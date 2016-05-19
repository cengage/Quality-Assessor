package com.qaitdevlabs.ptpat.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

public class Role implements Serializable, GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long roleId;
	private String roleName;
	private String roleDescription;
	private Set<UrlRule> rules = new HashSet<UrlRule>(0);
	private Set<User> users = new HashSet<User>(0);

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public Set<UrlRule> getRules() {
		return rules;
	}

	public void setRules(Set<UrlRule> rules) {
		this.rules = rules;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return roleName;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Role) {
			Role roleObj = (Role) obj;
			if (roleObj.roleName.equals(roleName)) {
				return true;
			}
		}
		return false;
	}

}
