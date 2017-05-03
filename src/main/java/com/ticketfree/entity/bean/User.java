package com.ticketfree.entity.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.JsonObject;
import com.ticketfree.entity.baseentity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.beans.Transient;
import java.util.List;

@Entity
@Table(name = "user")
public class User extends BaseEntity {

    private String username;
    @JsonIgnore
    private String password;
//    private String roles;
    @JsonIgnore
    private String email;
    @JsonIgnore
    private List<Event> events;

    public User() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public String getRoles() {
//        return roles;
//    }
//
//    public void setRoles(String roles) {
//        this.roles = roles;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(mappedBy="mainUser")
    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        json.addProperty("entityId", this.getEntityId());
        json.addProperty("username", this.getUsername());
        return json;
    }
}