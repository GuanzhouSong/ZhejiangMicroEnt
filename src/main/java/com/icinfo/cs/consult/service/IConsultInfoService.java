/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.consult.service;

import java.util.List;

import com.icinfo.cs.consult.dto.ConsultInfoDto;
import com.icinfo.cs.consult.model.ConsultInfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_consult_info 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年10月12日
 */
public interface IConsultInfoService extends BaseService {
	
	/**
	 * 
	 * 描述   保存
	 * @author 赵祥江
	 * @date 2017年10月12日 上午9:41:45 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int insertConsultInfo (ConsultInfo consultInfo) throws Exception;
	
	/**
	 * 
	 * 描述   根据uid删除
	 * @author 赵祥江
	 * @date 2017年10月12日 上午9:42:30 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int deleteConsultInfoByUid (String uid) throws Exception;
	
	/**
	 * 
	 * 描述   修改
	 * @author 赵祥江
	 * @date 2017年10月12日 上午9:42:59 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int updateConsultInfo (ConsultInfo consultInfo) throws Exception;
	
	/**
	 * 
	 * 描述   根据uid查询
	 * @author 赵祥江
	 * @date 2017年10月12日 上午9:43:51 
	 * @param 
	 * @return ConsultInfo
	 * @throws
	 */
	public ConsultInfo selectConsultInfoByUid (String uid) throws Exception;
	
	/**
	 * 
	 * 描述   分页查询
	 * @author 赵祥江
	 * @date 2017年10月12日 下午1:56:11 
	 * @param 
	 * @return List<ConsultInfoDto>
	 * @throws
	 */
	public List<ConsultInfoDto> queryConsultInfoListJSON(PageRequest request)throws Exception;
	
	/**
	 * 
	 * 描述   组装信息
	 * @author 赵祥江
	 * @date 2017年10月12日 下午4:26:58 
	 * @param 
	 * @return ConsultInfo
	 * @throws
	 */
	public ConsultInfo getConsultInfo(ConsultInfo consultInfo) throws Exception;
	
}