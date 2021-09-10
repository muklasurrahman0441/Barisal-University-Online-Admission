package MeritList;

import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.jdbc.PreparedStatement;





public class MeritFetch {

	
	 
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
	
	 public static ArrayList<MeritBean> getScienceData() {
	    	connection = MeritFetch.getConnection();
	        ArrayList<MeritBean> countryList = new ArrayList<MeritBean>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("SELECT * FROM `result` ORDER BY merit ASC LIMIT 3");
	        
	            while(rs.next()) {	
	            	MeritBean u=new MeritBean();
	            	
	            
	        		u.setRoll(rs.getInt("roll"));
	        		u.setSerial(rs.getInt("serial"));
	        		u.setBoard(rs.getString("board"));
	            	u.setSsc_letter(rs.getString("ssc_letter"));
	            	u.setHsc_letter(rs.getString("hsc_letter"));
	            	u.setName(rs.getString("name"));
	            	u.setFather(rs.getString("father"));
	            	u.setMother(rs.getString("mother"));
	            	u.setPer_tot(rs.getDouble("per_tot"));
	            	u.setBan(rs.getDouble("ban"));
	            	u.setEng(rs.getDouble("eng"));
	            	u.setPhy(rs.getDouble("phy"));
	            	u.setPhy(rs.getDouble("che"));
	            	u.setMat(rs.getDouble("mat"));
	            	u.setBio(rs.getDouble("bio"));
	            	u.setIct(rs.getDouble("ict"));
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
	
	 
	 
	 
		public int Create_csv() throws SQLException
		{
			int val = 0;
			
			try {
				//	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				DateFormat dateFormat = new SimpleDateFormat("HH_mm_ss");
				Date date = new Date();
				System.out.println(dateFormat.format(date));
				String ss = String.valueOf(dateFormat.format(date));
			
			PrintWriter pw = new PrintWriter(new File("C:\\Users\\pc\\Downloads\\"+"Merit"+ss+"List"+".csv"));
			StringBuilder sb = new StringBuilder();
			
			
			    sb.append("SSC Roll");				
	    		sb.append(",");
	    		 sb.append("HSC Roll");				
	    		sb.append(",");
	    		
	    		 sb.append("Board");	
	    		sb.append(",");
	    		 sb.append("SSS Letter");	
	    		sb.append(",");
	    		 sb.append("HSC Letter");	
	    		sb.append(",");
	    		 sb.append("Name");	
	    		sb.append(",");
	    		 sb.append("Father Name");	
	    		sb.append(",");
	    		 sb.append("Mother Name");	
	    		sb.append(",");
	    		
	    		 sb.append("Result point");	
	    		sb.append(",");
	    		 sb.append("Bangla");	
	    		sb.append(",");
	    		 sb.append("English");	
	    		sb.append(",");
	    		 sb.append("Physics");	
	    		sb.append(",");
	    		
	    		 sb.append("Chemistry");	
	    		sb.append(",");
	    		 sb.append("Mathematics");	
	    		sb.append(",");
	    		 sb.append("Biology");	
	    		sb.append(",");
	    		 sb.append("ICT");	
	    		sb.append(",");
	    		 sb.append("Total MCQ");	
	    		sb.append(",");
	    		 sb.append("Total Marks");	
	    		sb.append(",");
	    		 sb.append("Merit");	    		
	    		sb.append("\r\n");
			
			ConnectionClass obj = new ConnectionClass();
	        Connection con = (Connection) obj.createConnection();
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        
	        String query = "SELECT * FROM `result` ORDER BY merit ASC LIMIT 3";       
			ps=(PreparedStatement) con.prepareStatement(query);		
	        rs=ps.executeQuery();
			
	        while(rs.next())
	        {
	        
			    sb.append(rs.getInt("roll"));				
	    		sb.append(",");
	    		sb.append(rs.getInt("serial"));				
	    		sb.append(",");
	    		
	    		sb.append(rs.getString("board"));
	    		sb.append(",");
	    		sb.append(rs.getString("ssc_letter"));
	    		sb.append(",");
	    		sb.append(rs.getString("hsc_letter"));
	    		sb.append(",");
	    		sb.append(rs.getString("name"));
	    		sb.append(",");
	    		sb.append(rs.getString("father"));
	    		sb.append(",");
	    		sb.append(rs.getString("mother"));
	    		sb.append(",");
	    		
	    		sb.append(rs.getDouble("per_tot"));
	    		sb.append(",");
	    		sb.append(rs.getDouble("ban"));
	    		sb.append(",");
	    		sb.append(rs.getDouble("eng"));
	    		sb.append(",");
	    		sb.append(rs.getDouble("phy"));
	    		sb.append(",");
	    		
	    		sb.append(rs.getDouble("che"));
	    		sb.append(",");
	    		sb.append(rs.getDouble("mat"));
	    		sb.append(",");
	    		sb.append(rs.getDouble("bio"));
	    		sb.append(",");
	    		sb.append(rs.getDouble("ict"));
	    		sb.append(",");
	    		sb.append(rs.getDouble("mcq"));
	    		sb.append(",");
	    		sb.append(rs.getDouble("g_total"));
	    		sb.append(",");
	    		sb.append(rs.getDouble("merit"));	    		
	    		sb.append("\r\n");
	        }
	        
	        	
	      
			
			pw.write(sb.toString());
			pw.close();
			System.out.println("Merit List csv file ready");
			  
			val = 10;
				
				
			}  
			catch (Exception en) {
				
				en.printStackTrace();
			}
			
			
			
			return val;
			
			
		}
	
}
