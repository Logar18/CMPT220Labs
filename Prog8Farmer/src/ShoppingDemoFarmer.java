import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
/**
 * @author Logan Farmer <br>
 * 
 * Prog 7
 * Due Date & Time: 4/1/2019 before 1:30 PM
 *
 * Purpose: The purpose of this program is to keep track of all items in your shopping cart as well as 
 *	        calculate several things about said shopping cart.  
 * Input: The user will be able to input items into the cart, as well as different letters into the menu.
 *
 * Output: The program will output the main menu as well as several useful pieces of information about the
 *	       items in the shopping cart such as the most/least expensive item in the cart, total cost of all
 *	       items in the cart, as well as details about all items in the cart.
 *
 * Certification of Authenticity: <br>
 *	 I certify that this lab is entirely my own work. <br>
 */
public class ShoppingDemoFarmer 
{
	//global keyboard documentation
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) 
	{
		//variable declaration as well as moneystyle object
		ShoppingCartFarmer shoppingCart = new ShoppingCartFarmer();
		String fake, name;
		char choice;
		int quantity = 0, numItems = 0;
		double price = 0.0;
		DecimalFormat moneyStyle = new DecimalFormat("$0.00");
		
		System.out.println("Enter Filename: ");
		String filename = keyboard.next();
		File initialCart = new File(filename);

		
		try
		{
		Scanner input = new Scanner(initialCart);
		numItems = input.nextInt();
		for (int i = 0; i < numItems; i++)
		{
			name = input.next();
			quantity = input.nextInt();
			price = input.nextDouble();
			ItemFarmer newItem = new ItemFarmer(name, quantity, price);
			if (!shoppingCart.addToCart(newItem))
				  System.out.println("Item was Added!");
			else System.out.println("Sorry, but the cart is full! ");
			System.out.println();
		}
		input.close();
    	do 
		{
		//print menu
		System.out.println();
		System.out.println("Choose an option from the menu:");
		System.out.println("A: Add an Item to the Cart");
		System.out.println("L: Find the Least Expensive Item in the Cart");
		System.out.println("M: Find the Most Expensive Item in the Cart");
		System.out.println("N: Find the Number of Items in the Cart");
		System.out.println("T: Find the Total Cost of all Items in the Cart");
		System.out.println("P: Print Out Details About all Items in the Cart");
		System.out.println("Q: Quit");
		System.out.println();
		fake = keyboard.next();
		choice = Character.toUpperCase(fake.charAt(0));
		
		//switch for menu
		switch (choice)
			{
		case 'A': //input for item as well as input validation.
				  System.out.println("Enter Name of Item: ");
				  name = keyboard.next();
				  do
				  {
				  System.out.println("Enter Quantity of Item: ");
				  quantity = keyboard.nextInt();
				  }//do
				  while (quantity <= 0);
				  do
				  {
				  System.out.println("Enter Price of Item: ");
				  price = keyboard.nextDouble();
				  }//do
				  while (price <= 0.0);
				  ItemFarmer newItem = new ItemFarmer(name, quantity, price);
				  if (!shoppingCart.addToCart(newItem))
					  System.out.println("Item was Added!");
				  else System.out.println("Sorry, but the cart is full! ");
				  break;
		case 'L': if (shoppingCart.findLeastExpensive() != null)
				  {
				  System.out.println("The least expensive item in your cart is: "); 
				  System.out.println(shoppingCart.findLeastExpensive().toString());
				  }//if
				  else System.out.println("The Cart is Empty!");
				  break;
		case 'M': if (shoppingCart.findMostExpensive() != null)
				  { 
				  System.out.println("The most expensive item in your cart is: "); 
				  System.out.println(shoppingCart.findMostExpensive().toString());
				  }//if
				  else System.out.println("The Cart is Empty!");
				  break;
		case 'N': System.out.println("Number of Items in Cart: " + shoppingCart.getSize());
				  break;
		case 'T': System.out.println("Total Cost of all Items in Cart: " + moneyStyle.format(shoppingCart.calcTotal()));
				  break;
		case 'P': if (shoppingCart.findLeastExpensive() != null)
				  shoppingCart.printList();
				  else System.out.println("The Cart is Empty!");
				  break;
		case 'Q': System.out.println("Goodbye!");
				  break;
		default:  System.out.println("Invalid Input, please try again!");
				  System.out.println();
			}//switch
		}//do
		while(choice != 'Q');
		}//try
		
		catch(FileNotFoundException ex)
		{
			System.out.println("Failed to find file: " + initialCart.getAbsolutePath());
		}//catch
		catch(NullPointerException ex)
		{
			System.out.println("Null pointer exception.");
			System.out.println(ex.getMessage());
		}//catch
		catch(Exception ex)
		{
			System.out.println("Something went wrong!");
			ex.printStackTrace();
		}//catch
		
		
	}//main

}//ShoppingDemoFarmer
