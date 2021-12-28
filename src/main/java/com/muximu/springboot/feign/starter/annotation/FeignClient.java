package com.muximu.springboot.feign.starter.annotation;

import com.muximu.springboot.feign.starter.config.FeignClientConfiguration;
import com.muximu.springboot.feign.starter.config.FeignClientAutoConfiguration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface FeignClient {

    String url();

    Class<? extends FeignClientConfiguration> configuration() default FeignClientAutoConfiguration.class;

}
