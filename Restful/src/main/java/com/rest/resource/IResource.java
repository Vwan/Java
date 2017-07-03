package com.rest.resource;

import com.rest.model.Project;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;

//import javax.inject.Inject;

//import org.jvnet.hk2.annotations.Inject;
/*
 * // sub resource - project
 */
public interface IResource {
	
	/*
	 * @Inject public ProjectResource(ProjectModel pm) { this.pm = pm; }
	 */
	/*
	 * Get All Projects via uri: baseUrl/projects
	 */
	@GET
	@Produces({ "application/xml", "application/json" })
	public Response get() throws SQLException;

	/*
	 * Get project by id via uri: baseUrl/projects/{id}
	 */
	@GET
	@Produces({ "application/xml", "application/json" })
	@Path("/{id}")
	public Response getById(@PathParam("id") String id) throws SQLException;

	/*
	 * Create new project via Post to uri: baseUrl/projects/{id}
	 */
	@POST
	@Consumes({ "application/xml", "application/json" })
	@Produces({ "application/xml", "application/json" })
	public Response post(Project p) throws SQLException;

	/*
	 * Method: PUT Create new project if not exists already, Update existing
	 * project
	 */
	@PUT
	@Consumes({ "application/xml", "application/json" })
	@Produces({ "application/xml", "application/json" })
	public Response put(Project p) throws SQLException;

	/*
	 * Method: PUT Create new project if not exists already, Update existing
	 * project
	 */

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id) throws SQLException;

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
			@Context HttpServletResponse servletResponse) throws SQLException, IOException;

}