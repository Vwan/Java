package com.tks.action

import com.tks.repo.BaseRepoTest
import com.tks.repo.impl.TaskRepo
import com.tks.web.TaskAction
import ognl.Ognl
import rules.entity.TaskRule

/**
 * Created by wanjia on 2016/8/16.
 */
class TaskActionTest extends BaseRepoTest<TaskRepo,TaskRule> {

    def setup(){
    }

    def "test create task"(){
        setup:
        def task = rule.getEntity();
        System.out.println("+++++"+task);
        // request.setAttribute("task",task);
        def taskAction = new TaskAction();
        taskAction.setEntity(task);
        when:
        String result = taskAction.create();
        System.out.println("task list is: "+taskAction.getDatamap());
        System.out.println(Ognl.getValue("release.id",task))

        then:
        result=="success";

    }

    def "find all task"(){
        when:
        def taskAction = new TaskAction();
        def result = taskAction.listAll()
        System.out.println("task list is: "+taskAction.getDatamap());
        then:
        result!=null
    }

    def "delete task"(){
        when:
        def task = rule.getEntity();
        def taskAction = new TaskAction();
        taskAction.setEntity(task);
        def result = taskAction.delete();
        System.out.println("task list is: "+taskAction.getDatamap());

        then:
        result=="success"
    }

    def "update task"(){
        when:
        def task = rule.getEntity();
        task.setDescription("Modified")
        task.setSummary("name modified");
        def taskAction = new TaskAction();
        taskAction.setEntity(task);
        def result = taskAction.update();
        System.out.println("task list is: "+taskAction.getDatamap());

        then:
        result=="success"
    }
}
