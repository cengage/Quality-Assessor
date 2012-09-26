<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/common.css" type="text/css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery/assessmentRequests.js"></script>
</head>
<body>
	<%@include file="/WEB-INF/pages/mainHeader.jsp"%>
	<div class="background container">
		<%@include file="/WEB-INF/pages/header.jsp"%>
		<div style="font-size:18px;padding-left:20px;padding-top:20px"><label><strong>Requests For Assessments</strong></label></div>
		<div id='viewIgnoreRequestDiv' style="margin-left:670px;"><a style='color:#30576E' href='assessmentRequests?ignoreInvitation=true'>View ignored invitations</a></div>
		<div style="padding-left:20px">
			<c:forEach var="assessment" items="${assessmentRequestList}">
				<div style='border-top:1px solid #ccc;margin-top:15px;'>
				<div style='margin-bottom:12px;margin-top:12px;font-weight:bold;font-size:13px'>
				<div>${assessment.invitationDate}</div>
				<div>${assessment.userCompleteName} on ${assessment.domainName}</div></div>
				<div style='display:inline;'><a style='display:inline;padding:4px 13px' class='button-default' href="assessments/${assessment.domainId}?requestedUserId=${assessment.userId}&invitationId=${assessment.invitationId}">Assess Now</a></div>
				<div style='display:inline;'><a style='display:inline;padding:4px 13px' class='button-default' href="ignoreInvitation?invitationId=${assessment.invitationId}">Ignore</a></div>
				</div>
			</c:forEach>
		</div>
	</div>
	<%@include file="/WEB-INF/pages/footer.jsp"%>
</body>
</html>