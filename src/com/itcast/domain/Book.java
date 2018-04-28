package com.itcast.domain;

import java.io.Serializable;

public class Book implements Serializable{
    private String id;//主键
    private String name;//书名
    private String author;//作者
    private float money;//单价
    private String description;//描述
    private String path;//存放文件的目录
    private String oldImageName;//原来文件名
    private String newImageName;//新文件名（保证文件不重名）
    private String categoryId;//记住所属类别的主键


    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getOldImageName() {
        return oldImageName;
    }

    public void setOldImageName(String oldImageName) {
        this.oldImageName = oldImageName;
    }

    public String getNewImageName() {
        return newImageName;
    }

    public void setNewImageName(String newImageName) {
        this.newImageName = newImageName;
    }


    public String getCategoryId() {
        return categoryId;
    }
}
