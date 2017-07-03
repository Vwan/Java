package rules.entity;

import com.tks.entity.Product;
import com.tks.entity.User;
import com.tks.repo.impl.ProductRepo;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by wanjia on 2016/8/12.
 */
public class ProductRule extends BaseTestRule<Product,ProductRepo> {
    private UserRule userRule = new UserRule();

    public void before(){
        super.before();
        userRule.before();
    }

    public void generate(){
        userRule.generate();
        User user = userRule.getEntity();
        userRule.getRepo().create(user);
        System.out.println("User in taskrule: "+user);

        //entity = new Product ("IN PROGRESS111","IN PROGRESS111");
        entity=new Product(RandomStringUtils.random(5,true,false), RandomStringUtils.random(5,true,false));
        System.out.println("entity in ProductRule - " + entity);
        entity.getUsers().add(user);
        System.out.println(entity.toString());

    }
    public void after(){
        super.after();
        userRule.after();
    }

    public ProductRule(){

    }

}
