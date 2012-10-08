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
	<%@include file="/WEB-INF/pages/mainHeader.jsp"%>
	
	<div class="background container">
	<%@include file="/WEB-INF/pages/header.jsp"%>
		<div style="background: white; padding: 10px">
			<c:if test="${not empty requestScope.message}">
				<div id="messageDiv" style="padding: 11px 7px;">
					<div
						style="color: windowtext; z-index: -1; padding: 7px; width: 750px; background: OliveDrab">${requestScope.message}</div>
				</div>
			</c:if>
<%-- 			<div style="font-weight:bold;font-size:17px;margin-left:10px">Welcome ${sessionScope.userCompleteName}</div> --%>
<!-- 			<div style='margin:10px'><a  style='color:#30576E;' href=''>View New Added Domains</a></div> -->
<!-- 			<div style='margin:10px'><a  style='color:#30576E;' href='assessmentRequests'>Invitations For Assessment</a></div> -->
<!-- 			<div style='margin:10px'><a  style='color:#30576E;' href='profile'>Manage Your Profile</a></div> -->
<!-- 			<div style='margin:10px'><a  style='color:#30576E;' href=''>History</a></div> -->
		</div>
		<p style='margin-left:50px'><strong>Welcome ${sessionScope.userCompleteName}</strong></p>
	
	</div>
	<%@include file="/WEB-INF/pages/footer.jsp"%>
</body>
</html>