package com.tks.repo

import com.tks.entity.TaskStatus
import com.tks.repo.impl.TaskStatusRepo
import rules.entity.StatusRule
import spock.lang.Unroll
/**
 * Created by wanjia on 2016/8/7.
 */
public class TaskTaskStatusRepoTest extends BaseRepoTest<TaskStatusRepo,StatusRule> {
    TaskStatus status
    def setup(){
    }
    def teardown(){

    }

    @Unroll("create new taskStatus in db, expecting #result")
    def "P: Create New Status"(){
        setup:
        expect:
        System.out.println("repo entity is:"+repo.getEntity())
        rule.createAndVerify(repo);
    }

    @Unroll("create TaskStatus existing already in db, expecting #result")
    def "F: Create Status existing already "(){
        setup:
        rule.createAndVerify(repo);
        when:
        repo.create(repo.getEntity());
        then:
        def ex = thrown(IllegalArgumentException)
    }

    @Unroll("find taskStatus by name,expecting #result")
    def "P: Find Status by Name"(){
        expect:
        rule.verifyFindByFieldName(repo,"name",repo.getEntity().getName());

    }
    @Unroll("Find All TaskStatus,expecting #result")
    def "P: Find All Status"() {
        setup:
        rule.createAndVerify(repo);
        expect:
        List<TaskStatus> status = rule.verifyFindAll(repo, repo.count());
        for (TaskStatus s : status) {
        System.out.println("result is:" + s)
    }
    }
}
