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
<h2>
	<b>UIUC Thin Pavement Section</b>
</h2>
<div id="tabs">
	<ul>
		<li><a href="#tabs-1">Data</a></li>
		<li><a href="#tabs-2">Reports and Documents</a></li>

	</ul>
	<div id="tabs-1">
		<h2>Files Available</h2>
		<input type="radio" id="r1" value="mixes" name="data" checked="true">Mixes<br>
		<input type="radio" id="r2" name="data" value="instrumentation">Instrumentation<br>
		<input type="radio" name="data" value="response">Response
		Testing Data <br> <input type="radio" name="data" value="traffic">Traffic
		Testing Data <br> <br>
		<div id="mix">
			<ul class="glassList">
				<li><a target="_blank"
					href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Tensar\Data\Mixes\Complex_Moduli_Summary2.xls"
					style="text-decoration: underline; color: blue; padding-bottom: 10px;">Mix
						Data</a></li>
				<li><a target="_blank"
					href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Tensar\Data\Mixes\HMA mix Test Report.doc"
					style="text-decoration: underline; color: blue;"> Test Report
						1(GMM and Graduation)</a></li>
				<li><a target="_blank"
					href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Tensar\Data\Mixes\TestReport2.doc"
					style="text-decoration: underline; color: blue;">Test Report
						2(Dynamic Modulus)</a></li>

			</ul>
		</div>
		<div id="traf" hidden="true">
			<div id="itraf">
				<!-- in this example the tree is populated from inline HTML -->
				<ul>
					<li>Responses
						<ul>
							<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
								href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Tensar\Data\Traffic dara\Normalized_Traffic data_A 2.xls">Cell
									A</a></li>
							<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
								href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Tensar\Data\Traffic dara\Normalized_Traffic data_BC 2.xls">Cell
									B/C</a></li>
							<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
								href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Tensar\Data\Traffic dara\Normalized_Traffic data_D 2.xls">Cell
									D</a></li>
						</ul>
					</li>
					<li>Performance (Rutting)

						<ul>

							<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
								href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Tensar\Data\Traffic dara\TENSAR_Rutting profile_A.xls">Cell
									A</a></li>
							<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
								href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Tensar\Data\Traffic dara\TENSAR_Rutting profile_B_C.xls">Cell
									B/C</a></li>
							<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
								href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Tensar\Data\Traffic dara\TENSAR_Rutting profile_D.xls">Cell
									D</a></li>


						</ul>
					</li>
					<li>Other
						<ul>
							<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
								href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Tensar\Data\Traffic dara\Rut measurement.doc">Rut
									Measurement(Doc) </a></li>



						</ul>
					</li>



				</ul>

			</div>
		</div>
		<div id="resp" hidden="true">
			<ul class="glassList">
				<li><a target="_blank"
					href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Tensar\Data\Response Testing Data\data analysis_Dual_D_WB.xls"
					style="text-decoration: underline; color: blue; padding-bottom: 10px;">Cell
						A</a></li>
				<li><a target="_blank"
					href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Tensar\Data\Response Testing Datadata analysis_Dual_B_C_WB"
					style="text-decoration: underline; color: blue;"> Cell B/C</a></li>
				<li><a target="_blank"
					href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Tensar\Data\Response Testing Data\data analysis_Dual_D_WB.xls"
					style="text-decoration: underline; color: blue;">Cell D</a></li>
				<li><a target="_blank"
					href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Tensar\Data\Response Testing Data\Summary data analysis1.xls"
					style="text-decoration: underline; color: blue; padding-bottom: 10px;">Summary
						of all cells</a></li>
				<li><a target="_blank"
					href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Tensar\Data\Response Testing Data\data.xlsx"
					style="text-decoration: underline; color: blue;"> Organized
						Data</a></li>

			</ul>
		</div>

		<div id="instrument" hidden="true">
			<div id="itree">
				<!-- in this example the tree is populated from inline HTML -->
				<ul>

					<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
						href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Tensar\Data\Instrumentation\Instrumentation_Tensar_with status_07_25.xls.pdf">Codes
							And Definitions</a></li>
					<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
						href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Tensar\Data\Instrumentation\instrument installation plan view_final_correction_1031.pdf">Installation
							Plan View</a></li>
					<li>Instrumentation
						<ul>
							<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
								href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Tensar\Data\Instrumentation\instrument installation.doc">Installation
									Details(Word)</a></li>

							<li>TDR Calibration
								<ul>
									<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
										href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Tensar\Data\Instrumentation\TDR REPORT.doc">Lab
											Calibration Report</a></li>
									<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
										href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Tensar\Data\Instrumentation\TDR Lab_Results.xls">Lab
											Calibration Results</a></li>
									<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
										href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Tensar\Data\Instrumentation\Comparison betweenProbes.xls">Comparison
											between Probes</a></li>
									<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
										href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Tensar\Data\Instrumentation\TDR_Summary.xls">Calibration
											Summary</a></li>

								</ul>
							</li>
							<li>Other
								<ul>
									<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
										href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Tensar\Data\Instrumentation\3400 Piezometer (REV E).doc">Geokon
											Peizometer Instruction Manual </a></li>
									<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
										href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Tensar\Data\Instrumentation\3400.pdf">Geokon
											Peizometer Specifications</a></li>
									<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
										href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Tensar\Data\InstrumentationGeokon Earth Pressure calibrations.xls">Geokon
											Earth Pressure Calibration</a></li>


								</ul>
							</li>



						</ul>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<div id="tabs-2">

		<div id="jstree">
			<!-- in this example the tree is populated from inline HTML -->
			<ul>
				<li>Reports
					<ul>
						<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\Profile Data\504RF-WideBase_LoadingHistory_06-20-2011.csv">Final
								Report</a></li>
						<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Tensar\Reports\Construction_report_June 6 2007.pdf">Construction
								Report</a></li>
						<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
							href="http://${address}\\Interface-Meeting\WB Data Folder\Docs\Tensar\Reports\PhD Thesis Tensar.pdf">Thesis</a></li>

					</ul>
				</li>
			</ul>
		</div>
		<div id="labTest">
			<ul>
				<li>Papers
					<ul>
						<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Tensar\Reports\TRB Paper Tensar.pdf">TRB
								Paper</a></li>
						<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Tensar\Reports\ASCE Paper Tensar.pdf">ASCE-Paper</a></li>

					</ul>

				</li>
			</ul>
		</div>
		<div id="tirePressure">
			<ul>
				<li>Others
					<ul>
						<li><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Tensar\Reports\B-section">Cell
								B/D Pictures</a></li>
						<li><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Tensar\Reports\Trenching">Trenching</a></li>
						<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Tensar\Reports\Dual tire pressure effect.ppt">Dual
								Tire Pressure Effect</a></li>



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
		$("#itree").jstree().bind("select_node.jstree", function(e, data) {
			var href = data.node.a_attr.href;
			document.location.href = href;

			//  $("#the_div").load(href); 
		});
		$("#itraf").jstree().bind("select_node.jstree", function(e, data) {
			var href = data.node.a_attr.href;
			document.location.href = href;

			//  $("#the_div").load(href); 
		});
		$('input[type=radio][name=data]').change(function() {
			if (this.value == 'mixes') {
				$("#instrument").hide();
				$("#mix").show();
				$("#resp").hide();
				$("#traf").hide();
			} else if (this.value == 'instrumentation') {
				$("#instrument").show();
				$("#mix").hide();
				$("#resp").hide();
				$("#traf").hide();
			} else if (this.value == 'response') {
				$("#instrument").hide();
				$("#mix").hide();
				$("#resp").show();
				$("#traf").hide();
			} else if (this.value == 'traffic') {
				$("#instrument").hide();
				$("#mix").hide();
				$("#resp").hide();
				$("#traf").show();
			}
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
</script>