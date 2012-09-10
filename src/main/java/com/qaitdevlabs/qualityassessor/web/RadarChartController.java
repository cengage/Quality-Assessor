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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qaitdevlabs.qualityassessor.domain.service.DomainService;
import com.qaitdevlabs.qualityassessor.dto.TreeNodeDTO;
import com.qaitdevlabs.qualityassessor.model.User;
import com.qaitdevlabs.qualityassessor.radarchart.service.RadarChartService;
import com.qaitdevlabs.qualityassessor.service.UserService;
import com.qaitdevlabs.qualityassessor.util.RadarChart;

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

	@RequestMapping(value = "/showRadarChart", method = RequestMethod.GET)
	public String showRadarChart(ModelMap model) {
		return "showRadarChart";
	}

	@RequestMapping(value = "/radarChart", method = RequestMethod.GET)
	public String showRadarChart(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		Long id = new Long(1);
		User user = userService.getUser(id);
		User assessor = userService.getUser(id);
		List<TreeNodeDTO> extremeChilds = new ArrayList<TreeNodeDTO>();
		domainService.getExtremeChildDomains(id, user, assessor, extremeChilds);
		System.out.println("childs");
		for (int i = 0; i < extremeChilds.size(); i++) {
			System.out.println(extremeChilds.get(i).getTitle());
		}
		BufferedImage bufferImage = radarChartService
				.getBufferedImage(extremeChilds);
		response.setContentType("image/png");
		ServletOutputStream os;
		try {
			os = response.getOutputStream();
			ImageIO.write(bufferImage, "png", os);
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
