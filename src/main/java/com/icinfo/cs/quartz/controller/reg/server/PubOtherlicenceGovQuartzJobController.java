package com.icinfo.cs.quartz.controller.reg.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icinfo.cs.quartz.service.IPubOtherlicenceGovQuartzJobService;
import com.icinfo.framework.core.web.BaseController;

/**
 * 
 * 描述:   公示许可证定时JOB
 * @author: 赵祥江
 * @date: 2017年11月20日 下午3:14:03
 */
@Controller
@RequestMapping("/quartz/pubotherlicencegov")
public class PubOtherlicenceGovQuartzJobController extends BaseController{
	@Autowired
	private IPubOtherlicenceGovQuartzJobService pubOtherlicenceGovQuartzJobService; 
	 
	/**
	 * 
	 * 描述   公示许可证定时任务
	 * @author 赵祥江
	 * @date 2017年11月20日 下午3:47:24 
	 * @param 
	 * @return void
	 * @throws
	 */
	public void pubOtherlicenceGovQuartzJob() throws Exception{
		pubOtherlicenceGovQuartzJobService.pubOtherlicenceGovQuartzJob();
	} 
}
