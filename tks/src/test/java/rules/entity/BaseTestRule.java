package rules.entity;

import com.tks.entity.GenericEntity;
import com.tks.repo.impl.GenericRepo;
import rules.AbstractBaseRule;

/**
 * Created by wanjia on 2016/8/12.
 */
public abstract class BaseTestRule<T extends GenericEntity,R extends GenericRepo>  extends AbstractBaseRule<T,R> {

    public void after(){
        clear(repo,entity);
    }

    public void before(){
        System.out.println("Executing before() - "+repo.getClass().getSimpleName() +"- Entity: "+repo.getEntity().toString());
        //repo.init();
        System.out.println("Finished before() - "+repo.getClass().getSimpleName() +"- Entity: "+repo.getEntity().toString());
    }

    public void save(){
        repo.create(entity);
    }

    public void clear(R repo,T entity){
        System.out.println("Executing after() - "+repo.getClass().getSimpleName() +"- Entity: "+repo.getEntity().toString());
       // repo.delete(entity);
       // repo.close();
        System.out.println("Finished after() - "+repo.getClass().getSimpleName() +"- Entity: "+repo.getEntity().toString());

    }
}
