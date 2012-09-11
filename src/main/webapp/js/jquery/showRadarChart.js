function getURLParameter(name) {
	return decodeURI((RegExp(name + '=' + '(.+?)(&|$)').exec(location.search) || [
			, null ])[1]);
}

$(function() {
	var key = getURLParameter("key");
	$('#radarChartId').attr("src", "radarChart?key=" + key);
});