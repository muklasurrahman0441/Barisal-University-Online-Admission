package apply;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import ApplyLocation.ApplyLocationModel;


import apply.beanClass;
import apply.modelClass;

/**
 * Servlet implementation class controller
 */
@WebServlet("/controller")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 2, //2MB
		maxFileSize = 1024 * 1024 * 5, //10MB
		maxRequestSize = 1024 * 1024 * 50 )
public class controller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	
	beanClass bean = new beanClass();
	modelClass model = new modelClass();
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String submit = request.getParameter("submit");
		System.out.println(submit);
		if(submit != null)
		{
			
			
			if(submit.contentEquals("superedit"))
			{
				String a = request.getParameter("name");
				
				String aa = request.getParameter("fathername");
				String ab = request.getParameter("mothername");
				String ac = request.getParameter("dateofbirth");
				
				
				
		        String b = request.getParameter("mobile");
		        String c = request.getParameter("quota");
		        String d = request.getParameter("unit");
		        
		        String e = request.getParameter("sscroll");
		        String f = request.getParameter("sscreg");
		        String g = request.getParameter("sscyear");
		        String h = request.getParameter("sscgpa");		       
		        String i = request.getParameter("sscgroup");
		        String j = request.getParameter("sscboard");
		        
		        String k = request.getParameter("hscroll");
		        String l = request.getParameter("hscreg");		        
		        String m = request.getParameter("hscyear");
		        String n = request.getParameter("hscgpa");
		        String o = request.getParameter("hscgroup");
		        String p = request.getParameter("hscboard");		        
		        String q = request.getParameter("payment");				
				int roll =Integer.parseInt(request.getParameter("roll"));
				
				
				bean.setName(a);
				
				bean.setFathername(aa);
				bean.setMothername(ab);
				bean.setDateofbirth(ac);
				
				
				bean.setMobile(b);
				bean.setQuota(c);
				bean.setUnit(d);
				
				
				bean.setSscroll(e);
				bean.setSscreg(f);
				bean.setSscyear(g);
				bean.setSscgpa(h);				
				bean.setSscgroup(i);
				bean.setSscboard(j);
				
				bean.setHscroll(k);
				bean.setHscreg(l);
				bean.setHscyear(m);
				bean.setHscgpa(n);
				bean.setHscgroup(o);
				bean.setHscboard(p);
				
				bean.setPayment(q);
							
				
				bean.setRoll(roll);
				
				try {
					int sts = model.updatesuper(bean);
					if(sts > 0)
					{
						System.out.println("submit successfully");
						request.setAttribute("success", "successfully updated");
						request.getRequestDispatcher("/controller?submit=unitview").forward(request, response);
					}
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
			}
			
			
			
			if(submit.contentEquals("edit_apply"))
			{
				String hscroll = request.getParameter("hscroll");
				System.out.println("Edit apply hscroll " + hscroll);
				try {
				
			         List<beanClass> beandata = model.edit_apply(hscroll);
					request.setAttribute("product", beandata);
					request.getRequestDispatcher("/apply/edit_apply_form.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			
			if(submit.contentEquals("Find_Seat"))
			{
				String hscroll = request.getParameter("hscroll");
				
			
				bean.setHscroll(hscroll);
			
				
				System.out.println("HSC roll and SSC roll "+hscroll+" ");


				try {
					List<beanClass> beandata = model.Find_Seat(hscroll);
				//	List<beanClass> beandata = model.retriveProduct();
					request.setAttribute("product", beandata);
					request.getRequestDispatcher("/apply/ViewSeatPlan.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			
			
			
			if(submit.contentEquals("view"))
			{
				String hscroll = request.getParameter("hscroll");
				System.out.println("Hscroll  in do get "+hscroll);
				System.out.println("view method in doget");
				try {
					List<beanClass> beandata = model.retriveProductApplicant(hscroll);
				//	List<beanClass> beandata = model.retriveProduct();
					request.setAttribute("product", beandata);
					request.getRequestDispatcher("/apply/viewImage.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			if(submit.contentEquals("viewafterpayment"))
			{
				String hscroll = request.getParameter("hscroll");
				System.out.println("Hscroll  in viewafterpayment "+hscroll);
				System.out.println("view method in viewafterpayment");
				try {
					List<beanClass> beandata = model.retriveProductApplicant(hscroll);
				//	List<beanClass> beandata = model.retriveProduct();
					request.setAttribute("product", beandata);
					request.getRequestDispatcher("/apply/viewafterpayment.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			if(submit.contentEquals("unitview"))
			{
				System.out.println("view method in doget");
				try {
					List<beanClass> beandata = model.retriveProduct();
					request.setAttribute("product", beandata);
					request.getRequestDispatcher("/admin/superadmin/unitview.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			if(submit.contentEquals("editapply"))
			{
				System.out.println("view method in edit apply ");
				String hscroll = request.getParameter("hscroll");
				System.out.println("Hscroll  in edit applyt "+hscroll);
				try {
					List<beanClass> beandata = model.retriveProductedit(hscroll);
					request.setAttribute("product", beandata);
					request.getRequestDispatcher("/admin/superadmin/unitviewedit.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			if(submit.contentEquals("deleteapply"))
			{
				System.out.println("view method in edit apply ");
				String hscroll = request.getParameter("hscroll");
				System.out.println("Hscroll  in edit applyt "+hscroll);
				try {
					boolean sts = model.deletereplay(hscroll);
					if(sts)
					{
						System.out.println("Delete one data");
						request.setAttribute("success", "successfully deleted");
						request.getRequestDispatcher("/controller?submit=unitview").forward(request, response);
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
			
			if(submit.contentEquals("clearseatplan"))
			{
				
				try {
					boolean sts = model.ClearUnitDatabase(bean);
					if(sts)
					{
						System.out.println("Database Cleared");
						request.setAttribute("success", "successfully");
						request.getRequestDispatcher("/admin/superadmin/unitregistration.jsp").forward(request, response);
					}
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
			}
			
			if(submit.contentEquals("Download_Admit"))
			{
			
		        String k = request.getParameter("hscroll");
		     
		    	System.out.println("hscroll " + k);
	
				bean.setHscroll(k);
			
				try {
					int sts = model.downloadadmit(k);
					if(sts > 0)
					{
						System.out.println("submit successfully");
						
						request.setAttribute("status", "Admit Card Download successfull");
						request.setAttribute("success", sts);
						request.getRequestDispatcher("/apply/DownloadAdmitCard.jsp").forward(request, response);
					}
					else
					{
                        System.out.println(" failed to download ");
						
						request.setAttribute("status", "Incorrect HSC Roll ");
						request.setAttribute("success", sts);
						request.getRequestDispatcher("/apply/DownloadAdmitCard.jsp").forward(request, response);
					}
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
			}
			
			
			if(submit.contentEquals("download"))
			{
			
		        String k = request.getParameter("hscroll");
		     
		    	System.out.println("hscroll " + k);
	
				bean.setHscroll(k);
			
				try {
					int sts = model.downloadadmit(k);
					if(sts > 0)
					{
						System.out.println("submit successfully");
						
						request.setAttribute("status", "Admit Card  Downloaded ,  if not Check Student Dash board .");
						request.getRequestDispatcher("/indexhome.jsp").forward(request, response);
					///	request.setAttribute("success", sts);
					///	request.getRequestDispatcher("/apply/beforepayment.jsp").forward(request, response);
					}
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
			}

			
			if(submit.contentEquals("Update_Info"))
			{
				String a = request.getParameter("name");

				String aa = request.getParameter("fathername");
				String ab = request.getParameter("mothername");
				String ac = request.getParameter("dateofbirth");
				
				
				
		        String b = request.getParameter("mobile");
		        String c = request.getParameter("quota");
		        String d = request.getParameter("unit");
		        
		        String e = request.getParameter("sscroll");
		        String f = request.getParameter("sscreg");
		        String g = request.getParameter("sscyear");
		        String h = request.getParameter("sscgpa");		       
		        String i = request.getParameter("sscgroup");
		        String j = request.getParameter("sscboard");
		        
		        String k = request.getParameter("hscroll");
		        String l = request.getParameter("hscreg");		        
		        String m = request.getParameter("hscyear");
		        String n = request.getParameter("hscgpa");
		        String o = request.getParameter("hscgroup");
		        String p = request.getParameter("hscboard");		        
		        String q = request.getParameter("payment");				
				int roll =Integer.parseInt(request.getParameter("roll"));
				
				
				bean.setName(a);
				
				bean.setFathername(aa);
				bean.setMothername(ab);
				bean.setDateofbirth(ac);
				
				bean.setMobile(b);
				bean.setQuota(c);
				bean.setUnit(d);
				
				
				bean.setSscroll(e);
				bean.setSscreg(f);
				bean.setSscyear(g);
				bean.setSscgpa(h);				
				bean.setSscgroup(i);
				bean.setSscboard(j);
				
				bean.setHscroll(k);
				bean.setHscreg(l);
				bean.setHscyear(m);
				bean.setHscgpa(n);
				bean.setHscgroup(o);
				bean.setHscboard(p);
				
				bean.setPayment(q);
							
				
				bean.setRoll(roll);
				
				try {
					int sts = model.Update_Info(bean);
					if(sts > 0)
					{
						System.out.println("submit successfully");
						request.setAttribute("var", "Information Updated  , Complete payment system if remains. ");
						request.setAttribute("success", sts);
						request.getRequestDispatcher("/apply/beforepayment.jsp").forward(request, response);
					}
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
			}
			
			
			
			

			

			if(submit.contentEquals("addtrxid"))
			{
				String name = request.getParameter("name");	      
		    
		        String unit = request.getParameter("unit");		        
		      
		        
		        String hscroll = request.getParameter("hscroll");		 
				
		        int roll =Integer.parseInt(request.getParameter("roll")) ;
				
		        String usertrxid = request.getParameter("usertrxid");
				
				
				
				bean.setName(name);			
				bean.setUnit(unit);		
				bean.setHscroll(hscroll);
				bean.setRoll(roll);
				bean.setUsertrxid(usertrxid);
				
				
			
			
				
				try {
					int sts = model.paymentmethod(bean);
					if(sts > 0)
					{
						System.out.println("Payment Successfull");
						request.setAttribute("status","Payment Successfull");
						request.setAttribute("success", sts);
						request.getRequestDispatcher("/apply/afterpayment.jsp").forward(request, response);
					}
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
			}

			if(submit.contentEquals("Upload"))
			{
				String a = request.getParameter("name");
				
				String aa = request.getParameter("fathername");
				String ab = request.getParameter("mothername");
				String ac = request.getParameter("dateofbirth");
				
		        String b = request.getParameter("mobile");
		        String c = request.getParameter("quota");
		        String d = request.getParameter("unit");
		        
		        String e = request.getParameter("sscroll");
		        String f = request.getParameter("sscreg");
		        String g = request.getParameter("sscyear");
		        String h = request.getParameter("sscgpa");		       
		        String i = request.getParameter("sscgroup");
		        String j = request.getParameter("sscboard");
		        
		        String k = request.getParameter("hscroll");
		        String l = request.getParameter("hscreg");		        
		        String m = request.getParameter("hscyear");
		        String n = request.getParameter("hscgpa");
		        String o = request.getParameter("hscgroup");
		        String p = request.getParameter("hscboard");
		        
		        String q = request.getParameter("payment");
				
				
				
				Part part = request.getPart("image");
				InputStream imagefile = part.getInputStream();
				
				int roll =0;
				
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				Date obj = new Date();
				System.out.println(dateFormat.format(obj));
				String ss = String.valueOf(dateFormat.format(obj));
				
				
				String date = request.getParameter("date");
				       date = ss;
				
				
				bean.setName(a);
				bean.setFathername(aa);
				bean.setMothername(ab);
				bean.setDateofbirth(ac);
				
				
				bean.setMobile(b);
				bean.setQuota(c);
				bean.setUnit(d);
				
				
				bean.setSscroll(e);
				bean.setSscreg(f);
				bean.setSscyear(g);
				bean.setSscgpa(h);				
				bean.setSscgroup(i);
				bean.setSscboard(j);
				
				bean.setHscroll(k);
				bean.setHscreg(l);
				bean.setHscyear(m);
				bean.setHscgpa(n);
				bean.setHscgroup(o);
				bean.setHscboard(p);
				
				bean.setPayment(q);
				
				
				bean.setImageToDb(imagefile);
				bean.setRoll(roll);
				bean.setDate(date);
				
				try {
					
					
					ApplyLocationModel locationobj = new ApplyLocationModel(); 
					locationobj.setApplyLocation(k);
					
					int sts = model.uploadimage(bean);
					if(sts > 0)
					{
						if(sts==10000)
						{
							request.setAttribute("success", "invalid SSC Year");
							request.getRequestDispatcher("/apply/imageUpload.jsp").forward(request, response);
						}
						
						else if(sts==20000)
						{
							request.setAttribute("success", "invalid SSC G.P.A");
							request.getRequestDispatcher("/apply/imageUpload.jsp").forward(request, response);
						}
						
						else if(sts==30000)
						{
							request.setAttribute("success", "invalid HSC Roll");
							request.getRequestDispatcher("/apply/imageUpload.jsp").forward(request, response);
						}
						
						else if(sts==40000)
						{
							request.setAttribute("success", "invalid HSC Registration");
							request.getRequestDispatcher("/apply/imageUpload.jsp").forward(request, response);
						}
						
						else if(sts==50000)
						{
							request.setAttribute("success", "invalid HSC Passing Year");
							request.getRequestDispatcher("/apply/imageUpload.jsp").forward(request, response);
						}
						
						else if(sts==60000)
						{
							request.setAttribute("success", "invalid HSC G.P.A");
							request.getRequestDispatcher("/apply/imageUpload.jsp").forward(request, response);
						}
						
						
						else
						{
							System.out.println("submit successfully");
							request.setAttribute("var", "Apply done  , Complete payment system . ");
							request.setAttribute("success", sts);
							request.getRequestDispatcher("/apply/beforepayment.jsp").forward(request, response);
						}
						
					}
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
			}

			
			
			
			
			if(submit.contentEquals("superupload"))
			{
				String a = request.getParameter("name");
		        String b = request.getParameter("mobile");
		        String c = request.getParameter("quota");
		        String d = request.getParameter("unit");
		        
		        String e = request.getParameter("sscroll");
		        String f = request.getParameter("sscreg");
		        String g = request.getParameter("sscyear");
		        String h = request.getParameter("sscgpa");		       
		        String i = request.getParameter("sscgroup");
		        String j = request.getParameter("sscboard");
		        
		        String k = request.getParameter("hscroll");
		        String l = request.getParameter("hscreg");		        
		        String m = request.getParameter("hscyear");
		        String n = request.getParameter("hscgpa");
		        String o = request.getParameter("hscgroup");
		        String p = request.getParameter("hscboard");
		        
		        String q = request.getParameter("payment");
				
				
				
				Part part = request.getPart("image");
				InputStream imagefile = part.getInputStream();
				
				
				int roll =Integer.parseInt(request.getParameter("roll")) ;
				
				
				bean.setName(a);
				bean.setMobile(b);
				bean.setQuota(c);
				bean.setUnit(d);
				
				
				bean.setSscroll(e);
				bean.setSscreg(f);
				bean.setSscyear(g);
				bean.setSscgpa(h);				
				bean.setSscgroup(i);
				bean.setSscboard(j);
				
				bean.setHscroll(k);
				bean.setHscreg(l);
				bean.setHscyear(m);
				bean.setHscgpa(n);
				bean.setHscgroup(o);
				bean.setHscboard(p);
				
				bean.setPayment(q);
				
				
				bean.setImageToDb(imagefile);
				
				bean.setRoll(roll);
				
				try {
					boolean sts = model.uploadimagesuper(bean);
					if(sts)
					{
						System.out.println("submit successfully");
						request.setAttribute("success", "successfully");
						request.getRequestDispatcher("/admin/superadmin/unitregistration.jsp").forward(request, response);
					}
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
			}
			
			
			
		}
	}

}
