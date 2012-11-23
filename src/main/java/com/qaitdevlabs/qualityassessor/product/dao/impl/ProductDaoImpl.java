package com.qaitdevlabs.qualityassessor.product.dao.impl;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.qaitdevlabs.qualityassessor.dao.impl.GenericDaoImpl;
import com.qaitdevlabs.qualityassessor.model.Product;
import com.qaitdevlabs.qualityassessor.model.User;
import com.qaitdevlabs.qualityassessor.product.dao.ProductDao;

@Repository
public class ProductDaoImpl extends GenericDaoImpl<Product, Serializable>
		implements ProductDao {

	@Override
	public List<Product> getListOfProductsByUser(User user) {
		Session session = null;
		List<Product> listOfProducts = null;
		try {
			session = getSessionFactory().openSession();
			Criteria criteria = session
					.createCriteria(Product.class);
			criteria.add(Restrictions.eq("user", user));
			listOfProducts = criteria.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (listOfProducts.size() < 1) {
			return null;
		}
		return listOfProducts;
	}

}
