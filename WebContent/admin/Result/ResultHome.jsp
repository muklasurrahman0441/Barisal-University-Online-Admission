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

<style>

.searchgender
{

padding:10px;
margin-left:10px;
width:45%;
height:700px;
overflow: scroll;
}


.SearchDivision
{
float:left;
padding:10px;
margin-left:10px;
margin-right:20px;
width:45%;
height:700px;
overflow: scroll;


}

/* Scrollbar styles */
::-webkit-scrollbar {
width: 12px;
height: 12px;
}

::-webkit-scrollbar-track {
box-shadow: inset 0 0 10px olivedrab;
border-radius: 10px;
}

::-webkit-scrollbar-thumb {
border-radius: 10px;
background: yellowgreen; 
box-shadow: inset 0 0 6px rgba(0,0,0,0.5); 
}

::-webkit-scrollbar-thumb:hover {
background: #7bac10;
}





</style>


<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#tablediv").hide();
     $("#showTable").click(function(event){
           $.get('/admission/DivisionPopulate?id=41', {name:document.getElementById("division").value},  function(responseJson) {
        	   if(responseJson!=null){
            	   $("#countrytable").find("tr:gt(0)").remove();
            	   var table1 = $("#countrytable");
	               $.each(responseJson, function(key,value) { 
	               		   var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
	                       rowNew.children().eq(0).text(value['count']); 
	                       rowNew.children().eq(1).text(value['id']); 
	                       rowNew.children().eq(2).text(value['board']); 	                       
	                       rowNew.children().eq(3).text(value['name']); 
	                       rowNew.children().eq(4).text(value['father']); 
	                       rowNew.children().eq(5).text(value['mother']); 
	                       rowNew.children().eq(6).text(value['mcq']); 
	                       rowNew.children().eq(7).text(value['g_total']); 
	                       rowNew.children().eq(8).text(value['merit']); 
	                       rowNew.appendTo(table1);
	               });
                }
            });
            $("#tablediv").show();          
	 });      
});
</script>



<script type="text/javascript">
$(document).ready(function() {
	$("#tablegender").hide();
     $("#showgender").click(function(event){
           $.get('/admission/GenderPolulate', {name:document.getElementById("gender").value},  function(responseJson) {
        	   if(responseJson!=null){
            	   $("#countrygender").find("tr:gt(0)").remove();
            	   var table1 = $("#countrygender");
	               $.each(responseJson, function(key,value) { 
	               		   var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
	                       rowNew.children().eq(0).text(value['count']); 
	                       rowNew.children().eq(1).text(value['id']); 
	                       rowNew.children().eq(2).text(value['board']); 	                       
	                       rowNew.children().eq(3).text(value['name']); 
	                       rowNew.children().eq(4).text(value['father']); 
	                       rowNew.children().eq(5).text(value['mother']); 
	                       rowNew.children().eq(6).text(value['mcq']); 
	                       rowNew.children().eq(7).text(value['g_total']); 
	                       rowNew.children().eq(8).text(value['merit']); 
	                       rowNew.children().eq(9).text(value['gender']); 
	                       rowNew.appendTo(table1);
	               });
                }
            });
            $("#tablegender").show();          
	 });      
});
</script>


</head>
<body>






<div class="SearchDivision">

<select id="division">
  <option value="BARISAL">BARISAL</option>
  <option value="DHAKA">DHAKA</option>
  <option value="CHITTAGONG">CHITTAGONG</option>
  <option value="JESSORE">JESSORE</option>  
  <option value="RAJSHAHI">RAJSHAHI</option>
  <option value="COMILLA">COMILLA</option>
  <option value="DINAJPUR">DINAJPUR</option>  
</select>	

<input type="button" value="Search Board" id="showTable"/>

<div id="tablediv">
<table class="table table-hover text-center"  id="countrytable"> 
    <tr class="bg-info text-white "> 
       <th>Serial</th>
	   <th>ID</th>
	   <th>Board </th>	
	    <th> Name</th>		
	      <th>Father Name </th>		
	        <th>Mother Name </th>		
	          <th> MCQ</th>		
	            <th>Total grade </th>		
	              <th> Merit  </th>		  
    </tr> 
</table>
</div>


</div>



<div class="searchgender">

<select id="gender">
  <option value="1">Male</option>
  <option value="2">Female</option>
  <option value="3">Others</option>
</select>	

<input type="button" value="Search Gender" id="showgender"/>

<div id="tablegender">
<table   id="countrygender"> 
    <tr class="bg-info text-white "> 
       <th>Serial</th>
	   <th>ID</th>
	   <th>Board </th>	
	    <th> Name</th>		
	      <th>Father Name </th>		
	        <th>Mother Name </th>		
	          <th> MCQ</th>		
	            <th>Total grade </th>		
	              <th> Merit  </th>	
	              <th> Gender  </th>		  
    </tr> 
</table>
</div>

</div>



<!--  

<div class="SearchDivision">
<form action="/admission/ResultController" method="post" >
<table>
<tr>
<td>Select Division :</td>
  <td>   
<select name="division">
  <option value="BARISAL">BARISAL</option>
  <option value="DHAKA">DHAKA</option>
  <option value="CHITTAGONG">CHITTAGONG</option>
  <option value="JESSORE">JESSORE</option>  
  <option value="RAJSHAHI">RAJSHAHI</option>
  <option value="COMILLA">COMILLA</option>
  <option value="DINAJPUR">DINAJPUR</option>  
</select>	  
  </td>	
</tr>
<tr>
<td></td>
<td> <button type="submit" name="submit" value="SearchBarisal"> Find  </button>     </td>
</tr>
</table>
</form>


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

-->



</body>
</html>