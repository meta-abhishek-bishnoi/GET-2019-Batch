package com.metacube.model;

public class Order {
	private int orderId;
	private int productCode;
	int quantity;
	public Order(int orderId, int productCode, int quantity) {
		super();
		this.orderId = orderId;
		this.productCode = productCode;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
