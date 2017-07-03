package rules.entity;

import com.tks.entity.Status;
import com.tks.repo.impl.StatusRepo;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by wanjia on 2016/8/12.
 */
public class StatusRule extends BaseTestRule<Status,StatusRepo> {

    public void generate(){
        //entity = new Status ("IN PROGRESS111","IN PROGRESS111");
        entity=new Status(RandomStringUtils.random(5,true,false), RandomStringUtils.random(5,true,false));
        System.out.println(entity.toString());

    }


}
