package com.java.jdsend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author linqiu
 * @version 1.0
 * @description: 实体类
 * @date 2021/9/6 13:31
 */
@Data
public class Send {
    //发送者ID
    @TableId(type = IdType.AUTO)
    private Integer sendId;
    //发送文本内容
    private String sendTxt;
    //备注信息
    private String sendDesc;
    //重复备注信息
    private String repeatSendDesc;
}
