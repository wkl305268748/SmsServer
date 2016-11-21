package com.server.sms.service.user;

import com.server.sms.mapper.user.PhoneMapper;
import com.server.sms.mapper.user.UserMapper;
import com.server.sms.mapper.user.UserTokenMapper;
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

    public boolean AddNewPhone(String token, String imei, Date time){
        int uid = userTokenMapper.selectByToken(token).getUserId();
        Phone phone = new Phone();
        phone.setImei(imei);
        phone.setTime(time);
        phone.setUser_id(uid);
        phoneMapper.insert(phone);
        return true;
    }

}




