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
								'/admission/SubAdminPopulate',
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
																	.append("<tr><td><a  href='/admission/subController?submit=edit_sub&id="
																			+ value['id']
																			+ "'> Update </a> </td><td><a  href='/admission/subController?submit=delete_sub&id="
																			+ value['id']
																			+ "'> delete </a> </td>   <td>"																		
																			+ value['subuser']
																			+ "</td>   <td>"
																			+ value['subpassword']	
																			+ "</td><td>"
																			+ value['seatgo']																			
																			+ "</td><td>"
																			+ value['yeargo']
																			+ "</td>   <td>"																			
																			+ value['gpago']																			
																			+ "</td><td>"
																			+ value['unitgo']																			
																			+ "</td> </tr>");

														});
									}
								});
			});
});


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
width:35%;
margin-left:10px;
height:520px;
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
  <h3 class="text-primary">Sub Admin Registration</h3>    
   <p class="text-danger">${success}</p>
 </div>





<!--   <p class="text-center"> <a href="/admission/subController?submit=view_sub_admin"> <big>  View All Sub admin Records </big> </a> </p>   --> 

<div class="superhome">
<a href="/admission/subController?submit=superadminhome">Admin Home</a>

</div>

  
<div class="regper">


<form action="/admission/subController" method="post" >

<table  class="table bg-light table-hover  ">

<tr>
<td>Enter  Username </td>
  <td> 
		<input type="text" name="subuser" required >       
  </td>	
</tr>

<tr>
<td>Enter Password </td>
  <td> 
		<input type="text" name="subpassword" required >     
  </td>	
</tr>

<tr>  
<td> Seat Plan Access Permission  </td>
<td> <input type="checkbox" name="seatgo" value="1">   </td>
</tr>

<tr>
<td> Examination year Access Permission  </td>
<td> <input type="checkbox" name="yeargo" value="1">  </td>
</tr>

<tr>
<td> Minimum G.P.A. For Each Unit Access Permission  </td>
<td> <input type="checkbox" name="gpago" value="1">    </td>
</tr>

<tr>
<td> Applied Unit applicant's data Access Permission  </td>
<td> <input type="checkbox" name="unitgo" value="1">  </td>

</tr>



<tr>
<td></td>
<td> <button type="submit" name="submit" value="Sub_Admin_Registration">Add Sub admin</button>  </td>
</tr>

</table>
</form>

</div>


<div class="disper">

 <!-- <input type="button" value="display" id="showTable"/> -->   
<p class="bg-info text-white"> Sub Admin Dashboard</p>

<div  id="tablediv">
<table  class="table bg-light table-hover " id="countrytable"> 
    <tr> 
        <th >Update</th>
        <th >Delete</th> 
     
       <th >User Name</th> 
        <th >Password</th> 
        
        <th >  Seat Plan</th> 
          <th > Examination year </th> 
            <th > Minimum G.P.A. For Each Unit </th> 
              <th > Applied Unit applicant's data </th> 
             
    </tr> 
</table>
</div>

</div>


</body>
</html>