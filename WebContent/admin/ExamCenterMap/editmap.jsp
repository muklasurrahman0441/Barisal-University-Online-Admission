<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
      <%@page import="ExamCenterMap.MapBean,ExamCenterMap.MapModel,java.util.*"%>
    
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

 <div class="jumbotron jumbotron-fluid text-center text-info bg-light">
  <h1> Update Map Data</h1>    
 </div>
 


<div class="container">

<form action="/admission/MapController" method="post" >

<table  class="table bg-light table-hover">

<c:forEach var="u" items="${product}">	


<input type="hidden" name="id" value="${u.getMap_id()}" readonly >


<tr>
<td>Latitude   :</td>
<td><input type="text" name="lat"  value="${u.getLat()}"  required/></td>
</tr>

<tr>
<td>Longitude :</td>
<td><input type="text" name="lng"  value="${u.getLng()}"  required/></td>
</tr>

<tr>
<td>Exam Center :</td>
<td><input type="text" name="examcenter"   value="${u.getExamcenter()}" required/></td>
</tr>

<tr>
<td colspan="2" align="center">
<button   type="submit" name="submit" value="updatedatamap" >	Update</button>
</td>
</tr>


</c:forEach>
</table>
</form>

</div>

</body>
</html>