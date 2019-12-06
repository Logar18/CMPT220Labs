/**
 * @author Logan Farmer <br>
 * 
 * Class that holds information about a grocery item including name, quantity, and price.
 */
import java.text.DecimalFormat;
public class ItemFarmer 
{
	/**
	 * Instance variable for item's name
	 */
	private String myName;
	/**
	 * Instance variable for item's quantity
	 */
	private int myQuant;
	/**
	 * Instance variable for item's price
	 */
	private double myPrice;
	DecimalFormat moneyStyle = new DecimalFormat("$0.00");

	/**
	 * Full Constructor for ItemFarmer
	 * @param newName new item's name
	 * @param newQuant new item's quantity
	 * @param newPrice new item's price
	 */
	public ItemFarmer(String newName, int newQuant, double newPrice)
	{
		myName = newName;
		myQuant = newQuant;
		myPrice = newPrice;
	}//ItemFarmer
	
	/**
	 * Empty constructor for ItemFarmer
	 */
	public ItemFarmer()
	{
		myName = "";
		myQuant = 0;
		myPrice = 0.0;
	}//empty constructor
	
	
	/**
	 * Setter for name
	 * @param newName Incoming name for item
	 */
	public void setName(String newName)
	{
		myName = newName;
	}//setName
	
	/**
	 * Setter for quantity
	 * @param newQuant incoming quantity for item
	 */
	public void setQuant(int newQuant)
	{
		myQuant = newQuant;
	}//setQuant
	
	/**
	 * Setter for price
	 * @param newPrice incoming price for item
	 */
	public void setPrice(double newPrice)
	{
		myPrice = newPrice;
	}//setPrice
	
	
	/**
	 * Getter for name
	 * @return name of item
	 */
	public String getName()
	{
		return myName;
	}//getName
	
	/**
	 * Getter for quantity
	 * @return quantity of item
	 */
	public int getQuant()
	{
		return myQuant;
	}//getQuant
	
	/**
	 * Getter for price
	 * @return price of item
	 */
	public double getPrice()
	{
		return myPrice;
	}//getPrice
	
	/**
	 * toString method to store information about item
	 * @return information about item
	 */
	public String toString()
	{
		String result;
		result = "Item Name: " + myName + "\n";
		result += "Quantity: " + myQuant + "\n";
		result += "Price: " + moneyStyle.format(myPrice) + "\n";
		return result;
	}//toString
	
}//ItemFarmer
