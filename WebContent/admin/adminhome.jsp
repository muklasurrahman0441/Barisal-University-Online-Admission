<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
 

</head>
<body>


  <div class="jumbotron jumbotron-fluid text-center bg-info text-white">
  <h1>Admin Home</h1>    
  <p>Only authorized admin is accessable</p>
 </div>



  <div class="text-center bg-light">       
       <form method="post" action="/admission/adminController">           
         Select Admin login :         
		        <select name="adminselect" required>
					    <option value="SuperAdmin">Super Admin</option>
					    <option value="SubAdmin">Sub Admin</option>		  
			    </select>	    
	   <input type="submit" name="submit" value="Select"/>           
     </form>       
  </div>








</body>
</html>