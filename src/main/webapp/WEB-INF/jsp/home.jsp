<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expense Tracker</title>
 <link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
 <script src="../webjars/jquery/3.0.0/js/jquery.min.js" ></script>
 <style>
 
 div{
  background-image:url('expense.jpg');
 background-repeat: no-repeat;
 }
 
 </style>
 
</head>
<body>
<center>
<div style="margin:40px;">
	
			<spring:url value="/expense/" var="addURL" />
  			<a class="btn btn-primary" href="${addURL}" role="button">Home</a>
  			
  			<spring:url value="/expense/list" var="addURL" />
  			<a class="btn btn-primary" href="${addURL}" role="button">View/Add Expenses</a>
  			
  			<spring:url value="/expense/graph" var="addURL" />
  			<a class="btn btn-primary" href="${addURL}" role="button">View Graph</a>
  	
 </div>
 
 <h1>Expense Tracker</h1>

</center>
</body>
</html>