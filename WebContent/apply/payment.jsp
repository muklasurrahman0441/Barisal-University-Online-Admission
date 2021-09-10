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
background-color:rgb(248, 255, 245);
text-align:center;
padding:10px;
margin-bottom:10px;
}
</style>


</head>
<body>


 <div class="header">
  <h3 class="text-info"> Payment System </h3>      
 </div>



<br>

<!-- 
<%
String hroll=request.getParameter("hscroll");
String name=request.getParameter("name");
String unit=request.getParameter("unit");
String roll=request.getParameter("roll");
System.out.println(hroll);
%>

<h1><%=hroll %></h1>
<h1><%=name %></h1>
<h1><%=unit %></h1>
<h1><%=roll %></h1>


<a href="/admission/indexhome.jsp">Pay later </a>


 -->

<div class="container bg-light  border border-info">

<p class="text-success"> 
Payment Amount : <b> 500tk </b><br> 
Send  to Nagad  :<b> 01521466521 </b> <br> 
<b class="text-danger">Enter your Transaction Number.</b>  
</p>

<form method="post" action="/admission/controller" enctype="multipart/form-data">

<table  class="table bg-light table-hover text-left ">
 
       <tr> 
	            <td>  Name : </td>  
	            <td>   <input type="text" name="name" value="<%=name %>"  readonly   required/>  </td>
         </tr>                   
	  
	   <tr> 
	            <td>  Hscroll : </td>  
	            <td>   <input type="text" name="hscroll" value="<%=hroll %>" readonly required/>  </td>
       </tr> 
       
          <tr> 
	            <td>  Unit : </td>  
	            <td>   <input type="text" name="unit" value="<%=unit %>" readonly required/>  </td>
       </tr> 
       
       
       
          <tr> 
	            <td>  Roll : </td>  
	            <td>   <input type="text" name="roll" value="<%=roll %>" readonly required/>  </td>
       </tr> 
       
         <tr> 
	            <td>Nagad Transaction Number : </td>  
	            <td>   <input type="text" name="usertrxid"  required/>  </td>
       </tr> 
       
             
       
             <tr> 	    
             <td></td>     
	            <td> 
	            <button type="submit" name="submit" value="addtrxid">Submit</button>
	         
	            </td>
            </tr> 
       
 </table>
 
</form>

</div>


</body>
</html>