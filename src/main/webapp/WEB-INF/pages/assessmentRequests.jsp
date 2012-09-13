<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/common.css" type="text/css" rel="stylesheet">
</head>
<body>
	<%@include file="/header.jsp"%>
	<div class="background container">
		<div style="font-size:18px;padding:30px"><label><strong>Requests For Assessments</strong></label></div>
		<div style="padding:20px">
			<c:forEach var="assessment" items="${assessmentRequestList}">
				<a href="domain?key=${assessment.domain.domainId}&requestedUserId=${assessment.user.userId}">Assess ${assessment.user.firstName}
					${assessment.user.lastName} on ${assessment.domain.domainName}</a>
				<br />
			</c:forEach>
		</div>
	</div>
</body>
</html>