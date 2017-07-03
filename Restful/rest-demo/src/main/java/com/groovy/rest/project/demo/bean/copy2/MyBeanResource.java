package com.hp.rest.project.demo.bean.copy2;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("myresources") 
public class MyBeanResource {

   @GET
   @Path("{id}")
   public void get(@BeanParam MyBean myBean) {}
 

   

 }
