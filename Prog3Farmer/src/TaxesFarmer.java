//
// Logan Farmer
// Prog 3
// Due Date & Time: 2/18/2019 before 1:30 PM
//
// Purpose: The purpose of this program is to help calculate tax information for individual users,
//		    as well as to summarize the information that was entered by the user.
//			 
//
// Input: The user will input their tax payer ID, filing status, gross income, and number of exemptions.
//		  The user will be able to enter an infinite amount of tax payers into the system until they input
//		  "0" as their tax payer ID.
//
// Output: This program will output tax information for individual tax payers, as well as
//		   a summary of all the information that the program calculated.
//
// I certify that this lab is my own work, but I discussed it with: Jordan Irving

import java.util.*;
import java.text.*;

public class TaxesFarmer 
{

	public static void main(String[] args) 
	{
		//define and initialize all variables
		String fake;
		char status;
		int taxPayerID = Integer.MAX_VALUE, exemptions = 0, totalTaxpayers = 0, maxTaxPayerID = 0;
		double taxableIncome = 0, grossIncome = 0.0, taxRate = 0.0, taxesOwed = 0.0, maxTax = Integer.MIN_VALUE, totalTaxesPaid = 0.0;
		double averageTax = 0.0;
		//define scanner and decimal formats
		Scanner keyboard = new Scanner(System.in);
		DecimalFormat moneyStyle = new DecimalFormat("$0.00");
		DecimalFormat percentage = new DecimalFormat("00%");
		
		
		//initial input
		System.out.println("Enter Taxpayer ID:");
		taxPayerID = keyboard.nextInt();
		
		//Big while loop
		while (taxPayerID != 0)
		{
		totalTaxpayers++;
		
		//2 do-while loops to validate user input
		do 
			{
			System.out.println("Enter Filing Status (S, M, or H):");
			fake = keyboard.next();
			status = Character.toUpperCase(fake.charAt(0));
			}//do
		while (status != 'S' && status != 'M' && status != 'H');
		
		System.out.println("Enter your Gross Income:");
		grossIncome = keyboard.nextDouble();
		
		do 
			{
			System.out.println("Enter the number of Exemptions:");
			exemptions = keyboard.nextInt();
			}//do
		while (exemptions < 0 || exemptions > 10 );
		
		taxableIncome = grossIncome - 4250 - (1600 * exemptions);
		
		

		//switch to determine tax rate
		switch (status)
		{
			case 'S': 
				if (taxableIncome < 0)
					taxRate = 0.0;
				else if (taxableIncome < 15000)
					taxRate = 0.14;
				else if (taxableIncome <= 50000)
					taxRate = 0.22;
				else taxRate = 0.31;
				break;
			case 'M':
				if (taxableIncome < 0)
					taxRate = 0.0;
				else if (taxableIncome < 25000 )
					taxRate = 0.12;
				else if (taxableIncome <= 135000 )
					taxRate = 0.20;
				else taxRate = 0.29;
			case 'H':
				if (taxableIncome < 0)
					taxRate = 0.0;
				else if (taxableIncome < 30000)
					taxRate = 0.13;
				else if (taxableIncome <= 70000)
					taxRate = 0.21;
				else taxRate = 0.30;
			default: 
				break;			
		}//switch
		
		//output while in loop
		System.out.println("Taxpayer ID: " + taxPayerID);
		if (status == 'S')
			System.out.println("Filing Status: Single");
		else if (status == 'H')
			System.out.println("Filing Status: Head of Household");
		else System.out.println("Filing Status: Married Filing Jointly");
		System.out.println("Taxable Income: " + moneyStyle.format(taxableIncome));
		System.out.println("Tax Rate: " + percentage.format(taxRate));
		taxesOwed = taxableIncome * taxRate;
		if (taxesOwed > maxTax)
			{
			maxTax = taxesOwed;
			maxTaxPayerID = taxPayerID;
			}//if
		
		//calculations for stored data that will output in summary
		totalTaxesPaid = totalTaxesPaid += taxesOwed;
		averageTax = totalTaxesPaid / totalTaxpayers;
		System.out.println("Taxes Owed: " + moneyStyle.format(taxesOwed));
		
		//Re-Input Taxpayer ID
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("Enter Taxpayer ID:");
		taxPayerID = keyboard.nextInt();
		if (taxPayerID == 0)
			{
			taxPayerID = 0;	
			}//if
		
		}//while
		
		//Final Summary Output outside of loop
		System.out.println("");
		System.out.println("");
		System.out.println("Total Number of Taxpayers: " + totalTaxpayers);
		System.out.println("Highest Tax Amount: " + moneyStyle.format(maxTax));
		System.out.println("Taxpayer ID of Highest Tax Amount: " + maxTaxPayerID);
		System.out.println("Total Taxes Paid: " + moneyStyle.format(totalTaxesPaid));
		System.out.println("Average Tax Amount: " + moneyStyle.format(averageTax));
			
		

	}//main

}//TaxesFarmer
