package com.sunhome.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Inventory {
	@Id
	int productId;
	int availableUnits;
	
	
	
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Inventory(int productId, int availableUnits) {
		super();
		this.productId = productId;
		this.availableUnits = availableUnits;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getAvailableUnits() {
		return availableUnits;
	}
	public void setAvailableUnits(int availableUnits) {
		this.availableUnits = availableUnits;
	}

}
