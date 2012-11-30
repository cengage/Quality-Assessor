package com.qaitdevlabs.qualityassessor.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductReviewController {

	@RequestMapping(value = "/productReviews")
	public String getProductReviewForm(){
		return "productReviews";
	}
}
