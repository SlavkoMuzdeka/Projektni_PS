package net.etfbl.child.model;

import java.util.Objects;

public class Child {
	
	private String name;
	private String parentName;
	private String surname;
	private Boolean isHere;
	

	public Child(String name, String parentName, String surname, Boolean isHere) {
		super();
		this.name = name;
		this.parentName = parentName;
		this.surname = surname;
		this.isHere = isHere;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getParentName() {
		return parentName;
	}


	public void setParentName(String parentName) {
		this.parentName = parentName;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public Boolean getIsHere() {
		return isHere;
	}


	public void setIsHere(Boolean isHere) {
		this.isHere = isHere;
	}


	@Override
	public int hashCode() {
		return Objects.hash(isHere, name, parentName, surname);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Child other = (Child) obj;
		return Objects.equals(isHere, other.isHere) && Objects.equals(name, other.name)
				&& Objects.equals(parentName, other.parentName) && Objects.equals(surname, other.surname);
	}


	@Override
	public String toString() {
		return "Child [name=" + name + ", parentName=" + parentName + ", surname=" + surname + ", isHere=" + isHere
				+ "]";
	}


}
