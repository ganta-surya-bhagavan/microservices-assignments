package com.sunhome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sunhome.dao.CartItemRepository;
import com.sunhome.dto.CartItem;
import com.sunhome.dto.Product;
@Service
public class CartServiceImpl implements CartService {
	
        @Autowired
        CartItemRepository cartDao;
        @Autowired 
        RestTemplate restTemplate;

	@Override
	public List<Product> addToCart(CartItem item) {
		cartDao.save(item);
		List<Product> productList = restTemplate.getForObject("http://localhost:8082/"+item.getCategory(),List.class); 
		return productList;
	}
	

}
