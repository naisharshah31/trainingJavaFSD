package com.lockers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Users {
	
	private long userID;
	private static long idCounter = 0;
	private String firstname;
	private String lastname;
	private String emailID;
	private String contactNumber;
	private String errorMessage;
	
	

	
	public Users( String firstname, String lastname, String emailID, String contactNumber) {
		this.userID = generateUserID();
		errorMessage = "";
		
		validateEmail(emailID);
		validateName(firstname);
		validateName(lastname);
		validateContactNumber(contactNumber);
		
		
		if (errorMessage == "" ) {
			System.out.println("All things valid");
		} else {
			System.out.println(errorMessage);
		}
	}
	
	private void validateContactNumber(String contactNumber) {
		
		if( ! contactNumber.matches("(0/91)?[7-9][0-9]{9}") ) {
			errorMessage += "Please enter a valid mobile number(10 Digits). \n";
		}
	}

	private void validateName(String name) {
		if( ! name.matches("(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$") ) {
			errorMessage += "Please enter valid name (1-25 charcaters(.,'- allowed)). \n";
		}
	}


	private static synchronized long generateUserID()
	{
	    return idCounter++;
	}    
	
	private void validateEmail(String email) {
		String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern mypattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher mymatcher= mypattern.matcher(email);
		if ( ! mymatcher.find() ) {
			errorMessage += "Please enter a valid email. \n";
		} 
	}
	
	
	
}
