<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.Statement" %>    
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>

<%
 	
		//JSP page to validate whether given username and password is valid or not	
		
        String name = request.getParameter("username");
        String pwd = request.getParameter("password");
        
        if (name == null || name.equals("") || pwd == null || pwd.equals("")) {
                response.sendRedirect("login.jsp?error=1");
        } else {
        	
        	final String url = "jdbc:mysql://localhost:3306/sparkairways";
    	    final String user = "root";
    	    final String dbPassword = "YOUR PASSWORD";
    		
    	    Connection conn;
    	    Statement stmt;
    	    ResultSet rs;
    		
    		Class.forName("com.mysql.jdbc.Driver");

    		conn = DriverManager.getConnection(url, user, dbPassword);
    	    stmt =  conn.createStatement();
    	    
    		String queryString = "SELECT * FROM userlogin WHERE username='" + name +"' AND password= '" + pwd +"' ";
    	    rs = stmt.executeQuery(queryString);
    	    
    	    
    	    if (!rs.next()) { 
    	    	out.print("USERNAME OR PASSWORD IS INCORRECT :(");
    		}
    		else {
    			session.setAttribute("username", name);
    			response.sendRedirect("search.jsp");
    		}
    
        }

   		 
		  		
%>
