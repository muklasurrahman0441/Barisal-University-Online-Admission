<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Form</title>


<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
 




</head>
<body>
<%@page import="year.UserDao,year.User"%>

<%
String id=request.getParameter("id");
User u=UserDao.getRecordById(Integer.parseInt(id));
%>

 <div class="jumbotron jumbotron-fluid text-center text-info">
  <h1> Edit SSC & HSC  Year  Management </h1>    
 </div>

<div class="container bg-light  text-left  border border-info">

<form action="edituser.jsp" method="post">
<input type="hidden" name="id" value="<%=u.getId() %>"/>
<table  class="table bg-light table-hover">

<tr>
<td>SSC First Time:</td>
<td><input type="text" name="fssc" value="<%= u.getFssc()%>"/></td>
</tr>


<tr>
<td>SSC Second Time :</td>
<td><input type="text" name="lssc" value="<%= u.getLssc()%>"/></td>
</tr>

<tr>
<td>HSC First Time :</td>
<td><input type="text" name="fhsc" value="<%= u.getFhsc()%>"/></td>
</tr>


<tr>
<td>HSC Second Time :</td>
<td><input type="text" name="lhsc" value="<%= u.getLhsc()%>"/></td>
</tr>



<tr><td></td>  <td >

<button type="submit" value="Edit User">Update</button>

</td></tr>
</table>
</form>

</div>

</body>
</html>