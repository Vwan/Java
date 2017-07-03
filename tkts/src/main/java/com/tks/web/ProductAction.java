package com.tks.web;

import com.tks.entity.Product;
import com.tks.repo.impl.ProductRepo;
import com.tks.service.impl.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wanjia on 2016/8/1.
 */
public class ProductAction extends BaseAction<Product,ProductService>{
    private Product product;
    private List<Product> products;
    private Map<String, Object> productmap = new HashMap<>();
    private ProductService productService = new ProductService();
    private ProductRepo productRepo = new ProductRepo();

    public ProductAction(){
        service=new ProductService();
    }

    public String createProduct(){
        productmap.clear();
        productmap.put("success","true");
        productService.create(product);
        productmap.put("product",product);
        return SUCCESS;
    }


    public String listProduct(){
        productmap.clear();
        //  productmap.put("success","true");
        List<Product> productes = productService.findAll();
        productmap.put("product",productes);
        return SUCCESS;
    }

    public String deleteProduct(){
        productmap.clear();
        productmap.put("success","true");
        System.out.println("deleteproduct - product ID: "+product.getId());
        Product existingproduct = (Product)productRepo.findById(product.getId());
        System.out.println("deleteproduct - product: "+existingproduct);
        //    productRepo.setEntity(existingproduct);
        //  productService.setRepo(productRepo);
        productService.delete(existingproduct);
        return SUCCESS;
    }

    public String updateProduct(){
        productmap.clear();
        productmap.put("success","true");
        System.out.println("updateproduct - product ID: "+product.getId());
        Product existingproduct = (Product)productRepo.findById(product.getId());
        // productRepo.setEntity(existingproduct);
        //productService.setRepo(productRepo);
        productService.update(product);
        // System.out.println("result is: "+productService.findByUniqueName("name",product.getName()));
        productmap.put("product",product);
        return SUCCESS;
    }
    
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Map<String, Object> getProductmap() {
        return productmap;
    }

    public void setProductmap(Map<String, Object> productmap) {
        this.productmap = productmap;
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public ProductRepo getProductRepo() {
        return productRepo;
    }

    public void setProductRepo(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
}
