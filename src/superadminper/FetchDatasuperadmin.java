package superadminper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class FetchDatasuperadmin {

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
	    
	    public static ArrayList<superbean> getAllCountries() {
	    	connection = FetchDatasuperadmin.getConnection();
	        ArrayList<superbean> countryList = new ArrayList<superbean>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from superadmin");
	        
	            while(rs.next()) {	
	            	superbean u=new superbean();
	            	
	            	u.setId(rs.getInt("id"));
	        		u.setSuperuser(rs.getString("superuser"));
	        		u.setSuperpassword(rs.getString("superpassword"));
	        		
	            
	            	countryList.add(u);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return countryList;
	    }
	 
	
	
}
