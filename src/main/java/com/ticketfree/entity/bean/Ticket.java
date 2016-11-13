package com.ticketfree.entity.bean;

import com.ticketfree.entity.baseentity.HistoryEntity;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket extends HistoryEntity {

    private Event event;
    private User user;
    private boolean active;
    private String uuid; // iventId + uuid

    public Ticket() {

    }

    @ManyToOne
    @JoinColumn(name="event")
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @ManyToOne
    @JoinColumn(name="user")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
