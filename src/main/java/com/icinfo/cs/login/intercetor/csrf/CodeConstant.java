package com.icinfo.cs.login.intercetor.csrf;

/**
 * Created by FENG on 2017/7/14.
 * icinfo inc
 */
public class CodeConstant {

    public final static ResultCode CSRF_ERROR = new ResultCode("101", "CSRF ERROR:无效的token，或者token过期");
}
