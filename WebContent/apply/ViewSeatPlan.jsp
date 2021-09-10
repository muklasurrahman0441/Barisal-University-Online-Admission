<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



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


</style>


</head>
<body>


 
   
  
   <div class="header">
  <h1 class="text-primary">  University Of Barisal  </h1>  
   <p class="text-success">    
   
Kornokathi, (Dhaka - Patuakhali Hwy), Barishal-8200, Bangladesh <br>
Email: info@bu.ac.bd <br>
Web: www.bu.ac.bd<br>
<h4 class="text-danger">Seat Plan</h4> 
   
   </p>    
   </div>
    

<div class="container bg-light  ">


     <c:forEach var="product" items="${product}">

		<table  class="table bg-light table-hover text-left ">
			<tr>
				<td>Name</td>
				<td>${product.name}</td>
			</tr>	
			
			
			<tr>					
					<td>Contact </td>
					<td>${product.mobile}</td>
					
			</tr>			
					<td>Unit</td>	
					<td>${product.unit}</td>
			</tr>	
			
			<tr>			
				
					<td>SSC roll</td>											
					<td>${product.sscroll}</td>			
			</tr>	
			
			<tr>		
					<td>HSC roll</td>	
					<td>${product.hscroll}</td>				
				
			</tr>	
			
			<tr>	
					<td>Exam Roll</td>
					<td>${product.roll}</td>
					
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
			
		
			
			
			
			

		</table>
		
		</c:forEach>
		
	


</div>




</body>
</html>