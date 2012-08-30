$(document)
		.ready(
				function() {
					$('#addMoreWorkExpbtn')
							.click(
									function() {
										var num = $('.cloneWorkExpTexts').length; // how
										// many

										var newNum = new Number(num + 1); // the

										var newWorkExpTable = $(
												'#workExpTexts' + num)
												.clone()
												.attr('id',
														'workExpTexts' + newNum);

										$('#workExpTexts' + num).after(
												newWorkExpTable);

										$(
												'#workExpTexts'
														+ newNum
														+ " td input.fromDatepicker")
												.val("");
										$(
												'#workExpTexts'
														+ newNum
														+ " td input.fromDatepicker")
												.attr('id', 'fromDatePicker'+newNum);
										$(
												'#workExpTexts'
														+ newNum
														+ " td input.fromDatepicker")
												.removeClass('hasDatepicker');
										$(
												'#workExpTexts'
														+ newNum
														+ " td input.fromDatepicker")
												.datepicker();
										$(
												'#workExpTexts'
														+ newNum
														+ " td input.toDatepicker")
												.val("");
										$(
												'#workExpTexts'
														+ newNum
														+ " td input.toDatepicker")
												.attr('id', "toDatePicker"+newNum);
										$(
												'#workExpTexts'
														+ newNum
														+ " td input.toDatepicker")
												.removeClass('hasDatepicker');
										$(
												'#workExpTexts'
														+ newNum
														+ " td input.toDatepicker")
												.datepicker();

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
	$(".fromDatepicker").datepicker();
	$(".toDatepicker").datepicker();
	$("#firstName").watermark("First Name");
	$("#middleName").watermark("Middle Name");
	$("#lastName").watermark("Last Name");
});
