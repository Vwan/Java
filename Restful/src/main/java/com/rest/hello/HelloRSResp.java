package com.rest.hello;

//import javax.servlet.ServletContext;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
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

@Path("/hello/response")
public class HelloRSResp {
    @Context Request request;
	
	@GET
	public Response sayHelloWorld() {
		return Response
	    .ok("Hello world (response)")
	    .type(MediaType.TEXT_PLAIN)
	    .build();
	}
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	public Response doPost(String payload) {
		
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
