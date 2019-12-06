/**
 * 
 * @author Logan Farmer <br>
 * This is the node class, which is used to assist our linked list class.
 */
public class NodeFarmer
{
	/**
	 * Instance variable for myData, and itemFarmer
	 */
	private ItemFarmer myData;
	/**
	 * Instance variable for myNext, also an itemFarmer
	 */
	private NodeFarmer myNext;
	
	/**
	 * Empty constructor for NodeFarmer
	 */
	public NodeFarmer()
	{
		myData = new ItemFarmer();
		myNext = null;
	}//node
	/**
	 * Full Constructor for NodeFarmer
	 * @param itemFarmer
	 */
	public NodeFarmer(ItemFarmer item)
	{
		myData = item;
		myNext = null;
	}//constructor
	/**
	 * Setter for myData
	 * @param product that will be stored in myData
	 */
	public void setData(ItemFarmer product)
	{
		myData = product;
	}//setData
	/**
	 * Getter for data
	 * @return myData, an itemFarmer
	 */
	public ItemFarmer getData()
	{
		return myData;
	}//getData
	/**
	 * Setter for myNext
	 * @param newNode, an itemFarmer
	 */
	public void setNext(NodeFarmer newNode)
	{
		myNext = newNode;
	}//setNext
	/**
	 * Getter for myNext
	 * @return NodeFarmer
	 */
	public NodeFarmer getNext()
	{
		return myNext;
	}//getNext
}//NodeFarmer
