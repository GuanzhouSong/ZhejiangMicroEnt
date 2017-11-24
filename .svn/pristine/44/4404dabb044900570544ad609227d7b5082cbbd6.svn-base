/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service;

import com.icinfo.cs.system.model.SysUserCheckRecord;
import com.icinfo.framework.core.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * 描述:   用户验证记录 SYS_USER_CHECK_RECORD 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年12月20日
 */
public interface ISysUserCheckRecordService extends BaseService {

    /**
     * 检查当前用户是否经过验证
     * @author ZhuDefeng
     * @date 2016-12-20
     * @param userName
     * @return
     */
    boolean isChecked(String userName) throws Exception;


    /**
     * 验证用户
     * @author ZhuDefeng
     * @date 2016-12-20
     * @param sysUserCheckRecord
     * @return
     */
    Map<String,String> checkUser(SysUserCheckRecord sysUserCheckRecord) throws Exception;


    /**
     * 校验短信验证码
     * @author ZhuDefeng
     * @return
     * @throws Exception
     */
    boolean ckSMSCode()throws Exception;


    /**
     * 根据用户名来查询验证记录
     * @author ZhuDefeng
     * @param username
     * @return
     */
    SysUserCheckRecord selectByUserName(String username)throws Exception;

    /**
     * 保存校验记录
     * @author ZhuDefeng
     * @return
     * @throws Exception
     */
    int saveRecord(SysUserCheckRecord sysUserCheckRecord,String optType)throws Exception;

    /**
     * 判断手机号码是否已经被注册
     * @author ZhuDefeng
     * @param telPhone
     * @return
     * @throws Exception
     */
    boolean isExistTelPhone(String telPhone,String userType)throws Exception;
    
    /**
     * 
     * 描述   获取所有数据
     * @author 赵祥江
     * @date 2016年12月22日 下午7:51:27 
     * @param 
     * @return List<SysUserCheckRecord>
     * @throws
     */
    List<SysUserCheckRecord>  selectAllSysUserCheckRecord()throws Exception;
}