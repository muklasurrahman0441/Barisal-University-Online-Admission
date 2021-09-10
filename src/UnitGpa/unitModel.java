package UnitGpa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import UnitGpa.ConnectionClass;
import UnitGpa.unitModel;
import UnitGpa.unitBean;


public class unitModel {
	
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	String sql = "";
	
	
	public int ClearDatase() throws SQLException
	{
		int val = 0;
		
		con = ConnectionClass.createConnection();
		String sql= "DELETE FROM unit";
		pst = con.prepareStatement(sql);		
		
		val = pst.executeUpdate();
		
		con.close();
		pst.close();
		
		val=2;
		
		return val;
		
		
	}
	
	
	public int DeleteUnit( int idd) throws SQLException
	{
		int val = 0;
		
		con = ConnectionClass.createConnection();
		String sql= "DELETE FROM unit where id="+idd;
		pst = con.prepareStatement(sql);		
		
		val = pst.executeUpdate();
		
		con.close();
		pst.close();
		
		
		return val;
		
		
	}
	
	
	public int updatUnit( unitBean bean) throws SQLException
	{
		int val = 0;
		
		con = ConnectionClass.createConnection();
		
		String sql= "update unit set unit=?,sgpa=?,hgpa=? where id=?";
		pst = con.prepareStatement(sql);
		
		pst.setString(1, bean.getUnit());
		pst.setDouble(2, bean.getSgpa());	
		pst.setDouble(3, bean.getHgpa());	
		pst.setInt(4, bean.getId());
		
		val = pst.executeUpdate();
		
		
		System.out.println("val : " + val);
		
		return val;
		
		
	}
	
	
	public List<unitBean> retriveEditUnit(int idd) throws SQLException
	{
		List<unitBean> been = new ArrayList<>();
		con = ConnectionClass.createConnection();
		String sql= "SELECT * FROM unit where id="+idd;
		PreparedStatement pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next())
		{
			unitBean u= new unitBean();			
			
			int id = rs.getInt(1);			
			String unit = rs.getString(2);			
			double  sgpa= rs.getDouble(3);
			double  hgpa= rs.getDouble(4);
			
			
			
			u.setId(id);
			u.setUnit(unit);
			u.setSgpa(sgpa);
			u.setHgpa(hgpa);
			
    		unitBean newbean = new unitBean(id,unit,sgpa,hgpa);
			been.add(newbean);
		}
		return been;
	}
	
	
	public List<unitBean> retriveUnit() throws SQLException
	{
		List<unitBean> been = new ArrayList<>();
		con = ConnectionClass.createConnection();
		String sql= "SELECT * FROM unit";
		PreparedStatement pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next())
		{
			unitBean u= new unitBean();			
			
			int id = rs.getInt(1);			
			String unit = rs.getString(2);			
			double  sgpa= rs.getDouble(3);
			double  hgpa= rs.getDouble(4);
			
			
			
			u.setId(id);
			u.setUnit(unit);
			u.setSgpa(sgpa);
			u.setHgpa(hgpa);
			
    		unitBean newbean = new unitBean(id,unit,sgpa,hgpa);
			been.add(newbean);
		}
		return been;
	}
	
	
	public int setUnit( unitBean bean) throws SQLException
	{
		int val = 0;
		
		con = ConnectionClass.createConnection();
		
		String sql= "INSERT INTO unit(unit,sgpa,hgpa) VALUE (?,?,?)";
		pst = con.prepareStatement(sql);
		
		pst.setString(1, bean.getUnit());
		pst.setDouble(2, bean.getSgpa());
		pst.setDouble(3, bean.getHgpa());
		
		val = pst.executeUpdate();
		
		
		System.out.println("val : " + val);
		
		return val;
		
		
	}

}
