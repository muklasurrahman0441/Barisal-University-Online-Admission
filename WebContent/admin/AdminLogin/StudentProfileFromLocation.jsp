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

}


</style>


</head>
<body class="bg-light">

  <div class="header">
  <h3 class="text-primary">  University Of Barisal  </h3>  
   <p class="text-success">    
   
Kornokathi, (Dhaka - Patuakhali Hwy), Barishal-8200, Bangladesh <br>
Email: info@bu.ac.bd <br>
Web: www.bu.ac.bd<br>
 </p>  


 </div>


<div class="table1">

	<c:forEach var="product" items="${product}">	




					<img alt="" src="/admission/showImage?id=${product.id}" width="100px"  height="100px" align="right" >  

		<table class="table table-hover table-striped table-light">
	
		
		            
			
					<tr>
					<td>Name</td>  
					<td>${product.name}</td> 					
					</tr>					
			         
			         
			         <tr>
				<td>Father Name</td>
				<td>${product.fathername}</td>
			</tr>	
			
				<tr>
				<td>Mother Name</td>
				<td>${product.mothername}</td>
			</tr>	
			
				<tr>
				<td>Date Of Birth</td>
				<td>${product.dateofbirth}</td>
			</tr>	
			         
			         <tr>
						<td>Contact</td>
					<td>${product.mobile}</td>
					</tr>
					
					<tr>
						<td>Quota</td> 
					<td>${product.quota}</td>
					</tr>
					
					<tr>
						<td>Unit</td>	
					<td>${product.unit}</td>
					</tr>
					
					<tr>				
						<td>SSC roll</td>
					<td>${product.sscroll}</td>
					</tr>
					
					<tr>										
						<td>SSC Registration</td>
					<td>${product.sscreg}</td>	
					</tr>
					
				
					<tr>
						<td>SSC Year</td>	
						<td>${product.sscyear}</td>
					</tr>
					
					<tr>
						<td>SSC G.P.A</td>
					<td>${product.sscgpa}</td>	
					</tr>
					
					<tr>			
						<td>SSC Group</td>
					<td>${product.sscgroup}</td>
					</tr>
					
					<tr>
						<td>SSC Board</td>	
						<td>${product.sscboard}</td>
						</tr>
						
						
						<tr>					
					<td>HSC roll</td>		
						<td>${product.hscroll}</td>		
						</tr>
						<tr>
						<td>HSC Registration</td>
						<td>${product.hscreg}</td>
					</tr>
					<tr>
						<td>HSC Year</td>	
						<td>${product.hscyear}</td>
					</tr>
					<tr>
						<td>HSC G.P.A</td>	
					<td>${product.hscgpa}</td>
						</tr>
						<tr>					
					<td>HSC Group</td>
						<td>${product.hscgroup}</td>
						</tr>
						<tr>
						<td>HSC Board</td>
					<td>${product.hscboard}</td>
					 </tr>

					 <tr>
						<td>Roll</td> 
						<td>${product.roll}</td>	
					</tr>
					<tr>
					<td>Registration Date</td>
						<td>${product.date}</td>	
					 </tr>
					 <tr>
					
						<td>Serial</td>
						<td>${product.serial}</td>	
					 </tr>
					 <tr>
							<td>Center</td> 
							<td>${product.center}</td>
						 </tr>
						 <tr>
								<td>Address</td>
								<td>${product.address}</td>		
							 </tr>
							 <tr>
								<td>Room</td> 
									<td>${product.room}</td>
								</tr>
								<tr>
									<td>Capacity</td>
									<td>${product.capacity}</td>
									 </tr>
									 <tr>
									
										<td>Payment Status</td> 
										<td>${product.payment}</td>
									</tr>
									
					
					
					<tr>				
					
					
					
</c:forEach>
			
			
		</table>


</div>
</body>
</html>