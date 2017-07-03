package com.rest.resource;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.glassfish.jersey.server.model.Resource;

//@Singleton
@Path("/v1")
public class RootResource {
	public RootResource() {
	}

	
	@Path("projects")
	public Resource projectController(){
		return Resource.from(ProjectResource.class);
	}
	
	@Path("/projects/{id}/products")
	public Resource productController(@PathParam ("id") int id){
		return Resource.from(ProductResource.class);
	}
	
}
