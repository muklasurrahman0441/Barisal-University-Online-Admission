package AnalysisResult;

public class ResyltBean {
	
	String board;
	int id,count;
	String name,father,mother;
	double merit,g_total,mcq;
	String gender;
	
	
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public double getMerit() {
		return merit;
	}

	public void setMerit(double merit) {
		this.merit = merit;
	}

	public double getG_total() {
		return g_total;
	}

	public void setG_total(double g_total) {
		this.g_total = g_total;
	}

	public double getMcq() {
		return mcq;
	}

	public void setMcq(double mcq) {
		this.mcq = mcq;
	}

	public ResyltBean() {
		super();
	}

	
	public ResyltBean(int id, String board,  int count) {
		super();
		
		this.id = id;
		this.board = board;
		this.count = count;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getBoard() {
		return board;
	}
	public void setBoard(String board) {
		this.board = board;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
