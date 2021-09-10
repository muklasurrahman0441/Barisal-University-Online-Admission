<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Seat plan</title>

<link rel="stylesheet" type="text/css" href="navigation.css">

</head>
<body>

<br><br>

<%@ page import="java.sql.*" %>
<%
String trxid =  request.getParameter("trxid");
System.out.println("see" +trxid);
PreparedStatement ps=null;
Connection con=null;
ResultSetMetaData rsmd=null;
ResultSet rs=null;


try{
	
	Class.forName("com.mysql.jdbc.Driver");
     con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/admission", "root", "");

	  ps=con.prepareStatement("select * from payment where usertrxid=?");
     //  PreparedStatement ps=con.prepareStatement("select * from userlogin");
       ps.setString(1,trxid);           
      
       
      rs=ps.executeQuery(); 
      rsmd=rs.getMetaData();
      
    
       while(rs.next())
          {
    	   if( rs.getString(6).equals(trxid) )
    		{
       	  
       	  String sql="Update payment set uvtrxid=? where hscroll="+rs.getString(4);
       	  ps = con.prepareStatement(sql);
       	  ps.setString(1, "verified");
       	  ps.executeUpdate();   	 
       	  
     	  out.print("<h3>TrxID Verified</h3><br>");     
     	  out.print(" <a href=trxidcheck.jsp> Check Transaction </a><br>");   
     	  
     	  
     	  out.print(" <a href=/admission/indexhome.jsp>Homepage </a>"); 
     	
      		}
    	   
    	  
                   
      
          
          
          
        
    
          }

  //    out.print("<br><br><hr> If you want to edit your info , do it now . Later you can not update your info. <a href=updatereg.jsp> update </a> ");


     
      
}              
catch (Exception e2)
  {
      e2.printStackTrace();
  }


%>





</body>
</html>