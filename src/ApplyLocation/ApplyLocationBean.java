package ApplyLocation;

public class ApplyLocationBean {
	
	
	public ApplyLocationBean(int id, String hscroll, String hostname, String canonicalhostname, String ipaddress,
			String macaddress, String applylocationdate) {
		super();
		this.id = id;
		this.hscroll = hscroll;
		this.hostname = hostname;
		this.canonicalhostname = canonicalhostname;
		this.ipaddress = ipaddress;
		this.macaddress = macaddress;
		this.applylocationdate = applylocationdate;
	}
	public ApplyLocationBean() {
		super();
	}
	

	int id;
	String hscroll,hostname,canonicalhostname,ipaddress,macaddress,applylocationdate;
	public String getApplylocationdate() {
		return applylocationdate;
	}
	public void setApplylocationdate(String applylocationdate) {
		this.applylocationdate = applylocationdate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHscroll() {
		return hscroll;
	}
	public void setHscroll(String hscroll) {
		this.hscroll = hscroll;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getCanonicalhostname() {
		return canonicalhostname;
	}
	public void setCanonicalhostname(String canonicalhostname) {
		this.canonicalhostname = canonicalhostname;
	}
	public String getIpaddress() {
		return ipaddress;
	}
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	public String getMacaddress() {
		return macaddress;
	}
	public void setMacaddress(String macaddress) {
		this.macaddress = macaddress;
	}
	
	
	
	int serial,capacity,roll;
	String center,address,room,date;
   


	String name,mobile,quota,unit,sscroll,sscreg,sscyear,sscgpa,sscgroup,sscboard,hscreg,hscyear,hscgpa,hscgroup,hscboard,payment;	
	String fathername,mothername,dateofbirth;
	public int getSerial() {
		return serial;
	}
	public void setSerial(int serial) {
		this.serial = serial;
	}
	public int getCapacity() {
		return capacity;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getQuota() {
		return quota;
	}
	public void setQuota(String quota) {
		this.quota = quota;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getSscroll() {
		return sscroll;
	}
	public void setSscroll(String sscroll) {
		this.sscroll = sscroll;
	}
	public String getSscreg() {
		return sscreg;
	}
	public void setSscreg(String sscreg) {
		this.sscreg = sscreg;
	}
	public String getSscyear() {
		return sscyear;
	}
	public void setSscyear(String sscyear) {
		this.sscyear = sscyear;
	}
	public String getSscgpa() {
		return sscgpa;
	}
	public void setSscgpa(String sscgpa) {
		this.sscgpa = sscgpa;
	}
	public String getSscgroup() {
		return sscgroup;
	}
	public void setSscgroup(String sscgroup) {
		this.sscgroup = sscgroup;
	}
	public String getSscboard() {
		return sscboard;
	}
	public void setSscboard(String sscboard) {
		this.sscboard = sscboard;
	}
	public String getHscreg() {
		return hscreg;
	}
	public void setHscreg(String hscreg) {
		this.hscreg = hscreg;
	}
	public String getHscyear() {
		return hscyear;
	}
	public void setHscyear(String hscyear) {
		this.hscyear = hscyear;
	}
	public String getHscgpa() {
		return hscgpa;
	}
	public void setHscgpa(String hscgpa) {
		this.hscgpa = hscgpa;
	}
	public String getHscgroup() {
		return hscgroup;
	}
	public void setHscgroup(String hscgroup) {
		this.hscgroup = hscgroup;
	}
	public String getHscboard() {
		return hscboard;
	}
	public void setHscboard(String hscboard) {
		this.hscboard = hscboard;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getFathername() {
		return fathername;
	}
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}
	public String getMothername() {
		return mothername;
	}
	public void setMothername(String mothername) {
		this.mothername = mothername;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	
	
	public ApplyLocationBean(int id , String name ,String fathername , String mothername , String dateofbirth, String mobile, String quota, String unit, String sscroll, String sscreg,
			String sscyear, String sscgpa, String sscgroup, String sscboard, String hscroll, String hscreg,
			String hscyear, String hscgpa, String hscgroup, String hscboard, String payment,int roll,String date ,int serial,String center,String address,String room, int capacity 
			) {
		super();
		this.id=id;
		this.name = name;
		this.fathername=fathername;
		this.mothername = mothername;
		this.dateofbirth = dateofbirth;
		this.mobile = mobile;
		this.quota = quota;
		this.unit = unit;
		this.sscroll = sscroll;
		this.sscreg = sscreg;
		this.sscyear = sscyear;
		this.sscgpa = sscgpa;
		this.sscgroup = sscgroup;
		this.sscboard = sscboard;
		this.hscroll = hscroll;
		this.hscreg = hscreg;
		this.hscyear = hscyear;
		this.hscgpa = hscgpa;
		this.hscgroup = hscgroup;
		this.hscboard = hscboard;
		this.payment = payment;
		this.roll=roll;
		this.date = date;
		
		this.serial=serial;
		this.center=center;
		this.address = address;
		this.room = room;
		this.capacity =capacity;
	
	}
	
	
	
	
	
}
