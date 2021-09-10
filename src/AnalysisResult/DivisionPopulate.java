package AnalysisResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;




@WebServlet("/DivisionPopulate")
public class DivisionPopulate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DivisionPopulate() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id= request.getParameter("id");
	    System.out.println("id : "+id);
	    
		String name= request.getParameter("name");
	    System.out.println("name : "+name);
	
	    
		ArrayList<ResyltBean> studentPermission=new ArrayList<ResyltBean>();
		studentPermission=ResultModel.getAllSearchDivision(name);
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(studentPermission, new TypeToken<List<ResyltBean>>() {}.getType());

		JsonArray jsonArray = element.getAsJsonArray();
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
		
	}

}
