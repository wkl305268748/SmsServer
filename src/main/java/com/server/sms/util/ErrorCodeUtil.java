package com.server.sms.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/21.
 */
public class ErrorCodeUtil {

    /**命名规则
     *
     * 模块名_错误对象_错误动作
     */

    public static final int SUCCESS = 0;
    public static final int REQUEST_ERROR_PARAM = 102;
    public static final int REQUEST_NO_PARAM = 101;
    public static final int REQUEST_TOKEN_OVERTIME = 103;
    public static final int REQUEST_TOKEN_ERROR = 104;
    public static final int LOGIN_USER_PASS_ERROR = 200;
    public static final int LOGIN_USER_DISABLE = 201;
    public static final int SMS_SERVER_ERROR=202;
    public static final int SMS_CODE_OVERTIME=203;
    public static final int COKIE_NULL=204;
    public static final int SMS_CODE_ERROR=205;
    public static final int USER_NULL=301;
    public static final int USER_BLOCKED=302;
    public static final int USER_ALREADY_EXISTS=303;
    public static final int PASSWORD_ERROR=304;
    public static final int TOKEN_LOSE_LOGIN=305;
    public static final int REGISTER_USER_ERROR = 210;
    public static final int REGISTER_CODE_ERROR = 211;
    public static final int SMS_SEND_ERROR = 212;
    public static final int ACTIVATED_ROBOT_NULL = 221;
    public static final int ACTIVATED_ROBOT_DISABLE = 222;
    public static final int BIND_PHONE_NULL = 231;
    public static final int BIND_ROBOT_NULL = 232;
    public static final int BIND_AUTHORITY_NULL = 233;
    public static final int BIND_GET_NULL = 235;
    public static final int ROBOT_NULL=401;
    public static final int ROBOT_BLOCKED=402;
    public static final int ROBOT_GET_NULL=403;

    public static Map<Integer, String> eMap;
    static{
        eMap = new HashMap<Integer, String>();
        eMap.put(SUCCESS, "成功");
        eMap.put(REQUEST_ERROR_PARAM, "请求失败，参数错误");
        eMap.put(REQUEST_NO_PARAM, "请求失败，缺少参数");
        eMap.put(REQUEST_TOKEN_OVERTIME, "该ID不存在");
        eMap.put(REQUEST_TOKEN_ERROR, "请求失败，token错误");
        eMap.put(LOGIN_USER_PASS_ERROR, "登陆失败，用户名或密码错误");
        eMap.put(LOGIN_USER_DISABLE, "短信请求间隔小于60s");
        eMap.put(REGISTER_USER_ERROR, "注册失败，用户已存在");
        eMap.put(REGISTER_CODE_ERROR, "注册失败，验证码错误");
        eMap.put(USER_NULL,"用户不存在");
        eMap.put(USER_BLOCKED,"用户被封禁");
        eMap.put(USER_ALREADY_EXISTS,"用户已存在");
        eMap.put(PASSWORD_ERROR,"密码错误");
        eMap.put(TOKEN_LOSE_LOGIN,"Token失效，请重新登陆");
        eMap.put(SMS_SEND_ERROR, "验证码发送失败");
        eMap.put(SMS_SERVER_ERROR,"短信服务器异常");
        eMap.put(SMS_CODE_OVERTIME,"短信验证码提交超时");
        eMap.put(COKIE_NULL,"Cookie不存在");
        eMap.put(SMS_CODE_ERROR,"短信验证码错误");
        eMap.put(ACTIVATED_ROBOT_NULL, "机器人编号不存在");
        eMap.put(ACTIVATED_ROBOT_DISABLE, "机器人被禁用");
        eMap.put(BIND_ROBOT_NULL, "绑定失败，机器人不存在");
        eMap.put(BIND_PHONE_NULL, "询问失败，用户不存在");
        eMap.put(BIND_AUTHORITY_NULL, "询问失败，机器权限未设定");
        eMap.put(BIND_GET_NULL, "获取绑定信息失败，没有绑定信息");
        eMap.put(ROBOT_NULL,"机器人不存在");
        eMap.put(ROBOT_BLOCKED,"机器人被封禁");
        eMap.put(ROBOT_GET_NULL,"机器人未绑定");
    }
}
