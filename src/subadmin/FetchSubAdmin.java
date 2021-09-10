package subadmin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class FetchSubAdmin {

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
	    
	    public static ArrayList<subBean> getAllCountries() {
	    	connection = FetchSubAdmin.getConnection();
	        ArrayList<subBean> countryList = new ArrayList<subBean>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from subadmin");
	        
	            while(rs.next()) {	
	            	subBean u=new subBean();
	            	
	            	u.setId(rs.getInt("id"));
	        		u.setSubuser(rs.getString("subuser"));
	        		u.setSubpassword(rs.getString("subpassword"));
	        		u.setSeatgo(rs.getString("seatgo"));
	        		u.setYeargo(rs.getString("yeargo"));
	        		u.setGpago(rs.getString("gpago"));
	        		u.setUnitgo(rs.getString("unitgo"));
	        		
	            
	            	countryList.add(u);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return countryList;
	    }
	 
	
	
	
}
