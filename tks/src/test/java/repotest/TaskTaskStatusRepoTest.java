package repotest; /**
 * Created by wanjia on 2016/8/7.
 */


import com.tks.entity.TaskStatus;
import com.tks.repo.impl.TaskStatusRepo;
import org.junit.*;
import rules.entity.StatusRule;


public class TaskTaskStatusRepoTest {
    private TaskStatusRepo statusRepo;
    private TaskStatus taskStatus;
    @ClassRule
    static public StatusRule sr = new StatusRule();

    @Before
    public void setup(){
        taskStatus = (TaskStatus)sr.getEntity();
        statusRepo = new TaskStatusRepo();
        statusRepo.setEntity(taskStatus);
       // statusRepo.init();
    }
    @Ignore
    @Test
    public void testCreate() throws Exception {
       sr.createAndVerify(statusRepo);
    }

    @After
    public void teardown(){
        statusRepo.delete((TaskStatus)sr.getEntity());
       // statusRepo.commitClose();
    }
}

