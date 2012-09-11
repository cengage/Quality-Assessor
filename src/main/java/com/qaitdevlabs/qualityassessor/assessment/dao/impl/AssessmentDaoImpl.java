package com.qaitdevlabs.qualityassessor.assessment.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
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
		System.out.println(user.getUserId() + " " + assessor.getUserId());
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

	@Override
	public List<Assessment> getAssessment(User assessor) {
		Session session = null;
		List<Assessment> assessments = null;
		try {
			session = getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(Assessment.class);
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

	@Override
	public Double getAverageAssessment(User user, User assessor, Domain domain) {
		Session session = null;
		Double score = new Double(0);
		try {
			session = getSessionFactory().openSession();
			String SQL_QUERY = "select avg(assessment.score) from Assessment assessment where assessment.user=:user and assessment.domain=:domain and assessment.assessor<>:assessor";
			Query query = session.createQuery(SQL_QUERY);
			query.setParameter("user", user);
			query.setParameter("domain", domain);
			query.setParameter("assessor", assessor);
			List results = query.list();
			Iterator resultIterator = results.iterator();
			if (resultIterator.hasNext()) {
			Double obj = (Double) resultIterator.next();
//            for (int i = 0; i < obj.length; i++) {
                   System.out.print("************************"+obj);
                   if(null != obj)
                    score= obj;
//            }
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return score;
	}

}
