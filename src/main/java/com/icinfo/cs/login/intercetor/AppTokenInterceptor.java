package com.icinfo.cs.login.intercetor;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icinfo.cs.pbapp.controller.AppTokenCheck;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.tools.utils.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.HeaderParam;

import java.lang.reflect.Method;

/**
 * Created by FENG on 2016/11/10.
 */
public class AppTokenInterceptor  extends HandlerInterceptorAdapter {

	 private final static Logger logger = LoggerFactory.getLogger(AppTokenInterceptor.class);


	 //App 用户端token
     public static final String APP_TOKEN ="token";
	 
	 @Autowired
	 private com.icinfo.cs.pbapp.service.impl.TokenManager tokenManager;

	    @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	        if (handler instanceof HandlerMethod) {
	            HandlerMethod handlerMethod = (HandlerMethod) handler;
	            Method method = handlerMethod.getMethod();
	            AppTokenCheck annotation = method.getAnnotation(AppTokenCheck.class);
	            if (annotation != null) {
	                
	                //获取传过来参数中token
		            logger.info("本次访问中方式为："+request.getMethod());
		            String clientToken; 
		            if("GET".equals(request.getMethod())){  //get方式token值在请求参数中
		            	clientToken = request.getParameter(APP_TOKEN);
		            }else{ //post 方式token值放入header中
			            clientToken=request.getHeader(APP_TOKEN);
		            }
		            logger.info("本次访问中token值为"+clientToken);

		            String tel = tokenManager.getClientTokenValue(clientToken);

		        	if(StringUtils.isBlank(tel)){
		                response.setContentType("application/json;charset=utf-8");
		                ObjectMapper mapper = new ObjectMapper();
		           	    JSONObject jsonObj = new JSONObject();
						jsonObj.put("status", "1");
						jsonObj.put("result",  "");
						jsonObj.put("errcode", "400"); 
						jsonObj.put("msg", "token验证错误"); 
		                String json = mapper.writeValueAsString(AjaxResult.success("token验证错误", jsonObj));
		                ServletOutputStream out = response.getOutputStream();
		                out.write(json.getBytes());
		                out.flush();
		                out.close();
			            return false;
		        	}
//		    		request.setAttribute("tel",tel);             
	            }
	            return true;
	        } else {
	            return super.preHandle(request, response, handler);
	        }
	    }


	  

		@Override
		public void postHandle(HttpServletRequest request,
				HttpServletResponse response, Object handler,
				ModelAndView modelAndView) throws Exception {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void afterCompletion(HttpServletRequest request,
				HttpServletResponse response, Object handler, Exception ex)
				throws Exception {
			// TODO Auto-generated method stub
			
		}
}
