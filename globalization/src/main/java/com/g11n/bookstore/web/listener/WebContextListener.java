package com.g11n.bookstore.web.listener;

import com.g11n.bookstore.common.ConnectionManager;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

/**
 * Created by Administrator on 16-5-3.
 */
@WebListener
public class WebContextListener implements ServletContextListener {
    //@Resource(lookup="java:/comp/env",name="jdbc/BookStore")
    private DataSource datasource;
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ConnectionManager.setDataSource(datasource);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
