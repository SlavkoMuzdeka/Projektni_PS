package project.model;

import java.io.File;
import java.io.Serializable;

public class HygieneTest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7293896044464782702L;
	private int id;
	private int idPerson;
	private File document;
	private byte[] data;
	
	public HygieneTest(int id, int idPerson, File document) {
		super();
		this.id = id;
		this.idPerson = idPerson;
		this.document = document;
	}
	
	public HygieneTest() {
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

	public File getDocument() {
		return document;
	}

	public void setDocument(File document) {
		this.document = document;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
	
	
	
}
