<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Expense</title>
 <link href="http://localhost:8080/webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="http://localhost:8080/webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
 <script src="http://localhost:8080/webjars/jquery/3.0.0/js/jquery.min.js" ></script>
</head>
<body>
<center>
<div style="margin:40px;">
	
			<spring:url value="/expense/" var="addURL" />
  			<a class="btn btn-primary" href="${addURL}" role="button">Home</a>
  			
  			<spring:url value="/expense/list" var="addURL" />
  			<a class="btn btn-primary" href="${addURL}" role="button">View/Add Expenses</a>
  			
  			<spring:url value="/expense/graph" var="addURL" />
  			<a class="btn btn-primary" href="${addURL}" role="button">View ExpenseType Graph</a>
  	
 </div>
</center>

 <div class="container">
  <spring:url value="/expense/save" var="saveURL" />
  <h2>Expense</h2>
  <form:form modelAttribute="expenseForm" method="post" action="${saveURL }" cssClass="form">
   <form:hidden path="id"/>
   <div class="form-group">
    <lable for="ExpenseType">Expense Type</lable>
    
    <form:select path="ExpenseType" cssClass="form-control" id="ExpenseType" >
                     <form:option value = "NONE" label = "Select"/>
                     <form:options items = "${expenseTypeList}" />
                  </form:select> 
   </div>
   
   <div class="form-group">
    <lable for="ExpenseItem">Expense Item</lable>
   <form:select path="ExpenseItem" cssClass="form-control" id="ExpenseItem" >
                     <form:option value = "NONE" label = "Select"/>
                     <form:options items = "${expenseItemList}" />
                  </form:select> 
   </div>
   
   <div class="form-group">
    <lable for="ExpenseMoney">Expense Money</lable>
    <form:input type="number" path="ExpenseMoney" cssClass="form-control" id="ExpenseMoney" />
   </div>
   
   <div class="form-group">
    <lable for="ExpenseDate">Expense Date</lable>
    <form:input type="date" path="ExpenseDate" cssClass="form-control" id="ExpenseDate" />
   </div>
   
   <button type="submit" class="btn btn-primary">Save</button>
  </form:form>
 </div>
</body>
</html>