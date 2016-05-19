package com.qaitdevlabs.ptpat.service;

import java.util.List;
import java.util.Map;

import com.qaitdevlabs.ptpat.model.Category;
import com.qaitdevlabs.ptpat.model.Product;
import com.qaitdevlabs.ptpat.model.SubCategory;
import com.qaitdevlabs.ptpat.model.SubCategoryData;

public interface ConnectorService {

	String saveAllFetchedData(Map<String, String> fetchedData);

	String fetchAndSaveJankinData();

	String fetchAndSaveJiraData();

	List<Product> fetchAllProducts();

	List<Category> fetchAllCategoriesByProductId(Long selectedProductId);

	List<SubCategory> fetchAllSubCategoriesByProductAndCategoryId(
			Long selectedProductId, Long selectedCategoryId);

	List<SubCategoryData> fetchSubCategoriesDataByProductCategoryAndSubCategoryId(
			Long selectedProductId, Long selectedCategoryId,
			Long selectedSubCategoryId);

}
