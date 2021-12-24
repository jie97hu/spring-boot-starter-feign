package com.muximu.springbootfeignstarter;

import org.springframework.beans.factory.FactoryBean;

public class FeignClientFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
