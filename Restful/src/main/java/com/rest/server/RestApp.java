package com.rest.server;

import com.rest.common.Log;
import com.rest.filter.RequestFilter;
import com.rest.filter.ResponseFilter;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@ApplicationPath("/rest/*") // register a ("/rest/*") urlmapping to jersey, no need one in web.xml 
public class RestApp extends ResourceConfig {
	Log log = new Log();

	public RestApp() throws ClassNotFoundException, SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		 map.put("jersey.config.server.tracing.type", "ALL");
		addProperties(map);
		// rc.register(GensonJsonConverter.class);
	//	register(JacksonJsonProvider.class);
		// dependency injection
		register(new RestAppBinder());
		register(RequestFilter.class);
		register(ResponseFilter.class);
		packages("com.hp.rest");
		
		//MySqlDBHandler.connectDB(MYSQLURL);
		//register(MySqlInit.class);
		/*
		 * Enable LoggingFilter & output entity.
		 */
		registerInstances(new LoggingFilter(Logger.getLogger(RestApp.class
				.getName()), true));
		/*for(Resource res: rc.getResources()){
			log.info(String.format("resource: %s, path =[%s]", res.getName(), res.getPath()));
		}*/
		/*
		 * multipart support;
		 */
		// rc.packages("org.glassfish.jersey.examples.multipart");
		// rc.register(MultiPartFeature.class);

		/*
		 * swagger support

		BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8002");
        beanConfig.setBasePath("/api");
        beanConfig.setResourcePackage("io.swagger.resources");
        beanConfig.setScan(true);
        add(io.swagger.jaxrs.listing.ApiListingResource.class);
        add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        */
	}
}
