package com.java.jdsend.utils;

import com.java.jdsend.entity.Send;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * @author linqiu
 * @version 1.0
 * @description: 推送微信消息工具类
 * @date 2021/9/9 20:28
 */
public class WechatSend {
    /***
     * @description: 推送消息到微信
     * @param: send
     * @return: 返回请求响应码
     * @author linqiu11
     * @date: 2021/9/6
     */
    public static HttpStatus sendMessage(String oldSendText, Send send){
        HashMap<String, Object> map = new HashMap<>();
        map.put("token","");
        map.put("title","京东账户数据有更新");
        map.put("content","京东用户："+send.getSendDesc()+"\n原状态为："+oldSendText+"\n新状态为："+send.getSendTxt());
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://www.pushplus.plus/send?token={token}&title={title}&content={content}", String.class, map);
        return response.getStatusCode();
    }
}
