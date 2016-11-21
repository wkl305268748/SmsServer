package com.server.sms.json.response;

/**
 * Created by Administrator on 2016/10/21.
 */
public class UserResponse{
   public  boolean  check;

    public UserResponse(boolean check){
        this.check = check;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
