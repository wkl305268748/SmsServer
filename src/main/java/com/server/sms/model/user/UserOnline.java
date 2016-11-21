package com.server.sms.model.user;

import java.util.Date;

public class UserOnline {
    private Integer id;

    private Boolean is_online;

    private Integer user_id;

    private Date time;

    private boolean  is_valid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsOnline() {
        return is_online;
    }

    public void setIsOnline(Boolean isOnline) {
        this.is_online = isOnline;
    }

    public Integer getUserId() {
        return user_id;
    }

    public void setUserId(Integer userId) {
        this.user_id = userId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public boolean  getIsValid() {
        return is_valid;
    }

    public void setIsValid(boolean  isValid) {
        this.is_valid = isValid;
    }
}