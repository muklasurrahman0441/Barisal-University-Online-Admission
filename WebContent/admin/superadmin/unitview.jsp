<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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

.display
{

display:block;

}

.table1
{

width:100%;
margin:10px;
float:left

}

.table1 td,th
{
text-align:left;
padding:5px;
}

.superhome{
margin:10px;
margin-left:10%;
}

</style>

</head>
<body>



 <div class="header">

<h4>${success}</h4>
<P class="text-success"> Unit view for super admin  </P>
 <!--   <a href="/admission/controller?submit=unitview"><big>click to view </big></a> --> 
</div>

 <div class="superhome">
<a href="/admission/subController?submit=superadminhome">Admin Home</a>

</div>

<div class="container  text-center bg-light  border border-info" >

<form action="/admission/searchControl"  method="post">
<table>
<tr>
<td>Search by Hscroll</td>
<td> <input type="text" name="hscroll" required>   </td>
<td> <input type="submit" name="submit" value="searchByHscRoll" required>   </td>
</tr>
</table>
</form>

</div>

<br>

<div class="container  text-center bg-light  border border-danger" >
<form action="/admission/searchControl"  method="post">
<table>
<tr>
		<td>Search format : (yy/mm/dd) :</td> 
		<td> <input type="text" name="date" placeholder="****/**/**" required>   </td>
		<td> <input type="submit" name="submit" value="searchByDate" required>   </td>
</tr>
</table>
</form>

<br>

<form action="/admission/searchControl"  method="GET">
<table>
<tr>
		<td> Create CSV By Date >> Search : (yy/mm/dd) :</td> 
		<td> <input type="text" name="date" placeholder="****/**/**" required>   </td>
		<td> <input type="submit" name="submit" value="Create_CSV_File_Date" >   </td>
</tr>
</table>
</form>

</div>

<br>
<div class="container  text-center bg-light  border border-success" >

<form action="/admission/searchControl"  method="post">
<table>
<tr>
<td>Search by Exam Roll</td>
<td> <input type="text" name="roll" required>   </td>
<td> <input type="submit" name="submit" value="search_Exam_Roll" required>   </td>
</tr>
</table>
</form>


</div>

<br>

<div class="container   bg-light  border border-info" >


<form action="/admission/searchControl" method="GET">
 Create CSV File  :    <input type="submit" name="submit" value="Create_CSV_File" >
</form>

</div>
<br>

</div>
<br>




<div class="table1">

	<table border="1"  class="table-hover">
			<tr  class="bg-info text-white">
					
					<th>Name</th>
					<th>Father's Name</th>
					<th>Mother's Name</th>
					<th>Date Of Birth</th>
					<th>Contact </th>
					<th>Quota</th>
					<th>Unit</th>		
				
					<th>SSC roll</th>											
					<th>SSC Registration</th>	
					<th>SSC Year</th>	
					<th>SSC G.P.A</th>					
					<th>SSC Group</th>	
					<th>SSC Board</th>					
					
					<th>HSC roll</th>					
					<th>HSC Registration</th>	
					<th>HSC Year</th>	
					<th>HSC G.P.A</th>							
					<th>HSC Group</th>	
					<th>HSC Board</th>
					
					
					<th>Roll</th>
					
					<th>Payment</th>
						<th>Date</th>
							<th>Exam Center</th>
								<th>Address</th>
									<th>Room</th>
										<th>Capacity</th>
					<th>Image</th>
					<th>Update</th>
					<th>Delete</th>
				
					</tr>
	
					
<c:forEach var="product" items="${product}">		
			<tr>
		    	
				<td>${product.name}</td>
				
				<td>${product.fathername}</td>
				<td>${product.mothername}</td>
				<td>${product.dateofbirth}</td>
				
				<td>${product.mobile}</td>
				<td>${product.quota}</td>
				
				<td>${product.unit}</td>
				<td>${product.sscroll}</td>
				<td>${product.sscreg}</td>
				<td>${product.sscyear}</td>
				<td>${product.sscgpa}</td>
				
				<td>${product.sscgroup}</td>
				<td>${product.sscboard}</td>
				<td>${product.hscroll}</td>
				<td>${product.hscreg}</td>
				<td>${product.hscyear}</td>
				<td>${product.hscgpa}</td>
				<td>${product.hscgroup}</td>
				<td>${product.hscboard}</td>
				
				<td>${product.roll}</td>
				
				<td>${product.payment}</td>
				<td>${product.date}</td>
				
				
				
				<td>${product.center}</td>
				<td>${product.address}</td>
				<td>${product.room}</td>
				<td>${product.capacity}</td>
				
				
				<td><img alt="" src="/admission/showimage?id=${product.id}" width="50px"  height="50px"></td>
				<td><a href="/admission/controller?submit=editapply&hscroll=${product.hscroll}">Edit </a></td>
				<td><a href="/admission/controller?submit=deleteapply&hscroll=${product.hscroll}">Delete </a></td>
				
				
				
			</tr>
</c:forEach>
		</table>
	
</div>




</body>
</html>