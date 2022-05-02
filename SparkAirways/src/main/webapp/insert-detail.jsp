<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.io.*,java.util.*,java.sql.*, com.mysql.jdbc.Driver"%>  
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!-- Dummy PAYMENT GATEWAY -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Gateway</title>
<style type="text/css">
* {
margin: 0;
padding: 0;
}

body {
font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
font-weight: bold;
}

.container {
height: 900px;
width: 400px;
background-image: linear-gradient(#1e6b30, #308d46);
top: 50%;
left: 50%;
position: absolute;
transform: translate(-50%, -50%);
position: absolute;
border-bottom-left-radius: 180px;
border-top-right-radius: 150px;
}

.main-content {
height: 235px;
background-color: #1b9236;
border-bottom-left-radius: 90px;
border-bottom-right-radius: 80px;
border-top: #1e6b30;
}

.text {
text-align: center;
font-size: 300%;
text-decoration: aliceblue;
color: aliceblue;
}

.course {
color: black;
font-size: 25px;
font-weight: bolder;
}

.centre-content {
height: 180px;
margin: -70px 30px 20px;
color: aliceblue;
text-align: center;
font-size: 20px;
border-radius: 25px;
padding-top: 0.5px;
background-image: linear-gradient(#1e6b30, #308d46);
}

.centre-content-h1 {
padding-top: 30px;
padding-bottom: 30px;
font-weight: normal;
}

.price {
font-size: 60px;
margin-left: 5px;
bottom: 15px;
position: relative;
}

.pay-now-btn {
cursor: pointer;
color: #fff;
height: 50px;
width: 290px;
border: none;
margin: 5px 30px;
background-color: rgb(71, 177, 61);
position: relative;
}

.card-details {
background: rgb(8, 49, 14);
color: rgb(225, 223, 233);
margin: 10px 30px;
padding: 10px;
/* border-bottom-left-radius: 80px; */
}

.card-details p {
font-size: 15px;
}

.card-details label {
font-size: 15px;
line-height: 35px;
}

.submit-now-btn {
cursor: pointer;
color: #fff;
height: 30px;
width: 240px;
border: none;
margin: 5px 30px;
background-color: rgb(71, 177, 61);
}

</style>

</head>
<body>
	<%
		if (session.getAttribute("username") == null) {
	        response.sendRedirect("login.jsp?error=1");
		}
	
		String email = request.getParameter("email");
		int flight_no = Integer.parseInt(request.getParameter("flight_no"));
		
	%>
	
	<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"  
    url="jdbc:mysql://localhost:3306/sparkairways"  
    user="root"  password="Your Password"/>  
    
    
    <sql:update dataSource="${db}" var="res_insert">  
		INSERT INTO register_details VALUES ( "${param.fullname}", "${param.address}", ${param.age}, "${param.mobile}", "${param.email}", "${param.id_type_id_no}", "${param.country}"   );  
	</sql:update>
	
	<div class="container">
      <div class="main-content">
        <p class="text">GeeksforGeeks</p>
      </div>
  
      <div class="centre-content">
        <h1 class="price">2499<span>/-</span></h1>
        <p class="course">
           Buy DSA Self-Paced Course Now !
        </p>
      </div>
  
      <div class="last-content">
        <button type="button" class="pay-now-btn">
           Apply Coupons
        </button>
        <button type="button" class="pay-now-btn">
           Pay with Netbanking
        </button>
  
        <!-- <button type="button" class="pay-now-btn">
        Netbanking options
        </button> -->
      </div>
  
      <div class="card-details">
        <p>Pay using Credit or Debit card</p>
  
        <div class="card-number">
          <label> Card Number </label>
          <input
            type="text"
            class="card-number-field"
            placeholder="###-###-###"/>
        </div>
        <br />
        <div class="date-number">
          <label> Expiry Date </label>
          <input type="text" class="date-number-field" 
                 placeholder="DD-MM-YY" />
        </div>
  
        <div class="cvv-number">
          <label> CVV number </label>
          <input type="text" class="cvv-number-field" 
                 placeholder="xxx" />
        </div>
        <div class="nameholder-number">
          <label> Card Holder name </label>
          <input
            type="text"
            class="card-name-field"
            placeholder="Enter your Name"/>
        </div>
        
        <a href="confirmation.jsp?email=<%= email %>&flight_no=<%= flight_no %>&transaction=sucessful">
        <button type="submit" 
                class="submit-now-btn">
          Submit
        </button>
        </a>
      </div>
    </div>
	

</body>
</html>
