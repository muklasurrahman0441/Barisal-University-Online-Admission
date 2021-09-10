<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
      <%@page import="ApplyLocation.*,java.util.*"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    
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
height100px;
background-color:rgb(248, 255, 245);
text-align:center;
padding:10px;
margin-bottom:10px;
}


.searchbox
{

width:40%;
margin-left:30%;
margin-right:30%;
border: 1px solid black;
float:left;
padding:20px;
margin-bottom:20px;
}


.display
{
width:80%;
margin-left:10%;
margin-right:10%;
border: 1px solid black;
float:left;
padding:20px;
}


</style>


</head>
<body class="bg-light">


 <div class="header">
  <h3 class="text-primary">  University Of Barisal  </h3>  
   <p class="text-success">    
   Kornokathi, (Dhaka - Patuakhali Hwy), Barishal-8200, Bangladesh <br>
   Web: www.bu.ac.bd<br>
 </p>  
 </div>




<div class="searchbox">
<p align="center"> <a href="/admission/subController?submit=superadminhome">Admin Home</a></p>
<p class="text-info"> <big>Applicant's Apply Location </big></p>

<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search  HSC Roll" >


</div>

<br>

<div class="display">
<table id="myTable"  class="table table-hover ">
<tr class="bg-info text-white"><th> HSC Roll</th>  <th>Host Name </th>   <th>Canonical Host Name</th>  <th>IP Address</th> <th>Mac Address </th>  <th>Apply Date</th> <th> Profile</th> </tr>
<c:forEach var="u" items="${product}">	
	<tr>	
	<td>${u.getHscroll()}</td>
	<td>${u.getHostname() }</td>
	<td>${u.getCanonicalhostname()}</td>	
	<td>${u.getIpaddress()}</td>
	<td>${u.getMacaddress()}</td>	
	<td>${u.getApplylocationdate()}</td>	
		
	<td> <a href="/admission/ApplyLocationController?submit=viewProfile&hscroll=${u.getHscroll()}">Profile</a> </td>
	
	</tr>
</c:forEach>
</table>
</div>




<script>
function myFunction() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}
</script>


</body>
</html>