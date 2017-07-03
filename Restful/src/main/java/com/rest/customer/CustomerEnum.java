package com.rest.customer;

import java.util.HashMap;
import java.util.Map;

public enum CustomerEnum {
	  
	instance  ;
	private Map<String, Customer> contentProvider = new HashMap<String,Customer>();
	  
	  private CustomerEnum() {
	    
		  Customer customer = new Customer("1", "vivian","wan");
	//	  customer.setDescription("Read http://www.vogella.com/tutorials/REST/article.html");
	    contentProvider.put("1", customer);
	     customer = new Customer("2", "helen","shi");
	    contentProvider.put("2", customer);
	    
	  }
	  public Map<String, Customer> getModel(){
	    return contentProvider;
	  }
	  
}
