<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type='text/css' rel='stylesheet' href='css/colorbox.css' />
<link rel="stylesheet" href="css/domainSettingsStyle.css">
<link rel="stylesheet" href="css/jquery.ui.all.css">
<script src='js/jquery/jquery.min.js'></script>
<script src="js/jquery/jquery.ui.core.min.js"></script>
<script src="js/jquery/jquery.ui.widget.min.js"></script>
<script src="js/jquery/jquery.ui.position.min.js"></script>
<script src="js/jquery/jquery.ui.autocomplete.min.js"></script>
<script src="js/jquery/domainSettingsScript.js"></script>
<script src='js/jquery/autoCompleteScript.js'></script>
<script src="js/jquery.colorbox-min.js"></script>
<link rel="stylesheet" href="css/jquery.ui.autocomplete.css">
<style>
.ui-autocomplete-loading {
	background: white url('images/ui-anim_basic_16x16.gif') right center
		no-repeat;
}
</style>
<link type='text/css' rel='stylesheet' href='css/style.css' />

</head>
<body>

	<!--Adding main div for domain settings -->

	<div id="main" align="center">
		<div id="selectedDomainInfo"></div>
		<p></p>
		<div>
			<a style="width: 111px" class='button-default'
				href="javascript:showUpdateDomainView()">Edit Domain</a>
		</div>

		<p></p>

		<div>
			<a style="width: 111px" class='button-default'
				href="javascript:showAddDomainView()">Add Sub-Domain</a>
		</div>

		<p></p>

		<div>
			<a style="width: 111px" class='button-default'
				href="javascript:deleteDomain()">Delete Domain</a>
		</div>

	</div>

	<!--  div for adding new domain View -->

	<div id="addDomain" style="display: none">
		<div id="addMsg"></div>
		<div>
			<label for="Name"> <strong>Please enter Domain name</strong>
			</label>
		</div>
		<div>
			<input class="autoCompleteWiki" id="newTitleId" type="text">
		</div>
		<div>
        			<a target="_blank" class="wikiLinkUpdate" href=""></a>
        		</div>
		<div id="newTitleErrorId"></div>
		<p></p>
		<div id="newWeightageDiv">
			<div>
				<label for="Weighting"> <strong>Please give
						weighing to Domain</strong>
				</label>
			</div>
			<div>
				<input id="newWeightageId" type="text"> <label
					id="remainingWeightageId" for="remainingWeightage"> </label>
			</div>

			<div id="newWeightageErrorId"></div>
		</div>
		<p></p>
		<p></p>
		<div style="float:left">
			<a style="width: 47px" class='button-default'
				href="javascript:saveDomain()">Add</a>
		</div>
        <div style="float:left;float: left;position: absolute;right: 0;margin:0 18px" id="subDomainWeightageDiv">
        <a id="subDomainWeightageLink" href="javascript:showSubDomainsWeightage()">Show Sub-Domain Weighing</a>
        </div>


		<div id="backButtonId" align="right"
			style="bottom: 0; position: fixed; right: 0">
			<a href="javascript:showDomainSettings()"><img width="35px"
				height="28px" src="images/prev.png"></a>
		</div>
	</div>

	<!--  div for editing new domain View -->

	<div id="editDomain" style="display: none">
		<div id="editMsg"></div>
		<div>
			<div>
				<label for="Name"> <strong>Please enter Domain name</strong>
				</label>
			</div>
			<div>
				<input class="autoCompleteWiki" id="editTitleId" type="text">
			</div>
			<div id="editTitleErrorId"></div>
		</div>
		<p></p>
		<div id="editWeightageDiv">
			<div>
				<label for="Weightage"> <strong>Please give
						weighing to Domain</strong>
				</label>
			</div>
			<div>
				<input id="editWeightageId" type="text">
			</div>

			<div id="editWeightageErrorId"></div>
		</div>
		<p></p>
		<p></p>
		<div>
			<a style="width: 47px" class='button-default'
				href="javascript:updateDomain()">Update</a>
		</div>



		<div align="right" style="bottom: 0; position: fixed; right: 0">
			<a href="javascript:showDomainSettings()"><img width="35px"
				height="28px" src="images/prev.png"></a>
		</div>

	</div>
</body>
</html>