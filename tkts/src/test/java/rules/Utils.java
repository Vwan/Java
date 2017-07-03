package rules;

import com.tks.entity.GenericEntity;
import com.tks.repo.impl.GenericRepo;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

/**
 * Created by wanjia on 2016/8/14.
 */
public interface Utils<T extends GenericEntity,R extends GenericRepo> {
    default T createAndVerify(R repo){
        long id = repo.getEntity().getId();
        System.out.println("id before find is:" + id);
        System.out.println("repo entity is:"+repo.getEntity());
        T result = (T)repo.findById(id);
        System.out.println("result in utils:"+result);
        assertNotNull(result);
        return result;
    }

    default T verifyFindByFieldName(R repo,String name,String value){
        T entity =  (T)repo.findSingleByFieldName(name,value);
        System.out.println("entity is:"+entity);
        long id = entity.getId();
        System.out.println("id is:"+id);
        System.out.println("top 1 id is:"+repo.doTop1Id());
        assertThat(id,is(repo.doTop1Id()));
        return entity;
    }
    default List<T> verifyFindAll(R repo, long size){
        List<T> entity =  repo.findAll();
        assertNotNull(entity);
        assertThat(entity.size(),is((int)size));
        return entity;
    }
}
