package com.qaitdevlabs.ptpat.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.qaitdevlabs.ptpat.dao.SubCategoryDao;
import com.qaitdevlabs.ptpat.model.SubCategory;

@Repository
public class SubCategoryDaoImpl extends GenericDaoImpl<SubCategory, Long>
		implements SubCategoryDao {

	@Override
	public SubCategory getSubCategoryBySubCategoryName(String subCategoryName) {
		Session session = getSessionFactory().openSession();
		SubCategory subCategory = (SubCategory) session
				.createQuery(
						"from SubCategory sc where sc.subCategoryName= :sName")
				.setParameter("sName", subCategoryName).uniqueResult();
		return subCategory;
	}

	@Override
	public SubCategory saveSubCategory(Session session, String subCategoryName) {
		if (session == null)
			session = getSessionFactory().openSession();

		SubCategory subCategory = new SubCategory();
		subCategory.setSubCategoryName(subCategoryName);
		session.save(subCategory);
		return subCategory;
	}

}