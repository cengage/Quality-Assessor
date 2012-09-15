<html>
<head>
<link href="css/common.css" rel="Stylesheet" type="text/css" />
<!-- Include the required JavaScript libraries: -->
<script src='js/jquery/jquery.min.js' type="text/javascript"></script>
<script src='js/jquery/jquery-ui.custom.min.js' type="text/javascript"></script>
<script src='js/jquery/jquery.cookie.js' type="text/javascript"></script>
<script src='js/jquery/jquery.dynatree.js' type="text/javascript"></script>
<script type="text/javascript" src="js/jquery/jquery.colorbox-min.js"></script>
<script type="text/javascript" src="js/jquery/homePageScript.js"></script>
<link type='text/css' rel='stylesheet' href='css/colorbox.css' />
<link type='text/css' rel='stylesheet' href='css/button.css' />
<link type='text/css' rel='stylesheet' href='css/style.css' />
<link rel='stylesheet' type='text/css' href='css/skin/ui.dynatree.css'>
</head>

<body class="homeClass">
	<%@include file="/header.jsp"%>
	<div class="background container">

		<div style="background: white; padding: 10px">
			<c:if test="${not empty requestScope.message}">
				<div style="padding: 11px 7px;">
					<div
						style="color: windowtext; z-index: -1; padding: 7px; width: 750px; background: OliveDrab">${requestScope.message}</div>
				</div>
			</c:if>
			<a style="margin: 0px 2px 0px; width: 130px" class='button-default'
				href="javascript:showAddRootDomainView()">Add New Domain</a>
		</div>
		<p></p>
		<!-- Add a <div> element where the tree should appear: -->
		<div id="tree"></div>
	</div>
</body>
</html>