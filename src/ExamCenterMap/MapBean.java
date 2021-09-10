package ExamCenterMap;

public class MapBean {
	
	
	double lat,lng;
	String examcenter;
	
	int map_id;
	
	
	
	
	
	
	public MapBean( int map_id,double lat, double lng, String examcenter) {
		super();
		this.map_id = map_id;
		this.lat = lat;
		this.lng = lng;
		this.examcenter = examcenter;
		
	}
	public MapBean() {
		super();
	}
	public int getMap_id() {
		return map_id;
	}
	public void setMap_id(int map_id) {
		this.map_id = map_id;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public String getExamcenter() {
		return examcenter;
	}
	public void setExamcenter(String examcenter) {
		this.examcenter = examcenter;
	}
	
	
	
	

}
