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
 


<style type="text/css">


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

.d1{
padding:10px;
left:0;
height:0;
width:25%;
height:615px;
border: 2px solid DodgerBlue;
margin:10px;
float:left;
background-color:#ddeac8;
}






#abcd
{

width:200px; 
margin-bottom:5px;
}

#abc
{

width:200px; 
margin-bottom:20px;
}

</style>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


</head>
<body>

 <div class="header">
 <p class="text-primary">Admin Home</p>
 <b><p class="text-success">${success}</p></b>
 </div>


<div class="w3-sidebar w3-bar-block w3-light-grey w3-card" style="width:200px; float:left;">
      
      <h4 class="text-danger text-center"> Dashboard  </h4>
      
     <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo1" id="abcd">Student DashBoard</button>
	<div id="demo1" class="collapse">
	 <pre>  <a href="admin/AdminLogin/DashBoardStudentReg.jsp">Manage DashBoard</a> </pre> 
	</div>     
    
   <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo2"  id="abcd">Super Admin Permission</button>
	<div id="demo2" class="collapse">
	 <pre>  <a href="admin/AdminLogin/AdminRegistration.jsp">Manage Super Admin</a> </pre> 
	</div>
	 
   <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo3" id="abcd">Sub Admin Permission</button>
	<div id="demo3" class="collapse">
	 <pre>  <a href="admin/AdminLogin/SubAdminrRg.jsp">Manage Sub Admin</a> </pre> 
	</div>	
	  
   <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo4" id="abcd">Exam Center Map</button>
	<div id="demo4" class="collapse">
	 <pre>  <a href="admin/ExamCenterMap/Exam_Center_Reg.jsp">Manage Coordinates</a> </pre> 
	</div>
  
   <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo5" id="abcd">Seat plan</button>
	<div id="demo5" class="collapse">
	 <pre>  <a href="admin/seatplan/SeatPlanReg.jsp">Manage Seat plan</a> </pre> 
	</div>
			 
   <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo6" id="abcd">SSC & HSC Exam Year</button>
	<div id="demo6" class="collapse">
	 <pre>  <a href="admin/year/YearReg.jsp">Manage Exam Year</a> </pre> 
	</div>
 
   <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo7" id="abcd">Unit and G.P.A </button>
	<div id="demo7" class="collapse">
	 <pre>  <a href="admin/UnitGpa/addunit.jsp">Manage Unit and G.P.A</a> </pre> 
	</div>
  
   <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo8" id="abcd">Application Management </button>
	<div id="demo8" class="collapse">
	 <pre>  <a href="/admission/controller?submit=unitview">Manage Application</a> </pre> 
	</div>
 
   <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo9" id="abcd">Student MAC & IP Address </button>
	<div id="demo9" class="collapse">
	 <pre> <a href="/admission/ApplyLocationController?submit=applylocationview">Manage  MAC & IP Address</a> </pre> 
	</div>
	 
   <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo10" id="abcd">Merit List </button>
	<div id="demo10" class="collapse">
	 <pre>  <a href="admin/Merit/MeritHome.jsp">Manage Merit List</a> </pre> 
	</div>
	
	<br><br>
	 
 </div>


<div class="card" style="width:200px; float:left; margin-left:400px;">
      <h4 class="text-danger text-center"> Dashboard  </h4>
      <hr>
      <input type="button" onclick="location.href='indexhome.jsp';" value="Home Page" />
      <hr>
        <input type="button" onclick="location.href='admin/checkid/trxidcheck.jsp';" value="Check student Trnasaction" />
    <hr>
      


<button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demoo" id="abc">Result Management</button>
	<div id="demoo" class="collapse">	
	
					<div >
					<dl>
					    <dt>Analysis Result :</dt>
					    <dd> <a href="admin/Result/ResultHome.jsp"> Click Here </a>   </dd>
					</dl> 
					<b>Upload Result as CSV FILE</b> 
					<br><br>
						<form enctype="multipart/form-data"  action="/admission/uploadResultCsvController" method="post">
								<input type="file" name="chooser" >
								<input type="hidden" value="import" name="action">		
									<br>		
								<button type="submit" value="Submit"> Submit </button>	
								<br><br>	
						</form>
					</div>															
	</div>
	
	
	
	
	<button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demooN" id="abc">Manage Database</button>
	<div id="demooN" class="collapse">	
	
			<div>
			<dl>
			    <dt>Clear Database options </dt>
			    <dd>  <a href="admin/seatplan/clearseatplan.jsp">Clear Seatplan  </a>  </dd>
			    <dd>  <a href="admin/year/clearseatplan.jsp">Clear SSC & HSC Year  </a>  </dd>
			    <dd>   <a href="/admission/unitController?submit=cleardatase">Clear Unit and G.P.A </a> </dd>
			    <dd>  <a href="admin/superadmin/unitregistration.jsp">Clear Unit data </a>  </dd>   
			 </dl> 
			</div>
</div>
	
	</div>
	
	
	
	


</body>
</html>