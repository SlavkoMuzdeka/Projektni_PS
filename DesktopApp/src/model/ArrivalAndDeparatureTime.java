package model;


public class ArrivalAndDeparatureTime {
	
	private String id;
	private String idChild;
	private String recordedTime;
	private boolean type;
	
	public ArrivalAndDeparatureTime(String recordedTime, boolean type) {
		super();	
		this.recordedTime = recordedTime;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdChild() {
		return idChild;
	}

	public void setIdChild(String idChild) {
		this.idChild = idChild;
	}

	public String getRecordedTime() {
		return recordedTime;
	}

	public void setRecordedTime(String recordedTime) {
		this.recordedTime = recordedTime;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}
}
