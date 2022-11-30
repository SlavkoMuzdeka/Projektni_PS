package model;

import java.time.LocalDate;

public class Membership {
	
	private int id;
	private String serviceType;
	private int amount;
	private boolean paid;
	private LocalDate date;
	private int idChild;
	private LocalDate paymentDate;
	
	public Membership(int id, String serviceType, int amount, boolean paid, LocalDate date, int idChild,
			LocalDate paymentDate) {
		super();
		this.id = id;
		this.serviceType = serviceType;
		this.amount = amount;
		this.paid = paid;
		this.date = date;
		this.idChild = idChild;
		this.paymentDate = paymentDate;
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getIdChild() {
		return idChild;
	}

	public void setIdChild(int idChild) {
		this.idChild = idChild;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	
}
