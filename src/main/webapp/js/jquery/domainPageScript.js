function getURLParameter(name) {
	return decodeURI((RegExp(name + '=' + '(.+?)(&|$)').exec(location.search) || [
			, null ])[1]);
}

$(function() {
	var key = getURLParameter("key");
	$("#tree")
			.dynatree(
					{
						initAjax : {
							url : "domainHierarchy",
							data : {
								key : key, // Optional arguments to append to
								// the url
								mode : "all"
							}
						},
						// onLazyRead : function(node) {
						// node.appendAjax({
						// url : "domains",
						// data : {
						// "key" : node.data.key, // Optional url arguments
						// "mode" : "all"
						// }
						// });
						// },
						onCustomRender : function(node) {
							if ((node.data.score > 0)
									&& (node.getChildren() == null)) {
								title = node.data.title;
								return "<a style='color:green;cursor:pointer' class='dynatree-title'>"
										+ title + "</a>"
							}
						},
						onClick : function(node, event) {
							// alert(node.data.score);
							// alert(node.data.assessmentId);
							if ((node.getEventTargetType(event) == "title")
									&& (node.getChildren() == null)) {
								var parentKey = node.data.parentKey;
								var key = node.data.key;
								var title = node.data.title;
								var weightage = node.data.weightage;
								var score = node.data.score;
								var assessmentId = node.data.assessmentId;
								$.colorbox({
									href : 'rate?title=' + title + '&key='
											+ key + '&score=' + score
											+ '&assessmentId=' + assessmentId,
									open : true,
									iframe : true,
									width : "480px",
									height : "300px",
									opacity : 0.9,

								});

							}
						}

					});
});

function updateNode(score, assessmentId) {
	var node = $("#tree").dynatree("getActiveNode");
	node.data.score = score;
	node.data.assessmentId = assessmentId;
	node.render();
}