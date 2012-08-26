package com.qaitdevlabs.qualityassessor.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.qaitdevlabs.qualityassessor.model.User;

/**
 * 
 * @author anujchhabra
 * 
 */
public interface UserDao extends GenericDao<User, Long> {




	public User saveUser(User user);
	
	/*
	 * To check user name and password combination
	 */
	
	public User validateUser(User user);
	
	public User findUserWithProperty(String property, String value);
	
	public User getUser(Long userId , boolean lazyLoad);

}
