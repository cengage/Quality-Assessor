package com.qaitdevlabs.ptpat.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qaitdevlabs.ptpat.dao.RoleDao;
import com.qaitdevlabs.ptpat.model.Role;
import com.qaitdevlabs.ptpat.model.User;
import com.qaitdevlabs.ptpat.service.ConnectorService;

@Controller
public class HomeController {

	Logger logger = Logger.getLogger(HomeController.class.getName());

	public String urlName;

	public Map<String, String> dataMap = new HashMap<String, String>();

	public String getUrlName() {
		return urlName;
	}

	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}

	public Map<String, String> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, String> dataMap) {
		this.dataMap = dataMap;
	}

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private ConnectorService connectorService;

	public ConnectorService getConnectorService() {
		return connectorService;
	}

	public void setConnectorService(ConnectorService connectorService) {
		this.connectorService = connectorService;
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(ModelMap model, HttpServletRequest request) {

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		HttpSession session = request.getSession();
		User user = (User) auth.getPrincipal();
		session.setAttribute("userCompleteName",
				user.getFirstName() + user.getLastName());
		Role adminRole = roleDao.getRoleByName("ROLE_ADMIN");
		if (auth.getAuthorities().contains(adminRole)) {
			System.out.println("landing admin page");
			session.setAttribute("role", "ROLE_ADMIN");
		} else {
			System.out.println("landing user page");
			session.setAttribute("role", "ROLE_USER");
		}

		// ----- Jenkins Connector Call --------
		String jenkinStatus = connectorService.fetchAndSaveJankinData();
		request.setAttribute("jenkinStatus", jenkinStatus);

		// ---- Jira Connector Call--------
		String jiraStatus = connectorService.fetchAndSaveJiraData();
		request.setAttribute("jiraStatus", jiraStatus);

		return "home";
	}

}
