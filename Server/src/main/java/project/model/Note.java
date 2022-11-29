package project.model;

public class Note {
	
	private int id;
	private int idChild;
	private String description;
	
	
	public Note(int id, int idChild, String description) {
		super();
		this.id = id;
		this.idChild = idChild;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdChild() {
		return idChild;
	}
	public void setIdChild(int idChild) {
		this.idChild = idChild;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
