package com.sunhome.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CartItem {
	
	@Id
	int productId;
	int quantity;
	String category;
	
	
	
	public CartItem(int productId, int quantity, String category) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
