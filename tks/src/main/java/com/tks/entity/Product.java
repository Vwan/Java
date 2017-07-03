package com.tks.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by waon 2016/7/16.
 */
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "product_name") })
public class Product extends GenericEntity  {

    @Column(name="product_name",unique = true)
    private String name;
    @Column(name="product_desc")
    private String description;

    @OneToMany(fetch = FetchType.LAZY)//,cascade = CascadeType.ALL)
    private Set<User> users = new HashSet<>();

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product() {
    }

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", desc='" + description + '\'' +
                ", users=" + users +
                '}';
    }
}
