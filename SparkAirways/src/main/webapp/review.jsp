<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Review & Pay | Spark Airways</title>
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
		
		//Fetch details from the form 
		String fullname = request.getParameter("fullname");
		String address = request.getParameter("address");
		int age = Integer.parseInt( request.getParameter("age") );
		String mobile = request.getParameter("mobile");
		String id_type = request.getParameter("id_type");
		String id_no = request.getParameter("id_no");
		String email = request.getParameter("email_id");
		String country = request.getParameter("country");
		String id_type_id_no = id_type + "/" + id_no;
		
		//Flow working properly and fetching all details properly
		/* out.println(flight_no);
		out.println(fullname);
		out.println(address);
		out.println(age);
		out.println(mobile);
		out.println(email);
		out.println(country);
		out.println(id_type_id_no);  */
		
	%>
	<div style="text-align: center;">
		
		<h2>Review and Pay</h2> <br> <br>
		
		<em>Full Name: <%= fullname %></em> <br> <br>
 		<em>Address: <%= address %></em> <br> <br>
		<em>Age: <%= age %></em> <br> <br>
		<em>Mobile: <%= mobile %></em> <br> <br>
		<em>ID: <%= id_type_id_no %></em> <br> <br>
 		<em>Email: <%= email %></em> <br> <br>
		<em>Country: <%= country %></em> <br> <br> <br>
		
		<form action="insert-detail.jsp" method="post">
			
			<!-- Pass details to insert-details.jsp to use hidden form field concept -->
			<input type="hidden" name="flight_no" value="<%= flight_no %>">
			<input type="hidden" name="fullname" value="<%= fullname %>">
			<input type="hidden" name="email" value="<%= email %>">
			<input type="hidden" name="age" value="<%= age %>">
			<input type="hidden" name="mobile" value="<%= mobile %>">
			<input type="hidden" name="address" value="<%= address %>">
			<input type="hidden" name="id_type_id_no" value="<%= id_type_id_no %>">
			<input type="hidden" name="country" value="<%= country %>">
			
			<input type="submit" value="Pay">
		
		</form>
		
	</div>


</body>
</html>