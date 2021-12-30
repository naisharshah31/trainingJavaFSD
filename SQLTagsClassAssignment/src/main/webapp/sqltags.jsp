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
<title>SQL Tags Class Assignment</title>
</head>
<body>
	<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"  
     url="jdbc:mysql://localhost:3306/classdemo"  
     user="root"  password="YOUR_PASSWORD"/>  
	

	<c:out value="1. Insert 5 records in table: " />  
<%-- 	<sql:update dataSource="${db}" var="count">  
	INSERT INTO emp VALUES (129,'Hello', 14000);  
	</sql:update>
	
	
	<sql:update dataSource="${db}" var="count">  
	INSERT INTO emp VALUES (128,'Hello', 24000);  
	</sql:update>
	
	<sql:update dataSource="${db}" var="count">  
	INSERT INTO emp VALUES (123,'Hola', 44000);  
	</sql:update>
	
	<sql:update dataSource="${db}" var="count">  
	INSERT INTO emp VALUES (124,'Namaste', 2000);  
	</sql:update>
	
	<sql:update dataSource="${db}" var="count">  
	INSERT INTO emp VALUES (125,'Heya', 4400);  
	</sql:update>
	 --%>
	<b> Records Inserted...</b>
	
	<br> <br>
	
	<c:out value="2. Update empname to manager where sal > 20000: " />  
	
	<sql:update dataSource="${db}" var="updateEmpSalary">  
	UPDATE emp SET empname='Manager' WHERE salary > 20000;
	</sql:update>
	
	<b> Records Updated...</b>
	
	<br> <br>
	
	<c:out value="3. delete record with empid 102 and 103: " />  
	
	<sql:update dataSource="${db}" var="deleteEmpID">  
	DELETE FROM emp WHERE empid IN (102, 103);
	</sql:update>
	
	<b> Records DELETED...</b>
	
	<br> <br>
	
	<c:out value="4. Fetch all records: " />  
	
	
	<b> Fetching records...</b>
	
	
	<sql:query dataSource="${db}" var="rs">  
		SELECT * FROM emp WHERE empid >= 101 and empid <= 104;  
	</sql:query>  
	
	<table border="2" width="100%">  
<tr>  
<th>Employee ID</th>  
<th>Employee Name</th>  
<th>Salary</th>  

</tr>  
	<c:forEach var="table" items="${rs.rows}">  
		<tr>  
			
			<td><c:out value="${table.empid}"/></td>  
			<td><c:out value="${table.empname}"/></td>  
			<td><c:out value="${table.salary}"/></td>  
			
		</tr>  
	</c:forEach>  
</table>  
	
	
	
	
	

</body>
</html>