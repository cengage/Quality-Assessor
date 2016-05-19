package com.qaitdevlabs.ptpat.dao;

import org.hibernate.Session;

import com.qaitdevlabs.ptpat.model.Category;

public interface CategoryDao extends GenericDao<Category, Long> {

	Category getCategoryByCategoryName(String categoryName);

	Category saveCategory(Session session, String categoryName);

}