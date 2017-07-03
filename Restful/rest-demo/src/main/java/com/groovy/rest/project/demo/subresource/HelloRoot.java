package com.hp.rest.project.demo.subresource;

import javax.ws.rs.Path;

@Path("hello")
public class HelloRoot {

	@Path("/sub")
	public Class sayHello(){
         return HelloSubResource.class;       
    }
}
