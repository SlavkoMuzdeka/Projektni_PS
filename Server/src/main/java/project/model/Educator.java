package project.model;

public class Educator extends Person {
	
	private String username;
	private String password;
	private int idGroup;

	public Educator() {
		super();
	}
	public Educator(String name, String surname, String uid, String dateOfBirth, String id, Address address,
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

	public int getIdGroup() {
		return idGroup;
	}

	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}
	
	
}
