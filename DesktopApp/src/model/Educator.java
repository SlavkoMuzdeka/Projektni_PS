package model;

public class Educator extends Person {
	
	private String username;
	private String password;
	private int salary;
	private String selectionDate;
	private int idGroup;

	public Educator(String name, String surname, String uid, String dateOfBirth, String id, Address address,
			String username, String password, int salary) {
		super(name, surname, uid, dateOfBirth, id, address);
		this.username = username;
		this.password = password;
		this.salary = salary;
	}
	
	public Educator() {
		super();
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getSelectionDate() {
		return selectionDate;
	}

	public void setSelectionDate(String selectionDate) {
		this.selectionDate = selectionDate;
	}

	public int getIdGroup() {
		return idGroup;
	}

	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}
	
	
}
