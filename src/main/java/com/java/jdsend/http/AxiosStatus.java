package com.java.jdsend.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author linqiu
 * @version 1.0
 * @description: 固定错误代码
 * @date 2021/9/6 17:26
 */
@Getter
@AllArgsConstructor
public enum AxiosStatus {
    SELECT_SUCCESS(9981,"查询用户成功"),
    Save_Ok(20000,"京东数据保存成功"),
    UPDATE_OK(3000,"京东数据更新成功"),
    ERROR(40000,"操作失败"),
    ERROR_POINT(50000,"出现空指针异常"),
    ADMIN_EXIST(60000,"京东数据未发生变化，更新失败"),;
    private int status;
    private String message;

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
