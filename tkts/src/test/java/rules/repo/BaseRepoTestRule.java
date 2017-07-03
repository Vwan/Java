package rules.repo;

import com.tks.entity.GenericEntity;
import com.tks.repo.impl.GenericRepo;
import rules.AbstractBaseRule;

/**
 * Created by wanjia on 2016/8/12.
 */
public abstract class BaseRepoTestRule<T extends GenericEntity,R extends GenericRepo>    extends AbstractBaseRule<T,R>  {
    //protected T repo;
    @Override
    public void before() {
        System.out.println("Executing before() - "+repo.getClass().getSimpleName() +"- Entity: "+repo.getEntity().toString());
     //   repo.init();
        System.out.println("Finished before() - "+repo.getClass().getSimpleName() +"- Entity: "+repo.getEntity().toString());
    }

    @Override
    public void after() {
        System.out.println("Executing after() - "+repo.getClass().getSimpleName() +"- Entity: "+repo.getEntity().toString());
        repo.delete(repo.getEntity());
        System.out.println("Finished after() - "+repo.getClass().getSimpleName() +"- Entity: "+repo.getEntity().toString());

    }

    public R getRepo() {
        return repo;
    }

    public void setRepo(R repo) {
        this.repo = repo;
    }

    public BaseRepoTestRule() {
        System.out.println("Initializing RULE - "+this.getClass().getSimpleName() );
    }
    public BaseRepoTestRule(R repo) {
        this.repo=repo;
        System.out.println("Initializing RULE - "+this.getClass().getSimpleName() );

    }

}
