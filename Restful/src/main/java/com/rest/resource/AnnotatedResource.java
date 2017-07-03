package com.rest.resource;

import java.lang.annotation.Annotation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("annoresource")
public class AnnotatedResource {
 
    @GET
    public Response get() {
        Annotation annotation = AnnotatedResource.class
                            .getAnnotation(Path.class);
        return Response.ok().entity("Entity", new Annotation[] {annotation}).build();
    }
}