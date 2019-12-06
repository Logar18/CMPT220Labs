/**
 * 
 * @author Logan <br>
 * This is the class containing the keyed shopping cart, which sorts each item that is entered into it
 * alphabetically. The purpose of this class is to help sort and organize all items in the cart.
 */
public class KeyedListFarmer 
{
	/**
	 * Instance variable for the array of items in the shopping cart.
	 */
	private ItemFarmer[] myItems;
	/**
	 * Instance variable for the size of the array of items.
	 */
	private int mySize;
	
	/**
	 * The default constructor for KeyedListFarmer.
	 */
	public KeyedListFarmer()
	{
		myItems = new ItemFarmer[20];
		for (int i = 0; i < myItems.length; i++)
			myItems[i] = null;
		mySize = 0;
	}//constructor
	
	/**
	 * Method used to clear out the array and replaces all references in the shopping cart with null.
	 */
	public void clear()
	{
		for (int i = 0; i < mySize; i++)
			myItems[i] = null;
		mySize = 0;
	}//clear
	
	/**
	 * Getter for the size of the array.
	 * @return the size of the array.
	 */
	public int getSize()
	{
		return mySize;
	}//getSize
	
	/**
	 * Find method used to find the index of a certain item in the array based off of the item's name.
	 * @param keyValue The name of the item that is being searched for.
	 * @return an integer storing the index of where said item is located in the array.
	 */
	private int findIndex(String keyValue)
	{
		int loc = 0;
		while ((loc < mySize) && (keyValue.compareToIgnoreCase(myItems[loc].getName()) != 0))
			loc++;
		if(mySize == loc)
			return -1;
		else return loc;
		
	}//findIndex
	
	/**
	 * Add method used to add items to the cart by alphabetical order.
	 * @param product The item that is being added to the cart
	 * @return a boolean that will return whether or not the item was added to the cart.
	 */
	public boolean add(ItemFarmer product)
	{
		boolean ans = false;
		String name = product.getName();
		int loc = findIndex(name), k = 0;
		
		if ((loc == -1 ) && (!isFull()))
		{
		while((k < mySize) && (myItems[k].getName().compareToIgnoreCase(name) < 0))
		{
		  k++;
		}//while
			
		for (int i = mySize; i > k; i--)
			myItems[i] = myItems[i - 1];
		myItems[k] = product;
		mySize++;
		ans = true;
		}//if
		return ans;
	}//add

	/**
	 * Removed method used to remove a specific item based on it's name.
	 * @param keyValue the name of the item that the user wishes to remove.
	 * @return a boolean that says whether or not the item was removed.
	 */
	public boolean remove(String keyValue)
	{
		boolean removed = false;
		int loc = findIndex(keyValue);
		if (loc != -1)
		{
		for (int i = loc + 1; i < mySize; i++)
			myItems[i-1] = myItems[i];
		mySize--;
		removed = true;
		}//if
		return removed;
	}//remove
	
	/**
	 * Retrieve method used to search for an item in the cart.
	 * @param keyValue the name of the item the user is searching for.
	 * @return an ItemFarmer if the item is found, and null otherwise.
	 */
	public ItemFarmer retrieve(String keyValue)
	{
		int spot = -1;
		for (int j = 0; j < mySize; j++)
		{
			if (myItems[j].getName().equalsIgnoreCase(keyValue))
			{
				spot = j;
			}//if 
		}//for
		if (spot != -1)
			return myItems[spot];
		else return null;
	}//retrieve

	/**
	 * isEmpty method used to find out whether or not the shopping cart is empty.
	 * @return a boolean that will say whether or not the cart is empty.
	 */
	public boolean isEmpty() 
	{
		boolean result = false;
		if (myItems[0] == null)
			result = true;
		return result;
	}//isEmpty
	
	/**
	 * Method similar to isEmpty; used to find out if the list is full.
	 * @return a boolean that will say whether or not the cart is full.
	 */
	public boolean isFull()
	{
		boolean answer = false;
		if (myItems.length == mySize)
			answer = true;
		return answer;
	}//isFull
	
	/**
	 * Print method to go through the array of items and print out information about items in cart.
	 */
	public void print()
	{
		for (int x = 0; x < mySize; x++)
		{
			System.out.println();
			System.out.println("Item " + (x+1) + ": ");
			System.out.println(myItems[x].toString());
		}//for
	}//print
	
	/**
	 * getCount method is used to find the total number of items in the cart.
	 * @return an integer representing how many total items there are in the shopping cart.
	 */
	public int getCount()
	{
		int count = 0;
		for (int y = 0; y < mySize; y++)
			count += myItems[y].getQuant();
		return count;
	}//getCount
	
	/**
	 * calcTotal method used to calculate the price of all items in the cart by multiplying price * quantity.
	 * @return a double that represents the total cost of all items in the shopping cart. 
	 */
	public double calcTotal()
	{
		double total = 0.0;
		for (int g = 0; g < mySize; g++)
			total += (myItems[g].getPrice() * myItems[g].getQuant());
		return total;
	}//calcTotal
}//KeyedListFarmer
