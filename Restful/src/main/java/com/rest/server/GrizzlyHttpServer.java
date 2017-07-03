package com.rest.server;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import com.rest.common.Constants;

import java.net.URI;
import java.sql.SQLException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.core.UriBuilder;

/**
 * Grizzly server
 *
 */
public class GrizzlyHttpServer implements Constants{
	
	/*
	 * define base URL
	 */
	  private static URI getBaseURI() { 
	        return UriBuilder.fromUri(BASEURI).build(); 
	    } 
	  public static final URI BASE_URI = getBaseURI(); 
	//  public static final Logger LOGGER = Logger.getLogger(GrizzlyHttpServer.class.getName());
	  public static Logger getLogger(){
		  Logger l = Logger.getLogger(GrizzlyHttpServer.class.getName());
		  l.setLevel(Level.FINE);
		  l.setUseParentHandlers(false);
		  ConsoleHandler ch = new ConsoleHandler();
		  ch.setLevel(Level.ALL);
		  l.addHandler(ch);
		return l;
	  }
  
    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    public HttpServer startServer(URI BASE_URI) throws ClassNotFoundException, SQLException {
    	ResourceConfig rc = new RestApp();//new JerseyResourceConfiguration();
         return GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
    }
  
}

