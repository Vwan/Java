package com.tks.action

import com.tks.entity.Status
import com.tks.entity.Task
import com.tks.repo.impl.TaskRepo
import com.tks.service.impl.TaskService
import org.junit.Ignore
import spock.lang.Specification
import spock.lang.Unroll
/**
 * Created by wanjia on 2016/8/7.
 */
public class TaskServiceTest extends Specification {
    private TaskRepo repo= new TaskRepo() ;
    private TaskService service;
    def setup(){
        repo = Mock(repo);
        service = new TaskService(repo)
    }

    def teardown(){}
    @Ignore
    @Unroll("create new task, expecting #result")
    def "P: Create New Task"(){
        setup:
        def task =null;

        when:
        def result = (Task)service.create(task);

        then:
        1 * repo.create(task) >> {
            size.times {
                Status status = new Status("status1","status 1 desc");
                new Task("Test1","test 1 desc",status);
            }

        }
        result.getSummary()==name;
        where:
        size | name
        1 | "single product"
    }
}
