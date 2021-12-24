package com.muximu.springbootfeignstarter;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

public class FeignClientRegister implements ImportBeanDefinitionRegistrar, ResourceLoaderAware, EnvironmentAware {
    @Override
    public void setEnvironment(Environment environment) {

    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {

    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {

    }
}
