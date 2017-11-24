/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.login.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.login.dto.PubPhoneapplyDto;
import com.icinfo.cs.login.model.PubPhoneapply;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_phoneapply 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
public interface IPubPhoneapplyService extends BaseService {
	
	/**
	 * 
	 * 描述: 添加
	 * @auther gaojinling
	 * @date 2016年8月29日 
	 * @param phoneApply
	 * @return
	 */
    public int savePubPhoneapply(PubPhoneapply phoneApply);
    
    /**
     * 
     * 描述: 更新（通过流水号更新）
     * @auther gaojinling
     * @date 2016年8月31日 
     * @param phoneApply
     * @return
     */
    public int update(PubPhoneapply phoneApply);
    
    /**
     * 
     * 描述: 联络员确认书打印查询
     * @auther gaojinling
     * @date 2016年8月29日 
     * @param map
     * @return
     */
    public List<PubPhoneapplyDto> selectPhoneApplyPrint(Map<String, Object> map);
    
    /**
     * 
     * 描述: 获取联络员接收列表list数据
     * @auther yujingwei
     * @date 2016年8月29日 
     * @param map
     * @return
     */
	public List<PubPhoneapply> queryPage(PageRequest request);
    
	/**
     * 描述: 查询联络员申请信息
	 * @param pripid ,pripid
     * @auther yujingwei
     * @date 2016年8月29日 
     * @return PubPhoneapply
     */
	public PubPhoneapply selectPubPhoneApplyInfo(String pasid, String pripid);
    
    /**
	 * 
	 * 描述: 单条件查询
	 * @auther gaojinling
	 * @date 2016年8月31日 
	 * @param key 传入的属性
	 * @param Value 属性值
	 * @return
	 */
	List<PubPhoneapply> selectPubPhoneapplyByOne(String key,String Value); 
	
	/**
	 * @描述：联络员确认书接收
	 * @author chenxin
	 * @date 2016-09-08
	 * @param pasid
	 * @param sysUser 
	 * @return
	 * @throws Exception
	 */
	public boolean acceptPubPhoneApply(String pasid, SysUserDto sysUser)throws Exception;
}