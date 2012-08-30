package com.qaitdevlabs.qualityassessor.web;

import javax.validation.Valid;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qaitdevlabs.qualityassessor.dto.UserProfileDTO;
import com.qaitdevlabs.qualityassessor.model.SocialNetwork;
import com.qaitdevlabs.qualityassessor.model.User;
import com.qaitdevlabs.qualityassessor.model.WorkExperience;
import com.qaitdevlabs.qualityassessor.service.UserService;

@Controller
public class UserProfileController {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String getProfilePage() {
		return "profile";
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String updateUserProfile(@Valid UserProfileDTO userProfileForm,
			ModelMap map) {
		User user = new User();
		user.setUsername(userProfileForm.getUsername());
		user.setPassword(userProfileForm.getPassword());
		user.setFirstName(userProfileForm.getFirstName());
		user.setLastName(userProfileForm.getLastName());
		user.setCity(userProfileForm.getCity());
		user.setState(userProfileForm.getState());
		user.setZipCode(userProfileForm.getZipCode());
		user.setAddress(userProfileForm.getAddress());
		Date creationDate = new Date();
		user.setCreationDate(creationDate);
		
		userService.saveUser(user);
		List<String> areaOfExpertise = userProfileForm.getAreaOfExpertise();
		List<String> title = userProfileForm.getTitle();
		List<Date> fromDate = userProfileForm.getFromDate();
		List<Date> toDate = userProfileForm.getToDate();
		int size = userProfileForm.getAreaOfExpertise().size();
		for (int i = 0; i < size; i++) {
			WorkExperience workExperience = new WorkExperience();
			workExperience.setAreaOfExpertise(areaOfExpertise.get(i));
			workExperience.setTitle(title.get(i));
			workExperience.setFromDate(fromDate.get(i));
			workExperience.setToDate(toDate.get(i));
			workExperience.setUser(user);
			userService.saveWorkExperience(workExperience);
		}

		List<String> socialSiteName = userProfileForm.getSocialSiteName();
		List<String> socialSiteId = userProfileForm.getSocialSiteId();
		size = socialSiteName.size();

		for (int i = 0; i < size; i++) {
			SocialNetwork socialNetwork = new SocialNetwork();
			socialNetwork.setSocialSiteName(socialSiteName.get(i));
			socialNetwork.setSocialSiteId(socialSiteId.get(i));
			socialNetwork.setUser(user);
			userService.saveSocialNetwork(socialNetwork);
		}

		return null;
	}
}
