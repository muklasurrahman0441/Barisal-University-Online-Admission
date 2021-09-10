<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Seat Plan</title>


<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
 





</head>
<body>
<%@page import="seatplan.UserDao,seatplan.User"%>

<%
String id=request.getParameter("id");
User u=UserDao.getRecordById(Integer.parseInt(id));
%>

 <div class="jumbotron jumbotron-fluid text-center text-info">
  <h1> Edit Seat Plan  </h1>    
  <p class="text-danger" > ${success}  </p>
 </div>

<div class="container bg-light  text-left  border border-info">

<form action="edituser.jsp" method="post">
<input type="hidden" name="id" value="<%=u.getId() %>"/>
<table  class="table bg-light table-hover">

<tr>
<td>Serial:</td>
<td><input type="number" name="serial" value="<%= u.getSerial()%>"/></td>
</tr>


<tr>
<td>Exam Center :</td>
<td><input type="text" name="center" value="<%= u.getCenter()%>"/></td>
</tr>

<tr>
<td>Address :</td>
<td><input type="text" name="address" value="<%= u.getAddress()%>"/></td>
</tr>


<tr>
<td>Room :</td>
<td><input type="text" name="room" value="<%= u.getRoom()%>"/></td>
</tr>


<tr>
<td>Capacity :</td>
<td><input type="number" name="capacity" value="<%= u.getCapacity()%>"/></td>
</tr>

<tr>
<td>First Range :</td>
<td><input type="number" name="frange" value="<%= u.getFrange()%>"/></td>
</tr>

<tr>
<td>Last Range :</td>
<td><input type="number" name="lrange" value="<%= u.getLrange()%>"/></td>
</tr>

<tr>
<td></td>

<td>
<button type="submit" value="Edit User">Update</button>

</td>

</tr>
</table>
</form>

</div>
</body>
</html>