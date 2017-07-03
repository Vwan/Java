package com.tks.repo.impl;

import com.tks.core.EntityManagerHelper;
import com.tks.core.QueryBuilder;
import com.tks.entity.GenericEntity;
import com.tks.exception.CustomException;
import com.tks.repo.IGenericRepo;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;

/**
 * Created by wanjia on 2016/8/26.
 */

public abstract class GenericRepo<T extends GenericEntity> extends QueryBuilder<T> implements IGenericRepo<T> {

    protected EntityManager entityManager = EntityManagerHelper.getEntityManager();
//    protected QueryBuilder queryBuilder = new QueryBuilder();

    public boolean exists(T entity){
        return false;
    }

    public long create(T entity) {
       Boolean exists = exists(entity);
        System.out.println("entity id before persist:" + entity.getId());
        System.out.println("does exist exists? " + exists);
        if (exists) {
            throw new CustomException("Already Exists","400");
        }
        else {
            try {
                entityManager.persist(entity);
                // entityManager.merge(entity);
                EntityManagerHelper.commit();
                return entity.getId();
            }catch (Exception e){
                throw new CustomException("Insert Fail With Unexpected Error","500");
            }

        }

    }

    public long update(T entity) {
        if ( doFindOne(entity.getId())==null){
            throw new CustomException("Entity Not Found!","400");
        }
        try {
            entityManager.merge(entity);
            EntityManagerHelper.commit();
            return entity.getId();
        }catch (Exception e){
            throw new CustomException("Update Fail With Unexpected Error","500");
        }
    }
    public void delete(T entity) {
        if ( doFindOne(entity.getId())==null){
            throw new CustomException("Entity Not Found!","400");
        }
        try {
            entityManager.remove(entity);//entityManager.merge(entity));
            EntityManagerHelper.commit();
          /*  T deletedEntity=findById(entity.getId());
            System.out.println("deleted entity should not exist:"+deletedEntity);
            if(deletedEntity!=null){
                throw new CustomException("Delete Fail,please retry","500");
            }*/
        }catch (Exception e){
            throw new CustomException("Delete Fail With Unexpected Error","500");
        }
    }

    public void deleteBatch(List<T> entities) {
        for(T item:entities){
            delete(item);
        }
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

    public List<T> FindAllById(String fieldName, long value){
        return doFindAllById(fieldName,value);
    }
    @Override
    public List<Object> findAllByJoin() {
        return null;
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
