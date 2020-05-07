package com.sunhome.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sunhome.dto.Product;
import com.sunhome.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping(value="/products/search={name}")
	@ResponseBody
	@HystrixCommand(fallbackMethod="searchProductByNameFailure",commandKey="search product by name",groupKey="product service")
	public List<Product> searchProductByName(@PathVariable("name")String name)
	{
		return productService.findByName(name);
	}
	public List<Product> searchProductByNameFailure(String name){
		List<Product> productList = new ArrayList<Product>();
		productList.add(new Product(110,"oneplus","mobiles"));
		productList.add(new Product(111,"relme 5 pro","mobiles"));
		return productList;
	}
	
	
	@GetMapping(value="/products/price/id={id}")
	@ResponseBody
	public double getPriceById(@PathVariable("id")String id)
	{
		return productService.findPrice(Integer.parseInt(id));
	}
	
	
	@GetMapping(value="/products")
	@ResponseBody
	@HystrixCommand(fallbackMethod="getAllProductsFailure",commandKey="get all products",groupKey="product service")
	public List<Product> getAllProducts()
	{
		return productService.getAllProducts();
	}
	public List<Product> getAllProductsFailure(){
		List<Product> productList = new ArrayList<Product>();
		productList.add(new Product(110,"oneplus","mobiles"));
		productList.add(new Product(111,"relme 5 pro","mobiles"));
		return productList;
	}
	
	
	@GetMapping(value="/products/{id}")
	@ResponseBody
	@HystrixCommand(fallbackMethod="getProductByIdFailure",commandKey="get all products by id",groupKey="product service")
	public Optional<Product> getProductById(@PathVariable("id")String id)
	{
		return productService.findById(Integer.parseInt(id));
	}
	public List<Product> getProductByIdFailure(String id){
		List<Product> productList = new ArrayList<Product>();
		productList.add(new Product(110,"oneplus","mobiles"));
		productList.add(new Product(111,"relme 5 pro","mobiles"));
		return productList;
	}
	
	
	@GetMapping(value="/products/{category}")
	@ResponseBody
	@HystrixCommand(fallbackMethod="getProductByCategoryFailure",commandKey="get all products by category",groupKey="product service")
	public List<Product> getProductByCategory(@PathVariable("category")String category)
	{
		return productService.getByCategory(category);
	}
	public List<Product> getProductByCategoryFailure(String category){
		List<Product> productList = new ArrayList<Product>();
		productList.add(new Product(110,"oneplus","mobiles"));
		productList.add(new Product(111,"relme 5 pro","mobiles"));
		return productList;
	}
	
	
	
}
