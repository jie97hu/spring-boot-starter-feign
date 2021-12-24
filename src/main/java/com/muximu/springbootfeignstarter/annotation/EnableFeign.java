package com.muximu.springbootfeignstarter.annotation;

import com.muximu.springbootfeignstarter.FeignClientRegister;
import org.springframework.context.annotation.Import;

@Import({FeignClientRegister.class})
public @interface EnableFeign {
}
