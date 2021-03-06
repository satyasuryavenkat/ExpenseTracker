<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Expense List</title>
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
  <h2>Expense List</h2>
  <table class="table table-striped">
   <thead>
    <tr>
     <th scope="row">Expense Type</th>
     <th scope="row">View graph</th>
    </tr>
   </thead>
   <tbody>
    <c:forEach items="${expensetype_list}" var="expense" >
     <tr>
      
      <td>${expense.getExpenseType()}</td>
      <td>
       <spring:url value="/expense/view/${expense.getExpenseType()}" var="updateURL" />
       <a class="btn btn-primary" href="${updateURL}" role="button">View Graph</a>
      </td>
     </tr>
    </c:forEach>
   </tbody>
  </table>
 
 </div>
 
 <center>
  <spring:url value="/expense/list" var="graphURL" />
  <a class="btn btn-primary" href="${graphURL}" role="button">Back</a>
</center>
</body>
</html>