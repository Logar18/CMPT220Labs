// Logan Farmer
// Prog 6
// Due Date & Time: 3/13/2019 before 1:30 PM
//
// Purpose: The purpose of this program is to print a set of stairs based off of parameters entered by the user, as well
//          as calculate the area of the triangle formed by said stairs.
//			
//
// Input: The user will be able to input step width, number of steps, as well as a fill style that will determine what
//        character is used to from the set of stairs.
//		  
//
// Output: The program is able to output a set of stairs, the area of the stairs, as well as a summary of the 
//         information that is stored about the stairs.
//
// I certify that this lab is my own work.

import java.util.Scanner;
import java.util.*;

public class StepsDemoFarmer {
	
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) 
	{
		//variable and class object initialization
		char choice, styleInput;
		String fake, fake2;
		int stepInput = 0, numInput = 0;
		
		StepsFarmer steps = new StepsFarmer();
		
		//main loop
		do
		{
		//print menu
		System.out.println();
		System.out.println("Choose an option from the menu:");
		System.out.println("W: Assign the Step Width");
		System.out.println("N: Assign the Number of Steps");
		System.out.println("F: Assign Fill Style");
		System.out.println("A: Calculate the Area");
		System.out.println("T: Text Description of the Steps");
		System.out.println("D: Draw the Steps");
		System.out.println("Q: Quit");
		System.out.println();
		fake = keyboard.next();
		choice = Character.toUpperCase(fake.charAt(0));
		
		//switch to assist menu input
		switch (choice)
			{
		case 'W':
				do
				{
				System.out.println("Enter Step Width: ");
				stepInput = keyboard.nextInt();
				steps.setStepWidth(stepInput);
				}//do
				while (stepInput <= 0);
				System.out.println("New Step Width: " + steps.getStepWidth());
				break;
		case 'N':
				do
				{
				System.out.println("Enter Number of Steps: ");
				numInput = keyboard.nextInt();
				steps.setNumSteps(numInput);
				}
				while (numInput <= 0);
				System.out.println("New Number of Steps: " + steps.getNumSteps());
				break;
		case 'F': 
				System.out.println("Enter Fill Style (Character): ");
				fake2 = keyboard.next();
				styleInput = (fake2.charAt(0));
				steps.setFillStyle(styleInput);
				System.out.println("New Fill Style: " + steps.getFillStyle());
				break;
		case 'A':
				System.out.println("The area is: " + steps.calcArea());
				break;
		case 'T':
				System.out.println("Area: " + steps.calcArea());
				System.out.println(steps.toString());
				break;
		case 'D':
				steps.drawSteps();
				break;
		case 'Q': System.out.println("Goodbye!");
				break;
		default: System.out.println("Invalid Input, please try again.");
				 System.out.println();	 
			}//switch
		}//do
		while (choice != 'Q');		

	}//main

}//StepsDemoFarmer
