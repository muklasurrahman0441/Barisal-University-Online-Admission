package search;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import search.searchBean;
import search.searchBean;


@WebServlet("/searchControl")
public class searchControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	searchBean bean = new searchBean();
	searchModel model = new searchModel();
	

    public searchControl() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String submit = request.getParameter("submit");
		System.out.println(submit);
		
		if(submit != null)
		{
			
			
			
			
			if(submit.contentEquals("unitview"))
			{
				System.out.println("view method in doget");
				try {
					List<searchBean> beandata = model.retriveProduct();
					request.setAttribute("product", beandata);
					request.getRequestDispatcher("/admin/superadmin/unitview.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			if(submit.contentEquals("Create_CSV_File_Date"))
			{
				String date = request.getParameter("date");			        
				System.out.println("date  in CSV "+date);	
				
				try {
					int sts = model.Create_CSV_File_Date(date);
					
					if(sts>0)
					{
						request.setAttribute("success", "CSV file Created");
						request.getRequestDispatcher("/searchControl?submit=unitview").forward(request, response);	
						
					}
						
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
			}
			
			
			if(submit.contentEquals("Create_CSV_File"))
			{
		       
				
				try {
					int sts = model.Create_CSV_File();
					
					if(sts>0)
					{
						request.setAttribute("success", "CSV file Created");
						request.getRequestDispatcher("/searchControl?submit=unitview").forward(request, response);	
						
					}
						
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
			}
		}
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String submit = request.getParameter("submit");
		System.out.println(submit);
		
		if(submit != null)
		{
			
			
			
			
			
			if(submit.contentEquals("searchByHscRoll"))
			{
				
		        
		        String hscroll = request.getParameter("hscroll");	
		        
				System.out.println("Hscroll "+hscroll);
				
				bean.setHscroll(hscroll);
				
				
				
				try {
					List<searchBean> beandata = model.searchModel(hscroll);
						request.setAttribute("product", beandata);
						request.getRequestDispatcher("/admin/superadmin/searchView.jsp").forward(request, response);
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
			}
			
			
			
			if(submit.contentEquals("searchByDate"))
			{
		        String date = request.getParameter("date");			        
				System.out.println("date "+date);				
				bean.setDate(date);	
				
				try {
					List<searchBean> beandata = model.searchModelDate(date);
						request.setAttribute("product", beandata);
						request.getRequestDispatcher("/admin/superadmin/searchView.jsp").forward(request, response);
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
			}
			
			
			if(submit.contentEquals("search_Exam_Roll"))
			{
		        String roll = request.getParameter("roll");			        
				System.out.println("Exam roll :  "+roll);				
				bean.setDate(roll);	
				
				try {
					List<searchBean> beandata = model.searchModelExamRoll(roll);
						request.setAttribute("product", beandata);
						request.getRequestDispatcher("/admin/superadmin/searchView.jsp").forward(request, response);
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
			}
		
			
			
			
		
			
			
			
		}
		
	}

}
