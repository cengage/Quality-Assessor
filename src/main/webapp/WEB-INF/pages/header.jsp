<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
<link href="/qualityassessor/css/header.css" type="text/css" rel='stylesheet' />
</head>
<body>
	<div id='cssmenu'>
		<ul>
			
				<li><a href='/qualityassessor/home'><span>Home</span></a></li>
			
			
				<c:if test="${sessionScope.group=='AdminGroup'}">
					<li><a href='/qualityassessor/domainManagement?type=product'><span>Product Management</span></a></li>
					<li><a href='/qualityassessor/domainManagement?type=skill'><span>Colleague/Skill Management</span></a></li>
				</c:if>
				
		

			<li><a href='/qualityassessor/assessmentRequests'><span>Reviews</span></a></li>
			<li><a href='/qualityassessor/profile'><span> My Profile</span></a></li>
			<li><a href="<c:url value='/qualityassessor/j_spring_security_logout'/>"><span>Logout</span></a></li>
		</ul>
	</div>
</body>
</html>