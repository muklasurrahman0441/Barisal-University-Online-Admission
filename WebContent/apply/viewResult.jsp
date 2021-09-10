<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
 

<style>

.header
{
left:0;
width:100%;
height:60px;
background-color:#DCDCDC;
text-align:center;
padding:10px;
margin-bottom:10px;
}

</style>


</head>
<body>

   <div class="header">
  <h3>Admission Test Result</h3>    
   </div>
    


<div style="width:50%; margin-left:20%;">
<table  class="table bg-light table-hover text-left ">
    
	<c:forEach var="product" items="${product}">	


               	
			
	
		
		            
			
					<tr>
					<td>Board</td>  
					<td>${product.board}</td> 					
					</tr>					
			         
			         <tr>
						<td>Group</td>
					<td>${product.group}</td>
					</tr>
					
					<tr>
						<td>SSC ROLL</td> 
					<td>${product.roll1}</td>
					</tr>
					
					<tr>
						<td>HSC Roll</td>	
					<td>${product.serial1}</td>
					</tr>
					
					<tr>				
						<td>Student Name</td>
					<td>${product.name}</td>
					</tr>
					
					
					<tr>				
						<td>SSC Result Percentage</td>
					<td>${product.ssc_per}</td>
					</tr>
					
					<tr>				
						<td>HSC Result Percentage</td>
					<td>${product.hsc_per}</td>
					</tr>
					
						
					<tr>				
						<td>Bangla</td>
					<td>${product.ban}</td>
					</tr>
						
					<tr>				
						<td>English</td>
					<td>${product.eng}</td>
					</tr>
						
					<tr>				
						<td>Physics</td>
					<td>${product.phy}</td>
					</tr>
						
					<tr>				
						<td>Chemestry</td>
					<td>${product.che}</td>
					</tr>
						
					<tr>				
						<td>Mathematics</td>
					<td>${product.mat}</td>
					</tr>
						
					<tr>				
						<td>ICT</td>
					<td>${product.ict}</td>
					</tr>
						
					<tr>				
						<td>MCQ</td>
					<td>${product.mcq}</td>
					</tr>
						
					<tr>				
						<td>Total Marks</td>
					<td>${product.g_total}</td>
					</tr>
						
					<tr>				
						<td>Merit position</td>
					<td>${product.merit}</td>
					</tr>
						
					<tr>				
						<td>Pass status</td>
					<td>${product.status}</td>
					</tr>
					
			
					
</c:forEach>
			
			
		</table>
		</div>

<br>


</body>
</html>