package com.server.sms.controller;

import com.server.sms.json.JsonBean;
import com.server.sms.json.response.PasswordResponse;
import com.server.sms.json.response.TokenCheckResponse;
import com.server.sms.service.user.UserLoginService;
import com.server.sms.service.user.UserService;
import com.server.sms.util.ErrorCodeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "/v1/manager_users", description = "用户管理模块")
@RequestMapping(value = "/v1/manager_users")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserLoginService userLoginService;


    @ApiOperation(value = "校验用户名与密码")
    @RequestMapping(value = "/password_check", method = RequestMethod.GET)
    @ResponseBody
    public JsonBean PasswordCheck(@RequestParam(required = true) String username,
                                  @RequestParam(required = true) String password) {
        JsonBean result;

        /**---校验流程---**/
        //用户名密码校验流程
        int errorCode = userService.checkUserPassword(username, password);
        if (errorCode != ErrorCodeUtil.SUCCESS) {
            result = new JsonBean(errorCode);
            return result;
        }

        result = new JsonBean(ErrorCodeUtil.SUCCESS);
        return result;
    }


    @ApiOperation(value = "用户名和密码登录")
    @RequestMapping(value = "/password", method = RequestMethod.GET)
    @ResponseBody
    public JsonBean Password(@RequestParam(required = true) String
                                     username, @RequestParam(required = true) String password) {
        JsonBean result;

        /**---校验流程---**/
        //用户名密码校验流程
        int errorCode = userService.checkUserPassword(username, password);
        if (errorCode != ErrorCodeUtil.SUCCESS) {
            result = new JsonBean(errorCode);
            return result;
        }

        /**---操作流程---**/
        //登陆流程
        PasswordResponse bean = userLoginService.LoginPass(username);
        result = new JsonBean(ErrorCodeUtil.SUCCESS, bean);
        return result;
    }


    @ApiOperation(value = "重置密码")
    @RequestMapping(value = "/reset_password", method = RequestMethod.POST)
    @ResponseBody
    public JsonBean ResetPassword(@RequestParam(required = true) String token,
                                  @RequestParam(required = true) String password) {
        JsonBean result;

        /**---校验流程---**/

        /**---操作流程---**/
        userService.ResetPassword(token, password);
        result = new JsonBean(ErrorCodeUtil.SUCCESS);
        return result;
    }


    @ApiOperation(value = "退出登录")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public JsonBean LogOut(@RequestParam(required = true) String token) {
        JsonBean result;
        /**---校验流程---**/

        /**---操作流程---**/
        userLoginService.Logout(token);
        result = new JsonBean(ErrorCodeUtil.SUCCESS);
        return result;
    }


    @ApiOperation(value = "校验Token")
    @RequestMapping(value = "/token_check", method = RequestMethod.GET)
    @ResponseBody
    public JsonBean TokenCheck(@RequestParam(required = true) String token) {
        JsonBean result;
        /**---校验流程---**/

        /**---操作流程---**/
        TokenCheckResponse bean = userLoginService.GetToken(token);
        result = new JsonBean(ErrorCodeUtil.SUCCESS, bean);
        return result;
    }

}

