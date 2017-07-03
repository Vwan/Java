package com.tks.core;

import com.tks.entity.GenericEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by wanjia on 2016/9/3.
 */
public interface IGenericRepoService<T extends GenericEntity> {
    long create(T entity);
    long update(T entity) ;
    void delete(T entity) ;
    void deleteBatch(List<T> entity);
    T findById(long id) ;
    T findById(Class entityClass,long id) ;
    List<T> findAll() ;
    T findSingleByFieldName(String fieldName, String value);
    List<T> findListByFieldName(String fieldName, String value);
    T findSingleByFieldNames(Map<String,String> fieldmaps);
    List<Object> findAllByJoin();
    List<T> FindAllById(String fieldName, long id);
    long count() ;
}
