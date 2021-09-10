<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

super admin panel 
<br>

<a href="AdminLogin/AdminRegistration.jsp">Add Super admin</a>
<br>
<hr>
<h3>Seat plan</h3>
<a href="seatplan/index.jsp">Seatplan</a> <br>
<a href="seatplan/clearseatplan.jsp">Clear Seatplan database  database </a>

<br><br><hr>

<h3>Examination Year Settings</h3>
<a href="year/index.jsp">SSC & HSC year management</a><br>
<a href="year/clearseatplan.jsp">Clear SSC & HSC Year management database </a>

<br><br><hr>

<h3>Unit and Minimum G.P.A Ffor Each Unit</h3>
<a href="UnitGpa/insertUnitGpa.jsp">Unit & G.P.A Management</a><br>
<a href="/admission/unitController?submit=cleardatase">Clear Unit and G.P.A  Daatabase</a>

<br><br><hr>

<h3>Unit Management</h3>
<a href="superadmin/displayUnitData.jsp"> Display All Unit Data </a> <br>
<a href="superadmin/unitregistration.jsp">Clear Unit database </a>

<br><br>
</body>
</html>