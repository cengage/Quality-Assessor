<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
<link href="css/common.css" rel="Stylesheet" type="text/css" />
<!-- Include the required JavaScript libraries: -->
<script src='js/jquery/jquery.min.js' type="text/javascript"></script>
<!-- <script src='js/jquery/jquery-ui.custom.min.js' type="text/javascript"></script> -->
<!-- <script src='js/jquery/jquery.cookie.js' type="text/javascript"></script> -->
<!-- <script type="text/javascript" src="js/jquery/homePageScript.js"></script> -->
<link type='text/css' rel='stylesheet' href='css/button.css' />
<link type='text/css' rel='stylesheet' href='css/style.css' />

</head>

<body>
<%-- 	<%@include file="/WEB-INF/pages/mainHeader.jsp"%> --%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
	<div class="background container">
<%-- 	<%@include file="/WEB-INF/pages/header.jsp"%> --%>
		<div style="background: white; padding: 10px">
			<c:if test="${not empty requestScope.message}">
				<div id="messageDiv" style="padding: 11px 7px;">
					<div
						style="color: windowtext; z-index: -1; padding: 7px; width: 750px; background: OliveDrab">${requestScope.message}</div>
				</div>
			</c:if>

		</div>
		<p style='margin-left:50px'><strong>Welcome ${sessionScope.userCompleteName}</strong></p>
	
	</div>
	
</body>
</html>