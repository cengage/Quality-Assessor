<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<!-- Include the required JavaScript libraries: -->
<script src='js/jquery/jquery.min.js' type="text/javascript"></script>
<script src='js/jquery/jquery-ui.custom.min.js' type="text/javascript"></script>
<script src='js/jquery/jquery.cookie.js' type="text/javascript"></script>
<script src='js/jquery/jquery.dynatree.js' type="text/javascript"></script>
<script type="text/javascript" src="js/jquery/jquery.colorbox-min.js"></script>
<script type="text/javascript" src="js/jquery/homePageScript.js"></script>
<link type='text/css' rel='stylesheet' href='css/colorbox.css' />
<link type='text/css' rel='stylesheet' href='css/style.css' />
<link rel='stylesheet' type='text/css' href='css/skin/ui.dynatree.css'>
</head>

<body class="homeClass">
	<div style="position: fixed; right: 16px">
		<a href="profile">Profile</a>
		<a href="<c:url value="j_spring_security_logout" />">Logout</a>
	</div>
	<div>
		<a style="width: 120px" class='button-default'
			href="javascript:showAddRootDomainView()">Add New Domain</a>
	</div>
	<p></p>
	<!-- Add a <div> element where the tree should appear: -->
	<div id="tree"></div>
</body>
</html>