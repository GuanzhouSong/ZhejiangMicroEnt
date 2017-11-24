/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.registinfo.service.impl;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.registinfo.mapper.UlManageMapper;
import com.icinfo.cs.registinfo.model.UlManage;
import com.icinfo.cs.registinfo.service.IUlManageService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.security.shiro.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * 描述:    cs_ul_manage 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
@Service
public class UlManageServiceImpl extends MyBatisServiceSupport implements IUlManageService {
    @Autowired
    UlManageMapper ulManageMapper;
    @Autowired
    HttpSession session;
    @Override
    public int addUlManage(UlManage ulManage) {
        UserProfile userProfile = (UserProfile) session.getAttribute(Constants.SESSION_SYS_USER_KEY);
        ulManage.setDisposeName(userProfile.getUsername());
        ulManage.setCreateTime(new Date());
        ulManage.setDisposeDate(new Date());
        return ulManageMapper.insert(ulManage);
    }
}