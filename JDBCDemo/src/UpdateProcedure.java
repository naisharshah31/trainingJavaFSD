import java.sql.DriverManager;

import java.sql.SQLException;
import java.util.Scanner;
import java.sql.CallableStatement;
import java.sql.Connection;


public class UpdateProcedure {

	private static final String url = "jdbc:mysql://localhost:3306/classdemo";
    private static final String user = "root";
    private static final String password = "YOUR_PASSWORD";
    static String sql = "{call update_price(?,?,?)}";

    
    private static Connection con;
    private static CallableStatement stmt;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      con = DriverManager.getConnection(url, user, password);

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      
		      String sql = "{call update_price_using_authorid (?, ?)}";
		      stmt = con.prepareCall(sql);
		      
		      //Bind IN parameter first, then bind OUT parameter
		      System.out.print("Enetr author_id: ");
		      int author_id = scan.nextInt();
		      stmt.setInt(1, author_id); 
		      
		      System.out.print("Enter new price: ");
		      int price = scan.nextInt();
		      stmt.setInt(2, price); 	      
		      
		      //Use execute method to run stored procedure.
		      System.out.println("Executing stored procedure..." );
		      stmt.executeUpdate();
		      
		      stmt.close();
		      con.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(con!=null)
		            con.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Goodbye!");
		   scan.close();

	}

}
