package com.qaitdevlabs.ptpat.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.qaitdevlabs.ptpat.model.ProductCategory;
import com.qaitdevlabs.ptpat.model.SubCategory;
import com.qaitdevlabs.ptpat.model.SubCategoryData;

public interface SubCategoryDataDao extends GenericDao<SubCategoryData, Long> {

	SubCategoryData saveSubCategoryData(Session session,
			ProductCategory productCategory, String subCategoryRawData,
			SubCategory subCategory);

	List<SubCategory> fetchAllSubCategoriesByProductAndCategoryId(
			Long selectedProductId, Long selectedCategoryId);

	List<SubCategoryData> fetchSubCategoriesDataByProductCategoryAndSubCategoryId(
			Long selectedProductId, Long selectedCategoryId,
			Long selectedSubCategoryId);

	SubCategoryData getSubCategoryDataByProductCategoryIdAndSubCategoryId(
			Long productCtegoryId, Long subCategoryId);

	SubCategoryData updateSubCategoryData(Long id, Session session,
			ProductCategory productCategory, String subCategoryRawData,
			SubCategory subCategory, Date createdDate);

}