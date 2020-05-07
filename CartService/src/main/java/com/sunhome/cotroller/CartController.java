package com.sunhome.cotroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sunhome.dto.CartItem;
import com.sunhome.dto.Product;
import com.sunhome.service.CartService;

@EnableHystrix
@EnableHystrixDashboard
@RestController
@EnableDiscoveryClient
public class CartController {
	@Autowired
	CartService cartService;
	@HystrixCommand(fallbackMethod="addToCartFailure",commandKey="Add to cart",groupKey="Cart Service")
	@PostMapping(value="/cart")
	@ResponseBody
	public List<Product> addToCart(@RequestBody CartItem item)
	{
		return cartService.addToCart(item);
	}
	
	public List<Product> addToCartFailure(CartItem item){
		List<Product> productList = new ArrayList<Product>();
		productList.add(new Product(190,"Moto Z","mobiles"));
		productList.add(new Product(192,"Namkeen","snacks"));
		return productList;
	}
	
	
	

}
