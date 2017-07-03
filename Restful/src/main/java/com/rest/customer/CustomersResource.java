package com.rest.customer;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Path("customers")
@Produces({"text/plain","text/xml"})

public class CustomersResource {

	// Allows to insert contextual objects into the class,
	// e.g. ServletContext, Request, Response, UriInfo
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	// Return the list of customers to the user in the browser
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Customer> getcustomersBrowser() {
		List<Customer> customers = new ArrayList<Customer>();
		customers.addAll(CustomerEnum.instance.getModel().values());
		return customers;
	}

	// Return the list of customers for applications
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Customer> getcustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		customers.addAll(CustomerEnum.instance.getModel().values());
		return customers;
	}

	// Defines that the next path parameter after customers is
	// treated as a parameter and passed to the CustomerResources
	// Allows to type http://localhost:8080/com.vogella.jersey.Customer/rest/customers/1
	// 1 will be treaded as parameter Customer and passed to CustomerResource
	@GET
	@Path("{id}")
	public CustomerResource getCustomer(@PathParam("id") String id) {
		System.out.println(uriInfo.toString());
		return new CustomerResource(uriInfo, request, id);
	}

	// returns the number of customers
	// Use
	// http://localhost:8080/com.vogella.jersey.Customer/rest/customers/count
	// to get the total number of records
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		int count = CustomerEnum.instance.getModel().size();
		return String.valueOf(count);
	}

	// create a new customer from query parameters
	@PUT
	@Consumes({ MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
	// @Produces({ MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
	public void createCustomer(@QueryParam("id") String id, 
			@QueryParam("firstName") String firstName, 
			@QueryParam("lastName") String lastName) {
		Customer Customer = new Customer(id, firstName,lastName);
		CustomerEnum.instance.getModel().put(id, Customer);
	}

	@POST // update a customer?
	@Produces(MediaType.TEXT_XML)
	@Consumes(MediaType.TEXT_XML)
	public void newCustomer(@QueryParam("id") String id,
			@QueryParam("firstName") String firstName,
			@QueryParam("lastName") String lastName)
			// @Context HttpServletResponse servletResponse) 
					throws IOException {
		Customer Customer = new Customer(id, firstName,lastName);
		if (firstName != null) {
			Customer.setFirstName(firstName);
		}
		CustomerEnum.instance.getModel().put(id, Customer);
		//servletResponse.sendRedirect("../create_Customer.html");
	}
	/* @Produces(MediaType.TEXT_HTML)
	 * @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	  public void newCustomer(@FormParam("id") String id,
	      @FormParam("summary") String summary,
	      @FormParam("description") String description,
	      @Context HttpServletResponse servletResponse) throws IOException {
	    Customer Customer = new Customer(id, summary);
	    if (description != null) {
	      Customer.setDescription(description);
	    }
	    CustomerEnum.instance.getModel().put(id, Customer);

	    servletResponse.sendRedirect("../create_Customer.html");
	  }
	 */




} 




