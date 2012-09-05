package com.qaitdevlabs.qualityassessor.assessment.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.qaitdevlabs.qualityassessor.assessment.dao.AssessmentDao;
import com.qaitdevlabs.qualityassessor.dao.impl.GenericDaoImpl;
import com.qaitdevlabs.qualityassessor.model.Assessment;
import com.qaitdevlabs.qualityassessor.model.Domain;
import com.qaitdevlabs.qualityassessor.model.User;

@Repository
public class AssessmentDaoImpl extends GenericDaoImpl<Assessment, Long>
		implements AssessmentDao {

	@SuppressWarnings("unchecked")
	@Override
	public Assessment getAssessment(User assessor, User user, Domain domain) {
		Session session = null;
		List<Assessment> assessments = null;

		try {
			session = getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(Assessment.class);
			criteria.add(Restrictions.eq("assessor", assessor));
			criteria.add(Restrictions.eq("user", user));
			criteria.add(Restrictions.eq("domain", domain));
			assessments = criteria.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (assessments.size() < 1) {
			return null;
		}
		return assessments.get(0);

	}

}
