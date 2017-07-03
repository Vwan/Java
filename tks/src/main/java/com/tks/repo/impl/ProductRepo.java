package com.tks.repo.impl;

import com.tks.entity.Language;
import com.tks.entity.Product;
import com.tks.exception.CustomException;

/**
 * Created by wanjia on 2016/7/30.
 */
public class ProductRepo extends GenericRepo<Product> {
    public boolean exists(Product product){
        if (product.getName()==null){
            throw new CustomException("Product Name is empty","400");
        }
        return (findSingleByFieldName("name",product.getName())==null?false:true);
    }
}
