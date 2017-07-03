package com.tks.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.StringJoiner;

/**
 * Created by wanjia on 2016/7/16.
 */
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"task_summary","release_id"})})
public class Task extends GenericEntity {

    @Column(name="task_summary")
    private String summary;
    @Column(name="task_description")
    private String description;

    @ManyToOne(targetEntity = Release.class,fetch = FetchType.LAZY)
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="release_id",nullable=false)
    private Release release;

    @OneToOne(fetch=FetchType.LAZY)//,cascade = CascadeType.ALL)
    @JoinColumn( name = "task_status_id",referencedColumnName="id",nullable = false)
    private TaskStatus taskStatus;

    public Task(){}

    public Task(String summary, String description, Release release, TaskStatus taskStatus) {
        this.summary = summary;
        this.description = description;
        this.release = release;
        this.taskStatus = taskStatus;
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

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String toString() {
        return "Task{" +
                "summary='" + summary + '\'' +
                ", description='" + description + '\'' +
                ", release=" + release +
                ", taskStatus=" + taskStatus +

                '}';
    }

}
