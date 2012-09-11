package com.qaitdevlabs.qualityassessor.assessmentinvitation.service;

import java.util.List;

import com.qaitdevlabs.qualityassessor.model.Assessment;
import com.qaitdevlabs.qualityassessor.model.AssessmentInvitation;
import com.qaitdevlabs.qualityassessor.model.User;

public interface AssessmentInvitationService {

	public void sendInvitation(AssessmentInvitation assessmentInvitation);

	List<Assessment> getAssessmentInvitations(User assessor);

}
