package com.tks.entity;

import javax.persistence.*;
import java.io.Serializable;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public GenericEntity() {

    }
}
