/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.concern.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.concern.dto.CsConcernObjDto;
import com.icinfo.cs.concern.model.CsConcernObj;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_concern_obj 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年11月01日
 */
public interface ICsConcernObjService extends BaseService {
	/**
	 * 获取企业关注服务申请数据
	 * @author zjj
	 */
	public List<CsConcernObjDto> queryPage(PageRequest request) throws Exception;
	/**
	 * 获取指定企业关注服务申请数据
	 */
	public List<CsConcernObjDto> selectCsConObjInfo(Map<String,Object> qryMap) throws Exception;
	
	
	/**
	 * 插入关注服务对象数据
	 * @author zjj
	 * @param csSuperviseObjDto
	 * @return
	 * @throws Exception
	 */
	public int insert(CsConcernObjDto csConcernObj) throws Exception;
	
	/**
	 * 删除标识信息
	 * 
	 * @param batchNO
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	public int doDelByAndPriPID(String batchNO,String priPID) throws Exception;
	/**
	 * 更新数据信息
	 * 
	 * @author zjj
	 * @throws Exception
	 */
	public int updateByField(CsConcernObj csConcernObj,String field) throws Exception;
	
	public List<CsConcernObjDto> queryAllUnauditPage(PageRequest request) throws Exception; 
	/**
	 * 获取企业预警查看页面数据
	 * @author zjj
	 */
	public List<CsConcernObjDto> queryPageForView(PageRequest request) throws Exception;
	/**
	 * 获取企业有效关注标识
	 * @author zjj
	 */
	public List<CsConcernObjDto> selectEffectiveConMark(Map<String,Object> qryMap) throws Exception;
	/**
	 * 获取一家企业关注服务情况
	 * 返回Map作为全景查询索引参数
	 * 
	 * @author zjj
	 */
	public Map<String,Object> doGetConcernInfoForIndex(String priPID) throws Exception;
	
	/**
	 * 描述：根据pripid获取有效的关注服务对象
	 * @author baifangfang
	 * @date 2017-04-19
	 * @param priPID
	 * @return
	 */
	public List<CsConcernObjDto> qryCsConcernObjDtoByPriPID(String priPID);
}