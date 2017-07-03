package com.rest.resource;

import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.rest.model.Custom;

@Path("/test/{param}")
public class Contexts {
	@Context Request request;
	@Context HttpServletRequest servletRequest;
	@Context Response response;
	@Context HttpServletResponse servletResponse;
	@Context ServletConfig servletConfig;
	@Context ServletContext servletContext;
	@Context HttpHeaders header;
	@Context UriInfo info;

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response getContext() throws SQLException {
	MultivaluedMap<String, String> queryParameters = info.getQueryParameters();
	MultivaluedMap<String, String> pathParameters = info.getPathParameters();
	System.out.println(queryParameters);
	System.out.println(pathParameters);
	System.out.println(this.request.getMethod());
//	System.out.println(this.response.getStatus());
//	System.out.println(this.servletConfig.getServletName());
//	System.out.println(this.servletContext.getServerInfo());
	System.out.println(this.header.getHeaderString("content-type"));
	System.out.println(this.info.getAbsolutePath());
	return Response.ok().entity(new Custom( "test contexts of query parameters are:"+ queryParameters)).build();
	}
}
