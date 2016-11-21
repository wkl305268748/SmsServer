package com.server.sms.service.user;

import com.server.sms.json.response.PasssmsResponse;
import com.server.sms.json.response.PasswordResponse;
import com.server.sms.json.response.TokenCheckResponse;
import com.server.sms.mapper.user.UserMapper;
import com.server.sms.mapper.user.UserOnlineMapper;
import com.server.sms.mapper.user.UserTokenMapper;
import com.server.sms.model.user.User;
import com.server.sms.model.user.UserOnline;
import com.server.sms.model.user.UserToken;
import com.server.sms.util.ErrorCodeUtil;
import com.server.sms.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserLoginService {
    @Autowired
    UserTokenMapper userTokenMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserOnlineMapper userOnlineMapper;

    /**
     * 短信登陆流程
     * 1、删除已有的token
     * 2、生成新的token 加入数据库
     * 3、生成userOnline加入数据库
     *
     * @param phone
     * @return
     */
    public PasssmsResponse LoginSms(String phone) {
        User user = userMapper.selectUserByPhone(phone);

        //1、删除已有的token
        userTokenMapper.deleteTokenByUserId(user.getId());

        //2、生成新的token 加入数据库
        String token = createToken(phone);
        UserToken userToken = new UserToken();
        userToken.setToken(token);
        userToken.setUserId(user.getId());
        userToken.setTime(new Date());
        userToken.setIsvalid(true);
        userTokenMapper.insert(userToken);

        //3、生成userOnline加入数据库
        UserOnline userOnline = new UserOnline();
        userOnline.setIsOnline(true);
        userOnline.setUserId(user.getId());
        userOnline.setTime(new Date());
        userOnline.setIsValid(true);
        userOnlineMapper.insert(userOnline);

        //返回结果
        PasssmsResponse passsmsResponse = new PasssmsResponse();
        //用户是否有初始密码
        if (user.getPassword() == null)
            passsmsResponse.setIs_password(false);
        else
            passsmsResponse.setIs_password(true);
        passsmsResponse.setPhone(phone);
        passsmsResponse.setToken(token);
        return passsmsResponse;
    }

    /**
     * 用户名密码登陆流程
     * 1、删除已有的token
     * 2、生成新的token 加入数据库
     * 3、生成userOnline加入数据库
     *
     * @param username
     * @return
     */
    public PasswordResponse LoginPass(String username) {
        User user = userMapper.selectUserByPhone(username);

        //1、删除已有的token
        userTokenMapper.deleteTokenByUserId(user.getId());

        //2、生成新的token 加入数据库
        String token = createToken(username);
        UserToken userToken = new UserToken();
        userToken.setToken(token);
        userToken.setUserId(user.getId());
        userToken.setTime(new Date());
        userToken.setIsvalid(true);
        userTokenMapper.insert(userToken);

        //3、生成userOnline加入数据库
        UserOnline userOnline = new UserOnline();
        userOnline.setIsOnline(true);
        userOnline.setUserId(user.getId());
        userOnline.setTime(new Date());
        userOnline.setIsValid(true);
        userOnlineMapper.insert(userOnline);

        //返回结果
        PasswordResponse passsmsResponse = new PasswordResponse();
        passsmsResponse.setToken(token);
        return passsmsResponse;
    }

    /**
     * 退出登陆
     *
     * @param token
     * @return
     */
    public boolean Logout(String token) {
        UserToken userToken = userTokenMapper.selectByToken(token);
        int result = userTokenMapper.deleteTokenByUserId(userToken.getUserId());
        if (result <= 0)
            return false;
        return true;
    }

    /**
     * 通过token获取用户id
     *
     * @param token
     * @return
     */
    public TokenCheckResponse GetToken(String token) {
        UserToken userToken = userTokenMapper.selectByToken(token);
        TokenCheckResponse tokenResponse = new TokenCheckResponse();
        tokenResponse.setId(userToken.getUserId());
        return tokenResponse;
    }

    /**
     * 校验token
     *
     * @param token
     * @return
     */
    public int checkToken(String token) {
        //1、参数合法判断
        if (token.length() != 16)
            return ErrorCodeUtil.REQUEST_ERROR_PARAM;

        //2、判断token是否存在
        UserToken userToken = userTokenMapper.selectByToken(token);
        if (userToken == null)
            return ErrorCodeUtil.TOKEN_LOSE_LOGIN;

        User user = userMapper.selectByPrimaryKey(userToken.getUserId());
        //3、校验用户是否存在
        if (user == null)
            return ErrorCodeUtil.USER_NULL;

        //4、校验用户是否封禁
        if (user.getIsDisable())
            return ErrorCodeUtil.USER_BLOCKED;

        return ErrorCodeUtil.SUCCESS;
    }

    /**
     * 随机生成Token
     * 用户名+时间戳 -> MD5
     *
     * @param name
     * @return
     */
    private String createToken(String name) {
        return MD5Util.MD5_16(name + new Date().getTime());
    }
}
