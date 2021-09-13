package com.java.jdsend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.java.jdsend.entity.Send;
import com.java.jdsend.mapper.SendMapper;
import com.java.jdsend.service.SendService;
import com.java.jdsend.utils.Base64Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * @author linqiu
 * @version 1.0
 * @description: 保存并推送京东数据
 * @date 2021/9/6 13:37
 */
@Service
public class SendServiceImpl implements SendService {

    @Autowired
    private SendMapper sendMapper;
    @Override
    public int saveSendText(Send send) {
        return sendMapper.insert(send);
    }

    @Override
    public Integer hasSendId(Send send) {
        Send sendInfo = sendMapper.selectOne(new QueryWrapper<Send>().eq("send_desc", send.getSendDesc()));
        //判断数据不为空且数据库中无相同数据
        if(null!=sendInfo && !sendInfo.getSendTxt().equalsIgnoreCase(send.getSendTxt())){
            return sendInfo.getSendId();
        }
        //判断数据不为空且数据库中有相同数据
        if(null!=sendInfo && sendInfo.getSendTxt().equalsIgnoreCase(send.getSendTxt())){
            return 0;
        }
        return -1;
    }

    @Override
    public int updateSendText(Send send) {
        //通过备注查询用户id，如果已经存在京东数据吗，通过id更新京东数据
        return sendMapper.updateById(send);
    }

    @Override
    public Send selectSendData(Integer sendId) {
        Send send = sendMapper.selectById(sendId);
        String s = Base64Util.encodeStr(send.getSendTxt());
        send.setSendTxt(s);
        return send;
    }

    @Override
    public String selectOldTxt(Integer sendId) {
        Send send = sendMapper.selectById(sendId);
        return send.getSendTxt();
    }

    @Override
    public List<Send> selectAllSend() {
        List<Send> sends = sendMapper.selectList(null);
        Iterator<Send> iterator = sends.iterator();
        while (iterator.hasNext()){
            Send send = iterator.next();
            send.setSendTxt(Base64Util.encodeStr(send.getSendTxt()));
        }
        return sends;
    }
}
