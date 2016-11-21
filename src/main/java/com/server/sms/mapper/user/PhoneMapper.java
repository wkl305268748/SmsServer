package com.server.sms.mapper.user;

import com.server.sms.model.user.Phone;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Administrator on 2016/11/6 0006.
 */
@Mapper
public interface PhoneMapper {

    @Insert("INSERT INTO phone(user_id,imei,nickname,remark,time) VALUES(#{user_id},#{imei},#{nickname},#{remark},#{time})")
    int insert(Phone phone);
}
