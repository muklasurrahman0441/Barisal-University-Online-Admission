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
   <div class="jumbotron jumbotron-fluid text-center">
  <h1 class="text-info">Download Your Admit Card</h1>    
  <h3 class="text-primary">${status}</h3>
   </div>
    
<div class="container bg-light text-center  border border-info">


<%

String hscroll = request.getParameter("hscroll");

%>


<p class="text-danger text-center">You Can do both print or Download Admit card.</p>
 
 <hr>
<form action="/admission/controller" method="post">


<input type="hidden" name="hscroll"    value=<%=hscroll %>  readonly  required >
<button type="submit" name="submit" value="Download_Admit">Download</button>

</form>

<hr>


<a href="/admission/controller?submit=viewafterpayment&hscroll=<%=hscroll %>">Click to print admit card </a>


</div>






</body>
</html>