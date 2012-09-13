<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
<link href="css/header.css" type="text/css" rel='stylesheet' />
</head>
<body>
	<div id='cssmenu'>
		<ul>
			<c:if test="${sessionScope.group=='AdminGroup'}">
				<li><a href='adminHome'><span>Home</span></a></li>
			</c:if>
			<li><a href='home'><span><c:choose>
						<c:when test="${sessionScope.group=='AdminGroup'}">Assessment</c:when>
						<c:otherwise> Home</c:otherwise>
					</c:choose> </span></a></li>

			<li><a href='profile'><span>Profile</span></a></li>
			<li><a href="<c:url value='j_spring_security_logout'/>"><span>Logout</span></a></li>
		</ul>
	</div>
</body>
</html>