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
 




</head>
<body>




<div class="container-fluid  border border-success" >
<br>
<div class="container  text-center bg-light  border border-primary" >
<h2>${success}</h2>
<a href="/admission/controller?submit=unitview"><big>click to view all unit data </big></a>
</div>

<br>



<br>
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

<form action="/admission/searchControl"  method="post">
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

</div>
<br>



<div class="container-fluid bg-light  text-left  ">

	<table  class="table bg-light table-hover border border-danger">
			<tr  class="bg-info text-white">
					<th>Id</th>
					<th>Name</th>
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
		    	<td>${product.id}</td>
				<td>${product.name}</td>
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
				
				
				<td><img alt="" src="/admission/showimage?id=${product.id}" width="100px"  height="150px"></td>
				<td><a href="/admission/controller?submit=editapply&hscroll=${product.hscroll}">Edit </a></td>
				<td><a href="/admission/controller?submit=deleteapply&hscroll=${product.hscroll}">Delete </a></td>
				
				
				
			</tr>
</c:forEach>
		</table>
	
</div>



</body>
</html>