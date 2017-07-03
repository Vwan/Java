package com.tks.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.StringJoiner;

/**
 * Created by wanjia on 2016/7/16.
 */
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"task_summary","status_id","release_id"})})
public class Task extends GenericEntity {

    @Column(name="task_summary")
    private String summary;
    @Column(name="task_description")
    private String description;

    @ManyToOne(targetEntity = Release.class,fetch = FetchType.LAZY)
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="release_id",nullable=false)

    private Release release;

    @OneToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn( name = "status_id",referencedColumnName="id")
    private Status status;

    @Transient
    @Column(name="parent_task_id")

    private long parentTaskId;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Task parent;

    public Task(){}

    public Task(String summary, String description, Release release, Status status) {
        this.summary = summary;
        this.description = description;
        this.release = release;
        this.status = status;
    }

    public Task(String summary, String description, Release release, Status status, long parentTaskId) {
        this.summary = summary;
        this.description = description;
        this.release = release;
        this.status = status;
        this.parentTaskId = parentTaskId;
    }

    public Release getRelease() {
        return release;
    }

    public void setRelease(Release release) {
        this.release = release;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public long getParentTaskId() {
        return parentTaskId;
    }

    public void setParentTaskId(long parentTaskId) {
        this.parentTaskId = parentTaskId;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add("summary = " + summary)
                .add("description = " + description)
                .add("release = " + release)
                .add("status = " + status)
                .add("parentTaskId = " + parentTaskId)
                .add("parent = " + parent)
                .add("id = " + id).toString();
    }
}
