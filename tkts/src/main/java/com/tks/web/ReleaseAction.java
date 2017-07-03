package com.tks.web;

import com.tks.entity.Product;
import com.tks.entity.Release;
import com.tks.repo.impl.ProductRepo;
import com.tks.service.impl.ProductService;
import com.tks.service.impl.ReleaseService;

/**
 * Created by wanjia on 2016/8/1.
 */
public class ReleaseAction extends BaseAction<Release,ReleaseService>{

    public ReleaseAction(){
        service=new ReleaseService();
    }
    public long doCreate(){
        System.out.println("createRelease - Release in Release action:"+entity);

        long id =service.create(entity);
        return id;
    }

    /*private Product getProductByRelease(Release release) {
        String name =release.getProduct().getName();
        System.out.println("getStatusByRelease - status name is: " + name);
        ProductService service= new ProductService();
        service.setRepo(new ProductRepo());
        Product product =(Product)service.findByUniqueName("name",name);
        System.out.println("getStatusByRelease - status is" + product);
        return product;
    }*/

    private Product getProductByRelease(Release release) {
        long id =release.getProduct().getId();
        System.out.println("getProductByRelease - product id is: " + id);
        ProductService service= new ProductService();
        service.setRepo(new ProductRepo());
        Product product =(Product)service.findById(id);
        System.out.println("getProductByRelease - product is" + product);
        return product;
    }

    @Override
    public String toString() {
        return "ReleaseAction{" +
                "release=" + entity +
                ", datamap=" + datamap +
                '}';
    }
}
