package stuper;

public class subBean {
	String apply,payment,seatplan,admitcard,result;
	int id,loginper;
	
	
	public subBean() {
		super();
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLoginper() {
		return loginper;
	}

	public void setLoginper(int loginper) {
		this.loginper = loginper;
	}
}
