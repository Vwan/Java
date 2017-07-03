package com.rest.resource;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Contact {
	private String id;
	private String name;
	//private List<Address> addresses;
	
	public Contact() {}
	
	public Contact(String id, String name){//}, List<Address> addresses) {
		this.id = id;
		this.name = name;
	//	this.addresses = addresses;
	}

/*	@XmlElement(name="address")
	public List<Address> getAddresses() {
		return addresses;
	}
*/
	/*public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}*/
	// Omit other getters and setters
}               
