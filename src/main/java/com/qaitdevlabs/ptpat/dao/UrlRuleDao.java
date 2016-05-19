package com.qaitdevlabs.ptpat.dao;

import java.util.List;

import com.qaitdevlabs.ptpat.model.UrlRule;

public interface UrlRuleDao extends GenericDao<UrlRule, Long> {

	public List<String> getUrlAuthorityList(String url, String method);
}
