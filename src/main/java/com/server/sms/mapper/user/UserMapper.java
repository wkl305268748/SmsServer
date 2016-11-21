package com.server.sms.mapper.user;

import com.server.sms.model.user.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user(username,password,regtime,is_disable,is_valid) VALUES(#{username},#{password},#{regtime},#{is_disable},#{is_valid})")
    int insert(User record);

    @Select("SELECT * FROM user WHERE id = #{id} AND is_valid=1")
    User selectByPrimaryKey(@Param(value = "id") Integer id);

    @Select("SELECT * FROM user WHERE is_valid=1")
    List<User> selectAll();

     @Select("SELECT * FROM user WHERE username=#{username} AND is_valid=1")
    User selectUserByUserName(@Param(value = "username") String username);

    @Select("SELECT * FROM user WHERE phone=#{phone} AND is_valid=1")
    User selectUserByPhone(@Param(value = "phone") String phone);

    @Update("UPDATE user SET password=#{password} WHERE id=#{id}")
    int updatePasswordById(@Param(value = "id") Integer id, @Param(value = "password") String password);

}