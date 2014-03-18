package jp.co.worksap.intern.Entity;

public class FinancialApplication {
	private String date;
	private String type;
	private String status;
	private String applicant;
	private String manager;
	private String accountant;
	private String amount;
	private String title;
	private String detail;

	public String GetDate() {
		return date;
	}
	
	public String GetType() {
		return type;
	}

	public String GetStatus() {
		return status;
	}

	public String GetApplicant() {
		return applicant;
	}

	public String GetManager() {
		return manager;
	}

	public String GetAccountant() {
		return accountant;
	}

	public String GetAmount() {
		return amount;
	}

	public String GetTitle() {
		return title;
	}
	
	public String GetDetail() {
		return detail;
	}
	
	public void SetDate(String sdate) {
		date = sdate;
	}
	
	public void SetType(String stype) {
		type = stype;
	}

	public void SetStatus(String sstatus) {
		status = sstatus;
	}

	public void SetApplicant(String sapplicant) {
		applicant = sapplicant;
	}

	public void SetManager(String smanager) {
		manager = smanager;
	}

	public void SetAccountant(String saccountant) {
		accountant = saccountant;
	}

	public void SetAmount(String samount) {
		amount = samount;
	}

	public void SetTitle(String stitle) {
		title = stitle;
	}
	
	public void SetDetail(String sdetail) {
		detail = sdetail;
	}
}
