<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/common.css" rel="Stylesheet" type="text/css" />
<!-- Include the required JavaScript libraries: -->
<script src='../js/jquery/jquery.min.js' type="text/javascript"></script>
<script src='../js/jquery/jquery-ui.custom.min.js' type="text/javascript"></script>
<script src='../js/jquery/jquery.cookie.js' type="text/javascript"></script>
<script src='../js/jquery/jquery.dynatree.js' type="text/javascript"></script>
<script type="text/javascript" src="../js/jquery/domainHierarchyScript.js"></script>
<link type='text/css' rel='stylesheet' href='../css/table.css' />
<link type='text/css' rel='stylesheet' href='../css/style.css' />

<style>
tr {
	width: 800px;
	height: 32px;
}

td {
	width: 130px;
	height: 32px;
}
</style>
</head>
<body class="homeClass">
	<%@include file="/WEB-INF/pages/mainHeader.jsp"%>
	<div class="background container">
	<%@include file="/WEB-INF/pages/header.jsp"%>

		<br>
		
		<div style="float:left;margin-left: 27px; margin-top: 20px;margin-right:30px;margin-bottom:30px" id="excelDivId">
		<label ><strong>Click on the stars infront of domains to give rating of that domain</strong></label>
		</div>
		
		<div id="explanationStarId" style="margin-top:20px">
		<label><strong>Star Explanations</strong></label>
			<table style="margin-top:15px">
				<tr title="Unquestioned competence in a skill.  Industry leaders recognize this person's competence.  Can explain underlying forces to others; you've practiced this skill along side other experts AND you are journeying and possibly innovating in the skill domain.">
					<td style="width:32%"><img  src="../images/yellowstar.png"> <img
						 src="../images/yellowstar.png"> <img
						 src="../images/yellowstar.png"> <img
						 src="../images/yellowstar.png"> <img
						 src="../images/yellowstar.png"></td>
					<td style="width:20%">Mastering</td>
				</tr>
				<tr title=" Has used the skill in multiple environments, at least one of which is work; peers recognize this person's competence; you're here if peers from two different environments can vouch for you AND you are practicing">
					<td><img  src="../images/yellowstar.png"> <img
						 src="../images/yellowstar.png"> <img
						 src="../images/yellowstar.png"> <img
						 src="../images/yellowstar.png"> <img
						 src="../images/whitestar.gif"></td>
					<td>Journeying</td>
				</tr>
				<tr title="Actively using a skill at home, in a class or work environment; you're here if you can reference more than one resource that you've used to learn about this skill AND if you've used this in the last 30 days ">
					<td><img  src="../images/yellowstar.png"> <img
						 src="../images/yellowstar.png"> <img
						 src="../images/yellowstar.png"> <img
						 src="../images/whitestar.gif"> <img
						 src="../images/whitestar.gif"></td>
					<td>Practicing</td>
				</tr>
				<tr title="know what a skill is, no first-hand experience">
					<td><img  src="../images/yellowstar.png"> <img
						 src="../images/yellowstar.png"> <img
						 src="../images/whitestar.gif"> <img
						 src="../images/whitestar.gif"> <img
						 src="../images/whitestar.gif"></td>
					<td>Learning</td>
				</tr>
				<tr title="Not sure what a skill is,or why/when it would be needed ">
					<td><img  src="../images/yellowstar.png"> <img
						 src="../images/whitestar.gif"> <img
						 src="../images/whitestar.gif"> <img
						 src="../images/whitestar.gif"> <img
						 src="../images/whitestar.gif"></td>
					<td>Questioning</td>
				</tr>
			</table>
		</div>
	</div>
	<%@include file="/WEB-INF/pages/footer.jsp"%>
</body>
</html>