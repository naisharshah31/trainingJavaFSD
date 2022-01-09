<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
</head>
<body>

<form style="text-align: center;" action="validate-admin-login.jsp"  method="post">
		<h1>Login to your Admin account</h1>
		
		<label>Username: </label>
		<input type="text" name="username" placeholder="john_doe" required>
		
		<br> <br>
		
		<label>Password: </label>
		<input type="password" name="password" required>
		
		 <br> <br> <br>
		
		<input type="submit" value="Login">
		
	</form>


</body>
</html>