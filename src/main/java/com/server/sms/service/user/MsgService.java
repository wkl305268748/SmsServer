package com.server.sms.service.user;

import com.google.gson.Gson;
import com.server.sms.mapper.user.MsgMapper;
import com.server.sms.mapper.user.PhoneMapper;
import com.server.sms.mapper.user.UserMapper;
import com.server.sms.mapper.user.UserTokenMapper;
import com.server.sms.util.JpushUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/6 0006.
 */
@Service
public class MsgService {
    @Autowired
    UserTokenMapper userTokenMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    PhoneMapper phoneMapper;
    @Autowired
    MsgMapper msgMapper;

    public boolean smsAll(String token,String imei){
        int uid = userTokenMapper.selectByToken(token).getUserId();
        msgMapper.delete(uid);

        Map<String,String> map = new HashMap<>();
        map.put("type","1");
        JpushUtil jpushUtil = new JpushUtil();
        jpushUtil.pushMap(imei,map);

        return true;
    }

    public boolean smsGet(String token,String imei,String phone){
        int uid = userTokenMapper.selectByToken(token).getUserId();
        msgMapper.delete(uid);

        Map<String,String> map = new HashMap<>();
        map.put("type","2");
        map.put("phone",phone);
        JpushUtil jpushUtil = new JpushUtil();
        jpushUtil.pushMap(imei,map);

        return true;
    }

    public boolean smsEdit(String token,String imei,Integer id,String body){

        Map<String,String> map = new HashMap<>();
        map.put("type","3");
        map.put("id",id+"");
        map.put("body",body);
        JpushUtil jpushUtil = new JpushUtil();
        jpushUtil.pushMap(imei,map);

        return true;
    }
}
