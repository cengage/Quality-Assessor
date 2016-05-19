package com.qaitdevlabs.ptpat.dao;

import java.util.List;

import org.hibernate.Session;

import com.qaitdevlabs.ptpat.model.Product;

public interface ProductDao extends GenericDao<Product, Long> {

	Product getProductByProductCode(String productCode);

	Product saveProduct(Session session, String productCode);

	List<Product> fetchAllProdcuts();

}