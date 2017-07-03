package com.rest.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.rest.model.Custom;

public class CustomNotFoundException extends WebApplicationException {
	/**
	  * Create a HTTP 404 (Not Found) exception.
	  */
	  public CustomNotFoundException() {
	    super(Response.Status.NOT_FOUND);
	  }
	 
	  /**
	  * Create a HTTP 404 (Not Found) exception.
	  * @param message： the entity of the 404 response.
	  */
	
	  public static Response serverError(Custom message) {
		    return Response.serverError().entity(message).build();
	  }
}
