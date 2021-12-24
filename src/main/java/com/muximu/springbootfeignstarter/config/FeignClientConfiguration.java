package com.muximu.springbootfeignstarter.config;

import feign.Client;
import feign.RequestInterceptor;
import feign.RequestLine;
import feign.Retryer;
import feign.codec.Decoder;
import feign.codec.Encoder;

import java.util.List;

/**
 * feign的一些相关配置项,具体含义参考官方定义 https://github.com/OpenFeign/feign
 * urlPre例外，是自定义的配置项，用于{@link RequestLine#value()}中定义的url合并起来构成完整的url
 **/
public interface FeignClientConfiguration {

    String urlPre();

    Client client();

    Decoder decoder();

    Encoder encoder();

    Retryer retryer();

    List<RequestInterceptor> requestInterceptor();

}
