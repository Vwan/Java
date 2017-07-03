package com.tks.web.action;

import com.tks.entity.*;
import com.tks.service.impl.*;
import org.apache.struts2.convention.annotation.*;
import org.apache.velocity.runtime.log.SystemLogChute;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by wanjia on 2016/8/1.
 */

@Namespace("/task")
public class TaskAction extends BaseAction<Task, TaskService>{

    protected String statusListSelected;
    public TaskAction (){
        service=new TaskService();
    }


    public long doCreate(){
        System.out.println("createTask - Task in Task action:"+entity);
        System.out.println("selected lang list is:"+listSelected);
        Set<Language> langlist = new HashSet<Language>() ;
        for(int i=0;i<listSelected.size();i++){
            langlist.add(new LanguageService().findSingleByFieldName("code",listSelected.get(i)));
        }
        System.out.println("language list is:"+langlist);
        System.out.println(entity.getRelease().getName());
        Release release = new ReleaseService().findSingleByFieldName("name",entity.getRelease().getName());
        entity.setRelease(release);
        entity.getRelease().setLanguages(langlist);
        System.out.println("ReleaseID:"+entity.getRelease().getId());
        System.out.println("status list selected is:"+statusListSelected);
        System.out.println("status list selected is:"+new TaskStatusService().findSingleByFieldName("name",statusListSelected));
        entity.setTaskStatus(new TaskStatusService().findSingleByFieldName("name",statusListSelected));
        System.out.println("entity is:"+entity);
        long id =service.create(entity);
        return id;
    }

    @Action(value = "listAllByRelease",
            interceptorRefs = {
                    //  @InterceptorRef(value = "json"),
                    @InterceptorRef(value = "defaultStack")
            }
    )
    public String listAllByRelease(){
        System.out.println("Release Name is: "+ entity.getRelease().getName());
        Release release = new ReleaseService().findSingleByFieldName("name",entity.getRelease().getName());
        System.out.println("Release is: "+release);
        System.out.println("Release ID is: "+release.getId());
        entities=service.FindAllById("release_id",release.getId());
        System.out.println("listAll - "+entities);
        if(entities!=null) {
            return SUCCESS;
        }
        else{
            return ERROR;
        }
    }

    public String getStatusListSelected() {
        return this.statusListSelected;
    }

    public void setStatusListSelected(String statusListSelected) {
        this.statusListSelected = statusListSelected;
    }

    public Task getEntity(){
        return entity;
    }

    public void setEntity(Task item) {
        System.out.println("setEntity in UserAction is executed: user= "+item);
        this.entity = item;
        System.out.println("setEntity in UserAction is executed: entity="+entity);
    }

    public void setEntities(java.util.List<Task> items) {
        System.out.println("setEntity in UserAction is executed: user= "+items);
        entities= items;
        System.out.println("setEntity in UserAction is executed: entity="+entities);
    }

    public List<Task> getEntities(){
        return entities;
    }
}
