//
// Logan Farmer
// Prog 2
// Due Date & Time: 2/11/2019 before 1:30 PM
//
// Purpose: This program will calculate how much money an individual will earn
//			 before and after taxes.
//
// Input: The user will input their name, how many hours they worked that week,
//		   as well as their pay rate.
//
// Output: The program will output the worker's full name, how many hours they worked,
//		    their pay rate, their gross wages, their taxes owed, as well their net pay.
//
// I certify that this lab is my own work, but I discussed it with: Jordan Irving


import java.util.*;
import java.text.*;
public class PayCalculatorFarmer 
{

	public static void main(String[] args) 
	{
		//declaring variables
		String lastName, firstName;
		double payRate = 0, grossPay = 0, netPay = 0, overTimePay1 = 0, overTimePay2 = 0, taxesOwed = 0, taxRate = 0;
		int hours = 0, overTimeHours1 = 0, overTimeHours2 = 0;
		
		//inputs
		Scanner keyboard = new Scanner(System.in);
		DecimalFormat moneyStyle = new DecimalFormat("$0.00");
		System.out.println("Enter your last name.");
		lastName = keyboard.next();
		System.out.println("Enter your first name.");
		firstName = keyboard.next();
		System.out.println("Enter the number of hours worked.");
		hours = keyboard.nextInt();
		System.out.println("Enter your pay rate.");
		payRate = keyboard.nextDouble();
		
		
		//calculator for grossPay
		if (hours <= 40)
			{
			grossPay = hours * payRate;
			} //if 
		else if (hours < 50)
			{
			overTimeHours1 = hours - 40;
			overTimePay1 = overTimeHours1 * (payRate * 1.5);
			grossPay =  (40 * payRate) + overTimePay1;
			} //else if
		else
			{
			overTimeHours2 = hours - 40;
			overTimePay2 = overTimeHours2 * (payRate * 2);
			grossPay = (40 * payRate) + overTimePay2;
			} //else
		
		//Calculator for taxRate
		if (grossPay <= 200.00)
			{
			taxRate = 0.0;
			} //if
		else if (grossPay <= 1000.00)
			{
			taxRate = 0.1;
			}//else if1
		else if (grossPay <= 2250.00)
			{
			taxRate = 0.22;
			}//else if2
		
		else if (grossPay > 2250)
			{
			taxRate = 0.31;
			}//else if3
		
		taxesOwed = grossPay * taxRate;
		netPay = grossPay - taxesOwed;
		
		//outputs
		System.out.println("Worker's Full Name: " + firstName + " " + lastName);
		System.out.println("Hours Worked: " + hours);
		System.out.println("Pay Rate: " + moneyStyle.format(payRate));
		System.out.println("Gross Wages: " + moneyStyle.format(grossPay));
		System.out.println("Taxes Owed: " + moneyStyle.format(taxesOwed));
		System.out.println("Net Pay: " + moneyStyle.format(netPay));
		
		
		

	}//main

}//PayCalculatorFarmer
