package com.tks.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by wanjia on 2016/8/12.
 */
//@Entity
@MappedSuperclass
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)//.JOINED)
//@DiscriminatorColumn(name="ENTITY_TYPE",discriminatorType = DiscriminatorType.STRING)
public class GenericEntity  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//AUTO)//.TABLE)
    @Column(unique=true)
    protected long id;

    @Column(name = "created_on", insertable = true, updatable = false)
    Date createdOn;

    @Column(name = "updated_on", insertable = false, updatable = true)
    Timestamp updatedOn;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public GenericEntity() {

    }

    public Date getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Timestamp getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Timestamp updatedOn) {
        this.updatedOn = updatedOn;
    }

    @PrePersist
    public void onCreate() {
        this.setCreatedOn(new Date());
    }

    @PreUpdate
    public void onPersist() {
        this.setUpdatedOn(new Timestamp(new Date().getTime()));
    }

}
