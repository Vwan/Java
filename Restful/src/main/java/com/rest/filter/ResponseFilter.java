package com.rest.filter;

	import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
	 
	public class ResponseFilter implements ContainerResponseFilter {
	 
	    @Override
	    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
	        throws IOException {
	    		String header = "content-type";
	    		MultivaluedMap<String, Object> headers = responseContext.getHeaders();
	    		if (headers!=null){
	            responseContext.getHeaders().add("X-Powered-By", "HP");
	            Object type = headers.getFirst(header);
	            if (type!=null)
	            {
	              headers.remove(header);
	              headers.add(header, type.toString() + ";charset=UTF-8");
	            }
	    }
	    }
	}

