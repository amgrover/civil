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
<style>
a:link {
	text-decoration: none;
} /* unvisited link */
a:visited {
	text-decoration: none;
} /* visited link */
a:hover {
	text-decoration: underline;
} /* mouse over link */
a:active {
	text-decoration: underline;
} /* selected link */
</style>
<table style="width: 100%">
	<tr>
		<td align="left" width="75%"><h2>
				<b>WBT Project - Thin/Thick Sections</b>
			</h2></td>
		<td align="right"><button onclick="goBack()">Go Back</button></td>
	</tr>
</table>

<div id="tabs">
	<ul>
		<li><a href="#tabs-1">Download Raw Data</a></li>
		<li><a href="#tabs-2">Download Summary Data</a></li>

	</ul>
	<div id="tabs-1">
		<h2>Please Select Filters</h2>
		<table>

			<tr>
				<td id="1">Select Sensor Type:</td>
				<td><select id="sensorType"></select></td>
				<td id="dateLabel" hidden="true">Select Date</td>
				<td id="dateVal" hidden="true"><select id="date" hidden="true"></select></td>
				<td id="2">Select Load(KN):</td>
				<td><select id="load"></select></td>

				<td id="3">Select Repetitions:</td>
				<td><select id="repetition"></select>
			</tr>
			<tr>
				<td id="4">Select Test Id:</td>
				<td><select id="testId"></select></td>

				<td id="5">Select Wheel Type:</td>
				<td><select id="wheelType"></select></td>
				<td id="6">Select Trafficking:</td>
				<td><select id="trafficking"></select>
			</tr>
			<tr>
				<td id="7">Select Pressure(KPa):</td>
				<td><select id="pressure"></select></td>
				<td></td>
				<td></td>
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
					<button id="download">Download</button>
				</td>
			</tr>


		</table>


	</div>
	<div id="tabs-2">
		<h2>Please Select Filters</h2>
		<table>

			<tr>
				<td>Select Sensor Type:</td>
				<td><select id="sensorType2"></select></td>

				<td>Select Load(kip):</td>
				<td><select id="load2"></select></td>
				<td>Select Number of wheels:</td>
				<td><select id="num2"></select></td>


			</tr>
			<tr>
				<td>Select Sensor Name:</td>
				<td><select id="name2"></select></td>

				<td>Select Pressure(psi):</td>
				<td><select id="pressure2"></select></td>
				<td>Select Wheel offset:</td>
				<td><select id="offset2"></select>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>
				<td><input type="button" onclick="openNewWindow()"
					value="Instrumentation Plan"></td>
				</td>

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

</div>


<script>
	var sensor;
	var testId;
	var wheelType;
	var trafficking;
	var load;
	var pressure;
	var index = 0;
	var type = "max";
	var sensorType;
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
			var url = "/charts/sensorType";
			getSensorTypes();

		}
	});
	$(function() {
		intialize(0);

		getSensorTypes();

	});

	$.fn.sort_select_box = function() {
		// Get options from select box
		var my_options = $("#" + this.attr('id') + ' option');
		// sort alphabetically
		my_options.sort(function(a, b) {
			if (a.text > b.text)
				return 1;
			else if (a.text < b.text)
				return -1;
			else
				return 0
		})
		//replace with sorted my_options;
		$(this).empty().append(my_options);

		// clearing any selections
		$("#" + this.attr('id') + " option").attr('selected', false);
	}
	function intialize(index) {
		if (index == 0) {
			sensor = "#" + "sensor";
			testId = "#" + "testId";
			wheelType = "#" + "wheelType";
			trafficking = "#" + "trafficking";
			load = "#" + "load";
			pressure = "#pressure";
			sensorType = "#sensorType";
			repetition = "#repetition";

		} else {
			sensor = "#" + "sensor" + (index + 1);
			testId = "#" + "testId" + (index + 1);
			tire = "#" + "tire" + (index + 1);
			speed = "#" + "speed" + (index + 1);
			load = "#" + "load" + (index + 1);
			pressure = "#pressure" + (index + 1);
			sensorType = "#sensorType" + (index + 1);
			repetition = "#repetition" + (index + 1);
		}
	}

	function getSensorTypes() {
		var url = "/davis/sensorTypes";
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				$(sensorType + "> option").remove();
				$.each(smartphone, function() {
					$(sensorType).append(new Option(this, this));
				});
				if (sensorType == "#sensorType2") {
					$("#sensorType2 option[value='TEMP']").remove();
					$("#sensorType2 option[value='RSD']").remove();
					getSensorName();
				} else if ($(sensorType).val() == "TEMP") {
					unhideTemp();
					getTempDate();
				} else
					getTestIds();

			}
		});
	}
	openNewWindow = function() {
		var url = "http://${address}\\Interface-Meeting\\WB Data Folder\\NamingConventions\\Prop Sec UC-Davis 10-04-12.docx";

		window.open(url, "_blank");
	};
	function unhideTemp() {
		$("#dateLabel").show();
		$("#dateVal").show();
		$("#date").show();
		$(sensor).hide();
		$(testId).hide();
		$(wheelType).hide();
		$(trafficking).hide();
		$(load).hide();
		$(pressure).hide();

		$(repetition).hide();

		$("#2").hide();
		$("#3").hide();
		$("#4").hide();
		$("#5").hide();
		$("#6").hide();
		$("#7").hide();
	}
	function hideTemp() {
		$("#dateLabel").hide();
		$("#dateVal").hide();
		$("#date").hide();
		$(sensor).show();
		$(testId).show();
		$(wheelType).show();
		$(trafficking).show();
		$(load).show();
		$(pressure).show();

		$(repetition).show();

		$("#2").show();
		$("#3").show();
		$("#4").show();
		$("#5").show();
		$("#6").show();
		$("#7").show();
	}
	function getTempDate() {
		var url = "/davis/date";
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				unhideTemp();
				$("#date  > option").remove();
				$.each(smartphone, function() {
					$("#date").append(new Option(this, this));
				});
			}
		});
	}
	function getTestIds() {
		var url = "/davis/testIds";
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				$(testId + "> option").remove();
				$.each(smartphone, function() {
					$(testId).append(new Option(this, this));
				});
				getTirePressure();
			}
		});
	}
	function getTirePressure() {
		var url = "/davis/pressure/" + $(testId).val() + "/"
				+ $(sensorType).val();
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				$(pressure + "> option").remove();
				$.each(smartphone, function() {
					$(pressure).append(new Option(this, this));
				});
				//$(pressure).sort_select_box();
				getLoad();
			}
		});
	}
	function getLoad() {
		var url = "/davis/load/" + $(testId).val() + "/" + $(sensorType).val();
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				$(load + "> option").remove();
				$.each(smartphone, function() {
					$(load).append(new Option(this, this));
				});
				//$(load).sort_select_box();
				getWheelType();
			}
		});
	}
	function getWheelType() {
		var url = "/davis/wheelType/" + $(testId).val() + "/"
				+ $(sensorType).val() + "/" + $(pressure).val() + "/"
				+ $(load).val() + "/";
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				$(wheelType + "> option").remove();
				$.each(smartphone, function() {
					$(wheelType).append(new Option(this, this));
				});
				//$(wheelType).sort_select_box();
				getTrafficking();
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
				//$(trafficking).sort_select_box();
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
				//$('select').each(function( index ) {
				//  $(this).sort_select_box();
				//});
				//$(repetition).;

			}
		});
	}
	function download() {
		var url = "/davis/download/" + $(testId).val() + "/"
				+ $(sensorType).val() + "/" + $(pressure).val() + "/"
				+ $(load).val() + "/" + $(wheelType).val() + "/"
				+ $(trafficking).val() + "/" + $(repetition).val() + "/"
				+ $("#date").val() + "/";
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				var a = document.createElement('a');
				a.href = 'data:attachment/csv,' + escape(smartphone);
				a.target = '_blank';
				a.download = 'myFile.csv';

				document.body.appendChild(a);
				a.click();

			}
		});
	}
	function downloadAll() {
		var url;
		var str = $(sensorType).val();

		if (str.indexOf("MDD") != -1) {
			url = "http://${address}\\Interface-Meeting\\DavisSummary\\FilteredMDDSummary.xls";
		} else if (str.indexOf("PRESSURE") != -1) {
			url = "http://${address}\\Interface-Meeting\\DavisSummary\\Pressure Data Summary.xls";
		} else if (str.indexOf("STRAIN") != -1) {
			url = "http://${address}\\Interface-Meeting\\DavisSummary\\Strain Data Summary.xls";
		}
		window.open(url, "_blank");
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
				//$("#name2").sort_select_box();
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
				//$("#pressure2").sort_select_box();
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
				//$("#load2").sort_select_box();
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
					var s;
					if (this == 1) {
						s = "Wide Base";
					} else if (this == 2) {
						s = "Dual Base"
					}
					$("#num2").append(new Option(s, this));
				});
				//$("#num2").sort_select_box();
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
				//$('select').each(function( index ) {
				//  $(this).sort_select_box();
				//});
				//$("#offset2").sort_select_box();

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
	$("#sensorType").change(function() {
		if ($("#sensorType").val() == "TEMP") {
			getTempDate();
		}
		hideTemp();
		getTestIds();
	});
	$("#testId").change(function() {
		getTirePressure();
	});
	$("#load").change(function() {
		getWheelType();
	})
	$("#pressure").change(function() {
		getLoad();
	})
	$("#trafficking").change(function() {
		getCycles();
	})
	$("#wheelType").change(function() {
		getTrafficking();
	})
	$("#download").click(function() {
		download();
	});
	$("#num2").change(function() {
		getOffset();
	});
	$("#load2").change(function() {
		getNum();
	});
	$("#pressure2").change(function() {
		getLoadSummary();
	});
	$("#name2").change(function() {
		getPressureSummary();
	});
	$("#sensorType2").change(function() {
		getSensorName();

	});
	$("#download2").click(function() {
		downloadSummary();
	});
	function goBack() {
		window.history.back()
	}
</script>