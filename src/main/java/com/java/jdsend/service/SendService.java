package com.java.jdsend.service;

import com.java.jdsend.entity.Send;

import java.util.List;

/**
 * @author linqiu
 * @version 1.0
 * @description: 发送服务
 * @date 2021/9/6 13:36
 */
public interface SendService {

    /***
     * @description: 保存用户数据
     * @param: send
     * @return: 返回是否保存成功
     * @author linqiu
     */
    int saveSendText(Send send);

    /***
     * @description: 判断数据库中是否已经有此用户
     * @param: send
     * @return: 返回判断结果
     * @author
     * @date:
     */
    Integer hasSendId(Send send);

    /***
     * @description: 通过ID更新数据
     * @param: sendId
     * @return: 返回受影响的行数
     * @author
     * @date:
     */
    int updateSendText(Send send);



    Send selectSendData(Integer sendId);

    /***
     * @description: 查询用户旧的京东数据
     */
    String selectOldTxt(Integer sendId);

    /***
     * @description: 批量查询用户数据
     */
    List<Send> selectAllSend();
}
