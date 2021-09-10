package seatplan;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;





public class modelClass {
	
	
	public int Create_csv() throws SQLException
	{
		int val = 0;
		
		try {
			//	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			DateFormat dateFormat = new SimpleDateFormat("HH_mm_ss");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			String ss = String.valueOf(dateFormat.format(date));
		
		PrintWriter pw = new PrintWriter(new File("C:\\Users\\USER\\Downloads\\"+"table"+ss+"haha"+".csv"));
		StringBuilder sb = new StringBuilder();
		
		ConnectionClass obj = new ConnectionClass();
        Connection con = (Connection) obj.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "select * from examcenter";       
		ps=(PreparedStatement) con.prepareStatement(query);		
        rs=ps.executeQuery();
		
        while(rs.next())
        {
        
				sb.append(rs.getInt("serial"));
			
    		sb.append(",");
    		sb.append(rs.getString("center"));
    		sb.append(",");
    		sb.append(rs.getString("address"));
    		sb.append(",");
    		sb.append(rs.getString("room"));
    		sb.append(",");
    		sb.append(rs.getInt("capacity"));
    		sb.append(",");
    		sb.append(rs.getString("frange"));
    		sb.append(",");
    		sb.append(rs.getString("lrange"));
    		sb.append("\r\n");
        }
        
        	
      
		
		pw.write(sb.toString());
		pw.close();
		System.out.println("csv file ready");
		  
		val = 10;
			
			
		}  
		catch (Exception en) {
			
			en.printStackTrace();
		}
		
		
		
		return val;
		
		
	}
	
	
	
	
	public int insert_csv(BufferedReader bufferedReader) throws SQLException
	{
		int val = 0;
		
		
		
		
		
		
		try {
			String line="";
			while ((line=bufferedReader.readLine())!=null)
			{
				String[] values=line.trim().split(",");
				
				 int serial = Integer.parseInt(values[0]);				  
				  String center =String.valueOf(values[1]) ;
					  String address =String.valueOf(values[2]) ;
					  String room = values[3];
					  int capacity = Integer.parseInt(values[4]);
					  String frange = values[5];
					  String lrange = 	values[6];	  
					  System.out.print(serial+" "+center+" "+address+" "+room+" "+capacity+" "+frange+" "+lrange);
					
					  ConnectionClass obj = new ConnectionClass();
				      Connection con = (Connection) obj.createConnection();
				      
				      PreparedStatement ps = (PreparedStatement) con.prepareStatement("insert into examcenter(serial,center,address,room,capacity,frange,lrange) values(?,?,?,?,?,?,?)");
						
					  	ps.setInt(1,serial);
					  	ps.setString(2,center);
					  	ps.setString(3,address);
					  	ps.setString(4,room);
					  	ps.setInt(5,capacity);
					  	
					  	ps.setString(6,frange);
					  	ps.setString(7,lrange);
					     ps.executeUpdate();
					     System.out.println("inserted");
					     val=22;
					
					    }
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return val;
		
		
	}
	

}
