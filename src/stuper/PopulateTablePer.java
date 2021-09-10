package stuper;

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


/**
 * Servlet implementation class PopulateTablePer
 */
@WebServlet("/PopulateTablePer")
public class PopulateTablePer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PopulateTablePer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	///	String id= request.getParameter("id");
	///	System.out.println("id : "+id);
		
		ArrayList<subBean> studentPermission=new ArrayList<subBean>();
		studentPermission=FetchDataPer.getAllCountries();
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(studentPermission, new TypeToken<List<subBean>>() {}.getType());

		JsonArray jsonArray = element.getAsJsonArray();
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
		
		
	}

}
