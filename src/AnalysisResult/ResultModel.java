package AnalysisResult;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




public class ResultModel {

	
	
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	String sql = "";
	
	
	
	 public static ArrayList<ResyltBean> getAllSearchGender(String gender) {
			
		 int count = 0;
		 
		
	        ArrayList<ResyltBean> countryList = new ArrayList<ResyltBean>();
	        try {
	        	Connection con = ConnectionClass.createConnection();
	        	Statement pst=  con.createStatement();	            
	             String sql= "SELECT * FROM result where gender="+"'"+gender+"'";	            
	             ResultSet rs = pst.executeQuery(sql);
	        
	            while(rs.next()) {	
	            	ResyltBean u=new ResyltBean();
	            	
	            	count =count+1;
	            	
	            	u.setId(rs.getInt("id"));
	            	u.setBoard(rs.getString("board"));
	            	u.setCount(count);
	            	u.setName(rs.getString("name"));
	            	u.setFather(rs.getString("father"));
	            	u.setMother(rs.getString("mother"));
	            	u.setMcq(rs.getDouble("mcq"));
	            	u.setG_total(rs.getDouble("g_total"));
	            	u.setMerit(rs.getDouble("merit"));
	        		u.setGender(rs.getString("gender"));
	            	
	            
	            	countryList.add(u);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return countryList;
	    }
	
	
	
	 public static ArrayList<ResyltBean> getAllSearchDivision(String division) {
		
		 int count = 0;
		 
		
	        ArrayList<ResyltBean> countryList = new ArrayList<ResyltBean>();
	        try {
	        	Connection con = ConnectionClass.createConnection();
	        	Statement pst=  con.createStatement();	            
	             String sql= "SELECT * FROM result where board="+"'"+division+"'";	            
	             ResultSet rs = pst.executeQuery(sql);
	        
	            while(rs.next()) {	
	            	ResyltBean u=new ResyltBean();
	            	
	            	count =count+1;
	            	
	            	u.setId(rs.getInt("id"));
	            	u.setBoard(rs.getString("board"));
	            	u.setCount(count);
	            	u.setName(rs.getString("name"));
	            	u.setFather(rs.getString("father"));
	            	u.setMother(rs.getString("mother"));
	            	u.setMcq(rs.getDouble("mcq"));
	            	u.setG_total(rs.getDouble("g_total"));
	            	u.setMerit(rs.getDouble("merit"));
	        		
	            	
	            
	            	countryList.add(u);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return countryList;
	    }
	
	
	
	public List<ResyltBean> searchByDivision(String division)throws SQLException
	{
		
		int count = 0;
		
		List<ResyltBean> been = new ArrayList<>();
		con = ConnectionClass.createConnection();
		String sql= "SELECT * FROM result where board="+"'"+division+"'";
		PreparedStatement pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next())
		{
			int id = rs.getInt(1);			
			String div = rs.getString(2);	
		     count=count+1;
			ResyltBean newbean = new ResyltBean(id,div,count);
			been.add(newbean);
			
			
		}
		return been;
	}
}
