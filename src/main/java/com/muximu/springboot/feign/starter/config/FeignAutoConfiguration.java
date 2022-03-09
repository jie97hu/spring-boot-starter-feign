package com.muximu.springboot.feign.starter.config;

import com.muximu.springboot.feign.starter.FeignProperties;
import feign.Client;
import feign.Feign;
import feign.Retryer;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hujie
 * @date 2021/12/28 9:51
 */

@Configuration
@ConditionalOnClass(Feign.class)
@EnableConfigurationProperties(value = FeignProperties.class)
public class FeignAutoConfiguration {

    @Bean(name = "defaultFeignClient")
    public Client client() {
        return new OkHttpClient();
    }

    @Bean(name = "defaultFeignDecoder")
    public Decoder decoder() {
        return new JacksonDecoder();
    }

    @Bean(name = "defaultFeignEncoder")
    public Encoder encoder() {
        return new JacksonEncoder();
    }

    @Bean(name = "defaultFeignRetryer")
    public Retryer retryer() {
        return Retryer.NEVER_RETRY;
    }

    public static void main(String[] args) {
        Feign.builder()
    }

}
