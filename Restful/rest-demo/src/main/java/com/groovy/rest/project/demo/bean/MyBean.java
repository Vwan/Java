package com.hp.rest.project.demo.bean;

import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PathParam;

public class MyBean {  

	   @FormParam("myData")
	   private String data;
	   @HeaderParam("myHeader")
	   private String header;
	   @PathParam("id")
	   public void setResourceId(String id) {}


	}