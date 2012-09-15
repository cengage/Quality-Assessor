<html>
<head>
<link href="css/common.css" rel="Stylesheet" type="text/css" />
<!-- Include the required JavaScript libraries: -->
<script src='js/jquery/jquery.min.js' type="text/javascript"></script>
<script src='js/jquery/jquery-ui.custom.min.js' type="text/javascript"></script>
<script src='js/jquery/jquery.cookie.js' type="text/javascript"></script>
<script src='js/jquery/jquery.dynatree.js' type="text/javascript"></script>
<script type="text/javascript" src="js/jquery/jquery.colorbox-min.js"></script>
<script type="text/javascript" src="js/jquery/excel.js"></script>
<link type='text/css' rel='stylesheet' href='css/colorbox.css' />
<link type='text/css' rel='stylesheet' href='css/table.css' />
<link type='text/css' rel='stylesheet' href='css/style.css' />
<link rel='stylesheet' type='text/css' href='css/skin/ui.dynatree.css'>
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
	<%@include file="/header.jsp"%>
	<div class="background container">


		<br>
		
		<div style="float:left;margin-left: 27px; margin-top: 20px;margin-right:30px" id="excelDivId">
		<label ><strong>Click on the stars infront of domains to give rating of that domain</strong></label>
		</div>
		
		<div id="explanationStarId" style="margin-top:20px">
		<label><strong>Star Explanations</strong></label>
			<table style="margin-top:15px">
				<tr>
					<td style="width:30%"><img class="toggle" src="images/yellowstar.png"> <img
						class="toggle" src="images/yellowstar.png"> <img
						class="toggle" src="images/yellowstar.png"> <img
						class="toggle" src="images/yellowstar.png"> <img
						class="toggle" src="images/yellowstar.png"></td>
					<td style="width:25%">Excellent</td>
				</tr>
				<tr>
					<td><img class="toggle" src="images/yellowstar.png"> <img
						class="toggle" src="images/yellowstar.png"> <img
						class="toggle" src="images/yellowstar.png"> <img
						class="toggle" src="images/yellowstar.png"> <img
						class="toggle" src="images/whitestar.gif"></td>
					<td>Very Good</td>
				</tr>
				<tr>
					<td><img class="toggle" src="images/yellowstar.png"> <img
						class="toggle" src="images/yellowstar.png"> <img
						class="toggle" src="images/yellowstar.png"> <img
						class="toggle" src="images/whitestar.gif"> <img
						class="toggle" src="images/whitestar.gif"></td>
					<td>Good</td>
				</tr>
				<tr>
					<td><img class="toggle" src="images/yellowstar.png"> <img
						class="toggle" src="images/yellowstar.png"> <img
						class="toggle" src="images/whitestar.gif"> <img
						class="toggle" src="images/whitestar.gif"> <img
						class="toggle" src="images/whitestar.gif"></td>
					<td>Bad</td>
				</tr>
				<tr>
					<td><img class="toggle" src="images/yellowstar.png"> <img
						class="toggle" src="images/whitestar.gif"> <img
						class="toggle" src="images/whitestar.gif"> <img
						class="toggle" src="images/whitestar.gif"> <img
						class="toggle" src="images/whitestar.gif"></td>
					<td>Very Bad</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>