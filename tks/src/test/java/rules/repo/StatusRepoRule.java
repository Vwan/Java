package rules.repo; /**
 * Created by wanjia on 2016/8/7.
 */


import com.tks.entity.TaskStatus;
import com.tks.repo.impl.TaskStatusRepo;
import org.junit.After;
import rules.Utils;
import rules.entity.StatusRule;


public class StatusRepoRule extends BaseRepoTestRule<TaskStatus,TaskStatusRepo> implements Utils {
    TaskStatus taskStatus;
    public static StatusRule statusRule= new StatusRule();
  /*  @ClassRule
    static public RuleChain rule =  RuleChain.outerRule(new StatusRepoRule())
            .around(statusRule);*/
    public StatusRepoRule() {
        statusRule.before();
        taskStatus =(TaskStatus)statusRule.getEntity();
        repo=new TaskStatusRepo();
        repo.setEntity(taskStatus);

    }

     public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }


    public void before(){
        super.before();

    }
    @After
    public void after(){
        super.after();
    }
}

