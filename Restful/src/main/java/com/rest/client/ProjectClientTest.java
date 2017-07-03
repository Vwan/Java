package com.rest.client;

import java.net.URI;
import java.sql.SQLException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import com.rest.common.Constants;
import com.rest.model.Project;

public class ProjectClientTest implements Constants{
  public static void main(String[] args) throws SQLException {
    ClientConfig config = new ClientConfig();
    Client client = ClientBuilder.newClient(config);
    WebTarget service = client.target(getBaseURI()+"/v1/projects/");
    
    int id=122;

    // create one project
    Project p = new Project(id,"p1", "d1");
    Response response = service.request(MediaType.APPLICATION_XML)
    		.post(Entity.entity(p,MediaType.APPLICATION_XML),Response.class);
    System.out.println(response.getStatus());
  }
/*
    // Get JSON for application
    System.out.println(service.path(String.valueOf(id)).request().accept(MediaType.APPLICATION_JSON).get(String.class));

    // Get XML for application
    System.out.println(service.path(String.valueOf(id)).request().accept(MediaType.APPLICATION_XML).get(String.class));

    //Delete Project with id 
    System.out.println(service.path(String.valueOf(id)).request().delete());
 
    //Create a Project
    Form form =new Form();
    form.param("id", "345");
    form.param("name","name");
    form.param("description","desc");
    response = service.request().post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED),Response.class);
    System.out.println("Form response " + response.getStatus());

  }
*/
  private static URI getBaseURI() {
    return UriBuilder.fromUri(BASEURI).build();
  }

}
