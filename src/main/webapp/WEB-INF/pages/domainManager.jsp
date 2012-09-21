<html>
<head>
<link href="css/common.css" rel="Stylesheet" type="text/css" />
<!-- Include the required JavaScript libraries: -->
<script src='js/jquery/jquery.min.js' type="text/javascript"></script>
<script src='js/jquery/jquery-ui.custom.min.js' type="text/javascript"></script>
<script src='js/jquery/jquery.cookie.js' type="text/javascript"></script>
<script src='js/jquery/jquery.dynatree.js' type="text/javascript"></script>
<script type="text/javascript" src="js/jquery/jquery.colorbox-min.js"></script>
<!-- <script type="text/javascript" src="js/jquery/homePageScript.js"></script> -->
<script type="text/javascript" src="js/jquery/domainManager.js"></script>
<link type='text/css' rel='stylesheet' href='css/colorbox.css' />
<link type='text/css' rel='stylesheet' href='css/button.css' />
<link type='text/css' rel='stylesheet' href='css/style.css' />
<link rel='stylesheet' type='text/css' href='css/skin/ui.dynatree.css'>
<script src="js/jquery/jquery.ui.autocomplete.min.js"></script>
<script src='js/jquery/autoCompleteScript.js'></script>
<link rel="stylesheet" href="css/jquery.ui.autocomplete.css">
<link rel="stylesheet" href="css/jquery.ui.all.css">
<style type="text/css">
.inputWeightage{
width:30px;
}

.addBorder{
border:1px;
}

.iconWidth{
width:2%;
}

img{
cursor:pointer;
}

.titleClass{

width:30%;
}

</style>
</head>

<body >
	<%@include file="/header.jsp"%>
	<div class="background container">

		<div style="background: white; padding: 10px">
			<a style="margin: 0px 2px 0px; width: 130px" class='button-default'
				href="javascript:showAddRootDomainView()">Add New Domain</a>
		</div>
		<p></p>
		<!-- Add a <div> element where the tree should appear: -->
		<div style="width:700px" id="domainDivId"></div>
	</div>
</body>
</html>