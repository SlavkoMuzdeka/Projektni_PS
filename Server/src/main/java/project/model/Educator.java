package project.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Educator extends Person implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1596610363448810830L;
	private String username;
	private String password;
	private int plata;
	private LocalDate  selectionDate;
	private int idGroup;
	private MedicalClearance medicalClearance;
	private HygieneTest hygieneTest;

	public Educator() {
		super();
	}
	public Educator(String name, String surname, String uid, String dateOfBirth, String id, Address address,
			String username, String password, int plata) {
		super(name, surname, uid, dateOfBirth, id, address);
		this.username = username;
		this.password = password;
		this.plata = plata;
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

	public int getPlata() {
		return plata;
	}

	public void setPlata(int plata) {
		this.plata = plata;
	}

	public LocalDate getSelectionDate() {
		return selectionDate;
	}

	public void setSelectionDate(LocalDate selectionDate) {
		this.selectionDate = selectionDate;
	}

	public int getIdGroup() {
		return idGroup;
	}

	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}
	public MedicalClearance getMedicalClearance() {
		return medicalClearance;
	}
	public void setMedicalClearance(MedicalClearance medicalClearance) {
		this.medicalClearance = medicalClearance;
	}
	public HygieneTest getHygieneTest() {
		return hygieneTest;
	}
	public void setHygieneTest(HygieneTest hygieneTest) {
		this.hygieneTest = hygieneTest;
	}
	
	
}
