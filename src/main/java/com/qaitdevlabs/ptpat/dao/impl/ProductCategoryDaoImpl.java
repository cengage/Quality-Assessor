package com.qaitdevlabs.ptpat.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.qaitdevlabs.ptpat.dao.ProductCategoryDao;
import com.qaitdevlabs.ptpat.model.Category;
import com.qaitdevlabs.ptpat.model.Product;
import com.qaitdevlabs.ptpat.model.ProductCategory;

@Repository
public class ProductCategoryDaoImpl extends
		GenericDaoImpl<ProductCategory, Long> implements ProductCategoryDao {

	@Override
	public ProductCategory getProductCategoryByProductIdAndCategoryId(
			Long categoryId, Long productId) {
		Session session = getSessionFactory().openSession();
		ProductCategory productCategory = (ProductCategory) session
				.createQuery(
						"from ProductCategory pc where pc.category.categoryId= :categoryId and pc.product.productId=:productId")
				.setParameter("categoryId", categoryId)
				.setParameter("productId", productId).uniqueResult();
		return productCategory;
	}

	@Override
	public ProductCategory saveProductCategory(Session session,
			Product product, Category category) {
		if (session == null)
			session = getSessionFactory().openSession();

		Date createdDate = new Date();
		ProductCategory productCategory = new ProductCategory();
		productCategory.setProduct(product);
		productCategory.setCategory(category);

		productCategory.setCreatedDate(createdDate);
		productCategory.setLastModifiedDate(createdDate);
		session.save(productCategory);
		return productCategory;
	}

	@Override
	public List<Category> fetchAllCategoriesByProductId(Long selectedProductId) {
		Session session = getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Category> categoryList = session
				.createQuery(
						"select category from ProductCategory pc where pc.product.productId= :productId")
				.setParameter("productId", selectedProductId).list();
		return categoryList;
	}

}