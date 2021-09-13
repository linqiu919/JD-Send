package com.java.jdsend.controller;

import com.java.jdsend.entity.Send;
import com.java.jdsend.http.AxiosResult;
import com.java.jdsend.service.SendService;
import com.java.jdsend.utils.WechatSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author linqiu
 * @version 1.0
 * @date 2021/9/6 13:43
 */
@RestController
public class JdSendController {

    @Autowired
    private SendService sendService;


    @GetMapping("selectById/{sendId}")
    private AxiosResult<Send> querySendDataById(@PathVariable Integer sendId){
        return AxiosResult.success(sendService.selectSendData(sendId));
    }

    @GetMapping("selectAllSend")
    private AxiosResult<List<Send>> queryAllSend(){
        return AxiosResult.success(sendService.selectAllSend());
    }

    @PostMapping("saveOrUpdateText")
    private AxiosResult<Void> saveOrUpdateText(@RequestBody Send send){
        //保存之前判断数据库是否已经有用户数据，如果有用户数据，则进行更新操作并推送微信，不再插入数据库
        Integer statue = sendService.hasSendId(send);
        if(statue>0){
            //为用户数据设置查询的ID，用于更新数据
            send.setSendId(statue);
            //获取旧数据
            String oldTxt = sendService.selectOldTxt(statue);
            //更新数据
            sendService.updateSendText(send);
            //推送微信
            WechatSend.sendMessage(oldTxt,send);
            return AxiosResult.updateSuccess();
        }else if(statue!=0){
            //数据库无数据，存储到数据库中
            sendService.saveSendText(send);
            //推送微信
            WechatSend.sendMessage("新数据",send);
            return AxiosResult.saveSuccess();
        }else{
            return AxiosResult.adminExist();
        }
    }
}
