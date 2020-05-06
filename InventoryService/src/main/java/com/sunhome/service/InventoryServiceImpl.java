package com.sunhome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunhome.dao.InventoryRespository;

@Service
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	InventoryRespository invDao;
	
	@Override
	public int getStocks(int productId) {
		return invDao.getStockByProductId(productId);	
	}

}
