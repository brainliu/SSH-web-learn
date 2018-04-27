package com.itcast.domain;
import java.io.Serializable;
public class Category implements Serializable{
    private String name;
    private String id;
    private  String description;

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(String id) {
        this.id=id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
