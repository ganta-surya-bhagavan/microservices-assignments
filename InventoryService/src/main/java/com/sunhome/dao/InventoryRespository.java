package com.sunhome.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sunhome.dto.Inventory;
@Repository
public interface InventoryRespository extends CrudRepository<Inventory, Integer> {
	
	@Query("SELECT inv.availableUnits from Inventory inv where inv.productId= :id")
	int getStockByProductId(@Param("id")int productId);
	
	
	
}
