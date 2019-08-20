package dao;

public class UserOrder {
	int orderId;
	String timestamp;
	double amount;
	
	public UserOrder(int orderId, String timestamp, double amount) {
		super();
		this.orderId = orderId;
		this.timestamp = timestamp;
		this.amount = amount;
	}
	public int getOrderId() {
		return orderId;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public double getAmount() {
		return amount;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
