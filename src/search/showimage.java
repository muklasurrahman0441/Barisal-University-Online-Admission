package search;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import search.ConnectionClass;
import search.searchBean;

/**
 * Servlet implementation class showimage
 */
@WebServlet("/showimage")
public class showimage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	searchBean bean = new searchBean();
	searchModel model = new searchModel();
	
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		try {
			model.retriveImage(id, bean);
			byte[] image = bean.getImagedata();
			if(image.length ==0)
			{
				System.out.println("hhhh");
			}
			OutputStream os = response.getOutputStream();
			os.write(image);
			os.flush();
			os.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
