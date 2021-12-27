import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class JDBCMain {
	
	private static final String url = "jdbc:mysql://localhost:3306/classdemo";
    private static final String user = "root";
    private static final String password = "NaisharMYSQL";
    
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    
    private static Scanner scan;
    
    
    
    
    public static void insertDB() throws ClassNotFoundException, SQLException {
    	
    	Class.forName("com.mysql.jdbc.Driver");
    	
    	int empID;
		String empName;
		int salary;
		
    	System.out.print("Enter Employee ID: ");
		empID = scan.nextInt();
		
		System.out.print("Enter Employee Name: ");
		empName = scan.next();
		
		System.out.print("Enter Salary: ");
		salary = scan.nextInt();
		
		
		con = (Connection) DriverManager.getConnection(url, user, password);
		stmt = (Statement) con.createStatement();
	    /*
	     * USING CONCATE
	     * String queryString = "INSERT INTO emp VALUES(" + empID + ", '"+ empName +"',  " + salary +")";
	     */
		
		//USING PreparedStatement
	    String queryString = "INSERT INTO emp VALUES (?, ?, ?)";
	    PreparedStatement stmt=(PreparedStatement) con.prepareStatement(queryString);  
	    stmt.setInt(1, empID);
	    stmt.setString(2, empName);
	    stmt.setInt(3, salary);
	    
	    System.out.println(stmt);
	    
	    int res = stmt.executeUpdate(); 
	    
	    if ( res == 1) {
	    	System.out.println("Insertion successful :)");
	    }
		
	    
    }
	
	public static void updateDB() throws ClassNotFoundException, SQLException {
	    	
    	Class.forName("com.mysql.jdbc.Driver");
    	
    	int empID;
		String empName;
		
		
    	System.out.print("Enter Employee ID where you want to change name: ");
		empID = scan.nextInt();
		
		System.out.print("Enter Employee Name: ");
		empName = scan.next();
		
		
		con = (Connection) DriverManager.getConnection(url, user, password);
	    stmt = (Statement) con.createStatement();
	    String queryString = "UPDATE emp SET empname='"+ empName +"' WHERE empid = " + empID +"";
	    int res = stmt.executeUpdate(queryString); 
	    
	    if ( res == 1) {
	    	System.out.println("Updation successful :)");
	    }
		
    }
    
	public static void deleteDB() throws ClassNotFoundException, SQLException {
    	
    	Class.forName("com.mysql.jdbc.Driver");
    	
    	int empID;
		
    	System.out.print("Enter Employee ID you want to delete: ");
		empID = scan.nextInt();
		
		
		
		
		con = (Connection) DriverManager.getConnection(url, user, password);
	    stmt = (Statement) con.createStatement();
	    String queryString = "DELETE FROM emp WHERE empid = " + empID +"";
	    int res = stmt.executeUpdate(queryString); 
	    
	    if ( res == 1) {
	    	System.out.println("Deletion successful");
	    }
		
    }
	
	public static void retrieve() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver");

		con = (Connection) DriverManager.getConnection(url, user, password);
	    stmt = (Statement) con.createStatement();
	    
		String queryString = "SELECT * FROM emp";
	    rs = stmt.executeQuery(queryString);
	    
	    while (rs.next()) 
    	{ 
    	   int id = rs.getInt(1); 
    	   String name = rs.getString(2); 
    	   String sal = rs.getString(3); 
    	   System.out.printf("empid : %d, empname: %s, salary : %s %n", id, name, sal); 
    	}
	    
	    

	}
	
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		
		
		int choice = 0;
		
		scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("1. Insert");
			System.out.println("2. Update");
			System.out.println("3. Delete");
			System.out.println("4. Retrieve");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			choice = scan.nextInt();
			
			
			switch (choice) {
			case 1: 
				insertDB();
				break;
			case 2:
				updateDB();
				break;
			case 3:
				deleteDB();
				break;
			case 4:
				retrieve();
				break;
			case 5:
				System.out.println("Exiting.......");
				//Releasing resources
				scan.close();
			    con.close();
				System.exit(0);
				
			default:
				scan.close();
				throw new IllegalArgumentException("Unexpected value: " + choice);
				
			}
			
			
			
		}
		
		
	    
		
	}

}
