package apply;

import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


import apply.ConnectionClass;
import apply.beanClass;

public class modelClass {
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	String sql = "";
	boolean sts = false;
	boolean sts2 = false;
	
	
	String sscf,sscl,hscf,hscl,sscrollf,hscrollf;
	
	int serial,capacity;
	 String center,address,room,rol;
	
	 
	 public List<beanClass> edit_apply(String hscrol) throws SQLException
		{
			
		 
		 List<beanClass> been = new ArrayList<>();
			con = ConnectionClass.createConnection();
			String sql= "SELECT * FROM imaageup where hscroll="+hscrol;
			PreparedStatement pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			if(rs.next())
			{
				int id = rs.getInt(1);			
				String name = rs.getString(2);	
				String fathername = rs.getString(3);
				String mothername = rs.getString(4);
				String dateofbirth = rs.getString(5);
				
				String  mobile= rs.getString(6);
				String  quota= rs.getString(7);
				String  unit= rs.getString(8);
				String  sscroll= rs.getString(9);			
				String  sscreg= rs.getString(10);
				String  sscyear= rs.getString(11);
				String  sscgpa= rs.getString(12);
				String  sscgroup= rs.getString(13);
				String  sscboard= rs.getString(14);
				String  hscroll= rs.getString(15);
				String  hscreg= rs.getString(16);
				String  hscyear= rs.getString(17);
				String  hscgpa= rs.getString(18);
				String  hscgroup= rs.getString(19);
				String  hscboard= rs.getString(20);
				String  payment= rs.getString(21);
				int  roll= rs.getInt(23);
				String  date= rs.getString(24);
				
				
				
			
				
			System.out.println("see retriveProductedit  : "+name+roll+hscroll);

				beanClass newbean = new beanClass(id,name,fathername,mothername,dateofbirth,mobile,quota,unit,sscroll,sscreg,sscyear,sscgpa,sscgroup,sscboard,hscroll,hscreg,hscyear,hscgpa,hscgroup,hscboard,payment,roll,date);
				been.add(newbean);
			}
			return been;
		 
		 
		}
	 
	 
	 
	 
	public boolean ClearUnitDatabase(beanClass bean) throws SQLException
	{
		con = ConnectionClass.createConnection();
		String sql= "DELETE FROM imaageup";
		pst = con.prepareStatement(sql);		
		
		sts = pst.executeUpdate() > 0;
		
		con.close();
		pst.close();
		return sts;
	}
	
	
	public boolean deletereplay(String hscroll) throws SQLException
	{
		con = ConnectionClass.createConnection();
		String sql= "DELETE FROM imaageup where hscroll="+hscroll;
		pst = con.prepareStatement(sql);		
		
		sts = pst.executeUpdate() > 0;
		
		con.close();
		pst.close();
		return sts;
	}
	
	
	public int downloadadmit( String hscroll) throws SQLException
	{
	
		int val=0;
		int roll=0;
		
		try
		{
			DateFormat dateFormat = new SimpleDateFormat("HH_mm_ss");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			String ss = String.valueOf(dateFormat.format(date));
			
			String filename="C:\\Users\\USER\\Downloads\\"+ss+".pdf";
			Document document = new Document();
			
			PdfWriter.getInstance(document, new FileOutputStream(filename));			
			document.open();
			
			
			Image img = Image.getInstance("F:\\demo\\work\\admission\\WebContent\\logo.jpg");
			img.scaleToFit(100, 100);
		   img.setAlignment(Image.ALIGN_CENTER);
		    document.add(img);
			
			 Font f=new Font(FontFamily.TIMES_ROMAN,18.0f,Font.UNDERLINE,BaseColor.BLACK);			
			 Paragraph para = new Paragraph("University Of Barisal\nAdmission Test :Session: (2014-2015)");	
			 para.setAlignment(Paragraph.ALIGN_CENTER);
		     document.add(para);
		   
		     
		     
		     
		     
			
			document.add(new Paragraph(" "));			
			document.add(new Paragraph(" "));
			
			con = ConnectionClass.createConnection();
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        
	        String query = "select * from imaageup where hscroll="+hscroll;
	        ps=con.prepareStatement(query);
	        rs=ps.executeQuery();
	        
	        System.out.println("hscroll " + hscroll);
	        
	       
	        
	        while(rs.next())
	        {
	        	roll=Integer.parseInt(rs.getString("roll"));
	        	System.out.println("inside download : roll  "+roll);
	        	
	           
	        	 Blob imageBlob = (Blob) rs.getBlob(22);
	        	 byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());
	        	 Image image = Image.getInstance(imageBytes);
	        	 image.scaleAbsolute(100,100);
	        	 image.setAlignment(Image.LEFT);	        	 
	        	 document.add(image);
	        	 
	      	
	        	 
	           PdfPTable table2 = new PdfPTable(2);
	           
	           table2.setWidthPercentage(80);
	           table2.setHorizontalAlignment(Element.ALIGN_LEFT);
	   		  
	           PdfPCell cellOne2 = new PdfPCell(new Phrase("Name "));
	  		   PdfPCell cellTwo2 = new PdfPCell(new Phrase(rs.getString("name")));
	  		   cellOne2.setBorder(Rectangle.NO_BORDER);
	  		   cellTwo2.setBorder(Rectangle.NO_BORDER);
	  		   table2.addCell(cellOne2);
	  		   table2.addCell(cellTwo2);		 		   
	  		  
	  		   PdfPCell cellOne3 = new PdfPCell(new Phrase("Father's Name "));
	  		   PdfPCell cellTwo3 = new PdfPCell(new Phrase(rs.getString("fathername")));
	  		   cellOne3.setBorder(Rectangle.NO_BORDER);
	  		   cellTwo3.setBorder(Rectangle.NO_BORDER);
	  		   table2.addCell(cellOne3);
	  		   table2.addCell(cellTwo3);	
	  		   
	  		   
	  		   PdfPCell cellOne4 = new PdfPCell(new Phrase("Mother's Name "));
	  		   PdfPCell cellTwo4 = new PdfPCell(new Phrase( rs.getString("mothername")));
	  		   cellOne4.setBorder(Rectangle.NO_BORDER);
	  		   cellTwo4.setBorder(Rectangle.NO_BORDER);
	  		   table2.addCell(cellOne4);
	  		   table2.addCell(cellTwo4);	
	  		   
	  		   PdfPCell cellOne5 = new PdfPCell(new Phrase("Date Of Birth "));
	  		   PdfPCell cellTwo5 = new PdfPCell(new Phrase(rs.getString("dateofbirth")));
	  		   cellOne5.setBorder(Rectangle.NO_BORDER);
	  		   cellTwo5.setBorder(Rectangle.NO_BORDER);
	  		   table2.addCell(cellOne5);
	  		   table2.addCell(cellTwo5);	
	  		   
	  		  
	  		   PdfPCell cellOne6 = new PdfPCell(new Phrase("SSC Roll "));
			   PdfPCell cellTwo6 = new PdfPCell(new Phrase(rs.getString("sscroll")));
			   cellOne6.setBorder(Rectangle.NO_BORDER);
			   cellTwo6.setBorder(Rectangle.NO_BORDER);
			   table2.addCell(cellOne6);
			   table2.addCell(cellTwo6);	
			   
			   PdfPCell cellOne7 = new PdfPCell(new Phrase("HSC Roll "));
			   PdfPCell cellTwo7 = new PdfPCell(new Phrase(String.valueOf(rs.getString("hscroll"))));
			   cellOne7.setBorder(Rectangle.NO_BORDER);
			   cellTwo7.setBorder(Rectangle.NO_BORDER);
			   table2.addCell(cellOne7);
			   table2.addCell(cellTwo7);	
			   
			   PdfPCell cellOne8 = new PdfPCell(new Phrase("Exam roll "));
			   PdfPCell cellTwo8 = new PdfPCell(new Phrase(String.valueOf( rs.getInt("roll"))));
			   cellOne8.setBorder(Rectangle.NO_BORDER);
			   cellTwo8.setBorder(Rectangle.NO_BORDER);
			   table2.addCell(cellOne8);
			   table2.addCell(cellTwo8);	
	  		   
	  		   
	  		   document.add(table2);	 		
	        	/*
	        	Paragraph par = new Paragraph("Name : "+ rs.getString("name") + "\n" + 
	                                       "Father's Name : " +  rs.getString("fathername")+ "\n" + 
	                                       "Mother's Name : " +  rs.getString("mothername")+ "\n" + 
	                                       "Date Of Birth : " +  rs.getString("dateofbirth")+ "\n" + 
	                                      
	                                       "Contact : " +  rs.getString("mobile")+ "\n" + 
	        			                  "Quota : "+   rs.getString("quota")+ "\n" +
	                                       
	                                       "Unit : " + rs.getString("unit") +"\n" +
	                                       "SSC Roll : " + rs.getString("sscroll")+"\n" +
	                                       "SSC Registration : " + rs.getString("sscreg")+"\n" +
	                                       /*
	                                       
	                                       "SSC Year : " + rs.getString("sscyear")+"\n" +
	                                       "SSC G.P.A : " + rs.getString("sscgpa")+"\n" +
	                                       "SSC Group : " + rs.getString("sscgroup")+"\n" +
	                                       "SSC Board : " + rs.getString("sscboard") +"\n" +
	                                      */
	                                       
	  		   /*
	                                       "HSC Roll : " + rs.getString("hscroll")+"\n" +
	                                       "HSC Registration : " + rs.getString("hscreg")+"\n" +
	                                    */   
	                                       /*
	                                       "HSC Year : " + rs.getString("hscyear")+"\n" +
	                                       "HSC G.P.A : " + rs.getString("hscgpa")+"\n" +
	                                       "HSC Group : " + rs.getString("hscgroup")+"\n" +
	                                       "HSC Board : " + rs.getString("hscboard")
	                                       +"\n" +
	                                      
	                                       
	                                       "Payment Status: " + rs.getString("payment")
	                                       +"\n" +
	                                       
	                                        */
	  		   /*
	                                       "Exam roll : " + rs.getInt("roll") +"\n"
	                                     
	                                      
	        	    
	        			
	        			);
	        	
	        
	        	document.add(par);
	        	
	        	*/
	        	String sqlseat= "SELECT * FROM examcenter";
				PreparedStatement pstseat = con.prepareStatement(sqlseat);
				rs = pstseat.executeQuery();
				
				while(rs.next())
				{
					
					int fr=Integer.parseInt(rs.getString(7));
					int lr=Integer.parseInt(rs.getString(8));
					 System.out.println("fr ,lr  : " +fr+lr);

					if(roll>=fr && roll<=lr)
					{
						serial = rs.getInt("serial");
						center = rs.getString("center");
					    address = rs.getString("address");
					   	room =rs.getString("room");
						capacity=rs.getInt("capacity");
						 
						 System.out.println("roll center,address : " +serial+center+address+room+capacity);
						 
						 /*
							Paragraph paragra = new Paragraph("Exam Center : "+ rs.getString("center") + "\n" + 
                                    "Address : " +  rs.getString("address")+ "\n" + 
     			                  "Room : "+   rs.getString("room")+ "\n" +
                                    "Capacity : " + rs.getInt("capacity") 
                                   
     	    
     			
     			);
     	document.add(paragra);
     	*/
     	
     	
          // PdfPTable table2 = new PdfPTable(2);
		  
           PdfPCell c11 = new PdfPCell(new Phrase("Exam Center "));
		   PdfPCell c12 = new PdfPCell(new Phrase(rs.getString("center")));
		   c11.setBorder(Rectangle.NO_BORDER);
		   c12.setBorder(Rectangle.NO_BORDER);
		   table2.addCell(c11);
		   table2.addCell(c12);		 		   
		  
		   PdfPCell c21 = new PdfPCell(new Phrase("Address "));
		   PdfPCell c22 = new PdfPCell(new Phrase(rs.getString("address")));
		   c21.setBorder(Rectangle.NO_BORDER);
		   c22.setBorder(Rectangle.NO_BORDER);
		   table2.addCell(c21);
		   table2.addCell(c22);	
		   
		   
		   PdfPCell c31 = new PdfPCell(new Phrase("Room "));
		   PdfPCell c32 = new PdfPCell(new Phrase(rs.getString("room")));
		   c31.setBorder(Rectangle.NO_BORDER);
		   c32.setBorder(Rectangle.NO_BORDER);
		   table2.addCell(c31);
		   table2.addCell(c32);	
		   
		   PdfPCell c41 = new PdfPCell(new Phrase("Capacity "));
		   PdfPCell c42 = new PdfPCell(new Phrase(String.valueOf(rs.getInt("capacity"))));
		   c41.setBorder(Rectangle.NO_BORDER);
		   c42.setBorder(Rectangle.NO_BORDER);
		   table2.addCell(c41);
		   table2.addCell(c42);	
		   
		   
		   
		   document.add(table2);
		     
	 
				}
					
				}
				
				
	        	
	        	
	        	
	        	document.add(new Paragraph(" "));	
	        	val=Integer.parseInt(hscroll);
	        	
	        	
	        }
	        
	        
	        Font ffff = new Font(FontFamily.TIMES_ROMAN, 18.0f, Font.BOLD, BaseColor.WHITE);
	        Chunk c = new Chunk("General Instructions For Applicants" , ffff);
	        c.setBackground(BaseColor.GRAY);
	        Paragraph p = new Paragraph(c);
	        p.setAlignment(Paragraph.ALIGN_CENTER);
	        document.add(p);
	       
	        /*
             Font f1=new Font(FontFamily.TIMES_ROMAN,18.0f,Font.UNDERLINE,BaseColor.BLACK);	
	         Paragraph para1 = new Paragraph("General Instructions for applicants\n\n",f1);	
			 para1.setAlignment(Paragraph.ALIGN_LEFT);
		     document.add(para1);
		     */
		             Font f2=new Font(FontFamily.TIMES_ROMAN,10.0f,Font.ITALIC,BaseColor.GRAY);	
		             Paragraph para2 = new Paragraph("1 . Please print 2 copies of admit card and staple a recent passport size duty attested photo with the said admit card.\n",f2	);		     
		 			 para2.setAlignment(Paragraph.ALIGN_LEFT);
		 		     document.add(para2);
		 		     
		 		    Font f3=new Font(FontFamily.TIMES_ROMAN,10.0f,Font.ITALIC,BaseColor.GRAY);	
		 		    Paragraph para23 = new Paragraph("2 . Bring the original registration cards of SSC and HSC or Equivalent Examinations.\n",f3	);		     
		 			 para23.setAlignment(Paragraph.ALIGN_LEFT);
		 		     document.add(para23);
		 		     
		 		    Font f4=new Font(FontFamily.TIMES_ROMAN,10.0f,Font.ITALIC,BaseColor.GRAY);	
		 		    Paragraph para24 = new Paragraph("3 . All sorts of calculators, Digital Watch, Mobile Phone, Blue Tooth or any telecommunications devices are strictly prohibited in the Examination Hall.\n",f4	);		     
		 			 para24.setAlignment(Paragraph.ALIGN_LEFT);
		 		     document.add(para24);
		 		     
	   
		 		
		 		     
			document.close();
			System.out.println("finished");
			
			
			
		}
		catch(Exception ex)
		{
			System.err.println(ex);
		}
	
		
		
		return (val);
	}
	
	
	
	
	
	public int paymentmethod( beanClass bean) throws SQLException
	{
	
		int val=0;
		int value=0;
		con = ConnectionClass.createConnection();
		String sql= "INSERT INTO payment(name,unit,hscroll,roll,usertrxid) VALUE (?,?,?,?,?)";
	
		pst = con.prepareStatement(sql);		
		
		pst.setString(1, bean.getName());
		pst.setString(2, bean.getUnit());
		pst.setString(3, bean.getHscroll());
		pst.setInt(4, bean.getRoll());
		pst.setString(5, bean.getUsertrxid());
		
		value = pst.executeUpdate();
		
		String status= "update imaageup set payment=? where hscroll=? ";
		pst = con.prepareStatement(status);		
		pst.setString(1, "yes");		
        pst.setString(2, bean.getHscroll());
	
        pst.executeUpdate();
    	System.out.println("Payment status yes now");
		con.close();
		pst.close();
		
		
		val = Integer.parseInt(bean.getHscroll());
		
		return (val);
	}
	
	
	public int uploadimage( beanClass bean) throws SQLException
	{
		int value=0;
		int valuepass=0;
		String unit="";
		double sgpa=0.0,hgpa=0.0;
		
		
		
		con = ConnectionClass.createConnection();
		
		int examrolltake=0;
		
		String extractroll = "SELECT * FROM `imaageup` ORDER BY roll DESC LIMIT 1";		
		PreparedStatement pst = con.prepareStatement(extractroll);
		rs = pst.executeQuery();
		while(rs.next())
		{
			 examrolltake = Integer.parseInt(rs.getString(23));		
			 System.out.println("examrolltake old : "+examrolltake);
		}
		
		
		String hsc_roll_no ="";
		String hsc_regno="";
		String hsc_pass_year="";
		String hsc_gpa="";
		
		String hscroll_get = bean.getHscroll();	
		System.out.println("hscroll_get"+hscroll_get);
		String hsc_result = "SELECT * FROM `hsc_rsc_result` where roll_no="+hscroll_get;		
		PreparedStatement pst_hsc_result = con.prepareStatement(hsc_result);
		rs = pst_hsc_result.executeQuery();
		while(rs.next())
		{
			hsc_roll_no =rs.getString(4);
			hsc_regno = rs.getString(5);
			hsc_pass_year =rs.getString(7);
			hsc_gpa = rs.getString(8);
			
			 System.out.println("hsc_roll_no,hsc_regno,hsc_pass_year,hsc_gpa : "+hsc_roll_no+hsc_regno+hsc_pass_year+hsc_gpa);
		}
		
		
		String sschsc = "SELECT * FROM `year`";		
		PreparedStatement pstssc = con.prepareStatement(sschsc);
		rs = pstssc.executeQuery();
		while(rs.next())
		{
		    	sscf =rs.getString(2);
		    	sscl = rs.getString(3);
		    	hscf =rs.getString(4);
		    	hscl = rs.getString(5);
			
			 System.out.println("ssf,sscl,hscf,hscl : "+sscf+sscl+hscf+hscl);
		}
		
		
        String unitget=bean.getUnit();
		
		System.out.println("Unit get : " + unitget);
		
		String unitgpa = "SELECT * FROM `unit` where unit="+"'"+unitget+"'";		
		PreparedStatement unitgpars = con.prepareStatement(unitgpa);
		ResultSet rs1 = unitgpars.executeQuery();
		while(rs1.next())
		{
			    unit = rs1.getString(2);
		    	sgpa =rs1.getDouble(3);
		    	hgpa = rs1.getDouble(4);
		    	
			
			 System.out.println("unit,sgpa,hgpa  : "+unit+sgpa+hgpa);
		}
		
		
		
		
		String sql= "INSERT INTO imaageup(name,fathername,mothername,dateofbirth,mobile,quota,unit,sscroll,sscreg,sscyear,sscgpa,sscgroup,sscboard,hscroll,hscreg,hscyear,hscgpa,hscgroup,hscboard,payment,image,roll,date) VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		pst = con.prepareStatement(sql);
		
		pst.setString(1, bean.getName());
		pst.setString(2, bean.getFathername());
		pst.setString(3, bean.getMothername());
		pst.setString(4, bean.getDateofbirth());
		pst.setString(5, bean.getMobile());
		pst.setString(6, bean.getQuota());
		pst.setString(7, bean.getUnit());
		
		sscrollf =  String.valueOf(bean.getSscyear()) ;
		System.out.println("sscrollf : "+sscrollf);
		
		if( (sscrollf.equals(sscf)) || (sscrollf.equals(sscl)) )
		{
			pst.setString(8, bean.getSscroll());
		}
		else
		{
		
			System.out.println("Incorrect SSC Year");
			valuepass = 10000;
			return (valuepass);
			
		}
		
	
		
		
		pst.setString(9, bean.getSscreg());
		pst.setString(10, bean.getSscyear());
		
		if( (unit.equals(bean.getUnit())) )
		{			
			double sgpaup = Double.parseDouble(bean.getSscgpa());		
			System.out.println("sscup : , sgpa + unit " + sgpaup+sgpa+unit);
			if(sgpaup > sgpa)
			{
				pst.setString(11, bean.getSscgpa());				
			}	
			else
			{
				
				System.out.println("Incorrect SSC GPA");
				valuepass = 20000;
				return (valuepass);
			}
		}
		
		pst.setString(12, bean.getSscgroup());
		pst.setString(13, bean.getSscboard());
		
		
		
		hscrollf =String.valueOf( bean.getHscyear());
		System.out.println("hscrollf : "+hscrollf);

	//	 if( (hscrollf.equals(hscf)) || (hscrollf.equals(hscl)) )
	//	{
			
			if( hsc_roll_no.equals(bean.getHscroll()) )
			{
				pst.setString(14, bean.getHscroll());
				System.out.println("correct hsc result roll match");
			}
			else
			{
				
				System.out.println("Incorrect HSC Roll");
				valuepass = 30000;
				return (valuepass);
			}
			
	//	}
		
		/*	else
		{
			
			System.out.println("Incorrect HSC Year");
			valuepass = 99999;
			return (valuepass);
		}
		
		*/
		
			// hsc_regno = rs.getString(5);
		 //	hsc_pass_year =rs.getString(7);
		//	hsc_gpa = rs.getString(8);
			
			
			if( hsc_regno.equals(bean.getHscreg() ) )
			{
				pst.setString(15, bean.getHscreg());
				System.out.println("correct hsc result registration match");
			}
			else
			{
				
				System.out.println("Incorrect HSC registration");
				valuepass = 40000;
				return (valuepass);
			}
			
			
			if( hsc_pass_year.equals(bean.getHscyear() ) )
			{
				pst.setString(16, bean.getHscyear());
				System.out.println("correct hsc result hsc_pass_year match");
			}
			else
			{
				
				System.out.println("Incorrect HSC hsc_pass_year");
				valuepass = 50000;
				return (valuepass);
			}
		
		
		

		if( (unit.equals(bean.getUnit())) )
		{		
			double hgpaup = Double.parseDouble(bean.getHscgpa());		
			System.out.println("hscup : hgpa + unit " + hgpaup+hgpa+unit);
			if(hgpaup > hgpa)
			{
				
				if( hsc_gpa.equals(bean.getHscgpa() ) )
				{
					pst.setString(17, bean.getHscgpa());
					System.out.println("correct hsc result hsc_gpa match");
				}
				
					
				
			}
			else
			{
				
				System.out.println("Incorrect HSC GPA");
				valuepass = 60000;
				return (valuepass);
			}
			
			
		}
		
		
		
		pst.setString(18, bean.getHscgroup());
		pst.setString(19, bean.getHscboard());
		pst.setString(20, bean.getPayment());
		
	
		pst.setBlob(21, bean.getImageToDb());
		
		examrolltake = examrolltake + 1;
		
		 System.out.println("examrolltake new  : "+examrolltake);
		String enterexamroll = String.valueOf(examrolltake);
		
		pst.setString(22, enterexamroll );
		pst.setString(23, bean.getDate());
		
		
		value = pst.executeUpdate();
		 System.out.println("value imag value : "+value);
		con.close();
		pst.close();
		
		valuepass=Integer.parseInt(bean.getHscroll()) ;
		System.out.println("value imag value pass  : "+valuepass);
		return (valuepass);
	}
	
	
	public int Update_Info( beanClass bean) throws SQLException
	{
		
		int r=0;
		con = ConnectionClass.createConnection();
		String sql= "update imaageup set name=?,fathername=?,mothername=?,dateofbirth=?,mobile=?,quota=?,unit=?,sscroll=?,sscreg=?,sscyear=?,sscgpa=?,sscgroup=?,sscboard=?,hscroll=?,hscreg=?,hscyear=?,hscgpa=?,hscgroup=?,hscboard=?,payment=?,roll=? where hscroll=? ";
		pst = con.prepareStatement(sql);
		
		pst.setString(1, bean.getName());
		pst.setString(2, bean.getFathername());
		pst.setString(3, bean.getMothername());
		pst.setString(4, bean.getDateofbirth());
		
		
		pst.setString(5, bean.getMobile());
		pst.setString(6, bean.getQuota());
		pst.setString(7, bean.getUnit());
		pst.setString(8, bean.getSscroll());
		pst.setString(9, bean.getSscreg());
		pst.setString(10, bean.getSscyear());
		pst.setString(11, bean.getSscgpa());
		pst.setString(12, bean.getSscgroup());
		pst.setString(13, bean.getSscboard());
		
		pst.setString(14, bean.getHscroll());
		pst.setString(15, bean.getHscreg());
		pst.setString(16, bean.getHscyear());
		pst.setString(17, bean.getHscgpa());		
		pst.setString(18, bean.getHscgroup());
		pst.setString(19, bean.getHscboard());
		pst.setString(20, bean.getPayment());	
		
		pst.setInt(21, bean.getRoll());
		
		pst.setString(22, bean.getHscroll());
		
		
		
		
		
		r = pst.executeUpdate();
		
		 r =Integer.parseInt(bean.getHscroll()) ;
		
		con.close();
		pst.close();
		return r;
	}
	
	
	

	public int updatesuper( beanClass bean) throws SQLException
	{
		
		int r=0;
		con = ConnectionClass.createConnection();
		String sql= "update imaageup set name=?,fathername=?,mothername=?,dateofbirth=?,mobile=?,quota=?,unit=?,sscroll=?,sscreg=?,sscyear=?,sscgpa=?,sscgroup=?,sscboard=?,hscroll=?,hscreg=?,hscyear=?,hscgpa=?,hscgroup=?,hscboard=?,payment=?,roll=? where hscroll=? ";
		pst = con.prepareStatement(sql);
		
		pst.setString(1, bean.getName());
		
		pst.setString(2, bean.getFathername());
		pst.setString(3, bean.getMothername());
		pst.setString(4, bean.getDateofbirth());
		
		
		pst.setString(5, bean.getMobile());
		pst.setString(6, bean.getQuota());
		pst.setString(7, bean.getUnit());
		pst.setString(8, bean.getSscroll());
		pst.setString(9, bean.getSscreg());
		pst.setString(10, bean.getSscyear());
		pst.setString(11, bean.getSscgpa());
		pst.setString(12, bean.getSscgroup());
		pst.setString(13, bean.getSscboard());
		
		pst.setString(14, bean.getHscroll());
		pst.setString(15, bean.getHscreg());
		pst.setString(16, bean.getHscyear());
		pst.setString(17, bean.getHscgpa());		
		pst.setString(18, bean.getHscgroup());
		pst.setString(19, bean.getHscboard());
		pst.setString(20, bean.getPayment());	
		
		pst.setInt(21, bean.getRoll());
		
		pst.setString(22, bean.getHscroll());
		
		
		
		
		
		r = pst.executeUpdate();
		
		con.close();
		pst.close();
		return r;
	}
	
	
	
	public boolean uploadimagesuper( beanClass bean) throws SQLException
	{
		con = ConnectionClass.createConnection();
		String sql= "INSERT INTO imaageup(name,mobile,quota,unit,sscroll,sscreg,sscyear,sscgpa,sscgroup,sscboard,hscroll,hscreg,hscyear,hscgpa,hscgroup,hscboard,payment,image,roll) VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		pst = con.prepareStatement(sql);
		
		pst.setString(1, bean.getName());
		pst.setString(2, bean.getMobile());
		pst.setString(3, bean.getQuota());
		pst.setString(4, bean.getUnit());
		pst.setString(5, bean.getSscroll());
		pst.setString(6, bean.getSscreg());
		pst.setString(7, bean.getSscyear());
		pst.setString(8, bean.getSscgpa());
		pst.setString(9, bean.getSscgroup());
		pst.setString(10, bean.getSscboard());
		
		pst.setString(11, bean.getHscroll());
		pst.setString(12, bean.getHscreg());
		pst.setString(13, bean.getHscyear());
		pst.setString(14, bean.getHscgpa());		
		pst.setString(15, bean.getHscgroup());
		pst.setString(16, bean.getHscboard());
		pst.setString(17, bean.getPayment());
		
	
		pst.setBlob(18, bean.getImageToDb());
		
		pst.setInt(19, bean.getRoll());
		
		
		sts = pst.executeUpdate() > 0;
		
		con.close();
		pst.close();
		return sts;
	}
	
	
	public List<beanClass> Find_Seat(String hroll)throws SQLException
	{
		List<beanClass> been = new ArrayList<>();
		con = ConnectionClass.createConnection();
		String sql= "SELECT * FROM imaageup where hscroll="+hroll;
		PreparedStatement pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		if(rs.next())
		{
					
			String name = rs.getString(2);			
			String  mobile= rs.getString(6);
			
			String  unit= rs.getString(8);
			String  sscroll= rs.getString(9);				
			String  hscroll= rs.getString(15);			
			String  payment= rs.getString(21);
			
		   int  roll= Integer.parseInt(rs.getString(23));
		
			
		     
			 
			 
			 
			String sqlseat= "SELECT * FROM examcenter";
			PreparedStatement pstseat = con.prepareStatement(sqlseat);
			rs = pstseat.executeQuery();
			while(rs.next())
			{
				
				int fr=Integer.parseInt(rs.getString(7));
				int lr=Integer.parseInt(rs.getString(8));
				 System.out.println("fr ,lr  : " +fr+lr);

				if(roll>=fr && roll<=lr)
				{
					serial = rs.getInt("serial");
					center = rs.getString("center");
				    address = rs.getString("address");
				   	room =rs.getString("room");
					capacity=rs.getInt("capacity");
					 
					 System.out.println("roll center,address : " +serial+center+address+room+capacity);
				}
				
			}
			
			

			
		

			beanClass newbean = new beanClass(name,mobile,unit,sscroll,hscroll,payment,roll,serial,center,address,room,capacity);
			been.add(newbean);
		}
		return been;
	}
	
	
	
	
	public List<beanClass> retriveProductApplicant(String hroll)throws SQLException
	{
		List<beanClass> been = new ArrayList<>();
		con = ConnectionClass.createConnection();
		String sql= "SELECT * FROM imaageup where hscroll="+hroll;
		PreparedStatement pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		if(rs.next())
		{
			int id = rs.getInt(1);			
			String name = rs.getString(2);		
			
			String fathername = rs.getString(3);	
			String mothername = rs.getString(4);	
			String dateofbirth = rs.getString(5);	
			
			String  mobile= rs.getString(6);
			String  quota= rs.getString(7);
			String  unit= rs.getString(8);
			String  sscroll= rs.getString(9);			
			String  sscreg= rs.getString(10);
			String  sscyear= rs.getString(11);
			String  sscgpa= rs.getString(12);
			String  sscgroup= rs.getString(13);
			String  sscboard= rs.getString(14);
			String  hscroll= rs.getString(15);
			String  hscreg= rs.getString(16);
			String  hscyear= rs.getString(17);
			String  hscgpa= rs.getString(18);
			String  hscgroup= rs.getString(19);
			String  hscboard= rs.getString(20);
			String  payment= rs.getString(21);
			
		   int  roll= Integer.parseInt(rs.getString(23));
		   String date = rs.getString(24);
			
		     
			 
			 
			 
			String sqlseat= "SELECT * FROM examcenter";
			PreparedStatement pstseat = con.prepareStatement(sqlseat);
			rs = pstseat.executeQuery();
			while(rs.next())
			{
				
				int fr=Integer.parseInt(rs.getString(7));
				int lr=Integer.parseInt(rs.getString(8));
				 System.out.println("fr ,lr  : " +fr+lr);

				if(roll>=fr && roll<=lr)
				{
					serial = rs.getInt("serial");
					center = rs.getString("center");
				    address = rs.getString("address");
				   	room =rs.getString("room");
					capacity=rs.getInt("capacity");
					 
					 System.out.println("roll center,address : " +serial+center+address+room+capacity);
				}
				
			}
			
			

			
		

			beanClass newbean = new beanClass(id,name,fathername,mothername,dateofbirth,mobile,quota,unit,sscroll,sscreg,sscyear,sscgpa,sscgroup,sscboard,hscroll,hscreg,hscyear,hscgpa,hscgroup,hscboard,payment,roll,date,serial,center,address,room,capacity );
			been.add(newbean);
		}
		return been;
	}
	
	
	public List<beanClass> retriveProductedit(String hroll) throws SQLException
	{
		List<beanClass> been = new ArrayList<>();
		con = ConnectionClass.createConnection();
		String sql= "SELECT * FROM imaageup where hscroll="+hroll;
		PreparedStatement pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		if(rs.next())
		{
			int id = rs.getInt(1);			
			String name = rs.getString(2);	
			String fathername = rs.getString(3);
			String mothername = rs.getString(4);
			String dateofbirth = rs.getString(5);
			
			String  mobile= rs.getString(6);
			String  quota= rs.getString(7);
			String  unit= rs.getString(8);
			String  sscroll= rs.getString(9);			
			String  sscreg= rs.getString(10);
			String  sscyear= rs.getString(11);
			String  sscgpa= rs.getString(12);
			String  sscgroup= rs.getString(13);
			String  sscboard= rs.getString(14);
			String  hscroll= rs.getString(15);
			String  hscreg= rs.getString(16);
			String  hscyear= rs.getString(17);
			String  hscgpa= rs.getString(18);
			String  hscgroup= rs.getString(19);
			String  hscboard= rs.getString(20);
			String  payment= rs.getString(21);
			int  roll= rs.getInt(23);
			String  date= rs.getString(24);
		
			
		System.out.println("see retriveProductedit  : "+name+roll+hscroll);

		beanClass newbean = new beanClass(id,name,fathername,mothername,dateofbirth,mobile,quota,unit,sscroll,sscreg,sscyear,sscgpa,sscgroup,sscboard,hscroll,hscreg,hscyear,hscgpa,hscgroup,hscboard,payment,roll,date);
		been.add(newbean);
		}
		return been;
	}

	
	
	public List<beanClass> retriveProduct() throws SQLException
	{
		List<beanClass> been = new ArrayList<>();
		con = ConnectionClass.createConnection();
		String sql= "SELECT * FROM imaageup ORDER BY date DESC";
		PreparedStatement pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next())
		{
			int id = rs.getInt(1);			
			String name = rs.getString(2);	
			String fathername = rs.getString(3);
			String mothername = rs.getString(4);
			String dateofbirth = rs.getString(5);
			
			String  mobile= rs.getString(6);
			String  quota= rs.getString(7);
			String  unit= rs.getString(8);
			String  sscroll= rs.getString(9);			
			String  sscreg= rs.getString(10);
			String  sscyear= rs.getString(11);
			String  sscgpa= rs.getString(12);
			String  sscgroup= rs.getString(13);
			String  sscboard= rs.getString(14);
			String  hscroll= rs.getString(15);
			String  hscreg= rs.getString(16);
			String  hscyear= rs.getString(17);
			String  hscgpa= rs.getString(18);
			String  hscgroup= rs.getString(19);
			String  hscboard= rs.getString(20);
			String  payment= rs.getString(21);
			int  roll= rs.getInt(23);
			String  date= rs.getString(24);

		     
			 System.out.println("hscroll in sss " + hscroll );
			 
		
			String sqlseat= "SELECT * FROM examcenter";
			PreparedStatement pstseat = con.prepareStatement(sqlseat);
			ResultSet rs1 = pstseat.executeQuery();
			while(rs1.next())
			{
				
				int fr=Integer.parseInt(rs1.getString(7));
				int lr=Integer.parseInt(rs1.getString(8));
				 System.out.println("fr ,lr  : " +fr+lr);

				if(roll>=fr && roll<=lr)
				{
					serial = rs1.getInt("serial");
					center = rs1.getString("center");
				    address = rs1.getString("address");
				   	room =rs1.getString("room");
					capacity=rs1.getInt("capacity");
					 
					 System.out.println("roll center,address : " +serial+center+address+room+capacity);
				}
				
			}
		
			
			
		

		     beanClass newbean = new beanClass(id,name,fathername,mothername,dateofbirth,mobile,quota,unit,sscroll,sscreg,sscyear,sscgpa,sscgroup,sscboard,hscroll,hscreg,hscyear,hscgpa,hscgroup,hscboard,payment,roll,date,serial,center,address,room,capacity );
			been.add(newbean);
		}
		return been;
	}

	public void retriveImage(int iid,beanClass bean) throws SQLException
	{
		con = ConnectionClass.createConnection();
		String sql= "SELECT image FROM imaageup WHERE id=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1,iid);
		rs = pst.executeQuery();
		while(rs.next())
		{
			Blob blob = rs.getBlob("image");
			byte[] bytearray = blob.getBytes(1, (int) blob.length());
			bean.setImagedata(bytearray);
		}
	}
	
}
