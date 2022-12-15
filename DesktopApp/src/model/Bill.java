package model;


public class Bill {
	
	private String billNumber;
	private String billType;
	private int amount;
	private String date;
	private boolean paid;
	private String kindergartenName;
	
	public Bill(String billNumber, String billType, int amount, String date, boolean paid,
			String kindergartenName) {
		super();
		this.billNumber = billNumber;
		this.billType = billType;
		this.amount = amount;
		this.date = date;
		this.paid = paid;
		this.kindergartenName = kindergartenName;
	}
	
	public Bill() {
		
	}

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public String getKindergartenName() {
		return kindergartenName;
	}

	public void setKindergartenName(String kindergartenName) {
		this.kindergartenName = kindergartenName;
	}
	
}
