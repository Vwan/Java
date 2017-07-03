package com.tks.web.action;

import com.tks.entity.Task;
import com.tks.entity.TaskStatus;
import com.tks.entity.User;
import com.tks.service.impl.TaskStatusService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import java.util.List;

/**
 * Created by wanjia on 2016/8/1.
 */
@Namespace("/taskstatus")
public class TaskStatusAction extends BaseAction<TaskStatus,TaskStatusService> {

    public TaskStatusAction(){
        service = new TaskStatusService();
    }

    public void validate(){
        if("".equals(entity.getName())){
            addFieldError("name",getText("name.required"));
        }
    }
    public TaskStatus getEntity(){
        return entity;
    }

    public void setEntity(TaskStatus item) {
        System.out.println("setEntity in UserAction is executed: user= "+item);
        this.entity = item;
        System.out.println("setEntity in UserAction is executed: entity="+entity);
    }

    public void setEntities(List<TaskStatus> items) {
        System.out.println("setEntity in UserAction is executed: user= "+items);
        entities= items;
        System.out.println("setEntity in UserAction is executed: entity="+entities);
    }

    public List<TaskStatus> getEntities(){
        return entities;
    }


}
