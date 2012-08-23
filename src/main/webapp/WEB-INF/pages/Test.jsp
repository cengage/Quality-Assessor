<html lang="en">
<head>
	<meta charset="utf-8">
	<title>jQuery UI Autocomplete - Remote JSONP datasource</title>
	<link rel="stylesheet" href="css/jquery.ui.all.css">
	<script src='js/jquery/jquery.min.js'></script>
	<script src="js/jquery/jquery.ui.core.min.js"></script>
	<script src="js/jquery/jquery.ui.widget.min.js"></script>
	<script src="js/jquery/jquery.ui.position.min.js"></script>
	<script src="js/jquery/jquery.ui.autocomplete.min.js"></script>
	<link rel="stylesheet" href="css/autocomplete.css">
	<link rel="stylesheet" href="css/jquery.ui.autocomplete.css">
	<style>
	.ui-autocomplete-loading { background: white url('images/ui-anim_basic_16x16.gif') right center no-repeat; }
	#city { width: 25em; }
	</style>
	<script>
	$(function() {
		function log( message ) {
			$( "<div/>" ).text( message ).prependTo( "#log" );
			$( "#log" ).scrollTop( 0 );
		}

		$( "#city" ).autocomplete({
			source: function( request, response ) {
				$.ajax({
					url: "http://en.wikipedia.org/w/api.php",
					dataType: "jsonp",
					data: {
						action: "opensearch",
						search: "api",
						namespace: "0",
						limit : "10",
						search: request.term
					},
					success: function( data ) {
						dataStr = data.toString();
						dataArr =dataStr.split(",");
						dataArr.shift();
						response( $.map(dataArr, function( item ) {
							return {
								label: item,
								value: item
							}
						}));
					}
				});
			},
			minLength: 2,
			select: function( event, ui ) {
				alert(ui.item.label);
				log( ui.item ?
					"Selected: " + ui.item.label :
					"Nothing selected, input was " + this.value);
			},
			open: function() {
				$( this ).removeClass( "ui-corner-all" ).addClass( "ui-corner-top" );
			},
			close: function() {
				$( this ).removeClass( "ui-corner-top" ).addClass( "ui-corner-all" );
			}
		});
	});
	</script>
</head>
<body>

<div class="demo">

<div class="ui-widget">
	<label for="city">Your city: </label>
	<input id="city" />
	Powered by <a href="http://geonames.org">geonames.org</a>
</div>

<div class="ui-widget" style="margin-top:2em; font-family:Arial">
	Result:
	<div id="log" style="height: 200px; width: 300px; overflow: auto;" class="ui-widget-content"></div>
</div>

</div><!-- End demo -->



<div class="demo-description">
<p>The Autocomplete widgets provides suggestions while you type into the field. Here the suggestions are cities, displayed when at least two characters are entered into the field.</p>
<p>In this case, the datasource is the <a href="http://geonames.org">geonames.org webservice</a>. While only the city name itself ends up in the input after selecting an element, more info is displayed in the suggestions to help find the right entry. That data is also available in callbacks, as illustrated by the Result area below the input.</p>
</div><!-- End demo-description -->

</body>
</html>
