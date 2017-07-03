package com.tks.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wanjia on 2016/7/16.
 */
@Entity
public class Language extends GenericEntity{
    @Column(name="lang_code")
    private String code;
    @Column(name="lang_name")
    private String name;

    @OneToMany(targetEntity = Release.class,fetch = FetchType.LAZY)
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
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


}
