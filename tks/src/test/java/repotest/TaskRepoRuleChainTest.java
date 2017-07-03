package repotest;

import com.tks.entity.TaskStatus;
import com.tks.entity.Task;
import com.tks.repo.impl.TaskStatusRepo;
import com.tks.repo.impl.TaskRepo;
import org.junit.*;
import org.junit.rules.RuleChain;
import rules.entity.BaseTestRule;
import rules.entity.StatusRule;
import rules.entity.TaskRule;
import rules.repo.BaseRepoTestRule;
import rules.repo.StatusRepoRule;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by wanjia on 2016/8/7.
 */


public class TaskRepoRuleChainTest {
    static private TaskRepo taskRepo= new TaskRepo();
    static private TaskStatusRepo statusRepo;//= new TaskStatusRepo();
    static private BaseRepoTestRule statusRepoRule=new StatusRepoRule();
    static private BaseTestRule statusRule=new StatusRule();
    static private BaseTestRule taskRule=new TaskRule();
    private Task task=new Task();
    private TaskStatus taskStatus;
    @ClassRule
    static public RuleChain rule =  RuleChain.outerRule(taskRule)
            .around(statusRepoRule)
            .around(statusRule);

    @Before
    public void setup() {
        statusRepo = (TaskStatusRepo)statusRepoRule.getRepo();
        taskStatus = (TaskStatus)statusRule.getEntity();
        statusRepo.setEntity(taskStatus);
        statusRepoRule.setRepo(statusRepo);
        statusRepoRule.createAndVerify(statusRepo);
   //     statusRepo.close();
        task=(Task)taskRule.getEntity();
        task.setTaskStatus(taskStatus);
        taskRepo.setEntity(task);
    }
    @Ignore
    @Test
    public void testCreate() throws Exception {
       Task task=(Task)taskRule.createAndVerify(taskRepo);
       System.out.println("new count is" + task);
        System.out.println("taskRepo is" + taskRepo);
        //System.out.println("Task Created: "+ ((Task)taskRepo.findById(afterCount)).toString());
        assertThat(taskRepo.getEntity().getTaskStatus(),is(taskStatus));

    }

    @After
    public void teardown() {
       taskRepo.delete(taskRepo.getEntity());
        statusRepo.delete(taskStatus);
    //    taskRepo.close();
    }


}