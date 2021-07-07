package meta.mainApp;

import java.util.ArrayList;
import java.util.Scanner;

import meta.helper.Cart;
import meta.helper.Items;
import meta.helper.ServiceCart;

public class Assignment1 
{
	public static void main(String args[]){
		ServiceCart service = new ServiceCart();
		Scanner scan = new Scanner(System.in); // here scanner is to take input from user
		/*
		 * In this portion(This is for admin or developer portion where we provide items to our application to user)  
		 * we create various object of items in static form 
		 * where they contains item names and their prices in it.
		 * They All Objects are stored in the a ArrayList<E> where E is type of Items class.
		 * Items(String itemName, double price) where 2 parameters are in the form of String and double 
		 * actually contains name of items and price of item
		 */
		ArrayList<Items> listItems = new ArrayList<Items>();
		Items item = new Items("Hot Coffee",99.00);// Create object of Items
		listItems.add(item); // add Object to Array List
		item = new Items("HOT Tea",45.00);
		listItems.add(item);
		item = new Items("Red BUll",129.00);
		listItems.add(item);
		item = new Items("Pizza",145.00);
		listItems.add(item);
		item = new Items("Oreao Shake",99.00);
		listItems.add(item);
		item = new Items("Cold Drink",55.00);
		listItems.add(item);
		
		/*
		 * This portion is for user purpose where user can add, remove, update and printBill(Checkout) 
		 * All the cart items added into a ArrayList<E> where type of E is Cart.
		 */
		ArrayList<Cart> listCartItems= new ArrayList<Cart>(); // initialization of ArrayList.
		Cart cartItem ; 
		int flag=1; // flag is a variable for continuing the while loop
		do{
			System.out.println("Press 1 for Add Items To Cart");
			System.out.println("Press 2 for View Added Items");
			System.out.println("Press 3 for Update Cart Item");
			System.out.println("Press 4 for delete Cart Item");
			System.out.println("Press 5 for generating Bill");
			int choice=0; // choice is a variable for user's choice
			try
			{
				choice = scan.nextInt();
			}catch(Exception e)
			{
				System.out.println("Please Enter A Valid Choice");
				break;
			}
			switch(choice)
			{
				case 1: 
					service.showProducts(listItems);
					// showProducts is used to show the available items 
					System.out.println("\nEnter Product No. To ADD to Cart");
					int productNumber = scan.nextInt();// this take product number of listed item from user
					String cartProductName = listItems.get(productNumber-1).getItemName();
					// in this portion we get name of product from items list to added into cart
					double cartProductPrice = listItems.get(productNumber-1).getPrice();
					// in  this portion we get the listed price value of available item
					System.out.println("Enter Item Quantity :");
					int productQuantity = scan.nextInt(); // this will contains product quantity
					/*
					 * Here We are checking if user Putting Invalid Item Number Then We provide an error message 
					 * actually here we are preventing from null pointer exception
					 */
					if(productQuantity>listItems.size())
					{
						System.out.println("Please Enter Valid Choice");
						break;
					}
					int duplicateId = service.getDuplicateItemId(listCartItems, cartProductName);
					/*
					 * duplicateId gets the id of available items into cart if there is any item into cart then 
					 * it will send the index of that item other wise it returns -1
					 * now if we get -1 then we add that item into cart otherwise 
					 * we update the quantity of that item
					 */
					if(duplicateId==-1)
					{
						cartItem = new Cart(cartProductName, cartProductPrice, productQuantity); // create object of a cart item
						listCartItems.add(cartItem); // add cart item to ArrayList
					}else
					{
						int currentQuantity = listCartItems.get(duplicateId).getItemQuantity();
						listCartItems.get(duplicateId).setItemQuantity(productQuantity+currentQuantity);
						//updating current items's quantity
					}
					break;
				case 2:
					service.showCartItems(listCartItems);
					// here showCartItems(E) function prints the items available in the cart to us 
					// here E is the ArrayList<Cart> 
					break;
				case 3:
					/*
					 * if someone want to update items into empty cart then user will get an error message
					 */
					if(listCartItems==null || listCartItems.size()==0)
					{
						System.out.println("Card Is Empty !!");
						break;
					}
					service.showCartItems(listCartItems);
					// here we are showing available cart items to user
					System.out.println("\nEnter Product No. To Update Quantity");
					int productId = scan.nextInt();// this take product number of listed item from user
					System.out.println("\n Enter New Quantity :");
					int productUpdatedQuantity = scan.nextInt(); //this will take item quantity
					/*
					 * if user updated quantity as 0 or -ve then the item will remove from cart 
					 * otherwise it will updated to that quantity to the cart
					 */
					if ( productUpdatedQuantity<=0 )
						listCartItems.remove(productId-1); // removing item from cart
					else
						listCartItems.get(productId-1).setItemQuantity(productUpdatedQuantity); // updating quantity
					System.out.println("Updated Successful !!!");
					break;
				case 4:
					/*
					 * if someone want to delete items into empty cart then user will get an error message
					 */
					if(listCartItems==null || listCartItems.size()==0)
					{
						System.out.println("Card Is Empty !!");
						break;
					}
					service.showCartItems(listCartItems);
					// here we are showing available cart items to user
					System.out.println("\nEnter Product No. To Update Quantity");
					int deleteProductId = scan.nextInt();// this take product number of listed item from user
					listCartItems.remove(deleteProductId-1); // deleting items from cart
					System.out.println("Deleted Successful !!!");	
					break;
				case 5: 
					service.printBill(listCartItems);
					// this function is to print the bill will total amount
					break;
				default:
					System.out.println("Please Enter A Valid Choice");
			}
			System.out.println("Press 1 to Conti..");
			try
			{
				flag = scan.nextInt();
			}catch(Exception inputException)
			{
				System.out.println("Please Enter A Valid Choice");
				break;
			}
		}while(flag==1);
	}

}
