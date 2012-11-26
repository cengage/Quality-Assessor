package com.qaitdevlabs.qualityassessor.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qaitdevlabs.qualityassessor.model.Product;
import com.qaitdevlabs.qualityassessor.model.User;
import com.qaitdevlabs.qualityassessor.product.service.ProductService;
import com.qaitdevlabs.qualityassessor.service.UserService;

@Controller
public class ProductController {
	
	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	private ProductService productService;
	
	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	
	@RequestMapping(value = "/myProducts", method = RequestMethod.GET)
	public String getListOfProductsByUser(ModelMap map, HttpServletRequest request) {
		Long userId = (Long) request.getSession().getAttribute("USER_ID");
		User user = userService.getUser(userId);
		List<Product> listOfProducts = productService.getListOfProductsByUser(user);
		map.addAttribute("productList", listOfProducts);
		return "myProductsView";
	}
	
	public List<Product> getMatchingProducts(){
		
	}
	
}
