<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/table.css" type="text/css" rel="stylesheet">
<link href="css/button.css" type="text/css" rel="stylesheet">
<link href="css/common.css" type="text/css" rel="stylesheet">
<link type='text/css' rel='stylesheet' href='css/style.css' />
<script type="text/javascript" src="js/jquery/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		if ($("#messageDiv").is(':visible')) {
			setTimeout(function() {
				$("#messageDiv").hide('blind');
			}, 3000);
		}
		;
	});
</script>
</head>
<body>
	<%@include file="/WEB-INF/pages/mainHeader.jsp"%>
	<div class="background container">
	<%@include file="/WEB-INF/pages/header.jsp"%>
		<c:if test="${not empty requestScope.message}">
			<div id="messageDiv" style="padding: 11px 84px;">
				<div
					style="color: windowtext; z-index: -1; padding: 7px; width: 750px; background: OliveDrab">${requestScope.message}</div>
			</div>
		</c:if>
		<table
			style="margin-top: 4%; width: 60%; margin-right: auto; margin-left: 80px; float: left;margin-bottom:20px"
			class="imagetable">
			<thead>
				<tr>
					<td
						style="font-size: 15px; font-weight: bold; background: #30576E; color: white; text-align: center;"
						colspan="4">Domain</td>

				</tr>
			</thead>

			<c:forEach items="${listOfRootDomains}" var="domain"
				varStatus="status">
				<tr>
					<td><span class='spanTitle'>${domain.name}</span></td>
					<td><a class='button-default'
						style="margin: 0px 2px 0px; width: 130px; padding: 4px 13px; text-align: center"
						href='assessments/${domain.id}'><span class='spanTitle'>Self Assessment</span></a></td>
					<td><a class='button-default'
						style="margin: 0px 2px 0px; width: 130px; padding: 4px 13px; text-align: center"
						href='assessments/${domain.id}/chart?domainName=${domain.name}'>
						<span class='spanTitle'>View Assessment</span></a></td>
				</tr>
			</c:forEach>
		</table>
		<table
			style="float: left; margin-top: 4%; margin-left: 4%; font-size: 12px">
			<tr>
				<td><a class='button-default'
					style="margin: 0px 2px 0px; width: 100px; padding: 9px 5px 19px; text-align: center"
					href='invitationlist'><span class='spanTitle'>Invite Application Colleagues</span></a></td>
			</tr>
			<tr>
				<td><a class='button-default'
					style="margin: 0px 2px 0px; width: 100px; padding: 9px 5px 19px; text-align: center"
					href='Invite Application Friends'><span class='spanTitle'>Invite LinkedIn Colleagues</span></a></td>
			</tr>
			<tr>
				<td><a class='button-default'
					style="margin: 0px 2px 0px; width: 100px; padding: 9px 5px 19px; text-align: center"
					href='Invite Application Friends'><span class='spanTitle'>Invite Facebook Colleagues</span></a></td>
			</tr>
			<tr>
				<td><a class='button-default'
					style="margin: 0px 2px 0px; width: 100px; padding: 9px 5px 19px; text-align: center"
					href='Invite Application Friends'><span class='spanTitle'>Invite Twitter Colleagues</span></a></td>
			</tr>
			<tr>
				<td><a class='button-default'
					style="margin: 0px 2px 0px; width: 100px; padding: 9px 5px 19px; text-align: center"
					href='Invite Application Friends'>Invite Googleplus Colleagues</a></td>
			</tr>


		</table>

		<div style="width: 500px; padding: 430px 84px 1px;">
			<a  style="color:#30576E" href="assessmentRequests">Click here to assess others</a>
		</div>
	</div>
	<%@include file="/WEB-INF/pages/footer.jsp"%>
</body>
</html>