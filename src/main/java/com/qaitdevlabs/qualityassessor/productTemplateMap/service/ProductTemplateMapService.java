package com.qaitdevlabs.qualityassessor.productTemplateMap.service;

import java.util.List;

import com.qaitdevlabs.qualityassessor.model.ProductTemplateMap;

public interface ProductTemplateMapService {

	void saveOrUpdateProductTemplateMap(ProductTemplateMap productTemplateMap);

	List<ProductTemplateMap> getProductsToBeReviewed();

	ProductTemplateMap getProductTemplateMapById(Long Id);
}
