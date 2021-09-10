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


<style>

.header
{
left:0;
width:100%;
height100px;
background-color:#a4bdba;
text-align:center;
padding:10px;
margin-bottom:10px;
}

.regper
{
width:30%;
margin-left:10px;
height:450px;
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




 <script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
 
$( document ).ready(function() {
	$(document)
	.ready(
			function() {
				$
						.get(
								'/admission/ExamCenterMapPopulate',
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
																	.append("<tr><td><a  href='/admission/MapController?submit=upmap&map_id="
																			+ value['map_id']
																			+ "'> Update </a> </td><td><a  href='/admission/MapController?submit=mapdelete&map_id="
																			+ value['map_id']
																			+ "'> delete </a> </td>   <td>"																		
																			+ value['lat']
																			+ "</td>   <td>"
																			+ value['lng']
																			+ "</td>   <td>"
																			+ value['examcenter']																																				
																			+ "</td> </tr>");

														});
									}
								});
			});
});


</script>

</head>
<body>

    
 
 
 <div class="superhome">
<a href="/admission/subController?submit=superadminhome">Admin Home</a>

</div>

  
<div class="regper">
 


 <!-- <input type="button" value="display" id="showTable"/> -->   

 <!--  <p class="display-4  bg-light">  <a href="viewusers.jsp">View All Records</a></p>    --> 

<form action="/admission/MapController" method="GET">

<table class="table  table-hover ">

<tr>
<td>Latitude   :</td>
<td><input type="text" name="lat"  required/></td>
</tr>

<tr>
<td>Longitude :</td>
<td><input type="text" name="lng" required/></td>
</tr>

<tr>
<td>Exam Center :</td>
<td><input type="text" name="examcenter"  required/></td>
</tr>

<tr>
<td colspan="2" align="center">
<input input type="submit" name="submit" value="Upload" />
</td>
</tr>

</table>
</form>

<hr>

  <a href="map.html" target="_blank">   <b class="text-info">Click to Find Coordinates </b> </a>

</div>

<div class="disper">
<div  id="tablediv">
<table  class="table bg-light table-hover " id="countrytable"> 
    <tr> 
        <th >Update</th>
        <th>Delete</th> 
     
        <th >Latitude</th> 
        <th >Longitude</th>         
		<th>Exam Center </th>
		
        
   </tr> 
</table>
</div>
</div>


</body>
</html>