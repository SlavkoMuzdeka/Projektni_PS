package model;


public class Membership {
	
	private int id;
	private String serviceType;
	private int amount;
	private boolean paid;
	private String date;
	private String paymentDate;
	private String idChild;
	private Child child;

	
	public Membership(int id, String serviceType, int amount, boolean paid, String date,
			String paymentDate) {
		super();
		this.id = id;
		this.serviceType = serviceType;
		this.amount = amount;
		this.paid = paid;
		this.date = date;
		this.paymentDate = paymentDate;
	}
	
	public Membership() {
		super();
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getIdChild() {
		return idChild;
	}

	public void setIdChild(String idChild) {
		this.idChild = idChild;
	}

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}
	
}
