package com.qaitdevlabs.qualityassessor.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qaitdevlabs.qualityassessor.model.ProductTemplateMap;
import com.qaitdevlabs.qualityassessor.productTemplateMap.service.ProductTemplateMapService;

@Controller
public class ProductReviewController {
	
	private ProductTemplateMapService productTemplateMapService;

	@Autowired
	public void setProductTemplateMapService(
			ProductTemplateMapService productTemplateMapService) {
		this.productTemplateMapService = productTemplateMapService;
	}
	
	@RequestMapping(value = "/productReviews", method = RequestMethod.GET)
	public String getProductsToBeReviewed(HttpServletRequest request) {
		System.out.println("controller");
		List<ProductTemplateMap> matchingProductList = productTemplateMapService
				.getProductsToBeReviewed();
		System.out.println(matchingProductList);
		request.setAttribute("list", matchingProductList);
		return "productReviews";
	}

}
