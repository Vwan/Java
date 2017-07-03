package com.tks.web.listener;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by wanjia on 2016/9/6.
 */

public class AppServletContextListner implements ServletContextListener {
    private static final String PERSISTENT_UNIT="TKTS";
    private EntityManagerFactory emf;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
         emf= Persistence.createEntityManagerFactory(PERSISTENT_UNIT);
         sce.getServletContext().setAttribute(this.getClass().getSimpleName(),emf);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        emf.close();
    }
}
