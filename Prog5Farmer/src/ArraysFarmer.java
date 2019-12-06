//
// Logan Farmer
// Prog 5
// Due Date & Time: 3/4/2019 before 1:30 PM
//
// Purpose: The purpose of this program is to offer the user three different programs that can all do various things.
//			
//
// Input: The user will be asked to enter an integer that relates to an integer on the menu, and based on what number they enter,
//		  they will enter a different program, each making the user enter values into arrays.
//		  
//
// Output: The output of this program varies based off of the program that they select to run from the main menu. One program outputs
//	       golf statistics, one outputs either positive or negative numbers, and the other outputs data from an array of negative numbers.	   
//
// I certify that this lab is my own work, but I discussed it with: Jordan Irving



import java.util.*;
public class ArraysFarmer 
{
	//global keyboard for inputs
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) 
	{
		int choice = 0;
		
		//main loop
		do
		{
		//print menu
		System.out.println();
		System.out.println("Choose an option from the menu:");
		System.out.println("1) Let's Go Golfing!");
		System.out.println("2) More Positives or More Negatives?");
		System.out.println("3) How Many Maxes?");
		System.out.println("0) Quit");
		System.out.println();
		choice = keyboard.nextInt();
		
		//switch to assist menu input
		switch (choice)
			{
		case 1: golfing();
				break;
		case 2: positiveNegative();
				break;
		case 3: howManyMaxes();
				break;
		case 0: System.out.println("Goodbye!");
				break;
		default: System.out.println("Invalid Input, please try again.");
				 System.out.println();	 
			}//switch
		}//do
		while (choice != 0);
	}//main
	
	//main method for "Let's go golfing" 
	public static void golfing()
	{
		//variable and array declarations
		int[] parValues = new int[9];
		int[] numStrokes = new int[9];
		int parInput = 0, i = 0, j = 0, strokeInput = 0;
		
		System.out.println("Enter Par Value 1: ");
		parInput = keyboard.nextInt();
		
		//input loop
		while (i <= (parValues.length - 1))
		{
			parValues[i] = parInput;
			i++;
			if (i <= 8)
			{
			System.out.println("Enter Par Value " + (i + 1) + ": ");
			parInput = keyboard.nextInt();
			}//if
		}//while
		
		System.out.println("Enter Strokes for Hole 1: ");
		strokeInput = keyboard.nextInt();
		
		//input loop
		while (j <= (numStrokes.length - 1))
		{
			numStrokes[j] = strokeInput;
			j++;
			if (j <= 8)
			{
			System.out.println("Enter Strokes for Hole " + (j + 1) + ": ");
			strokeInput = keyboard.nextInt();
			}//if
		}//while
		
		golfCalc(parValues, numStrokes);
		
	}//golfing

	//main method for "More Positives or More Negatives?"
	public static void positiveNegative()
	{
		int[] numbers = new int[20];
		int input = 0, h = 0, negativeCount = 0, positiveCount = 0;
		
		//input and input loop
		System.out.println("Enter First Number (or 0 to Quit): ");
		input = keyboard.nextInt();
		while ((input != 0) && (h < (numbers.length - 1)))
		{
			numbers[h] = input;
			if (numbers[h] > 0)
				positiveCount++;
			else negativeCount++;
			h++;
			System.out.println("Enter Number " + (h + 1) + "(or 0 to Quit): ");
			input = keyboard.nextInt();
		}//while
		
		posNegHelper(negativeCount, positiveCount, numbers, h);
	}//positiveNegative
	
	//main method for "How Many Maxes?"
	public static void howManyMaxes()
	{
		//variable and array declaration
		int[] negatives = new int[100];
		int h = 0, input = 0;
		
		//input for negatives array
		System.out.println("Enter Negative Number 1 (or a positive to quit): ");
		input = keyboard.nextInt();
		while ((input < 0) && (h < (negatives.length - 1)))
		{
			negatives[h] = input;
			h++;
			System.out.println("Enter Negative Number " + (h + 1) + "(or a positive to quit): ");
			input = keyboard.nextInt();
		}//while
		
		maxesHelper(negatives, h);
		
	}//howManyTaxes
	
	//calculator method assisting golfing method
	public static void golfCalc(int[] pars, int[] strokes) 
	{
		int i = 0, result = 0, eagles = 0, birdies = 0, numPars = 0, bogeys = 0, doubleBogeys = 0, other = 0;
		
		//for loops to scan arrays and calculate golf results
		for (i = 0; i < pars.length; i++)
		{
			result = strokes[i] - pars[i];
			if (result == 2)
				doubleBogeys++;
			else if (result == 1)
				bogeys++;
			else if (result == 0)
				numPars++;
			else if (result == -1)
				birdies++;
			else if (result == -2)
				eagles++;
			else other++;
			
		}//for
		
		//output for golf game
		System.out.println("Eagles: " + eagles);
		System.out.println("Birdies: " + birdies);
		System.out.println("Pars: " + numPars);
		System.out.println("Bogeys: " + bogeys);
		System.out.println("Double Bogeys: " + doubleBogeys);
		System.out.println("Others: " + other);
		System.out.println();
		
	}//golfCalc
	
	//assistant method for positive/negative
	public static void posNegHelper(int negatives, int positives, int[]nums, int size)
	{
		int i = 0;
		
		//output
		if (negatives < positives)
		{
			System.out.println();
			System.out.println("You had more positives than negatives! Here they are:");
			for (i = 0; i < size; i++)
			{
				if (nums[i] > 0 )
				System.out.println(nums[i]);
			}//for
		}//if
		else if (negatives > positives)
		{
			System.out.println();
			System.out.println("You had more negatives than positives! Here they are:");
			for (i = 0; i < size; i++)
			{
				if (nums[i] < 0 )
				System.out.println(nums[i]);
			}//for
		}//else if
		else
		{
			System.out.println();
			System.out.println("It was a tie! Here are all the numbers:");
			for (i = 0; i < size; i++)
				System.out.println(nums[i]);
		}//else
		
	}//posNegHelper

	//assistant method to help with calculations for how many maxes
	public static void maxesHelper(int[] numbahs, int size)
	{
		//variable declaration
		System.out.println();
		int i = 0, j = 0, k = 0, maxTimes = 0;
		int maxValue = Integer.MIN_VALUE;
		
		//for loops to scan arrays and find necessary information to print
		for (i = 0; i < size; i++)
			System.out.println(numbahs[i]);
		for (j = 0; j < size; j++)
		{
			if (numbahs[j] > maxValue)
				maxValue = numbahs[j];
		}//for
		for (k = 0; k < size; k++)
		{
			if (numbahs[k] == maxValue)
				maxTimes++;
		}//for
		
		//output
		System.out.println();
		System.out.println("Max Value in Array: " + maxValue);
		System.out.println("Times Max Value Appears: " + maxTimes);
		System.out.println();
	}//maxesHelper
}//ArraysFarmer
