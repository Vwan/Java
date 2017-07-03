package com.tks.action

import com.tks.entity.TaskStatus
import com.tks.repo.BaseRepoTest
import com.tks.repo.impl.TaskStatusRepo
import com.tks.service.impl.TaskStatusService
import com.tks.web.action.TaskStatusAction
import rules.entity.StatusRule
/**
 * Created by wanjia on 2016/8/16.
 */
class TaskTaskStatusActionTest extends BaseRepoTest<TaskStatusRepo,StatusRule> {

    def setup(){
    }

    def "test create status"(){
        setup:
            TaskStatus status = rule.getEntity();
            System.out.println("+++++"+status);
            TaskStatusAction statusAction = new TaskStatusAction();
            status.setDescription("test")
            status.setName("new test")
            statusAction.setEntity(status);
        when:
            String result = statusAction.create();
        then:
           result=="success";

    }

    def "find all status"(){
        when:
            TaskStatusAction statusAction = new TaskStatusAction();
            def result = statusAction.listAll()
            System.out.println("taskStatus list is: "+statusAction.getEntities());
        then:
            result!=null
    }

    def "delete status"(){
        when:
        TaskStatus status = rule.getEntity();
        TaskStatusAction statusAction = new TaskStatusAction();
        statusAction.setEntity(status);
        def result = statusAction.delete();
        System.out.println("taskStatus list is: "+result);

        then:
        result!=null
    }

    def "update status"(){
        when:
        TaskStatus status = rule.getEntity();
        status.setDescription(description)
        status.setName(name);
        TaskStatusAction statusAction = new TaskStatusAction();
        statusAction.setEntity(status);
        def result = statusAction.update();
        System.out.println("taskStatus list is: "+result);

        then:
        TaskStatus us = new TaskStatusService().findSingleByFieldName("status_name",name)
        us.getDescription()==description
        us.getName()==name
        result==testresult

        where:
        description | name | testresult
        "DescModified" | "Name modified" | "success"
    }
}
