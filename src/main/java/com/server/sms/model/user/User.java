package com.server.sms.model.user;

import java.util.Date;

public class User {
    private Integer id;

    private String username;

    private String password;

    private Date regtime;

    private Boolean is_disable;

    private Boolean is_valid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getRegtime() {
        return regtime;
    }

    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }

    public Boolean getIsDisable() {
        return is_disable;
    }

    public void setIsDisable(Boolean isDisable) {
        this.is_disable = isDisable;
    }

    public Boolean getIsValid() {
        return is_valid;
    }

    public void setIsValid(Boolean isValid) {
        this.is_valid = isValid;
    }

}