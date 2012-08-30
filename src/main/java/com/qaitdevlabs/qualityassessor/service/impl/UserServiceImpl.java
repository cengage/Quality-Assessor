package com.qaitdevlabs.qualityassessor.service.impl;

import com.qaitdevlabs.qualityassessor.dao.UserDao;
import com.qaitdevlabs.qualityassessor.model.SocialNetwork;
import com.qaitdevlabs.qualityassessor.model.User;
import com.qaitdevlabs.qualityassessor.model.WorkExperience;
import com.qaitdevlabs.qualityassessor.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * This class is a implementation of UserService class
 * 
 * @author anujchhabra
 */
@Service
public class UserServiceImpl implements UserService {
	private UserDao userDao;
	private PasswordEncoder passwordEncoder;

	public UserDao getUserDao() {
		return userDao;
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	@Autowired
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	public User saveUser(User user) {
		user.setPassword(passwordEncoder.encodePassword(user.getPassword(),
				user.getUsername()));
		userDao.saveUser(user);
		return user;
	}

	@Override
	public SocialNetwork saveSocialNetwork(SocialNetwork socialNetwork) {
		return userDao.saveSocialNetwork(socialNetwork);
	}

	@Override
	public WorkExperience saveWorkExperience(WorkExperience workExperience) {
		return userDao.saveWorkExperience(workExperience);
	}

}
