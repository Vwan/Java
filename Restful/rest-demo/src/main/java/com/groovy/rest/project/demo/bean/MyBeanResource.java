package com.hp.rest.project.demo.bean;

import javax.ws.rs.BeanParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("myresources") 
public class MyBeanResource {

   @POST
   @Path("{id}")
   public void post(@BeanParam MyBean myBean) {}
 

   

 }
