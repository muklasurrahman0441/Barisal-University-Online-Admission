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

 <div class="jumbotron jumbotron-fluid text-center text-info bg-light">
  <h1> Update Unit and GPA Information</h1>    
 </div>
 


<div class="container">

<form action="/admission/unitController" method="post" >

<table  class="table bg-light table-hover">

<c:forEach var="u" items="${product}">	
<tr>
<td>Id </td>
<td><input type="number" name="id" value="${u.getId()}" readonly ></td>
</tr>
<tr>
<td>Set Unit</td>
  <td> 
		        <select name="unit" required>
					    <option value="KA">KA</option>
					    <option value="KHA">KHA</option>
					    <option value="GA">GA</option>			  
			    </select>
	     </td>	
</tr>
<tr>
<td>Set Minimum SSC G.P.A. </td>
<td>   <input type="number" name="sgpa" value="${u.getSgpa()}" step="0.01" min="0" max="5" required/>  </td>
</tr>
<tr>
<td>Set Minimum HSC G.P.A. </td>
<td>   <input type="number" name="hgpa" value="${u.getHgpa()}" step="0.01" min="0" max="5" required/>  </td>
</tr>
<tr>
<td></td>
<td> <input type="submit" name="submit" value="update"> </td>
</tr>
</c:forEach>
</table>
</form>

</div>

</body>
</html>