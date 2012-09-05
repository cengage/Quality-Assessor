$(document)
		.ready(
				function() {
					$('#addMoreWorkExpbtn')
							.click(
									function() {
										var num = $('.cloneWorkExpTexts').length; // how
										var id=num-1;
//										alert(id);
										
//										var title = $('#workExpTexts'+ id+ " td input.title").attr('name');
//										alert(title);
//										var areaOfExperience = $('#workExpTexts'+ id+ " td input.areaOfExperience").attr('name');
//										var roleDescription = $('#workExpTexts'+ id+ " td input.roleDescription").attr('name');
//										var fromDatepicker = $('#workExpTexts'+ id+ " td input.fromDatepicker").attr('name');
//										var toDatepicker = $('#workExpTexts'+ id+ " td input.toDatepicker").attr('name');
										
										
										
										var newNum = new Number(num ); // the
										
//										 title= title.replace(/\[.*?\]/g, '['+(newNum-1)+']');
//										 //alert(title);
//										 areaOfExperience= areaOfExperience.replace(/\[.*?\]/g, '['+(newNum-1)+']');
//										 roleDescription= roleDescription.replace(/\[.*?\]/g, '['+(newNum-1)+']');
//										 fromDatepicker= fromDatepicker.replace(/\[.*?\]/g, '['+(newNum-1)+']');
//										 toDatepicker= toDatepicker.replace(/\[.*?\]/g, '['+(newNum-1)+']');

										var newrow=$("<tr class='cloneWorkExpTexts' id='workExpTexts"+num+"'>" +
												"<td><input type='text' value='' class='title' name='workExperiences["+num+"].title' id='workExperiences["+num+"].title'></td>" +
												"<td><input type='text' value='' class='areaOfExperience' name='workExperiences["+num+"].areaOfExpertise' ></td>" +
												"<td><input type='text' value='' class='roleDescription' name='workExperiences["+num+"].roleDescription'></td>" +
											    "<td style='width: 44%'><input type='text' value='' class='fromDatepicker' style='width: 100%' name='workExperiences["+num+"].fromDate' ></td> " +
											    "<td style='width: 44%'><input type='text' value='' class='toDatepicker' style='width: 100%' name='workExperiences["+num+"].toDate' ></td>" +
											    "</tr>") ;
										
//										var newWorkExpTable = $(
//												'#workExpTexts' + id)
//												.clone()
//												.attr('id',
//														'workExpTexts' + num);

//										$('#workExpTexts' + id).after(
//												newrow);

										$('#workExpBtnTr').before(newrow);
										
//										$('#workExpTexts'+ newNum+ " td input.title").attr('name',title);
//										$('#workExpTexts'+ newNum+ " td input.areaOfExperience").attr('name',areaOfExperience);
//										$('#workExpTexts'+ newNum+ " td input.roleDescription").attr('name',roleDescription);
//										$('#workExpTexts'+ newNum+ " td input.fromDatepicker").attr('name',fromDatepicker);
//										$('#workExpTexts'+ newNum+ " td input.toDatepicker").attr('name',toDatepicker);
//										
//										$('#workExpTexts'+ newNum+ " td input.fromDatepicker").val("");
//										$('#workExpTexts'+ newNum+ " td input.fromDatepicker").attr('id','fromDatePicker'+ newNum);
										
//										$(
//												'#workExpTexts'
//														+ newNum
//														+ " td input.fromDatepicker")
//												.removeClass('hasDatepicker');
										$(
												'#workExpTexts'
														+ num
														+ " td input.fromDatepicker")
												.datepicker({ dateFormat: 'dd-mm-yy' });
//										$(
//												'#workExpTexts'
//														+ num
//														+ " td input.toDatepicker")
//												.val("");
//										$(
//												'#workExpTexts'
//														+ newNum
//														+ " td input.toDatepicker")
//												.attr('id',
//														"toDatePicker" + newNum);
//										$(
//												'#workExpTexts'
//														+ newNum
//														+ " td input.toDatepicker")
//												.removeClass('hasDatepicker');
										$(
												'#workExpTexts'
														+ newNum
														+ " td input.toDatepicker")
												.datepicker({ dateFormat: 'dd-mm-yy' });

									});

					$('#addMoreSocialbtn')
							.click(
									function() {
										var newTr = $("<tr><td><input type='text' name='socialSiteName'></td><td><input type='text' name='socialSiteId'></td></tr>");
										$('#socialButtonRow').before(newTr);

									});

					$('#btnDel').click(function() {
						var num = $('.clonedInput').length; // how many
						// "duplicatable"
						// input fields we currently
						// have
						$('#input' + num).remove(); // remove the last element

						// enable the "add" button
						$('#btnAdd').attr('disabled', '');

						// if only one element remains, disable the "remove"
						// button
						if (num - 1 == 1)
							$('#btnDel').attr('disabled', 'disabled');
					});

					$('#btnDel').attr('disabled', 'disabled');
				});

$(function() {
	$(".fromDatepicker").datepicker({ dateFormat: 'dd-mm-yy' });
	$(".toDatepicker").datepicker({ dateFormat: 'dd-mm-yy' });
	$("#firstName").watermark("First Name");
	$("#middleName").watermark("Middle Name");
	$("#lastName").watermark("Last Name");
});
