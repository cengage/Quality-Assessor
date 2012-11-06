<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Sign Up</title>
<link href="css/common.css" rel="Stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/logincss/reset.css">
<link rel="stylesheet" type="text/css" href="css/logincss/structure.css">
<link rel="stylesheet" type="text/css" href="css/error.css">
<script src="js/jquery/jquery.min.js"></script>
<script src="js/jquery/jquery.validate.min.js"></script>
<script>
  $(document).ready(function(){
    $("#signUpForm").validate();
  });
  
  jQuery.validator.addMethod("confirmPassword", function(value, element) { 
	  var password=$('#password').val();
	  var confirmPassword =$('#confirmPassword').val();
	  if(password!=confirmPassword){
		  return false;
	  }
	   return true; 
	}, "Password doesn\'t match with confirm password");
  
//   function checkCustomValidation(){
// 	  var password=$('#password').val();
// 	  var confirmPassword =$('#confirmPassword').val();
// 	  if(password!=confirmPassword){
// 		  alert('password doesn\'t match with confirm password');
// 		  return false;
// 	  }
// 	   return true;
//   }
  
  </script>
</head>

<body>

	<%@include file="/WEB-INF/pages/mainHeader.jsp"%>

	<!-- <body style="padding: 100px 0 0 250px;"> -->


	<div class="background container"
		style="background: white; width: 70%; margin: auto;">
	<%@include file="/WEB-INF/pages/headerlogin.jsp"%>
	


		<!-- 		<H2>Sign In</H2> -->

		<form:form id="signUpForm" class="box login"
			style="top: 36%;" action="signUp" method="post" commandName="userProfileDTO" >
			<fieldset class="boxBody" style="height: 75%">
				<label style="margin: 2px 9px 2px 2px;font-size: 12px;position: absolute;right: 0;">* fields are required</label>
				<label class="userform-box-name">First Name*</label> 
				<form:input path="firstName" type="text" value="" class="required" /> 
				<form:errors path="firstName" cssClass="error" />
					
			   <label class="userform-box-name">Last Name*</label> 
			   <form:input path="lastName" type="text" value="" class="required" />
			   
			   <form:errors path="lastName" cssClass="error" />
					 
				<label class="userform-box-name">Email*</label> 
				<form:input path="username" type="text" value="" size="30" maxlength="2048"
					class="required email" /> 
				<form:errors path="username" cssClass="error" />
				
				<label class="userform-box-name">Password*</label>
				<form:input path="password"  type="password" value=""
					size="30" maxlength="2048" class="required" minlength="6" />
				<form:errors path="password" cssClass="error" />
				
			  <label class="userform-box-name">Confirm Password*</label> <form:input
					id="confirmPassword" path="confirmPassword" type="password"
					value="" size="30" maxlength="2048"
					class="required confirmPassword" minlength="6" />
				<form:errors path="confirmPassword" cssClass="error" />
				<form:errors path="" cssClass="error"/>


			</fieldset>
			<fieldset class="formFooter" style="height: 25%;padding:20px 26px;">
				<input type="submit" class="btnLogin" value="Sign Up">
			</fieldset>



		</form:form>


	</div>
<%@include file="/WEB-INF/pages/footer.jsp"%>

</body>
</html>
