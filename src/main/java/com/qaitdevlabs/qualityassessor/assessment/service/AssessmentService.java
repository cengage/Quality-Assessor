package com.qaitdevlabs.qualityassessor.assessment.service;

import com.qaitdevlabs.qualityassessor.model.Assessment;
import com.qaitdevlabs.qualityassessor.model.Domain;
import com.qaitdevlabs.qualityassessor.model.User;

public interface AssessmentService {
	public Assessment saveAssessment(Assessment assessment);

	public Assessment getAssessment(User assessor, User user, Domain domain);

}
