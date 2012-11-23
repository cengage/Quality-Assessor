<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<title>
</title>
<style type="text/css">
.topNavigation{

}

.leftNavigation{
float:left;
width:15%;
}

.content{
float:left;
width:67%;
height:99%;
background:white;
margin:3px;
border-radius:3px;
overflow:auto;
}


.body{
height:89%;
}

</style>

<tiles:insertAttribute name="header" />

</head>
<body>

<tiles:insertAttribute name="main-header" />

<div class="topNavigation">
<tiles:insertAttribute name="topNavigation" />
</div>

<div class="body">
<div class="leftNavigation">
<tiles:insertAttribute name="leftNavigation" />
</div>
 
<div class="content"> 
<tiles:insertAttribute name="content" />
</div>

</div>

<div class="footer">
<tiles:insertAttribute name="footer" />
</div>


</body>
</html>