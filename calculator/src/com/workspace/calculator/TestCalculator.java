package com.workspace.calculator;

import java.util.*;

public class TestCalculator {

	public static void main(String[] args) {
		
		
		int choice;
		
		//Object creation
		Scanner scan = new Scanner(System.in);
		Calculator calculator = new Calculator();
		
		
		while(true) {
			
			System.out.println("\n ********************** Calculator ******************************");
			System.out.println("1. Addition (+) ");
			System.out.println("2. Subtraction (-) ");
			System.out.println("3. Multiplication (*) ");
			System.out.println("4.. Division (/) ");
			System.out.println("5. Exit ");
			
			System.out.print("Please enter your choice : ");
			
			//Choice Input for calculation
			choice = scan.nextInt();
			
			switch(choice) {
				
				case 1:
					calculator.addition();
					break;
				
				case 2:
					calculator.subtraction();
					break;
				
				case 3:
					calculator.multiplicatin();
					break;
					
				case 4:
					calculator.divsion();
					break;
					
				default:
					//Releasing scanner resource
					scan.close();
					System.out.println("\n ****************** Exiting ************************");
					System.exit(1);
				
			}		
			
		}
		
		
		
	}

}
