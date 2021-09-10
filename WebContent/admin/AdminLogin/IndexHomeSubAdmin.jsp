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
  <h4>${success}</h4>    
  <p>Only authorized Subadmin is accessable</p>
 </div>






<div class="container bg-light">
<h3 class=" text-center  text-primary">Sub Admin Login Form</h3>
<form action="/admission/subController" method="GET" >
<table class="table table-hover ">
<tr>
<td>Enter Username </td>
  <td> 
		<input type="text" name="subuser" required >       
  </td>	
</tr>
<tr>
<td>Enter Password </td>
  <td> 
		<input type="password" name="subpassword" required >       
  </td>	
</tr>
<tr>
<td></td>
<td> 
<button  type="submit" name="submit" value="Sub_Admin_Login"  > Login </button> </td>
</tr>
</table>
</form>
</div>





</body>
</html>