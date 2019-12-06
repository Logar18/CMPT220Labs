import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;
/**
 * @author Logan Farmer <br>
 * 
 * Prog 9
 * Due Date & Time: 4/11/2019 before 1:30 PM <br>
 *
 * Purpose: The purpose of this program is to keep track of all items in your shopping cart (alphabetically) as well as 
 *	        calculate several things about said shopping cart. <br>
 *
 * Input: The user will be able to input items into the cart, as well as different numbers into the menu.
 * 		  The user will also be able to search for items in the cart, as well as input a file containing items.
 *			<br>
 * Output: The program will output the main menu as well as several useful pieces of information about the
 *	       items in the shopping cart such the total number of items, total cost of all items, as well as
 *		   print a list of all of the items in the cart.
 *				<br>
 * Certification of Authenticity: <br>
 *	 I certify that this lab is entirely my own work. <br>
 */
public class ShoppingDemoFarmer 
{
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args)  
	{
		KeyedListFarmer cart = new KeyedListFarmer();
		String name, removeName, searchName, fake;
		int quantity = 0, numItems = 0, choice = Integer.MIN_VALUE;
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
			if (cart.add(newItem))
				  System.out.println("Item was Added!");
			else System.out.println("Sorry, but the item could not be added! ");
			System.out.println();
		}//for
		input.close();
		do 
		{
			System.out.println();
			System.out.println("1. Add an item to the list");
			System.out.println("2. Delete an item from the list");
			System.out.println("3. Print each item in the list");
			System.out.println("4. Search for a user-specified item in the list");
			System.out.println("5. Count the total number of items in the list");
			System.out.println("6. Total the cost of the items in the list");
			System.out.println("7. Determine whether the list is empty");
			System.out.println("8. Determine whether the list is full");
			System.out.println("9. Clear the list");
			System.out.println("0. Quit");
			fake = keyboard.next();
			choice = Character.toUpperCase(fake.charAt(0));
			
			switch (choice)
			{
				case '1': //input for item as well as input validation.
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
					 if (cart.add(newItem))
					   System.out.println("Item was Added!");
					 else System.out.println("Sorry, but the item could not be added! ");
					 break;
				case '2':
					System.out.println("Enter name of item that you would like to remove");
					removeName = keyboard.next();
					if (cart.remove(removeName))
						System.out.println("Item was removed!");
					else System.out.println("Item could not be found in list.");
					break;
				case '3': 
					cart.print();
					break;
				case '4': 
					System.out.println("Enter the name of the item that you would like to search for");
					searchName = keyboard.next();
					if(cart.retrieve(searchName) != null)
						System.out.println("Yes, you have " + cart.retrieve(searchName).getQuant() + " " + cart.retrieve(searchName).getName() + " at " + moneyStyle.format(cart.retrieve(searchName).getPrice()) + ".");
					else System.out.println("No such item was found in your cart.");
					break;
				case '5': 
					System.out.println("Your cart contains a total of " + cart.getCount() + " items.");
					break;
				case '6': 
					System.out.println("The total price of all items in the cart is: " + moneyStyle.format(cart.calcTotal()));
					break;
				case '7': 
					if (cart.isEmpty())
						System.out.println("The cart is empty.");
					else System.out.println("The cart is not empty.");
					break;
				case '8':
					if (cart.isFull())
						System.out.println("The cart is full.");
					else System.out.println("The cart is not full.");
					break;
				case '9': 
					cart.clear();
					System.out.println("The cart was cleared!");
					break;
				case '0':
					System.out.println("Goodbye!");
					break;
				default:
					System.out.println("Invalid input, please try again!");
					System.out.println();
			}//switch
		}//do
		while (choice != '0');
		}//try
		
		//catches to prevent program from crashing
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

}//shoppingDemoFarmer
