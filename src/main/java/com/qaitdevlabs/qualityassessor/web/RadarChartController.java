package com.qaitdevlabs.qualityassessor.web;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qaitdevlabs.qualityassessor.common.exception.GenericException;
import com.qaitdevlabs.qualityassessor.domain.service.DomainService;
import com.qaitdevlabs.qualityassessor.dto.RadarChartInfo;
import com.qaitdevlabs.qualityassessor.model.Domain;
import com.qaitdevlabs.qualityassessor.model.User;
import com.qaitdevlabs.qualityassessor.radarchart.service.RadarChartService;
import com.qaitdevlabs.qualityassessor.service.UserService;


@Controller
public class RadarChartController {

	private DomainService domainService;

	@Autowired
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private RadarChartService radarChartService;

	@Autowired
	public void setRadarChartService(RadarChartService radarChartService) {
		this.radarChartService = radarChartService;
	}

	@RequestMapping(value = "assessments/{key}/chart", method = RequestMethod.GET)
	public String showRadarChart(ModelMap model , @PathVariable String key ,HttpServletRequest request) {
		Domain domain = domainService.getDomain(key);
		if(domain == null){
			throw new GenericException("Requested domain doesn't exist!!!");
		}
		else if(!domain.getIsParent()){
			throw new GenericException("Requested domain is not a root domain!!!");
		}
		request.setAttribute("domainName", domain.getDomainName());
		return "radarChart";
	}

	@RequestMapping(value = "/radarChart", method = RequestMethod.GET)
	public String showRadarChart(@RequestParam String key, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {
	
		Long id = Long.valueOf(key);
		Long userId = (Long) request.getSession().getAttribute("USER_ID");
		User user = userService.getUser(userId);
		User assessor = userService.getUser(userId);
		List<RadarChartInfo> extremeChilds = new ArrayList<RadarChartInfo>();
//		domainService.getExtremeChildDomains(id, user, assessor, extremeChilds);

		BufferedImage bufferImage = radarChartService
				.getBufferedImage(extremeChilds);
		response.setContentType("image/png");
		ServletOutputStream os;
		try {
			os = response.getOutputStream();
			ImageIO.write(bufferImage, "png", os);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
