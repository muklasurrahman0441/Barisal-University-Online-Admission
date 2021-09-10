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
								'/admission/PopulateTableUnit',
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
																	.append("<tr><td><a  href='/admission/unitController?submit=edit&id="
																			+ value['id']
																			+ "'> Update </a> </td><td><a  href='/admission/unitController?submit=delete&id="
																			+ value['id']
																			+ "'> delete </a> </td>   <td>"																		
																			+ value['unit']
																			+ "</td>   <td>"
																			+ value['sgpa']			
																			+ "</td>   <td>"
																			+ value['hgpa']		
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
height100px;
background-color:#ddeac8;
text-align:center;
padding:10px;
margin-bottom:10px;
}

.regper
{
width:30%;
margin-left:10px;
height:300px;
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
  <h1>Set Minimum G.P.A for Each Unit </h1>    
  <p  class="text-info" >${success}</p>
 </div>
 


<div class="superhome">
<a href="/admission/subController?submit=superadminhome">Admin Home</a>

</div>



<div class="regper">


 <!--    <p  class=" text-center"> <big><a  class=" bg-info text-white"  href="/admission/unitController?submit=view"> View all records </a></big> </p>   -->

<form action="/admission/unitController" method="post" >
<table class="table bg-light  table-hover " >
<tr>
<td> Set Unit</td>
  <td> 
		        <select name="unit" required>
					    <option value="KA">KA</option>
					    <option value="KHA">KHA</option>
					    <option value="GA">GA</option>			  
			    </select>
	     </td>	
</tr>
<tr>
<td >Set Minimum SSC G.P.A. </td>
<td>   <input type="number" name="sgpa" placeholder="0.0" step="0.01" min="0" max="5" required/>  </td>
</tr>
<tr>
<td>Set Minimum HSC G.P.A. </td>
<td>   <input type="number" name="hgpa" placeholder="0.0" step="0.01" min="0" max="5" required/>  </td>
</tr>
<tr>
<td></td>
<td> <button type="submit" name="submit" value="Set"  class="btn btn-outline-primary"  > Set </button></td>
</tr>
</table>

</form>

</div>

<div class="disper">

 <!-- <input type="button" value="display" id="showTable"/> -->   
<p class="bg-info text-white"> Unit and Minimum G.P.A</p>

<div  id="tablediv">
<table  class="table bg-light table-hover " id="countrytable"> 
    <tr> 
        <th >Update</th>
        <th>Delete</th> 
     
        <th >Unit</th> 
        <th >SSC G.P.A.</th> 
        <th >HSC G.P.A.</th> 
        
 
              
                   
    </tr> 
</table>
</div>

</div>

</body>
</html>