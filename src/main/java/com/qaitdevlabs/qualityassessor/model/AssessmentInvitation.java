package com.qaitdevlabs.qualityassessor.model;

public class AssessmentInvitation {
	private Long assessmentInvitationId;
	private User user;
	private User assessor;
	private Domain domain;

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

}
