package com.server.sms.service.user;

import com.server.sms.mapper.user.MsgMapper;
import com.server.sms.mapper.user.PhoneMapper;
import com.server.sms.mapper.user.UserMapper;
import com.server.sms.mapper.user.UserTokenMapper;
import com.server.sms.model.user.Msg;
import com.server.sms.model.user.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class PhoneService {
    @Autowired
    UserTokenMapper userTokenMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    PhoneMapper phoneMapper;
    @Autowired
    MsgMapper msgMapper;

    public boolean AddNewPhone(int user_id, String imei, Date time){
        Phone phone = new Phone();
        phone.setImei(imei);
        phone.setTime(time);
        phone.setUser_id(user_id);
        phoneMapper.insert(phone);
        return true;
    }

    public boolean AddSuccessPhone(String imei, Date time){
        Phone phone = phoneMapper.selectByImei(imei);
        phone.setIs_success(true);
        phone.setTime(time);
        phoneMapper.update(phone);
        return true;
    }

    public boolean AddErrorPhone(String imei, Date time){
        Phone phone = phoneMapper.selectByImei(imei);
        phone.setIs_success(false);
        phone.setTime(time);
        phoneMapper.update(phone);
        return true;
    }

    public boolean AddMsg(int id,String address,String body,long date,String imei){
        //增加短信
        Msg msg = new Msg();
        msg.setMsg_id(id);
        msg.setAddress(address);
        msg.setBody(body);
        msg.setDate(new Date(date));
        msg.setImei(imei);
        msgMapper.insert(msg);
        return true;
    }

}




