package UnitGpa;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import UnitGpa.unitBean;
import UnitGpa.unitModel;


@WebServlet("/unitController")
public class unitController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	unitBean bean = new unitBean();
	unitModel model = new unitModel();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String submit = request.getParameter("submit");
		System.out.println(submit);
		if(submit != null)
		{
			
			if(submit.contentEquals("cleardatase"))
			{
				
				try {
					int sts = model.ClearDatase();
					if(sts > 0)
					{
						System.out.println(sts);
						System.out.println("submit successfully");
						request.setAttribute("success", "Unit and G.P.A. Database Cleared");
						request.getRequestDispatcher("/admin/UnitGpa/addunit.jsp").forward(request, response);
					}
					
			
					
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
				
			}
			
			
			if(submit.contentEquals("view"))
			{
				
				System.out.println("view method in unit");
				try {
				
			         List<unitBean> beandata = model.retriveUnit();
					request.setAttribute("product", beandata);
					request.getRequestDispatcher("/admin/UnitGpa/view.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			if(submit.contentEquals("delete"))
			{
				
				int id = Integer.parseInt(request.getParameter("id"));
				
				bean.setId(id);
				
				
				
				try {
					int sts = model.DeleteUnit(id);
					if(sts > 0)
					{
						System.out.println("submit successfully");
						request.setAttribute("success", "successfully deleted");
						request.getRequestDispatcher("/admin/UnitGpa/addunit.jsp").forward(request, response);
					}
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
				
			}
			
			if(submit.contentEquals("edit"))
			{
				int id = Integer.parseInt(request.getParameter("id"));
				System.out.println("Edit method in unit" + id);
				try {
				
			         List<unitBean> beandata = model.retriveEditUnit(id);
					request.setAttribute("product", beandata);
					request.getRequestDispatcher("/admin/UnitGpa/editUnit.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String submit = request.getParameter("submit");
		System.out.println(submit);
		
		if(submit != null)
		{
			if(submit.contentEquals("Set"))
			{
				String unit = request.getParameter("unit");
				double sgpa = Double.parseDouble(request.getParameter("sgpa"));
				double hgpa = Double.parseDouble(request.getParameter("hgpa"));
				
				
				bean.setUnit(unit);
				bean.setSgpa(sgpa);
				bean.setHgpa(hgpa);			
				
				try {
					int sts = model.setUnit(bean);
					if(sts > 0)
					{
						
							System.out.println("submit successfully");
							request.setAttribute("success", "insert  successfully");
						    request.getRequestDispatcher("/admin/UnitGpa/addunit.jsp").forward(request, response);
							
							
						
					}
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
				
				
				
			}
			
			
			
			if(submit.contentEquals("update"))
			{
				
				int id = Integer.parseInt(request.getParameter("id"));
				String unit = request.getParameter("unit");
				double sgpa = Double.parseDouble(request.getParameter("sgpa"));
				double hgpa = Double.parseDouble(request.getParameter("hgpa"));
				
				bean.setId(id);
				bean.setUnit(unit);
				bean.setSgpa(sgpa);
				bean.setHgpa(hgpa);			
				
				
				try {
					int sts = model.updatUnit(bean);
					if(sts > 0)
					{
						System.out.println("submit successfully");
						request.setAttribute("success", "successfully updated");
						request.getRequestDispatcher("/admin/UnitGpa/addunit.jsp").forward(request, response);
					}
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
				
			}
			
			

			
			
		}
		
		
		
	}

}
