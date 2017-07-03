package rules.entity;

import com.tks.entity.TaskStatus;
import com.tks.repo.impl.TaskStatusRepo;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by wanjia on 2016/8/12.
 */
public class StatusRule extends BaseTestRule<TaskStatus,TaskStatusRepo> {

    public void generate(){
        //entity = new TaskStatus ("IN PROGRESS111","IN PROGRESS111");
        entity=new TaskStatus(RandomStringUtils.random(5,true,false), RandomStringUtils.random(5,true,false));
        System.out.println(entity.toString());

    }


}
