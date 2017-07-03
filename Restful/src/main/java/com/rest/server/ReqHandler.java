package com.rest.server;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.rest.model.Custom;

import com.rest.common.Log;
import com.rest.model.Project;
import com.rest.model.ProjectModel;

public class ReqHandler{
	@Context
	UriInfo uriInfo;
	private ProjectModel pm;
	private Log log;

	@Inject
	public ReqHandler (ProjectModel pm,Log log){
		//this.uriInfo = uriInfo;
		this.pm=pm;
		this.log=log;
	}
	//public ReqHandler(){};
	/*
	 * Get all projects
	 */
	public Response doGet() throws SQLException {
		try {
			List<Project> records = pm.getProjects();
			if (records.size() > 0) {
				setUriAttribute(records);
				return Response.ok()
						.entity(new GenericEntity<List<Project>>(records) {
						}).build();
			} else
				log.info("not found records in db");
			return Response.status(404).entity(new Custom("Not Found records in db"))
					.build();
		}

		catch (Exception e) {
			String message = e.getMessage();
			e.printStackTrace();
			log.info(message);
			return null;
		}
	}
	/*
	 * Get projects by Id
	 */
	public Response doGet(int id) throws SQLException {
		try {
			//List<Project> records = pm.getProjectByID(id);
			List<Project> records=pm.getProjectsWithProductsByID(id);
			if (records.size() > 0) {
				return Response.ok()
						.entity(new GenericEntity<List<Project>>(records) {
						}).build();
			} else
				log.info("not found records in db");
		//	return (new CustomNotFoundException().CustomNotFoundException(new Custom("Not Found records in db")));
			return Response.status(Status.NOT_FOUND).entity(new Custom("Not Found records in db")).build();
		}
		catch (Exception e) {
			String message = e.getMessage();
			e.printStackTrace();
			log.info(message);
			return Response.status(Status.BAD_REQUEST)
					.entity(new Custom(message)).build();
		}
	}

	/*
	 * do post
	 */
	public Response doPost(Project p) throws SQLException {
		Response res= null;
			try {
				String uri=setUriAttribute(p);
				res = Response.status(201).entity(p).header("Location",uri).build();
					if(res.getStatus()==201){
						if(pm.createProject(p)){
						log.info("project created");
						//p.setUri(uri);
						}
						else res=Response.status(Status.EXPECTATION_FAILED).entity(new Custom("Project "+p +" already exists!")).build();
					}
					else {
						log.info("project creation failed");
						res = Response.serverError().entity(new Custom("Project "+p +" creation failed!")).build();
					}
			}
			catch (Exception e) {
				String message = e.getMessage();
				e.printStackTrace();
				log.info(message);
				res = Response.serverError().entity(new Custom(message)).build();
			}
			return res;
	}
	
	/*
	 * do PUT if project not exists, create as a new one if project exists,
	 * update if needed
	 */
	public Response doPut(Project p) throws SQLException {
		Response res = null;
		try {
			res = Response.status(200).entity(p)
					.header("Location", putUriAttribute(p)).build();
			if (res.getStatus() == 200) {
				if (pm.projectExists(p.getId())) {
					log.info("project exists, updating");
					if (pm.updateProject(p)) {
						log.info("project updated");
					} else {
						log.info("project update failed");
						res = Response.serverError()
								.entity(new Custom("update record fail"))
								.build();
					}
				} else {
					if (pm.createProject(p)) {
						log.info("project doesnot exist, created");
						res = Response.status(201).entity(p)
								.header("Location", putUriAttribute(p)).build();
					} else {
						log.info("project creation failed");
						res = Response.serverError()
								.entity(new Custom("create record fail"))
								.build();
					}
				}
			}
		} catch (Exception e) {
			log.info(e.getStackTrace().toString());
			res = Response.serverError().build();
		}
		return res;
	}
	
	/*
	 * do delete
	 */
	public Response doDelete(int id) throws SQLException {
			try {
				if(pm.projectExists(id)){
					if(pm.deleteRecord(id)){
					return Response.ok().build();
					}
					else
					{
						return Response.serverError().entity(new Custom("Project "+id +" deletion fail!")).build(); 
					}
				}
				else{
					return Response.status(Status.NOT_FOUND).entity(new Custom("Project id "+id +" doesn't exists!")).build();
				}
		
		}
		catch (Exception e) {
			log.info(e.getStackTrace().toString());
			return Response.serverError().build();
		}
}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		  HttpServletRequest req = (HttpServletRequest)request;
		  req.setCharacterEncoding("UTF-8");
		}

	
	public String putUriAttribute(Project p){
		String uri = uriInfo.getAbsolutePath().toASCIIString();
		p.setUri(uri);
		return uri;
	}
	
	public String setUriAttribute(Project p){
		String uri = uriInfo.getAbsolutePath()+String.valueOf(p.getId());
		p.setUri(uri);
		return uri;
	}
	
	public void setUriAttribute(List<Project> p){
		
		for(Project proj:p){
			String uri = setUriAttribute(proj);
			proj.setUri(uri);
		}
		
	}
}
