package repotest;

import com.tks.entity.Status;
import com.tks.entity.Task;
import com.tks.repo.impl.StatusRepo;
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
    static private StatusRepo statusRepo;//= new StatusRepo();
    static private BaseRepoTestRule statusRepoRule=new StatusRepoRule();
    static private BaseTestRule statusRule=new StatusRule();
    static private BaseTestRule taskRule=new TaskRule();
    private Task task=new Task();
    private Status status;
    @ClassRule
    static public RuleChain rule =  RuleChain.outerRule(taskRule)
            .around(statusRepoRule)
            .around(statusRule);

    @Before
    public void setup() {
        statusRepo = (StatusRepo)statusRepoRule.getRepo();
        status = (Status)statusRule.getEntity();
        statusRepo.setEntity(status);
        statusRepoRule.setRepo(statusRepo);
        statusRepoRule.createAndVerify(statusRepo);
   //     statusRepo.close();
        task=(Task)taskRule.getEntity();
        task.setStatus(status);
        taskRepo.setEntity(task);
    }
    @Ignore
    @Test
    public void testCreate() throws Exception {
       Task task=(Task)taskRule.createAndVerify(taskRepo);
       System.out.println("new count is" + task);
        System.out.println("taskRepo is" + taskRepo);
        //System.out.println("Task Created: "+ ((Task)taskRepo.findById(afterCount)).toString());
        assertThat(taskRepo.getEntity().getStatus(),is(status));

    }

    @After
    public void teardown() {
       taskRepo.delete(taskRepo.getEntity());
        statusRepo.delete(status);
    //    taskRepo.close();
    }


}