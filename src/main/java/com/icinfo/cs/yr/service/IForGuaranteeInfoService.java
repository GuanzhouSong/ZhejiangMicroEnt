/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.yr.dto.ForGuaranteeInfoDto;
import com.icinfo.cs.yr.model.ForGuaranteeInfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_forguaranteeinfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
public interface IForGuaranteeInfoService extends BaseService {

	/**
	 * 
	 * 描述             : 根据年报ID分页查询 公示 对外担保信息
	 * @author: 赵祥江
	 * @date  : 2016年9月9日 下午3:55:12 
	 * @param : anCheID:年报ID
	 * @return: List<ForGuaranteeInfo>
	 * @throws
	 */
	public List<ForGuaranteeInfo> queryPage(PageRequest request) throws Exception;


	/**
	 * 
	 * 描述             : 根据年报ID 公示 对外担保信息  不分页
	 * @author: 赵祥江
	 * @date  : 2016年9月19日 下午3:34:47 
	 * @param :
	 * @return: List<ForGuaranteeInfo>
	 * @throws
	 */
    public List<ForGuaranteeInfo> selectForGuaranteeInfoByAnCheID(String anCheID)throws Exception; 
    
    /**
     * 
     * 描述   根据年报ID分页查询
     * @author 赵祥江
     * @date 2017年3月20日 下午5:38:02 
     * @param 
     * @return List<ForGuaranteeInfo>
     * @throws
     */
    public List<ForGuaranteeInfo> selectForGuaranteeInfoByAnCheIDPage(PageRequest request)throws Exception; 
    
    
    
    
    /** 
	 * 描述: 根据年报id删除公示信息
	 * @auther ZhouYan
	 * @date 2016年9月19日 
	 * @param anCheID
	 * @return
	 * @throws Exception 
	 */
	public int deleteByAnCheID(String anCheID) throws Exception;
	
	/** 
	 * 描述: 根据年报id保存公示信息
	 * @auther ZhouYan
	 * @date 2016年9月19日 
	 * @param anCheID
	 * @return
	 * @throws Exception 
	 */
	public int insertByAnCheID(String anCheID) throws Exception;


	/**
	 * 
	 * 描述: 公示侧获取对外担保信息（过滤敏感词）
	 * @auther chenyl
	 * @date 2016年10月10日 
	 * @param request
	 * @return
	 */
	public List<ForGuaranteeInfoDto> queryPageForPub(PageRequest request);
	
	/** 
	 * 描述: 保存公示信息
	 * @auther ZhouYan
	 * @date 2016年11月11日 
	 * @param forGuaranteeInfo
	 * @return
	 * @throws Exception 
	 */
	public int insert(ForGuaranteeInfo forGuaranteeInfo)throws Exception;
}