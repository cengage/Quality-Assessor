package com.qaitdevlabs.ptpat.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qaitdevlabs.ptpat.dto.UserProfileDTO;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		UserProfileDTO userProfileDTO = new UserProfileDTO();
		model.addAttribute("userProfileDTO", userProfileDTO);
		return "login";
	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		UserProfileDTO userProfileDTO = new UserProfileDTO();
		model.addAttribute("userProfileDTO", userProfileDTO);
		model.addAttribute("error", "true");
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "login";
	}
}
