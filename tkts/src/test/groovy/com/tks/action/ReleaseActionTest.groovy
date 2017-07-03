package com.tks.action

import com.tks.repo.BaseRepoTest
import com.tks.repo.impl.ReleaseRepo
import com.tks.web.ReleaseAction
import rules.entity.ReleaseRule
/**
 * Created by wanjia on 2016/8/16.
 */
class ReleaseActionTest extends BaseRepoTest<ReleaseRepo,ReleaseRule> {

    def setup(){
    }

    def "test create Release"(){
        setup:
        def release = rule.getEntity();
        System.out.println("+++++"+release);
        // request.setAttribute("Release",release);
        def releaseAction = new ReleaseAction();
        releaseAction.setEntity(release);
        when:
        String result = releaseAction.create();
        System.out.println("Release list is: "+releaseAction.getDatamap());

        then:
        result=="success";

    }

    def "find all Release"(){
        when:
        def releaseAction = new ReleaseAction();
        def result = releaseAction.listAll()
        System.out.println("Release list is: "+releaseAction.getDatamap());
        then:
        result!=null
    }

    def "delete Release"(){
        when:
        def release = rule.getEntity();
        def releaseAction = new ReleaseAction();
        releaseAction.setEntity(release);
        def result = releaseAction.delete();
        System.out.println("Release list is: "+releaseAction.getDatamap());

        then:
        result!=null
    }

    def "update Release"(){
        when:
        def release = rule.getEntity();
        release.setDesc("Modified")
        release.setName("name modified");
        def releaseAction = new ReleaseAction();
        releaseAction.setEntity(release);
        def result = releaseAction.update();
        System.out.println("Release list is: "+releaseAction.getDatamap());

        then:
        result!=null
    }
}
