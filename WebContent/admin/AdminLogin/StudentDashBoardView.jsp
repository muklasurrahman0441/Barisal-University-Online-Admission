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
height:50px;
background-color:#DCDCDC;
text-align:center;
padding:10px;
margin-bottom:10px;
}


</style>

</head>
<body>


<div class="header">
  <h4>Student Dash Board permission</h4>    
  <p class="text-danger"> Please provide correct information if update data </p>
 
 </div>



<div class="container bg-light  text-center  border border-info">
<p class="text-danger"> Do not Add more than one column </p>

<table  class="table bg-light table-hover ">

<tr  class="bg-info text-white">  <th>Apply</th><th>Login Permission</th> <th> Payment</th> <th> Seat plan </th> <th> Admit card </th> <th> Result</th>  <th>Update</th><th>Delete</th> </tr>

<c:forEach var="u" items="${product}">	

	<tr>
<!--  <td>${u.getId()}</td> -->	
    
    <td>${u.getApply() }</td>
	<td>${u.getLoginper()} </td>
	
	<td>${u.getPayment() }</td>	
	<td>${u.getSeatplan() }</td>
	<td>${u.getAdmitcard() }</td>	
	<td>${u.getResult() }</td>	
	
	
	
	
	<td><a href="/admission/subController?submit=edit_student_dashboard&id=${u.getId()}">Edit</a></td>
	<td><a href="/admission/subController?submit=delete_student_Dashboard&id=${u.getId()}">Delete</a></td>

	
	</tr>
</c:forEach>

</table>


</div>


</body>
</html>