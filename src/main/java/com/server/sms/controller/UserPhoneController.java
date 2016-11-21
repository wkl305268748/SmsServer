package com.server.sms.controller;

import com.server.sms.json.JsonBean;
import com.server.sms.service.user.MsgService;
import com.server.sms.service.user.PhoneService;
import com.server.sms.util.ErrorCodeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by Administrator on 2016/11/4 0004.
 */

@Api(value = "/v1/phone", description = "用户控制模块")
@RequestMapping(value = "/v1/user_phone")
@RestController
public class UserPhoneController {
    @Autowired
    PhoneService phoneService;
    @Autowired
    MsgService msgService;

    @ApiOperation(value = "获取手机列表信息")
    @RequestMapping(value = "/phones", method = RequestMethod.GET)
    @ResponseBody
    public JsonBean phonesAll(@RequestParam(required = true) String token) {
        JsonBean bean;
        bean = new JsonBean(ErrorCodeUtil.SUCCESS);
        return bean;
    }

    @ApiOperation(value = "获取指定手机信息")
    @RequestMapping(value = "/phone", method = RequestMethod.GET)
    @ResponseBody
    public JsonBean phones(@RequestParam(required = true) String token,
                           @RequestParam(required = true) String imei) {
        JsonBean bean;
        bean = new JsonBean(ErrorCodeUtil.SUCCESS);
        return bean;
    }

    @ApiOperation(value = "修改指定手机信息")
    @RequestMapping(value = "/phone", method = RequestMethod.PUT)
    @ResponseBody
    public JsonBean phonesEdit(@RequestParam(required = true) String token,
                               @RequestParam(required = true) String nickname,
                               @RequestParam(required = true) String remark,
                               @RequestParam(required = true) String imei) {
        JsonBean bean;
        bean = new JsonBean(ErrorCodeUtil.SUCCESS);
        return bean;
    }

    @ApiOperation(value = "获取指定手机指定手机号短信")
    @RequestMapping(value = "/sms/imei/phone", method = RequestMethod.GET)
    @ResponseBody
    public JsonBean smsGet(@RequestParam(required = true) String token,
                           @RequestParam(required = true) String phone,
                           @RequestParam(required = true) String imei) {
        JsonBean bean;
        //清空短信
        //发送指令
        msgService.smsGet(token,imei,phone);

        bean = new JsonBean(ErrorCodeUtil.SUCCESS);
        return bean;
    }


    @ApiOperation(value = "显示短信")
    @RequestMapping(value = "/sms/imei/show", method = RequestMethod.GET)
    @ResponseBody
    public JsonBean smsShow(@RequestParam(required = true) String token,
                            @RequestParam(required = true) String imei) {
        JsonBean bean;
        bean = new JsonBean(ErrorCodeUtil.SUCCESS);
        return bean;
    }

    @ApiOperation(value = "显示指定短信")
    @RequestMapping(value = "/sms/imei/msgid", method = RequestMethod.GET)
    @ResponseBody
    public JsonBean smsidGet(@RequestParam(required = true) String token,
                             @RequestParam(required = true) String msgid,
                             @RequestParam(required = true) String imei) {
        JsonBean bean;
        bean = new JsonBean(ErrorCodeUtil.SUCCESS);
        return bean;
    }

    @ApiOperation(value = "修改指定短信")
    @RequestMapping(value = "/sms/imei/msgid", method = RequestMethod.PUT)
    @ResponseBody
    public JsonBean smsPut(@RequestParam(required = true) String token,
                           @RequestParam(required = true) Integer id,
                           @RequestParam(required = true) String body,
                           @RequestParam(required = true) String imei) {
        JsonBean bean;


        //发送修改指令
        msgService.smsEdit(token,imei,id,body);

        bean = new JsonBean(ErrorCodeUtil.SUCCESS);
        return bean;
    }
}
