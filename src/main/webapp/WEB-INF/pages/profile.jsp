<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<link href="css/profile.css" rel="Stylesheet" type="text/css" />
<link href="css/common.css" rel="Stylesheet" type="text/css" />
<link href="css/button.css" type="text/css" rel="stylesheet">
<script src='js/jquery/jquery.min.js' type="text/javascript"></script>
<script type="text/javascript" src="js/jquery/profile.js"></script>
<!-- <link href="css/jquery.ui.all.css" rel="stylesheet"/> -->
<script src="js/jquery/jquery.min.js"></script>
<script src="js/jquery/jquery.ui.core.min.js"></script>
<script src="js/jquery/jquery.ui.widget.min.js"></script>
<script src="js/jquery/jquery.ui.datepicker.js"></script>
<script src="js/jquery/jquery.watermark.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/error.css">
<script src="js/jquery/jquery.validate.min.js"></script>
<link href="css/datepick.css" rel="stylesheet" />

<script>
		$(document).ready(function() {
			$("#profileForm").validate();
		});
</script>
</head>

<body>
	<%@include file="/header.jsp"%>

	<div class="background container" style="height: auto">
		<div style="margin: 0px; padding-top: 30px">

			<form:form  id="profileForm" action="profile" method="POST"
				commandName="userProfileDTO">
				<form:errors path="" cssClass="objectError" />

				<table class="zebra-striped"
					style="width: 650px; margin: 0px 30px 10px 120px; border: 1px solid #CCCCCC;">
					<thead>
						<tr>
							<td style="text-align: center; border-bottom: 1px solid #CCCCCC;"
								colspan="4"><strong class="headerStrong">Personal
									Details</strong></td>
						</tr>
					</thead>

					<tr style="background-color: white;">
						<!-- 					<td class="span3"><select name="salutation" -->
						<!-- 						style="margin-left: 50px;"><option>Mr.</option> -->
						<!-- 							<option>Ms.</option> -->
						<!-- 							<option>Mrs.</option></select></td> -->
						<td><strong>Name*</strong></td>
						<td class="span3"><form:input id="firstName" path="firstName"
								type="text" class="required" /> <form:errors path="firstName"
								cssClass="error" /></td>
						<td class="span3"><form:input id="middleName"
								path="middleName" type="text" /></td>
						<td class="span3"><form:input id="lastName" path="lastName"
								type="text" /></td>
					</tr>
					<tr style="background-color: white;">
						<td class="span3"><strong>Email*</strong></td>
						<td class="span3"><form:input path="username" type="text"
								class="required email" /></td>
						<td colspan="2"><form:errors path="username" cssClass="error" /></td>

					</tr>
				</table>

				<table class="zebra-striped"
					style="width: 650px; margin: 30px 30px 10px 120px; border: 1px solid #CCCCCC;">
					<thead>
						<tr>
							<td style="text-align: center; border-bottom: 1px solid #CCCCCC;"
								colspan="4"><strong class="headerStrong">Address
									Details</strong></td>
						</tr>
					</thead>

					<tr>
						<td class="span3"><strong>Address Line1</strong></td>
						<td class="span3"><form:input path="addressLine1" type="text" /></td>
						<td class="span3"><strong>Address Line2</strong></td>
						<td class="span3"><form:input path="addressLine2" type="text" /></td>
					</tr>
					<tr>
						<td class="span3"><strong>City</strong></td>
						<td class="span3"><form:input path="city" type="text" /></td>
						<td class="span3"><strong>State</strong></td>
						<td class="span3"><form:input path="state" type="text" /></td>
					</tr>
					<tr>
						<td class="span3"><strong>Country</strong></td>
						<td class="span3"><form:input path="country" type="text" /></td>
						<td class="span3"><strong>Zip</strong></td>
						<td class="span3"><form:input path="zipCode" type="text" /></td>
					</tr>

				</table>


				<table id="workExpTable1" class="zebra-striped"
					style="width: 650px; margin: 30px 30px 10px 120px; border: 1px solid #CCCCCC;">

					<thead>
						<tr>
							<td style="text-align: center; border-bottom: 1px solid #CCCCCC;"
								colspan="5"><strong class="headerStrong">Work
									Experience</strong></td>
						</tr>
					</thead>

					<tr style="background-color: #F9F9F9;" id="workExpLabels1"
						class="clonedInput">
						<td><strong>Title</strong></td>
						<td><strong>Area Of Expertise</strong></td>
						<td><strong>Role Description</strong></td>
						<td><strong>From Date</strong></td>
						<td><strong>To Date</strong></td>

					</tr>
					<c:forEach items="${userProfileDTO.workExperiences}"
						varStatus="stat">
						<tr id="workExpTexts${stat.index}" class="cloneWorkExpTexts">
							<td><form:input type="hidden"
									path="workExperiences[${stat.index}].workExperienceId" /> <form:input
									path="workExperiences[${stat.index}].title" class="title"
									type="text" /></td>
							<td><form:input
									path="workExperiences[${stat.index}].areaOfExpertise"
									class="areaOfExperience" type="text" /></td>
							<td><form:input
									path="workExperiences[${stat.index}].roleDescription"
									class="roleDescription" type="text" /></td>
							<td style="width: 44%"><form:input style="width: 100%"
									class="fromDatepicker"
									path="workExperiences[${stat.index}].fromDate" type="text" /></td>
							<td style="width: 44%"><form:input style="width: 100%"
									class="toDatepicker"
									path="workExperiences[${stat.index}].toDate" type="text" /></td>
						</tr>
					</c:forEach>

					<tr id="workExpBtnTr">
						<td colspan="2" style="border-top: none"><input
							class="btn primary" id="addMoreWorkExpbtn" type="button"
							value="Add More Work Experience"></td>
					</tr>

				</table>




				<table id="socialNetwork1" class="zebra-striped"
					style="width: 650px; margin: 30px 30px 10px 120px; border: 1px solid #CCCCCC;">

					<thead>
						<tr>
							<td style="text-align: center; border-bottom: 1px solid #CCCCCC;"
								colspan="5"><strong class="headerStrong">Social
									Network</strong></td>
						</tr>
					</thead>

					<tr style="background-color: #F9F9F9;">
						<form:input type="hidden" path="socialNetworkId" />
						<td class="span3"><strong>SocialNetwork</strong></td>
						<td class="span3"><strong>SocialNetwork-Id</strong></td>
					</tr>
					<tr>
						<td class="span3"><input name="socialSiteName" type="hidden"
							value="LinkedIn" /><strong>LinkedIn</strong></td>
						<td class="span3"><form:input path="linkedInId" /></td>
					</tr>
					<tr>
						<td class="span3"><input name="socialSiteName" type="hidden"
							value="Facebook" /><strong>Facebook</strong></td>
						<td class="span3"><form:input path="facebookId" /></td>
					</tr>
					<tr>
						<td class="span3"><input name="socialSiteName" type="hidden"
							value="Twitter" /><strong>Twitter</strong></td>
						<td class="span3"><form:input path="twitterId" /></td>
					</tr>
					<tr>
						<td class="span3"><input name="socialSiteName" type="hidden"
							value="Googleplus" /><strong>Googleplus</strong></td>
						<td class="span3"><form:input path="googleplusId" /></td>
					</tr>
					<!-- 					<tr id="socialButtonRow"> -->
					<!-- 						<td style="border-top: none"><input id="addMoreSocialbtn" class="btn primary" -->
					<!-- 							type="button" value="Add More Social Network"></td> -->
					<!-- 					</tr> -->
				</table>

				<div align="center">
					<input style="margin-top: 20px; margin-bottom: 10px" type="submit"
						class="btn primary" value="Save">
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>