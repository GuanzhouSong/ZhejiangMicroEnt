package com.icinfo.cs.es.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icinfo.cs.es.service.ISmEntSearchService;

@Component
public class EmEntScheduledUpdateUtil {
	
	@Autowired
	ISmEntSearchService smEntSearchService;
	/**
	 * 小微企业信息索引维护定时任务
	 * 
	 * @author baifangfang
	 * @date 2017-05-05
	 */
	public void smEntQuartzJob(){
		System.out.println(11+"=================");
		smEntSearchService.doInsertIncreToGs();
	}
}
