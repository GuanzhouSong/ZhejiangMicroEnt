package com.icinfo.cs.quartz.service;

import com.icinfo.framework.core.service.BaseService;

/**
 * 
 * 描述:  公示许可证定时任务
 * @author: 赵祥江
 * @date: 2017年11月20日 下午3:18:25
 */
public interface IPubOtherlicenceGovQuartzJobService extends BaseService{
	

    /**
     * 
     * 描述   公示许可证定时任务
     * @author 赵祥江
     * @date 2017年11月20日 下午3:18:49 
     * @param 
     * @return String
     * @throws
     */
    public String pubOtherlicenceGovQuartzJob() throws Exception;
}
