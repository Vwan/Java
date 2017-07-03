package com.tks.action

import com.tks.entity.Product
import com.tks.repo.BaseRepoTest
import com.tks.repo.impl.ProductRepo
import com.tks.web.ProductAction
import rules.entity.ProductRule
/**
 * Created by wanjia on 2016/8/16.
 */
class ProductActionTest extends BaseRepoTest<ProductRepo,ProductRule> {

    def setup(){
    }

    def "test create Product"(){
        setup:
            Product product = rule.getEntity();
            System.out.println("+++++"+product);
           // request.setAttribute("Product",Product);
            ProductAction productAction = new ProductAction();
            productAction.setEntity(product);
        when:
            String result = productAction.create();
            System.out.println("Product list is: "+productAction.getDatamap());
        then:
           result=="success";

    }

    def "find all Product"(){
        when:
            ProductAction productAction = new ProductAction();
            def result = productAction.listAll()
            System.out.println("Product list is: "+productAction.getDatamap());
        then:
            result!=null
    }

    def "delete Product"(){
        when:
        Product product = rule.getEntity();
        ProductAction productAction = new ProductAction();
        productAction.setEntity(product);
        def result = productAction.delete();
        System.out.println("Product list is: "+productAction.getDatamap());

        then:
        result!=null
    }

    def "update Product"(){
        when:
        Product product = rule.getEntity();
        product.setDesc("Modified")
        product.setName("name modified");
        ProductAction productAction = new ProductAction();
        productAction.setEntity(product);
        def result = productAction.update();
        System.out.println("Product list is: "+productAction.getDatamap());

        then:
        result!=null
    }
}
