package com.ecommerce.microcommerce.model;

public class Personnage {
    //state of an object
    protected int id;
    protected String name;
    protected String type;

    //constructor method
    public Personnage() {

    }



    public Personnage(int id) {
        this.id=id;
        int chance=(int) (Math.random() * 2);
        this.type=(chance==0)?"Guerrier":"Magicien";
        this.name=type+"_"+id;
    }

    public Personnage(int id, String name, String type ) {
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
