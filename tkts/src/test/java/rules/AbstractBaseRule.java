package rules;

import com.tks.entity.GenericEntity;
import com.tks.repo.impl.GenericRepo;
import org.junit.rules.ExternalResource;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.lang.reflect.ParameterizedType;

/**
 * Created by wanjia on 2016/8/15.
 */
public abstract class AbstractBaseRule<T extends GenericEntity,R extends GenericRepo> extends ExternalResource implements Utils {
    protected T entity;
    protected R repo;
    private Class clazzEntity;
    private Class clazzRepo;
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                before();
                generate();
                save();
                base.evaluate();
                after();

            }
        };
    }
    public void generate(){}
    public void save(){}
    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }


    public void before() {
    }
    public void after(){
    }

    public AbstractBaseRule(){
        this.clazzEntity= (Class)((ParameterizedType)this.getClass().
                getGenericSuperclass()).getActualTypeArguments()[0];
        this.clazzRepo= (Class)((ParameterizedType)this.getClass().
                getGenericSuperclass()).getActualTypeArguments()[1];
        try {
            entity = (T)this.clazzEntity.newInstance();
            repo=(R)this.clazzRepo.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public R getRepo() {
        return repo;
    }

    public void setRepo(R repo) {
        this.repo = repo;
    }
}
