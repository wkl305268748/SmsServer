package com.server.sms.json;

import com.server.sms.util.ErrorCodeUtil;

/**
 * Created by Administrator on 2016/10/21.
 */
public class JsonBean {
    int error_code;
    boolean success;
    String msg;
    Object data;

    public JsonBean() {
    }

    public JsonBean(int error_code, Object data) {
        this.error_code = error_code;
        if(error_code == ErrorCodeUtil.SUCCESS)
            this.success = true;
        else
            this.success = false;
        this.msg = ErrorCodeUtil.eMap.get(error_code);
        this.data = data;
    }

    public JsonBean(int error_code) {
        this.error_code = error_code;
        if(error_code == ErrorCodeUtil.SUCCESS)
            this.success = true;
        else
            this.success = false;
        this.msg = ErrorCodeUtil.eMap.get(error_code);

        this.data = null;
    }

    public int getError_code() {
        return error_code;
    }
    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
