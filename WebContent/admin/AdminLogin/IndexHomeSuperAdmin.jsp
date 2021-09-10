<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Super Admin </title>

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

</style>



</head>
<body>


  <div class="header">
  <h3>${success}</h3>    
  <p class="text-info">Only authorized admin is accessable</p>
 </div>

<div class="container border border-info bg-light">
<h4 class=" text-center  text-primary">Super Admin Login</h4>

<form action="/admission/adminController" method="GET" >
<table class="table table-light table-hover ">
<tr>
<td>Enter User Name </td>
  <td> 
		<input type="text" name="superuser" required >       
  </td>	
</tr>
<tr>
<td>Enter Password </td>
  <td> 
		<input type="password" name="superpassword" required >       
  </td>	
</tr>
<tr>
<td></td>
<td>
<button type="submit" name="submit" value="Super_Admin_Login" class="btn btn-info" >Login</button>
 </td>
</tr>
</table>
</form>


</div>




</body>
</html>