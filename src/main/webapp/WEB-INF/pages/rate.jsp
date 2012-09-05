<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/button.css" type="text/css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
img:hover {
	cursor: pointer;
}
</style>
<script src='js/jquery/jquery.min.js' type="text/javascript"></script>
<script src='js/jquery/rate.js' type="text/javascript"></script>
</head>
<body>
	<div align="center" style="margin: 40px 5px 5px">
		<h2 class="heading">Provide Rating for</h2>
		<div id="ratingContainer">

		</div>
		<div style="margin: 38px">
			<input class="btn primary" onclick="saveRating();" type="button"
				value="Submit" />
		</div>
	</div>

</body>
</html>