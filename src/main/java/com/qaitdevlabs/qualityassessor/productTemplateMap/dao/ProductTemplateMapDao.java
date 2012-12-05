package com.qaitdevlabs.qualityassessor.productTemplateMap.dao;

import java.util.List;

import com.qaitdevlabs.qualityassessor.model.ProductTemplateMap;

public interface ProductTemplateMapDao {

	public void saveOrUpdateProductTemplateMap(ProductTemplateMap productTemplateMap) ;

	public List<ProductTemplateMap> getProductsToBeReviewed();
}
