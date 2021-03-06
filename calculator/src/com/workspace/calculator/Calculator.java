package com.workspace.calculator;

import java.util.*;
import java.text.NumberFormat;

public class Calculator {
	
	private double number1;
	private double number2;
	Scanner scan;
	
	//for formatting the output
	NumberFormat nf;
	
	public Calculator () {
		this.scan = new Scanner(System.in);
		this.nf = NumberFormat.getNumberInstance();
		nf.setGroupingUsed(false) ; // don't group by threes 
		nf.setMaximumFractionDigits(2) ; //we set the max number of decimal digits.
		nf.setMinimumFractionDigits(2) ; //we set the min number of decimal digits.
		
	}
	
	
	void takeInput() {
		System.out.print("enter first number : ");
		this.number1 = scan.nextDouble();
		
		
		System.out.print("enter second number : ");
		this.number2 = scan.nextDouble();
	}
	
	void addition() {
		takeInput();
	
		System.out.println("\n");
		System.out.println("Adding " + number1 + " + " + number2 + " = " + nf.format(this.number1 + this.number2));
	}
	
	
	void subtraction() {
		takeInput();
		
		System.out.println("\n");
		System.out.println("Subtracting " + number1 + " - " + number2 + " = " +  nf.format(this.number1 - this.number2));
	}
	
	void multiplicatin() {
		takeInput();
		
		System.out.println("\n");
		System.out.println("Multipling " + number1 + " - " + number2 + " = " +  nf.format(this.number1 * this.number2));
	}
	
	void divsion() {
		takeInput();
		
		//Validation
		if ( this.number2 == 0 ) {
			System.out.println("Sorry second number cant't be zero");
			takeInput();
		}
		
		System.out.println("\n");
		System.out.println("Dividing " + number1 + " - " + number2 + " = " +  nf.format(this.number1 / this.number2));
	}
	
}
