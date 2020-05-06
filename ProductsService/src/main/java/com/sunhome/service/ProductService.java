package com.sunhome.service;

import java.util.List;
import java.util.Optional;

import com.sunhome.dto.Product;

public interface ProductService {
	
	public List<Product> getAllProducts();
	public Optional<Product> findById(int id);
	public List<Product> findByName(String name);
	public double findPrice(int productId);
	public List<Product> getByCategory(String category);

}
