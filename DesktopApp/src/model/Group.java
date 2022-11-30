package model;

import java.util.ArrayList;

public class Group {
	
	private int id;
	private String name;
	private int numberOfMembers;
	private ArrayList<Child> children= new ArrayList<>();
	private ArrayList<Educator> educators= new ArrayList<>();
	private ArrayList<Activity> activities= new ArrayList<>();
	
	public Group(int id, String name, int numberOfMembers, ArrayList<Child> children, ArrayList<Educator> educators,
			ArrayList<Activity> activities) {
		super();
		this.id = id;
		this.name = name;
		this.numberOfMembers = numberOfMembers;
		this.children = children;
		this.educators = educators;
		this.activities = activities;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfMembers() {
		return numberOfMembers;
	}

	public void setNumberOfMembers(int numberOfMembers) {
		this.numberOfMembers = numberOfMembers;
	}

	public ArrayList<Child> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<Child> children) {
		this.children = children;
	}

	public ArrayList<Educator> getEducators() {
		return educators;
	}

	public void setEducators(ArrayList<Educator> educators) {
		this.educators = educators;
	}

	public ArrayList<Activity> getActivities() {
		return activities;
	}

	public void setActivities(ArrayList<Activity> activities) {
		this.activities = activities;
	}
	
}
