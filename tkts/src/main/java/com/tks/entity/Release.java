package com.tks.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wanjia on 2016/7/16.
 */
@Entity
@Table(name="Releases",uniqueConstraints = {@UniqueConstraint(columnNames="release_name")})
public class Release extends GenericEntity  {

    @Column(name="release_name")
    private String name;
    @Column(name="release_desc")
    private String desc;

    @ManyToOne(targetEntity = Product.class)//,cascade = CascadeType.ALL)
    @JoinColumn(name="product_id",nullable=false)
    private Product product;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Language> languages=new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {

        return desc;
    }

    public Release() {
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

      public Release(String name, String desc, Product product, Set<Language> languages) {
        this.name = name;
        this.desc = desc;
        this.product = product;
        this.languages = languages;
    }

    public Release(String name, String desc, Product product) {
        this.name = name;
        this.desc = desc;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Set<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "Release{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", product=" + product +
                ", languages=" + languages +
                '}';
    }


}
