package model;

public class Address {
	
	private int idAddress;
	private String street;
	private String city;
	private String number;

	public Address( String city, String street, String number) {
		super();
		this.street = street;
		this.city = city;
		this.number = number;
	}
	
	

	public Address() {
		super();
	}



	public int getIdAddress() {
		return idAddress;
	}

	public void setIdAddress(int idAddress) {
		this.idAddress = idAddress;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	
}
