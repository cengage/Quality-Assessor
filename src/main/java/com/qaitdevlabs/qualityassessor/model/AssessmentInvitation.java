package com.qaitdevlabs.qualityassessor.model;

import java.util.Date;

public class AssessmentInvitation {
	private Long assessmentInvitationId;
	private User user;
	private User assessor;
	private Domain domain;
	private Date invitationDate;
	private Boolean ignoreInvitation = false;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getAssessor() {
		return assessor;
	}

	public void setAssessor(User assessor) {
		this.assessor = assessor;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public Long getAssessmentInvitationId() {
		return assessmentInvitationId;
	}

	public void setAssessmentInvitationId(Long assessmentInvitationId) {
		this.assessmentInvitationId = assessmentInvitationId;
	}

	public Date getInvitationDate() {
		return invitationDate;
	}

	public void setInvitationDate(Date invitationDate) {
		this.invitationDate = invitationDate;
	}

	public Boolean isIgnoreInvitation() {
		return ignoreInvitation;
	}

	public void setIgnoreInvitation(Boolean ignoreInvitation) {
		this.ignoreInvitation = ignoreInvitation;
	}

}
