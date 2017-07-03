package com.hp.rest.project.demo.subresource;

import javax.ws.rs.GET;

public class HelloSubResource {
	@GET
    public String get()
    {
         return "Hello Sub Resource.";
    }
}
