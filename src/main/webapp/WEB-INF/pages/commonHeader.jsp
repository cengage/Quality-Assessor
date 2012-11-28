<script src="js/jquery/jquery.min.js"></script>
<style type="text/css">
.topNavigation {
	
}

.leftNavigation {
	float: left;
	width: 15%;
	background: none repeat scroll 0 0 #595959;
	height : 700px;
	margin : 2px -1px 0 2px;
}

.content {
	float: left;
	width: 84%;
	height: 700px;
	background: white;
	margin: 2px;
/* 	border-radius: 3px; */
	overflow: auto;
	border :1px solid #ccc;
}

.body {
	height: 700px;
}
</style>
<link href="/qualityassessor/css/header.css" type="text/css"
	rel='stylesheet' />
	
<script>
$(function(){
// 	$('.divNavigation').click(function(){
// 		alert("click");
// 		$(this).css("background","#333333");
// 	});
	
	$('#cssmenu ul > li').click(function(){
		if($(this).hasClass("level-2")){
			parentLi = $(this).parent().parent();
			alert(parentLi.index());
		}
		else{
			alert($(this).index());
		}
	});
});
</script>

