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

	/**
	 * This method return user object that corresponds to username of user
	 * 
	 * @param userName
	 *            login username of user
	 * @return user object
	 * @throws UsernameNotFoundException
	 *             if username not found it throws UsernameNotFoundException
	 * @throws DataAccessException
	 */
	public User getCustomUserByUserName(String userName)
			throws UsernameNotFoundException, DataAccessException;

	public User saveUser(User user);
	
	/*
	 * To check user name and password combination
	 */
	
	public User validateUser(User user);
	
	public User findUserWithProperty(String property, String value);
	
	public User getUser(Long userId , boolean lazyLoad);

}
