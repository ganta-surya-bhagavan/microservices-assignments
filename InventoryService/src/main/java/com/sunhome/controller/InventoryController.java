package com.sunhome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sunhome.service.InventoryService;

@RestController
public class InventoryController {
	@Autowired
	InventoryService invService;
	
	@GetMapping("/products/{productId}")
	@ResponseBody
	@HystrixCommand(fallbackMethod="getProductsCountFailure",commandKey="Get Avaliable Products",groupKey="Inventory Service")
	public int getProductsCount(@PathVariable("productId")String productId)
	{
		return invService.getStocks(Integer.parseInt(productId));
	}
	
	public int getProductsCountFailure(String productId) {
		return 0;
	}
	
}
