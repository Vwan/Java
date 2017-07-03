package com.tks.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Created by wanjia on 2016/7/16.
 */
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "status_name") })
public class TaskStatus extends GenericEntity{

    @Column(name="status_name")
    private String name;
    @Column(name="status_desc")
    private String description;

    public TaskStatus(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public TaskStatus(){}


    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add("name = " + name)
                .add("description = " + description)
                .add("id = " + id).toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskStatus that = (TaskStatus) o;

        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.description, that.description) &&
                Objects.equals(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, id);
    }


}
