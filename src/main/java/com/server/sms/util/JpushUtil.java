package com.server.sms.util;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


/**
 * 极光推送
 */
public class JpushUtil {

    protected static final Logger LOG = LoggerFactory.getLogger(JpushUtil.class);

    JPushClient jpushClient;
    String MasterSecret = "fd5f389ac0485818d612ab5e";
    String AppKey = "a72b65db8668e95342565eb7";

    public JpushUtil(){
        jpushClient = new JPushClient(MasterSecret, AppKey);
    }



    /**
     * 发送推送信息
     * @param alias 别名
     * @param msg 消息
     * @return
     */
    public boolean pushMap(String alias,Map<String,String> msg) {
        // For push, all you need do is to build PushPayload object.
        PushPayload payload = PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(alias))
                .setMessage(Message.newBuilder()
                        .setMsgContent("")
                        .addExtras(msg)
                        .build())
                .build();

        try {
            PushResult result = jpushClient.sendPush(payload);
            if(!result.isResultOK())
                return false;
            LOG.info("Got result - " + result);

        } catch (APIConnectionException e) {
            // Connection error, should retry later
            LOG.error("Connection error, should retry later", e);
            return false;

        } catch (APIRequestException e) {
            // Should review the error, and fix the request
            LOG.error("Should review the error, and fix the request", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            return false;
        }
        return true;
    }

    /**
     * 发送推送信息
     * @param alias 别名
     * @param msg 消息
     * @return
     */
    public boolean pushJson(String alias,String msg) {
        // For push, all you need do is to build PushPayload object.
        PushPayload payload = PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(alias))
                .setMessage(Message.newBuilder()
                        .setMsgContent(msg)
                        .build())
                .build();

        try {
            PushResult result = jpushClient.sendPush(payload);
            if(!result.isResultOK())
                return false;
            LOG.info("Got result - " + result);

        } catch (APIConnectionException e) {
            // Connection error, should retry later
            LOG.error("Connection error, should retry later", e);
            return false;

        } catch (APIRequestException e) {
            // Should review the error, and fix the request
            LOG.error("Should review the error, and fix the request", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            return false;
        }
        return true;
    }
}
