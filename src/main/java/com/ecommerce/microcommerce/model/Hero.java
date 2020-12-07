package com.ecommerce.microcommerce.model;

public class Hero {
    //state of an object
    protected int id;
    protected String name;
    protected String type;

    //constructor method
    public Hero() {

    }

    public Hero(int id,String name, String type ) {
        this.id=id;
        this.name = name;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
