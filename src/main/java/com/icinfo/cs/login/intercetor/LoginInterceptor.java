package com.icinfo.cs.login.intercetor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.login.constant.YrConstants;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.tools.utils.WebUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * Created by FENG on 2016/11/10.
 */
public class LoginInterceptor  implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        //过滤登录页面

        if(url.indexOf(YrConstants.YR_SKIP_URL) >= 0){
            return true;
        }
        //获取Session
        HttpSession session = request.getSession();
        if(session == null|| !request.isRequestedSessionIdValid()){
            response.sendRedirect(request.getContextPath() +sendLoginUrl(url));
            return  false;
        }
        MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute(YrConstants.YR_SESSION_NAME);
        if(midBaseInfoDto == null ){
            if(WebUtils.isAjax(request)) {   // 判断是否是js的ajax 请求
                String _url = sendLoginUrl(url);  //跳转的登录路径
                response.setContentType("application/json;charset=utf-8");
                response.setStatus(401);
                ObjectMapper mapper = new ObjectMapper();
                String json = mapper.writeValueAsString( AjaxResult.error("401.5",_url));
                PrintWriter pw = response.getWriter();
                pw.write(json);
                pw.close();
            }else{
                response.sendRedirect(request.getContextPath() + sendLoginUrl(url));
            }
            return false;
        }
        return true;
    }
    //判断登录地址 add gqf
    public String sendLoginUrl(String url){
        return "/reg/client/login/all"; //国家局统一登录页面退出
     /*  if(url.indexOf("sfc") >= 0){
            return  YrConstants.YR_LOGIN_URL+"/sfc";
        }else if(url.indexOf("pb") >= 0){
            return YrConstants.YR_LOGIN_URL+"/pb";
        }else {
           return YrConstants.YR_LOGIN_URL+"/ent";
       }*/

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
