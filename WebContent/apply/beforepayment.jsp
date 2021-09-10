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

  <div class="jumbotron jumbotron-fluid text-center">
  <h4>${var}</h4>
  </div>

<div class="container">


 <dl>
    <dt>Student Dashboard</dt>
<a href="/admission/subController?submit=view_student_dashboar"> Go Student Dash Board </a>        
    <dt>Complete Payment System </dt>
    <dd><a href="/admission/controller?submit=view&hscroll=${success}">Go for payment </a></dd>
     <dt>Update Your Information</dt>
    <dd><a href="/admission/controller?submit=edit_apply&hscroll=${success}">Edit</a></dd>
  </dl>     










</div>

</body>
</html>