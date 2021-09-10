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
height:100px;
background-color:#DCDCDC;
text-align:center;
padding:10px;
margin-bottom:10px;
}


</style>


</head>
<body>

 <div class="header">
  <h4>Update Student Dash Board permission</h4>    
  <p class="text-danger"> Student Can only access the permitted web page by admin .  </p>
 </div>


<div class="container bg-light  text-center  border border-info">

<form action="/admission/subController" method="post" >

<table  class="table bg-light table-hover ">

<c:forEach var="u" items="${product}">	



<tr>
<td><input type="hidden" name="id" value="${u.getId()}" readonly ></td>
</tr>



	<c:choose>	
	<c:when test="${u.getApply()== '1' }">		
	<tr>
	 <td> Online Application Permission </td>
<td> <input type="checkbox" name="apply" value="1" checked>    </td>
	</tr>	
	</c:when>		
	 <c:otherwise>      
      <tr>      
	   <td> Online Application Permission </td>
<td> <input type="checkbox" name="apply" value="1">    </td>
     </tr>      
    </c:otherwise>
	</c:choose>
	
	
		<c:choose>	
	<c:when test="${u.getLoginper()== '1' }">		
	<tr>
	<td>Student Login Permission </td>
<td> <input type="checkbox" name="loginper" value="1" checked>   </td>
	</tr>	
	</c:when>		
	 <c:otherwise>      
      <tr>      
	<td>Student Login Permission </td>
<td> <input type="checkbox" name="loginper" value="1">   </td>
     </tr>      
    </c:otherwise>
	</c:choose>



	<c:choose>	
	<c:when test="${u.getPayment()== '1' }">		
	<tr>
	<td>Student Payment System Permission </td>
<td> <input type="checkbox" name="payment" value="1" checked>   </td>
	</tr>	
	</c:when>		
	 <c:otherwise>      
      <tr>      
	<td>Student Payment System Permission </td>
<td> <input type="checkbox" name="payment" value="1">   </td>
     </tr>      
    </c:otherwise>
	</c:choose>
	
	
	
		<c:choose>	
	<c:when test="${u.getSeatplan()== '1' }">		
	<tr>
	<td>Student Seat plan Permission </td>
<td> <input type="checkbox" name="seatplan" value="1" checked>    </td>
	</tr>	
	</c:when>		
	 <c:otherwise>      
      <tr>      
	<td>Student Seat plan Permission </td>
<td> <input type="checkbox" name="seatplan" value="1">    </td>
     </tr>      
    </c:otherwise>
	</c:choose>
	
	
	
	<c:choose>	
	<c:when test="${u.getAdmitcard()== '1' }">		
	<tr>
	<td>Admit card Download / Print Permission </td>
<td> <input type="checkbox" name="admitcard" value="1" checked>   </td>
	</tr>	
	</c:when>		
	 <c:otherwise>      
      <tr>      
	<td>Admit card Download / Print Permission </td>
<td> <input type="checkbox" name="admitcard" value="1">   </td>
     </tr>      
    </c:otherwise>
	</c:choose>
	
	
	
	<c:choose>	
	<c:when test="${u.getResult()== '1' }">		
	<tr>
	<td>Result Permission </td>
<td> <input type="checkbox" name="result" value="1" checked>   </td>
	</tr>	
	</c:when>		
	 <c:otherwise>      
      <tr>      
	<td>Result Permission </td>
<td> <input type="checkbox" name="result" value="1">   </td>
     </tr>      
    </c:otherwise>
	</c:choose>

<!-- 


<tr>
<td> Online Application Permission </td>
<td> <input type="checkbox" name="apply" value="1">    </td>
</tr>

<tr>
<td>Student Login Permission </td>
<td> <input type="checkbox" name="loginper" value="1">   </td>
</tr>

<tr>
<td>Student Payment System Permission </td>
<td> <input type="checkbox" name="payment" value="1">   </td>
</tr>

<tr>
<td>Student Seat plan Permission </td>
<td> <input type="checkbox" name="seatplan" value="1">    </td>
</tr>

<tr>
<td>Admit card Download / Print Permission </td>
<td> <input type="checkbox" name="admitcard" value="1">   </td>
</tr>

<tr>
<td>Result Permission </td>
<td> <input type="checkbox" name="result" value="1">   </td>
</tr>

 -->


<tr><td></td>
<td>
<button type="submit" name="submit" value="Update_Student_Dashboard">Update</button>
 </td>

</tr>


</c:forEach>

</table>
</form>
</div>

</body>
</html>