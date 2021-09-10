package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;











public class adminModel {
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	String sql = "";
	
	
	
	public int delete_super( int idd) throws SQLException
	{
		int val = 0;
		
		con = ConnectionClass.createConnection();
		String sql= "DELETE FROM superadmin where id="+idd;
		pst = con.prepareStatement(sql);		
		
		val = pst.executeUpdate();
		
		con.close();
		pst.close();
		
		
		return val;
		
		
	}
	
	
	public int update_super( adminBean bean) throws SQLException
	{
		int val = 0;
		
		con = ConnectionClass.createConnection();
		
		String sql= "update superadmin set superuser=?,superpassword=? where id=?";
		pst = con.prepareStatement(sql);
		
		pst.setString(1, bean.getSuperuser());
		pst.setString(2, bean.getSuperpassword());		
		pst.setInt(3, bean.getId());
		
		val = pst.executeUpdate();
		
		
		System.out.println("val : " + val);
		
		return val;
		
		
	}
	
	
	
	public List<adminBean> edit_super(int idd) throws SQLException
	{
		List<adminBean> been = new ArrayList<>();
		con = ConnectionClass.createConnection();
		String sql= "SELECT * FROM superadmin where id="+idd;
		PreparedStatement pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next())
		{
			adminBean u= new adminBean();			
			
			int id = rs.getInt(1);			
			String superuser = rs.getString(2);			
			String superpassword = rs.getString(3);
			
			
			
			u.setId(id);
			u.setSuperuser(superuser);
			u.setSuperpassword(superpassword);
			
			adminBean newbean = new adminBean(id,superuser,superpassword);
			been.add(newbean);
		}
		return been;
	}
	
	
	
	public List<adminBean> view_super_admin() throws SQLException
	{
		List<adminBean> been = new ArrayList<>();
		con = ConnectionClass.createConnection();
		String sql= "SELECT * FROM superadmin";
		PreparedStatement pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next())
		{
			adminBean u= new adminBean();			
			
			int id = rs.getInt(1);			
			String superuser = rs.getString(2);			
			String superpassword = rs.getString(3);	
			
			
			u.setId(id);
			u.setSuperuser(superuser);
			u.setSuperpassword(superpassword);
			
			
			adminBean newbean = new adminBean(id,superuser,superpassword);
			been.add(newbean);
		}
		return been;
	}
	
	
	public int Super_Admin_Registration( adminBean bean) throws SQLException
	{
		int val = 0;		
		con = ConnectionClass.createConnection();		
		String sql= "INSERT INTO superadmin(superuser,superpassword) VALUE (?,?)";
		pst = con.prepareStatement(sql);
		
		pst.setString(1, bean.getSuperuser());
		pst.setString(2, bean.getSuperpassword());		
		
		val = pst.executeUpdate();		
		System.out.println("val in super admin registration: " + val);		
		return val;		
		
	}
	
	
	
	
	public int Super_Admin_Login( adminBean bean) throws SQLException
	{
		int val = 0;		
		con = ConnectionClass.createConnection();		
		
		String superuser=bean.getSuperuser();
		String superpassword = bean.getSuperpassword();
		
		
		String sql= " SELECT * FROM  superadmin";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next())
		{
			String user = rs.getString(2);
			String pass = rs.getString(3);
			
			if( (superuser.equals(user)) && (superpassword.equals(pass)))
			{
				System.out.println("passward matched");
				val = 100;
				break;
			}
			else
			{
				val = 99;
			}
			
			
			
		}
		
		return val;		
		
	}
	
	
	
	

}
