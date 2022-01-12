<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*, com.mysql.jdbc.Driver"%>  
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to Spark Airways | Home page</title>
</head>
<body>
<%
		//Session check
        if (session.getAttribute("username") == null) {
                response.sendRedirect("login.jsp?error=1");
        }
%>

<!-- Print welcome message -->
<b>Hello: <%= session.getAttribute("username") %></b><br>

<br> 	

<!-- Connection -->
<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"  
     url="jdbc:mysql://localhost:3306/sparkairways"  
     user="root"  password="NaisharMYSQL"/>  
	

<form style="text-align: center;" action="get-flight.jsp" method="post">
	
	<h2>Search Flight</h2>
	
	<!-- Query to fecth DISTINCT Values from source_city field -->
	<label>From : </label>
	<sql:query dataSource="${db}" var="rs">  
		SELECT DISTINCT(source_city) FROM flight_Details;  
	</sql:query>  
	<select name="source_city">
		<c:forEach var="table" items="${rs.rows}">  
		<option value="${table.source_city}">  
			<c:out value="${table.source_city}"/>  
		</option>  
	</c:forEach>  
	</select>	

	<br> <br>
	<!-- Query to fecth DISTINCT Values from destination_city field -->
	<label>To: </label>
	<sql:query dataSource="${db}" var="rs">  
		SELECT DISTINCT(destination_city) FROM flight_Details;  
	</sql:query>  
	<select name="destination_city">
		<c:forEach var="table" items="${rs.rows}">  
		<option value="${table.destination_city}">  
			<c:out value="${table.destination_city}"/>  
		</option>  
	</c:forEach>  
	</select>	
	
	<br> <br>
	
	<label>Date of travel: </label>
	<input type="date" name="date_of_travel" required />

	<br> <br>
	
	
	<label>No. of persons: </label>
	<select name="no_of_persons">
		<option value="1"> 1 </option>
		<option value="2"> 2 </option>
		<option value="3"> 3 </option>
		<option value="4"> 4 </option>
	</select>
	
	<br> <br> <br>
	
	<input type="submit" value="Search Flight">
	
</form>

</body>
</html>
