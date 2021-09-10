package seatplan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class importCSV
 */
@WebServlet("/importCSV")
public class importCSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String uploadURL = "assets/csv";
	User u = new User();
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");

		if (action.equals("import")) {
			Part part = request.getPart("chooser");
			String fileName = getFileName(part);
			String appilicationPath = request.getServletContext().getRealPath("");
			String basePath = appilicationPath + File.separator + uploadURL;			
			String csvPath=basePath+File.separator+fileName;			
			File fileSaveDir=new File(csvPath);			
			part.write(csvPath+File.separator);			
			BufferedReader bufferedReader=new BufferedReader(new FileReader(csvPath));			
			String line="";			
			while ((line=bufferedReader.readLine())!=null) {
				String[] result=line.trim().split(",");				
				System.out.println(" Name "+result[0]+"Price "+result[1]+" Description "+result[2]);
				
				/*
				TestCSVModel testCSVModel=new TestCSVModel();
				testCSVModel.setName(result[1]);
				testCSVModel.setPrice(Double.parseDouble(result[2]));
				testCSVModel.setDescription(result[3]);
				DBData db=new DBData();
				db.saveCSVData(testCSVModel);
				System.out.println("ID "+result[0]+" Name "+result[1]+"Price "+result[2]+" Description "+result[3]);
				
				*/
			}
		}
	}

	

	private String getFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		
		String[] tokens = contentDisp.split(";");
		for (String token : tokens) {
			if (token.trim().startsWith("filename")) {
				return token.substring(token.indexOf("=") + 2, token.length() - 1);
			}
		}
		return "";
	}	

}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
	String filename= request.getParameter("file");
	    
		File file =new File(filename);
		System.out.println(file);
		try
		{
			Scanner inputStream = new Scanner(file);
			while(inputStream.hasNext())
			{
				String data = inputStream.next();
			//    System.out.println(data);
			  String[] values=data.split(",");				
			  
			  for (String string : values) {
				System.out.println(string);
			}
			  System.out.println(values);
		     
//			  int serial = Integer.parseInt(values[0]);
//			  String center =String.valueOf(values[1]) ;
//			  String address =String.valueOf(values[2]) ;
//			  String room = values[3];
//			  int capacity = Integer.parseInt(values[4]);
//			  String frange = values[5];
//			  String lrange = 	values[6];	  
//			  System.out.print(serial+" "+center+" "+address+" "+room+" "+capacity+" "+frange+" "+lrange);
//		
			 /*
			  System.out.print(values[0]+" ");
		      System.out.print(values[1]+" ");
		      System.out.print(values[2]+" ");
		      System.out.print(values[3]+" ");
		      System.out.print(values[4]+" ");
		      System.out.print(values[5]+" ");
		      System.out.print(values[6]+"***");
		   
			*/
		/*
		      ConnectionClass obj = new ConnectionClass();
		      Connection con = (Connection) obj.createConnection();
		      
		      PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into examcenter(serial,center,address,room,capacity,frange,lrange) values(?,?,?,?,?,?,?)");
//		  	ps.setInt(1,serial);
//		  	ps.setString(2,center);
//		  	ps.setString(3,address);
//		  	ps.setString(4,room);
//		  	ps.setInt(5,capacity);
//		  	
//		  	ps.setString(6,frange);
//		  	ps.setString(7,lrange);
//		     ps.executeUpdate();
//		     System.out.println("inserted");
		
		
			}
			
			inputStream.close();
		
			
	
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		*/
		
		
		
		
		
		
		

