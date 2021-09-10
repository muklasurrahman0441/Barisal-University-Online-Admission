package admin;

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





@WebServlet("/adminController")
public class adminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	adminBean bean= new adminBean();
	adminModel model = new adminModel();
	
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String submit = request.getParameter("submit");
		System.out.println(submit);
		if(submit != null)
		{
			
			if(submit.contentEquals("viewmapadmin"))
			{				
				double lat=0,lng=0;
				String centername="";
				Connection con = null;
				PreparedStatement pst = null;
				ResultSet rs = null;
				String sql = "";
				
				
				String mapcenter = request.getParameter("center");
				
				System.out.println("view method in map \n and center :"+mapcenter);
				try {
				
					con = ConnectionClass.createConnection();
					
					 sql= "SELECT * FROM mapdata where mapcenter="+"'"+ mapcenter+"'";
					 pst = con.prepareStatement(sql);
					rs = pst.executeQuery();
					if(rs.next())
					{
						 lat= (rs.getDouble(2));
						 lng= (rs.getDouble(3));
						 centername = rs.getString(4);
						
						System.out.println(lat+" "+lng+" "+centername);
					}
					
					request.setAttribute("latt", lat);
					request.setAttribute("lngg", lng);
					request.setAttribute("centernamee", centername);
					request.getRequestDispatcher("/admin/AdminLogin/Find_Center_Map.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
			
			if(submit.contentEquals("Super_Admin_Login"))
			{
				String superuser = request.getParameter("superuser");	
				String superpassword = request.getParameter("superpassword");	
				
				System.out.println("superuser , superpassword "+superuser+superpassword);
				
				bean.setSuperuser(superuser);
				bean.setSuperpassword(superpassword);
						
				try {					
					
					int sts = model.Super_Admin_Login(bean);
					if(sts==100)
					{						
							System.out.println(" Login Successful  ");
							request.setAttribute("success", "Welcome Super Admin Home Page");
						    request.getRequestDispatcher("/admin/AdminLogin/indexsuper.jsp").forward(request, response);							
						
					}
					
					if(sts==99)
					{
						System.out.println(" Passward does not matched in controller  ");
						request.setAttribute("success", "Invalid User name or Passward");
						  request.getRequestDispatcher("/admin/AdminLogin/IndexHomeSuperAdmin.jsp").forward(request, response);							

					}
					
				} catch (Exception ex) {
				
					ex.printStackTrace();
				}
			
		}
			
			
			
			if(submit.contentEquals("delete_super"))
			{
				
				int id = Integer.parseInt(request.getParameter("id"));
				
				bean.setId(id);
				
				
				
				try {
					int sts = model.delete_super(id);
					if(sts > 0)
					{
						System.out.println("delete successfully");
						request.setAttribute("success", "successfully deleted");
						 request.getRequestDispatcher("/admin/AdminLogin/AdminRegistration.jsp").forward(request, response);	
					}
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
				
			}
			
			
			
		
			if(submit.contentEquals("view_super_admin"))
			{
				
				System.out.println("view_super_admin");
				try {
				
			         List<adminBean> beandata = model.view_super_admin();
					request.setAttribute("product", beandata);
					request.getRequestDispatcher("/admin/AdminLogin/superadminview.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			if(submit.contentEquals("edit_super"))
			{
				
				int id = Integer.parseInt(request.getParameter("id"));
				System.out.println("Edit method in super admin " + id);
				try {
				
			         List<adminBean> beandata = model.edit_super(id);
					request.setAttribute("product", beandata);
					request.getRequestDispatcher("/admin/AdminLogin/superadminedit.jsp").forward(request, response);
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
			
			if(submit.contentEquals("update_super"))
			{
				
				int id = Integer.parseInt(request.getParameter("id"));
				String superuser = request.getParameter("superuser");	
				String superpassword = request.getParameter("superpassword");	
				
				System.out.println("in update superuser , superpassword "+superuser+superpassword);
				
				bean.setId(id);
				bean.setSuperuser(superuser);
				bean.setSuperpassword(superpassword);		
				
				
				try {
					int sts = model.update_super(bean);
					if(sts > 0)
					{
						System.out.println("update  successfully");
						request.setAttribute("success", "successfully updated");
					    request.getRequestDispatcher("/admin/AdminLogin/AdminRegistration.jsp").forward(request, response);							
					}
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
				
			}
			
			
			
			
			if(submit.contentEquals("Select"))
			{
				String adminselect = request.getParameter("adminselect");				
				bean.setAdminselect(adminselect);			
				try {					
					if(bean.getAdminselect().equals("SuperAdmin"))
					{						
							System.out.println(" in super admin redirecting  ");
							request.setAttribute("success", "Welcome Super Admin");
						    request.getRequestDispatcher("/admin/AdminLogin/IndexHomeSuperAdmin.jsp").forward(request, response);							
						
					}	
					
					if(bean.getAdminselect().equals("SubAdmin"))
					{						
							System.out.println(" in sub admin redirecting  ");
							request.setAttribute("success", "Welcome Sub Admin");
						    request.getRequestDispatcher("/admin/AdminLogin/IndexHomeSubAdmin.jsp").forward(request, response);							
						
					}	
				} catch (Exception ex) {
				
					ex.printStackTrace();
				}
				
			}
				
				if(submit.contentEquals("Super_Admin_Registration"))
				{
					String superuser = request.getParameter("superuser");	
					String superpassword = request.getParameter("superpassword");	
					
					System.out.println("superuser , superpassword "+superuser+superpassword);
					
					bean.setSuperuser(superuser);
					bean.setSuperpassword(superpassword);
							
					try {					
						
						int sts = model.Super_Admin_Registration(bean);
						if(sts>0)
						{						
								System.out.println(" in super admin redirecting  ");
								request.setAttribute("success", " New Super Admin Inserted ");
							    request.getRequestDispatcher("/admin/AdminLogin/AdminRegistration.jsp").forward(request, response);							
							
						}	
						
					} catch (Exception ex) {
					
						ex.printStackTrace();
					}
				
			}
				
				
				
				if(submit.contentEquals("Super_Admin_Login"))
				{
					String superuser = request.getParameter("superuser");	
					String superpassword = request.getParameter("superpassword");	
					
					System.out.println("superuser , superpassword "+superuser+superpassword);
					
					bean.setSuperuser(superuser);
					bean.setSuperpassword(superpassword);
							
					try {					
						
						int sts = model.Super_Admin_Login(bean);
						if(sts==100)
						{						
								System.out.println(" Login Successful  ");
								request.setAttribute("success", "Welcome Super Admin Home Page");
							    request.getRequestDispatcher("/admin/AdminLogin/indexsuper.jsp").forward(request, response);							
							
						}
						
						if(sts==99)
						{
							System.out.println(" Passward does not matched in controller  ");
							request.setAttribute("success", "Invalid User name or Passward");
							  request.getRequestDispatcher("/admin/AdminLogin/IndexHomeSuperAdmin.jsp").forward(request, response);							

						}
						
					} catch (Exception ex) {
					
						ex.printStackTrace();
					}
				
			}
			
			
		
		
		
		
	}
	}
}
