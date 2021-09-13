package com.java.jdsend.http;

import lombok.Data;

/**
 * @author linqiu
 * @version 1.0
 * @description: 状态码
 * @date 2021/9/6 17:24
 */
@Data
public class AxiosResult<T> {
    private int status;
    private String message;
    private T data;

    private AxiosResult(AxiosStatus axiosStatus,T t){
        this.status = axiosStatus.getStatus();
        this.message = axiosStatus.getMessage();
        this.data = t;
    }

    //获取结果集对象
    private static <T> AxiosResult<T> getInstance(AxiosStatus axiosStatus,T t){
        return new AxiosResult<T>(axiosStatus,t);
    }

    //保存新数据成功
    public  static <T> AxiosResult<T> saveSuccess(){
        return getInstance(AxiosStatus.Save_Ok,null);
    }

    //更新数据成功
    public  static <T> AxiosResult<T> updateSuccess(){
        return getInstance(AxiosStatus.UPDATE_OK,null);
    }

    //数据已经存在
    public  static <T> AxiosResult<T> adminExist(){
        return getInstance(AxiosStatus.ADMIN_EXIST,null);
    }

    //访问成功携带数据
    public static <T> AxiosResult<T> success(T t){
        return getInstance(AxiosStatus.SELECT_SUCCESS,t);
    }

    //访问失败不携带数据
    public static <T> AxiosResult<T> error(){
        return getInstance(AxiosStatus.ERROR,null);
    }
    //访问失败携带数据
    public static <T> AxiosResult<T> error(T t){
        return getInstance(AxiosStatus.ERROR,t);
    }

    /*
     自定义失败状态码
    */
    public static <T> AxiosResult<T> error(AxiosStatus axiosStatus) {
        return getInstance(axiosStatus, null);
    }

    //自定义失败状态携带数据
    public static <T> AxiosResult<T> error(AxiosStatus axiosStatus,T t){
        return getInstance(axiosStatus,t);
    }



}
