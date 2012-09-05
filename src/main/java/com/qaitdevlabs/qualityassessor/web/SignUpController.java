package com.qaitdevlabs.qualityassessor.web;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import com.qaitdevlabs.qualityassessor.Constants;
import com.qaitdevlabs.qualityassessor.dto.UserProfileDTO;
import com.qaitdevlabs.qualityassessor.model.Group;
import com.qaitdevlabs.qualityassessor.model.SocialNetwork;
import com.qaitdevlabs.qualityassessor.model.User;
import com.qaitdevlabs.qualityassessor.model.WorkExperience;
import com.qaitdevlabs.qualityassessor.service.GroupService;
import com.qaitdevlabs.qualityassessor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created with IntelliJ IDEA. User: anujchhabra Date: 28/8/12 Time: 2:29 PM To
 * change this template use File | Settings | File Templates.
 */

@Controller
public class SignUpController {

	private UserService userService;
	private GroupService groupService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String showSignUpPage() {
		return "signUp";
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String getUserDetails(@Valid UserProfileDTO userProfileForm,
			ModelMap map) {
		User user = new User();
		user.setUsername(userProfileForm.getUsername());
		user.setPassword(userProfileForm.getPassword());
		user.setFirstName(userProfileForm.getFirstName());
		user.setLastName(userProfileForm.getLastName());

		Group group = groupService.getGroupByGroupName(Constants.GROUP_OWNER);
		System.out.println(group);
		Set<Group> groups = user.getGroups();
		groups.add(group);
		user.setGroups(groups);
		Date creationDate = new Date();
		user.setCreationDate(creationDate);
		userService.saveUser(user);
		// WorkExperience workExperience = new WorkExper0ience();
		// workExperience.setAreaOfExpertise(userProfileForm.getAreaOfExpertise());
		// workExperience.setTitle(userProfileForm.getTitle());
		// workExperience.setFromDate(userProfileForm.getFromDate());
		// workExperience.setToDate(userProfileForm.getToDate());
		// workExperience.setUser(user);
		//
		// SocialNetwork socialNetwork = new SocialNetwork();
		// socialNetwork.setSocialSiteName(userProfileForm.getSocialSiteName());
		// socialNetwork.setSocialSiteId(userProfileForm.getSocialSiteId());
		// socialNetwork.setUser(user);

		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
				user, user.getPassword(), user.getAuthorities());
		auth.setDetails(user);
		SecurityContextHolder.getContext().setAuthentication(auth);

		/*
		 * userService.saveUser(user);
		 * userService.saveSocialNetwork(socialNetwork);
		 * userService.saveWorkExperience(workExperience);
		 */
		return "redirect:/home";
	}
}
