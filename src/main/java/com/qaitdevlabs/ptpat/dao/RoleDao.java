package com.qaitdevlabs.ptpat.dao;

import com.qaitdevlabs.ptpat.model.Role;

public interface RoleDao extends GenericDao<Role, Long> {

	public Role getRoleByName(String roleName);

}
