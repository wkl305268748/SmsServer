package com.server.sms.mapper.user;

import com.server.sms.model.user.Phone;
import org.apache.ibatis.annotations.*;

/**
 * Created by Administrator on 2016/11/6 0006.
 */
@Mapper
public interface PhoneMapper {

    @Insert("INSERT INTO phone(user_id,imei,nickname,remark,is_success,time) VALUES(#{user_id},#{imei},#{nickname},#{remark},#{is_success},#{time})")
    int insert(Phone phone);

    @Select("SELECT * FROM phone WHERE imei = #{imei} ")
    Phone selectByImei(@Param(value = "imei") String imei);

    @Update("UPDATE user SET nickname=#{nickname},remark=#{remark},is_success=#{is_success},time=#{time} WHERE id=#{id}")
    int update(Phone phone);
}
