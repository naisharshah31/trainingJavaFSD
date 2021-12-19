package com.lockers;

import java.util.Scanner;


public class LockerMain {
	
	public static void main(String[] args) {
		
		//Developer Details
		System.out.println("Developer Name: Naishar Shah");
		System.out.println("Designation: Intern at Trivium eSolutions");
		
		//input for service request number
		int choice;
		
		//Object creation
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			
			//Options
			System.out.println("\n ********************** Company Lockers Pvt. Ltd. ******************************");
			System.out.println("1. List files (Asc.) ");
			System.out.println("2. Delete a file");
			System.out.println("3. Search a file");
			System.out.println("4. Create a file");
			System.out.println("5. Exit ");
			
			System.out.print("Please enter your choice : ");
			
			//Choice Input for calculation
			choice = scan.nextInt();
			
			switch(choice) {
				
				case 1:
					
					//List function feature to list all files in ascending order.
					FileFunctions.listFiles();
					break;
				
				case 2:
					
					//Input for filename to be deleted
					System.out.print("Enter filename to be deleted: ");
					String fileToBeDeleted = scan.next();
					
					//Function to delete a specific file given by user
					FileFunctions.deleteFile(fileToBeDeleted);
					break;
				
				case 3:
					
					//Input for filename to be searched
					System.out.println("Please enter filename to be searched: ");
					String fileToBeSearched = scan.next();
					
					//Function to search a specific file given by user
					FileFunctions.searchFile(fileToBeSearched);
					break;
				
				case 4:
					
					//Input for filename to be created
					System.out.println("Please enter filename to be created: ");
					String fileToBeCreated = scan.next();
					
					//Function to create a specific file given by user
					FileFunctions.createFile(fileToBeCreated);
					break;
					
				case 5:
					
					//Releasing scanner resource
					scan.close();
					System.out.println("\n ****************** Exiting ************************");
					System.exit(1);
					break;
				
				default:
					//Releasing scanner resource
					System.out.println("\n ****************** Please enter an option between 1-5 ************************");
					break;
				
					
				
			}		
			
		}
	}
}
