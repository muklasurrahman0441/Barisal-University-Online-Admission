package stuper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;


public class FetchDataPer {
	
	 
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
	    	connection = FetchDataPer.getConnection();
	        ArrayList<subBean> countryList = new ArrayList<subBean>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from studentdashboard");
	        
	            while(rs.next()) {	
	            	subBean u=new subBean();
	            	
	            	u.setId(rs.getInt("id"));
	        		u.setApply(rs.getString("apply"));
	        		u.setLoginper(rs.getInt("loginper"));
	        		u.setPayment(rs.getString("payment"));
	        		u.setSeatplan(rs.getString("seatplan"));
	        		u.setAdmitcard(rs.getString("admitcard"));
	        		u.setResult(rs.getString("result"));
	            	
	            
	            	countryList.add(u);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return countryList;
	    }
	 
	 
}
