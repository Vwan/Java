package com.rest.hello;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class Hello {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHelloWorld() {
		return "Hello world";
	}

	@GET
	@Path("/pathparamtest/{name: [a-zA-Z][a-zA-Z0-9]*}")
	public String sayHello(@PathParam("name") String name) {
		return "Hello, " + name;
	}
	
	@GET
	@Path("/links")
	public String sayHelloLink(String name) {
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
	
	//// curl -X POST -H "Content-Type: text/plain" -d "this is from post data"  http://localhost:9898/restdemo/hello/echo
	@POST 
	@Consumes("text/plain")
	@Path("/echo")
	public String sayHelloEcho(String message)
	{
		return "Hello, " +message;     
	}
}
