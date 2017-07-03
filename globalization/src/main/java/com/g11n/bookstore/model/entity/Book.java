package com.g11n.bookstore.model.entity;

/**
 * Created by Administrator on 16-5-3.
 */
public class Book implements java.io.Serializable{
    private int id;
    private String name;

    public Book(int id,String name){
        this.id=id;
        this.name=name;
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

