package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import search.ConnectionClass;
import search.searchBean;

public class searchModel {
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	String sql = "";
	
	
	
	public List<searchBean> retriveProduct() throws SQLException
	{
		List<searchBean> been = new ArrayList<>();
		con = ConnectionClass.createConnection();
		String sql= "SELECT * FROM imaageup ORDER BY date DESC";
		PreparedStatement pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next())
		{
			int id = rs.getInt(1);			
			String name = rs.getString(2);	
			String fathername = rs.getString(3);
			String mothername = rs.getString(4);
			String dateofbirth = rs.getString(5);
			
			String  mobile= rs.getString(6);
			String  quota= rs.getString(7);
			String  unit= rs.getString(8);
			String  sscroll= rs.getString(9);			
			String  sscreg= rs.getString(10);
			String  sscyear= rs.getString(11);
			String  sscgpa= rs.getString(12);
			String  sscgroup= rs.getString(13);
			String  sscboard= rs.getString(14);
			String  hscroll= rs.getString(15);
			String  hscreg= rs.getString(16);
			String  hscyear= rs.getString(17);
			String  hscgpa= rs.getString(18);
			String  hscgroup= rs.getString(19);
			String  hscboard= rs.getString(20);
			String  payment= rs.getString(21);
			int  roll= rs.getInt(23);
			String  date= rs.getString(24);

		     
			 System.out.println("hscroll in sss " + hscroll );
			 
			 
			 int serial=0,capacity=0;
			 String center = null,address=null,room=null;
		
			String sqlseat= "SELECT * FROM examcenter";
			PreparedStatement pstseat = con.prepareStatement(sqlseat);
			ResultSet rs1 = pstseat.executeQuery();
			while(rs1.next())
			{
				
				int fr=Integer.parseInt(rs1.getString(7));
				int lr=Integer.parseInt(rs1.getString(8));
				 System.out.println("fr ,lr  : " +fr+lr);

				if(roll>=fr && roll<=lr)
				{
					serial = rs1.getInt("serial");
					center = rs1.getString("center");
				    address = rs1.getString("address");
				   	room =rs1.getString("room");
					capacity=rs1.getInt("capacity");
					 
					 System.out.println("roll center,address : " +serial+center+address+room+capacity);
				}
				
			}
		
			
			
		

			searchBean newbean = new searchBean(id,name,fathername,mothername,dateofbirth,mobile,quota,unit,sscroll,sscreg,sscyear,sscgpa,sscgroup,sscboard,hscroll,hscreg,hscyear,hscgpa,hscgroup,hscboard,payment,roll,date,serial,center,address,room,capacity );
			been.add(newbean);
		}
		return been;
	}
	
	
	
	public int Create_CSV_File_Date(String dat) throws SQLException, FileNotFoundException
	{
	
		int val = 0;
		
		try {
		//	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			DateFormat dateFormat = new SimpleDateFormat("HH_mm_ss");
			Date datee = new Date();
			System.out.println(dateFormat.format(datee));
			String ss = String.valueOf(dateFormat.format(datee));
		
		PrintWriter pw = new PrintWriter(new File("C:\\Users\\USER\\Downloads\\"+"CSV_By_Date"+ss+"file_Date"+".csv"));
		StringBuilder sb = new StringBuilder();
		
		
		sb.append("Id");			
		sb.append(",");    		
		sb.append("Name");
		sb.append(",");    
		sb.append("Father's Name");
		sb.append(",");  
		sb.append("Mother's Name");
		sb.append(",");  
		sb.append("Date of Birth");
		sb.append(",");  
		sb.append("Quota");
		sb.append(",");    		
		sb.append("Unit");
		sb.append(",");    		
		sb.append("SSSC Roll");
		sb.append(",");    		
		sb.append("SSC Registration");
		sb.append(",");    		
		sb.append("SSC Year");
		sb.append(",");    		
		sb.append( "SSC G.P.A" );
		sb.append(",");    		
		sb.append("SSC Year" );
		sb.append(",");    		
		sb.append( "SSC Board" );
		sb.append(",");    		
		sb.append("HSSC Roll");
		sb.append(",");    		
		sb.append("HSC Registration");
		sb.append(",");    		
		sb.append("HSC Year");
		sb.append(",");    		
		sb.append( "HSC G.P.A" );
		sb.append(",");    		
		sb.append("HSC Year" );
		sb.append(",");    		
		sb.append( "HSC Board" );
		sb.append(",");    		
		sb.append("Payment Status" );
		sb.append(",");    		
		sb.append("Roll");
		sb.append(",");    
		sb.append("Registration Date");
		sb.append("\r\n");
		
		
		
		ConnectionClass obj = new ConnectionClass();
        Connection con = (Connection) obj.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query= "SELECT * FROM imaageup where date="+"'"+dat+"'";
		ps=(PreparedStatement) con.prepareStatement(query);		
        rs=ps.executeQuery();
		
        val = 111;
        
        while(rs.next())
        {
        
		    sb.append(rs.getInt("id"));			
    		sb.append(",");    		
    		sb.append(rs.getString("name"));
    		sb.append(",");  
    		sb.append(rs.getString("fathername"));
    		sb.append(",");  
    		sb.append(rs.getString("mothername"));
    		sb.append(",");  
    		sb.append(rs.getString("dateofbirth"));
    		sb.append(",");  
    		sb.append(rs.getString("quota"));
    		sb.append(",");    		
    		sb.append(rs.getString("unit"));
    		sb.append(",");    		
    		sb.append( rs.getString("sscroll"));
    		sb.append(",");    		
    		sb.append(  rs.getString("sscreg"));
    		sb.append(",");    		
    		sb.append(rs.getString("sscyear") );
    		sb.append(",");    		
    		sb.append( rs.getString("sscgpa") );
    		sb.append(",");    		
    		sb.append(rs.getString("sscgroup") );
    		sb.append(",");    		
    		sb.append( rs.getString("sscboard") );
    		sb.append(",");    		
    		sb.append(rs.getString("hscroll") );
    		sb.append(",");    		
    		sb.append(rs.getString("hscreg") );
    		sb.append(",");    		
    		sb.append( rs.getString("hscyear"));
    		sb.append(",");    		
    		sb.append(rs.getString("hscgpa") );
    		sb.append(",");    		
    		sb.append(rs.getString("hscgroup") );
    		sb.append(",");    		
    		sb.append( rs.getString("hscboard"));
    		sb.append(",");    		
    		sb.append(rs.getString("payment") );
    		sb.append(",");    		
    		sb.append(rs.getInt("roll") );
    		sb.append(",");    
    		sb.append(rs.getString("date"));
    		sb.append("\r\n");
        }
        
        	
      
		
		pw.write(sb.toString());
		pw.close();
		System.out.println("csv file ready");
		  } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return val;
	}
	
	
	
	
	public int Create_CSV_File() throws SQLException, FileNotFoundException
	{
	
		int val = 0;
		
		try {
		//	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			DateFormat dateFormat = new SimpleDateFormat("HH_mm_ss");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			String ss = String.valueOf(dateFormat.format(date));
		
		PrintWriter pw = new PrintWriter(new File("C:\\Users\\USER\\Downloads\\"+"createCSV"+ss+"file"+".csv"));
		StringBuilder sb = new StringBuilder();
		
		
		sb.append("Id");			
		sb.append(",");    		
		sb.append("Name");
		sb.append(",");  
		sb.append("Father's Name");
		sb.append(",");  
		sb.append("Mother's Name");
		sb.append(",");  
		sb.append("Date of Birth");
		sb.append(",");  
		sb.append("Quota");
		sb.append(",");    		
		sb.append("Unit");
		sb.append(",");    		
		sb.append("SSSC Roll");
		sb.append(",");    		
		sb.append("SSC Registration");
		sb.append(",");    		
		sb.append("SSC Year");
		sb.append(",");    		
		sb.append( "SSC G.P.A" );
		sb.append(",");    		
		sb.append("SSC Year" );
		sb.append(",");    		
		sb.append( "SSC Board" );
		sb.append(",");    		
		sb.append("HSSC Roll");
		sb.append(",");    		
		sb.append("HSC Registration");
		sb.append(",");    		
		sb.append("HSC Year");
		sb.append(",");    		
		sb.append( "HSC G.P.A" );
		sb.append(",");    		
		sb.append("HSC Year" );
		sb.append(",");    		
		sb.append( "HSC Board" );
		sb.append(",");    		
		sb.append("Payment Status" );
		sb.append(",");    		
		sb.append("Roll");
		sb.append(",");    
		sb.append("Registration Date");
		sb.append("\r\n");
		
		
		
		ConnectionClass obj = new ConnectionClass();
        Connection con = (Connection) obj.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "select * from imaageup";       
		ps=(PreparedStatement) con.prepareStatement(query);		
        rs=ps.executeQuery();
		
        val = 111;
        
        while(rs.next())
        {
        
		    sb.append(rs.getInt("id"));			
    		sb.append(",");    		
    		sb.append(rs.getString("name"));
    		sb.append(",");    	
    		sb.append(rs.getString("fathername"));
    		sb.append(",");  
    		sb.append(rs.getString("mothername"));
    		sb.append(",");  
    		sb.append(rs.getString("dateofbirth"));
    		sb.append(",");  
    		sb.append(rs.getString("quota"));
    		sb.append(",");    		
    		sb.append(rs.getString("unit"));
    		sb.append(",");    		
    		sb.append( rs.getString("sscroll"));
    		sb.append(",");    		
    		sb.append(  rs.getString("sscreg"));
    		sb.append(",");    		
    		sb.append(rs.getString("sscyear") );
    		sb.append(",");    		
    		sb.append( rs.getString("sscgpa") );
    		sb.append(",");    		
    		sb.append(rs.getString("sscgroup") );
    		sb.append(",");    		
    		sb.append( rs.getString("sscboard") );
    		sb.append(",");    		
    		sb.append(rs.getString("hscroll") );
    		sb.append(",");    		
    		sb.append(rs.getString("hscreg") );
    		sb.append(",");    		
    		sb.append( rs.getString("hscyear"));
    		sb.append(",");    		
    		sb.append(rs.getString("hscgpa") );
    		sb.append(",");    		
    		sb.append(rs.getString("hscgroup") );
    		sb.append(",");    		
    		sb.append( rs.getString("hscboard"));
    		sb.append(",");    		
    		sb.append(rs.getString("payment") );
    		sb.append(",");    		
    		sb.append(rs.getInt("roll") );
    		sb.append(",");    
    		sb.append(rs.getString("date"));
    		sb.append("\r\n");
        }
        
        	
      
		
		pw.write(sb.toString());
		pw.close();
		System.out.println("csv file ready");
		  } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return val;
	}
	 

	 
	
	
	public List<searchBean> searchModel(String hroll)throws SQLException
	{
		
		  int serial = 0,capacity=0;
		 String center="",address="",room="",rol="";
		
		List<searchBean> been = new ArrayList<>();
		con = ConnectionClass.createConnection();
		String sql= "SELECT * FROM imaageup where hscroll="+hroll;
		PreparedStatement pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next())
		{
			int id = rs.getInt(1);			
			String name = rs.getString(2);		
			
			String fathername = rs.getString(3);	
			String mothername = rs.getString(4);	
			String dateofbirth = rs.getString(5);	
			
			String  mobile= rs.getString(6);
			String  quota= rs.getString(7);
			String  unit= rs.getString(8);
			String  sscroll= rs.getString(9);			
			String  sscreg= rs.getString(10);
			String  sscyear= rs.getString(11);
			String  sscgpa= rs.getString(12);
			String  sscgroup= rs.getString(13);
			String  sscboard= rs.getString(14);
			String  hscroll= rs.getString(15);
			String  hscreg= rs.getString(16);
			String  hscyear= rs.getString(17);
			String  hscgpa= rs.getString(18);
			String  hscgroup= rs.getString(19);
			String  hscboard= rs.getString(20);
			String  payment= rs.getString(21);
			
		   int  roll= Integer.parseInt(rs.getString(23));
		   String date = rs.getString(24);
			
		     
			 System.out.println("hscroll in sss " + hscroll );
			 
		
			String sqlseat= "SELECT * FROM examcenter";
			PreparedStatement pstseat = con.prepareStatement(sqlseat);
			ResultSet rs1 = pstseat.executeQuery();
			while(rs1.next())
			{
				
				int fr=Integer.parseInt(rs1.getString(7));
				int lr=Integer.parseInt(rs1.getString(8));
				 System.out.println("fr ,lr  : " +fr+lr);

				if(roll>=fr && roll<=lr)
				{
					serial = rs1.getInt("serial");
					center = rs1.getString("center");
				    address = rs1.getString("address");
				   	room =rs1.getString("room");
					capacity=rs1.getInt("capacity");
					 
					 System.out.println("roll center,address : " +serial+center+address+room+capacity);
				}
				
			}
		
			
			
		

			    searchBean newbean = new searchBean(id,name,fathername,mothername,dateofbirth,mobile,quota,unit,sscroll,sscreg,sscyear,sscgpa,sscgroup,sscboard,hscroll,hscreg,hscyear,hscgpa,hscgroup,hscboard,payment,roll,date,serial,center,address,room,capacity );
			been.add(newbean);
		}
		return been;
	}
	
	
	public List<searchBean> searchModelDate(String dat)throws SQLException
	{
		
		 int serial = 0,capacity=0;
		 String center="",address="",room="",rol="";
		
		
		List<searchBean> been = new ArrayList<>();
		con = ConnectionClass.createConnection();
		
		System.out.println("Coming 1 "+dat);
		
		String sql= "SELECT * FROM imaageup where date="+"'"+dat+"'";
		PreparedStatement pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		System.out.println("Coming 1 executed ");
		
		while(rs.next())
		{
			int id = rs.getInt(1);			
			String name = rs.getString(2);		
			
			String fathername = rs.getString(3);	
			String mothername = rs.getString(4);	
			String dateofbirth = rs.getString(5);	
			
			String  mobile= rs.getString(6);
			String  quota= rs.getString(7);
			String  unit= rs.getString(8);
			String  sscroll= rs.getString(9);			
			String  sscreg= rs.getString(10);
			String  sscyear= rs.getString(11);
			String  sscgpa= rs.getString(12);
			String  sscgroup= rs.getString(13);
			String  sscboard= rs.getString(14);
			String  hscroll= rs.getString(15);
			String  hscreg= rs.getString(16);
			String  hscyear= rs.getString(17);
			String  hscgpa= rs.getString(18);
			String  hscgroup= rs.getString(19);
			String  hscboard= rs.getString(20);
			String  payment= rs.getString(21);
			
		   int  roll= Integer.parseInt(rs.getString(23));
		   String date = rs.getString(24);
			
		     
			 System.out.println("hscroll in sss " + hscroll );
			 
		
			String sqlseat= "SELECT * FROM examcenter";
			PreparedStatement pstseat = con.prepareStatement(sqlseat);
			ResultSet rs1 = pstseat.executeQuery();
			while(rs1.next())
			{
				
				int fr=Integer.parseInt(rs1.getString(7));
				int lr=Integer.parseInt(rs1.getString(8));
				 System.out.println("fr ,lr  : " +fr+lr);

				if(roll>=fr && roll<=lr)
				{
					serial = rs1.getInt("serial");
					center = rs1.getString("center");
				    address = rs1.getString("address");
				   	room =rs1.getString("room");
					capacity=rs1.getInt("capacity");
					 
					 System.out.println("roll center,address : " +serial+center+address+room+capacity);
				}
				
			}
		
			
			
		

			    searchBean newbean = new searchBean(id,name,fathername,mothername,dateofbirth,mobile,quota,unit,sscroll,sscreg,sscyear,sscgpa,sscgroup,sscboard,hscroll,hscreg,hscyear,hscgpa,hscgroup,hscboard,payment,roll,date,serial,center,address,room,capacity );
			been.add(newbean);
		}
		return been;
	}
	
	
	

	
	
	public List<searchBean> searchModelExamRoll(String rl)throws SQLException
	{
		
		  int serial = 0,capacity=0;
		 String center="",address="",room="",rol="";
		
		List<searchBean> been = new ArrayList<>();
		con = ConnectionClass.createConnection();
		String sql= "SELECT * FROM imaageup where roll="+rl;
		PreparedStatement pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next())
		{
			int id = rs.getInt(1);			
			String name = rs.getString(2);		
			
			String fathername = rs.getString(3);	
			String mothername = rs.getString(4);	
			String dateofbirth = rs.getString(5);	
			
			String  mobile= rs.getString(6);
			String  quota= rs.getString(7);
			String  unit= rs.getString(8);
			String  sscroll= rs.getString(9);			
			String  sscreg= rs.getString(10);
			String  sscyear= rs.getString(11);
			String  sscgpa= rs.getString(12);
			String  sscgroup= rs.getString(13);
			String  sscboard= rs.getString(14);
			String  hscroll= rs.getString(15);
			String  hscreg= rs.getString(16);
			String  hscyear= rs.getString(17);
			String  hscgpa= rs.getString(18);
			String  hscgroup= rs.getString(19);
			String  hscboard= rs.getString(20);
			String  payment= rs.getString(21);
			
		   int  roll= Integer.parseInt(rs.getString(23));
		   String date = rs.getString(24);
			
		     
			 System.out.println("hscroll in sss " + hscroll );
			 
		
			String sqlseat= "SELECT * FROM examcenter";
			PreparedStatement pstseat = con.prepareStatement(sqlseat);
			ResultSet rs1 = pstseat.executeQuery();
			while(rs1.next())
			{
				
				int fr=Integer.parseInt(rs1.getString(7));
				int lr=Integer.parseInt(rs1.getString(8));
				 System.out.println("fr ,lr  : " +fr+lr);

				if(roll>=fr && roll<=lr)
				{
					serial = rs1.getInt("serial");
					center = rs1.getString("center");
				    address = rs1.getString("address");
				   	room =rs1.getString("room");
					capacity=rs1.getInt("capacity");
					 
					 System.out.println("roll center,address : " +serial+center+address+room+capacity);
				}
				
			}
		
			
			
		

			    searchBean newbean = new searchBean(id,name,fathername,mothername,dateofbirth,mobile,quota,unit,sscroll,sscreg,sscyear,sscgpa,sscgroup,sscboard,hscroll,hscreg,hscyear,hscgpa,hscgroup,hscboard,payment,roll,date,serial,center,address,room,capacity );
			been.add(newbean);
		}
		return been;
	}
	



	public void retriveImage(int iid,searchBean bean) throws SQLException
	{
		con = ConnectionClass.createConnection();
		String sql= "SELECT image FROM imaageup WHERE id=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1,iid);
		rs = pst.executeQuery();
		while(rs.next())
		{
			Blob blob = rs.getBlob("image");
			byte[] bytearray = blob.getBytes(1, (int) blob.length());
			bean.setImagedata(bytearray);
		}
	}

}
