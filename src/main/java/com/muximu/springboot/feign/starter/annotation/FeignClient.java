package com.muximu.springboot.feign.starter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface FeignClient {

    String url() default "";

    String server() default "";

    Class<?> configuration() default void.class;

    Class<?> fallBack() default void.class;

}
