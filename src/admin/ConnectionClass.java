package admin;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
	public static Connection createConnection() {
		Connection con = null;
		String Driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/admission";
		String username = "root";
		String password = "";
		try 
		{
			try {
				Class.forName(Driver);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return con;
	}
}
