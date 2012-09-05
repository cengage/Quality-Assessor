<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Login Form</title>
<script src="js/jquery/jquery.min.js"></script>
<link href="css/common.css" rel="Stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/logincss/reset.css">
<link rel="stylesheet" type="text/css" href="css/logincss/structure.css">
<script type="text/javascript" src="js/jquery/validation.js"></script>
<script type="text/javascript" src="js/jquery/loginValidation.js"></script>
</head>

<body>
	
		<%@include file="/headerlogin.jsp"%>
		
		<div class="background container" style="background: white;width:927px;margin:auto;">
			<form class="box login" name='f'
				action="<c:url value='j_spring_security_check' />" onsubmit="return checkValidations();"  method='POST'>
				<fieldset class="boxBody">
					<label>Email</label> 
					<input id="userId" type="email" name='j_username' tabindex="1" required  > 
						<label>Password</label> 
						<input id ="passwordId" name='j_password' type="password" tabindex="2"  required>
				</fieldset>
				<footer>
	<div>
					<input  type="submit" class="btnLogin" value="Login"></div>
					<div style="margin:5px 5px 5px 247px;font-weight:bold;font-size:14px;font-style:italic">
					<a  href="signUp"><font  color="#3E698C"><u>SignUp!</u></font></a></div>
				</footer>
				
			</form>
<!-- 			<footer id="main"> -->
<!-- 				<a href="http://wwww.cssjunction.com">Simple Login Form -->
<!-- 					(HTML5/CSS3 Coded) by CSS Junction</a> | <a -->
<!-- 					href="http://www.premiumpixels.com">PSD by Premium Pixels</a> -->
<!-- 			</footer> -->
		</div>
		
	
</body>
</html>
