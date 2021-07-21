package com.dawson.robot;


import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;

import java.util.Arrays;

/**
 * <p>自定义机器人消息发送测试</p>
 * <p>创建时间：2021-7-15 10:24:20</p>
 * <p>修改时间：2021-7-15 10:24:20</p>
 * @author Dawson
 * @version 1.0
 */
public class Test {

    public static void main(String[] args) throws ApiException {

        // 根据机器人的token获取DingTalkClient
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=9bfe95392c974ea0d5e19fca0654d82fa311d8b7800069bb999204fad01d01da");

        // 创建请求对象
        OapiRobotSendRequest request = new OapiRobotSendRequest();

        // 文本消息
        request.setMsgtype("text");
        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        text.setContent("azkaban预警：Dawson test...");
        request.setText(text);

        // 添加联系方式对象
        OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
        at.setAtMobiles(Arrays.asList("13220802021"));
        at.setIsAtAll(true);// @All
        request.setAt(at);

        // 发送
        OapiRobotSendResponse response = client.execute(request);
        System.out.println(response.isSuccess());

    }

}
