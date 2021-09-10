<%@page import="seatplan.UserDao,seatplan.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Seat Plan</title>


<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
 





</head>
<body>

 <div class="jumbotron jumbotron-fluid text-center text-info">
  <h1> Seat Plan Records  </h1>    
  <p class="text-danger" > ${success}  </p>
 </div>



<div class="container  text-center bg-light  border border-success" >
<br>

	<form enctype="multipart/form-data"  action="/admission/testCSV" method="post">
			 <b class="text-info">  Import CSV FILE  : </b>
			<input type="file" name="chooser" >
			<input type="hidden" value="import" name="action">
			<input type="submit" value="Submit">
	</form>
	<br>
</div>

<br>
<div class="container bg-light  text-left  border border-info">
<br>

<form action="/admission/Create_CSV" method="post">
<b class="text-primary">Export CSV FILE  : </b>
<input type="submit" >
</form>
<br>
</div>
<br>
<div class="container bg-light  text-left  border border-info">

<a href="adduserform.jsp">Add New Seat Plan </a>

<h3 class="text-info text-center">View All Seat Plant</h3>

<%
List<User> list=UserDao.getAllRecords();
request.setAttribute("list",list);
%>

<table  class="table bg-light table-hover">
<tr  class="bg-info text-white"> <th>Id</th><th>Serial</th><th>Exam Center</th><th>Address</th><th>Room</th><th>Capacity</th> <th>First Range</th>  <th>Last Range</th><th>Edit</th><th>Delete</th>  </tr>

<c:forEach items="${list}" var="u">
	<tr>
	<td>${u.getId()}</td>
	<td>${u.getSerial()}</td>
	<td>${u.getCenter()}</td>
	<td>${u.getAddress()}</td>
	<td>${u.getRoom()}</td>
	<td>${u.getCapacity()}</td>
	<td>${u.getFrange()}</td>
	<td>${u.getLrange()}</td>
	<td><a href="editform.jsp?id=${u.getId()}">Edit</a></td>
	<td><a href="deleteuser.jsp?id=${u.getId()}">Delete</a></td>
	</tr>
</c:forEach>

</table>



</div>

</body>
</html>