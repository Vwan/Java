package repotest; /**
 * Created by wanjia on 2016/8/7.
 */


import com.tks.entity.Status;
import com.tks.repo.impl.StatusRepo;
import org.junit.*;
import rules.entity.StatusRule;


public class StatusRepoTest {
    private StatusRepo statusRepo;
    private Status status;
    @ClassRule
    static public StatusRule sr = new StatusRule();

    @Before
    public void setup(){
        status = (Status)sr.getEntity();
        statusRepo = new StatusRepo();
        statusRepo.setEntity(status);
       // statusRepo.init();
    }
    @Ignore
    @Test
    public void testCreate() throws Exception {
       sr.createAndVerify(statusRepo);
    }

    @After
    public void teardown(){
        statusRepo.delete((Status)sr.getEntity());
       // statusRepo.commitClose();
    }
}

