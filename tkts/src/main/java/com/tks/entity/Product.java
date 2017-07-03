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
    private String desc;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
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

    public Product(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", users=" + users +
                '}';
    }
}
