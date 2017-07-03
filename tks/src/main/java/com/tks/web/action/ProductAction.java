package com.tks.web.action;

import com.tks.entity.Product;
import com.tks.entity.TaskStatus;
import com.tks.entity.User;
import com.tks.service.impl.ProductService;
import org.apache.struts2.convention.annotation.Namespace;

import java.util.List;

/**
 * Created by wanjia on 2016/8/1.
 */
@Namespace("/product")
public class ProductAction extends BaseAction<Product,ProductService> {

    public ProductAction() {
        service = new ProductService();
    }
    public Product getEntity(){
        System.out.println("getEntity in ProductAction is executed: user= "+entity);
        return entity;
    }

    public void setEntity(Product item) {
        System.out.println("setEntity in ProductAction is executed: user= "+item);
        this.entity = item;
        System.out.println("setEntity in ProductAction is executed: entity="+entity);
    }

    public void setEntities(List<Product> items) {
        System.out.println("setEntities in ProductAction is executed: user= "+items);
        entities= items;
        System.out.println("setEntities in ProductAction is executed: entity="+entities);
    }

    public List<Product> getEntities(){

        System.out.println("getEntities in ProductAction is executed: entity="+entities);
        return entities;
    }
}