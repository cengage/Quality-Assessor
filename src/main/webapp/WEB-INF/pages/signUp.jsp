<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Login Form</title>
<link href="css/common.css" rel="Stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/logincss/reset.css">
<link rel="stylesheet" type="text/css" href="css/logincss/structure.css">
</head>

<body>

	<%@include file="/headerlogin.jsp"%>

	<!-- <body style="padding: 100px 0 0 250px;"> -->


	<div class="background container"
		style="background: white; width: 927px; margin: auto;">




		<!-- 		<H2>Sign In</H2> -->

		<form class="box login" style="top: 36%; height: 480px"
			action="signUp" method="post">
			<fieldset class="boxBody">

				<label class="userform-box-name">First Name</label> <input
					name="firstName" type="text" class="form-login" title="FirstName"
					value="" size="30" maxlength="2048" required /> <label
					class="userform-box-name">Last Name</label> <input name="lastName"
					type="text" class="form-login" title="LastName" value="" size="30"
					maxlength="2048" required /> <label class="userform-box-name">Email</label>
				<input name="username" type="text" class="form-login"
					title="Username" value="" size="30" maxlength="2048" required /> <label
					class="userform-box-name">Password</label> <input name="password"
					type="password" class="form-login" title="Password" value=""
					size="30" maxlength="2048" required /> <label
					class="userform-box-name">Confirm Password</label> <input
					name="confirmPassword" type="password" class="form-login"
					title="Confirm Password" value="" size="30" maxlength="2048"
					required />




			</fieldset>
			<footer>
				<input type="submit" class="btnLogin" value="Sign Up">
			</footer>



		</form>


	</div>


</body>
</html>
