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
height100px;
background-color:rgb(248, 255, 245);
text-align:center;
padding:10px;
margin-bottom:10px;
}

.table1
{

width:50%;
margin-left:25%;
margin-bottom:20px;
padding:10px;
background-color:rgb(248, 255, 245);
}


</style>


</head>
<body>

  <div class="header">
   <h3 class="text-success">    
  Payment Processing 
   
   </h3>  


 </div>


<div class="table1">

	<c:forEach var="product" items="${product}">	


               	
	<b>Complete Payment :  </b> <a href="/admission/apply/payment.jsp?hscroll=${product.hscroll}&name=${product.name}&unit=${product.unit}&roll=${product.roll}"> Payment here</a> 
		
		<hr>


					<img alt="" src="/admission/showImage?id=${product.id}" width="100px"  height="100px" >  

		<table>
	
	                           	 <tr>			
						
										<td><b>Payment Status</b></td> 
										<td>${product.payment}</td>
									</tr>
		            
			
					<tr>
					<td><b>Name</b></td>  
					<td>${product.name}</td> 					
					</tr>	
			         
			         <tr>
						<td><b>Contact</b></td>
					<td>${product.mobile}</td>
					</tr>
					
					<tr>				
						<td><b>SSC roll</b></td>
					<td>${product.sscroll}</td>
					</tr>
											
						<tr>					
					<td><b>HSC roll</b></td>		
						<td>${product.hscroll}</td>		
						</tr>
						

					 <tr>
						<td><b>Roll</b></td> 
						<td>${product.roll}</td>	
					</tr>
					
					<tr>
					<td><b>Registration Date</b></td>
						<td>${product.date}</td>	
					 </tr>
					 
			
					
					
</c:forEach>
			
			
		</table>


</div>
</body>
</html>