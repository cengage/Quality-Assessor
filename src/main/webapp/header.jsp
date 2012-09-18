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
			
				<li><a href='home'><span>Home</span></a></li>
			
			
				<c:if test="${sessionScope.group=='AdminGroup'}">
					<li><a href='domainManager'><span>Domain Manager</span></a></li>
				</c:if>
				
		

			<li><a href='assessments'><span>Assessments</span></a></li>
			<li><a href='profile'><span> My Profile</span></a></li>
			<li><a href="<c:url value='j_spring_security_logout'/>"><span>Logout</span></a></li>
		</ul>
	</div>
</body>
</html>