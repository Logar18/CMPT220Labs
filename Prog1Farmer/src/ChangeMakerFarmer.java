//
//Logan Farmer
//Prog 1
//Due Date and Time: 2/4/19 before 1:30 PM
//
//Purpose:  This program will calculate what kind of change you would give someone
//          based on the amount of money that they enter.
//
//Input:  The input is a keyboard scanner, and the user will input an integer that is
//		  equal to the amount of money that they would like to be made into change.
//
//Output:  The program will output a short message and then output the number of bills and coins
//		   that it would take to give proper change based upon the amount that was entered.
//
// I certify that this lab is entirely my own work.

import java.util.*;

public class ChangeMakerFarmer
{
	//create static keyboard
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args)
	{
		//variable declaration
		int amount = 0, originalAmount = 0, quarters = 0, dimes = 0, nickels = 0, 
		pennies = 0, ones = 0, fives = 0, tens = 0, twenties = 0, totalBills = 0, totalCoins = 0;
		
		//prompt user for input
		System.out.println("Enter a whole number.");
		System.out.println("I will output a combination of coins and bills");
		System.out.println("that equals the amount of change.");
		amount = keyboard.nextInt();
		
		//calculations for amount of bills
		originalAmount = amount;
		twenties = amount/2000;
		amount = amount%2000;
		tens = amount/1000;
		amount = amount%1000;
		fives = amount/500;
		amount = amount%500;
		ones = amount/100;
		amount = amount%100;
		//calculations for amount of coins
		quarters = amount/25;
		amount = amount%25;
		dimes = amount/10;
		amount = amount%10;
		nickels = amount/5;
		amount = amount%5;
		pennies = amount;
		
		//calculations for total number of bills and total number of coins
		totalBills = (twenties + tens + fives + ones);
		totalCoins = (quarters + dimes + nickels + pennies);
		
		//output
		System.out.println(originalAmount + " can be given as:");
		System.out.println(twenties + " twenties");
		System.out.println(tens + " tens");
		System.out.println(fives + " fives");
		System.out.println(ones + " ones");
		System.out.println(quarters + " quarters");
		System.out.println(dimes + " dimes");
		System.out.println(nickels + " nickels");
		System.out.println(pennies + " pennies");
		System.out.println(totalBills + " bills");
		System.out.println(totalCoins  + " coins");
		
	} //main
} //ChangeMakerFarmer