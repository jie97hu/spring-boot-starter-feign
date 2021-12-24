package com.muximu.springbootfeignstarter;

import com.muximu.springbootfeignstarter.annotation.FeignClient;
import com.muximu.springbootfeignstarter.config.FeignClientConfiguration;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.util.Map;
import java.util.Set;

public class FeignClientRegister implements ImportBeanDefinitionRegistrar, ResourceLoaderAware {
    private ResourceLoader resourceLoader;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        ClassPathScanningCandidateComponentProvider scanner = new FeignClientScanner();
        scanner.setResourceLoader(resourceLoader);
        String scanPackageName = ClassUtils.getPackageName(annotationMetadata.getClassName());
        Set<BeanDefinition> candidateComponents = scanner.findCandidateComponents(scanPackageName);
        for (BeanDefinition candidateComponent : candidateComponents) {
            if (candidateComponent instanceof AnnotatedBeanDefinition) {
                AnnotatedBeanDefinition beanDefinition = (AnnotatedBeanDefinition) candidateComponent;
                AnnotationMetadata metadata = beanDefinition.getMetadata();
                validateFeignClientAnnotation(metadata);
                BeanDefinitionHolder newHolder = new BeanDefinitionHolder(getBeanDefinition(metadata), metadata.getClassName(), null);
                BeanDefinitionReaderUtils.registerBeanDefinition(newHolder, beanDefinitionRegistry);
            }
        }
    }

    protected BeanDefinition getBeanDefinition(AnnotationMetadata metadata) {
        Class clazz = ClassUtils.resolveClassName(metadata.getClassName(), null);
        FeignClientFactoryBean factoryBean = new FeignClientFactoryBean();
        factoryBean.setType(clazz);
        factoryBean.setConfig(getConfiguration(metadata));
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clazz, factoryBean::getObject);
        beanDefinitionBuilder.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
        beanDefinitionBuilder.setLazyInit(true);
        return beanDefinitionBuilder.getBeanDefinition();
    }

    protected Class<? extends FeignClientConfiguration> getConfiguration(AnnotationMetadata metadata) {
        Map<String, Object> attributes = metadata.getAnnotationAttributes(FeignClient.class.getCanonicalName());
        return null;
    }

    protected void validateFeignClientAnnotation(AnnotationMetadata metadata) {
        Assert.isTrue(metadata.isInterface(), "@FeignClient只能作用于接口上");
    }

}
