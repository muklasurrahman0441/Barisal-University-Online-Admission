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
 



</head>
<body>


   <div class="jumbotron jumbotron-fluid text-center" style="background-color:#DCDCDC;">
  <h3 class="primary">Welcome Result Board </h3>   
  <h3>${status}</h3> 
   </div>
    

<div class="container bg-light  border border-info">

<%

String hscroll = request.getParameter("hscroll");

%>

<br>



<form action="/admission/subController" method="post">


Your HSC Roll : <input type="text" name="serial1"  value=<%=hscroll %>  required >

<button type="submit" name="submit" value="Find_Result">Find Result</button>


</form>



<br>
</body>
</html>