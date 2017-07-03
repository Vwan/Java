package com.tks.repo

import com.tks.entity.Product
import com.tks.repo.impl.ProductRepo
import rules.entity.ProductRule
import spock.lang.Unroll
/**
 * Created by wanjia on 2016/8/7.
 */
public class ProductRepoTest extends BaseRepoTest<ProductRepo,ProductRule> {
    Product product
    def setup(){
    }
    def teardown(){

    }

    @Unroll("create new product in db, expecting #result")
    def "P: Create New product"(){
        setup:
        expect:
        System.out.println("repo entity is:"+repo.getEntity())
        rule.createAndVerify(repo);
    }

    @Unroll("create product existing already in db, expecting #result")
    def "F: Create product existing already "(){
        setup:
        rule.createAndVerify(repo);
        when:
        repo.create(repo.getEntity());
        then:
        def ex = thrown(IllegalArgumentException)
    }

    @Unroll("find product by name,expecting #result")
    def "P: Find product by Name"(){
        expect:
        rule.verifyFindByFieldName(repo,"name",repo.getEntity().getName());

    }
    @Unroll("Find All product,expecting #result")
    def "P: Find All product"() {
        setup:
        rule.createAndVerify(repo);
        expect:
        List<Product> product = rule.verifyFindAll(repo, repo.count());
        for (Product s : product) {
        System.out.println("result is:" + s)
    }
    }
}
