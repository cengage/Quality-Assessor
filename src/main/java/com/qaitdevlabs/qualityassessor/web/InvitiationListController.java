package com.qaitdevlabs.qualityassessor.web;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qaitdevlabs.qualityassessor.assessment.service.AssessmentService;
import com.qaitdevlabs.qualityassessor.domain.service.DomainService;
import com.qaitdevlabs.qualityassessor.dto.DomainDTO;
import com.qaitdevlabs.qualityassessor.model.Assessment;
import com.qaitdevlabs.qualityassessor.model.Domain;
import com.qaitdevlabs.qualityassessor.model.User;
import com.qaitdevlabs.qualityassessor.service.UserService;
import com.qaitdevlabs.qualityassessor.util.JsonArray;

@Controller
public class InvitiationListController {

	private AssessmentService assessmentService;

	@Autowired
	public void setAssessmentService(AssessmentService assessmentService) {
		this.assessmentService = assessmentService;
	}

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

	@RequestMapping(value = "/invitationlist", method = RequestMethod.GET)
	public String getListOfApplicationUsers(ModelMap map) {
		List<User> userList = userService.getAllUsers();
		List<DomainDTO> domainList = domainService.getListOfRootDomains();
		System.out.println(domainList.get(0).getName());
		map.addAttribute("userList", userList);
		map.addAttribute("domainList", domainList);

		return "invitationList";
	}

	@RequestMapping(value = "/invitationlist", method = RequestMethod.POST)
	public String saveSelectedUserAndDomainList(
			@SuppressWarnings("rawtypes") @RequestBody List<LinkedHashMap> data,
			HttpServletRequest request) {
		System.out.println(data.get(0).get("userIds"));
		@SuppressWarnings("unchecked")
		List<LinkedHashMap<String, String>> userIds = (List<LinkedHashMap<String, String>>) data
				.get(0).get("userIds");
		@SuppressWarnings("unchecked")
		List<LinkedHashMap<String, String>> domainIds = (List<LinkedHashMap<String, String>>) data
				.get(1).get("domainIds");
		for (int i = 0; i < domainIds.size(); i++) {
			LinkedHashMap<String, String> map = domainIds.get(i);
			System.out.println(map.get("id"));
		}

		Long userId = (Long) request.getSession().getAttribute("USER_ID");
		User user = userService.getUser(Long.valueOf(userId));
		Iterator<LinkedHashMap<String, String>> domainItr = domainIds
				.iterator();
		while (domainItr.hasNext()) {
			String domainId = domainItr.next().get("id");
			Domain domain = domainService.getDomain(domainId);
			Iterator<LinkedHashMap<String, String>> userItr = userIds
					.iterator();
			User assessor;
			while (userItr.hasNext()) {
				userId = Long.valueOf(userItr.next().get("id"));
				assessor = userService.getUser(userId);
				Assessment assessment = new Assessment();
				assessment.setDomain(domain);
				assessment.setAssessor(assessor);
				assessment.setUser(user);
				assessmentService.saveAssessment(assessment);
			}
		}

		return "invitationList";
	}

}
