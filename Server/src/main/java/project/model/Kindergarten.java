package project.model;

import java.io.Serializable;

public class Kindergarten implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4283579465212782613L;
	private String name;
	private String phoneNumber;
	private Address address;
	
	public Kindergarten(String name, String phoneNumber, Address address) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}
