package com.tks.repo

import com.tks.entity.Status
import com.tks.entity.Task
import com.tks.repo.impl.StatusRepo
import com.tks.repo.impl.TaskRepo
import rules.entity.TaskRule
import spock.lang.Unroll

import static org.junit.Assert.assertNotNull
import static org.junit.Assert.assertTrue
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
/**
 * Created by wanjia on 2016/8/7.
 */
public class TaskRepoTest extends BaseRepoTest<TaskRepo,TaskRule> {

    def setup(){
       //
    }
    def teardown(){}

    @Unroll("create new Task in db, expecting #result")
    def "P: Create New Task"(){
       setup:
        expect:
        rule.createAndVerify(repo);
    }

    @Unroll("create Task existing already in db, expecting #result")
    def "F: Create Task existing already "(){
        setup:
        rule.createAndVerify(repo);
        when:
        repo.create(repo.getEntity());
        then:
        def ex = thrown(IllegalArgumentException)
    }

    @Unroll("find task by name,expecting #result")
    def "P: Find task by Name"(){
        setup:
        Task task = repo.getEntity();
        expect:
        rule.verifyFindByFieldName(repo,"id",String.valueOf(task.getId()));
    }

    @Unroll("Find All Tasks,expecting #result")
    def "P: Find All Tasks"() {
        setup:
        rule.createAndVerify(repo);
        expect:
        List<Task> tasks = rule.verifyFindAll(repo, repo.count());
        for (Task task : tasks) {
            System.out.println("result is:" + task)
            assertNotNull(task.getStatus());
        }
    }

    @Unroll("Find all tasks by status")
    def "P:Find All tasks by status"() {
        setup:
        rule.createAndVerify(repo);
        when:
        List<Task> tasks = repo.findByStatus(repo.getEntity().getStatus());
        then:
        assertNotNull(tasks)
        for (Task task : tasks) {
            System.out.println("result is:" + task)
            assertNotNull(task.getStatus());
        }
    }

        @Unroll("findByStatusName - Find all tasks by status name")
        def "P:Find All tasks by status name"(){
            setup:
            rule.createAndVerify(repo);
            repo.getEntity().setSummary("find all tasks by staus name");
            repo.getEntity().setStatus(repo.getEntity().getStatus());
            def repo2 = new TaskRepo()
            repo2.create(new Task("find all tasks by status name","",repo.getEntity().getRelease(),repo.getEntity().getStatus()));

            when:
            List<Task> tasks = repo.findByStatusName(repo.getEntity().getStatus().getName());
            then:
            assertNotNull(tasks)
            tasks.size()==2
            for (Task task : tasks) {
                System.out.println("result is:" + task)
                assertNotNull(task.getStatus());
            }
    }

    @Unroll("findByRelease - Find all tasks by release name")
    def "P:Find All tasks by release name"(){
        setup:
        rule.createAndVerify(repo);
        repo.getEntity().setSummary("find all tasks by release name");
        repo.getEntity().setRelease(repo.getEntity().getRelease());
        def repo2 = new TaskRepo()
        repo2.create(new Task("find all tasks by release name1","",repo.getEntity().getRelease(),repo.getEntity().getStatus()));

        when:
        List<Task> tasks = repo.findByRelease(repo.getEntity().getRelease());
        then:
        assertNotNull(tasks)
        tasks.size()==2
        for (Task task : tasks) {
            System.out.println("result is:" + task)
            assertNotNull(task.getRelease());
        }
    }

    @Unroll("Update Existing Task")
    def "P: Update Existing Task"() {
        setup:
        rule.createAndVerify(repo);

        when:
        Task task = repo.getEntity();
        task.setDescription("Updated Desc")
        task.setSummary("Updated Summary")
        Status status = new Status("test","test");
        new StatusRepo().create(status);
        task.setStatus(status)
        repo.update(task);
        System.out.println("result is:" + task)

        then:
        List<Task> tasks = repo.findByStatus(status);
        assertTrue(tasks.contains(task));

    }

    @Unroll("Delete Task")
    def "P: Delete Task"(){
        setup:
        rule.createAndVerify(repo);
        when:
        repo.delete(repo.getEntity());
        then:
        Task task = repo.findById(repo.getEntity().getId());
        assertThat(task,is(null))
    }
}
