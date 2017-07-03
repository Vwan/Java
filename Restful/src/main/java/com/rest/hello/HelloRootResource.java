package com.rest.hello;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("hello")
public class HelloRootResource {

	@Path("root")
	@GET
	@Produces({"text/html","text/plain","text/xml"})
	public String sayHelloRoot(){
		return "<h1>Hello Root Resource</h1>";
	}
	@Path("sub")
	public Class sayHello(){
         return HelloSubResource.class;       
    }
}
