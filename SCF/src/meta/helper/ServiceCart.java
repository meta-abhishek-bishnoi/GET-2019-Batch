package meta.helper;

import java.util.ArrayList;

public class ServiceCart 
{
	/*
	 * showProducts(ArrayList<Items> items) this function prints the items(Products) added into ArrayList<E>
	 * where type is Items object 
	 * @Param ArrayList<Items> this is list of available items in the shop
	 * This will print Entire list Of that items
	 */
	public void showProducts(ArrayList<Items> listItems) {
		// TODO Auto-generated method stub
		System.out.println("Items(Price)");// this is format where you get itemName(itemPrice)
		/*
		 * starting a loop to print all items
		 */
		for(int i=0; i<listItems.size(); i++)
		{
			String currentItemName = listItems.get(i).getItemName();// name of current item
			double currentItemPrice = listItems.get(i).getPrice();// price of current item
			/*
			 * this will change the line for items
			 */
			if(i%3==0)
				System.out.println();
			System.out.print(i+1+". "+currentItemName+"("+currentItemPrice+" INR)\t");
		}
	}
	/*
	 * showCartItems() this function will print all added items into the cart
	 * @Param ArrayList<Cart> this needs an arraylist of Cart class objects
	 */
	public void showCartItems(ArrayList<Cart> listCartItems) {
		// TODO Auto-generated method stub
		/*
		 * if we get list is null or zero in size then we will return to user with an error message
		 */
		if(listCartItems==null || listCartItems.size()==0)
		{
			System.out.println("Add Items To Cart !!"); // error message to user
			return;
		}
		System.out.println("Items In Cart Are:");
		System.out.println("SN\tItem\tPrice\tQuantity\tAmount");
		/*
		 * this loop will print all items of Arraylist<Cart> to user interface
		 */
		for(int i=0; i<listCartItems.size(); i++)
		{
			String currentItemName = listCartItems.get(i).getItemName();
			double currentItemPrice = listCartItems.get(i).getItemPrice();
			int currentItemQuantity = listCartItems.get(i).getItemQuantity();
			double currentItemAmount = currentItemPrice*currentItemQuantity;
			System.out.println(i+1+"\t"+currentItemName+"\t"+currentItemPrice+"\t"+currentItemQuantity+"\t"+currentItemAmount);
		}
	}
	/*
	 * printBill() function is used to generate the bill of user
	 * @Param ArrayList<Cart> here it will take list of cart items 
	 * and this will calculate the amount for each product wrt to quantity
	 * and also print total billing amount also
	 */
	public void printBill(ArrayList<Cart> listCartItems) 
	{
		// TODO Auto-generated method stub
		/*
		 * if we get list is null or zero in size then we will return to user with an error message
		 */
		if(listCartItems==null|| listCartItems.size()==0)
		{
			System.out.println("Add Items To Cart !!");
			return;
		}
		System.out.println("SN\tItem\tPrice\tQuantity\tAmount");
		System.out.println("----------------------------------");
		int totalAmount=0;// this variable is used to print total amount of bill
		/*
		 * this part takes the variables of Cart class and generate the bill
		 */
		for(int i=0; i<listCartItems.size(); i++)
		{
			String currentItemName = listCartItems.get(i).getItemName();
			double currentItemPrice = listCartItems.get(i).getItemPrice();
			int currentItemQuantity = listCartItems.get(i).getItemQuantity();
			double currentItemAmount = currentItemPrice*currentItemQuantity;
			totalAmount += currentItemAmount;
			System.out.println(i+1+"\t"+currentItemName+"\t"+currentItemPrice+"\t"+currentItemQuantity+"\t"+currentItemAmount);
		}
		System.out.println("----------------------------------");
		System.out.println("\t\t\tTotal Amount\t"+totalAmount);
	}
	/*
	 * getDuplicateItemId() this function is to find if the ArrayList<Cart> contains duplicate items or not
	 * if they find any dupliccate value then it will return that Items's index otherwise it will return -1 
	 */
	public int getDuplicateItemId(ArrayList<Cart> listCartItems, String cartProductName ) {
		// TODO Auto-generated method stub
		int index=-1, i=-1;
		for(Cart item: listCartItems)
		{
			i++;
			if(item.getItemName().equals(cartProductName))
			{
				return i;
			}
		}
		return index;
	}
	
	

}
