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
		
		<div class="background container" style="background: white;width:927px;margin:auto;">
			<form class="box login" name='f'
				action="<c:url value='j_spring_security_check' />" method='POST'>
				<fieldset class="boxBody">
					<label>Username</label> <input type="text" name='j_username'
						tabindex="1" required> <label><a href="#"
						class="rLink" tabindex="5">Forget your password?</a>Password</label> <input
						name='j_password' type="password" tabindex="2" required>
				</fieldset>
				<footer>

					<input type="submit" class="btnLogin" value="Login">
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
