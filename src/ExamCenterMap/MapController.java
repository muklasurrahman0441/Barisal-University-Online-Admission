package ExamCenterMap;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





@WebServlet("/MapController")
public class MapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	MapBean bean = new MapBean();
	MapModel model = new MapModel();
    public MapController() {
        super();
      
    }

    
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String submit = request.getParameter("submit");
		System.out.println(submit);
		
		if(submit != null)
		{
			if(submit.contentEquals("updatedatamap"))
			{
				
				int id = Integer.parseInt(request.getParameter("id"));
				
				double lat = Double.parseDouble(request.getParameter("lat"));
				double lng = Double.parseDouble(request.getParameter("lng"));
				String examcenter = request.getParameter("examcenter");
				
				bean.setMap_id(id);
				bean.setLat(lat);
				bean.setLng(lng);
				bean.setExamcenter(examcenter);
				
				System.out.println(id+lat+lng);
						
				
				
				try {
					int sts = model.updateMapInfo(bean);
					if(sts > 0)
					{
						System.out.println("updated successfully");
						request.setAttribute("success", "successfully updated");
						request.getRequestDispatcher("/admin/ExamCenterMap/Exam_Center_Reg.jsp").forward(request, response);
					}
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
				
				
			}
		}	
    
}	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String submit = request.getParameter("submit");
		System.out.println(submit);
		if(submit != null)
		{
			
	
			
			
			if(submit.contentEquals("upmap"))
			{
				System.out.println("Update  map");
				int map_id = Integer.parseInt(request.getParameter("map_id"));
				
				bean.setMap_id(map_id);
				
				System.out.println("Update  map  : id" +map_id);
				
				try {
					
			         List<MapBean> beandata = model.retriveEditMap(map_id);
					request.setAttribute("product", beandata);
					request.getRequestDispatcher("/admin/ExamCenterMap/editmap.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
			
			
			if(submit.contentEquals("mapdelete"))
			{
				
				int map_id = Integer.parseInt(request.getParameter("map_id"));
				
				bean.setMap_id(map_id);
				
				
				
				try {
					int sts = model.delete_Map_Data(map_id);
					if(sts > 0)
					{
						System.out.println("delete successfully");
						request.setAttribute("success", "successfully deleted");
						request.getRequestDispatcher("/admin/ExamCenterMap/Exam_Center_Reg.jsp").forward(request, response);
					}
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
				
			}
			
			
			if(submit.contentEquals("Upload"))
			{
				
				double lat=Double.parseDouble(request.getParameter("lat"));
				double lng= Double.parseDouble(request.getParameter("lng"));
				String examcenter=request.getParameter("examcenter");
				
				System.out.println(lat+" "+lng+" "+examcenter);
				
				bean.setLat(lat);
				bean.setLng(lng);
				bean.setExamcenter(examcenter);
				
				
				try {
					int sts = model.InsertMapData(bean);
					if(sts > 0)
					{
						System.out.println("submit successfully");
						request.setAttribute("success", "successfully inserted");
						request.getRequestDispatcher("/admin/ExamCenterMap/Exam_Center_Reg.jsp").forward(request, response);
					}
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
				
			}
			
			
		}
		
	}




}
