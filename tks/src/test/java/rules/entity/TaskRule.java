package rules.entity;

import com.tks.entity.Release;
import com.tks.entity.TaskStatus;
import com.tks.entity.Task;
import com.tks.repo.impl.TaskRepo;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by wanjia on 2016/8/12.
 */
public class TaskRule extends BaseTestRule<Task,TaskRepo> {

    private static StatusRule statusRule = new StatusRule();
    private static ReleaseRule releaseRule = new ReleaseRule();

    public void before(){
        super.before();
        statusRule.before();
        releaseRule.before();
    }

    public void after(){
        super.before();
        statusRule.after();
        releaseRule.after();
    }

    public void generate(){
        statusRule.generate();
        TaskStatus taskStatus = statusRule.getEntity();
        statusRule.getRepo().create(taskStatus);
        System.out.println("taskStatus in taskrule: "+ taskStatus);

        releaseRule.generate();
        Release release = releaseRule.getEntity();
        releaseRule.getRepo().create(release);
        System.out.println("Release in taskrule: "+release);

        entity = new Task (RandomStringUtils.random(5,true,false), RandomStringUtils.random(5,true,false),release, taskStatus);
        System.out.println("task in rule:"+entity.toString());
        repo.setEntity(entity);
        System.out.println("task repo in rule:"+repo.getEntity());

    }
    public TaskRule(){

    }
}
