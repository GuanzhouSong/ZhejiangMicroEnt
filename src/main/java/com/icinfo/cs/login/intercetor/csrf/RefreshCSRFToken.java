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
public @interface RefreshCSRFToken {
    /**
    * 描述：
    * @author gqf
    * @param
    * @return 
     *@date 2017/7/14 
    */
    public abstract boolean refresh() default true;
}
