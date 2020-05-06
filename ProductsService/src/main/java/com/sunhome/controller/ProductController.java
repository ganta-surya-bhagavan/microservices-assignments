package com.sunhome.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunhome.dto.Product;
import com.sunhome.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping(value="/products/search={name}")
	@ResponseBody
	public List<Product> searchProductByName(@PathVariable("name")String name)
	{
		return productService.findByName(name);
	}
	
	
	@GetMapping(value="/products/price/id={id}")
	@ResponseBody
	public double getPriceById(@PathVariable("id")String id)
	{
		return productService.findPrice(Integer.parseInt(id));
	}
	
	
	@GetMapping(value="/products")
	@ResponseBody
	public List<Product> getAllProducts()
	{
		return productService.getAllProducts();
	}
	
	@GetMapping(value="/products/{id}")
	@ResponseBody
	public Optional<Product> getProductById(@PathVariable("id")String id)
	{
		return productService.findById(Integer.parseInt(id));
	}
	
	@GetMapping(value="/products/{category}")
	@ResponseBody
	public List<Product> getProductByCategory(@PathVariable("category")String category)
	{
		return productService.getByCategory(category);
	}
	
	
}
