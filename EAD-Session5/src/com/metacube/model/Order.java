/**
* Model Class For orders (Cart Items)
* @author Abhishek Bishnoi
* @since Sept 2,2019
*/
package com.metacube.model;

public class Order {
	private int orderId;
	private int productCode;
	private String productType;
	private String productName;
	private double productPrice;
	private int quantity;
	public Order(int orderId, int productCode, String productType,
			String productName, double productPrice, int quantity) {
		super();
		this.orderId = orderId;
		this.productCode = productCode;
		this.productType = productType;
		this.productName = productName;
		this.productPrice = productPrice;
		this.quantity = quantity;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
