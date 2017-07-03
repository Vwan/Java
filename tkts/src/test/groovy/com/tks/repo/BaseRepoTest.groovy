package com.tks.repo

import com.tks.action.BaseTest
import com.tks.repo.impl.GenericRepo
import org.junit.ClassRule
import rules.AbstractBaseRule
import spock.lang.Shared

import java.lang.reflect.ParameterizedType

/**
 * Created by wanjia on 2016/8/16.
 */
public class BaseRepoTest<T extends GenericRepo, U extends AbstractBaseRule> extends BaseTest<T,U> {
    private Class clazz;
    private T repo;
    @ClassRule @Shared
    U rule = (U) ((Class) ((ParameterizedType) this.getClass().
            getGenericSuperclass()).getActualTypeArguments()[1]).newInstance();

    def setup(){
        repo = (T) ((Class) ((ParameterizedType) this.getClass().
                getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
        repo.setEntity(rule.getEntity());
    }
    def teardown(){}


    T getRepo() {
        return (T)repo

    }

    void setRepo(T repo) {
        this.repo = repo
    }

    U getU() {
        return (U)rule
    }

    void setU(U rule) {
        this.rule=rule;
    }
}
