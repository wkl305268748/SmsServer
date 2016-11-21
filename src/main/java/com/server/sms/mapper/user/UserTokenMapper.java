package com.server.sms.mapper.user;

import com.server.sms.model.user.UserToken;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserTokenMapper {

    @Insert("INSERT INTO user_token(token,user_id,time,is_valid) VALUES (#{token},#{user_id},#{time},#{is_valid})")
    int insert(UserToken record);

    @Select("SELECT * FROM user_token WHERE token=#{token} AND is_valid=1")
    UserToken selectByToken(String token);

    @Delete("DELETE  FROM user_token WHERE user_id=#{user_id}")
    int deleteTokenByUserId(@Param(value = "user_id") Integer user_id);
}