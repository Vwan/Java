package com.rest.client;

import com.rest.resource.ProductResource;
import com.rest.server.ReqHandler;
import org.junit.Test;

import javax.inject.Inject;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JerseyTestFramework {
	
	@Inject
	ReqHandler handler;

	@Test
	public void getUri(){
		final ProductResource pr = new ProductResource();
		final UriInfo uriInfo = mock(UriInfo.class);
		System.out.println("---"+uriInfo.getAbsolutePath());
	//	System.out.println(handler.getUri());
		when(uriInfo.getAbsolutePath()).thenReturn(URI.create("/test"));
	//	assertEquals(handler.getUri(),"/test");
	}
}
