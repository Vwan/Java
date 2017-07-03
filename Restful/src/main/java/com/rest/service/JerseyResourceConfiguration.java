package com.rest.service;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

public class JerseyResourceConfiguration extends ResourceConfig {

    public JerseyResourceConfiguration() {

        // where the TestResource class is
        packages("com.hp.rest.service"); 

        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(new TestService()).to(TestService.class);
            }
        });
    }
}