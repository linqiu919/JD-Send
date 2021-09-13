package com.java.jdsend.exception;

import com.java.jdsend.http.AxiosResult;
import com.java.jdsend.http.AxiosStatus;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.http.HttpServletRequest;


/**
 * @author linqiu
// * @version 1.0
 * @description: 全局异常处理
 * @date 2021/9/7 11:28
 */


@RestControllerAdvice
public class GlobalException {


    @ExceptionHandler(Throwable.class)
    public AxiosResult<Void> handlerThrowable(Throwable e){
        AxiosStatus netError = AxiosStatus.ERROR;
        netError.setMessage(e.getMessage());
        return AxiosResult.error(netError);
    }

    /**
     * 处理空指针的异常
     */
    @ExceptionHandler(value =NullPointerException.class)
    @ResponseBody
    public AxiosResult exceptionHandler(HttpServletRequest req, NullPointerException e){
        return AxiosResult.error(AxiosStatus.ERROR_POINT);
    }


}
