package com.tks.action

import com.tks.entity.Status
import com.tks.repo.BaseRepoTest
import com.tks.repo.impl.StatusRepo
import com.tks.service.impl.StatusService
import com.tks.web.StatusAction
import rules.entity.StatusRule
/**
 * Created by wanjia on 2016/8/16.
 */
class StatusActionTest extends BaseRepoTest<StatusRepo,StatusRule> {

    def setup(){
    }

    def "test create status"(){
        setup:
            Status status = rule.getEntity();
            System.out.println("+++++"+status);
            StatusAction statusAction = new StatusAction();
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
            StatusAction statusAction = new StatusAction();
            def result = statusAction.listAll()
            System.out.println("status list is: "+statusAction.getStatusmap());
        then:
            result!=null
    }

    def "delete status"(){
        when:
        Status status = rule.getEntity();
        StatusAction statusAction = new StatusAction();
        statusAction.setEntity(status);
        def result = statusAction.delete();
        System.out.println("status list is: "+result);

        then:
        result!=null
    }

    def "update status"(){
        when:
        Status status = rule.getEntity();
        status.setDescription(description)
        status.setName(name);
        StatusAction statusAction = new StatusAction();
        statusAction.setEntity(status);
        def result = statusAction.update();
        System.out.println("status list is: "+result);

        then:
        Status us = new StatusService().findSingleByFieldName("status_name",name)
        us.getDescription()==description
        us.getName()==name
        result==testresult

        where:
        description | name | testresult
        "DescModified" | "Name modified" | "success"
    }
}
