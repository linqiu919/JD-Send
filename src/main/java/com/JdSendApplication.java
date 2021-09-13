package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author linqiu
 * @version 1.0
 * @description: 主启动类
 * @date 2021/9/6 13:26
 */
@SpringBootApplication
@MapperScan("com.java.jdsend.mapper")
public class JdSendApplication {
    public static void main(String[] args) {
        SpringApplication.run(JdSendApplication.class,args);
    }
}
