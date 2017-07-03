package com.rest.model;

import java.sql.SQLException;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Product {

    private Integer id;
    private String name;
    private Integer projid;
    @XmlTransient
    private String notused;

    public Product(Integer id,String name,  Integer projid) throws SQLException {
        this.id = id;
        this.name = name;
        this.projid=projid;
    }

    // empty constructor needed for deserialization by JAXB
    public Product() {
    }
  
    public Integer getId(){
    	return this.id;
    }
    
    public String getName(){
    	return this.name;
    }
    
    public Integer getProjectID(){
    	return this.projid;
    }
    
    public void setId(Integer id){
    	this.id=id;
    }
    
    public void setName(String name){
    	this.name=name;
    }
    
    public void setDescription(Integer projid){
    	this.projid=projid;
    }
  
    public String toString() {
        return "Project{" +
            "name='" + name + '\'' +
            ", id=" + id +
            ", projid=" + projid +
            '}';
    }
}
