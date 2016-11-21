package com.server.sms.json.response;

/**
 * Created by Administrator on 2016/10/21.
 */
public class PasssmsResponse{
      private String phone;
      private Boolean is_password;
      private String token;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIs_password() {
        return is_password;
    }

    public void setIs_password(Boolean is_password) {
        this.is_password = is_password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
