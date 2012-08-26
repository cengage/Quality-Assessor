package com.qaitdevlabs.qualityassessor.service.impl;

import com.qaitdevlabs.qualityassessor.dao.UserDao;
import com.qaitdevlabs.qualityassessor.model.User;
import com.qaitdevlabs.qualityassessor.service.UserService;
import org.springframework.security.authentication.encoding.PasswordEncoder;

/**
 * This class is a implementation of UserService class
 * @author anujchhabra
 */
public class UserServiceImpl implements UserService{
    private UserDao userDao;
    private PasswordEncoder passwordEncoder;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encodePassword(user.getPassword(),
                user.getUsername()));
        userDao.saveUser(user);
        return user;
    }

}
