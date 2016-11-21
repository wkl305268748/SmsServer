package com.server.sms.model.user;

import java.util.Date;

public class UserToken {
    private Integer id;

    private String token;

    private Integer user_id;

    private Date time;

    private boolean is_valid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
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

    public boolean getIsvalid() {
        return is_valid;
    }

    public void setIsvalid(boolean isvalid) {
        this.is_valid = isvalid;
    }
}