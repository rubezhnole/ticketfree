package com.ticketfree.entity.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.JsonObject;
import com.ticketfree.entity.baseentity.HistoryEntity;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "event")
public class Event extends HistoryEntity {

    @JsonIgnore
    private User mainUser;
    private String backgroundImage;
    private String title;
    private String description;
    private String venue; // place of meeting
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date dateStart;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
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

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        json.addProperty("entityId", this.getEntityId());
        json.addProperty("backgroundImage", this.getBackgroundImage());
        json.addProperty("title", this.getTitle());
        json.addProperty("description", this.getDescription());
        json.addProperty("venue", this.getVenue());
        json.addProperty("dateStart", DateFormatUtils.format(this.getDateStart(), "dd-MM-yyyy HH:mm"));
        json.addProperty("dateEnd", DateFormatUtils.format(this.getDateEnd(), "dd-MM-yyyy HH:mm"));
        return json;
    }
}
