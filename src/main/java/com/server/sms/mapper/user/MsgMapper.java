package com.server.sms.mapper.user;

import com.server.sms.model.user.Phone;
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
}
