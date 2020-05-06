package com.sunhome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunhome.service.InventoryService;

@RestController
public class InventoryController {
	@Autowired
	InventoryService invService;
	
	@GetMapping("/products/{productId}")
	@ResponseBody
	public int getProductsCount(@PathVariable("productId")String productId)
	{
		return invService.getStocks(Integer.parseInt(productId));
	}
	
}
