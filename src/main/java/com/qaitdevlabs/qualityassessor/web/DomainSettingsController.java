package com.qaitdevlabs.qualityassessor.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qaitdevlabs.qualityassessor.domain.service.DomainService;
import com.qaitdevlabs.qualityassessor.dto.TreeNodeDTO;

/**
 * This controller class is used to create,update,delete domains
 * 
 * @author anujchhabra
 * 
 */
@Controller
public class DomainSettingsController {

	private DomainService domainService;

	@Autowired
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}

	@RequestMapping(value = "/domainSettings", method = RequestMethod.GET)
	public String domainSettingsPage(ModelMap model) {

		return "domainSettings";
	}

	/**
	 * This method handles update operation on domains
	 * 
	 * @param model
	 *            ModelMap
	 * @param key
	 *            key of domain
	 * @param parentKey
	 *            parent key of domain
	 * @param title
	 *            domain name
	 * @param weightage
	 *            weightage of domain
	 * @return true if no exception occurs
	 */
	@RequestMapping(value = "/updateDomain", method = RequestMethod.POST)
	public @ResponseBody
	String updateDomain(ModelMap model, @RequestParam String key,
			@RequestParam String parentKey, @RequestParam String title,
			@RequestParam String weightage) {

		System.out.println("Contoller" + key + " " + parentKey + " " + title
				+ " " + weightage);

		Date modificationDate = new Date();
		TreeNodeDTO dto = new TreeNodeDTO();
		dto.setKey(key);
		dto.setParentKey(parentKey);
		dto.setTitle(title);
		dto.setWeightage(weightage);
		dto.setModificationDate(modificationDate);

		domainService.updateDomain(dto);

		return "true";
	}

	/**
	 * This method handles save operation on domains
	 * 
	 * @param model
	 *            ModelMap
	 * @param parentKey
	 *            parent key of domain
	 * @param title
	 *            domain name
	 * @param weightage
	 *            weightage of domain
	 * @return data transfer object of saved domain
	 */
	@RequestMapping(value = "/saveDomain", method = RequestMethod.POST)
	public @ResponseBody
	TreeNodeDTO saveDomain(ModelMap model, @RequestParam String parentKey,
			@RequestParam String title, @RequestParam String weightage) {

		System.out.println("Contoller" + parentKey + " " + title + " "
				+ weightage);

		Date creationDate = new Date();
		TreeNodeDTO dto = new TreeNodeDTO();
		dto.setParentKey(parentKey);
		dto.setTitle(title);
		dto.setWeightage(weightage);
		dto.setCreationDate(creationDate);

		dto = domainService.saveDomain(dto);
		System.out.println(dto);
		return dto;
	}

	/**
	 * This method handles delete operation on domains
	 * 
	 * @param model
	 *            ModelMap
	 * @param key
	 *            key of domain
	 * @param parentKey
	 *            parent key of domain
	 * @return true if delete operation happened successfulley otherwise return
	 *         false
	 */
	@RequestMapping(value = "/deleteDomain", method = RequestMethod.POST)
	public @ResponseBody
	String deleteDomainMapping(ModelMap model, @RequestParam String key,
			@RequestParam String parentKey) {
		boolean success = domainService.deleteDomain(parentKey, key);
		return String.valueOf(success);
	}

}
