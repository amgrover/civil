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
<table style="width: 100%">
	<tr>
		<td align="left" width="75%"><h2>
				<b>Surface Strain Database</b>
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
				href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Florida\Tire Study Test Sections.ppt"
				style="text-decoration: underline; color: blue; padding-bottom: 10px;">Test
					Section Configuration</a></li>
			<li><a target="_blank"
				href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Florida\Tire Study Strain Summary.ppt"
				style="text-decoration: underline; color: blue;">Summary of Data
					Across Sections</a></li>
			<li><a target="_blank"
				href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Florida\2010 Impact of Wide-Base Single Tires.pdf"
				style="text-decoration: underline; color: blue;">Read the Paper</a></li>

		</ul>
	</div>
	<div id="tabs-1">

		<div id="jstree">
			<!-- in this example the tree is populated from inline HTML -->
			<ul>
				<li><a target="_blank"
					href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Florida\Tire Study Strain Data.xlsx">Strain
						Data Summary</a></li>


			</ul>
		</div>
		<div id="labTest">
			<ul>
				<li>Rutting Profile Data

					<ul>
						<li>Dual Profile
							<ul>
								<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
									href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Florida\Goodyear Duals\Dual Profiles.xlsx">
										Profiles</a></li>
								<li><a target="_blank"
									href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Florida\Goodyear Duals\Dense Grade\08jn5a\Profile Files">08-JN-5A*</a></li>
								<li><a target="_blank"
									href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Florida\Goodyear Duals\Dense Grade\08JN7AR\Profile Files">08-JN-7AR</a></li>
								<li><a target="_blank"
									href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Florida\Goodyear Duals\Dense Grade\08ma6bl\Profile Files">08-MA-6BL</a></li>
								<li><a target="_blank"
									href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Florida\Goodyear Duals\Dense Grade\08ma6cl\Profile Files">08-MA-6CL</a></li>
							</ul>
						</li>
					</ul>
					<ul>
						<li>Super Singles
							<ul>
								<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
									href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Florida\Goodyear Single\Single Profiles.xlsx">
										Profiles</a></li>
								<li><a target="_blank"
									href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Florida\Goodyear Single\Dense Grade\08AP5CR\Profile Files">08-AP-5CR*</a></li>
								<li><a target="_blank"
									href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Florida\Goodyear Single\Dense Grade\08AP7BL\Profile Files">08-AP-7BL</a></li>
								<li><a target="_blank"
									href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Florida\Goodyear Single\Dense Grade\08AP7CR\Profile Files">08-AP-7CR</a></li>

							</ul>
						</li>
					</ul>
					<ul>
						<li>WB 445
							<ul>
								<li data-jstree='{"icon":"http://jstree.com/tree.png"}'><a target="_blank"
									href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Florida\Michelin 445 Super Wide\445 Profiles.xlsx">
										Profiles</a></li>
								<li><a target="_blank"
									href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Florida\Michelin 445 Super Wide\Dense Grade\08AP5CL\Profile Files">08-AP-5CL*</a></li>
								<li><a target="_blank"
									href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Florida\Michelin 445 Super Wide\Dense Grade\08AP7CL\Profile Files">08-AP-7CL</a></li>
								<li><a target="_blank"
									href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Florida\Michelin 445 Super Wide\Dense Grade\08jl5bl">08-JN-5BL</a></li>
								<li><a target="_blank"
									href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Florida\Michelin 445 Super Wide\Dense Grade\08ma7br">08-MA-7BR</a></li>
								<li><a target="_blank"
									href="http://${address}\Interface-Meeting\WB Data Folder\Docs\Florida\Michelin 445 Super Wide\Dense Grade\08my6a\2nd attempt\08my6a\3-D Profile Views">08-MY-6A</a></li>

							</ul>
						</li>
					</ul>

				</li>
			</ul>
		</div>

	</div>
	<p style="text-align: right; font-size: x-small;">
		*Year-month-(Lane)(Section)(Right/Left)<br /> <img alt=""
			src="http://jstree.com/tree.png"> Downloadable File
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