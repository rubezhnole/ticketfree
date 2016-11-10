package com.ticketfree.entity.bean;

import com.ticketfree.entity.baseentity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.beans.Transient;

@Entity
@Table(name = "user")
public class User extends BaseEntity {

    private String username;
    private String password;
//    private String roles;
    private String email;

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
}