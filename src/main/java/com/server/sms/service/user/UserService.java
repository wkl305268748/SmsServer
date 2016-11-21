package com.server.sms.service.user;

import com.server.sms.mapper.user.UserMapper;
import com.server.sms.mapper.user.UserTokenMapper;
import com.server.sms.model.user.User;
import com.server.sms.model.user.UserToken;
import com.server.sms.util.ErrorCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserTokenMapper userTokenMapper;

    /**
     * 用户不存在性校验
     *
     * @param phone
     * @return
     */
    public int checkPhoneNo(String phone) {
        //参数判断
        if (phone.length() != 11)
            return ErrorCodeUtil.REQUEST_ERROR_PARAM;

        User user = userMapper.selectUserByPhone(phone);
        if (user != null)
            return ErrorCodeUtil.USER_ALREADY_EXISTS;
        return ErrorCodeUtil.SUCCESS;
    }

    /**
     * 手机号校验流程
     * 1、校验用户是否存在
     * 2、校验用户是否封禁
     *
     * @param phone
     * @return
     */
    public int checkPhone(String phone) {
        //参数判断
        if (phone.length() != 11)
            return ErrorCodeUtil.REQUEST_ERROR_PARAM;

        User user = userMapper.selectUserByPhone(phone);

        //1、校验用户是否存在
        if (user == null)
            return ErrorCodeUtil.USER_NULL;

        //2、校验用户是否封禁
        if (user.getIsDisable())
            return ErrorCodeUtil.USER_BLOCKED;

        return ErrorCodeUtil.SUCCESS;
    }

    /**
     * 用户名校验流程
     * 1、校验用户是否存在
     * 2、校验用户是否封禁
     *
     * @param username
     * @return
     */
    public int checkUserName(String username) {
        User user = userMapper.selectUserByUserName(username);

        //1、校验用户是否存在
        if (user == null)
            return ErrorCodeUtil.USER_NULL;

        //2、校验用户是否封禁
        if (user.getIsDisable())
            return ErrorCodeUtil.USER_BLOCKED;

        return ErrorCodeUtil.SUCCESS;
    }

    /**
     * 用户名密码检验
     *
     * @param username
     * @param password
     * @return
     */
    public int checkUserPassword(String username, String password) {
        User user = userMapper.selectUserByUserName(username);

        //1、校验用户是否存在
        if (user == null)
            return ErrorCodeUtil.USER_NULL;

        //2、校验用户是否封禁
        if (user.getIsDisable())
            return ErrorCodeUtil.USER_BLOCKED;

        //3、校验密码是否正确
        if (!password.equals(user.getPassword()))
            return ErrorCodeUtil.PASSWORD_ERROR;
        else
            return ErrorCodeUtil.SUCCESS;
    }


    /**
     * 根据手机号创建用户
     *
     * @param phone
     * @return
     */
    public boolean CreateUser(String phone) {
        User user = new User();
        user.setPassword(null);
        user.setIsDisable(false);
        user.setUsername(phone);
        user.setIsValid(true);
        user.setRegtime(new Date());
        int result = userMapper.insert(user);
        if (result <= 0)
            return false;
        return true;
    }

    /**
     * 根据用户名密码创建用户
     *
     * @param username
     * @param password
     * @return
     */
    public boolean CreateUser(String username, String password) {
        User user = new User();
        user.setPassword(password);
        user.setIsDisable(false);
        user.setUsername(username);
        user.setIsValid(true);
        user.setRegtime(new Date());
        int result = userMapper.insert(user);
        if (result <= 0)
            return false;
        return true;
    }

    /**
     * 重置密码
     *
     * @param token
     * @param password
     * @return
     */
    public boolean ResetPassword(String token, String password) {
        UserToken userToken = userTokenMapper.selectByToken(token);
        int result = userMapper.updatePasswordById(userToken.getUserId(), password);
        if (result <= 0)
            return false;
        return true;
    }
}




