package com.sunhome.service;

import java.util.List;

import com.sunhome.dto.CartItem;
import com.sunhome.dto.Product;

public interface CartService {
	
	List<Product> addToCart(CartItem item);

}
