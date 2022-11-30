package model;

import java.io.File;

public class HygieneTest {
	
	private int id;
	private int idPerson;
	private File document;
	
	public HygieneTest(int id, int idPerson, File document) {
		super();
		this.id = id;
		this.idPerson = idPerson;
		this.document = document;
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

	public File getDocument() {
		return document;
	}

	public void setDocument(File document) {
		this.document = document;
	}
	
}
