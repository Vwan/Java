package com.tks.repo.impl;

import com.tks.core.IReleaseRepoService;
import com.tks.entity.Language;
import com.tks.entity.Product;
import com.tks.entity.Release;
import com.tks.entity.User;
import com.tks.exception.CustomException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanjia on 2016/7/30.
 */
public class ReleaseRepo extends GenericRepo<Release> implements IReleaseRepoService{
    public List<Object> findAllByJoin() {
        List<Object> releases = new ArrayList<>();
        List results=  entityManager.createNativeQuery("select r.* from Releases r " +
                "join Product p on r.product_id = p.id").getResultList();
        return releases;
    }

    @Override
    public List<Release> findByProduct(Product product) {
        String id=Long.toString(product.getId());
        System.out.println(id);
        return findListByFieldName("product",id);
    }

    public boolean exists(Release release){
            if (release.getName()==null){
                throw new CustomException("Release Name is empty","400");
            }
            return (findSingleByFieldName("name",release.getName())==null?false:true);
    }
}
