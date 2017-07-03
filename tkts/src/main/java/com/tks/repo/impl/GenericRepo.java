package com.tks.repo.impl;

import com.tks.core.EntityManagerHelper;
import com.tks.entity.GenericEntity;
import com.tks.repo.IGenericRepo;
import com.tks.core.QueryBuilder;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;

/**
 * Created by wanjia on 2016/8/26.
 */

public abstract class GenericRepo<T extends GenericEntity> extends QueryBuilder<T> implements IGenericRepo<T> {

    private EntityManager entityManager = EntityManagerHelper.getEntityManager();
//    protected QueryBuilder queryBuilder = new QueryBuilder();

    public long create(T entity){
          if (doFindOne(entity.getId())!=null) {
            throw new IllegalArgumentException("Entity Already Exists");
          }
        entityManager.persist(entity);
        EntityManagerHelper.commit();
        return entity.getId();
    }
    public long update(T entity) {
        if (doFindOne(entity.getId())==null){
            return 0;
        }
        entityManager.merge(entity);
        EntityManagerHelper.commit();
        return entity.getId();
    }
    public void delete(T entity) {
        entityManager.remove(entityManager.merge(entity));
        EntityManagerHelper.commit();
    }

    public T findById(long id) {
        return (T)doFindOne(id);
    }
    public T findById(Class entityClass,long id) {
        return (T)doFindOne(entityClass,id);
    }
    public List<T> findAll() {
        return doFindAll();
    }

    public T findSingleByFieldName(String fieldName, String value){
        return (T)doGetSingleResult(fieldName,value);
    }

    public List<T> findListByFieldName(String fieldName, String value){
        return doGetResultList(fieldName,value);
    }
    public T findSingleByFieldNames(Map<String,String> fieldmaps){
        return (T)doGetSingleResultByFields(fieldmaps);
    }

    public long count() {
        return doCount();
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }
}
