package year;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class FetchYear {

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
	    
	    public static ArrayList<User> getAllCountries() {
	    	connection = FetchYear.getConnection();
	        ArrayList<User> countryList = new ArrayList<User>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from year");
	        
	            while(rs.next()) {	
	            	User u=new User();
	            	
	            	u.setId(rs.getInt("id"));
	            	
	            	u.setFssc(rs.getString("fssc"));
	            	u.setLssc(rs.getString("lssc"));
	            	u.setFhsc(rs.getString("fhsc"));
	            	u.setLhsc(rs.getString("lhsc"));
	            
	            	countryList.add(u);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return countryList;
	    }
	 
	
	
}
