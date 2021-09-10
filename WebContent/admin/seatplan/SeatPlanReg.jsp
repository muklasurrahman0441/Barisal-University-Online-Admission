<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
 

 <script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
 
$( document ).ready(function() {
	$(document)
	.ready(
			function() {
				$
						.get(
								'/admission/SeatplanPopulate',
								function(responseJson) {
									if (responseJson != null) {
										$("#countrytable").find(
												"tr:gt(0)").remove();
										var table1 = $("#countrytable");
										$
												.each(
														responseJson,
														function(key,
																value) {

															table1
																	.append("<tr><td><a  href='/admission/admin/seatplan/editform.jsp?id="
																			+ value['id']
																			+ "'> Update </a> </td><td><a  href='/admission/admin/seatplan/deleteuser.jsp?id="
																			+ value['id']
																			+ "'> delete </a> </td>   <td>"																		
																			+ value['serial']
																			+ "</td>   <td>"
																			+ value['center']
																			+ "</td>   <td>"
																			+ value['address']
																			+ "</td>   <td>"
																			+ value['room']
																			+ "</td>   <td>"
																			+ value['capacity']
																			+ "</td>   <td>"
																			+ value['frange']
																			+ "</td>   <td>"
																			+ value['lrange']																		
																			+ "</td> </tr>");

														});
									}
								});
			});
});


</script>

<style>

.header
{
left:0;
width:100%;
height100px;
background-color:#DCDCDC;
text-align:center;
padding:10px;
margin-bottom:10px;
}

.regper
{
width:30%;
margin-left:10px;
height:100%;
padding:10px;
float:left;
background-color:rgb(248, 255, 245);
border: 2px solid DodgerBlue;
}

th
{
color:#554488;
}

.disper
{
width:50%;
margin-left:10px;
padding:10px;
float:left;
}

.superhome{
margin:10px;

}

</style>

</head>
<body>

    <div class="header">
  <h1 class="text-primaryr"> Manage Seat Plan  </h1>    
  <p class="text-success">  ${success}  </p>
 </div>
 
 
 <div class="superhome">
<a href="/admission/subController?submit=superadminhome">Admin Home</a>

</div>

  
<div class="regper">
 


 <!-- <input type="button" value="display" id="showTable"/> -->   

 <!--  <p class="display-4  bg-light">  <a href="viewusers.jsp">View All Records</a></p>    --> 

<form action="adduser.jsp" method="post">

<table class="table  table-hover ">

<tr>
<td>Serial:</td>
<td><input type="number" name="serial"  required/></td>
</tr>

<tr>
<td>Exam Center :</td>
<td><input type="text" name="center" required/></td>
</tr>

<tr>
<td>Address :</td>
<td><input type="text" name="address"  required/></td>
</tr>

<tr>
<td>Room :</td>
<td><input type="text" name="room" required/></td>
</tr>



<tr>
<td>Capacity:</td>
<td><input type="number" name="capacity" required/></td>
</tr>

<tr>
<td>First Range:</td>
<td><input type="text" name="frange" required/></td>
</tr>

<tr>
<td>Last Range :</td>
<td><input type="text" name="lrange"  required/></td>
</tr>


<tr>

<td colspan="2" align="center">
<input type="submit" value="Submit"/>
</td>
</tr>

</table>
</form>



<div >
<br>

	<form enctype="multipart/form-data"  action="/admission/testCSV" method="post">
			 <b class="text-info">  Import CSV FILE  : </b>
			<input type="file" name="chooser" >
			<input type="hidden" value="import" name="action">
			<input type="submit" value="Submit">
	</form>
	<br>
</div>


<div >

<form action="/admission/Create_CSV" method="post">
<b class="text-primary">Export CSV FILE  : </b>
<input type="submit" >
</form>
<br>
</div>





</div>


 <div class="disper">
<div  id="tablediv">
<table  class="table bg-light table-hover " id="countrytable"> 
    <tr> 
        <th >Update</th>
        <th>Delete</th> 
     
        <th >Serial</th> 
        <th >Center</th>         
		<th>Address </th>
		<th>Room </th>
		<th>Capacity </th>
		<th> First Range</th>
		<th>Last Range </th>
        
        
   </tr> 
</table>
</div>
</div>

</body>
</html>