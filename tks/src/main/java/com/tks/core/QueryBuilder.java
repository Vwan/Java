package com.tks.core;

import com.tks.entity.GenericEntity;
import com.tks.exception.CustomException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.lang.reflect.ParameterizedType;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by wanjia on 2016/9/3.
 */
public  class QueryBuilder<T extends GenericEntity> implements IQueryBuilder<T>{
    protected T entity;
    protected Class<T> clazz;
    private EntityManager entityManager = EntityManagerHelper.getEntityManager();

    protected CriteriaBuilder cb;
    protected CriteriaQuery cq;
    protected Metamodel model;
    protected EntityType<T> clazz_;
    protected Root root;

    public QueryBuilder() {
        try {
            this.clazz = (Class) ((ParameterizedType) this.getClass().
                    getGenericSuperclass()).getActualTypeArguments()[0];
            entity = (T) this.clazz.newInstance();
            cb = entityManager.getCriteriaBuilder();
            cq = cb.createQuery(clazz);
            model = entityManager.getMetamodel();
            clazz_ = model.entity(clazz);
            root = cq.from(clazz_);
            cq = cq.select(root);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public TypedQuery getTypedQuery(String fieldName,String value){
        cq.where(cb.equal(root.get(clazz_.getSingularAttribute(fieldName)), value)).getSelection();
        TypedQuery typedQuery = entityManager.createQuery(cq);
        return typedQuery;
    }
    public T doGetSingleResult(String fieldName,String value){
        try {
            return (T) getTypedQuery(fieldName, value).getSingleResult();
        } catch (NoResultException e){
            System.out.println("No Result Found");
        //    throw new CustomException("No Result Found","400");
        }
        return null;
    }
    public List<T> doGetResultList(String fieldName,String value){
        return getTypedQuery(fieldName,value).getResultList();
    }

    public T doGetSingleResultByFields(Map<String,String> fieldmaps){
        return (T)getTypedQuery(fieldmaps).getSingleResult();
    }

    public TypedQuery getTypedQuery(Map<String,String> fieldmaps){
        List<Predicate> predicatesList = new LinkedList<Predicate>();
        Expression<String> exp;
        for(String fieldName:fieldmaps.keySet()) {
            Predicate p = cb.and(cb.equal(root.get(clazz_.getSingularAttribute(fieldName)), fieldmaps.get(fieldName)));
            predicatesList.add(p);
        }
        Predicate[] predArray = new Predicate[predicatesList.size()];
        predicatesList.toArray(predArray);
        cq.where(predArray);
        try {
            return entityManager.createQuery(cq);
        }
        catch (NoResultException e){
            return  null;
        }
    }

    public T doFindOne(long id){
        T result = entityManager.find(clazz,id);
        if (result==null){
            throw new CustomException("No Results Found","400");
        }
        return result;
    }
    public T doFindOne(Class entityClass,long id){
        T result = (T)entityManager.find(entityClass,id);
        if (result==null){
            throw new CustomException("No Results Found","400");
        }
        return result;
    }

    public List<T> doFindAll() {
         List<T> results = entityManager.createQuery(cq).getResultList();
        if (results==null){
            throw new CustomException("No Results Found","400");
        }
        return results;
    }

    @Override
    public List<T> doFindAllById(String fieldName, long id) {
        return entityManager.createQuery("SELECT t FROM "+entity.getClass().getSimpleName() +" t where "+fieldName+"="+id)
                .getResultList();
    }

    public long doCount() {
        return ((Number)entityManager.createQuery("SELECT COUNT(t) FROM "+entity.getClass().getSimpleName() +" t ")
                // .setParameter("param", value)
                .getSingleResult()).longValue();
    }

    public long doTop1Id(){
        return ((Number)entityManager.createQuery("SELECT max(id) from "+entity.getClass().getSimpleName() +" t ")
                .getSingleResult()).longValue();
    }

    public List<T> doFind(String dependantName, String value, String attribute) {
        T item = doGetSingleResult(dependantName,value);
        if (item==null) {
            throw new IllegalArgumentException("Field Name Not Exists");
        }
        System.out.println(item.getId());
        cq.select(root).where(cb.equal(root.get(clazz_.getSingularAttribute(attribute)), item.getId())).getSelection();
        return entityManager.createQuery(cq).getResultList();
    }
    public CriteriaQuery createCriteriaQuery(){
        return this.cq;
    }
}
