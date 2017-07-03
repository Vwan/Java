package com.rest.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import java.io.IOException;

 
public class RequestFilter implements ContainerRequestFilter {
 
    @Override
    public void filter(ContainerRequestContext requestContext)
                    throws IOException {
    	String header = requestContext.getHeaderString("content-type");
        requestContext.setProperty("content-type", header+";charset=UTF-8");
		  
		  System.out.println("header string is :"+requestContext.getHeaderString("content-type"));
        }
    }

