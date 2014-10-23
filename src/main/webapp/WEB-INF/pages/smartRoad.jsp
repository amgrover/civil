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
				<b>Smart Road</b>
			</h2></td>
		<td align="right"><button onclick="goBack()">Go Back</button></td>
	</tr>
</table>

<div id="tabs">
	<ul>
		<li><a href="#tabs-1">Download Raw Data</a></li>


	</ul>
	<div id="tabs-1">
		<h2>Please Select Filters</h2>
		<table style="width: 100%">

			<tr>
				<td id="1">Select Load:</td>
				<td><select id="load"></select></td>
				<td id="5">Select Date:</td>
				<td><select id="date"></select></td>

			</tr>
			<tr>
				<td id="4">Select Speed(mph):</td>
				<td><select id="speed"></select></td>
				<td id="5">Select Section:</td>
				<td><select id="section"></select></td>

			</tr>
			<tr>
				<td id="7">Select Pressure(psi):</td>
				<td><select id="pressure"></select></td>
				<td id="6">Select Sensor:</td>
				<td><select id="sensors" multiple="multiple">
						<option value="resp_axle1">resp_axle1</option>
						<option value="resp_axle2">resp_axle2</option>
						<option value="resp_axle3">resp_axle3</option>
						<option value="resp_axle4">resp_axle4</option>
						<option value="resp_axle5">resp_axle5</option>
						<option value="resp_axle6">resp_axle6</option>


				</select>
			</tr>
			<tr />
			<tr>
				<td></td>
				<td />

				<td>
					<button id="download">Download</button>
				</td>
				<td><input type="button" onclick="openNewWindow()"
					value="Instrumentation Plan"></td>
			</tr>


		</table>



	</div>
	<li>For Loading Information <input type="button"
		onclick="openNew()" value="Click Here">
	</li>
</div>


<script>
	var sensor;
	var testId;
	var test;
	var load;
	var pressure;
	var index = 0;

	var speed;
	var date;
	var section;
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

		getLoad();

	});
	openNewWindow = function() {
		var url;
		var str = $(section).val();

		if (str.indexOf("A") != -1) {
			url = "http://${address}\\Interface-Meeting\\smartroad\\sections\\SecA.pdf";
		} else if (str.indexOf("B") != -1) {
			url = "http://${address}\\Interface-Meeting\\smartroad\\sections\\SecB.pdf";
		} else if (str.indexOf("C") != -1) {
			url = "http://${address}\\Interface-Meeting\\smartroad\\sections\\SecC.pdf";
		} else if (str.indexOf("D") != -1) {
			url = "http://${address}\\Interface-Meeting\\smartroad\\sections\\SecD.pdf";
		} else if (str.indexOf("E") != -1) {
			url = "http://${address}\\Interface-Meeting\\smartroad\\sections\\SecE.pdf";
		} else if (str.indexOf("F") != -1) {
			url = "http://${address}\\Interface-Meeting\\smartroad\\sections\\SecF.pdf";
		} else if (str.indexOf("G") != -1) {
			url = "http://${address}\\Interface-Meeting\\smartroad\\sections\\SecG.pdf";
		} else if (str.indexOf("H") != -1) {
			url = "http://${address}\\Interface-Meeting\\smartroad\\sections\\SecH.pdf";
		} else if (str.indexOf("I") != -1) {
			url = "http://${address}\\Interface-Meeting\\smartroad\\sections\\SecI.pdf";
		} else if (str.indexOf("J") != -1) {
			url = "http://${address}\\Interface-Meeting\\smartroad\\sections\\SecJ.pdf";
		} else if (str.indexOf("K") != -1) {
			url = "http://${address}\\Interface-Meeting\\smartroad\\sections\\SecK.pdf";
		} else if (str.indexOf("L") != -1) {
			url = "http://${address}\\Interface-Meeting\\smartroad\\sections\\SecL.pdf";
		}
		window.open(url, "_blank");
	};
	openNew = function() {
		var url = "http://${address}\\Interface-Meeting\\smartroad\\truck_load.xls";

		window.open(url, "_blank");
	};

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
			sensor = "#" + "sensors";
			testId = "#" + "testId";

			load = "#" + "load";
			pressure = "#pressure";
			speed = "#speed";
			date = "#date";
			section = "#section";

		} else {

		}
	}

	function getLoad() {
		var url = "/smartRoad/load";
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
		var url = "/smartRoad/speed/" + $(load).val();
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				$(speed + "> option").remove();
				$.each(smartphone, function() {

					$(speed).append(new Option(this, this));
				});
				//$(load).sort_select_box();
				getPressure();
			}
		});
	}
	function getPressure() {
		var url = "/smartRoad/pressure/" + $(load).val() + "/" + $(speed).val()
				+ "/";
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				$(pressure + "> option").remove();
				$.each(smartphone, function() {
					$(pressure).append(new Option(this, this));
				});
				getTestIds();
			}
		});
	}
	function getTestIds() {
		var url = "/smartRoad/testId/" + $(load).val() + "/" + $(speed).val()
				+ "/" + $(pressure).val() + "/";
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {

				$.each(smartphone, function() {
					test = this;
				});
				getDates();
			}
		});
	}
	function getDates() {
		var url = "/smartRoad/date/" + test + "/";
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				$(date + "> option").remove();
				$.each(smartphone, function() {
					var str = this.split(" ");
					var n = str[1] + " " + str[2] + " " + str[5];
					$(date).append(new Option(n, this));
				});
				getSections();
			}
		});
	}
	function getSections() {
		var url = "/smartRoad/section/" + $(date).val() + "/";
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				$(section + "> option").remove();
				$.each(smartphone, function() {
					$(section).append(new Option(this, this));
				});

			}
		});
	}

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
		var url = "/smartRoad/download/" + $(section).val() + "/"
				+ $(date).val() + "/" + test + "/" + $(load).val() + "/"
				+ $(pressure).val() + "/" + $(speed).val() + "?sensors="
				+ result;
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
	$("#testId").change(function() {
		getDates();
	});
	$("#load").change(function() {
		getSpeed();
	})
	$("#pressure").change(function() {
		getTestIds();
	})

	$("#download").click(function() {
		download();
	});
	$("#date").change(function() {
		getSections();
	});
	function goBack() {
		window.history.back()
	}
</script>