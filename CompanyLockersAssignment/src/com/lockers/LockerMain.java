package com.lockers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class LockerMain {

	//Insertion sort
	private static String[] sort_sub(String array[], int f){
		String temp="";
		for(int i=0;i<f;i++){
			for(int j=i+1;j<f;j++){
				if(array[i].compareToIgnoreCase(array[j])>0){
					temp = array[i];
					array[i]=array[j];
					array[j]=temp;
				}
			}
		}
		return array;
	}
	
	public static void main(String[] args) {
		
		//Developer Details
		System.out.println("Developer Name: Naishar Shah");
		System.out.println("Designation: Intern at Trivium eSolutions");
		
		int choice;
		
		//Object creation
		Scanner scan = new Scanner(System.in);
		
		
		while(true) {
			
			System.out.println("\n ********************** Company Lockers Pvt. Ltd. ******************************");
			System.out.println("1. List files (Asc.) ");
			System.out.println("2. Delete a file");
			System.out.println("3. Search a file");
			System.out.println("4. Create a file");
			System.out.println("4. Exit ");
			
			System.out.print("Please enter your choice : ");
			
			//Choice Input for calculation
			choice = scan.nextInt();
			
			switch(choice) {
				
				case 1:
					int fileCount = 0;
				    ArrayList<String> filenames = new ArrayList<String>();
					


					File directoryPath = new File(System.getProperty("user.dir"));
					File[] listOfFiles = directoryPath.listFiles();
					fileCount = listOfFiles.length;
					
					
					System.out.println("All files: ");
					for (int i = 0; i < fileCount; i++) {
					  if (listOfFiles[i].isFile()) {
					    filenames.add(listOfFiles[i].getName());
					  } 
					}
					
					String[] str = new String[filenames.size()];
					 
			        for (int i = 0; i < filenames.size(); i++) {
			            str[i] = filenames.get(i);
			        }
					String[] sorted_filenames = sort_sub(str, str.length);
					
					for(String currentFile: sorted_filenames) {
						System.out.println(currentFile);
					}
					
					break;
				
				case 2:
					
					System.out.print("Enter filename to be deleted: ");
					String fileToBeDeleted = scan.next();
					
					File file = new File( (System.getProperty("user.dir") ) + "\\" + fileToBeDeleted );
					if(file.exists()) {
						if ( file.delete() ) {
							System.out.println("File deleted successfully!");
						}
					} else {
						System.out.println("Error 404 (Not Found)");
					}
					break;
				
				case 3:
					
					System.out.println("Please enter filename to be searched: ");
					String fileToBeSearched = scan.next();
					file = new File( (System.getProperty("user.dir") ) + "\\" + fileToBeSearched );
					if(file.exists()) {
						System.out.println("File exits!");
					} else {
						System.out.println("Error 404 (Not Found)");
					}
					break;
				
				case 4:
					
					System.out.println("Please enter filename to be created: ");
					String fileToBeCreated = scan.next();
					file = new File( (System.getProperty("user.dir") ) + "\\" + fileToBeCreated );
					
				try {
					if (file.createNewFile() ) {
						System.out.println("File Created!");
					} else {
						System.out.println("File already exists :(");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				case 5:
					//Releasing scanner resource
					scan.close();
					System.out.println("\n ****************** Exiting ************************");
					System.exit(1);
					break;
				
				default:
					//Releasing scanner resource
					scan.close();
					System.out.println("\n ****************** Exiting ************************");
					System.exit(1);
					break;
				
					
				
			}		
			
		}
	}
}
