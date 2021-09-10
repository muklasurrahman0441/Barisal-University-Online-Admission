import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class networdd {

	public static void main(String[] args) throws SocketException {
		System.out.println("Get local computer name and IP:");
		System.out.println();

	
		try {
			InetAddress ip = InetAddress.getLocalHost();			
			System.out.println("Name + IP: " + ip.toString());
			System.out.println("Name:" + ip.getHostName());
			System.out.println("IP address: " + ip.getHostAddress());
			System.out.println("Full name: " + ip.getCanonicalHostName());
			
			
			
			NetworkInterface network = NetworkInterface.getByInetAddress(ip);			
			byte[] mac = network.getHardwareAddress();				
			System.out.print("Current MAC address : ");				
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < mac.length; i++) {
				sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
			}
			String macaddress=sb.toString();			
			System.out.println(macaddress);
			
			
			
			String pattern = "EEEEE MMMMM yyyy HH:mm:ss.SSS Z";
			SimpleDateFormat simpleDateFormat =new SimpleDateFormat(pattern, new Locale("bd", "BD"));
			String date = simpleDateFormat.format(new Date());
			System.out.println(date);
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

}
