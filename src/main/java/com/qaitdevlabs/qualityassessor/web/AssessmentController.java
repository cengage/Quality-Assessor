package com.qaitdevlabs.qualityassessor.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.qaitdevlabs.qualityassessor.domain.service.DomainService;

@Controller
public class AssessmentController {

	private DomainService domainService;

	@Autowired
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}

	@RequestMapping(value = "/assessment", method = RequestMethod.GET)
	public String getListOfRootDomains(ModelMap map) {
		List<String> listOfRootDomains = domainService.getListOfRootDomains();
		map.addAttribute("listOfRootDomains", listOfRootDomains);
		return "assessment";
	}

}
