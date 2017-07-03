package com.hp.rest.project.demo.hello.Response;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

@Path("/hello")
@Consumes("text/xml")
@Produces("text/xml")
public class HelloRSResp {
	@Context HttpServletRequest servletRequest;
    @Context HttpServletResponse servletResponse;
    @Context ServletContext context;
    @Context Request request;
 //   @Context Response response;
    
	@GET
	public String sayHelloWorld() {
		return "Hello world";
	}
	
	@GET
	public Response sayHelloWorldResp() {
		return Response
	    .ok("Hello world")
	    .type(MediaType.TEXT_PLAIN)
	    .build();
	}
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	public Response doPost(String payload) {
		javax.ws.rs.core.Request.class().doPost(payload);
		return Response
	    .ok("Hello world")
	    .type(MediaType.TEXT_PLAIN)
	    .build();
	}
	
	@GET
	@Path("/notfound")
	public Response sayNotFound() {
		return Response
				.status(404)
				.type(MediaType.TEXT_PLAIN)
				.entity("resource not found")
				.build();
}	
}
