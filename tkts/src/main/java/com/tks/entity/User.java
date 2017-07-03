package com.tks.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by wanjia on 2016/7/16.
 */
@Entity
@Table(name="user")
public class User extends GenericEntity  {

    @Column(name="user_name")
    private String name;
    private String password;
    private String email;

    @OneToMany(targetEntity = Release.class,fetch = FetchType.LAZY)
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private Set<Product> products;
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public User(){}

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
