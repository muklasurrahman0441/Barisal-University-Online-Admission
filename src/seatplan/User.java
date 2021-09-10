package seatplan;

public class User {
	
	private int serial,capacity;
	
	private int id;
	
	private String center,address,room;
	private String frange,lrange;
	
    public String getFrange() {
		return frange;
	}
	public void setFrange(String frange) {
		this.frange = frange;
	}
	public String getLrange() {
		return lrange;
	}
	public void setLrange(String lrange) {
		this.lrange = lrange;
	}
	public int getSerial() {
		return serial;
	}
	public void setSerial(int serial) {
		this.serial = serial;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getCenter() {
		return center;
	}
	public void setCenter(String center) {
		this.center = center;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	


}
