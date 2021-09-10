<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<br><br>
<button onclick="myFunction()">Print Transactions</button>

<script>
function myFunction() {
  window.print();
}
</script>
<br><br>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="java.sql.*" %>
<%
String trxid =  request.getParameter("id");
System.out.println(trxid);

///response.setContentType("application/pdf");   
///response.setHeader("content-disposition","attachment; filename="+"transaction.docx");



PreparedStatement ps=null;
Connection con=null;
ResultSetMetaData rsmd=null;
ResultSet rs=null;

int count = 0;

if(trxid.equals("verified"))
{
	try{
		
		Class.forName("com.mysql.jdbc.Driver");
	     con = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/admission", "root", "");

		  ps=con.prepareStatement("select * from payment");
	    
	      rs=ps.executeQuery(); 
	      rsmd=rs.getMetaData();
	      
	      out.print("<table  border=1  cellspacing=5  cellpadding=10>");
	      out.print("<center><h1>Verified transaction list</h1></center>");

	      out.print("<tr> <td>Serial No </td>   ");
	      out.print(" <td>Student Name </td>   ");
          out.print(" <td> Unit    </td>");
	      out.print(" <td>University Trxid  </td> ");
          out.print(" <td>User Trxid  </td>  ");
          out.print(" <td> HSC Roll </td>   </tr>");
	       
	       while(rs.next())
	          {
	    	   
	    	   if(rs.getString(7).equals("unverified"))
	    	   {
	    		   System.out.printf("unverified");
	    	   }
	    	   else
	    	   {
	    		   count++;
		    	   out.print("<tr>  <td>"+count+"</td> ");
		    	   out.print("  <td>"+rs.getString(4)+"</td> ");
		           out.print("   <td>"+rs.getString(5)+"</td>");
	    		   out.print("  <td>"+rs.getString(1)+"</td> ");
		           out.print("   <td>"+rs.getString(2)+"</td>");
		           out.print("   <td>"+rs.getString(3)+"</td></tr> ");    
		           
	    	   }
	       }
	       out.print("</table>");    

	  //    out.print("<br><br><hr> If you want to edit your info , do it now . Later you can not update your info. <a href=updatereg.jsp> update </a> ");

	       out.print("<br>Total Students : "+count);
           count = 0;
	     
        
	}              
	catch (Exception e2)
	  {
	      e2.printStackTrace();
	  }
}
if(trxid.equals("unverified"))
{
	try{
		
		Class.forName("com.mysql.jdbc.Driver");
	     con = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/admission", "root", "");

	     ps=con.prepareStatement("select * from payment");
		    
	      rs=ps.executeQuery(); 
	      rsmd=rs.getMetaData();
	      
	      out.print("<table  border=1  cellspacing=5  cellpadding=10>");
	      out.print("<center><h1>Unverified transaction list</h1></center>");

	      out.print("<tr> <td>Serial No </td>   ");
	      out.print(" <td>Student Name </td>   ");
          out.print(" <td> Unit    </td>");
	      out.print(" <td>University Trxid  </td> ");
          out.print(" <td>User Trxid  </td>  ");
          out.print(" <td> HSC Roll </td>   ");
          out.print(" <td> Verify </td>   </tr>");
	       
	       while(rs.next())
	          {
	    	   
	    	   if(rs.getString(7).equals("unverified"))
	    	   {
	    		   count++;
		    	   out.print("<tr>  <td>"+count+"</td> ");
		    	   out.print("  <td>"+rs.getString(4)+"</td> ");
		           out.print("   <td>"+rs.getString(5)+"</td>");
	    		   out.print("  <td>"+rs.getString(1)+"</td> ");
		           out.print("   <td>"+rs.getString(2)+"</td>");
		           out.print("   <td>"+rs.getString(3)+"</td>");
		           
		           
		           out.print("<td><form method=\"post\" action=\"admintrxid.jsp\">\r\n" + 
                    		"          \r\n" + 
                    		"          <input type=\"hidden\" name=\"trxid\" value=\""+rs.getString(6)+"\" required/> \r\n" + 
                    		"	     <input type=\"submit\" value=\"verify\"/> \r\n" + 
                    		"	    		\r\n" + 
                    		"</form></td></tr>");
		           
	    		 
	    	   }
	    	   else
	    	   {
	    		         
	    		   System.out.printf("null");
	    	   }
	       }
	       out.print("</table>");    

	  //    out.print("<br><br><hr> If you want to edit your info , do it now . Later you can not update your info. <a href=updatereg.jsp> update </a> ");
	       out.print("<br>Total Students : "+count);
           count = 0;

	     
	      
	}              
	catch (Exception e2)
	  {
	      e2.printStackTrace();
	  }
}
if(trxid.equals("all"))
{

	try{
		
		Class.forName("com.mysql.jdbc.Driver");
	     con = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/admission", "root", "");

		  ps=con.prepareStatement("select * from payment");
	    
	      rs=ps.executeQuery(); 
	      rsmd=rs.getMetaData();
	      
	      out.print("<table border=1 cellspacing=5  cellpadding=10> ");
	      out.print("<center><h1>All transaction list</h1></center>");
	      
	      out.print("<tr> <td>Serial No </td>   ");
	      out.print(" <td>Student Name </td>   ");
          out.print(" <td> Unit    </td>");
	      out.print(" <td>University Trxid  </td> ");
          out.print(" <td>User Trxid  </td>  ");
          out.print(" <td> HSC Roll </td>   </tr>");
          

	       
	       while(rs.next())
	          {
	    	   count++;
	    	   out.print("<tr>  <td>"+count+"</td> ");
	    	   out.print("  <td>"+rs.getString(4)+"</td> ");
	           out.print("   <td>"+rs.getString(5)+"</td>");
    		   out.print("  <td>"+rs.getString(1)+"</td> ");
	           out.print("   <td>"+rs.getString(2)+"</td>");
	           out.print("   <td>"+rs.getString(3)+"</td> </tr>");  
	    
	          }
	       out.print("</table>"); 

	  //    out.print("<br><br><hr> If you want to edit your info , do it now . Later you can not update your info. <a href=updatereg.jsp> update </a> ");
             out.print("<br>Total Students : "+count);
             count = 0;

	     
	      
	}              
	catch (Exception e2)
	  {
	      e2.printStackTrace();
	  }
}





%>


</body>
</html>