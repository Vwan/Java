package com.rest.service;

//import javax.inject.Inject;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

//import org.jvnet.hk2.annotations.Inject;

@Path("/test")
@Produces("text/plain")
@Consumes("text/plain")
public class TestResource {

    private final TestService service;
    
    @Inject 
    public TestResource( TestService service) {
        this.service = service;
    }
    
  
    @GET
    public String get() {
        return service.getString();
    }
}
