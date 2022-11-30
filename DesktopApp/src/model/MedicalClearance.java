package model;

import java.io.File;

public class MedicalClearance {

	private int id;
	private int idPerson;
	private byte[] file;
	
	public MedicalClearance(int id, int idPerson, byte[] file) {
		super();
		this.id = id;
		this.idPerson = idPerson;
		this.file = file;
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
