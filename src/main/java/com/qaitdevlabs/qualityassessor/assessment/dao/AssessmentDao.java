package com.qaitdevlabs.qualityassessor.assessment.dao;

import com.qaitdevlabs.qualityassessor.dao.GenericDao;
import com.qaitdevlabs.qualityassessor.model.Assessment;
import com.qaitdevlabs.qualityassessor.model.Domain;
import com.qaitdevlabs.qualityassessor.model.User;


public interface AssessmentDao extends GenericDao<Assessment, Long>{

	Assessment getAssessment(User assessor, User user, Domain domain);

}
