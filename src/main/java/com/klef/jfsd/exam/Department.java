package com.klef.jfsd.exam;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "dname", length = 100, nullable = false)
    private String name;

    @Column(name = "location", length = 100, nullable = false)
    private String location;

    @Column(name = "hodname", length = 100, nullable = false)
    private String hodName;

    // Getters and Setters
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHodName() {
        return hodName;
    }

    public void setHodName(String hodName) {
        this.hodName = hodName;
    }

    // toString Method
    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + ", location=" + location + ", hodName=" + hodName + "]";
    }
}
