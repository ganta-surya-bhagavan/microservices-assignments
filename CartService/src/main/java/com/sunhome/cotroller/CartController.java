package com.sunhome.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunhome.dto.CartItem;
import com.sunhome.dto.Product;
import com.sunhome.service.CartService;

@RestController
public class CartController {
	@Autowired
	CartService cartService;
	
	@PostMapping(value="/cart")
	@ResponseBody
	public List<Product> addToCart(@RequestBody CartItem item)
	{
		return cartService.addToCart(item);
	}
	/*@PostMapping("/checkout")
	public String checkOut(@RequestBody CartItem item) {
		return 
	}*/
	
	

}
