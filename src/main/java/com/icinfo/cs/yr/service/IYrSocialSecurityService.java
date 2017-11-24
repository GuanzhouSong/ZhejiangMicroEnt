/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import com.icinfo.cs.yr.model.YrSocialSecurity;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:  cs_yr_social_security 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年11月21日
 */
public interface IYrSocialSecurityService extends BaseService {

    /**
     * 根据年份和主体身份代码进行查询
     * @author: wangjin
     * @return
     */
    YrSocialSecurity selectByYearAndPripid(Integer year, String priPID);

    /**
     * 更新数据
     * @param yrSocialSecurity
     * @return
     */
    int update(YrSocialSecurity yrSocialSecurity);

    /**
     * 添加数据
     * @param yrSocialSecurity
     * @return
     */
    int insert(YrSocialSecurity yrSocialSecurity);
}