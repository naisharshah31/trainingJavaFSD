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
<title>Update Password</title>
</head>
<body>

<%
	//Check session is activate or not (If not return to login)
	if (session.getAttribute("admin_username") == null) {
        response.sendRedirect("login.jsp?error=1");
	}	
	
	//Validation to check whether new password and confirm new password matches or not (If not then return to change password page)
	String new_password = request.getParameter("new_password");
	String confirm_new_password = request.getParameter("confirm_new_password");
	if( ! new_password.matches(confirm_new_password) ) {
		response.sendRedirect("change-password.jsp?error=1");
	}

	
%>

	<!-- Connnection -->
	<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"  
    url="jdbc:mysql://localhost:3306/sparkairways"  
    user="root"  password="NaisharMYSQL"/>  
    
    <!-- UPDATE Query -->
    <sql:update dataSource="${db}" var="updateAdminPassword">  
	UPDATE adminlogin SET password="${param.new_password}" WHERE username="${param.admin_username}";
	</sql:update>
	
	<!-- If password is updated successfully then print respond message -->
	<c:if test="${updateAdminPassword==1}">
	<font size="5" color='green'> Password Updated Successfully.</font>
	</c:if>
    

</body>
</html>