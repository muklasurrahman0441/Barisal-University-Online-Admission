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
								'/admission/YearPopulate',
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
																	.append("<tr><td><a  href='editform.jsp?id="
																			+ value['id']
																			+ "'> Update </a> </td><td><a  href='deleteuser.jsp?id="
																			+ value['id']
																			+ "'> delete </a> </td>   <td>"																		
																			+ value['fssc']
																			+ "</td>   <td>"
																			+ value['lssc']
																			+ "</td>   <td>"
																			+ value['fhsc']
																			+ "</td>   <td>"
																			+ value['lhsc']																		
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
background-color:#DCDCDC;
text-align:center;
padding:10px;
margin-bottom:10px;
}

.regper
{
width:30%;
margin-left:10px;
height:420px;
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
  <h1> Manage SSC &  HSC year  </h1>    
 </div>






<div class="superhome">
<a href="/admission/subController?submit=superadminhome">Admin Home</a>

</div>

  
<div class="regper">


<p class="text-danger" > Note : Set SSC & HSC year carefully . Any Wrong in first and second time year will harm the application process. </p>
<!-- 
  <p class="display-4  bg-light">  <a href="viewusers.jsp">View Record</a></p>
   -->


<form action="adduser.jsp" method="post">

<table  class="table  table-hover">


<tr>
<td>SSC for first time :</td>
<td><input type="text" name="fssc" required/></td>
</tr>

<tr>
<td>SSC for second time :</td>
<td><input type="text" name="lssc"  required/></td>
</tr>

<tr>
<td>HSC for first time :</td>
<td><input type="text" name="fhsc" required/></td>
</tr>



<tr>
<td>HSC for second time :</td>
<td><input type="text" name="lhsc" required/></td>
</tr>



<tr>
<td colspan="2">

<button type="submit" value="Add User">Submit</button>

</td>
</tr>

</table>
</form>


</div>

<div class="disper">

 <!-- <input type="button" value="display" id="showTable"/> -->   
<p class="bg-info text-white"> SSC & HSC Examination Year Management</p>

<div  id="tablediv">
<table  class="table bg-light table-hover " id="countrytable"> 
    <tr> 
        <th >Update</th>
        <th>Delete</th> 
     
        <th > SSC First Time </th> 
        <th > SSC Second Time </th> 
        <th > HSC First Time</th> 
        <th >HSC Second Time </th> 
        
 
              
                   
    </tr> 
</table>
</div>

</div>

</body>
</html>
