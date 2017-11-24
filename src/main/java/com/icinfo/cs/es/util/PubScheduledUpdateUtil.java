package com.icinfo.cs.es.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icinfo.cs.es.service.IEntSearchService;

@Component
public class PubScheduledUpdateUtil {
	
	@Autowired
	IEntSearchService entSearchService;
	
	/**
	 * 公示索引维护定时任务
	 * 
	 * @author baifangfang
	 * @date 2016-12-05
	 */
	public void pubQuartzJob(){
		entSearchService.doInsertIncreToGs();
	}
}
