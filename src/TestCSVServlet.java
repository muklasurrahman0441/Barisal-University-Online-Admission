

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
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
public class TestCSVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String uploadURL = "assets/csv";
	
	public TestCSVServlet() {

	}


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