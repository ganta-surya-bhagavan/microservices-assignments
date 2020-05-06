package com.sunhome.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sunhome.dto.CartItem;

@Repository
public interface CartItemRepository extends CrudRepository<CartItem, Integer> {

}
