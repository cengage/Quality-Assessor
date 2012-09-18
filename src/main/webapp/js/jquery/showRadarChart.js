function getURLParameter(name) {
	return decodeURI((RegExp(name + '=' + '(.+?)(&|$)').exec(location.search) || [
			, null ])[1]);
}

var domainName = '';
$(function() {
	var key = getURLParameter("key");
	var domainName = getURLParameter("domainName");
	// $('#radarChartId').attr("src", "radarChart?key=" + key);
	$('#headingMsg').html(
			"Assessment for " + domainName);
	var img = new Image();

	// wrap our new image in jQuery, then:
	$(img)
	// once the image has loaded, execute this code
	.load(function() {
		// set the image hidden by default
		$(this).hide();

		// with the holding div #loader, apply:
		$('#loader')
		// remove the loading class (so no background spinner),
		.removeClass('loading')
		// then insert our image
		.append(this);

		// fade our image in to create a nice effect
		$(this).fadeIn();
	})

	// if there was an error loading the image, react accordingly
	.error(function() {
		// notify the user that the image could not be loaded
	})

	// *finally*, set the src attribute of the new image to our image
	.attr('src', "radarChart?key=" + key);
});