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
height100px;
background-color:#DCDCDC;
text-align:center;
padding:10px;
margin-bottom:10px;
}

</style>


</head>
<body>

    <div class="header">
    
  <h3 class="text-danger">Sub Admin Dashboard </h3>
   <p>${status}</p>
 </div>

<div class="container bg-light text-center  text-primary">
  
  
  <!--  <a href="LogoutServlet">Logout</a>  <br>  --> 
  
      <a href="/admission/subController?submit=logut_sub">Logout</a>  
      <br>  

<a href="/admission/subController?submit=view_sub_admin_home&id=${success}"> <big> View Sub admin data </big> </a>
</div>




</body>
</html>