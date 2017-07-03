package com.rest.server;

import com.rest.common.Constants;
import org.glassfish.grizzly.http.server.HttpServer;

import com.rest.common.MySqlDBHandler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 * Main class.
 *
 */
public class Main implements Constants {
   public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
	   
	   System.setProperty("java.util.logging.config.file", "src/main/resources/logging.properties");
    		
    	/*
    	 * Start Grizzly server
    	 */
    	GrizzlyHttpServer server = new GrizzlyHttpServer();
    	HttpServer httpServer = server.startServer(GrizzlyHttpServer.BASE_URI);
    	server.getLogger().setLevel(Level.FINEST);
         System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASEURI));
         /*
          * Connect mySQL DB
          */
         MySqlDBHandler.connectDB(MYSQLURL);

         System.in.read();
        httpServer.shutdown();
        System.exit(0);       
    }
}

