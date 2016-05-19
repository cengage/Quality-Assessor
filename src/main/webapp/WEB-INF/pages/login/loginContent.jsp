<%@include file="/WEB-INF/pages/common/common-taglibs.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div style="background: none repeat scroll 0 0 #333333; height: 80px; margin: auto; width: 100%;">


	<form id="loginForm" class="box login" name='f'
		action="<c:url value='j_spring_security_check' />" method='POST'>
		<div style="margin-right: 25.5em; margin-left: 25.5em;">Login</div>
		<fieldset class="boxBody"
			style="margin-right: 25.5em; margin-left: 25.5em; background: #fefefe; border-top: solid #dde0e8; border-bottom: solid #dde0e8;">
			<label>User Name</label><input type="text" name='j_username'
				tabindex="1" id="userId" /> <label>Password</label><input
				type="password" id="passwordid" name='j_password' tabindex="2"
				class="required" />
			<c:if test="${not empty error}">
				<div class="error">
					${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</div>
			</c:if>
			<input type="submit" class="btnLogin" value="Login">
		</fieldset>

	</form>
	<form:form id="signUpForm" class="box login" style="top: 36%;"
		action="signUp" method="post" commandName="userProfileDTO">
		<fieldset class="boxBody"
			style="height: 75%; margin-top: 10em; margin-right: 25.5em; margin-left: 25.5em;">
			<label
				style="margin: 2px 302px 2px 2px; font-size: 12px; position: absolute; right: 0;">*
				fields are required</label> <label class="userform-box-name">First
				Name*</label>
			<form:input path="firstName" type="text" value="" class="required" />
			<form:errors path="firstName" cssClass="error" />
			<br> <br> <label class="userform-box-name">Last
				Name*</label>
			<form:input path="lastName" type="text" value="" class="required" />

			<form:errors path="lastName" cssClass="error" />
			<br> <br> <label class="userform-box-name">Email*</label>
			<form:input path="username" type="text" value="" size="30"
				maxlength="2048" class="required email" />
			<form:errors path="username" cssClass="error" />
			<br> <br> <label class="userform-box-name">Password*</label>
			<form:input path="password" type="password" value="" size="30"
				maxlength="2048" class="required" minlength="6" />
			<form:errors path="password" cssClass="error" />
			<br> <br> <label class="userform-box-name">Confirm
				Password*</label>
			<form:input id="confirmPassword" path="confirmPassword"
				type="password" value="" size="30" maxlength="2048"
				class="required confirmPassword" minlength="6" />
			<form:errors path="confirmPassword" cssClass="error" />
			<form:errors path="" cssClass="error" />
		</fieldset>
		<fieldset class="formFooter"
			style="height: 25%; margin-right: 25.5em; margin-left: 25.5em; padding: 20px 26px;  background: #eff4f6">
			<input type="submit" class="btnLogin" value="Sign Up">
		</fieldset>
	</form:form>

</div>