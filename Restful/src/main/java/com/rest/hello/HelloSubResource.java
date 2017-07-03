package com.rest.hello;

import javax.ws.rs.GET;

public class HelloSubResource {
	@GET
    public String get()    {
         return "Hello Sub Resource.";
    }
}
