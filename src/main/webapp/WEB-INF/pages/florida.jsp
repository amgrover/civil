<%@ include file="/common/taglibs.jsp"%>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
	
</script>
<script src="http://code.highcharts.com/highcharts.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />

<script src="http://code.highcharts.com/modules/exporting.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<script src="/scripts/jquery.blockUI.js"></script>
<script src="/scripts/tickpoint.js"></script>
<table style="width: 100%">
	<tr>
		<td align="left" width="75%"><h2>
				<b>Florida Test Pit and Test Track Database</b>
			</h2></td>
		<td align="right"><button onclick="goBack()">Go Back</button></td>
	</tr>
</table>

<div id="tabs">
	<ul>
		<li><a href="#tabs-1">Filtered Data</a></li>
		<li><a href="#tabs-2">Summary Data</a></li>

	</ul>
	<div id="tabs-1">
		<h2>Please Select Filters</h2>
		<table>

			<tr>
				<td>Select Section:</td>
				<td><select id="track"><option value="Test Track">Test
							Track</option>
						<option value="Test Pit">Test Pit</option></select></td>

				</select>
				</td>

				<td>Select Temperature(C):</td>
				<td><select id="temp"></select></td>
				<td>Select Repetitions:</td>
				<td><select id="repetition"></select>
			</tr>
			<tr>
				<td>Select Sensor Type:</td>
				<td><select id="sensor"><option value="SP">Surface
							Strain Gauge(SP)</option>
						<option value="EG">Embedded Strain Gauge(EG)</option>
						<option value="PC">Pressure Cell</option></select>
				<td>Select Load(kip):</td>
				<td><select id="code"></select></td>
				<td>Select Sensor:</td>
				<td><select id="sensorValues"></select></td>
			</tr>
			<tr>
				<td>Select TireType:</td>
				<td><select id="tireType"></select></td>
				<td>Select Pressure(psi):</td>
				<td><select id="pressure"></select></td>
				<td></td>
				<td><input type="button" onclick="openNewWindow()"
					value="Instrumentation Plan"></td>



			</tr>
			<tr />
			<tr>
				<td></td>
				<td />
				<td />

				<td>
					<button id="download">Plot</button>
				</td>
			</tr>


		</table>

		<div id="container"></div>

	</div>
	<div id="tabs-2">

		<h2>Please Select Filters</h2>
		<input type="radio" value="MaxResponses_" name="data"
			checked="checked"> Max response for each repetition<br>
		<input type="radio" name="data" value="MaxResponses_allrep_">
		Max response for all repetition <br> <input type="radio"
			name="data" value="AvgResponses_allrep_"> Avg response for
		all repetition <br> <input type="radio" name="data"
			value="AvgResponses_"> Avg response for each repetition <br>
		<br>
		<table>

			<tr>
				<td>Select Section:</td>
				<td><select id="track2"><option value="Test Track">Test
							Track</option>
						<option value="Test Pit">Test Pit</option></select></td>


				<td>Select Temperature(C):</td>
				<td><select id="temp2"></select></td>
				<td>Select Sensor:</td>
				<td><select id="sensorValues2" multiple="multiple"></select></td>

			</tr>
			<tr>
				<td>Select Sensor Type:</td>
				<td><select id="sensor2"><option value="SP">Surface
							Strain Gauge(SP)</option>
						<option value="EG">Embedded Strain Gauge(EG)</option>
						<option value="PC">Pressure Cell</option></select></td>

				<td>Select Load(kip):</td>
				<td><select id="code2"></select></td>

			</tr>
			<tr>
				<td>Select TireType:</td>
				<td><select id="tireType2"></select></td>
				<td>Select Pressure(psi):</td>
				<td><select id="pressure2"></select></td>
				<td></td>
				<td><input type="button" onclick="openNewWindow()"
					value="Instrumentation Plan"></td>


			</tr>
			<tr />
			<tr>
				<td></td>
				<td />
				<td />

				<td>
					<button id="download2">Download</button>
				</td>
			</tr>


		</table>
		<li>Download for all cases for selected sensor type <input
			type="button" onclick="downloadAll()" value="Click Here">
		</li>
	</div>
	<div id="tabs-3"></div>
</div>
<script>
	var sensor;
	var track;
	var type = "MaxResponses_";
	var code;
	var temp;
	var pressure;
	var index = 0;
	var sensorValues;
	var tireType;
	var repetition;
	$(function() {
		var tabs = $("#tabs").tabs();
		tabs.find(".ui-tabs-nav").sortable({
			axis : "x",
			stop : function() {
				tabs.tabs("refresh");
			}
		});
	});
	$("#tabs").tabs({
		activate : function(event, ui) {
			index = $("#tabs").tabs('option', 'active');
			intialize(index);
			getSensorValues();
			getTireType();
		}
	});
	$(function() {
		intialize(0);
		getSensorValues();
		getTireType();

	});
	openNewWindow = function() {
		var url = "http://${address}\\Interface-Meeting\\WB Data Folder\\NamingConventions\\FHWA Tire Study _FDOT Report 9.25.13.docx";

		window.open(url, "_blank");
	};

	function getSensorValues() {
		var url = "/florida/sensors/";
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				$(sensorValues + "> option").remove();
				$.each(smartphone, function() {
					var s = this;
					var b = $(sensor).val();
					if (b == "PC" && s.startsWith("PG")) {
						$(sensorValues).append(new Option(this, this));
					} else if (b == "SP" && !s.startsWith("EG")
							&& !s.startsWith("PG"))
						$(sensorValues).append(new Option(this, this));
					else if (b == "EG" && s.startsWith("EG"))
						$(sensorValues).append(new Option(this, this));
				});
				getTemp()

			}
		});
	}
	if (typeof String.prototype.startsWith != 'function') {
		// see below for better implementation!
		String.prototype.startsWith = function(str) {
			return this.indexOf(str) == 0;
		};
	}

	function intialize(index) {
		if (index == 0) {
			sensor = "#" + "sensor";
			track = "#" + "track";
			code = "#" + "code";

			temp = "#" + "temp";
			pressure = "#pressure";
			tireType = "#tireType";
			repetition = "#repetition";
			sensorValues = "#sensorValues";

		} else {
			sensor = "#" + "sensor" + (index + 1);
			track = "#" + "track" + (index + 1);
			code = "#" + "code" + (index + 1);

			temp = "#" + "temp" + (index + 1);
			pressure = "#pressure" + (index + 1);
			tireType = "#tireType" + (index + 1);
			repetition = "#repetition+ (index + 1)";
			sensorValues = "#sensorValues" + (index + 1);

		}
	}

	function getTireType() {
		var url = "/florida/tire/" + $(track).val() + "/" + $(sensor).val()
				+ "/";
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				$(tireType + "> option").remove();
				$.each(smartphone, function() {
					$(tireType).append(new Option(this, this));
				});
				getTemp()

			}
		});
	}
	function getTemp() {
		var url = "/florida/load/" + $(track).val() + "/" + $(sensor).val()
				+ "/" + $(tireType).val() + "/";
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				$(temp + "> option").remove();
				$.each(smartphone, function() {
					$(temp).append(new Option(this, this));
				});
				getTirePressure();
			}
		});
	}
	function getTirePressure() {
		var url = "/florida/pressure/" + $(track).val() + "/" + $(sensor).val()
				+ "/" + $(tireType).val() + "/" + $(temp).val() + "/";
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				$(pressure + "> option").remove();
				$.each(smartphone, function() {
					$(pressure).append(new Option(this, this));
				});
				getCode();
			}
		});
	}
	function getCode() {
		var url = "/florida/cycle/" + $(track).val() + "/" + $(sensor).val()
				+ "/" + $(tireType).val() + "/" + $(temp).val() + "/"
				+ $(pressure).val() + "/";
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				$(code + "> option").remove();
				$.each(smartphone, function() {
					$(code).append(new Option(this, this));
				});
				getRepetition();
			}
		});
	}
	function getRepetition() {
		var url = "/florida/repetition/" + $(track).val() + "/"
				+ $(sensor).val() + "/" + $(tireType).val() + "/"
				+ $(temp).val() + "/" + $(pressure).val() + "/" + $(code).val()
				+ "/";
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				$(repetition + "> option").remove();
				$.each(smartphone, function() {
					$(repetition).append(new Option(this, this));
				});

			}
		});
	}
	function getSummaryRepetition() {
		var url = "/florida/summary/repetition/" + $(track).val() + "/"
				+ $(sensor).val() + "/" + $(tireType).val() + "/"
				+ $(temp).val() + "/" + $(pressure).val() + "/" + $(code).val()
				+ "/" + $();
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				$(repetition + "> option").remove();
				$.each(smartphone, function() {
					$(repetition).append(new Option(this, this));
				});

			}
		});
	}
	function getTrafficking() {
		var url = "/davis/trafficking/" + $(testId).val() + "/"
				+ $(sensorType).val() + "/" + $(pressure).val() + "/"
				+ $(load).val() + "/";
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				$(trafficking + "> option").remove();
				$.each(smartphone, function() {
					$(trafficking).append(new Option(this, this));
				});
				getCycles();
			}
		});
	}
	function getCycles() {
		var url = "/davis/cycles/" + $(testId).val() + "/"
				+ $(sensorType).val() + "/" + $(pressure).val() + "/"
				+ $(load).val() + "/" + $(wheelType).val() + "/"
				+ $(trafficking).val() + "/";
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				$(repetition + "> option").remove();
				$.each(smartphone, function() {
					$(repetition).append(new Option(this, this));
				});

			}
		});
	}

	function getSensorName() {
		var url = "/davis" + "/sensorNames/" + $(sensorType).val();
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				$("#name2" + "> option").remove();
				$.each(smartphone, function() {
					$("#name2").append(new Option(this, this));
				});
				getPressureSummary();

			}
		});
	}
	function getPressureSummary() {
		var url = "/davis" + "/pressureSummary/" + $(sensorType).val() + "/"
				+ $("#name2").val();
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				$("#pressure2" + "> option").remove();
				$.each(smartphone, function() {
					$("#pressure2").append(new Option(this, this));
				});
				getLoadSummary();

			}
		});
	}
	function getLoadSummary() {
		var url = "/davis" + "/loadSummary/" + $(sensorType).val() + "/"
				+ $("#name2").val() + "/" + $("#pressure2").val() + "/";
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				$("#load2" + "> option").remove();
				$.each(smartphone, function() {
					$("#load2").append(new Option(this, this));
				});
				getNum();

			}
		});
	}
	function getNum() {
		var url = "/davis" + "/numOfWheelsSummary/" + $(sensorType).val() + "/"
				+ $("#name2").val() + "/" + $("#pressure2").val() + "/"
				+ $("#load2").val() + "/";
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				$("#num2" + "> option").remove();
				$.each(smartphone, function() {
					$("#num2").append(new Option(this, this));
				});
				getOffset();

			}
		});
	}
	function getOffset() {
		var url = "/davis" + "/offset/" + $(sensorType).val() + "/"
				+ $("#name2").val() + "/" + $("#pressure2").val() + "/"
				+ $("#load2").val() + "/" + $("#num2").val() + "/";
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				$("#offset2" + "> option").remove();
				$.each(smartphone, function() {
					$("#offset2").append(new Option(this, this));
				});

			}
		});
	}
	function downloadSummary() {
		var url = "/davis" + "/summary/" + $(sensorType).val() + "/"
				+ $("#name2").val() + "/" + $("#pressure2").val() + "/"
				+ $("#load2").val() + "/" + $("#num2").val() + "/"
				+ $("#offset2").val() + "/";
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				var csv = ConvertToCSV(smartphone);
				var a = document.createElement('a');
				a.href = 'data:attachment/csv,' + escape(csv);
				a.target = '_blank';
				a.download = 'myFile.csv';

				document.body.appendChild(a);
				a.click();

			}
		});
	}
	function ConvertToCSV(objArray) {
		var array = typeof objArray != 'object' ? JSON.parse(objArray)
				: objArray;
		var str = '';
		for ( var i = 0; i < 1; i++) {
			var line = '';
			for ( var index in array[i]) {
				if (line != '')
					line += ','

				line += index;
			}

			str += line + '\r\n';
		}
		for ( var i = 0; i < array.length; i++) {
			var line = '';
			for ( var index in array[i]) {
				if (line != '')
					line += ','

				line += array[i][index];
			}

			str += line + '\r\n';
		}

		return str;
	}

	$(document).ajaxStop($.unblockUI);
	function plot() {
		var url = "/florida/sensor/" + $(track).val() + "/" + $(tireType).val()
				+ "/" + $(temp).val() + "/" + $(pressure).val() + "/"
				+ $(code).val() + "/" + $(repetition).val() + "/"
				+ $(sensor).val() + "/" + $(sensorValues).val() + "/";
		var time;
		var value;
		$
				.blockUI({
					message : '<h1>We are processing your request. Please be patient....</h1>'
				});

		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {

				for ( var key in smartphone) {
					time = key;
					value = smartphone[key];
				}
				var v = $(sensorValues).val();
				if (v.indexOf("SL") != -1) {
					v += "(micro strain)";
				}
				var k = tickPoint(10, eval(time).length);
				$('#container').highcharts({
					chart : {
						borderWidth : 1,
						zoomType : 'x'
					},
					title : {
						text : 'Sensor Reading'
					},
					plotOptions : {
						series : {
							marker : {
								enabled : false
							}
						}
					},
					xAxis : {
						gridLineWidth : 1,
						title : {
							text : "seconds"
						},
						categories : eval(time),
						tickPositions : k
					},
					yAxis : {

						title : {
							text : v
						}
					},
					series : [ {
						name : $("#sensorValues").val(),
						data : value
					} ]
				});
			}
		});

	}
	function download() {
		var i = 1;
		var result = "";
		var option = $(sensorValues).find('option:selected');
		$.each(option, function(index, val) {
			if (!(i == 1)) {
				result += ",";
			}
			result += val.text;
			i = i + 1;
		});
		var url = "florida/summary/data/" + $(track).val() + "/"
				+ $(sensor).val() + "/" + $(tireType).val() + "/"
				+ $(code).val() + "/" + $(pressure).val() + "/" + type + "/"
				+ $(temp).val() + "/" + "?" + "sensors=" + result;
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				var csv = ConvertToCSV(smartphone);

				var a = document.createElement('a');
				a.href = 'data:attachment/csv,' + escape(csv);
				a.target = '_blank';
				a.download = 'myFile.csv';

				document.body.appendChild(a);
				a.click();

			}
		});
	}
	function downloadAll() {
		var i = 1;
		var result = "";
		var option = $(sensorValues).find('option:selected');
		$.each(option, function(index, val) {
			if (!(i == 1)) {
				result += ",";
			}
			result += val.text;
			i = i + 1;
		});
		var url = "florida/sum/data/" + $(sensor).val() + "/" + type + "?"
				+ "sensors=" + result;
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				var csv = ConvertToCSV(smartphone);

				var a = document.createElement('a');
				a.href = 'data:attachment/csv,' + escape(csv);
				a.target = '_blank';
				a.download = 'myFile.csv';

				document.body.appendChild(a);
				a.click();

			}
		});
	}
	$("#sensor").change(function() {
		getTireType();
		getSensorValues();
	});
	$("#track").change(function() {
		getTireType();
	});
	$("#tireType").change(function() {
		getTemp();
	})
	$("#pressure").change(function() {
		getCode();
	})
	$("#code").change(function() {
		getRepetition();
	})

	$("#download").click(function() {
		plot();
	});
	$("#sensor2").change(function() {
		getTireType();
		getSensorValues();
	});
	$("#track2").change(function() {
		getTireType();
	});
	$("#tireType2").change(function() {
		getTemp();
	})
	$("#pressure2").change(function() {
		getCode();
	})
	$("#code2").change(function() {
		getRepetition();
	})
	$("#download2").click(function() {
		download();
	});
	$("input:radio").change(function() {
		type = $("input[name=data]:checked").val();
	});
	function goBack() {
		window.history.back()
	}
</script>