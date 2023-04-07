package com.latihanLsp.Model;

public class Category {
    private int id;
    private String name;
    private String Desc;

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public Category(String desc) {
        Desc = desc;
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category() {

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
}
