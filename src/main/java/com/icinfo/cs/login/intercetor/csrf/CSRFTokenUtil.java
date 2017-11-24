package com.icinfo.cs.login.intercetor.csrf;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * Created by FENG on 2017/7/14.
 * icinfo inc
 */
public class CSRFTokenUtil {
    /**
    * 描述：
    * @author gqf
    * @param
    * @return 
     *@date 2017/7/14 
    */
    public static String generate(HttpServletRequest request) {

        return UUID.randomUUID().toString();
    }
}
