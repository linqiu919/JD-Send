package com.java.jdsend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

/**
 * @author linqiu
 * @version 1.0
 * @description: restTemplate配置类
 * @date 2021/9/6 16:27
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate templateConfig() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();

        //设置连接超时
        requestFactory.setConnectTimeout(5000);
        //设置请求超时
        requestFactory.setReadTimeout(2000);
        //设置是否缓存数据,当大量做增加或删除时建议关闭缓存,避免内存耗光
        requestFactory.setBufferRequestBody(false);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(requestFactory);

        //设置字符集编码
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(Charset.forName("utf-8")));
        //设置异常处理方式
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler());

        return restTemplate;
    }
}


