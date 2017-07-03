package com.tks.core;

import com.tks.entity.GenericEntity;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

/**
 * Created by wanjia on 2016/9/3.
 */
public interface IQueryBuilder<T extends GenericEntity> {
     TypedQuery getTypedQuery(String fieldName, String value);
     T doGetSingleResult(String fieldName,String value);
     List<T> doGetResultList(String fieldName, String value);

     T doGetSingleResultByFields(Map<String,String> fieldmaps);

     TypedQuery getTypedQuery(Map<String,String> fieldmaps);

     T doFindOne(long id);
     T doFindOne(Class entityClass,long id);
     List<T> doFindAll();

     long doCount() ;
     long doTop1Id();

     List<T> doFind(String dependantName, String value, String attribute) ;
}
