package year;


import com.mysql.jdbc.*;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import year.User;
import com.mysql.jdbc.Connection;




public class UserDao {
	
	public static Connection getConnection()
	{
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/admission","root","");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	
	
	public static int clearseatplan(User u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("delete from year");
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}

		return status;
		}

public static int save(User u){
int status=0;
try{
	Connection con=getConnection();
	PreparedStatement ps=con.prepareStatement("insert into year(fssc,lssc,fhsc,lhsc) values(?,?,?,?)");
	ps.setString(1,u.getFssc());
	ps.setString(2,u.getLssc());
	ps.setString(3,u.getFhsc());
	ps.setString(4,u.getLhsc());
	
	status=ps.executeUpdate();
	
	System.out.println("inserted");
	
}catch(Exception e){System.out.println(e);}
return status;
}


public static int update(User u){
int status=0;
try{
	Connection con=getConnection();
	PreparedStatement ps=con.prepareStatement("update year set fssc=?,lssc=?,fhsc=?,lhsc=? where id=?");
	ps.setString(1,u.getFssc());
	ps.setString(2,u.getLssc());
	ps.setString(3,u.getFhsc());
	ps.setString(4,u.getLhsc());
	ps.setInt(5,u.getId());
	status=ps.executeUpdate();
}catch(Exception e){System.out.println(e);}
return status;
}

public static int delete(User u){
int status=0;
try{
	Connection con=getConnection();
	PreparedStatement ps=con.prepareStatement("delete from year where id=?");
	ps.setInt(1,u.getId());
	status=ps.executeUpdate();
}catch(Exception e){System.out.println(e);}

return status;
}


public static List<User> getAllRecords()
{
List<User> list=new ArrayList<User>();

try{
	Connection con=getConnection();
	PreparedStatement ps=con.prepareStatement("select * from year");
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
		User u=new User();
		u.setId(rs.getInt("id"));
		u.setFssc(rs.getString("fssc"));
		u.setLssc(rs.getString("lssc"));
		u.setFhsc(rs.getString("fhsc"));
		u.setLhsc(rs.getString("lhsc"));
				
	 
		
		list.add(u);
	}
}catch(Exception e){System.out.println(e);}
return list;
}

public static User getRecordById(int id){
User u=null;
try{
	Connection con=getConnection();
	PreparedStatement ps=con.prepareStatement("select * from year where id=?");
	ps.setInt(1,id);
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
		u=new User();
		u.setId(rs.getInt("id"));
		u.setFssc(rs.getString("fssc"));
		u.setLssc(rs.getString("lssc"));
		u.setFhsc(rs.getString("fhsc"));
		u.setLhsc(rs.getString("lhsc"));
	}
}catch(Exception e){System.out.println(e);}
return u;
}


}
