package com.muximu.springboot.feign.starter.core;

import feign.Feign;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class FeignClientFactoryBean implements FactoryBean<Object>, ApplicationContextAware {

    private String url;
    private Class<?> type;
    private ApplicationContext applicationContext;

    @Override
    public Object getObject() {
        return configureFeign(type);
    }

    @Override
    public Class<?> getObjectType() {
        return this.type;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private <T> T configureFeign(Class<T> type) {

        return Feign.builder().target(type, url);
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }


}
