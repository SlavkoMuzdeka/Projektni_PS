package com.example.e_vrtic;

import java.util.Objects;

public class Person {
    private Integer id;
    private String name;
    private String parentName;
    private String surname;
    private Boolean isHere;

    public Person(Integer id, String name, String parentName, String surname, Boolean isHere) {
        super();
        this.id = id;
        this.name = name;
        this.parentName = parentName;
        this.surname = surname;
        this.isHere = isHere;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
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
        Person other = (Person) obj;
        return Objects.equals(isHere, other.isHere) && Objects.equals(name, other.name)
                && Objects.equals(parentName, other.parentName) && Objects.equals(surname, other.surname);
    }


    @Override
    public String toString() {
        return name + " (" + parentName + ") " + surname;
    }
}
