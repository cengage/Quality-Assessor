<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Login Form</title>
<script src="js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery/invitationList.js"></script>
<link href="css/common.css" rel="Stylesheet" type="text/css" />
<link type='text/css' rel='stylesheet' href='css/style.css' />
</head>

<body>

	<%@include file="/headerlogin.jsp"%>

	<div class="background container"
		style="background: white; width: 927px;">

		<div style="font-size:18px;padding:43px"><label><strong>Select Domain to Assess</strong></label></div>
		<table style='width: 600px; margin-left: 84px'>
			<tr>
				<td style='width: 250px;'><b>Application Domains</b><br /> <select
				size="10"	 multiple="multiple" id='domainList' style="width: 100%;">
						<c:forEach var='domain' items="${domainList}">
							<option value="${domain.id}">${domain.name}</option>
						</c:forEach>
				</select></td>
				<td style='width: 50px; text-align: center; vertical-align: middle;'>
					<input type='button' id='domainRight' value='  >  ' /> <br /> <input
					type='button' id='domainLeft' value='  <  ' />
				</td>
				<td style='width: 250px;'><b>Selected Domains</b><br /> <select
				size='10'	multiple="multiple" id='selectedDomainList' style="width: 100%;">

				</select></td>
			</tr>
		</table>
		<div style="font-size:18px;padding:43px"><label><strong>Select Users</strong></label></div>
		<table style='width: 600px; margin: 0px 84px 0px;'>
			<tr>
				<td style='width: 250px;'><b>Application Users</b><br /> <select
				size='10'	style="width: 100%" multiple="multiple" id='userList'>
						<c:forEach var='user' items="${userList}">
							<option value="${user.userId}">${user.firstName}
								${user.lastName}</option>
						</c:forEach>
				</select></td>
				<td style='width: 50px; text-align: center; vertical-align: middle;'>
					<input type='button' id='userRight' value='  >  ' /> <br /> <input
					type='button' id='userLeft' value='  <  ' />
				</td>
				<td style='width: 250px;'><b>Selected Users</b><br /> <select
				 size='10'	style="width: 100%" multiple="multiple" id='selectedUserList'>

				</select></td>
			</tr>
		</table>



		<div align="center"
			style="position: absolute; width: 150px; text-align: center; right: 50%; margin-top: 40px">
			<a  class='button-default' href="javascript:sendInvitation();">Send Invitations</a>
		</div>
	</div>
</body>
</html>