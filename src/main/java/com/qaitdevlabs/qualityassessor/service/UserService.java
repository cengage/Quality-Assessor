package com.qaitdevlabs.qualityassessor.service;

import com.qaitdevlabs.qualityassessor.model.SocialNetwork;
import com.qaitdevlabs.qualityassessor.model.User;
import com.qaitdevlabs.qualityassessor.model.WorkExperience;

/**
 * 
 * @author anujchhabra
 * 
 */
public interface UserService {

	public User saveUser(User user);

	public SocialNetwork saveSocialNetwork(SocialNetwork socialNetwork);

	public WorkExperience saveWorkExperience(WorkExperience workExperience);

}
