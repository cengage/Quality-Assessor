<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src='js/jquery/jquery.min.js' type="text/javascript"></script>
<script type="text/javascript" src="js/jquery/showRadarChart.js"></script>
<link href="css/common.css" type="text/css" rel="stylesheet">
</head>

<body>
	<%@include file="/header.jsp"%>
	<div class="background container">
	<div style="font-size:18px;padding:43px"><label><strong>Domain Assessment in form of Radar Chart</strong></label></div>
		<div align="center">
			<img id="radarChartId" src="radarChart" />
		</div>
	</div>
</body>
</html>