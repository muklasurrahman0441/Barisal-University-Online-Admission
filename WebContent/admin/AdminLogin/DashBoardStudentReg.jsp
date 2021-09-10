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
 


<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

$( document ).ready(function() {
	$(document)
	.ready(
			function() {
				$
						.get(
								'/admission/PopulateTablePer?id=41',
								function(responseJson) {
									if (responseJson != null) {
										$("#countrytable").find(
												"tr:gt(0)").remove();
										var table1 = $("#countrytable");
										$
												.each(
														responseJson,
														function(key,
																value) {

															table1
																	.append("<tr><td><a  href='/admission/subController?submit=edit_student_dashboard&id="
																			+ value['id']
																			+ "'> Update </a> </td><td><a  href='/admission/subController?submit=delete_student_Dashboard&id="
																			+ value['id']
																			+ "'> delete </a> </td>   <td>"
																			+ value['apply']
																			+ "</td><td>"
																			+ value['loginper']
																			+ "</td>   <td>"
																			+ value['payment']
																			+ "</td> <td>"
																			+ value['seatplan']
																			+ "</td><td>"
																			+ value['admitcard']
																			+ "</td><td>"
																			+ value['result']
																			+ "</td> </tr>");

														});
									}
								});
			});
});


/*
$(document).ready(function() {
	
     $("#showTable").click(function(event){
           $.get('/admission/PopulateTablePer?id=41',function(responseJson) {
        	   if(responseJson!=null){
            	   $("#countrytable").find("tr:gt(0)").remove();
            	   var table1 = $("#countrytable");
	               $.each(responseJson, function(key,value) { 	            	   

	 table1.append("<tr><td><a  href='/admission/subController?submit=edit_student_dashboard&id="+value['id']+"'> Update </a> </td><td><a  href='/admission/subController?submit=delete_student_Dashboard&id="+value['id']+"'> delete </a> </td>   <td>"+value['apply']+"</td><td>"+value['loginper']+"</td>   <td>"+value['payment']+"</td> <td>"+value['seatplan']+"</td><td>"+value['admitcard']+"</td><td>"+value['result']+"</td> </tr>");
	            	   	  
	               });
                }
            });
            $("#tablediv").show();          
	 });      
});
*/
</script>


<style>

.header
{
left:0;
width:100%;
height:80px;
background-color:#DCDCDC;
text-align:center;
padding:10px;
margin-bottom:10px;
}

.regper
{
width:20%;
margin-left:10px;
height:100%;
padding:10px;
float:left;
background-color:rgb(248, 255, 245);
border: 2px solid DodgerBlue;
}

th
{
color:#554488;
}

.disper
{
width:50%;
margin-left:10px;
padding:10px;
float:left;
}

.superhome{
margin:10px;

}

</style>

</head>
<body>

  <div class="header">
  <h4>Student Dash Board permission</h4>    
   <p class="text-danger">${success}</p>
 </div>


<div class="superhome">
<a href="/admission/subController?submit=superadminhome">Admin Home</a>

</div>

  
<div class="regper">

 <p  align="justify" class="text-danger">Note : Only One row is allowed to insert.  </p>

<form action="/admission/subController" method="post" >

<table class="table  table-hover ">


<tr>
<td> Online Application Permission </td>
<td> <input type="checkbox" name="apply" value="1">    </td>
</tr>

<tr>
<td>Student Login Permission </td>
<td> <input type="checkbox" name="loginper" value="1">   </td>
</tr>

<tr>
<td>Student Payment System Permission </td>
<td> <input type="checkbox" name="payment" value="1">   </td>
</tr>

<tr>
<td>Student Seat plan Permission </td>
<td> <input type="checkbox" name="seatplan" value="1">    </td>
</tr>

<tr>
<td>Admit card Permission </td>
<td> <input type="checkbox" name="admitcard" value="1">   </td>
</tr>

<tr>
<td>Result Permission </td>
<td> <input type="checkbox" name="result" value="1">   </td>
</tr>

<tr>

<td colspan="2" align="center"> 

<button type="submit" name="submit" value="Student_Dashboard_Registration">Submit</button>


</td>
</tr>

</table>
</form>
</div>


<div class="disper">

 <!-- <input type="button" value="display" id="showTable"/> -->   
<p class="bg-info text-white"> Student Dashboad  Permission</p>

<div  id="tablediv">
<table  class="table bg-light table-hover " id="countrytable"> 
    <tr> 
        <th scope="col">Update</th>
        <th scope="col">Delete</th> 
        <th scope="col">Apply</th> 
        <th scope="col">Login</th> 
        <th scope="col">Payment</th> 
        <th scope="col">Seat Plan</th> 
        <th scope="col">Admit Card</th>          
        <th scope="col">Result</th>          
    </tr> 
</table>
</div>
</div>


</body>
</html>