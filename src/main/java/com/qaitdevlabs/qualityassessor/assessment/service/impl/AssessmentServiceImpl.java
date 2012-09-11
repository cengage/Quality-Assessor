package com.qaitdevlabs.qualityassessor.assessment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qaitdevlabs.qualityassessor.assessment.dao.AssessmentDao;
import com.qaitdevlabs.qualityassessor.assessment.service.AssessmentService;
import com.qaitdevlabs.qualityassessor.model.Assessment;
import com.qaitdevlabs.qualityassessor.model.Domain;
import com.qaitdevlabs.qualityassessor.model.User;

@Service
public class AssessmentServiceImpl implements AssessmentService {
	private AssessmentDao assessmentDao;

	@Autowired
	public void setAssessmentDao(AssessmentDao assessmentDao) {
		this.assessmentDao = assessmentDao;
	}
	
	@Override
	public Assessment saveAssessment(Assessment assessment ) {
		return assessmentDao.save(assessment);
	}

	@Override
	public Assessment getAssessment(User assessor, User user, Domain domain) {
		return assessmentDao.getAssessment(assessor,user,domain);
	}

	@Override
	public List<Assessment> getAssessment(User assessor) {
		return assessmentDao.getAssessment(assessor);
	}

//	@Override
//	public Assessment getAssessment() {
//		return assessmentDao.save(assessment);
//	}
	
	

}
