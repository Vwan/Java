package com.tks.web.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Created by wanjia on 2016/8/26.
 */

public class AppServletRequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("request destroyed");
       // EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("request initialized");
       // EntityManagerHelper.getEntityManager();
    }
}
