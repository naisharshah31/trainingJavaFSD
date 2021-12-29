<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ include file="include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee details using JSP</title>
</head>
<body>

	
	<jsp:useBean id="emp" class="com.beans.RegistrationDetails"/>
	<jsp:setProperty property="*" name="emp"/>  
	  
	Record:<br>  
	<jsp:getProperty property="username" name="emp"/><br>
	<jsp:getProperty property="age" name="emp"/><br>  
	<jsp:getProperty property="email" name="emp" /><br>
	<jsp:getProperty property="gender" name="emp" /><br>
	<jsp:getProperty property="city" name="emp" /><br>
	

	
	<jsp:include page="sample.jsp"></jsp:include>
	<a href="forward.jsp">Forward using this link</a>
	<jsp:text>All rights reserved!</jsp:text>


</body>
</html>