package com.qaitdevlabs.ptpat.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qaitdevlabs.ptpat.connector.ConnectorFetchAndSaveBO;
import com.qaitdevlabs.ptpat.dao.ConnectorDao;
import com.qaitdevlabs.ptpat.dao.ProductCategoryDao;
import com.qaitdevlabs.ptpat.dao.ProductDao;
import com.qaitdevlabs.ptpat.dao.SubCategoryDataDao;
import com.qaitdevlabs.ptpat.model.Category;
import com.qaitdevlabs.ptpat.model.Product;
import com.qaitdevlabs.ptpat.model.SubCategory;
import com.qaitdevlabs.ptpat.model.SubCategoryData;
import com.qaitdevlabs.ptpat.service.ConnectorService;

@Service
public class ConnectorServiceImpl implements ConnectorService {

	private ProductDao productDao;

	private ConnectorDao connectorDao;

	private ProductCategoryDao productCategoryDao;

	private SubCategoryDataDao subCategoryDataDao;

	private ConnectorFetchAndSaveBO connectorFetchAndSaveBO;

	public SubCategoryDataDao getSubCategoryDataDao() {
		return subCategoryDataDao;
	}

	@Autowired
	public void setSubCategoryDataDao(SubCategoryDataDao subCategoryDataDao) {
		this.subCategoryDataDao = subCategoryDataDao;
	}

	public ProductCategoryDao getProductCategoryDao() {
		return productCategoryDao;
	}

	@Autowired
	public void setProductCategoryDao(ProductCategoryDao productCategoryDao) {
		this.productCategoryDao = productCategoryDao;
	}

	public ProductDao getProductDao() {
		return productDao;
	}

	@Autowired
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public ConnectorFetchAndSaveBO getConnectorFetchAndSaveBO() {
		return connectorFetchAndSaveBO;
	}

	@Autowired
	public void setConnectorFetchAndSaveBO(
			ConnectorFetchAndSaveBO connectorFetchAndSaveBO) {
		this.connectorFetchAndSaveBO = connectorFetchAndSaveBO;
	}

	public ConnectorDao getConnectorDao() {
		return connectorDao;
	}

	@Autowired
	public void setConnectorDao(ConnectorDao connectorDao) {
		this.connectorDao = connectorDao;
	}

	@Override
	public String saveAllFetchedData(Map<String, String> fetchedData) {
		return connectorDao.saveAllFetchedData(fetchedData);
	}

	@Override
	public String fetchAndSaveJankinData() {
		return connectorFetchAndSaveBO.fetchAndSaveJankinData();

	}

	@Override
	public String fetchAndSaveJiraData() {
		return connectorFetchAndSaveBO.fetchAndSaveJiraData();

	}

	@Override
	public List<Product> fetchAllProducts() {
		return productDao.fetchAllProdcuts();
	}

	@Override
	public List<Category> fetchAllCategoriesByProductId(Long selectedProductId) {
		return productCategoryDao
				.fetchAllCategoriesByProductId(selectedProductId);
	}

	@Override
	public List<SubCategory> fetchAllSubCategoriesByProductAndCategoryId(
			Long selectedProductId, Long selectedCategoryId) {
		return subCategoryDataDao.fetchAllSubCategoriesByProductAndCategoryId(
				selectedProductId, selectedCategoryId);
	}

	@Override
	public List<SubCategoryData> fetchSubCategoriesDataByProductCategoryAndSubCategoryId(
			Long selectedProductId, Long selectedCategoryId,
			Long selectedSubCategoryId) {
		return subCategoryDataDao
				.fetchSubCategoriesDataByProductCategoryAndSubCategoryId(
						selectedProductId, selectedCategoryId,
						selectedSubCategoryId);
	}

}
