package com.qaitdevlabs.qualityassessor.dao.impl;

import java.util.List;

import com.qaitdevlabs.qualityassessor.dao.RoleDao;
import com.qaitdevlabs.qualityassessor.dao.impl.GenericDaoImpl;
import com.qaitdevlabs.qualityassessor.model.Role;

public class RoleDaoImpl extends GenericDaoImpl<Role, Long> implements RoleDao {

	/**
	 * @see com.UserDao.net.security.domain.dao.CustomUserDAO#getRolesByUserName(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<String> getRolesByUserName(String userName) {
		return getHibernateTemplate()
				.find("SELECT r.roleName from Role r join r.groups rg join rg.users u where u.username=?",
						userName);

	}

	/**
	 * Constructor to create a Generics-based version using Role as the entity
	 */
	public RoleDaoImpl() {
		super(Role.class);
	}
}
