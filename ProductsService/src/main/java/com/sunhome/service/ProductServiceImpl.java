package com.sunhome.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunhome.dao.ProductRepository;
import com.sunhome.dto.Product;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository productDao;

	@Override
	public List<Product> getAllProducts() {
		return productDao.findAll();
	}

	@Override
	public List<Product> findByName(String name) {
		return productDao.findByProductNameContaining(name);
	}

	@Override
	public double findPrice(int productId) {
		return productDao.getPriceById(productId);
	}

	@Override
	public Optional<Product> findById(int id) {
		return productDao.findById(id);
	}

	@Override
	public List<Product> getByCategory(String category) {
		return productDao.findProductByCategory(category);
	}

}
