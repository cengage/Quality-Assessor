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
		List<SocialNetwork> socialNetworks = userService
				.getSocialNetworks(user);
		List<WorkExperience> workExperiences = userService
				.getWorkExperiences(user);
		UserProfileDTO userProfileDTO = new UserProfileDTO();

		userProfileDTO.setUsername(user.getUsername());
		userProfileDTO.setFirstName(user.getFirstName());
		userProfileDTO.setLastName(user.getLastName());
		userProfileDTO.setCity(user.getCity());
		userProfileDTO.setState(user.getState());
		userProfileDTO.setZipCode(user.getZipCode());
		// userProfileDTO.setAddress(user.getAddress());
		userProfileDTO.setAddressLine1(user.getAddressLine1());
		userProfileDTO.setAddressLine2(user.getAddressLine2());
		userProfileDTO.setSocialNetworks(socialNetworks);
		userProfileDTO.setWorkExperiences(workExperiences);

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

		// List<String> areaOfExpertise = userProfile.getAreaOfExpertise();
		// List<String> title = userProfile.getTitle();
		// List<Date> fromDate = userProfile.getFromDate();
		// List<Date> toDate = userProfile.getToDate();
		// int size = userProfileForm.getAreaOfExpertise().size();
		// for (int i = 0; i < size; i++) {
		// WorkExperience workExperience = new WorkExperience();
		// workExperience.setAreaOfExpertise(areaOfExpertise.get(i));
		// workExperience.setTitle(title.get(i));
		// workExperience.setFromDate(fromDate.get(i));
		// workExperience.setToDate(toDate.get(i));
		// workExperience.setUser(user);
		// userService.saveWorkExperience(workExperience);
		// }

		// List<String> socialSiteName = userProfileForm.getSocialSiteName();
		// List<String> socialSiteId = userProfileForm.getSocialSiteId();
		// size = socialSiteName.size();
		//
		// for (int i = 0; i < size; i++) {
		// SocialNetwork socialNetwork = new SocialNetwork();
		// socialNetwork.setSocialSiteName(socialSiteName.get(i));
		// socialNetwork.setSocialSiteId(socialSiteId.get(i));
		// socialNetwork.setUser(user);
		// userService.saveSocialNetwork(socialNetwork);
		// }

		return "profile";
	}
}
