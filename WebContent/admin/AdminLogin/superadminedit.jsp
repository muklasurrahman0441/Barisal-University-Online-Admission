<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@page import="admin.*,java.util.*"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
 


</head>
<body>


<div class="jumbotron jumbotron-fluid text-center">
  <h1>Update Super Admin Information</h1>    
  <p class="text-danger"> Edit super admin info very carefully .  </p>
  
 </div>

<div class="container bg-light  text-center  border border-info">

<form action="/admission/adminController" method="post" >

<table  class="table bg-light table-hover ">

<c:forEach var="u" items="${product}">	

<tr>

<td><input type="hidden" name="id" value="${u.getId()}" readonly ></td>
</tr>


<tr>
<td>Super Admin User_Name </td>
  <td> 
		<input type="text" name="superuser" value="${u.getSuperuser()}" required >       
  </td>	
</tr>

<tr>
<td>Super Admin Password </td>
  <td> 
		<input type="text" name="superpassword" value="${u.getSuperpassword()}" required >       
  </td>	
</tr>



<tr>
<td></td>
<td> 
<button type="submit" name="submit" value="update_super">Update</button>

</td>

</tr>


</c:forEach>

</table>
</form>

</div>


</body>
</html>