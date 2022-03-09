package com.muximu.springboot.feign.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "feign", ignoreInvalidFields = true)
public class FeignProperties {

    private Boolean enableHystrix;
    private Boolean enableSentinel;
    private Boolean enableRibbon;

    public Boolean getEnableHystrix() {
        return enableHystrix;
    }

    public void setEnableHystrix(Boolean enableHystrix) {
        this.enableHystrix = enableHystrix;
    }

    public Boolean getEnableSentinel() {
        return enableSentinel;
    }

    public void setEnableSentinel(Boolean enableSentinel) {
        this.enableSentinel = enableSentinel;
    }

    public Boolean getEnableRibbon() {
        return enableRibbon;
    }

    public void setEnableRibbon(Boolean enableRibbon) {
        this.enableRibbon = enableRibbon;
    }
}
