package com.rest.model;

import java.sql.SQLException;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@XmlRootElement
public class Project {

    private Integer id;
    private String name;
    private String description;
    
    private String uri;

	@XmlTransient
    private List<Product> product;

    public Project(Integer id,String name,  String description) throws SQLException {
        this.id = id;
        this.name = name;
        this.description=description;
        
    }
    
    public Project(Integer id,String name,  String description, List<Product> product) throws SQLException {
        this.id = id;
        this.name = name;
        this.description=description;
        this.product=product;
    }

    // empty constructor needed for deserialization by JAXB
    public Project() {
    }
  
    public Integer getId(){
    	return this.id;
    }
    
    public String getName(){
    	return this.name;
    }
    
    public String getDescription(){
    	return this.description;
    }
    
    public void setId(Integer id){
    	this.id=id;
    }
    
    public void setName(String name){
    	this.name=name;
    }
    
    public void setDescription(String description){
    	this.description=description;
    }
    
    
    public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@XmlAttribute(name="href")
    public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
	
	@Override
    public String toString() {
        return "Project{" +
            "name='" + name + '\'' +
            ", id=" + id +
            ", description=" + description +
            '}';
    }
}
