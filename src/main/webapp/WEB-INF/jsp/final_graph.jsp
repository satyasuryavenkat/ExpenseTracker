<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<html>
<head>
<meta charset="ISO-8859-1" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" />
<link th:href="@{/styles/navbar.css}" rel="stylesheet" />
<link th:href="@{/styles/style.css}" rel="stylesheet" />

</head>
<body>
			<div style="margin:40px;">
	<center>
			<spring:url value="/expense/" var="addURL" />
  			<a class="btn btn-primary" href="${addURL}" role="button">Home</a>
  			
  			<spring:url value="/expense/list" var="addURL" />
  			<a class="btn btn-primary" href="${addURL}" role="button">View/Add Expenses</a>
  			
  			<spring:url value="/expense/graph" var="addURL" />
  			<a class="btn btn-primary" href="${addURL}" role="button">View Graph</a>
  	</center>
 </div>
	<div class="container">
		<h2 align="center">Expense Tracker Graph</h2>

		<div id="container"
			style="width: 600px; height: 400px; margin: 0 auto"></div>
			<center>
			<spring:url value="/expense/graph" var="addURL" />
  			<a class="btn btn-primary" href="${addURL}" role="button">Back</a>
  			</center>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://code.highcharts.com/highcharts.js"></script>
	<script src="https://code.highcharts.com/modules/exporting.js"></script>
	<script th:inline="javascript">
    $(function(){
    Highcharts.chart('container', {
        chart: {
            type: 'column'
        },
        title: {
            text: 'Total Spend vs Item'
        },
        subtitle: {
            text: ''
        },
        xAxis: {
        
            categories: 	${itemlist},
            crosshair: true
        },
        yAxis: {
            min: 0,
            max:5000,
            title: {
                text: 'Money Spent in [INR]'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0"><b>{point.y:.1f} INR</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.4,
                borderWidth: 0
            }
        },
        series: [{
            name: 'Items',
            data: ${surveyMap.values()}
        }]
    });
    });
</script>

</body>
</html>