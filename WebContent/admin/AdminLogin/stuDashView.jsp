<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@page import="subadmin.*,java.util.*"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
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
margin-bottom:10px;
}

.table1
{
width:30%;
float:left;
margin-left:2%;
}


.imageinfo
{

width:30%;
margin-bottom:20px;
text-align:left;
}


.display
{
width:55%;
float:left;
margin-left:2%;

}


.tab1
{
width:30%;
}

.tab2
{
width:30%;
float:left;
margin-right:20px;
margin-bottom:30px;
}

.tab3
{
margin-bottom:30px;
width:30%;

}

.tab4
{
width:30%;
float:left;

margin-right:20px;
}



th
{
color:green;
}


</style>



</head>
<body class="bg-light">

<!-- HSC ROLL <h3>${hscroll}</h3> -->


  <div class="header">
   <h4 class="text-primary">  University Of Barisal  </h4>  
   <p class="text-success">    
   Kornokathi, (Dhaka - Patuakhali Hwy), Barishal-8200, Bangladesh <br>
   Web: www.bu.ac.bd<br> 
 </p>  
    
  </div>


<div class="table1">

           

<p class="bg-secondary text-white text-center"> 
 <input type="button" onclick="location.href='indexhome.jsp';" value="Home Page" /><br> </p>

<p class="bg-success text-white text-center"> 
<b> Student Dash Board </b> </p>

<c:forEach var="u" items="${product}">	
<table class="table table-light table-hover">




	<c:choose>	
	<c:when test="${u.getPayment()== '1' }">	
	
	<tr>
	    <td>Payment if incomplete</td>
		<td>	<a href="./controller?submit=view&hscroll=${hscroll}">Payment</a> </td>
		<td><img src="photos/iconr.JPG" width="20" height="20" /></td>
	</tr>
	
	</c:when>	
	
	 <c:otherwise>      
      <tr>
      
	      <td>Payment if incomplete</td>
	      <td> ------ </td>
		  <td><img src="photos/icona.JPG" width="20" height="20" /></td>
     </tr>
      
    </c:otherwise>
	</c:choose>
	
	
	<c:choose>	
	<c:when test="${u.getSeatplan()== '1' }">	
	
	<tr>
			<td>Seat Plan</td>
		    <td>
			
			<a href="./controller?submit=Find_Seat&hscroll=${hscroll}">Find</a>
		    </td>
		    <td><img src="photos/iconr.JPG" width="20" height="20" /></td>

   </tr>
	</c:when>	
	 <c:otherwise>
      
      <tr>
	      <td>Seat Plan</td>
	      <td> ------ </td>
	      <td><img src="photos/icona.JPG" width="20" height="20" /></td>
	   </tr>
      
    </c:otherwise>
	
	</c:choose>
	
	<c:choose>	
	<c:when test="${u.getAdmitcard()== '1' }">	
	
	<tr>
			<td>Admit Card</td>
		   <td><a href="apply/DownloadAdmitCard.jsp?hscroll=${hscroll}"> Download  </a>		 </td>
		   <td><img src="photos/iconr.JPG" width="20" height="20" /></td>

   </tr>
	</c:when>	
	 <c:otherwise>
      
      <tr>
	      <td>Admit Card</td>
		 <td> ------ </td>
		 <td><img src="photos/icona.JPG" width="20" height="20" /></td>
	  </tr>
      
    </c:otherwise>
	</c:choose>
	
	
	
	<c:choose>	
	<c:when test="${u.getResult()== '1' }">	
	
	
	<tr>
	<td>Exam Result </td>
		<td>	
		<a href="apply/GetResult.jsp?hscroll=${hscroll}"> Find Result </a>
		</td>
		<td><img src="photos/iconr.JPG" width="20" height="20" /></td>

   </tr>

	
	</c:when>	
	
	 <c:otherwise>
      
      
	<tr>
			<td>Exam Result </td>
		    <td>  ------	</td>
		      
		      
			<td><img src="photos/icona.JPG" width="20" height="20" /></td>
   </tr>
      
    </c:otherwise>
	
	
	</c:choose>
	
	
	
	


</table>
</c:forEach>



</div>



<div class="display">

	<c:forEach var="productProfile" items="${productProfile}">	


   
    
    <div class="imageinfo">           	
			
		<img alt="" src="/admission/showImage?id=${productProfile.id}" width="100px"  height="100px" >  
      <p align="right">  <a href="/admission/adminController?submit=viewmapadmin&center=${productProfile.center}">Find Map</a> 
      
      </p>     
      
	</div>				


	
	
				
	<table class="tab2">				
					
					
					
					
					
					<tr >
					<td colspan="2" class="text-center bg-secondary text-white" >  SSC Information  </td>  										
					</tr>	
					
				   <tr >			
						<th>Roll </th>
						<td>${productProfile.sscroll}</td>
					</tr><tr>	
						<th> Registration</th>
						<td>${productProfile.sscreg}</td>	
						</tr><tr>	
						<th>Passing Year</th>
						<td>${productProfile.sscyear}</td>
						</tr><tr>	
						<th> G.P.A </th>
						<td>${productProfile.sscgpa}</td>	
						</tr><tr>	
						<th>Group </th>
						<td>${productProfile.sscgroup}</td>
						</tr><tr>	
						<th>Board </th>
						<td>${productProfile.sscboard}</td>
					</tr>
					
					<!-- 
					
					<tr>		
						<td>${productProfile.sscroll}</td>
						<td>${productProfile.sscreg}</td>	
						<td>${productProfile.sscyear}</td>
						<td>${productProfile.sscgpa}</td>	
						<td>${productProfile.sscgroup}</td>
						<td>${productProfile.sscboard}</td>
					</tr>
						 -->
						
		</table>				
	<table  class="tab3">				
					
					<tr  >
					<td colspan="2" class="text-center bg-secondary text-white" >  HSC Information  </td>  										
					</tr>	
					
				  <tr >			
						<th>Roll </th>
					<td>${productProfile.hscroll}</td>
					</tr><tr>	
						<th> Registration</th>
							<td>${productProfile.hscreg}</td>	
						</tr><tr>	
						<th>Passing Year</th>
						<td>${productProfile.hscyear}</td>		
						</tr><tr>	
						<th> G.P.A </th>
						 <td>${productProfile.hscgpa}</td>	
						</tr><tr>	
						<th>Group </th>
						<td>${productProfile.hscgroup}</td>		
						</tr><tr>	
						<th>Board </th>
						   <td>${productProfile.hscboard}</td>
					</tr>
										
				<!-- 		
						
					<tr>					
						
						<td>${productProfile.hscroll}</td>						
						<td>${productProfile.hscreg}</td>					
						<td>${productProfile.hscyear}</td>					
					    <td>${productProfile.hscgpa}</td>					
						<td>${productProfile.hscgroup}</td>						
					    <td>${productProfile.hscboard}</td>
					 </tr>
 -->


	<table  class="tab4">				
					
					
					<tr >
					<td colspan="2" class="text-center bg-secondary text-white" > Examination's & Seat Plan Information    </td>  										
					</tr>	
							
							
				 <tr >			
						<th>Exam Roll </th>
							<td>${productProfile.roll}</td>	
				</tr><tr>		
						<th>Registration Date </th>
						<td>${productProfile.date}</td>	
						</tr><tr>
						<th>Serial</th>
						<td>${productProfile.serial}</td>	
						</tr><tr>
						<th> Center </th>
						<td>${productProfile.center}</td>
						</tr><tr>
						<th>Address </th>
						<td>${productProfile.address}</td>
						</tr><tr>
						<th>Room </th>
							<td>${productProfile.room}</td>
						</tr><tr>
						<th>Capacity </th>
							<td>${productProfile.capacity}</td>
						</tr><tr>
						<th>Payment Status</th>
						<td>${productProfile.payment}</td>
					</tr>
										

<!-- 
					 <tr>
						
						<td>${productProfile.roll}</td>	
						<td>${productProfile.date}</td>	
						<td>${productProfile.serial}</td>	
						<td>${productProfile.center}</td>
						<td>${productProfile.address}</td>
						<td>${productProfile.room}</td>
						<td>${productProfile.capacity}</td>
						<td>${productProfile.payment}</td>
					</tr>
									
				 -->	
			
		</table>



	<table  class="tab1">
		
					<tr>
					<td colspan="2" class="text-center bg-secondary text-white" >  General Information </td>  										
					</tr>		
			
			
			<tr>			
				<th> Name </th>
				<td>${productProfile.name}</td>	
			</tr><tr>
				<th> Father's Name </th>
				<td>${productProfile.name}</td>	
			</tr><tr>
				<th> Mother's Name </th>
				<td>${productProfile.mothername}</td>
			</tr><tr>
				<th> Date Of Birth </th>
				<td>${productProfile.dateofbirth}</td>
			</tr><tr>
		    	<th> Contact No </th>
				<td>${productProfile.mobile}</td>
			</tr><tr>	
				<th> Quota </th>
				<td>${productProfile.quota}</td>
			</tr><tr>	
			<th> Unit </th>
			<td>${productProfile.unit}</td>			
			</tr>
			
			<!--  
					<tr>					
					<td>${productProfile.name}</td>	
					<td>${productProfile.fathername}</td>
					<td>${productProfile.mothername}</td>
					<td>${productProfile.dateofbirth}</td>
					<td>${productProfile.mobile}</td>
					<td>${productProfile.quota}</td>
					<td>${productProfile.unit}</td>
					</tr>
					-->
					
	</table>	


</c:forEach>
</div>








</body>
</html>