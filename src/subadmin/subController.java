package subadmin;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;










@WebServlet("/subController")
public class subController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	subBean bean = new subBean();
	subModel model = new subModel();
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String submit = request.getParameter("submit");
		System.out.println(submit);
		if(submit != null)
		{
			
			
			if(submit.contentEquals("logut_sub"))
			{
				HttpSession session=request.getSession();  
	            session.invalidate();  
	            System.out.println("logut");
	            request.setAttribute("success", "Logut Successfully");
				  request.getRequestDispatcher("/admin/AdminLogin/IndexHomeSubAdmin.jsp").forward(request, response);							

			}
			
			
			if(submit.contentEquals("Sub_Admin_Login"))
			{
				String subuser = request.getParameter("subuser");	
				String subpassword = request.getParameter("subpassword");	
				
				 HttpSession session=request.getSession();  
			  
				 session.setAttribute("subuserr",subuser);  
			     session.setAttribute("subpasswordd",subpassword);  
				
				System.out.println("subuser , subpassword "+subuser+subpassword);
				
				bean.setSubuser(subuser);
				bean.setSubpassword(subpassword);
						
				try {	
					int	val=0;
					int counter =0;
					Connection con = null;
					PreparedStatement pst = null;
					ResultSet rs = null;
					String sql = "";
				    	
				        String subuserr=(String)session.getAttribute("subuserr"); 
				        String subpasswordd=(String)session.getAttribute("subpasswordd"); 
				        System.out.println("indide session : " +subuserr+" >>  "+subpasswordd);
				        
						con = (Connection) ConnectionClass.createConnection();	
						
						sql= " SELECT * FROM  subadmin";
						pst = (PreparedStatement) con.prepareStatement(sql);
						rs = pst.executeQuery();
						while(rs.next())
						{
							String user = rs.getString(2);
							String pass = rs.getString(3);
							
							if( (subuserr.equals(user)) && (subpasswordd.equals(pass)))
							{
								counter =15;
							    val = rs.getInt(1);
								System.out.println("passward matched");								
								break;
							}				
							
							
							
						}


				      ///  out.print("Hello, "+name+" Welcome to Profile");  
				        if(counter==15)
				        {

				        	
				        	String value =Integer.toString(val);
				        	
							 session.setAttribute("idd",value);  

				        	
							System.out.println(" Login Successful  ");
							request.setAttribute("status", " Login Successful ");
							request.setAttribute("success", val);
					        request.getRequestDispatcher("/admin/AdminLogin/subadminhome.jsp").forward(request, response);							
						
				        }
				        else
				        {
				        
				        	System.out.println(" Passward does not matched in controller  ");
							request.setAttribute("success", "Invalid User name or Passward");
							request.getRequestDispatcher("/admin/AdminLogin/IndexHomeSubAdmin.jsp").forward(request, response);							
				        	
				        }  
					
					
					
					/*
					int sts = model.Sub_Admin_Login(bean);
				
					if(sts==999999)
					{
						System.out.println(" Passward does not matched in controller  ");
						request.setAttribute("success", "Invalid User name or Passward");
						  request.getRequestDispatcher("/admin/AdminLogin/IndexHomeSubAdmin.jsp").forward(request, response);							

					}
					else
					{						
						System.out.println(" Login Successful  ");
						request.setAttribute("status", " Login Successful ");
						request.setAttribute("success", sts);
				        request.getRequestDispatcher("/admin/AdminLogin/subadminhome.jsp").forward(request, response);							
					
			    	}
			    	
			    	*/
					
				} catch (Exception ex) {
				
					ex.printStackTrace();
				}
			
		}
			
			
			
			
			if(submit.contentEquals("Student_Login"))
			{
				
				String hscroll = request.getParameter("hscroll");
				String sscroll = request.getParameter("sscroll");

				
				System.out.println("Student_Login page : "+hscroll+" ," +sscroll);
				try {
					
					int sts  = model.login_log(hscroll,sscroll);
					
					if(sts==15)
					{
						request.setAttribute("success", "passward not matched");
						request.getRequestDispatcher("/admin/AdminLogin/stuDashView.jsp").forward(request, response);
					}
					else
					{
						    List<subBean> beandata = model.Student_Login();
						    request.setAttribute("product", beandata);
						    
						    List<stuprofileBean> beanprofile = model.retriveProductApplicant(hscroll);
							request.setAttribute("productProfile", beanprofile);
							
							request.setAttribute("hscroll", sts);
							request.setAttribute("success", "passward  matched");
							request.getRequestDispatcher("/admin/AdminLogin/stuDashView.jsp").forward(request, response);
					}
					
					
				
			      
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			if(submit.contentEquals("superadminhome"))
			{
				
				
				
				try {
				   request.getRequestDispatcher("admin/adminhome.jsp").forward(request, response);	
				
				} catch (Exception ex) {
					
					ex.printStackTrace();
				}
				
				
			}
			
			
			if(submit.contentEquals("delete_student_Dashboard"))
			{
				
				int id = Integer.parseInt(request.getParameter("id"));
				
				bean.setId(id);
				
				
				
				try {
					int sts = model.delete_student_Dashboard(id);
					if(sts > 0)
					{
						System.out.println("delete successfully");
						request.setAttribute("success", "successfully deleted");
						 request.getRequestDispatcher("/admin/AdminLogin/DashBoardStudentReg.jsp").forward(request, response);	
					}
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
				
			}
			
			
			
			if(submit.contentEquals("delete_sub"))
			{
				
				int id = Integer.parseInt(request.getParameter("id"));
				
				bean.setId(id);
				
				
				
				try {
					int sts = model.delete_sub(id);
					if(sts > 0)
					{
						System.out.println("delete successfully");
						request.setAttribute("success", "successfully deleted");
						 request.getRequestDispatcher("/admin/AdminLogin/SubAdminrRg.jsp").forward(request, response);	
					}
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
				
			}
			
			
			if(submit.contentEquals("view_Student_Dashboard"))
			{
				
				System.out.println("view_Student_Dashboard");
				try {
				
			         List<subBean> beandata = model.view_Student_Dashboard();
					request.setAttribute("product", beandata);
					request.getRequestDispatcher("/admin/AdminLogin/StudentDashBoardView.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			if(submit.contentEquals("view_sub_admin"))
			{
				
				System.out.println("view_sub_admin");
				try {
				
			         List<subBean> beandata = model.view_sub_admin();
					request.setAttribute("product", beandata);
					request.getRequestDispatcher("/admin/AdminLogin/subadminview.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			if(submit.contentEquals("view_student_dashboar"))
			{
				System.out.println(" Student Dashboard>>>> : ");
				
			
				try {
				
			         List<subBean> beandata = model.view_student_dashboard();
					request.setAttribute("product", beandata);
					request.getRequestDispatcher("/admin/AdminLogin/ViewStudentDash.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
				
			}
			
			
			
			
			
			if(submit.contentEquals("view_sub_admin_home"))
			{
				//System.out.println(" upper >>>> : ");
			///	int id = Integer.parseInt(request.getParameter("id"));
			//	System.out.println("id in view admin home  >>>> : " +id);
			
				 HttpSession session=request.getSession(false);  
			        if(session!=null){  
			        String id_get=(String)session.getAttribute("idd"); 
			        System.out.println("id : " + id_get);
			        
			        if (id_get != null && !id_get.equals("")) 
			        {
			        
                               int id = Integer.parseInt(id_get);
				          
				        
				        try {
							
					         List<subBean> beandata = model.view_sub_admin_home(id);
							request.setAttribute("product", beandata);
							request.getRequestDispatcher("/admin/AdminLogin/viewsub.jsp").forward(request, response);
						} catch (SQLException e) {
							e.printStackTrace();
						}
			        	
			        }
			        else
			        {
			        	System.out.println(" Passward does not matched in controller  ");
						request.setAttribute("success", "Please Login First");
						request.getRequestDispatcher("/admin/AdminLogin/IndexHomeSubAdmin.jsp").forward(request, response);							
			        	
			        	
			        	
			        }
			        
			        }  
			        else{  
			        	System.out.println(" Passward does not matched in controller  ");
						request.setAttribute("success", "Please Login First");
						request.getRequestDispatcher("/admin/AdminLogin/IndexHomeSubAdmin.jsp").forward(request, response);							
			        				        }  
				
				
				
				
			
				
			}
			
			
			
			
			if(submit.contentEquals("edit_student_dashboard"))
			{
				
				int id = Integer.parseInt(request.getParameter("id"));
				System.out.println("Edit method in sub admin " + id);
				try {
				
			         List<subBean> beandata = model.edit_student_dashboard(id);
					request.setAttribute("product", beandata);
					request.getRequestDispatcher("/admin/AdminLogin/StudentDashBoardEdit.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			
			
			
			if(submit.contentEquals("edit_sub"))
			{
				
				int id = Integer.parseInt(request.getParameter("id"));
				System.out.println("Edit method in sub admin " + id);
				try {
				
			         List<subBean> beandata = model.edit_sub(id);
					request.setAttribute("product", beandata);
					request.getRequestDispatcher("/admin/AdminLogin/subAdminEdit.jsp").forward(request, response);
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
			
			
			if(submit.contentEquals("Find_Result"))
			{
				String serial1 = request.getParameter("serial1");
				System.out.println("serial1  in do get "+serial1);
				System.out.println("find result in serial1");
				try {
					List<subBean> beandata = model.Find_Result(serial1);
				
					request.setAttribute("product", beandata);
					request.getRequestDispatcher("/apply/viewResult.jsp").forward(request, response);
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
				
			}
			
			
			
			
			
			if(submit.contentEquals("Update_Student_Dashboard"))
			{
				
				
				int id = Integer.parseInt(request.getParameter("id"));
				
				boolean apply = request.getParameter("apply") != null;	
				boolean loginper = request.getParameter("loginper") != null;	
				boolean payment = request.getParameter("payment") != null;
				boolean seatplan = request.getParameter("seatplan") != null;	
				boolean admitcard = request.getParameter("admitcard") != null;
				boolean result = request.getParameter("result") != null;
				
				
				
			
				
				
				
				bean.setId(id);
				
	System.out.println("apply ,loginper , payment ,seatplan , admitcard,result "+apply+" "+loginper+" "+payment+" "+seatplan+" "+admitcard+" "+result+" ");
				
				
				
				int yy = 1;
				int zz= 0;
				
				String n = "1";
				String m = "0";
				if(apply)
				{
					
					bean.setApply(n);
					
				}
				else
				{
				
					bean.setApply(m);
				}
				
				if(loginper)
				{
					
					bean.setLoginper(yy);
					
				}
				else
				{
				
					bean.setLoginper(zz);
				}
				
				
				if(payment)
				{
					bean.setPayment(n);
					
				}
				else
				{
				
					bean.setPayment(m);
				}
				
				
				if(seatplan)
				{
					bean.setSeatplan(n);
					
				}
				else
				{
					
					bean.setSeatplan(m);
				}
				
				if(admitcard)
				{
					bean.setAdmitcard(n);
					
				}
				else
				{
					
					bean.setAdmitcard(m);
				}
				
				if(result)
				{
					bean.setResult(n);
					
				}
				else
				{
					
					bean.setResult(m);
				}
				
				
				
				
			
				try {					
				
				int sts = model.Update_Student_Dashboard(bean);
					if(sts>0)
					{						
							System.out.println(" sub admin page  ");
							request.setAttribute("success", "student dashboard Update Successfully");
						    request.getRequestDispatcher("/admin/AdminLogin/DashBoardStudentReg.jsp").forward(request, response);							
						
					}	
			
				} catch (Exception ex) {
				
					ex.printStackTrace();
				}
			
		}
			
			
			if(submit.contentEquals("update_sub"))
			{
				
				int id = Integer.parseInt(request.getParameter("id"));
			
				String subuser = request.getParameter("subuser");	
				String subpassword = request.getParameter("subpassword");
				
				
				boolean seatgo = request.getParameter("seatgo") != null;	
				boolean yeargo = request.getParameter("yeargo") != null;
				boolean gpago = request.getParameter("gpago") != null;	
				boolean unitgo = request.getParameter("unitgo") != null;
				
				
				System.out.println("subuser , subpassword ,seatgo , yeargo,gpago,unitgo "+subuser+" "+subpassword+" "+seatgo+" "+yeargo+" "+gpago+" "+unitgo);
				
				
				bean.setId(id);
				bean.setSubuser(subuser);
				bean.setSubpassword(subpassword);
				
				String n = "1";
				String m = "0";
				if(seatgo)
				{
					bean.setSeatgo(n);
					
				}
				else
				{
				
					bean.setSeatgo(m);
				}
				
				
				if(yeargo)
				{
					bean.setYeargo(n);
					
				}
				else
				{
				
					bean.setYeargo(m);
				}
				
				
				if(gpago)
				{
					bean.setGpago(n);
					
				}
				else
				{
					
					bean.setGpago(m);
				}
				
				if(unitgo)
				{
					bean.setUnitgo(n);
					
				}
				else
				{
					
					bean.setUnitgo(m);
				}
				
				
			
				try {					
				
				int sts = model.update_sub(bean);
					if(sts>0)
					{						
							System.out.println(" sub admin update page  ");
							request.setAttribute("success", "Sub Admin updated");
						    request.getRequestDispatcher("/admin/AdminLogin/SubAdminrRg.jsp").forward(request, response);							
						
					}	
			
				} catch (Exception ex) {
				
					ex.printStackTrace();
				}
			
		}
			
			
		
			
			
			

			
			
			
			
			if(submit.contentEquals("Student_Dashboard_Registration"))
			{
				
				
				
				
				boolean apply = request.getParameter("apply") != null;	
				boolean loginper = request.getParameter("loginper") != null;	
				boolean payment = request.getParameter("payment") != null;
				boolean seatplan = request.getParameter("seatplan") != null;	
				boolean admitcard = request.getParameter("admitcard") != null;
				boolean result = request.getParameter("result") != null;
				
				
				
				System.out.println("apply , payment ,seatplan , admitcard,result "+apply+" "+payment+" "+seatplan+" "+admitcard+" "+result+" ");
				
				
				
				int yy = 1;
				int zz= 0;
				
				String n = "1";
				String m = "0";
				if(apply)
				{
					
					bean.setApply(n);
					
				}
				else
				{
				
					bean.setApply(m);
				}
				
				if(loginper)
				{
					
					bean.setLoginper(yy);
					
				}
				else
				{
				
					bean.setLoginper(zz);
				}
				
				
				if(payment)
				{
					bean.setPayment(n);
					
				}
				else
				{
				
					bean.setPayment(m);
				}
				
				
				if(seatplan)
				{
					bean.setSeatplan(n);
					
				}
				else
				{
					
					bean.setSeatplan(m);
				}
				
				if(admitcard)
				{
					bean.setAdmitcard(n);
					
				}
				else
				{
					
					bean.setAdmitcard(m);
				}
				
				if(result)
				{
					bean.setResult(n);
					
				}
				else
				{
					
					bean.setResult(m);
				}
				
				
				
				
			
				try {					
				
				int sts = model.Student_Dashboard_Registration(bean);
					if(sts>0)
					{						
							System.out.println(" sub admin page  ");
							request.setAttribute("success", "student dashboard registration successfull");
						    request.getRequestDispatcher("/admin/AdminLogin/DashBoardStudentReg.jsp").forward(request, response);							
						
					}	
			
				} catch (Exception ex) {
				
					ex.printStackTrace();
				}
			
		}
			
			
			if(submit.contentEquals("Sub_Admin_Registration"))
			{
				
				String subuser = request.getParameter("subuser");	
				String subpassword = request.getParameter("subpassword");
				
				
				boolean seatgo = request.getParameter("seatgo") != null;	
				boolean yeargo = request.getParameter("yeargo") != null;
				boolean gpago = request.getParameter("gpago") != null;	
				boolean unitgo = request.getParameter("unitgo") != null;
				
				
				System.out.println("subuser , subpassword ,seatgo , yeargo,gpago,unitgo "+subuser+" "+subpassword+" "+seatgo+" "+yeargo+" "+gpago+" "+unitgo);
				
				
				
				bean.setSubuser(subuser);
				bean.setSubpassword(subpassword);
				
				String n = "1";
				String m = "0";
				if(seatgo)
				{
					bean.setSeatgo(n);
					
				}
				else
				{
				
					bean.setSeatgo(m);
				}
				
				
				if(yeargo)
				{
					bean.setYeargo(n);
					
				}
				else
				{
				
					bean.setYeargo(m);
				}
				
				
				if(gpago)
				{
					bean.setGpago(n);
					
				}
				else
				{
					
					bean.setGpago(m);
				}
				
				if(unitgo)
				{
					bean.setUnitgo(n);
					
				}
				else
				{
					
					bean.setUnitgo(m);
				}
				
				
			
				try {					
				
				int sts = model.Sub_Admin_Registration(bean);
					if(sts>0)
					{						
							System.out.println(" sub admin page  ");
							request.setAttribute("success", "New Sub admin inserted");
						    request.getRequestDispatcher("/admin/AdminLogin/SubAdminrRg.jsp").forward(request, response);							
						
					}	
			
				} catch (Exception ex) {
				
					ex.printStackTrace();
				}
			
		}
			
			
			
		}
		
		
		
		
		
	}

}
