package seatplan;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class Create_CSV
 */
@WebServlet("/Create_CSV")
public class Create_CSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	modelClass model = new modelClass();
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			int sts = model.Create_csv();
			if(sts > 0)
			{
				System.out.println("Inserted CSV");
				request.setAttribute("success", " CSV file Exported ");
				 request.getRequestDispatcher("/admin/seatplan/SeatPlanReg.jsp").forward(request, response);	
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		/*
		try {
		//	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			DateFormat dateFormat = new SimpleDateFormat("HH_mm_ss");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			String ss = String.valueOf(dateFormat.format(date));
		
		PrintWriter pw = new PrintWriter(new File("E:\\jspservlet\\pdf\\"+"table"+ss+"haha"+".csv"));
		StringBuilder sb = new StringBuilder();
		
		ConnectionClass obj = new ConnectionClass();
        Connection con = (Connection) obj.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "select * from examcenter";       
		ps=(PreparedStatement) con.prepareStatement(query);		
        rs=ps.executeQuery();
		
        while(rs.next())
        {
        
				sb.append(rs.getInt("serial"));
			
    		sb.append(",");
    		sb.append(rs.getString("center"));
    		sb.append(",");
    		sb.append(rs.getString("address"));
    		sb.append(",");
    		sb.append(rs.getString("room"));
    		sb.append(",");
    		sb.append(rs.getInt("capacity"));
    		sb.append(",");
    		sb.append(rs.getString("frange"));
    		sb.append(",");
    		sb.append(rs.getString("lrange"));
    		sb.append("\r\n");
        }
        
        	
      
		
		pw.write(sb.toString());
		pw.close();
		System.out.println("csv file ready");
		  } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		*/
		
	}

}
