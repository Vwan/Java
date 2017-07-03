package com.rest.resource;

import com.rest.common.Utils;
import com.rest.exception.CustomNotFoundException;
import com.rest.model.Custom;
import com.rest.model.Project;
import com.rest.server.ReqHandler;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;
import java.io.IOException;
import java.net.URI;
import java.sql.SQLException;

//import javax.inject.Inject;

//import org.jvnet.hk2.annotations.Inject;
/*
 * // sub resource - project
 */

public class ProjectResource implements IResource{
	  private ReqHandler handler;
	  @Context Request request;
	  @Context UriInfo uriInfo;
	  //private ReqHandler handler;
	  
	  @Inject
	    public ProjectResource(ReqHandler handler) { this.handler = handler; }
	
	/*
	 * Get All Projects via uri: baseUrl/projects
	 */
	@GET	
	@Produces({ "application/xml", "application/json" })
	public Response get() throws SQLException {
		return handler.doGet();
	}

	/*
	 * Get project by id via uri: baseUrl/projects/{id}
	 */
	//@Encoded
	@GET
	@Produces({ "application/xml", "application/json" })
	@Path("/{id}")
	public Response getById(@PathParam("id") String id) throws SQLException {
		if (!Utils.isInteger(id)){
			return CustomNotFoundException.serverError(new Custom("Invalid URI, id must be an integer"));
		}
		else{
			int idint = Integer.parseInt(id);
			return handler.doGet(idint);
		}
	/*	if (!Utils.isInteger(str)) 
			return new CustomNotFoundException().serverError(new Custom("Not Found records in db"));
	*/	
	}

	/*
	 * Create new project via Post to uri: baseUrl/projects/{id}
	 */
	@POST
	@Consumes({ "application/xml", "application/json" })
	@Produces({ "application/xml", "application/json" })
	public Response post(Project p) throws SQLException {
		return handler.doPost(p);
		}

	/*
	 * Method: PUT Create new project if not exists already, Update existing
	 * project
	 */
	@PUT
	@Consumes({ "application/xml", "application/json" })
	@Produces({ "application/xml", "application/json" })
	@Path("{id}")
	public Response put(@PathParam ("id") int id,Project p) throws SQLException {
		if (id!=p.getId())
			return Response.status(Status.BAD_REQUEST).entity(new Custom("invalid id")).build();
		return handler.doPut(p);
	}

	/*
	 * Method: PUT Create new project if not exists already, Update existing
	 * project
	 */

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id) throws SQLException {
		return handler.doDelete(id);
	}

	/*
	 * Method: PATCH Create new project if not exists already, Update existing
	 * project
	 */

	/*
	 * Post from form submit
	 */
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void formPost(@FormParam("id") int id,
			@FormParam("name") String name,
			@FormParam("description") String description,
			@Context HttpServletResponse servletResponse) throws IOException, SQLException {
		Response res = handler.doPost(new Project(id, name, description));
		if (res.getStatus() == 201) {
			System.out.println(id);
			URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(id)).build();
			Response.created(uri).build();
			servletResponse.sendRedirect("c:\test1.html");
					//.sendRedirect(uriInfo.getAbsolutePath()+"/"+String.valueOf(id));
					  
		}
	}

	@Override
	public Response put(Project p) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}