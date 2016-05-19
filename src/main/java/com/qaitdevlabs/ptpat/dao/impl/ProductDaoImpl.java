package com.qaitdevlabs.ptpat.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.qaitdevlabs.ptpat.dao.ProductDao;
import com.qaitdevlabs.ptpat.model.Product;

@Repository
public class ProductDaoImpl extends GenericDaoImpl<Product, Long> implements
		ProductDao {

	@Override
	public Product getProductByProductCode(String productCode) {
		Session session = getSessionFactory().openSession();
			Product product = (Product) session
					.createQuery("from Product p where p.productCode= :code")
					.setParameter("code", productCode).uniqueResult();
			return product;
		
	}

	@Override
	public Product saveProduct(Session session, String productCode) {
		if (session == null)
			session = getSessionFactory().openSession();
		
			Product product = new Product();
			product.setProductCode(productCode);
			session.save(product);
			return product;
	}

	@Override
	public List<Product> fetchAllProdcuts() {
		Session session = getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Product> productList = session.createCriteria(Product.class)
				.list();
		return productList;
	}

}