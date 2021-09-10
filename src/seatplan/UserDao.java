package seatplan;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seatplan.User;
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
			PreparedStatement ps=con.prepareStatement("delete from examcenter");
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}

		return status;
		}

public static int save(User u){
int status=0;
try{
	Connection con=getConnection();
	PreparedStatement ps=con.prepareStatement("insert into examcenter(serial,center,address,room,capacity,frange,lrange) values(?,?,?,?,?,?,?)");
	ps.setInt(1,u.getSerial());
	ps.setString(2,u.getCenter());
	ps.setString(3,u.getAddress());
	ps.setString(4,u.getRoom());
	ps.setInt(5,u.getCapacity());
	
	ps.setString(6,u.getFrange());
	ps.setString(7,u.getLrange());
	status=ps.executeUpdate();
}catch(Exception e){System.out.println(e);}
return status;
}


public static int update(User u){
int status=0;
try{
	Connection con=getConnection();
	PreparedStatement ps=con.prepareStatement("update examcenter set serial=?,center=?,address=?,room=?,capacity=?,frange=?,lrange=? where id=?");
	ps.setInt(1,u.getSerial());
	ps.setString(2,u.getCenter());
	ps.setString(3,u.getAddress());
	ps.setString(4,u.getRoom());
	ps.setInt(5,u.getCapacity());
	ps.setString(6,u.getFrange());
	ps.setString(7,u.getLrange());
	ps.setInt(8,u.getId());
	status=ps.executeUpdate();
}catch(Exception e){System.out.println(e);}
return status;
}

public static int delete(User u){
int status=0;
try{
	Connection con=getConnection();
	PreparedStatement ps=con.prepareStatement("delete from examcenter where id=?");
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
	PreparedStatement ps=con.prepareStatement("select * from examcenter");
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
		User u=new User();
		u.setId(rs.getInt("id"));
		u.setSerial(rs.getInt("serial"));   
		u.setCenter(rs.getString("center"));
		u.setAddress(rs.getString("address"));
		u.setRoom(rs.getString("room"));
		u.setCapacity(rs.getInt("capacity"));   			
	    u.setFrange(rs.getString("frange"));
	    u.setLrange(rs.getString("lrange"));
		
		list.add(u);
	}
}catch(Exception e){System.out.println(e);}
return list;
}

public static User getRecordById(int id){
User u=null;
try{
	Connection con=getConnection();
	PreparedStatement ps=con.prepareStatement("select * from examcenter where id=?");
	ps.setInt(1,id);
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
		u=new User();
		u.setId(rs.getInt("id"));
		u.setSerial(rs.getInt("serial"));   
		u.setCenter(rs.getString("center"));
		u.setAddress(rs.getString("address"));
		u.setRoom(rs.getString("room"));
		u.setCapacity(rs.getInt("capacity"));   
	
		u.setFrange(rs.getString("frange"));
	
		u.setLrange(rs.getString("lrange"));
	}
}catch(Exception e){System.out.println(e);}
return u;
}
}
