package com.qaitdevlabs.ptpat.dao;

import java.util.Map;

import com.qaitdevlabs.ptpat.model.SubCategoryData;

public interface ConnectorDao extends GenericDao<SubCategoryData, Long> {

	String saveAllFetchedData(Map<String, String> fetchedData);

}
