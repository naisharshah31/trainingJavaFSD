<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
</head>
<body>

<%
	
		if (session.getAttribute("admin_username") == null) {
	        response.sendRedirect("login.jsp?error=1");
		}	

		String admin_username = (String) session.getAttribute("admin_username");
%>

<form style="text-align: center;" action="update-password.jsp" method="post"">
	<label>New Password</label>
	<input type="password" name="new_password"> <br> <br>
	
	<label>Confirm New Password</label>
	<input type="password" name="confirm_new_password"> <br> <br> <br>
	
	<input type="hidden" name="admin_username" value="<%= admin_username  %>">
	
	<input type="submit" value="Chnage Password">
	
</form>

</body>
</html>