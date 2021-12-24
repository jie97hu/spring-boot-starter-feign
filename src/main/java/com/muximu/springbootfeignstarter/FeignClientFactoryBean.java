package com.muximu.springbootfeignstarter;

import com.muximu.springbootfeignstarter.config.FeignClientConfiguration;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class FeignClientFactoryBean implements FactoryBean<Object>, ApplicationContextAware {

    private Class<?> type;
    private Class<? extends FeignClientConfiguration> config;
    private ApplicationContext applicationContext;

    @Override
    public Object getObject() {
        return configureFeign();
    }

    @Override
    public Class<?> getObjectType() {
        return this.type;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private <T> T configureFeign() {
        return null;
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public Class<? extends FeignClientConfiguration> getConfig() {
        return config;
    }

    public void setConfig(Class<? extends FeignClientConfiguration> config) {
        this.config = config;
    }
}
