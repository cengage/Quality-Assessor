$(function() {
	
	$(".autoCompleteWiki").live('click',function(){$(".autoCompleteWiki").autocomplete(autocomplete_opts)});
	
		function log( message ) {
			$( "<div/>" ).text( message ).prependTo( "#log" );
			$( "#log" ).scrollTop( 0 );
		}

		var autocomplete_opts = {
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
				//alert('select');
				title = ui.item.label.trim();
				$(this).val(title);
				checkIfDomainAlreadyExist(title);
				
			},
			open: function() {
				$( this ).removeClass( "ui-corner-all" ).addClass( "ui-corner-top" );
			},
			close: function() {
				$( this ).removeClass( "ui-corner-top" ).addClass( "ui-corner-all" );
			}
		};
	});