package com.tks.service.impl;

import com.tks.entity.GenericEntity;
import com.tks.repo.impl.GenericRepo;
import com.tks.service.IGenericService;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

/**
 * Created by wanjia on 2016/8/7.
 */
public abstract class AbstractGenericService<T extends GenericEntity,R extends GenericRepo> implements IGenericService<T,R>{
    protected Class clazz;
   protected R repo;

    public AbstractGenericService(){
        try {
        this.clazz = (Class) ((ParameterizedType) this.getClass().
                getGenericSuperclass()).getActualTypeArguments()[1];
        repo = (R) this.clazz.newInstance();
           // repo.init();
    } catch (Exception e) {
        e.printStackTrace();
    }

    }

    @Override
    public long create(T entity) {
        return repo.create(entity);
    }

    @Override
    public long update(T entity) {
       return repo.update(entity);
    }

    @Override
    public void delete(T entity) {
         repo.delete(entity);
    }

    @Override
    public T findById(long id) {
        return (T)repo.findById(id);
    }

    @Override
    public T findById(Class entityClass, long id) {
        return (T) repo.findById(entityClass,id);
    }

    @Override
    public List<T> findAll() {
        return repo.findAll();
    }


    @Override
    public T findSingleByFieldName(String fieldName, String value) {
        return (T)repo.findSingleByFieldName(fieldName,value);
    }

    @Override
    public List findListByFieldName(String fieldName, String value) {
        return findListByFieldName(fieldName,value);
    }

    @Override
    public T findSingleByFieldNames(Map fieldmaps) {
        return (T)repo.findSingleByFieldNames(fieldmaps);
    }

    @Override
    public long count() {
        return repo.count();
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public R getRepo() {
        return repo;
    }

    public void setRepo(R repo) {
        this.repo = repo;
    }
}
