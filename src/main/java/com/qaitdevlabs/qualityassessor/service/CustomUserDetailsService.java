package com.qaitdevlabs.qualityassessor.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.qaitdevlabs.qualityassessor.model.User;
import com.qaitdevlabs.qualityassessor.dao.RoleDao;
import com.qaitdevlabs.qualityassessor.dao.UserDao;

/**
 * 
 * @author anujchhabra
 * 
 */
public class CustomUserDetailsService implements UserDetailsService {
	private UserDao userDao;
	private RoleDao roleDao;
	private PasswordEncoder passwordEncoder;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	/**
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException, DataAccessException {
		User customUser = userDao.getCustomUserByUserName(userName);
		List<String> roles = roleDao.getRolesByUserName(userName);
		customUser.setCustomerAuthorities(roles);
		return customUser;
	}

	public User saveUser(User user) {
		user.setPassword(passwordEncoder.encodePassword(user.getPassword(),
				user.getUsername()));
		userDao.saveUser(user);
		return user;
	}

}
