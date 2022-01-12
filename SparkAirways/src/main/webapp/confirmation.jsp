<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.io.*,java.util.*,java.sql.*, com.mysql.jdbc.Driver"%>  
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmation</title>
</head>
<body>

<%
	
		if (session.getAttribute("username") == null) {
	        response.sendRedirect("login.jsp?error=1");
		}	

		String transaction_res = request.getParameter("transaction");
		if( ! transaction_res.matches("sucessful")) {
			response.sendRedirect("login.jsp?payment_failed=true");
		} 

%>

	<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"  
    url="jdbc:mysql://localhost:3306/sparkairways"  
    user="root"  password="NaisharMYSQL"/>  
    
    <!-- After successful booking insert into table and print thank you message -->
    <sql:update dataSource="${db}" var="res_insert">  
		INSERT INTO booking_details (email_id, flight_no) VALUES ( "${param.email}", ${param.flight_no} );  
	</sql:update> 
    
    <h2>Thank you <%= session.getAttribute("username") %> for booking with us !!</h2>


</body>
</html>