<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="UnitGpa.unitBean,UnitGpa.unitModel,java.util.*"%>
    
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

<jsp:include page="addunit.jsp"></jsp:include>
<br>

<div class="container">
<table  class="table table-striped  bg-light table-bordered table-hover">
<tr class="bg-info text-white"><th>Id</th><th>Unit</th><th>SSC GPA</th> <th>HSC GPA</th> <th>Update</th><th>Delete</th> </tr>

<c:forEach var="u" items="${product}">	

	<tr>
	<td>${u.getId()}</td>
	<td>${u.getUnit()}</td>
	<td>${u.getSgpa()}</td>	
	<td>${u.getHgpa()}</td>	
	
	<td><a href="/admission/unitController?submit=edit&id=${u.getId()}">Edit</a></td>
	<td><a href="/admission/unitController?submit=delete&id=${u.getId()}">Delete</a></td>

	
	</tr>
</c:forEach>

</table>
</div>

</body>
</html>