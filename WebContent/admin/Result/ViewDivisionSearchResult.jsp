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



<div>

	<table >
			<tr>
					<th>Serial</th>
					<th>ID</th>
					<th>Board </th>					
					</tr>
					
<c:forEach var="product" items="${product}">		
			<tr>
		    	<td>${product.count}</td>
				<td>${product.id}</td>
				<td>${product.board}</td>
			</tr>
</c:forEach>
		</table>
	
</div>



</body>
</html>