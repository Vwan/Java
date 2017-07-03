package com.tks.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by wanjia on 2016/7/16.
 */
@Entity
@Table(name="Knowledge")
public class Knowledge implements Serializable {
    @Id
    private long id;

    public void setId(long id) {
        this.id = id;
    }

    private String name;
    private String summary;
    private String details;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
