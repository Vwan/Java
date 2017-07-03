package com.rest.resource;

import com.rest.common.Utils;
import com.rest.exception.CustomNotFoundException;
import com.rest.model.Custom;
import com.rest.model.Product;
import com.rest.model.Project;
import com.rest.server.ReqHandler;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.IOException;
import java.sql.SQLException;

public class HerbResource implements IResource{
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	Product product;
	@Inject
	ReqHandler handler;

	public HerbResource(){};
	public HerbResource(UriInfo uriInfo, Request request,
						Product product) {
		this.uriInfo = uriInfo;
		this.request = request;
		this.product = product;
	}
	
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
	public Response put(Project p) throws SQLException {
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
			@Context HttpServletResponse servletResponse) throws SQLException,
			IOException {
		Response res = handler.doPost(new Project(id, name, description));
		if (res.getStatus() == 201) {
			System.out.println(id);
			servletResponse
					.sendRedirect("file:///D:/Automation%20Community/Restful/workspace/restdemo/src/test/resources/Project1.html");
		}
	}

}