package com.qaitdevlabs.qualityassessor.dao.impl;

import java.util.List;

import com.qaitdevlabs.qualityassessor.dao.UrlRuleDao;
import com.qaitdevlabs.qualityassessor.model.UrlRule;

public class UrlRuleDaoImpl extends GenericDaoImpl<UrlRule, Long> implements
		UrlRuleDao {

	public UrlRuleDaoImpl() {
		super(UrlRule.class);

	}

	/**
	 * @see com.qainfotech.net.security.domain.dao.UrlAuthorityDAO#getAuthorityList
	 *      (java.lang.String, java.lang.String)
	 */
	public List<String> getUrlAuthorityList(String url, String method) {
		System.out.print(url + " " + method);
		Object params[] = { url, method };

		@SuppressWarnings("unchecked")
		List<String> list = getHibernateTemplate()
				.find("select r.roleName from Role r join r.rules ru where ru.url=? and ru.method=?",
						params);
		System.out.println(list);
		return list;
	}
}
