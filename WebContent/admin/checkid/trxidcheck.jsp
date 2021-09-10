<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<div align="center">
<h1>Check Transaction Id</h1>
   <hr>
      <input type="button" onclick="location.href='/admission/indexhome.jsp';" value="Home Page" />
      <hr>

<form method="post" action="trxid.jsp">
<table border="0">       
         <tr>        
         <td>Check : </td>
        <td> 
		        <select name="id" required>
					    <option value="verified">verified</option>
					    <option value="unverified">Unverified</option>
					    <option value="all">all</option>			  
			    </select>
	     </td>	
	     <td><input type="submit" value="Submit"/></td>
       </tr>              

      </table>
</form>


      
 </div>     
</body>

</html>