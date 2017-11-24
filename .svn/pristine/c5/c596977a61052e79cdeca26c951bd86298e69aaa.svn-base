package com.icinfo.cs.login.intercetor.csrf;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by FENG on 2017/7/14.
 * icinfo inc
 */
@Target({ java.lang.annotation.ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface VerifyCSRFToken {
    /**
     * 需要验证防跨站请求
     *
     */
    public abstract boolean verify() default true;
}
