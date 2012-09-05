package com.qaitdevlabs.qualityassessor.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
	public String getProfilePage(HttpServletRequest request, ModelMap map) {

		Long userId = (Long) request.getSession().getAttribute("USER_ID");
		User user = userService.getUser(userId);

		List<WorkExperience> workExperiences = userService
				.getWorkExperiences(user);
		UserProfileDTO userProfileDTO = new UserProfileDTO();

		userProfileDTO.setUsername(user.getUsername());
		userProfileDTO.setFirstName(user.getFirstName());
		userProfileDTO.setLastName(user.getLastName());
		userProfileDTO.setCountry(user.getCountry());
		userProfileDTO.setCity(user.getCity());
		userProfileDTO.setState(user.getState());
		userProfileDTO.setZipCode(user.getZipCode());
		userProfileDTO.setAddressLine1(user.getAddressLine1());
		userProfileDTO.setAddressLine2(user.getAddressLine2());
		userProfileDTO.setWorkExperiences(workExperiences);

		String facebookId = "";
		String twitterId = "";
		String googleplusId = "";
		String linkedInId = "";
		Long socialNetworkId = null;
		List<SocialNetwork> socialNetworks = userService
				.getSocialNetworks(user);
		if (socialNetworks.size() > 0) {
			SocialNetwork socialNetwork = socialNetworks.get(0);
			facebookId = socialNetwork.getFacebookId();
			twitterId = socialNetwork.getTwitterId();
			googleplusId = socialNetwork.getGoogleplusId();
			linkedInId = socialNetwork.getLinkedInId();
			socialNetworkId = socialNetwork.getSocialNetworkId();
			System.out.println(socialNetworkId);
		}

	

		userProfileDTO.setFacebookId(facebookId);
		userProfileDTO.setTwitterId(twitterId);
		userProfileDTO.setLinkedInId(linkedInId);
		userProfileDTO.setGoogleplusId(googleplusId);
		userProfileDTO.setSocialNetworkId(socialNetworkId);
		map.addAttribute("userProfileDTO", userProfileDTO);

		return "profile";
	}

	
	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String updateUserProfile(@Valid UserProfileDTO userProfileDTO,
			BindingResult result, ModelMap map, HttpServletRequest request) {
		Long userId = (Long) request.getSession().getAttribute("USER_ID");
		User user = userService.getUser(userId);
		user.setUsername(userProfileDTO.getUsername());
		user.setFirstName(userProfileDTO.getFirstName());
		user.setLastName(userProfileDTO.getLastName());
		user.setCountry(userProfileDTO.getCountry());
		user.setCity(userProfileDTO.getCity());
		user.setState(userProfileDTO.getState());
		user.setZipCode(userProfileDTO.getZipCode());
		user.setAddressLine1(userProfileDTO.getAddressLine1());
		user.setAddressLine2(userProfileDTO.getAddressLine2());
		userService.updateUser(user);

		List<WorkExperience> workExperiences = userProfileDTO
				.getWorkExperiences();
		if (workExperiences != null) {
			Iterator<WorkExperience> it = workExperiences.iterator();
			while (it.hasNext()) {
				WorkExperience workExperience = (WorkExperience) it.next();
				workExperience.setUser(user);
				userService.saveWorkExperience(workExperience);
			}
		}

		SocialNetwork socialNetwork = new SocialNetwork();
		socialNetwork.setSocialNetworkId(userProfileDTO.getSocialNetworkId());
		System.out.println("sosocialNetwork"+userProfileDTO.getSocialNetworkId());
		socialNetwork.setUser(user);
		socialNetwork.setFacebookId(userProfileDTO.getFacebookId());
		socialNetwork.setTwitterId(userProfileDTO.getTwitterId());
		socialNetwork.setLinkedInId(userProfileDTO.getLinkedInId());
		socialNetwork.setGoogleplusId(userProfileDTO.getGoogleplusId());
		userService.saveSocialNetwork(socialNetwork);
		

		return "redirect:/profile";
	}
}
