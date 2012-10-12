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
								+ "<td class='titleClass' class='addBorder' ><span class='spanTitle'>"
								+ data[i].title
								+ "</span><input style='display:none' "
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
						+ requestedUserId,
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
										+ "><td colspan='5' style='border-top:none;border-bottom:none;'></td><td class='iconWidth'><img class='newDomain' src='images/new.png'/></td><td class='iconWidth'><img class='editDomain' src='images/edit.png'/></td><td class='iconWidth'><img class='deleteDomain' src='images/cross.png'/></td><td class='titleClass'><span class='spanTitle'>"
										+ obj.title
										+ "</span> "
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
											+ "><span class='spanTitle'>"
											+ obj1.title
											+ "</span><input style='display:none' class='autoCompleteWiki' type='text' value='"
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
										+ "' childCount=0><td colspan='5' style='border-top:none;border-bottom:none;'></td><td class='iconWidth'><img class='newDomain' src='images/new.png'/></td><td class='iconWidth'><img class='editDomain' src='images/edit.png'/></td><td class='iconWidth'><img class='deleteDomain' src='images/cross.png'/></td><td class='titleClass'><span class='spanTitle'>"
										+ obj.title
										+ "</span><input style='display:none' class='autoCompleteWiki' type='text' value='"
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
		var row = $(this).closest('tr');
		var titleInput = row.find('.autoCompleteWiki');
		titleInput.show();
		var spanTitle = row.find('.spanTitle');
		spanTitle.hide();
		var weightageInput = row.find('.inputWeightage');
		weightageInput.removeClass("addBorder");
		weightageInput.attr('readonly', false);
		$(this).attr("src", "images/save.png");
		$(this).parent().prev().children().hide();
		$(this).removeClass("editDomain");
		$(this).addClass("saveDomain");

	});

	$(".saveDomain")
			.live(
					'click',
					function() {
						var row = $(this).closest('tr');
						var titleInput = row.find('.autoCompleteWiki');
						var title = titleInput.val();
						var spanTitle = row.find('.spanTitle');
						spanTitle.html(title);
						spanTitle.show();
						titleInput.hide();
						var weightageInput = row.find('.inputWeightage');
						var weightage = weightageInput.val();

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
							alert("Total sum of subdomain's weightage under a domain can't be greater than 100");
							return;
						}

						// row.find('input').attr('readonly',true);

						saveDomain(key, parentKey, title, weightage, row);
						weightageInput.addClass("addBorder");
						weightageInput.attr('readonly', 'readonly');
						$(this).attr("src", "images/edit.png");
						$(this).addClass("editDomain");
						$(this).parent().prev().children().show();
						$(this).removeClass("saveDomain");

						var expandImg = row.find('.expandDomain');

						if (expandImg.is(":hidden")) {
							expandImg.show(); // hide button
						}

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
						var row = $(this).closest('tr');
						var cell = $(this).closest('td');
						var ppid = row.attr("pid");
						var pid = row.attr("id");
						if (ppid == '0') {
							expandDomain = row.find('.expandDomain');
							if (expandDomain.length > 0) { // if domain not
															// expanded then
															// first expand it
								var table = $(this).closest('table');
								showCompleteDomainTree(pid, table);
								expandDomain.attr("src", "images/collapse.png");
								expandDomain.removeClass("expandDomain");
								expandDomain.addClass("collapseDomain");
							}
						}

						var colspan = cell.prev().attr("colspan");
						if (colspan == 5) {
							var tr = "<tr id='new' pid='"
									+ pid
									+ "'><td class='iconWidth' colspan='11'></td>"
									+ "<td class='iconWidth'><img class='saveDomain' src='images/save.png'></td>"
									+ "<td  class='iconWidth'><img class='deleteDomain' src='images/cross.png'/></td>"
									+ "<td class='titleClass'><span class='spanTitle'></span><input class='autoCompleteWiki' type='text'></td>"
									+ "<td><input class='inputWeightage' type='text'></td></tr>";
							row.after(tr);
						} else {
							var tr = "<tr id='new' pid='"
									+ pid
									+ "'><td colspan='5'></td><td  class='iconWidth'><img style='display:none'  class='newDomain' src='images/new.png'/></td>"
									+ "<td class='iconWidth'><img class='saveDomain' src='images/save.png'></td>"
									+ "<td  class='iconWidth'><img class='deleteDomain' src='images/cross.png'/></td>"
									+ "<td class='titleClass'><span class='spanTitle'></span><input class='autoCompleteWiki' type='text'></td>"
									+ "<td><input class='inputWeightage' type='text'></td></tr>";
							row.after(tr);
						}
					});

	$(".deleteDomain").live('click', function() {

		var row = $(this).closest('tr');
		var table = $(this).closest('table');
		var key = row.attr("id");
		var data = {
			key : key
		};
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

				var parentKey = row.attr("pid");
				if (key != 'new') {
					deleteDomain(key, parentKey, table, row);
				}

			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert(jqXHR.responseText);
			},
			dataType : 'json'
		});

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

});

function showAddRootDomainView() {
	var table = "";
	table += "<table style='margin-top:15px;width:100%;' class='imagetable' id='tableId'>";
	table += "<tr id='0' pid='0'><td class='iconWidth'><img style='display:none' class='expandDomain' src='images/expand.png'/></td>"
			+ "<td class='iconWidth'><img style='display:none' class='newDomain' src='images/new.png'/></td>"
			+ "<td class='iconWidth'><img class='saveDomain' src='images/save.png'/></td>"
			+ "<td class='iconWidth'><img class='deleteDomain' src='images/cross.png'/></td>"
			+ "<td class='titleClass'><span class='spanTitle'></span><input class='autoCompleteWiki' size='30' type='text'></td>"
			+ "<td></td><td></td><td></td></tr>"
	$('#domainDivId').prepend(table);
}

function saveDomain(key, parentKey, title, weightage, row) {
	if (weightage == undefined) {
		weightage = '100';
	}
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
//				$(currentObj).attr("src", "images/collapse.png");
//				$(currentObj).removeClass("expandDomain");
//				$(currentObj).addClass("collapseDomain");
			} else {
				table.remove();
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert(jqXHR.responseText);
		},
		dataType : 'text'
	});
}


function checkIfDomainAlreadyExist(domainName){
	var data = {
			name:domainName
		}
		
		var url = 'getDomain';
		$.ajax({
			type : 'GET',
			url : url,
			data : data,
			success : function(data) {
				if(data == null)
					return ;
				
				var existingDomainDiv = $("#existingDomainDiv");
				var headerDiv = $("<div><span style='font-weight:bold'>Following Domains already exist with specified name." +
						"</span><br><span style='font-weight:bold'>If you want to use existing one then select the checkbox infront of domain.</span>" +
						"</div>");
				existingDomainDiv.append(headerDiv);
				var domainDiv = $("<div style='margin-top:10px' id ='domainDiv'></div>");
				var orderList = $("<ol></ol>");
				for(i=0;i<data.length;i++){
					orderList.append("<li><input type='checkbox' value='"+data[i].id+"'>" +
							"<span>"+data[i].name+"</span></li>");
				}
				domainDiv.append(orderList);
				existingDomainDiv.append(domainDiv);
				var buttonDiv = $("<div id ='buttonDiv'></div>");
				buttonDiv.append("<br>");
				buttonDiv.append("<input type=button value='Ok'>");
				buttonDiv.append("<input type=button value='Cancel'>")
				existingDomainDiv.append(buttonDiv);
				showDomainInColorbox();
				},
			error : function(jqXHR, textStatus, errorThrown) {
				alert(jqXHR.responseText);
			},
			dataType : 'json'
		});
		
}


function showDomainInColorbox(){
	$.colorbox({
		href : '#existingDomainDiv',
		open : true,
		inline:true,
		width : "600px",
		height : "380px",
		opacity : 0.9,
		onOpen:function(){ //triggers a callback when the lightbox opens
            $('#existingDomainDiv').show(); //when the lightbox opens, show the content div
         },
         onCleanup:function(){
        	var existingDomainDiv = $('#existingDomainDiv');
        	existingDomainDiv.children().remove();
        	existingDomainDiv.hide(); //hides the content div when the lightbox closes
        	
         }
		});
}
