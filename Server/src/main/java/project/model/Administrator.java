package project.model;

import java.time.LocalDate;

public class Administrator extends Person {
	
	private String username;
	private String password;
	
	public Administrator(String name, String surname, String uid, LocalDate dateOfBirth, String id, Address address,
			String username, String password) {
		super(name, surname, uid, dateOfBirth, id, address);
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
