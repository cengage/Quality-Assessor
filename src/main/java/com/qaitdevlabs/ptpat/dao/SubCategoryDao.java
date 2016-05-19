package com.qaitdevlabs.ptpat.dao;

import org.hibernate.Session;

import com.qaitdevlabs.ptpat.model.SubCategory;

public interface SubCategoryDao extends GenericDao<SubCategory, Long> {

	SubCategory getSubCategoryBySubCategoryName(String subCategoryName);

	SubCategory saveSubCategory(Session session, String subCategoryName);

}