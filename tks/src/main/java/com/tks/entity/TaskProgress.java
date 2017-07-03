package com.tks.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

/**
 * Created by wanjia on 2016/7/16.
 */
@Entity
public class TaskProgress extends GenericEntity {

    @Column(name="progress_details")
    private String details;
    @Column(name="progress_notes")
    private String notes;

   /* @OneToOne(fetch=FetchType.LAZY)//,cascade = CascadeType.ALL)
    @JoinColumn( name = "task_status_id",referencedColumnName="id",nullable = false)
    private TaskStatus taskProgressStatus;*/

    @ManyToOne(targetEntity = Task.class)
    @JoinColumn(name = "task_id",nullable=false)//,columnDefinition = "long default 0")
    private Task task;

    public TaskProgress(){}

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "TaskProgress{" +
                "details='" + details + '\'' +
                ", notes='" + notes + '\'' +
                ", task=" + task +
                '}';
    }
}
