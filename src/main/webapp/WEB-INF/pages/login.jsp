<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Login Form</title>
<script src="js/jquery/jquery.min.js"></script>
<script src="js/jquery/jquery.validate.min.js"></script>
<link href="css/common.css" rel="Stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/logincss/reset.css">
<link rel="stylesheet" type="text/css" href="css/logincss/structure.css">
<link rel="stylesheet" type="text/css" href="css/error.css">
<!-- <script type="text/javascript" src="js/jquery/validation.js"></script> -->
<!-- <script type="text/javascript" src="js/jquery/loginValidation.js"></script> -->


  <script>
  $(document).ready(function(){
    $("#loginForm").validate();
  });
  </script>
</head>

<body>
		<%@include file="/WEB-INF/pages/mainHeader.jsp"%>
		
		
		<div class="background container" style="background: white;width:927px;margin:auto;">
		<%@include file="/WEB-INF/pages/headerlogin.jsp"%>
			<form id="loginForm" class="box login" name='f' style="min-height:260px"
				action="<c:url value='j_spring_security_check' />"   method='POST'>
				<fieldset class="boxBody" style="height:70%;">
					<label>Email</label> 
					<input id="userId" type="text" name='j_username' tabindex="1" class="required email"  > 
						<label>Password</label> 
						<input id ="passwordId" name='j_password' type="password" tabindex="2"  class="required" minlength="6" ">
			<c:if test="${not empty error}">
		<div class="error">
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>
				</fieldset>
				<footer style="height:30%;">
					<div>
					<input  type="submit" class="btnLogin" value="Login">
					</div>
					<div style="margin:5px 5px 5px 247px;font-weight:bold;font-size:14px;font-style:italic">
					<a  href="signUp"><font  color="#3E698C"><u>SignUp!</u></font></a>
					</div>
				</footer>
				
			</form>

		</div>
		
	
</body>
</html>
