package com.tks.web.action;

import com.tks.entity.*;
import com.tks.entity.TaskProgress;
import com.tks.service.impl.*;
import org.apache.struts2.convention.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by wanjia on 2016/8/1.
 */

@Namespace("/taskprogress")
public class TaskProgressAction extends BaseAction<TaskProgress, TaskProgressService>{

    public TaskProgressAction(){
        service=new TaskProgressService();
    }


    @Action(value = "listTaskProgressByTask",results = {
            @Result(type = "json",params = { "root", "entities" })}

            ,exceptionMappings = {
            @ExceptionMapping(exception = "java.lang.Exception", result = "error")
    },
            interceptorRefs = {
                  //  @InterceptorRef(value = "json"),
                    @InterceptorRef(value = "defaultStack")
            })
    public String listTaskProgressByTask(){
        System.out.println("TaskProgress Name is: "+ entity.getTask().getId());
        TaskProgress taskProgress = new TaskProgressService().findById(entity.getTask().getId());
        System.out.println("TaskProgress is: "+taskProgress);
        System.out.println("TaskProgress ID is: "+taskProgress.getId());
        entities=service.FindAllById("TaskProgress_id",taskProgress.getId());
        System.out.println("listAll - "+entities);
        if(entities!=null) {
            return SUCCESS;
        }
        else{
            return ERROR;
        }
    }

    public TaskProgress getEntity(){
        return entity;
    }

    public void setEntity(TaskProgress item) {
        System.out.println("setEntity in UserAction is executed: user= "+item);
        this.entity = item;
        System.out.println("setEntity in UserAction is executed: entity="+entity);
    }

    public void setEntities(List<TaskProgress> items) {
        System.out.println("setEntity in UserAction is executed: user= "+items);
        entities= items;
        System.out.println("setEntity in UserAction is executed: entity="+entities);
    }

    public List<TaskProgress> getEntities(){
        return entities;
    }
}
