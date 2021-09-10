

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import apply.ConnectionClass;




@WebServlet("/controlmap")
public class controlmap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public controlmap() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String submit = request.getParameter("submit");
		System.out.println(submit);
		if(submit != null)
		{
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			String sql = "";
			
			
			
			if(submit.contentEquals("viewmap"))
			{				
				double lat=0,lng=0;
				
				
				System.out.println("view method in doget");
				try {
				
					con = ConnectionClass.createConnection();
					
					 sql= "SELECT * FROM mapdata";
					 pst = con.prepareStatement(sql);
					rs = pst.executeQuery();
					if(rs.next())
					{
						 lat= (rs.getDouble(2));
						 lng= (rs.getDouble(3));
						
						
						System.out.println(lat+" "+lng);
					}
					
					request.setAttribute("latt", lat);
					request.setAttribute("lngg", lng);
					request.getRequestDispatcher("Map_Example.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
		}
		
		
	}

	

}
