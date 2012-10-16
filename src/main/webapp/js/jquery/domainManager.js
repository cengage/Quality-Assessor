function getURLParameter(name) {
	return decodeURI((RegExp(name + '=' + '(.+?)(&|$)').exec(location.search) || [
			, null ])[1]);
}

var requestedUserId = "null";

$(function() {

	$
			.ajax({
				type : 'GET',
				url : 'domains?key=0',
				success : function(data) {
					data = JSON.parse(data);
					for (i = 0; i < data.length; i++) {
						var table = "";
						table += "<table style='margin-top:15px;width:100%;' class='imagetable' id='tableId"
								+ i + "'>";
						table += "<tr pid='0' id="
								+ data[i].key
								+ "><td class='iconWidth'><img class='expandDomain' src='images/expand.png'/></td>"
								+ "<td class='iconWidth'><img class='newDomain' src='images/new.png'/></td>"
								+ "<td class='iconWidth'><img class='editDomain' src='images/edit.png'/></td>"
								+ "<td class='iconWidth'><img class='deleteDomain' src='images/cross.png'/></td>"
								+ "<td class='titleClass' class='addBorder' ><a class='wikiLink' target='_blank' href='http://en.wikipedia.org/wiki/"
								+ data[i].title
								+ "'><span class='spanTitle'>"
								+ data[i].title
								+ "</span></a><input style='display:none' "
								+ "class='autoCompleteWiki' type='text' value='"
								+ data[i].title + "'>"
								+ "</td><td></td><td></td><td></td></tr>"
						$('#domainDivId').append(table);
					}
				},
				error : function(jqXHR, textStatus, errorThrown) {
				},
				dataType : 'text'
			});

});

function showCompleteDomainTree(rootKey, table) {
	$
			.ajax({
				type : 'GET',
				url : 'domainHierarchy?key=' + rootKey + '&requestedUserId='
						+ requestedUserId+ '&fetchAssessment=false',
				success : function(data) {
					var ul = "";

					data = JSON.parse(data);

					children = data.children;

					// Second Level
					if (children != null) {

						var arr = children;
						for (i = 0; i < arr.length; i++) {
							obj = arr[i];

							children = obj.children;

							// Third Level
							if (children != null) {

								// alert(ratingStarHtml);
								ul += "<tr pid='"
										+ rootKey
										+ "' id='"
										+ obj.key
										+ "' "
										+ "><td colspan='5' style='border-top:none;border-bottom:none;'></td><td class='iconWidth'><img class='newDomain' src='images/new.png'/></td><td class='iconWidth'><img class='editDomain' src='images/edit.png'/></td>"
										+ "<td class='iconWidth'><img class='deleteDomain' src='images/cross.png'/></td><td class='titleClass'><a class='wikiLink' target='_blank' href='http://en.wikipedia.org/wiki/"
										+ obj.title
										+ "'><span class='spanTitle'>"
										+ obj.title
										+ "</span></a>"
										+ "<input style='display:none'  class='autoCompleteWiki' type='text' value='"
										+ obj.title
										+ "'></td><td><input  readonly='readonly' class='inputWeightage addBorder' type='text' value="
										+ obj.weightage
										+ "></td><td></td><td score="
										+ obj.score + " id=p" + i + ">"
										+ "</td></tr>";
								// ul += "<tr></tr>";
								var arr1 = children;
								for (j = 0; j < arr1.length; j++) {
									obj1 = arr1[j];

									score = obj1.score;
									weightage = obj1.weightage;
									key = obj1.key;

									ul += "<tr pid='"
											+ obj.key
											+ "' id='"
											+ obj1.key
											+ "'><td colspan='11' style='border-top:none;border-bottom:none;'></td><td class='iconWidth'><img class='editDomain' src='images/edit.png'/></td><td class='iconWidth'><img class='deleteDomain' src='images/cross.png'/></td><td class='titleClass'  i="
											+ i
											+ " j="
											+ j
											+ "><a class='wikiLink' target='_blank' href='http://en.wikipedia.org/wiki/"
											+ obj1.title
											+ "'><span class='spanTitle'>"
											+ obj1.title
											+ "</span></a><input style='display:none' class='autoCompleteWiki' type='text' value='"
											+ obj1.title
											+ "'></td><td><input  readonly='readonly' class='addBorder inputWeightage' type='text' value="
											+ obj1.weightage + "></td></tr>";

								}
								// ul += "<tr></tr>";
							} else {

								ul += "<tr pid='"
										+ rootKey
										+ "' id='"
										+ obj.key
										+ "' childCount=0><td colspan='5' style='border-top:none;border-bottom:none;'></td><td class='iconWidth'><img class='newDomain' src='images/new.png'/></td><td class='iconWidth'><img class='editDomain' src='images/edit.png'/></td>"
										+ "<td class='iconWidth'><img class='deleteDomain' src='images/cross.png'/></td><td class='titleClass'><a class='wikiLink' target='_blank' href='http://en.wikipedia.org/wiki/"
										+ obj.title
										+ "'><span class='spanTitle'>"
										+ obj.title
										+ "</span></a><input style='display:none' class='autoCompleteWiki' type='text' value='"
										+ obj.title
										+ "'></td><td><input readonly='readonly'  class='inputWeightage addBorder'  type='text' value="
										+ obj.weightage
										+ "></td><td></td><td assessmentId="
										+ obj.assessmentId + " id=" + obj.key
										+ ">" + "</td></tr>";
							}

						}

					}
					// ul += '</table>'
					table.append(ul);
				},
				error : function(jqXHR, textStatus, errorThrown) {
					// showErrorMessage(jqXHR.responseText, "450", "300");
				},
				dataType : 'text'
			});
}

$(function() {

	$(".editDomain").live('click', function() {

		if (checkIfOperationPending() == true) {
			alert("Please save or close already open domain");
			return;
		}

		var row = $(this).closest('tr');
		row.addClass("currentSelectedRow");
		var key = row.attr("id");
		var data = {
			key : key
		};
		var currentObj = this;
		$.ajax({
			type : 'POST',
			url : 'hasUpdateOrDeletePermission',
			data : data,
			success : function(data) {
				if (data.success == false) {
					alert(data.message);
					return;
				} else {
					var titleInput = row.find('.autoCompleteWiki');
					titleInput.show();
					var spanTitle = row.find('.spanTitle');
					spanTitle.hide();
					var weightageInput = row.find('.inputWeightage');
					weightageInput.removeClass("addBorder");
					weightageInput.attr('readonly', false);
					$(currentObj).attr("src", "images/save.png");
					$(currentObj).parent().prev().children().hide();
					$(currentObj).removeClass("editDomain");
					$(currentObj).addClass("saveDomain");
				}
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert(jqXHR.responseText);
			},
			dataType : 'json'
		});

	});

	$(".saveDomain")
			.live(
					'click',
					function() {
						var row = $(this).closest('tr');
						var titleInput = row.find('.autoCompleteWiki');
						var title = titleInput.val();
						
						var weightageInput = row.find('.inputWeightage');
						var weightage = weightageInput.val();
						if (weightage == undefined) {
							weightage = '100';
						}
						
						if(title==''){
							alert("Domain name can't be blank");
							return;
						}
						if(weightage==''){
							alert("Weighing can't be blank and must be numeric");
							return;
						}
						
						var key = row.attr("id");
						if (key == 'new') {
							key = '0';
						}
						var parentKey = row.attr("pid");

						var table = $(this).closest('table');
						var rows = table.find("tr[pid='" + parentKey + "']");
						sum = 0;

						rows.each(function(index) {
							sum = sum
									+ parseInt($(this).find('.inputWeightage')
											.val());
						});

						if (sum > 100) {
							alert("Total sum of subdomain's Weighing under a domain can't be greater than 100");
							return;
						}

						// row.find('input').attr('readonly',true);
						var currentObj = this;
						saveDomain(key, parentKey, title, weightage, row,
								currentObj);

					});

	$(".expandDomain").live('click', function() {
		key = $(this).closest('tr').attr("id");
		var table = $(this).closest('table');
		showCompleteDomainTree(key, table);
		$(this).attr("src", "images/collapse.png");
		$(this).removeClass("expandDomain");
		$(this).addClass("collapseDomain");
	});

	$(".collapseDomain").live('click', function() {
		var table = $(this).closest('table');
		table.find("tr:gt(0)").remove();
		$(this).attr("src", "images/expand.png");
		$(this).removeClass("collapseDomain");
		$(this).addClass("expandDomain");

	});

	$(".newDomain")
			.live(
					'click',
					function() {
						
						if (checkIfOperationPending() == true) {
							alert("Please save or close already open domain");
							return;
						}
						
						var row = $(this).closest('tr');
						var cell = $(this).closest('td');
						var ppid = row.attr("pid");
						var pid = row.attr("id");

						var currentObj = this;
						var data = {
							key : pid
						};
						$
								.ajax({
									type : 'POST',
									url : 'hasUpdateOrDeletePermission',
									data : data,
									success : function(data) {
										if (data.success == false) {
											alert(data.message);
											return;
										} else {
											if (ppid == '0') {
												expandDomain = row
														.find('.expandDomain');
												if (expandDomain.length > 0) { // if
																				// domain
																				// not
													// expanded then
													// first expand it
													var table = $(currentObj)
															.closest('table');
													showCompleteDomainTree(pid,
															table);
													expandDomain
															.attr("src",
																	"images/collapse.png");
													expandDomain
															.removeClass("expandDomain");
													expandDomain
															.addClass("collapseDomain");
												}
											}

											var colspan = cell.prev().attr(
													"colspan");
											if (colspan == 5) {
												var tr = "<tr class='currentSelectedRow' id='new' pid='"
														+ pid
														+ "'><td class='iconWidth' colspan='11'></td>"
														+ "<td class='iconWidth'><img class='saveDomain' src='images/save.png'></td>"
														+ "<td  class='iconWidth'><img class='deleteDomain' src='images/cross.png'/></td>"
														+ "<td class='titleClass'><a class='wikiLink' target='_blank' href=''><span class='spanTitle'></a></span><input class='autoCompleteWiki' type='text'></td>"
														+ "<td><input class='inputWeightage' type='text'></td></tr>";
												row.after(tr);
											} else {
												var tr = "<tr class='currentSelectedRow' id='new' pid='"
														+ pid
														+ "'><td colspan='5'></td><td  class='iconWidth'><img style='display:none'  class='newDomain' src='images/new.png'/></td>"
														+ "<td class='iconWidth'><img class='saveDomain' src='images/save.png'></td>"
														+ "<td  class='iconWidth'><img class='deleteDomain' src='images/cross.png'/></td>"
														+ "<td class='titleClass'><a class='wikiLink' target='_blank' href=''><span class='spanTitle'></span></a><input class='autoCompleteWiki' type='text'></td>"
														+ "<td><input class='inputWeightage' type='text'></td></tr>";
												row.after(tr);
											}
										}
									},
									error : function(jqXHR, textStatus,
											errorThrown) {
										alert(jqXHR.responseText);
									},
									dataType : 'json'
								});

					});

	$(".deleteDomain").live('click', function() {

		var row = $(this).closest('tr');
		var table = $(this).closest('table');
		var key = row.attr("id");
		var data = {
			key : key
		};
		var parentKey = row.attr("pid");
		if (key != 'new') {
			$.ajax({
				type : 'POST',
				url : 'hasUpdateOrDeletePermission',
				data : data,
				success : function(data) {
					if (data.success == false) {
						alert(data.message);
						return;
					}
					if (!confirm('Are you sure you want to delete domain?')) {
						return;
					}
					deleteDomain(key, parentKey, table, row);
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert(jqXHR.responseText);
				},
				dataType : 'json'
			});
		} else {
			if (parentKey != '0') {
				row.remove();
				table.find("tr[pid='" + key + "']").remove();
			} else {
				table.remove();
				row.removeClass("currentSelectedRow");
			}

		}

	});

	$(".inputWeightage").live(
			'keydown',
			function(evt) {
				{
					var charCode = evt.keyCode;

					if ((charCode > 47 && charCode < 58)
							|| (charCode > 95 && charCode < 106)
							|| (charCode == 8) || (charCode == 9)
							|| (charCode == 12) || (charCode == 27)
							|| (charCode == 37) || (charCode == 39)
							|| (charCode == 46)) {
						return true;
					}

					return false;
				}
			});

	// $("selectedDomainBtn").live('click', function() {
	//		
	// });

});

function showAddRootDomainView() {
	var table = "";
	table += "<table style='margin-top:15px;width:100%;' class='imagetable' id='tableId'>";
	table += "<tr class='currentSelectedRow' id='new' pid='0'><td class='iconWidth'><img style='display:none' class='expandDomain' src='images/expand.png'/></td>"
			+ "<td class='iconWidth'><img style='display:none' class='newDomain' src='images/new.png'/></td>"
			+ "<td class='iconWidth'><img class='saveDomain' src='images/save.png'/></td>"
			+ "<td class='iconWidth'><img class='deleteDomain' src='images/cross.png'/></td>"
			+ "<td class='titleClass'><span class='spanTitle expandDomain'></span><input class='autoCompleteWiki' size='30' type='text'></td>"
			+ "<td></td><td></td><td></td></tr>"
	$('#domainDivId').prepend(table);
}

function saveDomain(key, parentKey, title, weightage, row, currentObj) {
	
	data = '0';
	var data = {
		key : key,
		parentKey : parentKey,
		title : title,
		weightage : weightage
	};
	var url = 'saveOrUpdateDomain';
	$.ajax({
		type : 'POST',
		url : url,
		data : data,
		success : function(data) {
			if (key == '0') {
				row.attr("id", data);
			}
			
			var spanTitle = row.find('.spanTitle');
			var wikiLink = row.find('.wikiLink');
			spanTitle.html(title);
			spanTitle.show();
			wikiLink.attr("href", "http://en.wikipedia.org/wiki/"
					+ title);
			var titleInput = row.find('.autoCompleteWiki');
			titleInput.hide();
			
			row.removeClass("currentSelectedRow");
			var weightageInput = row.find('.inputWeightage');
			weightageInput.addClass("addBorder");
			weightageInput.attr('readonly', 'readonly');
			$(currentObj).attr("src", "images/edit.png");
			$(currentObj).addClass("editDomain");
			$(currentObj).parent().prev().children().show();
			$(currentObj).removeClass("saveDomain");

			var expandImg = row.find('.expandDomain');

			if (expandImg.is(":hidden")) {
				expandImg.show(); // hide button
			}

		},
		error : function(jqXHR, textStatus, errorThrown) {
			// showErrorMessage(jqXHR.responseText, "450", "300");
		},
		dataType : 'text'
	});
	return data;
}

function deleteDomain(key, parentKey, table, row) {

	var data = {
		key : key,
		parentKey : parentKey
	}

	var url = 'deleteDomain';
	$.ajax({
		type : 'POST',
		url : url,
		data : data,
		success : function(data) {
			if (parentKey != '0') {
				row.remove();
				table.find("tr[pid='" + key + "']").remove();
				// $(currentObj).attr("src", "images/collapse.png");
				// $(currentObj).removeClass("expandDomain");
				// $(currentObj).addClass("collapseDomain");
			} else {
				table.remove();
			}
			row.removeClass("currentSelectedRow");
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert(jqXHR.responseText);
		},
		dataType : 'text'
	});
}

function checkIfDomainAlreadyExist(domainName, row) {
	var data = {
		name : domainName
	}

	var url = 'getDomain';
	$
			.ajax({
				type : 'GET',
				url : url,
				data : data,
				success : function(data) {
					if (data == null || data.length == 0)
						return;

					var existingDomainDiv = $("#existingDomainDiv");
					var headerDiv = $("<div><span style='font-weight:bold'>Following Domains already exist with specified name."
							+ "</span><br><span style='font-weight:bold'>If you want to use existing one then select the checkbox infront of domain.</span>"
							+ "</div>");
					existingDomainDiv.append(headerDiv);
					var domainDiv = $("<div style='margin-top:10px' id ='domainDiv'></div>");
					// var orderList = $("<ol></ol>");
					// for(i=0;i<data.length;i++){
					// orderList.append("<li><input type='radio'
					// name='selectedDomain' value='"+data[i].key+"'>" +
					// "<span>"+data[i].title+"</span></li>");
					// }

					var html = "";
					// alert(data.length);
					for ( var n = 0; n < data.length; n++) {
						// alert(data[i].title);
						html += "<ol>";
						html += "<li style='list-style:none'>";
						html += "<input type='radio' name='selectedDomain' value='"
								+ data[n].key + "'>";
						html += "<span>" + data[n].title + "</span>";
						var children = data[n].children;
						if (children != null) {
							html += printValues(children, "");
						}
						html += "</li>";
						html += "</ol>";
						// alert("finished" + n + html);
					}
					// alert(html);
					domainDiv.append(html);

					// domainDiv.append(orderList);
					existingDomainDiv.append(domainDiv);
					var buttonDiv = $("<div id ='buttonDiv'></div>");
					buttonDiv.append("<br>");
					buttonDiv
							.append("<input type='button' onclick='updateIdOfDomain()' id='selectedDomainBtn'  value='Ok'>");
					buttonDiv.append("<input type='button' value='Cancel'>")
					existingDomainDiv.append(buttonDiv);
					showDomainInColorbox();
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert(jqXHR.responseText);
				},
				dataType : 'json'
			});

}

function hello(row) {
	alert('hello');
}

function updateIdOfDomain() {
	var value = $('input:radio[name=selectedDomain]:checked').val();
	$('.currentSelectedRow').attr('id', value);
	$.fn.colorbox.close();
	// row.attr();
}

function printValues(data, html) {

	for ( var j = 0; j < data.length; j++) {
		html += "<ol>";
		html += "<li style='list-style:none;margin-left:25px'>";
		// alert(data[i].title);
		// alert(data[i].children);
		html += "<span>" + data[j].title + "</span>";

		if (data[j].children != null) {
			html = printValues(data[j].children, html);
		} else {
			html += "</li>";
		}
		html += "</ol>";

	}
	return html;
}

function showDomainInColorbox() {
	$.colorbox({
		href : '#existingDomainDiv',
		open : true,
		inline : true,
		width : "780px",
		height : "580px",
		opacity : 0.9,
		onOpen : function() { // triggers a callback when the lightbox opens
			$('#existingDomainDiv').show(); // when the lightbox opens, show the
			// content div
		},
		onCleanup : function() {
			var existingDomainDiv = $('#existingDomainDiv');
			existingDomainDiv.children().remove();
			existingDomainDiv.hide(); // hides the content div when the
			// lightbox closes

		}
	});
}

function checkIfOperationPending() {
	if ($('.currentSelectedRow').length > 0) {
		return true;
	} else
		return false;
}
