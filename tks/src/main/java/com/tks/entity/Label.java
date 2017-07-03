package com.tks.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by wanjia on 2016/7/16.
 */
@Entity
@Table(name="Labels")
public class Label  implements Serializable {
    @Id
    private long id;
    private String labelName;
    @Id
    public long getId() {
        return id;
    }
    @Id
    public void setId(long id) {
        this.id = id;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }
}
