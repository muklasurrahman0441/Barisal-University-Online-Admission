package subadmin;

public class subBean {
	
	int id,loginper;
	String subuser,subpassword,seatgo,yeargo,gpago,unitgo;
	
	
	
	String apply,payment,seatplan,admitcard,result;
	
	


	public int getLoginper() {
		return loginper;
	}



	public void setLoginper(int loginper) {
		this.loginper = loginper;
	}



	public subBean() {
		super();
	}
	
	
	/// result start
	int roll,roll1,serial,serial1;
	String board,ssc_letter,hsc_letter,dob,group,name,father,mother,gender,quota,set,rem,status;
	double ssc_rgpa,hsc_rgpa,ssc_gpa,hsc_gpa,ssc_per,hsc_per,per_tot;
	double ban,eng,phy,che,mat,bio,ict,mcq,g_total,merit;
	double ban_c,ban_w,eng_c,eng_w,phy_c,phy_w,che_c,che_w,mat_c,mat_w,bio_c,bio_w;
	double ict_c,ict_w,tot_c,tot_w,tot_gp,hsc_phy,hsc_che,hsc_mat,hsc_bio;
	
	
	
	
	public double getTot_gp() {
		return tot_gp;
	}



	public void setTot_gp(double tot_gp) {
		this.tot_gp = tot_gp;
	}



	public subBean(String board2, String group2, int sscroll, int hscroll, String name2,double  ssc_per,double hsc_per ,double  ban,double eng ,double phy,double che,double mat,double bio,double ict,double mcq,double g_total,double merit,String status ) {
	   
																																this.board = board2;
																																this.group = group2;
																																this.roll1 = sscroll;
																																this.serial1 = hscroll;
																																this.name = name2;
																																this.ssc_per=ssc_per;
																																this.hsc_per = hsc_per;
																																this.ban=ban;
																																this.eng=eng;
																																this.phy=phy;
																																this.che = che;
																																this.mat=mat;
																																this.ict=ict;
																																this.mcq =mcq;
																																this.g_total=g_total;
																																this.merit=merit;
																																this.status=status;
	}
	
	
	
	public String getRem() {
		return rem;
	}
	public void setRem(String rem) {
		this.rem = rem;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getIct_c() {
		return ict_c;
	}
	public void setIct_c(double ict_c) {
		this.ict_c = ict_c;
	}
	public double getIct_w() {
		return ict_w;
	}
	public void setIct_w(double ict_w) {
		this.ict_w = ict_w;
	}
	public double getTot_c() {
		return tot_c;
	}
	public void setTot_c(double tot_c) {
		this.tot_c = tot_c;
	}
	public double getTot_w() {
		return tot_w;
	}
	public void setTot_w(double tot_w) {
		this.tot_w = tot_w;
	}
	public double getHsc_phy() {
		return hsc_phy;
	}
	public void setHsc_phy(double hsc_phy) {
		this.hsc_phy = hsc_phy;
	}
	public double getHsc_che() {
		return hsc_che;
	}
	public void setHsc_che(double hsc_che) {
		this.hsc_che = hsc_che;
	}
	public double getHsc_mat() {
		return hsc_mat;
	}
	public void setHsc_mat(double hsc_mat) {
		this.hsc_mat = hsc_mat;
	}
	public double getHsc_bio() {
		return hsc_bio;
	}
	public void setHsc_bio(double hsc_bio) {
		this.hsc_bio = hsc_bio;
	}
	public String getSet() {
		return set;
	}
	public void setSet(String set) {
		this.set = set;
	}
	public double getBan_c() {
		return ban_c;
	}
	public void setBan_c(double ban_c) {
		this.ban_c = ban_c;
	}
	public double getBan_w() {
		return ban_w;
	}
	public void setBan_w(double ban_w) {
		this.ban_w = ban_w;
	}
	public double getEng_c() {
		return eng_c;
	}
	public void setEng_c(double eng_c) {
		this.eng_c = eng_c;
	}
	public double getEng_w() {
		return eng_w;
	}
	public void setEng_w(double eng_w) {
		this.eng_w = eng_w;
	}
	public double getPhy_c() {
		return phy_c;
	}
	public void setPhy_c(double phy_c) {
		this.phy_c = phy_c;
	}
	public double getPhy_w() {
		return phy_w;
	}
	public void setPhy_w(double phy_w) {
		this.phy_w = phy_w;
	}
	public double getChe_c() {
		return che_c;
	}
	public void setChe_c(double che_c) {
		this.che_c = che_c;
	}
	public double getChe_w() {
		return che_w;
	}
	public void setChe_w(double che_w) {
		this.che_w = che_w;
	}
	public double getMat_c() {
		return mat_c;
	}
	public void setMat_c(double mat_c) {
		this.mat_c = mat_c;
	}
	public double getMat_w() {
		return mat_w;
	}
	public void setMat_w(double mat_w) {
		this.mat_w = mat_w;
	}
	public double getBio_c() {
		return bio_c;
	}
	public void setBio_c(double bio_c) {
		this.bio_c = bio_c;
	}
	public double getBio_w() {
		return bio_w;
	}
	public void setBio_w(double bio_w) {
		this.bio_w = bio_w;
	}
	public double getBan() {
		return ban;
	}
	public void setBan(double ban) {
		this.ban = ban;
	}
	public double getEng() {
		return eng;
	}
	public void setEng(double eng) {
		this.eng = eng;
	}
	public double getPhy() {
		return phy;
	}
	public void setPhy(double phy) {
		this.phy = phy;
	}
	public double getChe() {
		return che;
	}
	public void setChe(double che) {
		this.che = che;
	}
	public double getMat() {
		return mat;
	}
	public void setMat(double mat) {
		this.mat = mat;
	}
	public double getBio() {
		return bio;
	}
	public void setBio(double bio) {
		this.bio = bio;
	}
	public double getIct() {
		return ict;
	}
	public void setIct(double ict) {
		this.ict = ict;
	}
	public double getMcq() {
		return mcq;
	}
	public void setMcq(double mcq) {
		this.mcq = mcq;
	}
	public double getG_total() {
		return g_total;
	}
	public void setG_total(double g_total) {
		this.g_total = g_total;
	}
	public double getMerit() {
		return merit;
	}
	public void setMerit(double merit) {
		this.merit = merit;
	}
	public double getSsc_rgpa() {
		return ssc_rgpa;
	}
	public void setSsc_rgpa(double ssc_rgpa) {
		this.ssc_rgpa = ssc_rgpa;
	}
	public double getHsc_rgpa() {
		return hsc_rgpa;
	}
	public void setHsc_rgpa(double hsc_rgpa) {
		this.hsc_rgpa = hsc_rgpa;
	}
	public double getSsc_gpa() {
		return ssc_gpa;
	}
	public void setSsc_gpa(double ssc_gpa) {
		this.ssc_gpa = ssc_gpa;
	}
	public double getHsc_gpa() {
		return hsc_gpa;
	}
	public void setHsc_gpa(double hsc_gpa) {
		this.hsc_gpa = hsc_gpa;
	}
	public double getSsc_per() {
		return ssc_per;
	}
	public void setSsc_per(double ssc_per) {
		this.ssc_per = ssc_per;
	}
	public double getHsc_per() {
		return hsc_per;
	}
	public void setHsc_per(double hsc_per) {
		this.hsc_per = hsc_per;
	}
	public double getPer_tot() {
		return per_tot;
	}
	public void setPer_tot(double per_tot) {
		this.per_tot = per_tot;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFather() {
		return father;
	}
	public void setFather(String father) {
		this.father = father;
	}
	public String getMother() {
		return mother;
	}
	public void setMother(String mother) {
		this.mother = mother;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getQuota() {
		return quota;
	}
	public void setQuota(String quota) {
		this.quota = quota;
	}
	public int getSerial() {
		return serial;
	}
	public void setSerial(int serial) {
		this.serial = serial;
	}
	public int getSerial1() {
		return serial1;
	}
	public void setSerial1(int serial1) {
		this.serial1 = serial1;
	}



	
	
	
	
	
	
	public String getBoard() {
		return board;
	}
	public void setBoard(String board) {
		this.board = board;
	}
	public String getSsc_letter() {
		return ssc_letter;
	}
	public void setSsc_letter(String ssc_letter) {
		this.ssc_letter = ssc_letter;
	}
	public String getHsc_letter() {
		return hsc_letter;
	}
	public void setHsc_letter(String hsc_letter) {
		this.hsc_letter = hsc_letter;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public int getRoll1() {
		return roll1;
	}
	public void setRoll1(int roll1) {
		this.roll1 = roll1;
	}
	public String getApply() {
		return apply;
	}
	public void setApply(String apply) {
		this.apply = apply;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getSeatplan() {
		return seatplan;
	}
	public void setSeatplan(String seatplan) {
		this.seatplan = seatplan;
	}
	public String getAdmitcard() {
		return admitcard;
	}
	public void setAdmitcard(String admitcard) {
		this.admitcard = admitcard;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	
	//// result end
	

	
	
	
	
	
	






	public subBean(int id, String subuser, String subpassword, String seatgo, String yeargo, String gpago,String unitgo) {
		super();
		this.id = id;
		this.subuser = subuser;
		this.subpassword = subpassword;
		this.seatgo = seatgo;
		this.yeargo = yeargo;
		this.gpago = gpago;
		this.unitgo = unitgo;
	}
	
	
	
	public subBean(int id, String apply, int loginper,  String payment, String seatplan, String admitcard, String result) {
		super();
		this.id = id;
		this.apply = apply;
		this.loginper = loginper;
		this.payment = payment;
		this.seatplan = seatplan;
		this.admitcard = admitcard;
		this.result = result;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubuser() {
		return subuser;
	}
	public void setSubuser(String subuser) {
		this.subuser = subuser;
	}
	public String getSubpassword() {
		return subpassword;
	}
	public void setSubpassword(String subpassword) {
		this.subpassword = subpassword;
	}
	public String getSeatgo() {
		return seatgo;
	}
	public void setSeatgo(String seatgo) {
		this.seatgo = seatgo;
	}
	public String getYeargo() {
		return yeargo;
	}
	public void setYeargo(String yeargo) {
		this.yeargo = yeargo;
	}
	public String getGpago() {
		return gpago;
	}
	public void setGpago(String gpago) {
		this.gpago = gpago;
	}
	public String getUnitgo() {
		return unitgo;
	}
	public void setUnitgo(String unitgo) {
		this.unitgo = unitgo;
	}

}
