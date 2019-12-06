/**
 * 
 * @author Logan Farmer <br>
 * This is the class containing the shopping cart
 */

public class ShoppingCartFarmer 
{
	/**
	 * Instance variable for the array of items in cart
	 */
	private ItemFarmer[] myItems;
	/**
	 * Instance variable for size of array/number of items in cart.
	 */
	private int mySize;
	
	/**
	 *  default constructor for ShoppingCartFarmer
	 */
	public ShoppingCartFarmer()
	{
		myItems = new ItemFarmer[10];
		for (int i = 0; i < myItems.length; i++)
			myItems[i] = null;
		mySize = 0;
	}//empty constructor
	
	/**
	 * Getter for array size
	 * @return the size of the array
	 */
	public int getSize()
	{
		return mySize;
	}//getSize
	
	/**
	 * Method that adds items to shopping cart array
	 * @param item Reference to a grocery item
	 * @return boolean showing whether the cart is full or not
	 */
	public boolean addToCart(ItemFarmer item)
	{
		boolean full = false;
		if (myItems.length > mySize)
		{
			myItems[mySize] = item;
			mySize++;
		}
		else full = true;
		return full;
	}//addToCart
	
	/**
	 * Method that is used to locate the most expensive item in the shopping cart
	 * @return Most expensive item in shopping cart
	 */
	public ItemFarmer findMostExpenisve()
	{
		int maxItem = 0;
		for (int j = 1; j < mySize; j++)
			if (myItems[j].getPrice() > myItems[maxItem].getPrice())
				maxItem = j;
		return myItems[maxItem];
	}//findMostExpensive
	
	/**
	 * Method that is used to locate the least expensive item in the shopping cart
	 * @return Least expensive item in shopping cart
	 */
	public ItemFarmer findLeastExpensive()
	{
		int minItem = 0;
		for (int k = 1; k < mySize; k++)
			if (myItems[k].getPrice() < myItems[minItem].getPrice())
				minItem = k;
		return myItems[minItem];
	}//findLeastExpensive
	
	/**
	 * Method used to calculate the total cost of all items in the shopping cart
	 * @return Double (total price of all items in shopping cart) 
	 */
	public double calcTotal()
	{
		double totalPrice = 0.0;
		for (int g = 0; g < mySize; g++)
			totalPrice += (myItems[g].getPrice() * myItems[g].getQuant());
		return totalPrice;
	}//calcTotal
	
	/**
	 * Method used to print information about all items in the shopping cart.
	 */
	public void printList()
	{
		for (int x = 0; x < mySize; x++)
		{
			System.out.println();
			System.out.println("Item " + (x+1) + ": ");
			System.out.println(myItems[x].toString());
		}//for
	}//printList
}//ShoppingCartFarmer