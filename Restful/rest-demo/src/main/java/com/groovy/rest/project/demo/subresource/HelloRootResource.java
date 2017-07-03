package com.hp.rest.project.demo.subresource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("hello")
public class HelloRootResource {

	@Path("root")
	@GET
	@Produces({"text/html","text/plain","text/xml"})
	public String sayHelloRoot(){
		return "<xml><h1>Hello Root Resource</h1></xml>";
	}
	@Path("sub")
	public Class sayHello(){
         return HelloSubResource.class;       
    }
}
