package subadmin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
maxFileSize = 1024 * 1024 * 50, // 50 MB
maxRequestSize = 1024 * 1024 * 100)



@WebServlet("/uploadResultCsvController")
public class uploadResultCsvController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String uploadURL = "assets/csv";
   
	resultModel model = new resultModel();
	
	
    public uploadResultCsvController() {
        super();
      
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");

		if (action.equals("import")) {
			Part part = request.getPart("chooser");
			String fileName = getFileName(part);			
			String appilicationPath = request.getServletContext().getRealPath("");
			String basePath = appilicationPath + File.separator + uploadURL;			
			String csvPath=basePath+File.separator+fileName;			
			File fileSaveDir=new File(csvPath);			
			part.write(csvPath+File.separator);			
			try {			
			BufferedReader bufferedReader=new BufferedReader(new FileReader(csvPath));
			
			
			try {
				int sts = model.insert_csv(bufferedReader);
				if(sts > 0)
				{
					System.out.println("Result Inserted CSV in db ");
					request.setAttribute("success", "Result inserted ...  !!!!");
					 request.getRequestDispatcher("/admin/AdminLogin/indexsuper.jsp").forward(request, response);	
				}
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			
			/*
			String line="";
			
			while ((line=bufferedReader.readLine())!=null) {
				String[] values=line.trim().split(",");
				
				///System.out.println(" Name "+result[0]+"Price "+result[1]+" Description "+result[2]);
				
			  int serial = Integer.parseInt(values[0]);				  
			  String center =String.valueOf(values[1]) ;
				  String address =String.valueOf(values[2]) ;
				  String room = values[3];
				  int capacity = Integer.parseInt(values[4]);
				  String frange = values[5];
				  String lrange = 	values[6];	  
				  System.out.print(serial+" "+center+" "+address+" "+room+" "+capacity+" "+frange+" "+lrange);
			
			
				  ConnectionClass obj = new ConnectionClass();
			      Connection con = (Connection) obj.createConnection();
			      
			      PreparedStatement ps = (PreparedStatement) con.prepareStatement("insert into examcenter(serial,center,address,room,capacity,frange,lrange) values(?,?,?,?,?,?,?)");
				
			  	ps.setInt(1,serial);
			  	ps.setString(2,center);
			  	ps.setString(3,address);
			  	ps.setString(4,room);
			  	ps.setInt(5,capacity);
			  	
			  	ps.setString(6,frange);
			  	ps.setString(7,lrange);
			     ps.executeUpdate();
			     System.out.println("inserted");
			
			    }
			
				 */
			
			}
			
			
			 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
