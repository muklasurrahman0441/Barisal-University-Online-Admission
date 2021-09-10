package admin;

public class adminBean {

	String adminselect;
	
	int id;
	String superuser,superpassword;
	
	
	public adminBean() {
		super();
	}
	
	public adminBean(int id, String superuser, String superpassword) {
		super();
		this.id = id;
		this.superuser = superuser;
		this.superpassword = superpassword;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSuperuser() {
		return superuser;
	}

	public void setSuperuser(String superuser) {
		this.superuser = superuser;
	}

	public String getSuperpassword() {
		return superpassword;
	}

	public void setSuperpassword(String superpassword) {
		this.superpassword = superpassword;
	}

	public String getAdminselect() {
		return adminselect;
	}

	public void setAdminselect(String adminselect) {
		this.adminselect = adminselect;
	}
	
	
	
}
