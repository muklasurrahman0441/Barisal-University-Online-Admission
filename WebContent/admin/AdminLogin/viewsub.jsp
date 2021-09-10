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
padding:10px;
margin-bottom:10px;
}

</style>

</head>
<body>

 <div class="header">
  <h3 class="text-info"> Sub Admin Home   </h3>    
 </div>
 

 
 
<div class="container    border border-info">
  <p class="text-danger ">
    <input type="button" onclick="location.href='indexhome.jsp';" value="Home Page" />
  <br>
  NOTE : This is the most secure page .
   Any changes occur in absence of you can harm the applicant admission process.  
  </p>
  
 <br>
 

 
<c:forEach var="u" items="${product}">	

<!-- 
	${u.getId()}   <br>
	${u.getSubuser() }  <br>
	${u.getSubpassword() }   <br>
	${u.getSeatgo() }    <br>
	${u.getYeargo() }   <br>
	${u.getGpago() }   <br>
	${u.getUnitgo() }   <br>  -->

	<table  class="table bg-light table-hover ">
	
	
	<c:choose>	
	<c:when test="${u.getSeatgo()== '1' }">		
 <tr>
 <td>Manage Seat Plan </td>
 <td>  <a href="admin/seatplan/SeatPlanReg.jsp"> Click here </a> 	 </td></tr>
	</c:when>		
	</c:choose>

	
	<c:choose>	
	<c:when test="${u.getYeargo()== '1' }">		
<tr>
<td> SSC & HSC year management </td>
<td>	<a href="admin/year/YearReg.jsp">Click here</a>  	</td></tr>
	</c:when>			
	</c:choose>
	
	
	<c:choose>	
	<c:when test="${u.getGpago()== '1' }">		
  <tr>
  <td> Unit & G.P.A Management </td>
  <td>	<a href="admin/UnitGpa/addunit.jsp">Click here</a>	</td></tr>
	</c:when>	
	</c:choose>
	
	
	<c:choose>	
	<c:when test="${u.getUnitgo()== '1' }">			
<tr>
<td>Display All Unit Data</td>
<td>	<a href="/admission/controller?submit=unitview"> Click here </a>	</td></tr>
	</c:when>	
	</c:choose>
	
	
	</tr>
</c:forEach>

</table>


</div>




</body>
</html>