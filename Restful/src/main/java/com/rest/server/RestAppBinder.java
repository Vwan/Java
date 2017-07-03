package com.rest.server;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import com.rest.common.Log;
import com.rest.model.ProjectModel;
/*
 * When @Inject is detected on a parameter or field of type ReqHandler.class it is instantiated using the class ReqHandler. 
 * To use this binder, it need to be registered with the JAX-RS application
 */
public class RestAppBinder extends AbstractBinder {
    @Override
    protected void configure() {
    	bind(ProjectModel.class).to(ProjectModel.class);
        bind(ReqHandler.class).to(ReqHandler.class);
        bind(Log.class).to(Log.class);
        
    }
}
