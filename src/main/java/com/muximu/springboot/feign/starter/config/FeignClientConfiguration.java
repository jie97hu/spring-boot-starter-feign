package com.muximu.springboot.feign.starter.config;

import feign.Client;
import feign.RequestInterceptor;
import feign.Retryer;
import feign.codec.Decoder;
import feign.codec.Encoder;

import java.util.List;

/**
 * feign的一些相关配置项,具体含义参考官方定义 https://github.com/OpenFeign/feign
 **/
public interface FeignClientConfiguration {

    Client client();

    Decoder decoder();

    Encoder encoder();

    Retryer retryer();

    List<RequestInterceptor> requestInterceptor();

}
