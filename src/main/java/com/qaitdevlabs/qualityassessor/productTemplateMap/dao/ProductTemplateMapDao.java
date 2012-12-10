package com.qaitdevlabs.qualityassessor.productTemplateMap.dao;

import java.io.Serializable;
import java.util.List;

import com.qaitdevlabs.qualityassessor.dao.GenericDao;
import com.qaitdevlabs.qualityassessor.model.Domain;
import com.qaitdevlabs.qualityassessor.model.Product;
import com.qaitdevlabs.qualityassessor.model.ProductTemplateMap;

public interface ProductTemplateMapDao extends GenericDao<ProductTemplateMap, Serializable>{

	public void saveOrUpdateProductTemplateMap(ProductTemplateMap productTemplateMap) ;

	public List<ProductTemplateMap> getProductsToBeReviewed();

	public List<ProductTemplateMap> getListOfProductTemplateMapByProduct(Product product);

	public boolean isProductTemplateMapAlreadyExist(Product product,
			Domain domain);

}
