package com.example.e_vrtic.model;

import java.time.LocalDateTime;

public class ArrivalAndDeparatureTime {
	
	private String id;
	private String idChild;
	private LocalDateTime recordedTime;
	private boolean type;
	
	public ArrivalAndDeparatureTime(String id, String idChild, LocalDateTime recordedTime, boolean type) {
		super();
		this.id = id;
		this.idChild = idChild;
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

	public LocalDateTime getRecordedTime() {
		return recordedTime;
	}

	public void setRecordedTime(LocalDateTime recordedTime) {
		this.recordedTime = recordedTime;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}
}
