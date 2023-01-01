package project.model;

import java.io.Serializable;

public class MedicalClearance implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5174413934120515312L;
	private int id;
	private int idPerson;
	private byte[] file;

	public MedicalClearance(int id, int idPerson, byte[] file) {
		super();
		this.id = id;
		this.idPerson = idPerson;
		this.file = file;
	}

	public MedicalClearance() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

}
