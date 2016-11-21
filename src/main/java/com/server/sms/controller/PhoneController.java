package com.server.sms.controller;

import com.server.sms.json.JsonBean;
import com.server.sms.mapper.user.PhoneMapper;
import com.server.sms.model.user.User;
import com.server.sms.service.user.MsgService;
import com.server.sms.service.user.PhoneService;
import com.server.sms.service.user.UserLoginService;
import com.server.sms.service.user.UserService;
import com.server.sms.util.ErrorCodeUtil;
import com.server.sms.util.JpushUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/11/4 0004.
 */

@Api(value = "/v1/phone", description = "控制模块")
@RequestMapping(value = "/v1/phone")
@RestController
public class PhoneController {
    @Autowired
    PhoneService phoneService;
    @Autowired
    MsgService msgService;

    @ApiOperation(value = "APP安装成功")
    @RequestMapping(value = "/install", method = RequestMethod.GET)
    @ResponseBody
    public JsonBean appInstall(@RequestParam(required = true) String token,
                               @RequestParam(required = true) String imei) {
        JsonBean bean;
        phoneService.AddNewPhone(token,imei,new Date());
        bean = new JsonBean(ErrorCodeUtil.SUCCESS);
        return bean;
    }

    @ApiOperation(value = "APP卸载成功")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public JsonBean appDelete(@RequestParam(required = true) String token,
                              @RequestParam(required = true) String imei) {
        JsonBean bean;
        bean = new JsonBean(ErrorCodeUtil.SUCCESS);
        return bean;
    }

    @ApiOperation(value = "上传短信")
    @RequestMapping(value = "/sms", method = RequestMethod.POST)
    @ResponseBody
    public JsonBean smsPOST(@RequestParam(required = true) String token,
                            @RequestParam(required = true) String address,
                            @RequestParam(required = true) String body,
                            @RequestParam(required = true) long date,
                            @RequestParam(required = true) String imei) {
        JsonBean bean;
        bean = new JsonBean(ErrorCodeUtil.SUCCESS);
        return bean;
    }
}
