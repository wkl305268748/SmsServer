package com.server.sms.json.response;

/**
 * Created by Administrator on 2016/10/22.
 */
public class SmsSendResponse{
    private String phone;
    private String cookie;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }
}
