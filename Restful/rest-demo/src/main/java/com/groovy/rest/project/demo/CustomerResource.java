package com.hp.rest.project.demo;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

@Path("customer")
@Produces({"text/plain","text/xml"})
public class CustomerResource {

			  @Context
			  UriInfo uriInfo;
			  @Context
			  Request request;
			  String id;
			  
			  public CustomerResource(){};
			  public CustomerResource(UriInfo uriInfo, Request request, String id) {
			    this.uriInfo = uriInfo;
			    this.request = request;
			    this.id = id;
			  }
			  
			  //Application integration    
			  @GET
			  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
			  public Customer getCustomer() {
			    Customer customer = CustomerEnum.instance.getModel().get(id);
			    if(customer==null)
			      throw new RuntimeException("Get: Customer with " + id +  " not found");
			    return customer;
			  }
			  
			  // for the browser
			  @GET
			  @Produces(MediaType.TEXT_XML)
			  public Customer getCustomerHTML() {
				  Customer customer = CustomerEnum.instance.getModel().get(id);
			    if(customer==null)
			      throw new RuntimeException("Get: Customer with " + id +  " not found");
			    return customer;
			  }
			  
			  @PUT
			  @Consumes(MediaType.APPLICATION_XML)
			  public Response putCustomer(JAXBElement<Customer> customer) {
				  Customer c = customer.getValue();
			    return putAndGetResponse(c);
			  }
			  
			  @DELETE
			  public void deleteCustomer() {
				  Customer c = CustomerEnum.instance.getModel().remove(id);
			    if(c==null)
			      throw new RuntimeException("Delete: Customer with " + id +  " not found");
			  }
			  
			  private Response putAndGetResponse(Customer customer) {
			    Response res;
			    if(CustomerEnum.instance.getModel().containsKey(customer.getId())) {
			      res = Response.noContent().build();
			    } else {
			      res = Response.created(uriInfo.getAbsolutePath()).build();
			    }
			    CustomerEnum.instance.getModel().put(customer.getId().toString(), customer);
			    return res;
			  }
			  
			  

			} 

	


