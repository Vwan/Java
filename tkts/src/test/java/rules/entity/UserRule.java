package rules.entity;

import com.tks.entity.User;
import com.tks.repo.impl.UserRepo;
import org.apache.commons.lang.RandomStringUtils;

/**
 * Created by wanjia on 2016/8/12.
 */
public class UserRule extends BaseTestRule<User,UserRepo> {

    public void generate(){
        //entity = new Status ("IN PROGRESS111","IN PROGRESS111");
        entity=new User(RandomStringUtils.random(5,true,false), RandomStringUtils.random(5,true,false), RandomStringUtils.random(5,true,false)+"test@tkts.com");
        System.out.println(entity.toString());
    }

}
