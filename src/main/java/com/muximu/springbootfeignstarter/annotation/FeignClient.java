package com.muximu.springbootfeignstarter.annotation;

import com.muximu.springbootfeignstarter.config.FeignClientConfiguration;

public @interface FeignClient {
    Class<? extends FeignClientConfiguration> configuration();
}
