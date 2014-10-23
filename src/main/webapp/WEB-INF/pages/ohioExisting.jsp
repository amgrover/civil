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
<link rel="stylesheet" href="/scripts/dist/themes/default/style.min.css" />
<script src="/scripts/dist/jstree.min.js"></script>
<script src="/scripts/tickpoint.js"></script>
<table style="width: 100%">
	<tr>
		<td align="left" width="75%"><h2>
				<b>Ohio - US. 23 - Hot Weather Test </b>
			</h2></td>
		<td align="right"><button onclick="goBack()">Go Back</button></td>
	</tr>
</table>

<div id="tabs">
	<ul>
		<li><a href="#tabs-1">Plot</a></li>
		<li><a href="#tabs-2">Data</a></li>
		<li><a href="#tabs-3">Reports and Documents</a></li>


	</ul>
	<div id="tabs-1">
		<table style="width: 100%">
			<tr>
				<td>Select Tire</td>
				<td><select id="tire"><option value="A">Wide Base-425</option>
						<option value="B">Dual-295</option>
						<option value="C">Wide Base-495</option>
						<option value="D">Dual-275</option></select></td>
				<td>Select Thickness (in)</td>
				<td><select id="thickness"><option value="4">4</option>
						<option value="8">8</option>
				</select></td>
				<td>Select Sensor</td>
				<td><select id="sensor">
				</select></td>
			</tr>
			<tr></tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td><input type="button" onclick="plot()"
					value="Plot"></td>
				
			</tr>
		</table>
		<div id="container"></div>
	</div>
	<div id="tabs-3">
		<h2>Files Available</h2>
		<ul class="glassList">
			<li><a target="_blank"
				href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Ohio\OhioTestRoadSPS8OriginalTraces\HotWeatherShearRunsCategorySummary.xls"
				style="text-decoration: underline; color: blue; padding-bottom: 10px;">Codes
					and Definition</a></li>
			<li><a target="_blank"
				href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Ohio\TirePressureData Eric Ohio\natc\TPIPPREPORT.doc"
				style="text-decoration: underline; color: blue;">Tire Pavement
					Interface Pressure Patterns Report</a></li>
			<li><a target="_blank"
				href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Ohio\OhioTestRoadSPS8OriginalTraces\Wide-BaseTire-TRB2011-XueWeaver-Final.pdf"
				style="text-decoration: underline; color: blue;">TRB 2011 Paper</a></li>

		</ul>
	</div>
	<div id="tabs-2">

		<div id="jstree">
			<!-- in this example the tree is populated from inline HTML -->
			<ul>
				<li>Strain Data
					<ul>
						<li><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Ohio\OhioTestRoadSPS8OriginalTraces\USPS8A4">USP87A4</a></li>
						<li><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Ohio\OhioTestRoadSPS8OriginalTraces\USPS8A8">USP87A8</a></li>
						<li><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Ohio\OhioTestRoadSPS8OriginalTraces\USPS8B4">USP87B4</a></li>
						<li><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Ohio\OhioTestRoadSPS8OriginalTraces\USPS8B8">USP87B8</a></li>
						<li><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Ohio\OhioTestRoadSPS8OriginalTraces\USPS8C4">USP87C4</a></li>
						<li><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Ohio\OhioTestRoadSPS8OriginalTraces\USPS8C8">USP87C8</a></li>
						<li><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Ohio\OhioTestRoadSPS8OriginalTraces\USPS8D4">USP87D4</a></li>
						<li><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Ohio\OhioTestRoadSPS8OriginalTraces\USPS8A8">USP87A8</a></li>
						<li><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Ohio\OhioTestRoadSPS8OriginalTraces\HotWeatherShearRunsCategorySummary.xls"
							style="text-decoration: underline; color: blue; padding-bottom: 10px;">Codes
								and Definition</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<div id="labTest">
			<ul>
				<li>Lab Tests
					<ul>
						<li><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Ohio\OU-ACC-Labtests\Creep Test">Creep
								Test</a></li>
						<li><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Ohio\OU-ACC-Labtests\Creep Test">Relaxation
								Test</a></li>
					</ul>
					<ul>
						<li>Triangular Pulse Test
							<ul>
								<li><a target="_blank"
									href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Ohio\OU-ACC-Labtests\Creep Test">Data
										Folder</a></li>
								<li><a target="_blank"
									href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Ohio\OU-ACC-Labtests\Creep Test">First
										Analysis</a></li>
								<li><a target="_blank"
									href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Ohio\OU-ACC-Labtests\Creep Test">Second
										Analysis</a></li>
							</ul>
						</li>
					</ul>

				</li>
			</ul>
		</div>
		<div id="tirePressure">
			<ul>
				<li>Tire Pressure Patterns
					<ul>
						<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Ohio\TirePressureData Eric Ohio\natc\Nev.-NATC\checklist.xls">Checklist</a></li>
						<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Ohio\TirePressureData Eric Ohio\natc\Nev.-NATC\PhaseIII\PotPhIIITM.doc">Phase
								3 Plan</a></li>
						<li><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Ohio\TirePressureData Eric Ohio\natc\Nev.-NATC\FWD_Sp99">FWD</a></li>

					</ul>
					<ul>
						<li>Pressure Pattern Data
							<ul>
								<li><a target="_blank"
									href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Ohio\TirePressureData Eric Ohio\natc\Nev.-NATC\TPIPP\MODULAS">Summary
										of Data-Modulas</a></li>
								<li><a target="_blank"
									href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Ohio\TirePressureData Eric Ohio\natc\Nev.-NATC\TPIPP\VRSPTA">Summary
										of Data-VRSTA</a></li>
								<li><a target="_blank"
									href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Ohio\TirePressureData Eric Ohio\natc\Nev.-NATC\TPIPP\VRSPTA">VRSTA</a></li>

							</ul>
							<ul>
								<li>Modulas
									<ul>
										<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
											href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Ohio\TirePressureData Eric Ohio\natc\Nev.-NATC\TPIPP\SUMMARY OF DATA IN FOLDER MODULAS.doc">File
												Name Description</a></li>
										<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
											href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Ohio\TirePressureData Eric Ohio\natc\Nev.-NATC\TPIPP\SUMMARY OF ZIPPED DATA IN FOLDER VRSPTA.doc">Data</a></li>


									</ul>
								</li>
							</ul>
						</li>
					</ul>

				</li>
			</ul>
		</div>




	</div>
	<p style="text-align: right; font-size: x-small;">
		<img alt="" src="http://jstree.com/tree.png"> Downloadable File
	</p>

</div>
<script>
	$(document).ajaxStop($.unblockUI);
	function plot() {
		var url = "/ohioExisting/sensor/" + $("#tire").val() + "/"
				+ $("#thickness").val() + "/" + $("#sensor").val() + "/";
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
						}
					},
					yAxis : {

						title : {
							text : "Value (ue)"
						}
					},
					series : [ {
						name : $("#sensor").val(),
						data : value
					} ]
				});
			}
		});

	}

	$(function() {
		getSensors();
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
		}
	});
	function goBack() {
		window.history.back()
	}
	function getSensors() {
		var url = "/ohioExisting/sensors/";
		$.ajax({
			url : url,
			type : "GET",
			success : function(smartphone) {
				$("#sensor" + "> option").remove();
				$.each(smartphone, function() {
					$("#sensor").append(new Option(this, this));
				});

			}
		});
	}
</script>