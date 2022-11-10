package com.example.e_vrtic;

import java.util.Date;

public class Person {

    private Integer id;
    private String name;
    private Boolean isPresent;
    private Date date;

    public Person(Integer id, String name, Boolean isPresent, Date date) {
        this.id = id;
        this.name = name;
        this.isPresent = isPresent;
        this.date = date;
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

    public Boolean getPresent() {
        return isPresent;
    }

    public void setPresent(Boolean present) {
        isPresent = present;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isPresent=" + isPresent +
                ", date=" + date +
                '}';
    }
}
