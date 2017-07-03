package com.hp.rest.project.demo;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("/hello")
public class HelloRS {

	@GET
	public String sayHelloWorld() {
		return "Hello world";
	}

	@GET
	@Path("/pathparamtest/{name: [a-zA-Z][a-zA-Z0-9]*}")
	public String sayHello(@PathParam("name") String name) {
		return "Hello, " + name;
	}

	@GET
	@Path("/{name}")
	public String sayHello(
			@PathParam("name") 
			//@DefaultValue("QA") 
			String name,
			@QueryParam("count") 
			@DefaultValue("1") 
			int count) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < count; i++) {
			sb.append("Hello, " + name + "\n\n");
		}
		return sb.toString();
	}
}
