package com.tks.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wanjia on 2016/7/16.
 */
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "lang_code") })
public class Language extends GenericEntity{
    @Column(name="lang_code",unique = true, nullable = false)
    private String code;
    @Column(name="lang_name")
    private String name;

    @ManyToMany(mappedBy = "languages")//,cascade = CascadeType.ALL)
    private Set<Release> release=new HashSet<>();

    public Language() {
    }

    public Language(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Language{" +
                "langCode='" + code + '\'' +
                ", langName='" + name + '\'' +
                '}';
    }

    public Set<Release> getRelease() {
        return release;
    }

    public void setRelease(Set<Release> release) {
        this.release = release;
    }
}
