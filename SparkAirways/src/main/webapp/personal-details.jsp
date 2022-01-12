<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Personal Details | Spark Airways</title>
</head>
<body>

	<%
		//Session check
		if (session.getAttribute("username") == null) {
	        response.sendRedirect("login.jsp?error=1");
		}	
		
		String flight_no = request.getParameter("flight_no");
		if (flight_no == null || flight_no.equals("")) {
            response.sendRedirect("index.jsp?error=1");
    	}
		
		//out.print(flight_no);
		
	%>
	<h1 style="text-align: center;">Please enter your personal details</h1>
	<form style="text-align: center;" action="review.jsp?flight_no=<%= flight_no %>" method="post">
		<label>Full Name: </label>
		<input type="text" name="fullname" required />
		
		<br> <br>
		
		<label>Address: </label>
		<textarea name="address" required> </textarea>
		
		<br> <br>
		
		<label>Age: </label>
		<input type="number" name="age" required>
		
		<br> <br>
		
		<label>Mobile: </label>
		<input type="number" name="mobile" required>
		
		<br> <br>
		
		<label>ID Number: </label>
		<select name="id_type">
			<option name="aadhar_card"> Aadhar Card </option>
			<option name="ssn"> SSN </option>
			<option name="passport"> Passport </option>
			<option name="voter_id"> Voter IDs </option>
			<option name="driving_license"> Driving License </option>
		</select>
		<input type="text" name="id_no" required>
		
		<br> <br>
		
		<label>Email: </label>
		<input type="email" name="email_id" required>
		
		<br> <br>
		
		<label>Country: </label>
		<input type="text" name="country" required>
		
		<br> <br> <br>
		
		<input type="submit" value="Review">
		
		
		
	</form>

</body>
</html>