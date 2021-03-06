
import java.util.Scanner;
import java.util.regex.*;

public class RegexClassTask {
	public static void main(String[] args) {
		
		//creation of scanner object to take input of regex and inputString 
		Scanner scan = new Scanner(System.in);
		String regex, inputString;
		
		//regex pattern
		regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		
		//Taking inputString in which regex is searched
		System.out.print("Enter Input String : ");
		inputString = scan.nextLine();
		
		//Output ( validate email and give corresponding output )
		Pattern mypattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher mymatcher= mypattern.matcher(inputString);
		if ( mymatcher.find() ) {
			System.out.println("Valid email! Registration successful :) ");
		} else {
			System.out.println("Please enter a valid email");
		}
		
		
		//Releasing resources.
		scan.close();
		
	}
}
