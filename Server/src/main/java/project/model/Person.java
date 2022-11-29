package project.model;

import java.time.LocalDate;

public class Person {
	
	private String name;
	private String surname;
	private String uid;
	private LocalDate dateOfBirth;
	private String id; 
	private Address address;
	
	public Person(String name, String surname, String uid, LocalDate dateOfBirth, String id, Address address) {
		super();
		this.name = name;
		this.surname = surname;
		this.uid = uid;
		this.dateOfBirth = dateOfBirth;
		this.id = id;
		this.address = address;
	}
	
	public Person() {
		
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
}
