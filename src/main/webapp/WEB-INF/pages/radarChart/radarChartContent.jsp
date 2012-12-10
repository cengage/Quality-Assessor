<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Assessment Chart</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src='../../js/jquery/jquery.min.js' type="text/javascript"></script>
<script type="text/javascript" src="../../js/jquery/radarChart.js"></script>
<link href="../../css/common.css" type="text/css" rel="stylesheet">
<style type="text/css">


/** 
 * While we're having the loading class set.
 * Removig it, will remove the loading message
 */
 .loading { 
   background: url(../../images/image-loader.gif) no-repeat center center; 
   height : 200px;
 }
</style>
</head>

<body>
	
	

	
	<div align="center" style="font-size:18px;padding:43px"><label><strong id="headingMsg">Assessment for ${requestScope.domainName}</strong></label></div>
	<div align="center" id="loader" class="loading"  >
		<img  id='radarImage' >
		</div>

	
</body>
</html>