package com.ticketfree.entity.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ticketfree.entity.baseentity.HistoryEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "event")
public class Event extends HistoryEntity {

    @JsonIgnore
    private User mainUser;
    private String backgroundImage;
    private String title;
    private String description;
    private String venue; // place of meeting
    private Date dateStart;
    private Date dateEnd;

    public Event() {

    }

    @ManyToOne
    @JoinColumn(name="mainUser", nullable=false)
    public User getMainUser() {
        return mainUser;
    }

    public void setMainUser(User mainUser) {
        this.mainUser = mainUser;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }
}
