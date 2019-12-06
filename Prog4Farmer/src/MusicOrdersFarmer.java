//
// Logan Farmer
// Prog 4
// Due Date & Time: 2/25/2019 before 1:30 PM
//
// Purpose: The purpose of this program is to prompt the user to enter information about their song puchases and to
//			provide them with data about prices of their songs.
//
// Input: The user will enter their name, customer ID, as well as the number of songs ordered initially. Later, they will be asked to 
//		  enter information about individual songs including song length and genre.
//
// Output: This program will output information for each individual customer's song purchases, as well as
//		   a summary of all the information that the program calculated.
//
// I certify that this lab is my own work, but I discussed it with: Jordan Irving

import java.util.*;
import java.text.*;
public class MusicOrdersFarmer 
{
	static Scanner keyboard = new Scanner(System.in); 
	public static void main(String[] args) 
	{
		//Decimal Format for money
		DecimalFormat moneyStyle = new DecimalFormat("$0.00");
		
		//declaring variables
		int customerID = 0, songsOrdered = 0, totalCustomers = 0, maxCustomerID = 0, minCustomerID = 0;
		String name;
		double totalCost = 0.0, serviceCharge = 0.0, totalDue = 0.0, maxAmount = Integer.MIN_VALUE, minAmount = Integer.MAX_VALUE, averageAmountDue = 0.0, totalAmountDue = 0.0;
		
		//Initial Inputs
		do 
		{
			System.out.println("Enter your Customer ID (Between 1000 and 9999):");
			customerID = keyboard.nextInt();
		}//do
		while ((customerID < 1000 || customerID > 9999) && customerID != 0);
		
		//BIG LOOP
		while (customerID != 0)
		{
		totalCustomers++;
		System.out.println("Enter Your Name:");
		name = keyboard.next();
		do
		{
			System.out.println("Enter The Number of Songs Ordered:");
			songsOrdered = keyboard.nextInt();
		}//do
		while (songsOrdered <= 0);
		
		//calling methods
		totalCost = chooseSongs(songsOrdered);
		serviceCharge = calcServiceCharge(songsOrdered, totalCost);
		totalDue = calcTotalDue(totalCost, serviceCharge);
		outputResults(name, customerID, songsOrdered, totalCost, serviceCharge, totalDue);
		
		//keeping track of things
		if (totalDue > maxAmount)
		{
			maxAmount = totalDue;
			maxCustomerID = customerID;
		}//if
		if (totalDue < minAmount)
		{
			minAmount = totalDue;
			minCustomerID = customerID;
		}//if
		totalAmountDue = totalAmountDue += totalDue;
		//Re-Input of Customer ID
		System.out.println("");
		System.out.println("");
		System.out.println("");
		do 
		{
			System.out.println("Enter your Customer ID (Between 1000 and 9999):");
			customerID = keyboard.nextInt();
		}//do
		while ((customerID < 1000 || customerID > 9999) && customerID != 0);
		
		}//big while loop
		
		//averageAmountDue calculation
		averageAmountDue = totalAmountDue / totalCustomers;
		
		//Final Output
		System.out.println("");
		System.out.println("");
		System.out.println("Number of Customers Processed: " + totalCustomers);
		System.out.println("Highest Amount Charged: " + moneyStyle.format(maxAmount));
		System.out.println("Customer ID of Highest Amount: " + maxCustomerID);
		System.out.println("Lowest Amount Charged: " + moneyStyle.format(minAmount));
		System.out.println("Customer ID of Lowest Amount: " + minCustomerID);
		System.out.println("Total Amount Charged to All Customers: " + moneyStyle.format(totalAmountDue));
		System.out.println("Average Amount Charged: " + moneyStyle.format(averageAmountDue));
		
	}//main
	public static double chooseSongs(int numSongs)
	{
		//declaring variables
		String fake;
		double totalCost = 0.0, songCost = 0.0;
		int songNum = 0, songLength = 0;
		char genre;
		//loop so user can input data for all songs
		while (songNum < numSongs)
		{
			do
			{
				System.out.println("Enter song length (in seconds):");
				songLength = keyboard.nextInt();
			}//do
			while (songLength < 1 || songLength > 6000);
			do
			{
				System.out.println("Enter genre:");
				fake = keyboard.next();
				genre = Character.toUpperCase(fake.charAt(0));
			}//do
			while (genre != 'P' && genre != 'R' && genre != 'C' && genre != 'G' && genre != 'O');
			
			//switch to determine the cost of a single song based on genre
			switch (genre)
			{
			case 'P': 
				songCost = songLength * 0.004;
				break;
			case 'R':
				songCost = songLength * 0.0054;
				break;
			case 'C':
				songCost = songLength * 0.0019;
				break;
			case 'G':
				songCost = songLength * 0.003;
				break;
			default:
				songCost = songLength * 0.0025;
				break;	
			}//switch
			totalCost = totalCost += songCost;
			songNum++;
		}//while
		return totalCost;
	}//chooseSongs
	
	public static double calcServiceCharge(int numSongs, double totalCost)
	{
		//If-Else loop to determine the service charge
		double serviceCharge = 0.0;
		if (numSongs <= 4)
			serviceCharge = 0.16;
		else if (numSongs <= 9)
			serviceCharge = 0.13;
		else if (numSongs <= 15)
			serviceCharge = 0.10;
		else serviceCharge = 0.06;
		return serviceCharge;
	}//calcServiceCharge
	
	public static double calcTotalDue(double cost, double charge)
	{
		//Calculating total due
		double totalDue = 0.0;
		totalDue = cost - (cost * charge);
		totalDue = totalDue - (totalDue * 0.07);
		return totalDue;
	}//calcTotalDue
	
	public static void outputResults(String customerName, int ID, int totalSongs, double cost, double charge, double amountDue)
	{
		//DecimalFormat setup so output looks clean and organized
		DecimalFormat moneyStyle = new DecimalFormat("$0.00");
		DecimalFormat percentage = new DecimalFormat("00%");
		
		//output
		System.out.println("Customer Name: " + customerName);
		System.out.println("Customer ID: " + ID);
		System.out.println("Number of Songs Ordered: " + totalSongs);
		System.out.println("Total Cost: " + moneyStyle.format(cost));
		System.out.println("Service Charge: " + percentage.format(charge));
		System.out.println("Total Amount Due: " + moneyStyle.format(amountDue));
	}//outputResults

}//MusicOrdersFarmer
