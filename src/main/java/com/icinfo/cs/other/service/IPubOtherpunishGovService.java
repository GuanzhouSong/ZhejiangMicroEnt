/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.other.dto.PubOtherpunishGovDto;
import com.icinfo.cs.other.model.PubOtherpunishGov;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_otherpunish_gov 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年11月01日
 */
public interface IPubOtherpunishGovService extends BaseService {
	/** 
	 * 描述: 行政处罚归集查询
	 * @auther ZhouYan
	 * @date 2017年11月1日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	List<PubOtherpunishGovDto> selectPubOtherpunishGovList(PageRequest request) throws Exception;
	
	/** 
	 * 描述: 在册企业行政许可数
	 * @auther ZhouYan
	 * @date 2017年11月1日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	Integer selectPubOtherpunishGovRegTotal(Map<String, Object> paramsMap) throws Exception;
	
	
	/**
	 * 
	 * 描述   根据设置部门查询行政处罚
	 * @author 赵祥江
	 * @date 2017年11月21日 下午3:01:25 
	 * @param 
	 * @return List<PubOtherpunishGov>
	 * @throws
	 */
	public List<PubOtherpunishGov> selectPubOtherpunishGovByDeptnameList(String setDeptname)throws Exception;
	
	/**
	 * 
	 * 描述   根据主键ID更新
	 * @author 赵祥江
	 * @date 2017年11月21日 下午3:07:04 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int updatePubOtherpunishGov(PubOtherpunishGov pubOtherpunishGov)throws Exception; 
	  
 
	/**
	 * 
	 * 描述：行政处罚机关个数
	 * @author baifangfang
	 * @date 2017年11月21日
	 * @param paramsMap
	 * @return
	 */
	int selectDeptTotal(Map<String, Object> paramsMap);

	/**
	 * 
	 * 描述：经与市场主体比对记名于企业名下机关个数
	 * @author baifangfang
	 * @date 2017年11月21日
	 * @param paramsMap
	 * @return
	 */
	int selectEntDeptTotal(Map<String, Object> paramsMap);

	PubOtherpunishGovDto selectPunishGovCount(Map<String, Object> paramsMap) throws Exception;
}