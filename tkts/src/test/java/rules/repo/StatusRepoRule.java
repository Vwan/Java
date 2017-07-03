package rules.repo; /**
 * Created by wanjia on 2016/8/7.
 */


import com.tks.entity.Status;
import com.tks.repo.impl.StatusRepo;
import org.junit.After;
import rules.Utils;
import rules.entity.StatusRule;


public class StatusRepoRule extends BaseRepoTestRule<Status,StatusRepo> implements Utils {
    Status status;
    public static StatusRule statusRule= new StatusRule();
  /*  @ClassRule
    static public RuleChain rule =  RuleChain.outerRule(new StatusRepoRule())
            .around(statusRule);*/
    public StatusRepoRule() {
        statusRule.before();
        status=(Status)statusRule.getEntity();
        repo=new StatusRepo();
        repo.setEntity(status);

    }

     public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public void before(){
        super.before();

    }
    @After
    public void after(){
        super.after();
    }
}

