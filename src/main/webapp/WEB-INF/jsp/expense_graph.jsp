<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Expense Graph</title>
 <link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
 <script src="../webjars/jquery/3.0.0/js/jquery.min.js" ></script>
</head>
<body>

<div style="margin:40px;">
	<center>
			<spring:url value="/expense/" var="addURL" />
  			<a class="btn btn-primary" href="${addURL}" role="button">Home</a>
  			
  			<spring:url value="/expense/list" var="addURL" />
  			<a class="btn btn-primary" href="${addURL}" role="button">View/Add Expenses</a>
  			
  			<spring:url value="/expense/monthly" var="addURL" />
  			<a class="btn btn-primary" href="${addURL}" role="button">View Monthly Graph</a>
  			
  	</center>
 </div>
 <div class="container">
  <h2>Expense Graph</h2>
  <table class="table table-striped">
   <thead>
    <tr>
     <th scope="row">Expense Type</th>
     <th scope="row">Expense Item</th>
     <th scope="row">Expense Money</th>
     <th scope="row">Expense Date</th>
    </tr>
   </thead>
   <tbody>
    <c:forEach items="${expenseGraph}" var="exp" >
     <tr>
      
      <td>${exp.getExpenseType()}</td>
      <td>${exp.getExpenseItem()}</td>
      <td>${exp.getExpenseMoney()}</td>
      <td>${exp.getExpenseDate()}</td>

     </tr>
    </c:forEach>
   </tbody>
  </table>
  
 </div>
 
</body>
</html>