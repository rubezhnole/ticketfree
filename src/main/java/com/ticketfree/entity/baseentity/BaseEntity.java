package com.ticketfree.entity.baseentity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;

@MappedSuperclass
public class BaseEntity implements Serializable {

    private Integer entityId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entityId")
    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    @Transient
    @JsonIgnore
    public boolean isNew() {
        return null == getEntityId();
    }
}