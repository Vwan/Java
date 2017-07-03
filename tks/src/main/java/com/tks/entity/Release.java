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
    private String description;

    @ManyToOne(targetEntity = Product.class)//,cascade = CascadeType.ALL)
    @JoinColumn(name="product_id",nullable=false)
    private Product product;

    @ManyToMany(fetch = FetchType.LAZY)//,mappedBy = "releases")//,cascade = CascadeType.ALL)
    @JoinTable(name="releases_languages",
            joinColumns={@JoinColumn(name="release_id")},
            inverseJoinColumns={@JoinColumn(name="language_id")})
    private Set<Language> languages=new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {

        return description;
    }

    public Release() {
    }

    public void setDescription(String description) {
        this.description = description;
    }

      public Release(String name, String description, Product product, Set<Language> languages) {
        this.name = name;
        this.description = description;
        this.product = product;
        this.languages = languages;
    }

    public Release(String name, String description, Product product) {
        this.name = name;
        this.description = description;
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
                ", desc='" + description + '\'' +
                ", product=" + product +
                ", languages=" + languages +
                '}';
    }


}
