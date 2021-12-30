<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Marksheet</title>
</head>
<body>

	<b><center> Marksheet </center></b>
	<b>Date: <c:out value="<%=new java.util.Date()%>" /></b> <br> <br>

	<c:set var="subjectMarks1" value="85.2" />  
	<fmt:parseNumber var="subMarks1" integerOnly="true" type="number" value="${subjectMarks1}" />  
    <p><i>Marks 1: </i> <em> <c:out value="${subMarks1}" /> </em> , Total : 100</p>  
	
	
	<c:set var="subjectMarks2" value="55" />
	<fmt:parseNumber var="subMarks2" integerOnly="true" type="number" value="${subjectMarks2}" />    
    <p><i>Marks 2: </i> <em> <c:out value="${subMarks2}" /> </em> , Total : 100</p>
    
    
	<c:set var="subjectMarks3" value="60" />
	<fmt:parseNumber var="subMarks3" integerOnly="true" type="number" value="${subjectMarks3}" />    
    <p><i>Marks 3: </i> <em> <c:out value="${subMarks3}" /> </em> , Total : 100</p>
    
    <c:set var="subjectMarks4" value="88" />
	<fmt:parseNumber var="subMarks4" integerOnly="true" type="number" value="${subjectMarks4}" />    
    <p><i>Marks 4: </i> <em> <c:out value="${subMarks4}" /> </em> , Total : 100</p>
    
    <c:set var="subjectMarks5" value="70" />
	<fmt:parseNumber var="subMarks5" integerOnly="true" type="number" value="${subjectMarks5}" />    
    <p><i>Marks 5: </i> <em> <c:out value="${subMarks5}" /> </em> , Total : 100</p>
    
    <br> <br> <br>
    
    <i>Total marks: 
    	<b>
    			<c:set var="total" value="${subMarks1+subMarks2+subMarks3+subMarks4+subMarks5}" />
    			<c:out value="${total }" /> 
    	</b>
    </i>
    
    <br>
    
    <i>Percentage: 
    	<b>
    			<c:out value="${(total/500)*100}" />% 
    	</b>
    </i>
    
    
    <br>  <br>
    
    <i> Fees paid for semester 1: 
    	<b>
    			<c:set var="fees1" value="1000.2" />
    			<fmt:formatNumber value="${fees1}" currencySymbol="$" type="currency" /></p> 
    	</b>
    </i>
    
    +
    
    <i>Fees paid for semester 2: 
    	<b>
    			<c:set var="fees2" value="800" />
    			<fmt:formatNumber value="${fees2}" currencySymbol="$" type="currency" /></p> 
    	</b>
    </i>
    
    +
    
    <i>Fees paid for semester 3: 
    	<b>
    			<c:set var="fees3" value="900.243" />
    			<fmt:formatNumber value="${fees3}" currencySymbol="$" type="currency" /></p> 
    	</b>
    </i>
    
    +
    
    <i>Fees paid for semester 4: 
    	<b>
    			<c:set var="fees4" value="1000" />
    			<fmt:formatNumber value="${fees4}" currencySymbol="$" type="currency" /></p> 
    	</b>
    </i>
    
    <i> ---------------------------------------------- </i>
    <br>
    
    <i>Total fees: 
    	<b>
    			
    			<fmt:formatNumber value="${fees1+fees2+fees3+fees4}" currencySymbol="$" type="currency" /></p> 
    	</b>
    </i>
    
    

</body>
</html>