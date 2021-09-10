package ExamCenterMap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;









public class MapModel {
	
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	String sql = "";
	
	
	public int updateMapInfo( MapBean bean) throws SQLException
	{
		int val = 0;
		
		con = ConnectionClass.createConnection();
		
		String sql= "update mapdata set lat=?,lng=?,mapcenter=? where map_id=?";
		pst = con.prepareStatement(sql);
		
		
		pst.setDouble(1, bean.getLat());
		pst.setDouble(2, bean.getLng());
		pst.setString(3, bean.getExamcenter());
		pst.setInt(4, bean.getMap_id());
		
		
		val = pst.executeUpdate();
		
		
		System.out.println("val : " + val);
		
		return val;
		
		
	}
	
	
	
	
	public List<MapBean> retriveEditMap(int idd) throws SQLException
	{
		List<MapBean> been = new ArrayList<>();
		con = ConnectionClass.createConnection();
		String sql= "SELECT * FROM mapdata where map_id="+idd;
		PreparedStatement pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next())
		{
			MapBean u= new MapBean();			
			
			int id = rs.getInt(1);						
			double  lat= rs.getDouble(2);
			double  lng= rs.getDouble(3);
			String mapcenter = rs.getString(4);	
			
			
			u.setMap_id(id);
			u.setLat(lat);
			u.setLng(lng);
			u.setExamcenter(mapcenter);
			
			
			
			
			MapBean newbean = new MapBean(id,lat,lng,mapcenter);
			been.add(newbean);
		}
		return been;
	}
	
	
	
	
	
	
	
	
	public int delete_Map_Data( int idd) throws SQLException
	{
		int val = 0;
		
		con = ConnectionClass.createConnection();
		String sql= "DELETE FROM mapdata where map_id="+idd;
		pst = con.prepareStatement(sql);		
		
		val = pst.executeUpdate();
		
		con.close();
		pst.close();
		
		val=20;
		return val;
		
		
	}
	
	
	
	
	
	public int InsertMapData(MapBean bean) throws SQLException
	{
		int val=0;
		
		con = ConnectionClass.createConnection();
		String sql= "INSERT INTO mapdata(lat,lng,mapcenter) VALUE (?,?,?)";
		pst = con.prepareStatement(sql);
	
		pst.setDouble(1, bean.getLat());
		pst.setDouble(2, bean.getLng());
		pst.setString(3, bean.getExamcenter());
		
		
		val = pst.executeUpdate();
		
		
		
		return val;
	}

}
