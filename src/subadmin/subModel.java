package subadmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
















public class subModel {

	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	String sql = "";
	
	
	
	public List<stuprofileBean> retriveProductApplicant(String hroll)throws SQLException
	{
		List<stuprofileBean> been = new ArrayList<>();
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
			
		     
			 
			 int serial=0,capacity=0;
			 String center=null,address=null,room=null;
			 
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
			
			

			
		

			stuprofileBean newbean = new stuprofileBean(id,name,fathername,mothername,dateofbirth,mobile,quota,unit,sscroll,sscreg,sscyear,sscgpa,sscgroup,sscboard,hscroll,hscreg,hscyear,hscgpa,hscgroup,hscboard,payment,roll,date,serial,center,address,room,capacity );
			been.add(newbean);
		}
		return been;
	}
	
	
	
	
	
	
	
	
	
	public int login_log( String hroll ,String sroll ) throws SQLException
	{
		int val = 0;
		
        String sscroll="",hscroll="";
		
		String sw= "SELECT * FROM imaageup where hscroll="+hroll;
		PreparedStatement pstsw = con.prepareStatement(sw);
		ResultSet rssw = pstsw.executeQuery();
		
		while(rssw.next())
		{
		     sscroll = rssw.getString(9);	
		     hscroll  = rssw.getString(15);		
			 
			 System.out.println("inside model sscroll :" +sscroll +" hscroll" +hscroll);
			 
				
				
				if(sscroll.equals(sroll)  &&  hscroll.equals(hroll) )
				{
					System.out.println("Passward not matched");
					val = Integer.parseInt(hscroll) ;
				}
				else
				{
					System.out.println("Passward not matched");
					val = 15;
				}
				
			 
			 
		}
		
		
		
		return val;
		
		
	}
	
	
	
	public List<subBean> Student_Login() throws SQLException
	{
		
		List<subBean> been = new ArrayList<>();
		
			con = ConnectionClass.createConnection();
			String sql= "SELECT * FROM studentdashboard";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				subBean u= new subBean();			
				
				int id = rs.getInt(1);			
				String apply = rs.getString(2);	
				int loginper = rs.getInt(3);	
				String payment = rs.getString(4);	
				String seatplan = rs.getString(5);
				String admitcard= rs.getString(6);
				String result= rs.getString(7);
			
				
				
				u.setId(id);
				u.setApply(apply);
				u.setLoginper(loginper);
				u.setPayment(payment);
				u.setSeatplan(seatplan);
				u.setAdmitcard(admitcard);
				u.setResult(result);
				
				
				subBean newbean = new subBean(id,apply,loginper,payment,seatplan,admitcard,result);
				been.add(newbean);
			}
		
		
		return been;
		
		
		
		
	}
	
	
	
	
	
	public List<subBean> Find_Result(String ser1)throws SQLException
	{
		List<subBean> been = new ArrayList<>();
		con = ConnectionClass.createConnection();
		String sql= "SELECT * FROM result where serial1="+ser1;
		PreparedStatement pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		if(rs.next())
		{
				
			String board = rs.getString(2);			
			String  group= rs.getString(6);
			int  sscroll= rs.getInt(7);
			int  hscroll= rs.getInt(9);
			String name = rs.getString(11);
			
			double ssc_per = rs.getDouble(20);
			double  hsc_per= rs.getDouble(21);
			
			double ban = rs.getDouble(23);
			double  eng= rs.getDouble(24);
			double  phy= rs.getDouble(25);
			double  che= rs.getDouble(26);
			double  mat= rs.getDouble(27);			
			double  bio= rs.getDouble(28);			
			double  ict= rs.getDouble(29);
            double  mcq= rs.getDouble(30);			
			double  g_total= rs.getDouble(31);			
			double  merit= rs.getDouble(32);
			String status = rs.getString(56);	
		

			subBean newbean = new subBean( board,group,sscroll,hscroll,name,ssc_per ,hsc_per ,ban,eng,phy,che,mat,bio,ict,mcq,g_total,merit,status);
			been.add(newbean);
		}
		return been;
	}
	
	
	
	
	public int delete_sub( int idd) throws SQLException
	{
		int val = 0;
		
		con = ConnectionClass.createConnection();
		String sql= "DELETE FROM subadmin where id="+idd;
		pst = con.prepareStatement(sql);		
		
		val = pst.executeUpdate();
		
		con.close();
		pst.close();
		
		
		return val;
		
		
	}
	
	

	
	
	public int update_sub( subBean bean) throws SQLException
	{
		int val = 0;
		
		con = ConnectionClass.createConnection();
		
		String sql= "update subadmin set subuser=?,subpassword=?,seatgo=?,yeargo=?,gpago=?,unitgo=? where id=?";
		pst = con.prepareStatement(sql);
		
		pst.setString(1, bean.getSubuser());
		pst.setString(2, bean.getSubpassword());		
		pst.setString(3, bean.getSeatgo());
		pst.setString(4, bean.getYeargo());		
		pst.setString(5, bean.getGpago());
		pst.setString(6, bean.getUnitgo());		
		
		
		pst.setInt(7, bean.getId());
		
		val = pst.executeUpdate();
		
		
		System.out.println("val : " + val);
		
		return val;
		
		
	}
	
	
	
	public List<subBean> edit_sub(int idd) throws SQLException
	{
		List<subBean> been = new ArrayList<>();
		con = ConnectionClass.createConnection();
		String sql= "SELECT * FROM subadmin where id="+idd;
		PreparedStatement pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next())
		{
           subBean u= new subBean();			
			
			int id = rs.getInt(1);			
			String subuser = rs.getString(2);			
			String subpassword = rs.getString(3);	
			String seatgo = rs.getString(4);
			String yeargo= rs.getString(5);
			String gpago= rs.getString(6);
			String unitgo= rs.getString(7);
			
			
			u.setId(id);
			u.setSubuser(subuser);
			u.setSubpassword(subpassword);
			u.setSeatgo(seatgo);
			u.setYeargo(yeargo);
			u.setGpago(gpago);
			u.setUnitgo(unitgo);
			
			
			subBean newbean = new subBean(id,subuser,subpassword,seatgo,yeargo,gpago,unitgo);
			been.add(newbean);
		}
		return been;
	}
	
	
	
	public int Sub_Admin_Login( subBean bean) throws SQLException
	{
		int val = 0;		
		con = ConnectionClass.createConnection();		
		
		String subuser=bean.getSubuser();
		String subpassword = bean.getSubpassword();
		
		
		String sql= " SELECT * FROM  subadmin";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next())
		{
			String user = rs.getString(2);
			String pass = rs.getString(3);
			
			if( (subuser.equals(user)) && (subpassword.equals(pass)))
			{
				System.out.println("passward matched");
				val = rs.getInt(1);
				break;
			}
			else
			{
				val = 999999;
			}
			
			
			
		}
		
		return val;		
		
	}
	
	
	public List<subBean> view_sub_admin_home(int idd) throws SQLException
	{
		List<subBean> been = new ArrayList<>();
		con = ConnectionClass.createConnection();
		String sql= "SELECT * FROM subadmin where id="+idd;
		PreparedStatement pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next())
		{
			subBean u= new subBean();			
			
			int id = rs.getInt(1);			
			String subuser = rs.getString(2);			
			String subpassword = rs.getString(3);	
			String seatgo = rs.getString(4);
			String yeargo= rs.getString(5);
			String gpago= rs.getString(6);
			String unitgo= rs.getString(7);
			
			
			u.setId(id);
			u.setSubuser(subuser);
			u.setSubpassword(subpassword);
			u.setSeatgo(seatgo);
			u.setYeargo(yeargo);
			u.setGpago(gpago);
			u.setUnitgo(unitgo);
			
			
			subBean newbean = new subBean(id,subuser,subpassword,seatgo,yeargo,gpago,unitgo);
			been.add(newbean);
		}
		return been;
	}
	
	
	
	public List<subBean> view_sub_admin() throws SQLException
	{
		List<subBean> been = new ArrayList<>();
		con = ConnectionClass.createConnection();
		String sql= "SELECT * FROM subadmin";
		PreparedStatement pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next())
		{
			subBean u= new subBean();			
			
			int id = rs.getInt(1);			
			String subuser = rs.getString(2);			
			String subpassword = rs.getString(3);	
			String seatgo = rs.getString(4);
			String yeargo= rs.getString(5);
			String gpago= rs.getString(6);
			String unitgo= rs.getString(7);
			
			
			u.setId(id);
			u.setSubuser(subuser);
			u.setSubpassword(subpassword);
			u.setSeatgo(seatgo);
			u.setYeargo(yeargo);
			u.setGpago(gpago);
			u.setUnitgo(unitgo);
			
			
			subBean newbean = new subBean(id,subuser,subpassword,seatgo,yeargo,gpago,unitgo);
			been.add(newbean);
		}
		return been;
	}
	
	public int delete_student_Dashboard( int idd) throws SQLException
	{
		int val = 0;
		
		con = ConnectionClass.createConnection();
		String sql= "DELETE FROM studentdashboard where id="+idd;
		pst = con.prepareStatement(sql);		
		
		val = pst.executeUpdate();
		
		con.close();
		pst.close();
		
		val=20;
		return val;
		
		
	}
	
	
	public List<subBean> view_student_dashboard() throws SQLException
	{
		List<subBean> been = new ArrayList<>();
		con = ConnectionClass.createConnection();
		String sql= "SELECT * FROM studentdashboard";
		PreparedStatement pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next())
		{
			subBean u= new subBean();			
			
			int id = rs.getInt(1);			
			String apply = rs.getString(2);			
			int loginper = rs.getInt(3);	
			String payment = rs.getString(4);	
			String seatplan = rs.getString(5);
			String admitcard= rs.getString(6);
			String result= rs.getString(7);
		
			
			
			u.setId(id);
			u.setApply(apply);
			u.setLoginper(loginper);
			u.setPayment(payment);
			u.setSeatplan(seatplan);
			u.setAdmitcard(admitcard);
			u.setResult(result);
			
			
			subBean newbean = new subBean(id,apply, loginper,payment,seatplan,admitcard,result);
			been.add(newbean);
		}
		return been;
	}
	
	
	
	public List<subBean> edit_student_dashboard(int idd) throws SQLException
	{
		List<subBean> been = new ArrayList<>();
		con = ConnectionClass.createConnection();
		String sql= "SELECT * FROM studentdashboard where id="+idd;
		PreparedStatement pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next())
		{
			subBean u= new subBean();			
		
		int id = rs.getInt(1);			
		String apply = rs.getString(2);		
		int loginper = rs.getInt(3);		
		String payment = rs.getString(4);	
		String seatplan = rs.getString(5);
		String admitcard= rs.getString(6);
		String result= rs.getString(7);
	
		
		
		u.setId(id);
		u.setLoginper(loginper);
		u.setApply(apply);		
		u.setPayment(payment);
		u.setSeatplan(seatplan);
		u.setAdmitcard(admitcard);
		u.setResult(result);
		
		
		subBean newbean = new subBean(id,apply,loginper,payment,seatplan,admitcard,result);
		been.add(newbean);
		}
		return been;
	}
	
	
	
	
	public List<subBean> view_Student_Dashboard() throws SQLException
	{
		List<subBean> been = new ArrayList<>();
		con = ConnectionClass.createConnection();
		String sql= "SELECT * FROM studentdashboard";
		PreparedStatement pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next())
		{
			subBean u= new subBean();			
			
			int id = rs.getInt(1);			
			String apply = rs.getString(2);	
			int loginper = rs.getInt(3);	
			String payment = rs.getString(4);	
			String seatplan = rs.getString(5);
			String admitcard= rs.getString(6);
			String result= rs.getString(7);
		
			
			
			u.setId(id);
			u.setApply(apply);
			u.setLoginper(loginper);
			u.setPayment(payment);
			u.setSeatplan(seatplan);
			u.setAdmitcard(admitcard);
			u.setResult(result);
			
			
			subBean newbean = new subBean(id,apply,loginper,payment,seatplan,admitcard,result);
			been.add(newbean);
		}
		return been;
	}
	
	
	
	public int Update_Student_Dashboard( subBean bean) throws SQLException
	{
		int val = 0;
		
		con = ConnectionClass.createConnection();
		
		String sql= "update studentdashboard set apply=?,loginper=?,payment=?,seatplan=?,admitcard=?,result=? where id=?";
		pst = con.prepareStatement(sql);
		
		pst.setString(1, bean.getApply());
		pst.setInt(2, bean.getLoginper());
		pst.setString(3, bean.getPayment());
		pst.setString(4, bean.getSeatplan());
		pst.setString(5, bean.getAdmitcard());
		pst.setString(6, bean.getResult());
		
		
		pst.setInt(7, bean.getId());
		
		val = pst.executeUpdate();
		
		
		System.out.println("val : " + val);
		
		return val;
		
		
	}	
	
	public int Student_Dashboard_Registration( subBean bean) throws SQLException
	{
		int val = 0;		
		
		
		con = ConnectionClass.createConnection();		
		String sql= "INSERT INTO studentdashboard(apply,loginper,payment,seatplan,admitcard,result) VALUE (?,?,?,?,?,?)";
		pst = con.prepareStatement(sql);
		
		pst.setString(1, bean.getApply());
		pst.setInt(2, bean.getLoginper());
		pst.setString(3, bean.getPayment());
		pst.setString(4, bean.getSeatplan());
		pst.setString(5, bean.getAdmitcard());
		pst.setString(6, bean.getResult());
		
		
		val = pst.executeUpdate();		
		System.out.println("student dashboard registration: " + val);		
		
	
		
		System.out.println("yes");
		val=10;
		return val;		
		
	}
	
	public int Sub_Admin_Registration( subBean bean) throws SQLException
	{
		int val = 0;		
		
		
		con = ConnectionClass.createConnection();		
		String sql= "INSERT INTO subadmin(subuser,subpassword,seatgo,yeargo,gpago,unitgo) VALUE (?,?,?,?,?,?)";
		pst = con.prepareStatement(sql);
		
		pst.setString(1, bean.getSubuser());
		pst.setString(2, bean.getSubpassword());
		pst.setString(3, bean.getSeatgo());
		pst.setString(4, bean.getYeargo());
		pst.setString(5, bean.getGpago());
		pst.setString(6, bean.getUnitgo());
		
		val = pst.executeUpdate();		
		System.out.println("val in sub admin registration: " + val);		
		
	
		
		System.out.println("yes");
		val=10;
		return val;		
		
	}
}
