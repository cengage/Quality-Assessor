package com.qaitdevlabs.ptpat.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.qaitdevlabs.ptpat.dao.CategoryDao;
import com.qaitdevlabs.ptpat.model.Category;

@Repository
public class CategoryDaoImpl extends GenericDaoImpl<Category, Long> implements
		CategoryDao {

	@Override
	public Category getCategoryByCategoryName(String categoryName) {
		Session session = getSessionFactory().openSession();
		Category category = (Category) session
				.createQuery("from Category c where c.categoryName= :name")
				.setParameter("name", categoryName).uniqueResult();
		return category;
	}

	@Override
	public Category saveCategory(Session session, String categoryName) {
		if (session == null)
			session = getSessionFactory().openSession();

		Category category = new Category();
		category.setCategoryName(categoryName);
		session.save(category);
		return category;

	}

}