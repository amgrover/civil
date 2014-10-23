<%@ include file="/common/taglibs.jsp"%>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">	
</script>
<script src="http://code.highcharts.com/highcharts.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />

<script src="/scripts/exporting.js"></script>
<script src="/scripts/jquery-ui.js"></script>
<script src="/scripts/jquery.blockUI.js"></script>
<link rel="stylesheet" href="/scripts/dist/themes/default/style.min.css" />
<script src="/scripts/dist/jstree.min.js"></script>
<script src="/scripts/tickpoint.js"></script>
<script src="/scripts/export-csv.js"></script>
<table style="width: 100%">
	<tr>
		<td align="left" width="75%"><h2>
				<b>Ohio - US. 23 - WBT New Database </b>
			</h2></td>
		<td align="right"><button onclick="goBack()">Go Back</button></td>
	</tr>
</table>



<div id="tabs">
	<ul>
		<li><a href="#tabs-1">Plot Filtered Data</a></li>
		<li><a href="#tabs-2">Download Summary Data</a></li>
		<li><a href="#tabs-3">Raw Data and Documents</a></li>
	</ul>
	<div id="tabs-1">
		<h2>Please Select Filters</h2>
		<table>

			<tr>
				<td>Select Section:</td>
				<td><form:select id="section" path="sections"
						items="${sections}" /></td>

				<td>Select Speed(mph):</td>
				<td><select id="speed"></select></td>
				<td>Select Sensor Type:</td>
				<td><select id="sensorType"></select>
			</tr>
			<tr>
				<td>Select Tire Type:</td>
				<td><select id="tire"></select></td>

				<td>Select Pressure(psi):</td>
				<td><select id="pressure"></select></td>
				<td>Select Sensor:</td>
				<td><select id="sensor"></select>
			</tr>
			<tr>
				<td>Select Load:</td>
				<td><select id="load"></select></td>
				<td id="rep">Select Repetition:</td>
				<td><select id="repetition"></select></td>
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
					<button id="plot">Plot</button>
				</td>
			</tr>



		</table>


		<div id="container"></div>

	</div>
	<div id="tabs-2">
		<h2>Please Select Filters</h2>
		<input type="radio" value="max" name="data" checked="checked">
		Max response for each repetition<br> <input type="radio"
			name="data" value="max_max"> Max response for all repetition
		<br> <input type="radio" name="data" value="max_avg"> Avg
		response for all repetition <br> <br>
		<div id="body">


			<table>

				<tr>
					<td>Select Section:</td>
					<td><form:select id="section2" path="sections"
							items="${sections}" /></td>

					<td>Select Speed(mph):</td>
					<td><select id="speed2"></select></td>

					<td>Select Sensor Type:</td>
					<td><select id="sensorType2"></select>
				</tr>
				<tr>
					<td>Select Tire Type:</td>
					<td><select id="tire2"></select></td>

					<td>Select Pressure(psi):</td>
					<td><select id="pressure2"></select></td>
					<td>Select Sensor:</td>
					<td><select id="sensor2" multiple="multiple"></select>
				</tr>
				<tr>
					<td>Select Load:</td>
					<td><select id="load2"></select></td>
					<td>Select Season:</td>
					<td><select id="season"></td>
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
		<li>Download for all cases for selected sensor values <input
			type="button" onclick="downloadAll()" value="Click Here">
		</li>
	</div>
	<div id="tabs-3">
		<div id="jstree">
			<!-- in this example the tree is populated from inline HTML -->
			<ul>
				<li>Ohio Data
					<ul>
						<li><a
							href="http://${address}\Interface-Meeting\WB Data Folder\Ohio\Organized\Test Data for Section 39BS803">Test
								Data for Section Mainline Section, Driving</a></li>
						<li><a
							href="http://${address}\Interface-Meeting\WB Data Folder\Ohio\Organized\Test Data for Section 39D168">Test
								Data for Section Mainline Section, Passing</a></li>
						<li><a
							href="http://${address}\Interface-Meeting\WB Data Folder\Ohio\Organized\Test Data for Section 39D168">Test
								Data for Section Ramp Section, South Bound</a></li>

					</ul>
				</li>
			</ul>
			<ul>
				<li>Naming Convention
					<ul>
						<li>Instrumentation Plan
							<ul>
								<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a
									href="http://${address}\Interface-Meeting\WB Data Folder\NamingConventions\39BS803-Ramp-Instrumentation.pdf">39BS803-Ramp-Instrumentation</a></li>
								<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a
									href="http://${address}\Interface-Meeting\WB Data Folder\NamingConventions\39D168-Mainline(Driving)-Instrumentation.pdf">39D168-Mainline(Driving)-Instrumentation</a></li>
								<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a
									href="http://${address}\Interface-Meeting\WB Data Folder\NamingConventions\39P168-Mainline(Passing)-Instrumentation.pdf">39P168-Mainline(Passing)-Instrumentation</a></li>

							</ul>
						</li>
					</ul>
					<ul>

						<li>Truck Load Configuration
							<ul>
								<li>Single Dual
									<ul>
										<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a
											href="http://${address}\Interface-Meeting\WB Data Folder\NamingConventions\SD 10kip-110psi (June20,2013).pdf">SD
												10kip-110psi</a></li>
										<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a
											href="http://${address}\Interface-Meeting\WB Data Folder\NamingConventions\SD 14kip-120psi (Summer 2013).pdf">SD
												14kip-120psi</a></li>


									</ul>
								</li>
								<li>Single Wide-Base
									<ul>
										<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a
											href="http://${address}\Interface-Meeting\WB Data Folder\NamingConventions\SW 10kip-110psi (June28,2013).pdf">SW
												10kip-110psi</a></li>
										<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a
											href="http://${address}\Interface-Meeting\WB Data Folder\NamingConventions\SW 14kip-100psi.pdf">SW
												14kip-100psi</a></li>
										<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a
											href="http://${address}\Interface-Meeting\WB Data Folder\NamingConventions\SW Empty-100psi.pdf">SW
												Empty-100psi</a></li>
									</ul>
								</li>
								<li>Tandem Dual
									<ul>
										<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a
											href="http://${address}\Interface-Meeting\WB Data Folder\NamingConventions\TD 10kip-100psi.pdf">TD
												10kip-100psi</a></li>
										<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a
											href="http://${address}\Interface-Meeting\WB Data Folder\NamingConventions\TD 10kip-110psi (June28,2013).pdf">TD
												10kip-110psi</a></li>
										<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a
											href="http://${address}\Interface-Meeting\WB Data Folder\NamingConventions\TD Empty-100psi.pdf">TD
												Empty-100psi</a></li>


									</ul>
								</li>
								<li>Tandem Wide-Base
									<ul>
										<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a
											href="http://${address}\Interface-Meeting\WB Data Folder\NamingConventions\TW 6kip-110psi (June20,2013).pdf">TW
												6kip-110psi</a></li>
										<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a
											href="http://${address}\Interface-Meeting\WB Data Folder\NamingConventions\TW 8kip-120psi (Summer 2013).pdf">TW
												8kip-120psi</a></li>


									</ul>
								</li>
							</ul>
						</li>
					</ul>
				</li>
			</ul>
		</div>
		<p style="text-align: right; font-size: x-small;">
			<img alt="" src="http://jstree.com/tree.png"> Downloadable File
		</p>
	</div>
</div>





<script type="text/javascript">
	var isPlot = true;
	var sensor;
	var section;
	var tire;
	var speed;
	var load;
	var pressure;
	var index = 0;
	var type = "max";
	var sensorType;
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
			getTireType();
			var url = "/charts/sensorType";
			getSensorType(url);
		}
	});
	$(function() {
		$("#jstree").jstree().bind("select_node.jstree", function(e, data) {
			var href = data.node.a_attr.href;
			document.location.href = href;

			//  $("#the_div").load(href); 
		});
		$("#labTest").jstree().bind("select_node.jstree", function(e, data) {
			var href = data.node.a_attr.href;
			document.location.href = href;

			//  $("#the_div").load(href); 
		});
		$("#tirePressure").jstree().bind("select_node.jstree",
				function(e, data) {
					var href = data.node.a_attr.href;
					document.location.href = href;

					//  $("#the_div").load(href); 
				});

	});

	$('#jstree').on("changed.jstree", function(e, data) {
		console.log(data.selected);
	});
	$('button').on('click', function() {
		$('#jstree').jstree(true).select_node('child_node_1');
		$('#jstree').jstree('select_node', 'child_node_1');
		$.jstree.reference('#jstree').select_node('child_node_1');

	});
	openNewWindow = function() {
		var url;
		var str = $(section).val();
		if (str.indexOf("South") != -1) {
			url = "http://${address}\\Interface-Meeting\\WB Data Folder\\NamingConventions\\39BS803-Ramp-Instrumentation.pdf";
		} else if (str.indexOf("Driving") != -1) {
			url = 'http://${address}\\Interface-Meeting\\WB Data Folder\\NamingConventions\\39D168-Mainline(Driving)-Instrumentation.pdf';
		} else {
			url = "http://${address}\\Interface-Meeting\\WB Data Folder\\NamingConventions\\39P168-Mainline(Passing)-Instrumentation.pdf";
		}
		window.open(url, "_blank");
	};

	function intialize(index) {
		if (index == 0) {
			sensor = "#" + "sensor";
			section = "#" + "section";
			tire = "#" + "tire";
			speed = "#" + "speed";
			load = "#" + "load";
			pressure = "#pressure";
			sensorType = "#sensorType";

		} else {
			sensor = "#" + "sensor" + (index + 1);
			section = "#" + "section" + (index + 1);
			tire = "#" + "tire" + (index + 1);
			speed = "#" + "speed" + (index + 1);
			load = "#" + "load" + (index + 1);
			pressure = "#pressure" + (index + 1);
			sensorType = "#sensorType" + (index + 1);
		}
	}
	$(function() {
		intialize(0);
		getTireType();
		var url = "../charts/sensorType";
		getSensorType(url);

	});
	$(document).ajaxStop($.unblockUI);
	function plot() {
		var time;
		var value;
		$
				.blockUI({
					message : '<h1>We are processing your request. Please be patient....</h1>'
				});
		var url = "/charts/" + $("#section").val() + "/" + $("#tire").val()
				+ "/" + $("#load").val() + "/" + $("#speed").val() + "/"
				+ $("#pressure").val() + "/" + $("#repetition").val() + "/"
				+ $("#sensor").val();
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {

				for ( var key in smartphone) {
					time = key;
					value = smartphone[key];
				}
				var k = tickPoint(10, eval(time).length);
				var v = $(sensorType).val();
				if (v.indexOf("Gauge") != -1) {
					v += "(micro strain)";
				} else if (v.indexOf("LV") != -1) {
					v += "(inch)";
				} else if (v.indexOf("Pressure") != -1) {
					v += "(psi)";
				}
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
							text : "Time(seconds)"
						},
						categories : eval(time),
						tickPositions : k
					},
					yAxis : {
						title : {
							text : v
						},
						gridLineWidth : 2
					},
					series : [ {
						name : $("#sensor").val(),
						data : value
					} ]

				});

			}

		});

	}

	function getSensors() {
		var url = "/charts/sensors/" + $(sensorType).val();
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				$(sensor + "> option").remove();
				$.each(smartphone, function() {
					$(sensor).append(new Option(this, this));
				});

			}
		});
	}
	function getSensorType(url) {

		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				$(sensorType + "> option").remove();
				$.each(smartphone, function() {
					$(sensorType).append(new Option(this, this));
				});
				getSensors();
			}
		});
	}

	function getTireType(tab) {
		var url = "/charts/" + $(section).val();
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				$(tire + "> option").remove();
				$.each(smartphone, function() {
					$(tire).append(new Option(this, this));
				});
				getLoad();
			}
		});
	}

	function getLoad() {
		var url = "/charts/" + $(section).val() + "/" + $(tire).val();
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				$(load + "> option").remove();
				$.each(smartphone, function() {
					$(load).append(new Option(this, this));
				});
				getSpeed();

			}
		});
	}

	function getSpeed() {
		var url = "/charts/" + $(section).val() + "/" + $(tire).val() + "/"
				+ $(load).val();
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				$(speed + " > option").remove();
				$.each(smartphone, function() {
					$(speed).append(new Option(this, this));
				});
				getPressure();

			}
		});
	}
	function getPressure() {
		var url = "/charts/pressure/" + $(section).val() + "/" + $(tire).val()
				+ "/" + $(load).val();
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				$(pressure + " > option").remove();
				$.each(smartphone, function() {
					$(pressure).append(new Option(this, this));
				});
				if (index == 0)
					getRepetition();
				else
					getSeason();

			}
		});
	}
	function getRepetition() {
		var url = "/charts/" + $(section).val() + "/" + $(tire).val() + "/"
				+ $(load).val() + "/" + $(speed).val() + "/"
				+ $(pressure).val();
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				$("#repetition > option").remove();
				$.each(smartphone, function() {
					$("#repetition").append(new Option(this, this));
				});

			}
		});
	}

	$("#section").change(function() {
		getTireType();

	});
	$("#tire").change(function() {

		getLoad();

	});
	$("#load").change(function() {

		getSpeed();
		getPressure();

	});
	$("#pressure").change(function() {

		getRepetition();

	});
	$("#sensorType").change(function() {

		getSensors();

	});

	$("#plot").click(function() {
		plot();
	});
	$("#download").click(function() {
		download();
	});
	$("input:radio").change(function() {
		type = $("input[name=data]:checked").val();
	});
	function download() {
		var i = 1;
		var result = "";
		var option = $(sensor).find('option:selected');
		$.each(option, function(index, val) {
			if (!(i == 1)) {
				result += ",";
			}
			result += val.text;
			i = i + 1;
		});
		var url = "/charts/summary/" + $(section).val() + "/" + $(tire).val()
				+ "/" + $(load).val() + "/" + $(speed).val() + "/"
				+ $(pressure).val() + "/" + $("#response").val() + "?"
				+ "sensors=" + result + "&type=" + type;
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
		var option = $(sensor).find('option:selected');
		$.each(option, function(index, val) {
			if (!(i == 1)) {
				result += ",";
			}
			result += val.text;
			i = i + 1;
		});
		var url = "/charts/sum/" + "?" + "sensors=" + result + "&type=" + type;
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

	function getSeason() {
		var url = "/charts/season/" + $(section).val() + "/" + $(tire).val()
				+ "/" + $(load).val() + "/" + $(speed).val() + "/"
				+ $(pressure).val();
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				$("#season > option").remove();
				$.each(smartphone, function() {
					$("#season").append(new Option(this, this));
				});

			}
		});
	}
	$("#section2").change(function() {
		getTireType();
	});
	$("#tire2").change(function() {

		getLoad();

	});
	$("#load2").change(function() {

		getSpeed();
		getPressure();

	});
	$("#pressure2").change(function() {

		getSeason();

	});
	$("#sensorType2").change(function() {

		getSensors();

	});
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
	function goBack() {
		window.history.back()
	}
</script>