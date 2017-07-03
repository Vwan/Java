package com.rest.model;

import java.sql.SQLException;

import javax.xml.bind.annotation.XmlRootElement;

/*
 * Resource for error response, e.g Not Found
 */

@XmlRootElement
public class Custom {
    private String errorMsg;
    
    public Custom(){};
    public Custom(String  message)  {
        this.errorMsg=message;
    }
    
    public String getErrorMsg(){
    	return this.errorMsg;
    }
  
    public void setErrorMsg(String errorMsg){
    	this.errorMsg=errorMsg;
    }
    
}
