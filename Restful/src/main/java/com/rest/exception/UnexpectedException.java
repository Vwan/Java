package com.rest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
 
@Provider
public class UnexpectedException extends Throwable implements ExceptionMapper<Throwable>
{ 
    @Override
    public Response toResponse(Throwable exception)
    {
    	return Response.serverError().entity("Unexpected exception:\n"+exception.getMessage()).type("text/plain").build();
    }
}