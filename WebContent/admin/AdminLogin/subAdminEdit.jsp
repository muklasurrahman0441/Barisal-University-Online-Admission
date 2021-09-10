<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
     <%@page import="subadmin.*,java.util.*"%>
    
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
height:80px;
background-color:#DCDCDC;
text-align:center;
padding:10px;
margin-bottom:10px;
}

</style>

</head>
<body>

<div class="header">
  <h4>Update Sub Admin Information</h4>      
 </div>

<div class="container bg-light  text-left  border border-info">

<form action="/admission/subController" method="post" >

<table  class="table bg-light table-hover ">

<c:forEach var="u" items="${product}">	

<tr>
<td> </td>
<td><input type="hidden" name="id" value="${u.getId()}" readonly ></td>
</tr>


<tr>
<td>Super Admin User_Name </td>
  <td> 
		<input type="text" name="subuser" value="${u.getSubuser()}" required >       
  </td>	
</tr>

<tr>
<td>Super Admin Password </td>
  <td> 
		<input type="text" name="subpassword" value="${u.getSubpassword()}" required >       
  </td>	
</tr>


	<c:choose>	
	<c:when test="${u.getSeatgo()== '1' }">		
	<tr>
	  <td> Seat Plan Access Permission  </td>
	  <td> <input type="checkbox" name="seatgo" value="1" checked>   </td>
	</tr>	
	</c:when>		
	 <c:otherwise>      
      <tr>      
	     <td> Seat Plan Access Permission  </td>
	 <td> <input type="checkbox" name="seatgo" value="1" >   </td>
     </tr>      
    </c:otherwise>
	</c:choose>
	
	
		<c:choose>	
	<c:when test="${u.getYeargo()== '1' }">		
	<tr>
	<td> Examination year Access Permission  </td>
<td> <input type="checkbox" name="yeargo" value="1" checked>  </td>
	</tr>	
	</c:when>		
	 <c:otherwise>      
      <tr>      
	    <td> Examination year Access Permission  </td>
<td> <input type="checkbox" name="yeargo" value="1">  </td>
     </tr>      
    </c:otherwise>
	</c:choose>
	
	
		<c:choose>	
	<c:when test="${u.getGpago()== '1' }">		
	<tr>
	<td> Minimum G.P.A. For Each Unit Access Permission  </td>
<td> <input type="checkbox" name="gpago" value="1" checked>    </td>
	</tr>	
	</c:when>		
	 <c:otherwise>      
      <tr>      
	  <td> Minimum G.P.A. For Each Unit Access Permission  </td>
<td> <input type="checkbox" name="gpago" value="1">    </td>
     </tr>      
    </c:otherwise>
	</c:choose>
	
	
		<c:choose>	
	<c:when test="${u.getUnitgo()== '1' }">		
	<tr>
	  <td> Applied Unit applicant's data Access Permission  </td>
<td> <input type="checkbox" name="unitgo" value="1" checked>  </td>
	</tr>	
	</c:when>		
	 <c:otherwise>      
      <tr>      
	    <td> Applied Unit applicant's data Access Permission  </td>
<td> <input type="checkbox" name="unitgo" value="1">  </td>
     </tr>      
    </c:otherwise>
	</c:choose>

<!-- 

<tr>  
<td> Seat Plan Access Permission  </td>
<td> <input type="checkbox" name="seatgo" value="1">   </td>
</tr>

<tr>
<td> Examination year Access Permission  </td>
<td> <input type="checkbox" name="yeargo" value="1">  </td>
</tr>

<tr>
<td> Minimum G.P.A. For Each Unit Access Permission  </td>
<td> <input type="checkbox" name="gpago" value="1">    </td>
</tr>

<tr>
<td> Applied Unit applicant's data Access Permission  </td>
<td> <input type="checkbox" name="unitgo" value="1">  </td>

</tr>
 -->
 
<tr><td></td>
<td>  <button type="submit" name="submit" value="update_sub"> Update </button>   </td>

</tr>


</c:forEach>

</table>
</form>

</div>

</body>
</html>