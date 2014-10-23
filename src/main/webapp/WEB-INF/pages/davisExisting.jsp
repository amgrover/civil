<%@ include file="/common/taglibs.jsp"%>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
	
</script>
<script src="http://code.highcharts.com/highcharts.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />

<script src="http://code.highcharts.com/modules/exporting.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script type="text/javascript"
	src="https://github.com/douglascrockford/JSON-js/raw/master/json2.js"></script>
<script src="/scripts/jquery.blockUI.js"></script>
<link rel="stylesheet" href="/scripts/dist/themes/default/style.min.css" />
<script src="/scripts/dist/jstree.min.js"></script>
<table style="width: 100%">
	<tr>
		<td align="left" width="75%"><h2>
				<b>Rutting of Caltrans AC mixes and Contact Stresses Database</b>
			</h2></td>
		<td align="right"><button onclick="goBack()">Go Back</button></td>
	</tr>
</table>
<div id="tabs">
	<ul>
		<li><a href="#tabs-1">Data</a></li>
		<li><a href="#tabs-2">Reports and Document</a></li>

	</ul>
	<div id="tabs-2">
		<h2>Files Available</h2>
		<ul class="glassList">
			<li><a target="_blank"
				href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\Rutting of Caltrans AC.pdf"
				style="text-decoration: underline; color: blue; padding-bottom: 10px;">Rutting
					of Caltrans AC mix Report</a></li>
			<li><a target="_blank"
				href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\Contact Stresses of Pneum.pdf"
				style="text-decoration: underline; color: blue;">Contact
					Stresses Report</a></li>
			<li><a target="_blank"
				href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Phase I Report WBT 12-11-11F.pdf"
				style="text-decoration: underline; color: blue;">WBT Project
					Phase I Report</a></li>

		</ul>
	</div>
	<div id="tabs-1">

		<div id="jstree">
			<!-- in this example the tree is populated from inline HTML -->
			<ul>
				<li>Loading History
					<ul>
						<li  data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\Profile Data\504RF-WideBase_LoadingHistory_06-20-2011.csv">504RF*</a></li>
						<li  data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\Profile Data\505RF-LoadingHistory_06-17-2011.csv">505RF</a></li>
						<li  data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\Profile Data\506RF-LoadingHistory_06-20-2011.csv">506RF</a></li>
						<li  data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\Profile Data\507RF-LoadingHistory_06-20-2011.csv">507RF</a></li>
						<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\Profile Data\508RF-LoadingHistory_06-20-2011.csv">508RF</a></li>
						<li  data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\Profile Data\509RF-LoadingHistory_06-20-2011.csv">509RF</a></li>
						<li  data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\Profile Data\510RF-LoadingHistory_06-20-2011.csv">510RF</a></li>
						<li  data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\Profile Data\511RF-LoadingHistory_06-20-2011.csv">511RF</a></li>
						<li  data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank" 
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\Profile Data\512RF-LoadingHistory_06-20-2011.csv">512RF</a></li>
						<li  data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\Profile Data\513RF-LoadingHistory_06-20-2011.csv">513RF</a></li>

					</ul>
				</li>
			</ul>
		</div>
		<div id="labTest">
			<ul>
				<li>Profile Data
					<ul>
						<li  data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\Profile Data\504RF-WideBaseTire_ProfileData_06-20-2011.csv">504RF</a></li>
						<li  data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank" 
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\Profile Data\505RF-WideBaseTire_ProfileData_06-17-2011.csv">505RF</a></li>
						<li  data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank" 
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\Profile Data\506RF-WideBaseTire_ProfileData_06-20-2011.csv">506RF</a></li>
						<li  data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\Profile Data\507RF_ProfileData_06-20-2011.csv">507RF</a></li>
						<li  data-jstree='{"icon":"http://jstree.com/tree.png"}'> <a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\Profile Data\508RF_ProfileData_06-20-2011.csv">508RF</a></li>
						<li  data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\Profile Data\509RF_ProfileData_06-20-2011.csv">509RF</a></li>
						<li  data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\Profile Data\510RF_ProfileData_06-20-2011.csv">510RF</a></li>
						<li  data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\Profile Data\511RF_ProfileData_06-20-2011.csv">511RF</a></li>
						<li  data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\Profile Data\512RF_ProfileData_06-20-2011.csv">512RF</a></li>
						<li  data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\Profile Data\513RF_ProfileData_06-20-2011.csv">513RF</a></li>
					</ul>

				</li>
			</ul>
		</div>
		<div id="tirePressure">
			<ul>
				<li>3D Pneumatic Tire
					<ul>
						<li><a target="_blank" 
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\3D-PneumaticTireContactStresses\NATC4-5">NATC4-5**</a></li>
						<li><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\3D-PneumaticTireContactStresses\NATC6-8">NATC6-8</a></li>
						<li><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\3D-PneumaticTireContactStresses\NSUP5-9">NSUP5-9</a></li>
						<li><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\3D-PneumaticTireContactStresses\NSUP1000">NSUP1000</a></li>
						<li><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\3D-PneumaticTireContactStresses\UCBAIR">UCBAIR</a></li>
						<li><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\3D-PneumaticTireContactStresses\UCBB2-4">UCBB2-4</a></li>
						<li><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\3D-PneumaticTireContactStresses\UCBB5-6">UCBB5-6</a></li>
						<li><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\3D-PneumaticTireContactStresses\UCBB6-7">UCBB6-7</a></li>
						<li><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\3D-PneumaticTireContactStresses\UCBB8-9">UCBB8-9</a></li>
						<li><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\3D-PneumaticTireContactStresses\UCBR2-4">UCBR2-4</a></li>
						<li><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\3D-PneumaticTireContactStresses\UCBR5-6">UCBR5-6</a></li>
						<li><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\3D-PneumaticTireContactStresses\UCBR6-7">UCBR6-7</a></li>
						<li><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\3D-PneumaticTireContactStresses\UCBR8-9">UCBR8-9</a></li>
						<li><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\3D-PneumaticTireContactStresses\UCBS5-7">UCBS5-7</a></li>
						<li><a target="_blank"
							href="http://${address}\Interface-Meeting\WB Data Folder\Docs\UC Davis Data\3D-PneumaticTireContactStresses\UCBS9-1">UCBS9-1</a></li>


					</ul>


				</li>
			</ul>
		</div>




	</div>
	<p style="text-align: right; font-size: x-small;"> *For naming conventions see "Rutting" report in Reports and Document tab Table 1,page 9.<br/> **For naming conventions see "Contact Stresses"" Report<br/> <img alt="" src="http://jstree.com/tree.png"> Downloadable File</p>
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
</script>