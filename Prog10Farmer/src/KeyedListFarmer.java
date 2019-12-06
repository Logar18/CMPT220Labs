/**
 * 
 * @author Logan <br>
 * This is the class containing the keyed shopping cart, which sorts each item that is entered into it
 * alphabetically. The purpose of this class is to help sort and organize all items in the cart.
 */
public class KeyedListFarmer 
{
	/**
	 * Instance variable for the node representing the first node in the list.
	 */
	private NodeFarmer myHead;
	/**
	 * The default constructor for KeyedListFarmer.
	 */
	public KeyedListFarmer()
	{
		myHead = null;
	}//constructor
	/**
	 * Getter for myHEad
	 * @return NodeFarmer myHead
	 */
	public NodeFarmer getHead()
	{
		return myHead;
	}//getHead
	/**
	 * Setter for head
	 * @param newHead, a new node being added to the list
	 */
	public void setHead(NodeFarmer newHead)
	{
		myHead = newHead;
	}//setHead
	/**
	 * Method used to clear out the array and replaces all references in the shopping cart with null.
	 */
	public void clear()
	{
		myHead = null;
	}//clear
	/**
	 * Add method used to add items to the cart by alphabetical order.
	 * @param newItem The item that is being added to the cart
	 * @return a boolean that will return whether or not the item was added to the cart.
	 */
	public boolean add(ItemFarmer newItem)
	{
		boolean found = false;
		NodeFarmer curr = myHead;
		NodeFarmer newGuy = new NodeFarmer(newItem);
		NodeFarmer prev = null;
		
		if(!(findDuplicate(newGuy.getData().getName())))
		{
		while((curr != null) && (!found))
		{
			
			if((newGuy.getData().getName().compareToIgnoreCase(curr.getData().getName()) < 0))
				found = true;
			else 
			{ 
				prev = curr;
				curr = curr.getNext();
			}//else
		}//while
		
		newGuy.setNext(curr);
		if (prev == null)
		{
			myHead = newGuy;
			found = true;
		}//empty
		else
		{
			prev.setNext(newGuy);
			found = true;
		}//else
		}//if
		return found;
	}//add
	/**
	 * findDuplicate method used to find out if the item is in the list based off of the item's name.
	 * @param name The name of the item that is being searched for.
	 * @return a boolean saying whether or not the Item is in the array.
	 */
	private boolean findDuplicate(String name) 
	{
		NodeFarmer curr = myHead;
		boolean found = false;
		while ((curr != null) && (!found))
		{
			if(curr.getData().getName().equalsIgnoreCase(name))
				found = true;
			else
			{
				curr = curr.getNext();
			}//else
		}//while
		return found;
	}//findDuplicate
	/**
	 * Removed method used to remove a specific item based on it's name.
	 * @param keyValue the name of the item that the user wishes to remove.
	 * @return a boolean that says whether or not the item was removed.
	 */
	public boolean remove(String keyValue)
	{
		boolean found = false;
		NodeFarmer curr = myHead;
		NodeFarmer prev = null;
		
		while((curr != null) && (!found))
		{
			
			if((curr.getData().getName().equalsIgnoreCase(keyValue)))
				found = true;
			else 
			{ 
				prev = curr;
				curr = curr.getNext();
			}//else
		}//while
		if(found)
		{
		if(prev == null)
		{
			myHead = curr.getNext();
		}//if
		else prev.setNext(curr.getNext());
		}//if
		return found;
	}//remove
	/**
	 * Retrieve method used to search for an item in the cart.
	 * @param keyValue the name of the item the user is searching for.
	 * @return an ItemFarmer if the item is found, and null otherwise.
	 */
	public ItemFarmer retrieve(String keyValue)
	{
		boolean found = false;
		NodeFarmer curr = myHead;
		
		while (curr != null && !found)
		{
			if(curr.getData().getName().equalsIgnoreCase(keyValue))
				found = true;
			else 
				curr = curr.getNext();
		}//while
		return curr.getData();
	}//retrieve
	/**
	 * isEmpty method used to find out whether or not the shopping cart is empty.
	 * @return a boolean that will say whether or not the cart is empty.
	 */
	public boolean isEmpty()
	{
		boolean result = false;
		if(myHead == null)
			result = true;
		return result;
	}//isEmpty
	/**
	 * Method similar to isEmpty; used to find out if the list is full.
	 * @return a boolean that will say whether or not the cart is full.
	 */
	public boolean isFull()
	{
		return false;
	}//isFull
	/**
	 * Print method to go through the keyed list and print information about data in the list..
	 */
	public void print()
	{
		int x = 1;
		NodeFarmer curr = myHead;
		while (curr != null)
		{
			System.out.println("Item " + x + ":");
			System.out.println(curr.getData().toString());
			curr = curr.getNext();
			x++;
		}//while
	}//print
	/**
	 * getCount method is used to find the total number of items in the cart.
	 * @return an integer representing how many total items there are in the shopping cart.
	 */
	public int getCount()
	{
		int count = 0;
		NodeFarmer curr = myHead;
		while (curr != null)
		{
			count += curr.getData().getQuant();
			curr = curr.getNext();
		}//while
		return count;
	}//getCount
	/**
	 * calcTotal method used to calculate the price of all items in the cart by multiplying price * quantity.
	 * @return a double that represents the total cost of all items in the shopping cart. 
	 */
	public double calcTotal()
	{
		double total = 0.0;
		NodeFarmer curr = myHead;
		while (curr != null)
		{
			total += curr.getData().getPrice() * curr.getData().getQuant();
			curr = curr.getNext();
		}//while
		return total;
	}//calcTotal
	
}//KeyedListFarmer
