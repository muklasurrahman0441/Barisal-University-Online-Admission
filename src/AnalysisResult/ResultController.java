package AnalysisResult;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/ResultController")
public class ResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ResultModel model = new ResultModel();
	ResyltBean been = new ResyltBean();
   
    public ResultController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String submit = request.getParameter("submit");
		System.out.println(submit);
		if(submit != null)
		{
			 String division = request.getParameter("division");			 
			 System.out.println("division "+division);				
		     been.setBoard(division);
				
				
				
				try {
					List<ResyltBean> beandata = model.searchByDivision(division);
						request.setAttribute("product", beandata);
						request.getRequestDispatcher("/admin/Result/ResultHome.jsp").forward(request, response);
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
		}
		
		
	}

}
