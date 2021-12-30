package com.muximu.springboot.feign.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(value = FeignProperties.class)
@ConfigurationProperties(prefix = "feign", ignoreInvalidFields = true)
public class FeignProperties {
    /**
     * 端口
     */
    private Integer port = 80;
}
