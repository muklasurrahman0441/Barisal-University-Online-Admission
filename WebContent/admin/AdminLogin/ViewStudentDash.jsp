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
  <h1>Student Dash Board </h1>    
 </div>

<div class="container bg-light  border border-info">

<table  class="table bg-light table-hover text-left ">


<c:forEach var="u" items="${product}">	


	<c:choose>	
	<c:when test="${u.getApply()== '1' }">	
	
   <tr>
   <td>Online Application : </td>
   <td>   <a href="apply/imageUpload.jsp">Apply Online</a> </td>
   </tr>


	
	</c:when>	
	
	</c:choose>


     	<c:choose>	
	<c:when test="${u.getLoginper()== '1' }">	
	


<form action="/admission/subController" method="GET">
<tr>
<td>Enter HSC Roll : </td>
<td><input type="number" name="hscroll"> </td>
</tr>

<tr>
<td>Enter SSC Roll : </td>
<td><input type="number" name="sscroll"> </td>
</tr>

<tr>
<td></td>
 <td>  <button type="submit" name="submit" value="Student_Login">Login</button> </td>
</tr>

</form>
  
  
	</c:when>	
	
	</c:choose>



	
	
	
	
</c:forEach>

</table>
</div>

</body>
</html>