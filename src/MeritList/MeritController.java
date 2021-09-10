package MeritList;

import java.io.IOException;
import java.sql.SQLException;
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




@WebServlet("/MeritController")
public class MeritController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MeritController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArrayList<MeritBean> studentPermission=new ArrayList<MeritBean>();
		studentPermission=MeritFetch.getScienceData();
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(studentPermission, new TypeToken<List<MeritBean>>() {}.getType());

		JsonArray jsonArray = element.getAsJsonArray();
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String submit = request.getParameter("submit");
		System.out.println(submit);
		if(submit != null)
		{
			
			
			if(submit.contentEquals("ssccsv"))
			{
				try {
					MeritFetch model = new MeritFetch();
					int sts = model.Create_csv();
					if(sts > 0)
					{
						System.out.println("Inserted CSV");
						request.setAttribute("success", " CSV file Exported ");
						 request.getRequestDispatcher("/admin/Merit/MeritHome.jsp").forward(request, response);	
					}
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
			}
		}
		
		
	}

}
