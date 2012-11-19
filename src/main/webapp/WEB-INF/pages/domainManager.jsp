<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Domain Manager</title>
<link href="css/common.css" rel="Stylesheet" type="text/css" />
<!-- Include the required JavaScript libraries: -->
<script src='js/jquery/jquery.min.js' type="text/javascript"></script>
<script src='js/jquery/jquery-ui.custom.min.js' type="text/javascript"></script>
<script src='js/jquery/jquery.cookie.js' type="text/javascript"></script>
<script src='js/jquery/jquery.dynatree.js' type="text/javascript"></script>
<script type="text/javascript" src="js/jquery/jquery.colorbox-min.js"></script>
<!-- <script type="text/javascript" src="js/jquery/homePageScript.js"></script> -->
<script src='js/json2/json2.js' type="text/javascript"></script>
<script type="text/javascript" src="js/jquery/domainManager.js"></script>
<script src="js/jquery/jquery.watermark.min.js"></script>
<link type='text/css' rel='stylesheet' href='css/colorbox.css' />
<link type='text/css' rel='stylesheet' href='css/button.css' />
<link type='text/css' rel='stylesheet' href='css/style.css' />
<link rel='stylesheet' type='text/css' href='css/skin/ui.dynatree.css'>
<script src="js/jquery/jquery.ui.autocomplete.min.js"></script>
<script src='js/jquery/autoCompleteScript.js'></script>
<link rel="stylesheet" href="css/jquery.ui.autocomplete.css">
<link rel="stylesheet" href="css/jquery.ui.all.css">
<style type="text/css">
.inputWeightage{
width:30px;
}

.addBorder{
border:1px;
}

.iconWidth{
width:2%;
}

img{
cursor:pointer;
}

.titleClass{

width:25%;
}

.spanTitle{
font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
    font-size: 13px;
    font-weight: normal;
    line-height: 18px;
}

.rootTitle:hover{
color:black;
text-decoration:underline;
cursor:pointer;

}


a{
color:black;
}



</style>
</head>

<body >

	<%@include file="/WEB-INF/pages/mainHeader.jsp"%>
	<div class="background container">
	<%@include file="/WEB-INF/pages/header.jsp"%>
	<div id="backgroundImg"></div>
	<div style="background: white; margin: 20px auto auto;
    width: 90%;">
	<div style="display:inline">
			<input class="btn primary" id="addMoreWorkExpbtn" type="button"
					onclick="location.reload();" value="My Domains">
				
		</div>
		<c:choose>
			<c:when test="${param.type=='product'}">
				<div style="display:inline">
					<input class="btn primary"  type="button"
					onclick="showAddRootDomainView('product')" value="Add Product Domain">
				</div>
			</c:when>
			<c:otherwise>
				<div style="display:inline">
					<input class="btn primary"  type="button"
						onclick="showAddRootDomainView('skill')" value="Add Skill Domain">
				</div>
			</c:otherwise>
		</c:choose>
		<div  style="margin-right:10px;float:right;display:inline">
			<input id="searchDomain" type="text" style="width:180px">
			<input id="searchDomainType" type="hidden" value="${param.type}">
		</div>
		</div>
		<p></p>
		<!-- Add a <div> element where the tree should appear: -->
		<div style="width:90%;margin:auto;" id="domainDivId"></div>
		<div style="display:none;margin-top:25px;margin-left:15px;margin-right:15px" id="existingDomainDiv">
		</div>
	</div>
	<%@include file="/WEB-INF/pages/footer.jsp"%>
</body>
</html>