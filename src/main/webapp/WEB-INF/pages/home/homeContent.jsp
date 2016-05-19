<%@include file="/WEB-INF/pages/common/common-taglibs.jsp"%>
<p style='margin-left: 50px'>
	<strong>Welcome ${sessionScope.userCompleteName}</strong>
</p>

<div style='margin-left: 50px'>
	<a href="/PTPAT/getProductList"><span>Browse Data</span></a>
</div>

<c:if
	test="${requestScope.jenkinStatus eq 'Data Saved Successfully for Jenkin'}">
Data Saved Successfully for Jenkin
</c:if>


<c:if
	test="${requestScope.jenkinStatus ne 'Data Saved Successfully for Jenkin'}">
There is some problem in fetching data from Jenkins, <div
		id="toggleJenkinError">
		<a href="">Click here to see the stack trace </a>
	</div>
</c:if>


<div class="jenkinError" style="display: none;">${requestScope.jenkinStatus}</div>

<c:if
	test="${requestScope.jiraStatus eq 'Data Saved Successfully for Jira'}">
Data Saved Successfully for Jira
</c:if>

<div id="toggleJiraError">
	<c:if
		test="${requestScope.jiraStatus ne 'Data Saved Successfully for Jira'}">
There is some problem in fetching data from Jira, <a href="">Click here to
			see the stack trace</a>
	</c:if>
</div>

<div class="jiraError" style="display: none;">${requestScope.jiraStatus}</div>


<script type="text/javascript">
	$(document).ready(function() {
		$('#toggleJenkinError').click(function() {
			$('.jenkinError').slideToggle("fast");
		});

		$('#toggleJiraError').click(function() {
			$('.jiraError').slideToggle("fast");
		});
	});
</script>
<style>
.jenkinError {
	border-style: solid;
	border-width: 5px;
}

.jiraError {
	border-style: solid;
	border-width: 5px;
}
</style>