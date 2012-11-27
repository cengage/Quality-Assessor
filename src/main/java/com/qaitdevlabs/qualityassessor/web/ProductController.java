package com.qaitdevlabs.qualityassessor.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qaitdevlabs.qualityassessor.dto.AjaxResponse;
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
	
	@RequestMapping(value = "/saveOrUpdateProduct", method = RequestMethod.POST)
	public @ResponseBody
	Long saveOrUpdateProduct(HttpServletRequest request,
			@RequestParam String id, @RequestParam String productName,
			@RequestParam String productDescription) {
		System.out.println("contre");
		Long productId = null;
		Product product = null;
		if (!id.equals("")) {
			productId = Long.valueOf(id);
			System.out.println("productId " + productId);
			product = productService.getProductById(productId);
		}
		if (product == null) {
			product = new Product();
		}
		Long userId = (Long) request.getSession().getAttribute("USER_ID");
		User user = userService.getUser(userId);
		product.setUser(user);
		product.setProductId(productId);
		product.setProductName(productName);
		product.setProductDescription(productDescription);
		productService.saveOrUpdateProduct(product);
		return product.getProductId();
	}
	
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
	public @ResponseBody
	AjaxResponse deleteProduct(HttpServletRequest request, HttpServletResponse response,
			@RequestParam String id){
		Long productId = null;
		Product product = null;
		AjaxResponse ajaxResponse = new AjaxResponse();
		if(id.equals("")){
			response.setStatus(500);
			ajaxResponse.setSuccess(false);
			ajaxResponse.setMessage("Deletion UnScuccessfull");
		}
		if (!id.equals("")) {
			productId = Long.valueOf(id);
			System.out.println("productId " + productId);
			product = productService.getProductById(productId);
			if(product != null){
				productService.deleteProduct(product);
				ajaxResponse.setSuccess(true);
				ajaxResponse.setMessage("Deletion Scuccessfull");
			}
		}
		return ajaxResponse;
	}
	
}
