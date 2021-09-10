package subadmin;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;



public class resultModel {

	subBean u = new  subBean();
	
	public int insert_csv(BufferedReader bufferedReader) throws SQLException
	{
		
		int val = 0;
		
		try {
			String line="";
			while ((line=bufferedReader.readLine())!=null)
			{
				String[] values=line.trim().split(",");
				
				      String board = values[0];				  
				      String ssc_letter =values[1];
				 	  String hsc_letter =values[2] ;
					  String dob = values[3];
					  String group = values[4];
				   	  int roll = Integer.parseInt(values[5]);
					  int roll1 = Integer.parseInt(values[6]);
					  
					  
					  u.setBoard(board);
					  u.setSsc_letter(ssc_letter);
					  u.setHsc_letter(hsc_letter);
					  u.setDob(dob);
					  u.setGroup(group);
					  u.setRoll(roll);
					  u.setRoll1(roll1);
					  
					  
					  int serial  = Integer.parseInt(values[7]);
					  int serial1 = Integer.parseInt(values[8]);					  
					  String name = values[9];				  
				      String father =values[10];
				 	  String mother =values[11] ;
					  String gender = values[12];
					  String quota = values[13];
					  
					  
					  u.setSerial(serial);
					  u.setSerial1(serial1);
					  u.setName(name);
					  u.setFather(father);
					  u.setMother(mother);
					  u.setGender(gender);
					  u.setQuota(quota);
					  
					  
					  
					  double ssc_rgpa = Double.parseDouble(values[14]);
					  double hsc_rgpa = Double.parseDouble(values[15]);
					  double ssc_gpa = Double.parseDouble(values[16]);
					  double hsc_gpa = Double.parseDouble(values[17]);
					  double ssc_per = Double.parseDouble(values[18]);
					  double hsc_per = Double.parseDouble(values[19]);
					  double per_tot = Double.parseDouble(values[20]);
					
					
					  
					  u.setSsc_rgpa(ssc_rgpa);
					  u.setHsc_rgpa(hsc_rgpa);
					  u.setSsc_gpa(ssc_gpa);
					  u.setHsc_gpa(hsc_gpa);
					  u.setSsc_per(ssc_per);
					  u.setHsc_per(hsc_per);
					  u.setPer_tot(per_tot);
					  
					  
					  double ban = Double.parseDouble(values[21]);
					  double  eng= Double.parseDouble(values[22]);
					  double  phy= Double.parseDouble(values[23]);
					  double  che= Double.parseDouble(values[24]);
					  double  mat= Double.parseDouble(values[25]);
					  double  bio= Double.parseDouble(values[26]);
					  double  ict= Double.parseDouble(values[27]);
					  double  mcq= Double.parseDouble(values[28]);
					  double  g_total= Double.parseDouble(values[29]);
					  double  merit= Double.parseDouble(values[30]);
					  
					  u.setBan(ban);
					  u.setEng(eng);
					  u.setPhy(phy);
					  u.setChe(che);
					  u.setMat(mat);
					  u.setBio(bio);
					  u.setIct(ict);
					  u.setMcq(mcq);
					  u.setG_total(g_total);
					  u.setMerit(merit);
					  
					  
					  String  set= values[31];	
					  double  ban_c= Double.parseDouble(values[32]);
					  double  ban_w= Double.parseDouble(values[33]);
					  double  eng_c= Double.parseDouble(values[34]);
					  double  eng_w= Double.parseDouble(values[35]);
					  double  phy_c= Double.parseDouble(values[36]);
					  double  phy_w= Double.parseDouble(values[37]);
					  double  che_c= Double.parseDouble(values[38]);
					  double  che_w= Double.parseDouble(values[39]);
					  double  mat_c= Double.parseDouble(values[40]);
					  double  mat_w= Double.parseDouble(values[41]);
					  double  bio_c= Double.parseDouble(values[42]);
					  double  bio_w= Double.parseDouble(values[43]);
					  
				
					
					  u.setSet(set);
					  u.setBan_c(ban_c);
					  u.setBan_w(ban_w);
					  u.setEng_c(eng_c);
					  u.setEng_w(eng_w);
					  u.setPhy_c(phy_c);
					  u.setPhy_w(phy_w);
					  u.setChe_c(che_c);
					  u.setChe_w(che_w);
					  u.setMat_c(mat_c);
					  u.setMat_w(mat_w);
					  u.setBio_c(bio_c);
					  u.setBio_w(bio_w);
					  
						System.out.println("bio_c " + bio_c+ "bio_w " + bio_w);
					  
					  double  ict_c= Double.parseDouble(values[44]);
					  double  ict_w= Double.parseDouble(values[45]);
					  double  tot_c= Double.parseDouble(values[46]);
					  double  tot_w= Double.parseDouble(values[47]);
					  
					  double  tot_gp= Double.parseDouble(values[48]);
					  
					  double  hsc_phy= Double.parseDouble(values[49]);
					  double  hsc_che= Double.parseDouble(values[50]);
					  double  hsc_mat= Double.parseDouble(values[51]);
					  double  hsc_bio= Double.parseDouble(values[52]);
					 
					System.out.println("\ntot_w " +tot_w+"hsc_phy"+hsc_phy);
					  
					  
					  u.setIct_c(ict_c);
					  u.setIct_w(ict_w);
					  u.setTot_c(tot_c);
					  u.setTot_w(tot_w);
					  u.setTot_gp(tot_gp);
					  u.setHsc_phy(hsc_phy);
					  u.setHsc_che(hsc_che);
					  u.setHsc_mat(hsc_mat);
					  u.setHsc_bio(hsc_bio);
					  
					
					  String  rem= values[53];						
					  String  status= values[54];	
					 
					  System.out.println("\nhsc_mat"+hsc_mat+"hsc_bio"+hsc_bio+"rem "+rem + "status " + status);
					  
					  u.setRem(rem);
					  u.setStatus(status);
					
					  
					  
					
					  System.out.print(board+"**"+ssc_letter+"**"+hsc_letter+"**"+dob+"**"+group+"**"+roll+"**"+roll1+"**"+serial +"**"+serial1+"**"+name+"**"+father+"**"+mother+"**"+gender+""+quota  
							+"ssc_rgpa "+ ssc_rgpa+"hsc_rgpa "+hsc_rgpa +" ssc_gpa"+ ssc_gpa+"hsc_gpa "+hsc_gpa +" ssc_per"+ ssc_per+"hsc_per "+ hsc_per+" per_tot"+ per_tot
							+"ban "+ban +"eng"+eng +"phy "+phy +"che "+che  +"mat "+mat  +" bio"+ bio +" ict"+ict +"mcq "+mcq+"g_total "+ g_total +" merit"+merit   + "rem "
							  );
					  
						System.out.println("\nrem "+rem + "status " + status);
					
					  ConnectionClass obj = new ConnectionClass();
				      Connection con = (Connection) obj.createConnection();
				      
				      PreparedStatement ps = (PreparedStatement) con.prepareStatement(" INSERT INTO `result` (`board`, `ssc_letter`, `hsc_letter`, `dob`, `group`, `roll`, `roll1`, `serial`, `serial1`, `name`, `father`, `mother`, `gender`, `quota`, `ssc_rgpa`, `hsc_rgpa`, `ssc_gpa`, `hsc_gpa`, `ssc_per`, `hsc_per`, `per_tot`, `ban`, `eng`, `phy`, `che`, `mat`, `bio`, `ict`, `mcq`, `g_total`, `merit`, `set`, `ban_c`, `ban_w`, `eng_c`, `eng_w`, `phy_c`, `phy_w`, `che_c`, `che_w`, `mat_c`, `mat_w`, `bio_c`, `bio_w`, `ict_c`, `ict_w`, `tot_c`, `tot_w` , `tot_gp`, `hsc_phy`, `hsc_che`, `hsc_mat`, `hsc_bio`, `rem`, `status` ) VALUES (?, ?, ?,?, ?,?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,?,?,?,?,?,?,?,? ,?,?,?)");
						
				      
					  	ps.setString(1,u.getBoard());
					  	ps.setString(2,u.getSsc_letter());
					  	ps.setString(3,u.getHsc_letter());
					  	ps.setString(4,u.getDob());
					  	ps.setString(5,u.getGroup());					  	
					  	ps.setInt(6,u.getRoll());
					  	ps.setInt(7,u.getRoll1());
					  	
					  	ps.setInt(8, u.getSerial());
					  	ps.setInt(9, u.getSerial1());
					  	ps.setString(10, u.getName());
					  	ps.setString(11, u.getFather());
					  	ps.setString(12, u.getMother());
					  	ps.setString(13, u.getGender());
					  	ps.setString(14, u.getQuota());
					  	
					    ps.setDouble(15, u.getSsc_rgpa());
					    ps.setDouble(16, u.getHsc_rgpa());
					    ps.setDouble(17, u.getSsc_gpa());
					    ps.setDouble(18, u.getHsc_gpa());
					    ps.setDouble(19, u.getSsc_per());
					    ps.setDouble(20, u.getHsc_per());
					    ps.setDouble(21, u.getPer_tot());
					    
					    ps.setDouble(22, u.getBan());
					    ps.setDouble(23, u.getEng());
					    ps.setDouble(24, u.getPhy());
					    ps.setDouble(25, u.getChe());
					    ps.setDouble(26, u.getMat());
					    ps.setDouble(27, u.getBio());
					    ps.setDouble(28, u.getIct());
					    ps.setDouble(29, u.getMcq());
					    ps.setDouble(30, u.getG_total());
					    ps.setDouble(31, u.getMerit());
					    
					    ps.setString(32, u.getSet());
					    
					    ps.setDouble(33, u.getBan_c() );
					    ps.setDouble(34, u.getBan_w() );
					  
					    ps.setDouble(35, u.getEng_c() );
					    ps.setDouble(36, u.getEng_w() );
					    ps.setDouble(37, u.getPhy_c() );
					    ps.setDouble(38, u.getPhy_w() );
					    ps.setDouble(39, u.getChe_c() );
					    ps.setDouble(40, u.getChe_w() );
					    ps.setDouble(41, u.getMat_c() );
					    ps.setDouble(42, u.getMat_w() );
					    ps.setDouble(43, u.getBio_c() );
					    ps.setDouble(44, u.getBio_w() );
					    
					   
					    ps.setDouble(45, u.getIct_c()  );
					    ps.setDouble(46, u.getIct_w()  );
					    ps.setDouble(47, u.getTot_c()  );
					    ps.setDouble(48, u.getTot_w()  );
					    ps.setDouble(49, u.getTot_gp() );
					    
					    
					    ps.setDouble(50, u.getHsc_phy()  );
					    
					    ps.setDouble(51, u.getHsc_che()  );
					    ps.setDouble(52, u.getHsc_mat()  );
					    ps.setDouble(53, u.getHsc_bio()  );
					    
					    
					    
					    ps.setString(54, u.getRem());
					    ps.setString(55, u.getStatus() );
					    
					   
					  
					  	
					     ps.executeUpdate();
					     System.out.println("inserted result as csv ");
					     val=20;
					 	System.out.println("val :"+val);
					    }
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		
		
		
		
		
		
		return val;
		
		
	}
	
	
	
}
