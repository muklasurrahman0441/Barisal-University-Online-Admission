package ExamCenterMap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class FetchMapData {

	
	 private static Connection connection = null;

	    public static Connection getConnection() {
	        if (connection != null)
	            return connection;
	        else {
	            try {
	             ///   Properties prop = new Properties();
	             ///   InputStream inputStream = FetchDataPer.class.getClassLoader().getResourceAsStream("/db.properties");
	            ///    prop.load(inputStream);
	                String driver = "com.mysql.jdbc.Driver";
	                String url = "jdbc:mysql://localhost:3306/admission";
	                String user = "root";
	                String password = "";
	                Class.forName(driver);
	                connection = DriverManager.getConnection(url, user, password);
	                
	                System.out.println("driver : "+driver+"url : "+url+"user :  "+user+"password : "+password);
	            } catch (ClassNotFoundException e) {
	                e.printStackTrace();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            } 
	            return connection;
	        }

	    }
	    
	    public static ArrayList<MapBean> getAllMapData() {
	    	connection = FetchMapData.getConnection();
	        ArrayList<MapBean> mapdata = new ArrayList<MapBean>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from mapdata");
	        
	            while(rs.next()) {	
	            	MapBean u=new MapBean();
	            	
	            	u.setMap_id(rs.getInt("map_id"));
	            	u.setLat(rs.getDouble("lat"));
	            	u.setLng(rs.getDouble("lng"));
	            	u.setExamcenter(rs.getString("mapcenter"));
	            	
	            	
	            	
	            	
	        	
	        		
	            
	            	mapdata.add(u);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return mapdata;
	    }
	 
	
	
	
}
