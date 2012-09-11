package com.qaitdevlabs.qualityassessor.assessmentinvitation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qaitdevlabs.qualityassessor.assessmentinvitation.dao.AssessmentInvitationDao;
import com.qaitdevlabs.qualityassessor.model.Assessment;
import com.qaitdevlabs.qualityassessor.model.AssessmentInvitation;
import com.qaitdevlabs.qualityassessor.model.User;

@Service
public class AssessmentInvitationServiceImpl implements
		AssessmentInvitationService {

	private AssessmentInvitationDao assessmentInvitationDao;

	@Autowired
	public void setAssessmentInvitationDao(
			AssessmentInvitationDao assessmentInvitationDao) {
		this.assessmentInvitationDao = assessmentInvitationDao;
	}

	@Override
	public void sendInvitation(AssessmentInvitation assessmentInvitation) {
		assessmentInvitationDao.save(assessmentInvitation);

	}
	
	@Override
	public List<Assessment> getAssessmentInvitations(User assessor) {
		return assessmentInvitationDao.getAssessmentInvitations(assessor);
	}

}
