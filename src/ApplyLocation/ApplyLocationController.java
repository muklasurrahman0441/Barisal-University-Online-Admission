package ApplyLocation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





@WebServlet("/ApplyLocationController")
public class ApplyLocationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ApplyLocationModel model = new ApplyLocationModel();
 
    public ApplyLocationController() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String submit = request.getParameter("submit");
		System.out.println(submit);
		if(submit != null)
		{
			
			
			if(submit.contentEquals("viewProfile"))
			{
				
				String hscroll = request.getParameter("hscroll");
				System.out.println("Hscroll  in do get "+hscroll);
				System.out.println("view method in doget");
				try {
					List<ApplyLocationBean> beandata = model.viewProfileStudent(hscroll);
				//	List<beanClass> beandata = model.retriveProduct();
					request.setAttribute("product", beandata);
					request.getRequestDispatcher("/admin/AdminLogin/StudentProfileFromLocation.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			if(submit.contentEquals("applylocationview"))
			{
				
				System.out.println("apply location view");
				try {
				
			         List<ApplyLocationBean> beandata = model.ApplyLocationView();
					request.setAttribute("product", beandata);
					request.getRequestDispatcher("/admin/AdminLogin/ApplyUserView.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
