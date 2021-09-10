package UnitGpa;

public class unitBean {
	String unit;
	double sgpa,hgpa;	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	int id;
	
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public unitBean(int id , String unit, double sgpa, double hgpa) {
		super();
		this.id= id;
		this.unit = unit;
		this.sgpa = sgpa;
		this.hgpa = hgpa;
	}
	public double getSgpa() {
		return sgpa;
	}
	public void setSgpa(double sgpa) {
		this.sgpa = sgpa;
	}
	public double getHgpa() {
		return hgpa;
	}
	public void setHgpa(double hgpa) {
		this.hgpa = hgpa;
	}
	public unitBean() {
		super();
	}
	
	
	

}
