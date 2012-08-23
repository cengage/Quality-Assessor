$(function() {
		function log( message ) {
			$( "<div/>" ).text( message ).prependTo( "#log" );
			$( "#log" ).scrollTop( 0 );
		}

		$( ".autoCompleteWiki" ).autocomplete({
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
				title = title.replace(" ", "_");
				$('.wikiLinkUpdate').attr("href","http://en.wikipedia.org/wiki/" + title);
				$('.wikiLinkUpdate').html("http://en.wikipedia.org/wiki/" + title);
//				alert(ui.item.label);
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