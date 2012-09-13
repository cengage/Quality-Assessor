$(function() {
	$.ajax({
		type : 'GET',
		url : 'domainHierarchy?key=10&requestedUserId=null',
		success : function(data) {
			var ul = "";
			ul += '<table id="excelId">';
			data = JSON.parse(data);
			ul += "<tr><td>" + data.title + "</td></tr>"
			children = data.children;

			// Second Level
			if (children != null) {

				var arr = children;
				for (i = 0; i < arr.length; i++) {
					obj = arr[i];
					// ul += "<tr childCount=0><td></td><td>"
					// + obj.title
					// + "</td><td></td><td><img class='toggle'
					// src='images/whitestar.gif'></img><img
					// class='toggle'
					// src='images/whitestar.gif'></img><img
					// class='toggle'
					// src='images/whitestar.gif'></img><img
					// class='toggle'
					// src='images/whitestar.gif'></img><img
					// class='toggle'
					// src='images/whitestar.gif'></img></td></tr>";
					children = obj.children;

					// Third Level
					if (children != null) {

						ratingStarHtml = getRatingStarHtml(obj.score);
						ul += "<tr childCount=" + children.length
								+ "><td></td><td>" + obj.title
								+ "</td><td></td><td score=" + obj.score
								+ " id=p" + i + ">" + ratingStarHtml
								+ "</td></tr>";
						ul += "<tr></tr>";
						var arr1 = children;
						for (j = 0; j < arr1.length; j++) {
							obj1 = arr1[j];

							score = obj1.score;
							weightage = obj1.weightage;
							key = obj1.key;
							ratingStarHtml = getRatingStarHtml(score);
							// for (k = 0; k < score; k++) {
							// ratingStarHtml = ratingStarHtml
							// + "<img class='toggle'
							// src='images/yellowstar.png'></img>";
							// }
							//
							// var noOfWhiteStars = 5 - score;
							// for (m = 0; m < noOfWhiteStars; m++) {
							// ratingStarHtml = ratingStarHtml
							// + "<img class='toggle'
							// src='images/whitestar.gif'></img>";
							// }
							ul += "<tr><td></td><td></td><td  i=" + i + " j="
									+ j + ">" + obj1.title
									+ "</td><td  assessmentId="
									+ obj.assessmentId + " id=" + key
									+ " parentId=p" + i + " weightage="
									+ weightage + " score=" + score + ">"
									+ ratingStarHtml + "</td></tr>";

						}
						ul += "<tr></tr>";
					} else {
						ratingStarHtml = getRatingStarHtml(obj.score);
						ul += "<tr childCount=0><td></td><td>" + obj.title
								+ "</td><td></td><td assessmentId="
								+ obj.assessmentId + " id=" + obj.key + ">"
								+ ratingStarHtml + "</td></tr>";
					}

				}

			}
			ul += '</table>'
			$('#excelDivId').append(ul);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			// showErrorMessage(jqXHR.responseText, "450", "300");
		},
		dataType : 'text'
	});

});

function getRatingStarHtml(score) {
	alert("rating score" + score);
	ratingStarHtml = "";
	score = Math.round(score);
	for (k = 0; k < score; k++) {
		ratingStarHtml = ratingStarHtml
				+ "<img class='toggle'  src='images/yellowstar.png'></img>";
	}

	var noOfWhiteStars = 5 - score;
	for (m = 0; m < noOfWhiteStars; m++) {
		ratingStarHtml = ratingStarHtml
				+ "<img class='toggle'  src='images/whitestar.gif'></img>";
	}
	return ratingStarHtml;
}

$(".toggle").live('click', function() {
	previousScore = $(this).index();
	score = previousScore;
	if ($(this).attr('src') == 'images/whitestar.gif') {
		$(this).attr('src', "images/yellowstar.png");
		$(this).prevAll().attr('src', "images/yellowstar.png");
		score = $(this).index() + 1;
		// var node = $("#tree").dynatree("getActiveNode");
		// saveRating(node, score, requestedUserId);
	} else {
		// alert($(this).index());
		$(this).attr('src', "images/whitestar.gif");
		$(this).nextAll().attr('src', "images/whitestar.gif");
		score = $(this).index() - 1;
		if (score == -1) {
			score = 0;
		}
		// alert(score);

		// var node = $("#tree").dynatree("getActiveNode");
		// saveRating(node, score, requestedUserId);

	}
	$(this).parent().attr("score", score);
	id = $(this).parent().attr("id");
	assessmentId = $(this).parent().attr("assessmentId");
	parentId = $(this).parent().attr("parentId");
	if (parentId != null) {
		weightage = $(this).parent().attr("weightage");
		parentScore = (score - previousScore) * weightage / 100;
		parentPrevScore = $('#' + parentId).attr("score");
		updatedScore = parseFloat(parentPrevScore) + parentScore;
		alert(updatedScore);
		$('#' + parentId).attr("score", updatedScore);
		$('#' + parentId).html(getRatingStarHtml(updatedScore));
		alert(score);
	}
	saveRating(id, assessmentId, score, "null");
	// else {
	// if (($(this).next().length == 0)
	// || ($(this).next().attr('src') == 'images/whitestar.gif')) {
	// $(this).attr('src', "images/whitestar.gif");
	// score = $(this).index();
	// }
	// }
});

$(function() {
	$('td').live(
			'click',
			function() {
				var colIndex = $(this).parent().children().index($(this));
				var rowIndex = $(this).parent().parent().children().index(
						$(this).parent());
				alert('Row: ' + rowIndex + ', Column: ' + colIndex);
			});
});

function saveRating(id, assessmentId, updatedScore, requestedUserId) {
	// alert(score);
	var data = {
		key : id,
		score : updatedScore,
		id : assessmentId,
		requestedUserId : requestedUserId
	};
	var url = 'rate';
	$.ajax({
		type : 'POST',
		url : url,
		data : data,
		success : function(assessmentId) {

		},
		error : function(jqXHR, textStatus, errorThrown) {
			// showErrorMessage(jqXHR.responseText, "450", "300");
		},
		dataType : 'text'
	});
}