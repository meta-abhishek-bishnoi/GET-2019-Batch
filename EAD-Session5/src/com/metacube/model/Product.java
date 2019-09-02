package com.metacube.model;

public class Product {
	private int productCode;
	private String productType;
	private String productName;
	private double productPrice;
	public Product(int productCode, String productType, String productName,
			double productPrice) {
		super();
		this.productCode = productCode;
		this.productType = productType;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
}
