package com.qaitdevlabs.ptpat.dao.impl;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qaitdevlabs.ptpat.dao.CategoryDao;
import com.qaitdevlabs.ptpat.dao.ConnectorDao;
import com.qaitdevlabs.ptpat.dao.ProductCategoryDao;
import com.qaitdevlabs.ptpat.dao.ProductDao;
import com.qaitdevlabs.ptpat.dao.SubCategoryDao;
import com.qaitdevlabs.ptpat.dao.SubCategoryDataDao;
import com.qaitdevlabs.ptpat.model.Category;
import com.qaitdevlabs.ptpat.model.Product;
import com.qaitdevlabs.ptpat.model.ProductCategory;
import com.qaitdevlabs.ptpat.model.SubCategory;
import com.qaitdevlabs.ptpat.model.SubCategoryData;

@Repository
public class ConnectorDaoImpl extends GenericDaoImpl<SubCategoryData, Long>
		implements ConnectorDao {

	private ProductDao productDao;

	private CategoryDao categoryDao;

	private ProductCategoryDao productCategoryDao;

	private SubCategoryDao subCategoryDao;

	private SubCategoryDataDao subCategoryDataDao;

	public SubCategoryDataDao getSubCategoryDataDao() {
		return subCategoryDataDao;
	}

	@Autowired
	public void setSubCategoryDataDao(SubCategoryDataDao subCategoryDataDao) {
		this.subCategoryDataDao = subCategoryDataDao;
	}

	public SubCategoryDao getSubCategoryDao() {
		return subCategoryDao;
	}

	@Autowired
	public void setSubCategoryDao(SubCategoryDao subCategoryDao) {
		this.subCategoryDao = subCategoryDao;
	}

	public ProductCategoryDao getProductCategoryDao() {
		return productCategoryDao;
	}

	@Autowired
	public void setProductCategoryDao(ProductCategoryDao productCategoryDao) {
		this.productCategoryDao = productCategoryDao;
	}

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	@Autowired
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public ProductDao getProductDao() {
		return productDao;
	}

	@Autowired
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public String saveAllFetchedData(Map<String, String> fetchedData) {

		String status = "Data Saved Successfully";
		Session session = null;
		Transaction tx = null;

		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			// ----- save product ---------
			String productCode = fetchedData
					.get(fetchedData.keySet().toArray()[0]);

			Product product = productDao.getProductByProductCode(productCode);

			if (product == null) {
				product = productDao.saveProduct(session, productCode);
			}

			// ---- save category -------

			String categoryName = fetchedData.get(fetchedData.keySet()
					.toArray()[1]);

			Category category = categoryDao
					.getCategoryByCategoryName(categoryName);

			if (category == null) {
				category = categoryDao.saveCategory(session, categoryName);
			}

			// ---- for product_category -----

			ProductCategory productCategory = productCategoryDao
					.getProductCategoryByProductIdAndCategoryId(
							category.getCategoryId(), product.getProductId());

			if (productCategory == null) {

				productCategory = productCategoryDao.saveProductCategory(
						session, product, category);

			}

			// ----- for Sub_Category-----
			for (int i = 2; i < fetchedData.size(); i++) {

				String subCategoryName = (String) fetchedData.keySet()
						.toArray()[i];

				SubCategory subCategory = subCategoryDao
						.getSubCategoryBySubCategoryName(subCategoryName);

				if (subCategory == null) {
					subCategory = subCategoryDao.saveSubCategory(session,
							subCategoryName);
				}

				// ----- Sub_Category_Data -----
				String subCategoryRawData = fetchedData.get(fetchedData
						.keySet().toArray()[i]);

				SubCategoryData subCategoryData = subCategoryDataDao
						.getSubCategoryDataByProductCategoryIdAndSubCategoryId(
								productCategory.getProductCtegoryId(),
								subCategory.getSubCategoryId());

				if (subCategoryData == null) {
					subCategoryData = subCategoryDataDao.saveSubCategoryData(
							session, productCategory, subCategoryRawData,
							subCategory);
				} else {
					subCategoryData = subCategoryDataDao.updateSubCategoryData(
							subCategoryData.getId(), session, productCategory,
							subCategoryRawData, subCategory,
							subCategoryData.getCreatedDate());
				}
			}

			System.out.println();
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				tx.rollback();
			} catch (RuntimeException rbe) {
				throw rbe;
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return status;
	}

}
