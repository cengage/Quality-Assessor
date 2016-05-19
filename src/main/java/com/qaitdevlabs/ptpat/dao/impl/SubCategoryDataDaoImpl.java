package com.qaitdevlabs.ptpat.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.qaitdevlabs.ptpat.dao.SubCategoryDataDao;
import com.qaitdevlabs.ptpat.model.ProductCategory;
import com.qaitdevlabs.ptpat.model.SubCategory;
import com.qaitdevlabs.ptpat.model.SubCategoryData;

@Repository
public class SubCategoryDataDaoImpl extends
		GenericDaoImpl<SubCategoryData, Long> implements SubCategoryDataDao {

	@Override
	public SubCategoryData saveSubCategoryData(Session session,
			ProductCategory productCategory, String subCategoryRawData,
			SubCategory subCategory) {
		if (session == null)
			session = getSessionFactory().openSession();

		Date createdDate = new Date();
		SubCategoryData subCategoryData = new SubCategoryData();
		subCategoryData.setProductCategory(productCategory);

		subCategoryData.setSubCategoryRawData(subCategoryRawData);
		subCategoryData.setSubCategory(subCategory);
		subCategoryData.setCreatedDate(createdDate);
		subCategoryData.setLastModifiedDate(createdDate);
		session.save(subCategoryData);
		return subCategoryData;
	}

	@Override
	public List<SubCategory> fetchAllSubCategoriesByProductAndCategoryId(
			Long selectedProductId, Long selectedCategoryId) {
		Session session = getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<SubCategory> subCategoryList = session
				.createQuery(
						"select subCategory from SubCategoryData scData where scData.productCategory.product.productId= :productId and scData.productCategory.category.categoryId=:categoryId")
				.setParameter("productId", selectedProductId)
				.setParameter("categoryId", selectedCategoryId).list();
		return subCategoryList;
	}

	@Override
	public List<SubCategoryData> fetchSubCategoriesDataByProductCategoryAndSubCategoryId(
			Long selectedProductId, Long selectedCategoryId,
			Long selectedSubCategoryId) {
		Session session = getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<SubCategoryData> subCategoryDataList = session
				.createQuery(
						"from SubCategoryData scData where scData.productCategory.product.productId= :productId and scData.productCategory.category.categoryId=:categoryId and scData.subCategory.subCategoryId=:subCatId")
				.setParameter("productId", selectedProductId)
				.setParameter("categoryId", selectedCategoryId)
				.setParameter("subCatId", selectedSubCategoryId).list();
		return subCategoryDataList;
	}

	@Override
	public SubCategoryData getSubCategoryDataByProductCategoryIdAndSubCategoryId(
			Long productCtegoryId, Long subCategoryId) {
		Session session = getSessionFactory().openSession();
		SubCategoryData subCategoryData = (SubCategoryData) session
				.createQuery(
						"from SubCategoryData scd where scd.productCategory.productCtegoryId= :productCategoryId and scd.subCategory.subCategoryId=:subCategoryId")
				.setParameter("productCategoryId", productCtegoryId)
				.setParameter("subCategoryId", subCategoryId).uniqueResult();
		return subCategoryData;
	}

	@Override
	public SubCategoryData updateSubCategoryData(Long id, Session session,
			ProductCategory productCategory, String subCategoryRawData,
			SubCategory subCategory, Date createdDate) {
		if (session == null)
			session = getSessionFactory().openSession();

		Date updatedDate = new Date();
		SubCategoryData subCategoryData = new SubCategoryData();
		subCategoryData.setId(id);
		subCategoryData.setCreatedDate(createdDate);
		subCategoryData.setProductCategory(productCategory);

		subCategoryData.setSubCategoryRawData(subCategoryRawData);
		subCategoryData.setSubCategory(subCategory);
		subCategoryData.setLastModifiedDate(updatedDate);
		session.update(subCategoryData);
		return null;
	}

}