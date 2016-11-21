package com.server.sms.mapper.user;

import com.server.sms.model.user.UserOnline;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserOnlineMapper {

    @Insert("INSERT INTO user_online(is_online,user_id,time,is_valid)VALUES(#{is_online},#{user_id},#{time},#{is_valid})")
    int insert(UserOnline record);

}