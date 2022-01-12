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
<title>Search Details | Spark Airways</title>
</head>
<body>

	<h1 style="text-align: center;">Flight Details</h1>
	<%
		//Check Session is activate or not
		if (session.getAttribute("username") == null) {
	        response.sendRedirect("login.jsp?error=1");
		}	
	 
		//Fetch request params.
	    String source_city = request.getParameter("source_city");
	    String destination_city = request.getParameter("destination_city");
	    String date_of_travel = request.getParameter("date_of_travel");
        
        if (source_city == null || source_city.equals("") || destination_city == null || destination_city.equals("")) {
                response.sendRedirect("index.jsp?error=1");
        }
	%>
	
	
	<!-- Connection -->
	<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"  
    url="jdbc:mysql://localhost:3306/sparkairways"  
    user="root"  password="NaisharMYSQL"/>  
    
    <!-- SELECT Query to FETCH flight details based on different paramaters -->
	<sql:query dataSource="${db}" var="rs">  
		SELECT * FROM flight_details WHERE source_city="${param.source_city}" and destination_city="${param.destination_city}" and date_of_travel="${param.date_of_travel}";
	</sql:query>  
	
	<table border="2" width="100%">  
	<tr>  
	<th>Flight Code</th>
	<th>Source City</th>  
	<th>Destination</th>  
	<th>Date of Travel</th>  
	<th>Price </th>
	
	<!-- Printing flight details -->
	</tr>  
		<c:forEach var="table" items="${rs.rows}">  
			<tr>  
				<td> <a href="personal-details.jsp?flight_no=${table.flight_no}"><c:out value="${table.flight_no}"/></a></td>  
				<td><c:out value="${table.source_city}"/></td>  
				<td><c:out value="${table.destination_city}"/></td>  
				<td><c:out value="${table.date_of_travel}"/></td>  
				<td><c:out value="${table.price}"/></td>
			</tr>  
		</c:forEach>  
	</table>  
	

</body>
</html>