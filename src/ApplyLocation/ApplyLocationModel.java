package ApplyLocation;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;






public class ApplyLocationModel {

	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	String sql = "";
	
	
	
	public List<ApplyLocationBean> viewProfileStudent(String hroll)throws SQLException
	{
		List<ApplyLocationBean> been = new ArrayList<>();
		con = ConnectionClass.createConnection();
		String sql= "SELECT * FROM imaageup where hscroll="+hroll;
		PreparedStatement pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		if(rs.next())
		{
			int id = rs.getInt(1);			
			String name = rs.getString(2);		
			
			String fathername = rs.getString(3);	
			String mothername = rs.getString(4);	
			String dateofbirth = rs.getString(5);	
			
			String  mobile= rs.getString(6);
			String  quota= rs.getString(7);
			String  unit= rs.getString(8);
			String  sscroll= rs.getString(9);			
			String  sscreg= rs.getString(10);
			String  sscyear= rs.getString(11);
			String  sscgpa= rs.getString(12);
			String  sscgroup= rs.getString(13);
			String  sscboard= rs.getString(14);
			String  hscroll= rs.getString(15);
			String  hscreg= rs.getString(16);
			String  hscyear= rs.getString(17);
			String  hscgpa= rs.getString(18);
			String  hscgroup= rs.getString(19);
			String  hscboard= rs.getString(20);
			String  payment= rs.getString(21);
			
		   int  roll= Integer.parseInt(rs.getString(23));
		   String date = rs.getString(24);
			
		     
			 String center=null,address=null,room=null;
			 int serial=0,capacity=0;
			 
			 
			String sqlseat= "SELECT * FROM examcenter";
			PreparedStatement pstseat = con.prepareStatement(sqlseat);
			rs = pstseat.executeQuery();
			while(rs.next())
			{
				
				int fr=Integer.parseInt(rs.getString(7));
				int lr=Integer.parseInt(rs.getString(8));
				 System.out.println("fr ,lr  : " +fr+lr);

				if(roll>=fr && roll<=lr)
				{
					serial = rs.getInt("serial");
					center = rs.getString("center");
				    address = rs.getString("address");
				   	room =rs.getString("room");
					capacity=rs.getInt("capacity");
					 
					 System.out.println("roll center,address : " +serial+center+address+room+capacity);
				}
				
			}
			
			

			
		

			ApplyLocationBean newbean = new ApplyLocationBean(id,name,fathername,mothername,dateofbirth,mobile,quota,unit,sscroll,sscreg,sscyear,sscgpa,sscgroup,sscboard,hscroll,hscreg,hscyear,hscgpa,hscgroup,hscboard,payment,roll,date,serial,center,address,room,capacity );
			been.add(newbean);
		}
		return been;
	}
	
	
	public List<ApplyLocationBean> ApplyLocationView() throws SQLException
	{
		List<ApplyLocationBean> been = new ArrayList<>();
		con = ConnectionClass.createConnection();
		String sql= "SELECT * FROM applyaddress";
		PreparedStatement pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next())
		{
			ApplyLocationBean u= new ApplyLocationBean();			
			
			int id = rs.getInt(1);			
			String hscroll = rs.getString(2);			
			String hostname = rs.getString(3);	
			String canonicalhostname = rs.getString(4);
			String ipaddress= rs.getString(5);
			String macaddress= rs.getString(6);
			String applylocationdate= rs.getString(7);
			
			u.setId(id);
			u.setHscroll(hscroll);
			u.setHostname(hostname);
			u.setCanonicalhostname(canonicalhostname);
			u.setIpaddress(ipaddress);
			u.setMacaddress(macaddress);
			u.setApplylocationdate(applylocationdate);
		
			
			
			ApplyLocationBean newbean = new ApplyLocationBean(id,hscroll,hostname,canonicalhostname,ipaddress,macaddress,applylocationdate);
			been.add(newbean);
		}
		return been;
	}
	
	
	
	public void setApplyLocation(String k) throws SocketException, SQLException
	{
		
		
		
		try {
			InetAddress ip = InetAddress.getLocalHost();	
			
			
			
			System.out.println("Name + IP: " + ip.toString());
			System.out.println("Name:" + ip.getHostName());
			System.out.println("IP address: " + ip.getHostAddress());
			System.out.println("Full name: " + ip.getCanonicalHostName());
			
			String hscroll = k;
			String hostname = ip.getHostName();
			String canonicalhostname = ip.getHostAddress();
			String ipaddress = ip.getCanonicalHostName();
			
			
			NetworkInterface network = NetworkInterface.getByInetAddress(ip);			
			byte[] mac = network.getHardwareAddress();				
			System.out.print("Current MAC address : ");				
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < mac.length; i++) {
				sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
			}
			
			
			
			String macaddress=sb.toString();	
			
			
			System.out.println(hscroll+" "+hostname+" "+canonicalhostname+" "+ipaddress+" "+macaddress);
			
			String pattern = "EEEEE MMMMM yyyy HH:mm:ss.SSS Z";
			SimpleDateFormat simpleDateFormat =new SimpleDateFormat(pattern, new Locale("bd", "BD"));
			String applylocationdate = simpleDateFormat.format(new Date());
			System.out.println("Date : "+applylocationdate);
			
			
			
			con = ConnectionClass.createConnection();
			String sql= "INSERT INTO applyaddress(hscroll,hostname,canonicalhostname,ipaddress,macaddress,applylocationdate) VALUE (?,?,?,?,?,?)";		
			pst = con.prepareStatement(sql);		
			
			pst.setString(1, hscroll);
			pst.setString(2,hostname);
			pst.setString(3, canonicalhostname);
			pst.setString(4, ipaddress);
			pst.setString(5, macaddress);
			pst.setString(6, applylocationdate);
			
			pst.executeUpdate();
			
			System.out.println("Apply Location Inserted");
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		
	}
	
}
