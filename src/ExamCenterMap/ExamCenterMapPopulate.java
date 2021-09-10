package ExamCenterMap;

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






@WebServlet("/ExamCenterMapPopulate")
public class ExamCenterMapPopulate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ExamCenterMapPopulate() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		ArrayList<MapBean> mapdata=new ArrayList<MapBean>();
		mapdata=FetchMapData.getAllMapData();
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(mapdata, new TypeToken<List<MapBean>>() {}.getType());

		JsonArray jsonArray = element.getAsJsonArray();
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
		
	}

}
