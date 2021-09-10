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
 

</head>
<body>




<jsp:include page="SubAdminrRg.jsp"></jsp:include>
<br>
<div class="container bg-light  text-center  border border-info">

<table  class="table bg-light table-hover ">
<tr class="bg-info text-white"><th>Id</th><th>Sub admin username</th><th>Sub admin password</th> <th> Seat plan Setting </th> <th> Year Setting </th> <th> GPA  Setting </th> <th> uNIT  Setting</th>  <th>Update</th><th>Delete</th> </tr>

<c:forEach var="u" items="${product}">	

	<tr>
	<td>${u.getId()}</td>
	<td>${u.getSubuser() }</td>
	<td>${u.getSubpassword() }</td>	
	<td>${u.getSeatgo() }</td>
	<td>${u.getYeargo() }</td>	
	<td>${u.getGpago() }</td>	
	<td>${u.getUnitgo() }</td>
	
	
	
	<td><a href="/admission/subController?submit=edit_sub&id=${u.getId()}">Edit</a></td>
	<td><a href="/admission/subController?submit=delete_sub&id=${u.getId()}">Delete</a></td>

	
	</tr>
</c:forEach>

</table>

</div>


<br><br>
</body>
</html>