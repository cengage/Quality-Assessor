package com.qaitdevlabs.ptpat.dao.impl;

import java.util.List;

import com.qaitdevlabs.ptpat.dao.RoleDao;
import com.qaitdevlabs.ptpat.model.Role;

public class RoleDaoImpl extends GenericDaoImpl<Role, Long> implements RoleDao {

	/**
	 * Constructor to create a Generics-based version using Role as the entity
	 */

	public RoleDaoImpl() {
		super(Role.class);
	}

	public Role getRoleByName(String roleName) {
		// @SuppressWarnings("unchecked")
		System.out.println("hello");
		List<Role> role = getHibernateTemplate().find(
				"from Role r where r.roleName=?", roleName);
		if (role.size() < 1) {
			return null;
		}
		return role.get(0);
	}

}
