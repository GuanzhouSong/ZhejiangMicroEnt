package com.icinfo.cs.pbapp.controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

 /**
  * 
  * 描述: App客户端检查token注解（有此注解才走方法）
  * @author gaojinling
  * @date 2017年3月3日
  */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AppTokenCheck {


	
    long timeout() default 3000;
}