package com.ticketfree.entity.baseentity;

import com.ticketfree.entity.bean.User;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class HistoryEntity extends BaseEntity {

    private Date createDate;
    private User createBy;
    private Date editDate;
    private User editBy;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @OneToOne
    @JoinColumn(name = "createBy")
    public User getCreateBy() {
        return createBy;
    }

    public void setCreateBy(User createBy) {
        this.createBy = createBy;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    @OneToOne
    @JoinColumn(name = "editBy")
    public User getEditBy() {
        return editBy;
    }

    public void setEditBy(User editBy) {
        this.editBy = editBy;
    }

    @PrePersist
    protected void onCreate() {
        setCreateDate(new Date());
    }

    @PreUpdate
    protected void onUpdate() {
        setEditDate(new Date());
    }
}
