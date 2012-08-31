<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
<link href="css/profile.css" rel="Stylesheet" type="text/css" />
<link href="css/common.css" rel="Stylesheet" type="text/css" />
<script src='js/jquery/jquery.min.js' type="text/javascript"></script>
<script type="text/javascript" src="js/jquery/profile.js"></script>
<!-- <link href="css/jquery.ui.all.css" rel="stylesheet"/> -->
<script src="js/jquery/jquery.min.js"></script>
<script src="js/jquery/jquery.ui.core.min.js"></script>
<script src="js/jquery/jquery.ui.widget.min.js"></script>
<script src="js/jquery/jquery.ui.datepicker.js"></script>
<script src="js/jquery/jquery.watermark.min.js"></script>
<link href="css/datepick.css" rel="stylesheet" />
</head>

<body>
	<%@include file="/header.jsp"%>

	<div class="background container">
		<div style="margin: 0px">
			
			<form action="profile" method="POST">

				<p></p>
				<table class="zebra-striped"
					style="width: 650px; margin: 30px 30px 10px 120px; border: 1px solid #CCCCCC;">
					<thead>
						<tr style="background-color: #F9F9F9;">
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
						<td class="span3"><input id="firstName" name="firstName"
							type="text"></td>
						<td class="span3"><input id="middleName" name="middleName"
							type="text"></td>
						<td class="span3"><input id="lastName" name="lastName"
							type="text"></td>
					</tr>
					<tr style="background-color: white;">
						<td class="span3"><strong>Email*</strong></td>
						<td class="span3"><input name="username" type="text"></td>
					</tr>
				</table>

				<table  class="zebra-striped"
					style="width: 650px; margin: 30px 30px 10px 120px; border: 1px solid #CCCCCC;">
					<thead>
						<tr style="background-color: #F9F9F9;">
							<td style="text-align: center; border-bottom: 1px solid #CCCCCC;"
								colspan="4"><strong class="headerStrong">Address
									Details</strong></td>
						</tr>
					</thead>

					<tr>
						<td class="span3"><strong>Address Line1</strong></td>
						<td class="span3"><input name="addressLine1" type="text"></td>
						<td class="span3"><strong>Address Line2</strong></td>
						<td class="span3"><input name="addressLine2" type="text"></td>
					</tr>
					<tr>
						<td class="span3"><strong>City</strong></td>
						<td class="span3"><input name="city" type="text"></td>
						<td class="span3"><strong>State</strong></td>
						<td class="span3"><input name="state" type="text"></td>
					</tr>
					<tr>
						<td class="span3"><strong>Country</strong></td>
						<td class="span3"><input name="country" type="text"></td>
						<td class="span3"><strong>Zip</strong></td>
						<td class="span3"><input name="zip" type="text"></td>
					</tr>

				</table>


				<table id="workExpTable1" class="zebra-striped"
					style="width: 650px; margin: 30px 30px 10px 120px; border: 1px solid #CCCCCC;">

					<thead>
						<tr style="background-color: #F9F9F9;">
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
					<tr id="workExpTexts1" class="cloneWorkExpTexts">
						<td><input name="title" type="text"></td>
						<td><input name="areaOfExpertise" type="text"></td>
						<td><input name="roleDescription" type="text"></td>
						<td style="width: 44%"><input style="width: 100%"
							class="fromDatepicker" name="fromDate" type="text"></td>
						<td style="width: 44%"><input style="width: 100%"
							class="toDatepicker" name="toDate" type="text"></td>

					</tr>
					<tr>
						<td colspan="2" style="border-top: none"><input
							id="addMoreWorkExpbtn" type="button"
							value="Add More Work Experience"></td>
					</tr>

				</table>




				<table id="socialNetwork1" class="zebra-striped"
					style="width: 650px; margin: 30px 30px 10px 120px; border: 1px solid #CCCCCC;">

					<thead>
						<tr style="background-color: #F9F9F9;"
							style="background-color: #F9F9F9;">
							<td style="text-align: center; border-bottom: 1px solid #CCCCCC;"
								colspan="5"><strong class="headerStrong">Social
									Network</strong></td>
						</tr>
					</thead>

					<tr style="background-color: #F9F9F9;">
						<td class="span3"><strong>SocialNetwork</strong></td>
						<td class="span3"><strong>SocialNetwork-Id</strong></td>
					</tr>
					<tr>
						<td class="span3"><input name="socialSiteName" type="hidden"
							value="LinkedIn" /><strong>LinkedIn</strong></td>
						<td class="span3"><input name="socialNetworkName" type="text"></td>
					</tr>
					<tr>
						<td class="span3"><input name="socialSiteName" type="hidden"
							value="Facebook" /><strong>Facebook</strong></td>
						<td class="span3"><input name="socialNetworkName" type="text"></td>
					</tr>
					<tr>
						<td class="span3"><input name="socialSiteName" type="hidden"
							value="Twitter" /><strong>Twitter</strong></td>
						<td class="span3"><input name="socialNetworkName" type="text"></td>
					</tr>
					<tr id="socialButtonRow">
						<td style="border-top: none"><input id="addMoreSocialbtn"
							type="button" value="Add More Social Network"></td>
					</tr>
				</table>
				<input style="margin: 30px 30px 10px 120px;" type="submit"
					value="update">
			</form>
		</div>
	</div>
</body>
</html>