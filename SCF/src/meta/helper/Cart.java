package meta.helper;

public class Cart 
{
	private String itemName; // cart object item name 
	private double itemPrice; // cart object price name
	private int itemQuantity; // cart object quantity
	/*
	 * Cart(String itemName, double itemPrice, int itemQuantity) 
	 * here Cart() is a Constructor with three @Param of cart object
	 * name of item, price of item and quantity of item
	 */
	public Cart(String itemName, double itemPrice,  int itemQuantity){
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
	}
	
	public Cart(){ // this is default constructor		
	}
	/*
	 * These are the getter and setter method of Cart class variables 
	 * these can use to set and return value of them
	 */
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	
}
