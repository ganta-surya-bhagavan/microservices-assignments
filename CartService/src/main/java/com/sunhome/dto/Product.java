package com.sunhome.dto;
public class Product {
	int productId;
	String productName;
	double price;
	String category;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int productId, String productName, double price, String category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.category = category;
	}
	public Product(int productId, String productName,String category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.category=category;
	}
	
	
}
	
	
	
	

