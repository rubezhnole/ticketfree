package com.ticketfree.entity.baseentity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import java.io.Serializable;

@MappedSuperclass
public class BaseEntity implements Serializable {

    private Integer entityId;

    @Id
    @GeneratedValue
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