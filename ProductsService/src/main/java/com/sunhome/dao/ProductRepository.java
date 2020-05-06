package com.sunhome.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sunhome.dto.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	public List<Product> findProductByCategory(String category);

	@Query("select product.price from Product product where product.productId = :id")
	public double getPriceById(@Param("id") Integer id);
	
	List<Product> findByProductNameContaining(String title);

}
