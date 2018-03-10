package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.model.IProductDAO;
import com.model.Product;
import com.model.ProductDAO;

@Controller
public class ProductController {
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView home() {
		
		ModelAndView view = new ModelAndView("product");
		view.addObject("HeaderName", "Welcome to Products Page");
		return view;
	}
	
	@RequestMapping(value="/success", method=RequestMethod.POST)
	public ModelAndView productSuccess(@ModelAttribute("product1")Product product)
	{
		ModelAndView mv = new ModelAndView("success");
		mv.addObject("productName",product.getpName());
		
		IProductDAO pd = new ProductDAO();
		pd.insertProduct(product);
		
		return mv;
	}
	
	@RequestMapping(value="/getproducts", method = RequestMethod.GET)
	public ModelAndView getProductList() {
		
		ProductDAO pd = new ProductDAO();
		List<Product> al = pd.getProducts();
		ModelAndView mv = new ModelAndView("listproducts");
		mv.addObject("lp",al);
		return mv;		
	}
	
	@ResponseBody
	@RequestMapping(value="/getjsonproducts", method=RequestMethod.POST)
	public List<Product> getJsonProductList(){
		ProductDAO pd = new ProductDAO();
		List<Product> al = pd.getProducts();
		return al;
	}
	
	
	
	
	
	
	
	
	
}
