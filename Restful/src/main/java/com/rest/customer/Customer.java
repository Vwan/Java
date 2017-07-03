package com.rest.customer;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {

	private String ID;
	private String firstName;
	private String lastName;
	
	public Customer(){}
	public Customer (String ID,String firstName,String lastName){
		this.ID=ID;
		this.firstName=firstName;
		this.lastName=lastName;
	}
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public String setFirstName(String firstName){
		return this.firstName=firstName;
	}
	public String setLastName(String lastName){
		return this.lastName=lastName;
	
}
	public String getId() {
		return this.ID;
	}
}

