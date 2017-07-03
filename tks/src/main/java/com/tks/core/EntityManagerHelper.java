package com.tks.core;

import com.tks.web.listener.AppServletContextListner;
import org.apache.struts2.ServletActionContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletContext;

/**
 * Created by wanjia on 2016/8/26.
 */
public class EntityManagerHelper {

    private static final String PERSISTENT_UNIT="TKTS";
    private static final EntityManagerFactory emf;
    private static final ThreadLocal<EntityManager> threadLocal;

    static{
        //emf= Persistence.createEntityManagerFactory(PERSISTENT_UNIT);
        ServletContext sc = ServletActionContext.getServletContext();
        emf=(EntityManagerFactory)sc.getAttribute(AppServletContextListner.class.getSimpleName());
        threadLocal=new ThreadLocal<>();
    }

    public static EntityManager getEntityManager(){
        EntityManager em = threadLocal.get();
        if(em==null || !em.isOpen()){
            em = emf.createEntityManager();
            threadLocal.set(em);
        }
        return em;
    }

    public static void closeEntityManager(){
        EntityManager em = threadLocal.get();
        threadLocal.set(null);
        if (em!=null) em.close();
    }

    public static void beginTransaction(){
        if(!getEntityManager().getTransaction().isActive())
        getEntityManager().getTransaction().begin();
    }

    public static void commit(){
        if(!getEntityManager().getTransaction().isActive()) beginTransaction();
        getEntityManager().getTransaction().commit();
    }

    public static Query createQuery(String query){
        return getEntityManager().createQuery(query);
    }
}
