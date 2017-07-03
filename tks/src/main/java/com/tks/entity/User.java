package com.tks.entity;

import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by wanjia on 2016/7/16.
 */
@Entity
@Table(name="user",uniqueConstraints = {@UniqueConstraint(columnNames = {"user_name"})})
public class User extends GenericEntity  {

    @Column(name="user_name", nullable=false)
    private String name;
    @Column(name="password", nullable=false)
    private String password;
    private String email;

    @OneToMany(fetch = FetchType.LAZY)
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private Set<Product> products;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @EmailValidator(message = "must provide a valid email address")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name, String password, String email) {

        this.name = name;
        this.password = password;
        this.email = email;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public User(){}

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", products=" + products +
                '}';
    }
}
