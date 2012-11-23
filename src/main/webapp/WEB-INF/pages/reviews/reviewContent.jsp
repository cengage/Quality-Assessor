<%@include file="/WEB-INF/pages/common-taglibs.jsp"%>
<div>
	<div style="font-size: 18px; padding-left: 20px; padding-top: 20px">
		<label><strong>Requests For Assessments</strong></label>
	</div>
	<div id='viewIgnoreRequestDiv' style="margin-left: 670px;">
		<a style='color: #30576E'
			href='assessmentRequests?ignoreInvitation=true'>View ignored
			invitations</a>
	</div>
	<div style="padding-left: 20px">
		<c:forEach var="assessment" items="${assessmentRequestList}">
			<div style='border-top: 1px solid #ccc; margin-top: 15px;'>
				<div
					style='margin-bottom: 12px; margin-top: 12px; font-weight: bold; font-size: 13px'>
					<div>${assessment.invitationDate}</div>
					<div>${assessment.userCompleteName} on
						${assessment.domainName}</div>
				</div>
				<div style='display: inline;'>
					<a style='display: inline; padding: 4px 13px'
						class='button-default'
						href="assessments/${assessment.domainId}?requestedUserId=${assessment.userId}&invitationId=${assessment.invitationId}">Assess
						Now</a>
				</div>
				<div style='display: inline;'>
					<a style='display: inline; padding: 4px 13px'
						class='button-default'
						href="ignoreInvitation?invitationId=${assessment.invitationId}">Ignore</a>
				</div>
			</div>
		</c:forEach>
	</div>
</div>