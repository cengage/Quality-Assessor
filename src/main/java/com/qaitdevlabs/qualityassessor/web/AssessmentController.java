package com.qaitdevlabs.qualityassessor.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.qaitdevlabs.qualityassessor.domain.service.DomainService;
import com.qaitdevlabs.qualityassessor.dto.DomainDTO;
import com.qaitdevlabs.qualityassessor.dto.TreeNodeDTO;

@Controller
public class AssessmentController {

	private DomainService domainService;

	@Autowired
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}

	@RequestMapping(value = "/assessment", method = RequestMethod.GET)
	public String getListOfRootDomains(ModelMap map) {
		List<DomainDTO> listOfRootDomains = domainService.getListOfRootDomains();
		map.addAttribute("listOfRootDomains", listOfRootDomains);
		return "assessment";
	}

	@RequestMapping(value = "/domain", method = RequestMethod.GET)
	public String showDomain(@RequestParam String key,ModelMap map) {
		List<TreeNodeDTO> list = domainService.getDomain(key);
		
		return "domain";
	}
	
}
