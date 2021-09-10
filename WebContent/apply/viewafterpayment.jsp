<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admit Card</title>


<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
 
<style>

.header
{
left:0;
width:100%;
padding-right:10px;
}

.uvhead
{

left:0;
width:90%;
height:120px;
border:1px solid black;
text-align:left;
padding:10px;
margin-bottom:10px;
margin-left:5%;
}

.uvhead img
{
float:left;
margin-left:10px;
}

.uvhead p
{

margin-left:20px;
float:left;
}

.display
{

display:block;

}


.generalinfo
{
width:90%;
margin-left:5%;
margin-bottom:100px;
border:1px solid black;
float:left;
background:lightgray;
}

.generalinfo p
{
color:white;
background:gray;
text-align:center;
}


.table1
{

width:90%;
margin-left:5%;
margin-bottom:20px;
padding:10px;
border:1px solid black;
float:left;

}

td
{
padding-left: 100px;
}


.admitdata
{

width:40%;
margin-left:10px;
float:left;

}



</style>



</head>
<body>

  <div class="header">
  <p align="right" onclick="myFunction()"><u>Click to Print </u> </p>   
  </div>

<!--  

  <div class="header">
  <p align="right"><button onclick="myFunction()">Print admit card</button></p>
   
  </div>
-->


<script>
function myFunction() {
  window.print();
}
</script>


<div class="uvhead">

<img src="logo.jpg" width="100px"  height="100px"/>

<p>

<h3>University Of Barisal.</h3>
<b>Admission Test :Session: (2014-2015) </b>
</p>

</div>


<p align="center"><b> Admit  Card  </b></p>

<div class="table1">





	<c:forEach var="product" items="${product}">	

   <div class="imageuser">    <img  alt="" src="/admission/showImage?id=${product.id}" width="200px"  height="200px" align="right" > </div>

<div class="admitdata">
		<table>
	
		
		            		
			
					<tr>
					<th>Name</th>  
					<td>${product.name}</td> 					
					</tr>					
			         
			         <tr>
					<th>Father's Name</th>  
					<td>${product.fathername}</td> 					
					</tr>	
					
					<tr>
					<th>Mother's Name</th>  
					<td>${product.mothername}</td> 					
					</tr>	
					
					
					
					<tr>
					<th>Date Of Birth</th>  
					<td>${product.dateofbirth}</td> 					
					</tr>	
			         
			         <tr>
						<th>Contact</th>
					<td>${product.mobile}</td>
					</tr>
					
					<tr>
						<th>Quota</th> 
					<td>${product.quota}</td>
					</tr>
					
					<tr>
						<th>Unit</th>	
					<td>${product.unit}</td>
					</tr>
					
					<tr>				
						<th>SSC roll</th>
					<td>${product.sscroll}</td>
					</tr>
					
					<!-- 
					
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
						
						
			 -->			
						
						<tr>					
					<th>HSC roll</th>		
						<td>${product.hscroll}</td>		
						</tr>
						<tr>
						
						
						<!--  
						
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

            -->
 
					 <tr>
						<th>Exam Roll</th> 
						<td>${product.roll}</td>	
					</tr>
					
				<!-- 		
					<tr>
					<td>Registration Date</td>
						<td>${product.date}</td>	
					 </tr>
				
			 	 <tr>
					
						<td>Serial</td>
						<td>${product.serial}</td>	
					 </tr>
				 -->
				 
					 <tr>
							<th>Center</th> 
							<td>${product.center}</td>
						 </tr>
						 <tr>
								<th>Address</th>
								<td>${product.address}</td>		
							 </tr>
							 <tr>
								<th>Room</th> 
									<td>${product.room}</td>
								</tr>
								<tr>
									<th>Capacity</th>
									<td>${product.capacity}</td>
									 </tr>
									
									<!--
									
									 <tr>
									
										<th>Payment Status</th> 
										<td>${product.payment}</td>
									</tr>
									
					             
					             -->
					
				
					
</c:forEach>
			
			
		</table>		
		</div>		

</div>


           <br>

  
        <div class="generalinfo">
        
        <p>General Instructions for applicants</p>
        
        <label>01 Please print 2 copies of admit card and staple a recent passport size duty attested photo with the said admit card.  </label> <br>
        <label>02 Bring the original registration cards of SSC and HSC or Equivalent Examinations.</label><br>
        <label>03 All sorts of calculators, Digital Watch, Mobile Phone, Blue Tooth or any telecommunications devices are strictly prohibited in the Examination Hall. </label><br>
        
        
        </div>
	

</body>
</html>