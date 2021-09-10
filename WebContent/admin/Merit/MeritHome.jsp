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
								'/admission/MeritController',
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
																	.append("<tr><td>"																		
																			+ value['roll']
																			+ "</td>   <td>"
																			+ value['serial']
																			+ "</td>   <td>"
																			+ value['board']
																			+ "</td>   <td>"
																			+ value['ssc_letter']
																			+ "</td>   <td>"
																			+ value['hsc_letter']
																			+ "</td>   <td>"
																			+ value['name']
																			+ "</td>   <td>"
																			+ value['father']
																			+ "</td>   <td>"
																			+ value['mother']
																			+ "</td>   <td>"
																			+ value['per_tot']
																			+ "</td>   <td>"
																			+ value['ban']
																			+ "</td>   <td>"
																			+ value['eng']
																			+ "</td>   <td>"
																			+ value['phy']
																			+ "</td>   <td>"
																			+ value['che']
																			+ "</td>   <td>"
																			+ value['mat']
																			+ "</td>   <td>"
																			+ value['bio']
																			+ "</td>   <td>"
																			+ value['ict']
																			+ "</td>   <td>"
																			+ value['mcq']
																			+ "</td>   <td>"
																			+ value['g_total']
																			+ "</td>   <td>"
																			+ value['merit']																		
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
background-color:rgb(248, 255, 245);
text-align:center;
padding:10px;
margin-bottom:10px;
}

.regper
{
width:20%;
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
width:100%;
margin:5px;
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
  <h3> TOP 3 Student of All Unit  </h3>    
    <h4>${success}</h4>
 </div>
 
 
 <div class="superhome">
<a href="/admission/subController?submit=superadminhome">Admin Home</a>

<br>

<form action="/admission/MeritController" method="POST">
<b class="text-primary">Export Merit As CSV  : </b>
<button type="submit" name="submit" value="ssccsv"> Create CSV</button>
</form>
<br>
</div>





 <div class="disper">
<div class="table table-hover table-striped" id="tablediv">

    <h4  align="center" class="text-white bg-secondary" >  Top 3 students  </h4>
 
<table   id="countrytable"> 

    
    <tr class="bg-info">        
        <th class="text-white">SSC Roll</th> 
         <th class="text-white">HSC Roll</th>         
		 <th class="text-white"> Board</th>
		 <th class="text-white">SSS Letter </th>
		 <th class="text-white"> HSC Letter</th>
		  <th class="text-white">Name</th> 
        <th class="text-white">Father</th>         
		 <th class="text-white"> Mother</th>
		 <th class="text-white">Result point </th>
		 <th class="text-white">Bangla </th>
		  <th class="text-white">English</th> 
        <th class="text-white">Physics</th>         
		 <th class="text-white"> Chemistry</th>
		 <th class="text-white">Mathematics </th>
		 <th class="text-white">Biology </th>
	 <th class="text-white">ICT </th>
		 <th class="text-white">Total MCQ </th>
		 <th class="text-white">Total Marks </th>		
         <th class="text-white">Merit </th>
        
   </tr> 
</table>
</div>
</div>

</body>
</html>