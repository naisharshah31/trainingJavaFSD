	
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Playing with JSTL tags</title>
</head>
<body>
	
	<c:set var="empSalary1" value="20000"/>
	<c:set var="empSalary2" value="14000"/>
	<c:set var="empSalary3" value="25000"/>
	<c:set var="empSalary4" value="10000"/>
	
	
	<!-- JUST BECAUSE OF SPACE BETWEEN ITEMS, IT'S GIVING JASPER ERROR -->
	<c:forEach  var="empSalary" items="${empSalary1},${empSalary2},${empSalary3},${empSalary4}"> 
	
		<c:choose>
			<c:when test="${empSalary <= 13000}">
				<c:out value=" Salary ${empSalary}, Bonus of 5000: = " />
				<c:out value="${empSalary + 5000}"/>
				<br/>
			</c:when>
			<c:when test="${empSalary >= 13500 && empSalary <= 21000}">
				<c:out value="Salary ${empSalary}, bonus of 7000 = " />
				<c:out value="${empSalary + 7000}"/>
				<br/>
			</c:when>
			<c:when test="${empSalary} >= 22000 && ${empSalary} <= 26000">
				<c:out value="Salary ${empSalary}, bonus of  9000 = " />
				<c:out value="${empSalary + 9000}"/>
				<br/>
			</c:when>
			<c:when test="${empSalary} >= 28000">
				<c:out value="Salary ${empSalary}, bonus of 10000 = " />
				<c:out value="${empSalary + 10000}"/>
				<br/>
			</c:when>
		</c:choose>
	</c:forEach>


</body>
</html>
