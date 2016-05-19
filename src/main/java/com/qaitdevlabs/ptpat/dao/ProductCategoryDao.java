package com.qaitdevlabs.ptpat.dao;

import java.util.List;

import org.hibernate.Session;

import com.qaitdevlabs.ptpat.model.Category;
import com.qaitdevlabs.ptpat.model.Product;
import com.qaitdevlabs.ptpat.model.ProductCategory;

public interface ProductCategoryDao extends GenericDao<ProductCategory, Long> {

	ProductCategory getProductCategoryByProductIdAndCategoryId(Long categoryId,
			Long productId);

	ProductCategory saveProductCategory(Session session, Product product,
			Category category);

	List<Category> fetchAllCategoriesByProductId(Long selectedProductId);

}