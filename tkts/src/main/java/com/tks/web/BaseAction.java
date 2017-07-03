package com.tks.web;

import com.opensymphony.xwork2.ActionSupport;
import com.tks.entity.GenericEntity;
import com.tks.service.impl.AbstractGenericService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wanjia on 2016/8/21.
 */
public abstract class BaseAction<T extends GenericEntity,S extends AbstractGenericService> extends ActionSupport {
    T entity;
    S service;

    protected Map<String, Object> datamap = new HashMap<>();

    public String create(){
        datamap.clear();
        System.out.println("create - entity is:"+entity.getClass());
        System.out.println("create - entity is:"+entity);
        //long id=service.create(entity);
        long id=doCreate();
        System.out.println("create - new id is:"+id);
        if (id>0) {
            datamap.put("success","true");
            datamap.put("entity", entity);
            return SUCCESS;
        }
        else {
            datamap.put("success","false");
            datamap.put("entity","Already exists");
            return ERROR;
        }
    }
    public  long doCreate(){
        long id=service.create(entity);
        return id;
    }

    public String listAll(){
        datamap.clear();
        List<T> entities = service.findAll();
        System.out.println("listAll - "+entities);
        if(entities!=null) {
            datamap.put("success","true");
            datamap.put("entity", entities);
            return SUCCESS;
        }
        else{
            datamap.put("success","false");
            datamap.put("entity", "No Data Avaliable");
            return ERROR;
        }
    }

    public String delete(){
        datamap.clear();
        try {
            System.out.println("delete - entity ID: "+entity.getId());
            T existingEntity = (T)service.findById(entity.getId());
            System.out.println("delete - entity : "+existingEntity);
            if (existingEntity!=null) {
                System.out.println("delete - entity: " + existingEntity);
                service.delete(existingEntity);
                datamap.put("success", "true");
                return SUCCESS;
            } else {
                datamap.put("success", "false");
                datamap.put("msg","Entity Not Exist");
                return ERROR;
            }
        }
        catch(Exception e){
                e.printStackTrace();
            }

        return ERROR;
    }

    public String update(){
        datamap.clear();
        System.out.println("updateentity - entity ID: "+entity.getId());
        long id = service.update(entity);
        if(id==0) {
            datamap.put("success","false");
            datamap.put("msg","Entity Not Exists");
            return ERROR;
        }
       datamap.put("success","true");
        return SUCCESS;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public S getService() {
        return service;
    }

    public void setService(S service) {
        this.service = service;
    }

    public Map<String, Object> getDatamap() {
        return datamap;
    }

    public void setDatamap(Map<String, Object> datamap) {
        this.datamap = datamap;
    }
}
