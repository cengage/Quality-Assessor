<!DOCTYPE html>
<html>
<head>
<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>

<script>
$(function() {
	$( ".selector" ).autocomplete({ minLength: 8 });



$( "#city" ).autocomplete({
	source: function( request, response ) {
		$.ajax({
			url: "http://en.wikipedia.org/w/api.php",
			dataType: "jsonp",
			data: {
				action: "opensearch",
				search: request.term
			},
			success: function( data ) {
				alert(data);
				response( $.map( data.(request.term), function( item ) {
					alert(item);
					return {
						
						label: item.name + (item.adminName1 ? ", " + item.adminName1 : "") + ", " + item.countryName,
						value: item.name
					}
				}));
			}
		});
	},
	minLength: 2,
	select: function( event, ui ) {
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

}
);
	
// 	function autoComplete() {
// 		var value=$('#autocomplete').val();
// 		$.ajax({
// 			type : 'GET',
// 			url : 'http://en.wikipedia.org/w/api.php?action=opensearch&search='+value+'&callback=?',
// 			method: "serverCallback",
			
// 			success : function(data) {
// 				source =[];
				
// 				data=JSON.stringify(data);
// 				//alert(data);
// 				var n=data.split(",");
// 				source.push(n[1].substring(2,n[1].length-1));
// 				for(i=2;i<n.length-1;i++){
// 						source.push(n[i].substring(1,n[i].length-1));}
// 				source.push(n[n.length-1].substring(1,n[n.length-1].length-3));
// 				$("input#autocomplete").autocomplete({
					
// 				   source: source,
				
// 				});
				
// 			},
// 			error : function(jqXHR, textStatus, errorThrown) {
// 				// showMessage(jqXHR.responseText, "450", "300");
// 			},
// 			dataType : 'json'
// 		});

// 	}
</script>
</head>
<body style="font-size: 62.5%;">

	<input id="city"  />

</body>
</html>