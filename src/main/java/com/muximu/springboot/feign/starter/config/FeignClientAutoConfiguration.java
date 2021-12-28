package com.muximu.springboot.feign.starter.config;

import feign.Client;
import feign.RequestInterceptor;
import feign.Retryer;
import feign.codec.Decoder;
import feign.codec.Encoder;

import java.util.List;

/**
 * @author hujie
 * @date 2021/12/28 9:51
 */
public class FeignClientAutoConfiguration implements FeignClientConfiguration {

    @Override
    public Client client() {
        return null;
    }

    @Override
    public Decoder decoder() {
        return null;
    }

    @Override
    public Encoder encoder() {
        return null;
    }

    @Override
    public Retryer retryer() {
        return null;
    }

    @Override
    public List<RequestInterceptor> requestInterceptor() {
        return null;
    }
}
