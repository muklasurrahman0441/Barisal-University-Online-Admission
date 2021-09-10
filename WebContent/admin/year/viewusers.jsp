<%@page import="year.UserDao,year.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View SSC & HSC Year Management</title>


<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
 




</head>
<body>

<jsp:include page="userform.html"></jsp:include>

<%
List<User> list=UserDao.getAllRecords();
request.setAttribute("list",list);
%>

<br>
<div class="container bg-light  text-left  border border-danger">

<table  class="table bg-light table-hover">
<tr  class="bg-info text-white"><th>Id</th>
<th>SSC first time</th>
<th>SSC second time</th>
<th>HSC first time</th>
<th>HSC second time</th>
<th>Edit</th>
<th>Delete</th>  </tr>

<c:forEach items="${list}" var="u">
	<tr>
	<td>${u.getId()}</td>
	<td>${u.getFssc()}</td>
	<td>${u.getLssc()}</td>
	<td>${u.getFhsc()}</td>
	<td>${u.getLhsc()}</td>
	
	<td><a href="editform.jsp?id=${u.getId()}">Edit</a></td>
	<td><a href="deleteuser.jsp?id=${u.getId()}">Delete</a></td>
	</tr>
</c:forEach>

</table>

</div>

</body>
</html>