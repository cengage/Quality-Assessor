package com.qaitdevlabs.qualityassessor.assessmentinvitation.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.qaitdevlabs.qualityassessor.dao.impl.GenericDaoImpl;
import com.qaitdevlabs.qualityassessor.model.Assessment;
import com.qaitdevlabs.qualityassessor.model.AssessmentInvitation;
import com.qaitdevlabs.qualityassessor.model.User;

@Repository
public class AssessmentInvitationDaoImpl extends
		GenericDaoImpl<AssessmentInvitation, Serializable> implements
		AssessmentInvitationDao {

	@Override
	public List<Assessment> getAssessmentInvitations(User assessor) {
		Session session = null;
		List<Assessment> assessments = null;
		try {
			session = getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(AssessmentInvitation.class);
			criteria.add(Restrictions.eq("assessor", assessor));
			criteria.add(Restrictions.ne("user", assessor));
			assessments = criteria.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (assessments.size() < 1) {
			return null;
		}
		return assessments;
	}

}
