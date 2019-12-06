package meta.helper;

public class Items 
{
	private String itemName; // this contains the name of item
	private double price; // this variable contains price of item
	/*
	 * Items() is constructor to create an object an item
	 * @Param itemName this is name of that item in String form
	 * @param price this is price of that item in double form 
	 * 
	 */
	public Items(String itemName, double price){
		this.setItemName(itemName);
		this.setPrice(price);
	}
	public Items(){
		
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
