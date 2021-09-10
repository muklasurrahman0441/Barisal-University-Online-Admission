<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

String hscroll = request.getParameter("hscroll");

%>


<form method="get" action="/admission/controller">

<table>

<tr>
<td>Your HSC Roll</td>
<td><input type="number" name="hscroll"  value=<%=hscroll %>  read only required/></td>
</tr>

<tr>
<td>
 <input type="submit" name="submit" value="view"> 
</td>
</tr>


</table>
    

   


</form>

</body>
</html>