package com.qaitdevlabs.qualityassessor.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.qaitdevlabs.qualityassessor.domain.service.DomainService;
import com.qaitdevlabs.qualityassessor.dto.TreeNodeDTO;
import com.qaitdevlabs.qualityassessor.model.User;
import com.qaitdevlabs.qualityassessor.service.UserService;

@Controller
@RequestMapping("/domainHierarchy")
public class DomainHierarchyController {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private DomainService domainService;

	@Autowired
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	TreeNodeDTO getDomainHierarchy(
			@RequestParam String key,
			@RequestParam(value = "requestedUserId", required = false) String requestedUserId,
			ModelMap map, HttpServletRequest request) {
		Long userId = (Long) request.getSession().getAttribute("USER_ID");
		User assessor = userService.getUser(userId);
		System.out.println("requestedUserId" + requestedUserId);
		User user = null;
		if (!requestedUserId.equals("null")) {
			user = userService.getUser(Long.valueOf(requestedUserId));
		} else {
			user = assessor;
		}
		TreeNodeDTO dto = domainService.getDomainHierarchy(Long.valueOf(key),
				assessor, user);
		return dto;
	}
	
}
