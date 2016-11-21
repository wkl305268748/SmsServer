package com.server.sms.mapper.user;

import com.server.sms.model.user.Msg;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2016/11/6 0006.
 */
@Mapper
public interface MsgMapper {

    @Delete("delete * from msg where user_id = #{user_id}")
    int delete(@Param(value = "user_id") int user_id);

    @Insert("INSERT INTO msg(imei,msg_id,address,body,date) VALUES(#{imei},#{msg_id},#{address},#{body},#{date})")
    int insert(Msg msg);
}
