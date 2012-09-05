<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/table.css" type="text/css" rel="stylesheet">
<link href="css/button.css" type="text/css" rel="stylesheet">
<link href="css/common.css" type="text/css" rel="stylesheet">
<link type='text/css' rel='stylesheet' href='css/style.css' />
</head>
<script>

</script>
<body>
	<%@include file="/header.jsp"%>
	<div class="background container">
		<table style="margin-top:4%;width:80%;margin-right:auto;margin-left:auto;" class="imagetable">
			<thead>
				<tr>
					<td
						style="font-size: 15px; font-weight: bold; background: #436F93; color: white; text-align: center;"
						colspan="4">Domain</td>

				</tr>
			</thead>

			<c:forEach items="${listOfRootDomains}" var="domain"
				varStatus="status">
				<tr>
					<td>${domain.name}</td>
					<td><a class='button-default' style="margin:0px 2px 0px;width: 130px;padding:4px 13px;text-align:center" 
						 href='domain?key=${domain.id}'>Self Assessment</a></td>
					<td><a class='button-default' style="margin:0px 2px 0px;width: 138px;padding:4px 13px;text-align:center" 
						 href='Invite Friends to Assess'>Invite Friends to Assess</a></td>
					<td><a class='button-default' style="margin:0px 2px 0px;width: 130px;padding:4px 13px;text-align:center" 
						 href='Invite Friends to Assess'>View Assessment</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>