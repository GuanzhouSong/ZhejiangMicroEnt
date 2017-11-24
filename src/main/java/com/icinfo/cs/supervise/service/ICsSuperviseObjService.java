/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.supervise.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.supervise.dto.CsSuperviseObjDto;
import com.icinfo.cs.supervise.model.CsSuperviseObj;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_supervise_obj 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
public interface ICsSuperviseObjService extends BaseService {
	
	/**
	 * 插入重点监管对象
	 * 
	 * @author zhuyong
	 * @param csSuperviseObj
	 * @return
	 * @throws Exception
	 */
	public int insert(CsSuperviseObjDto csSuperviseObjDto) throws Exception; 
	
	/**
	 * 更新数据信息
	 * 
	 * @author zhuyong
	 * @param csSuperviseObj
	 * @return
	 * @throws Exception
	 */
	public int updateByField(CsSuperviseObj csSuperviseObj,String field) throws Exception; 
	
	
	/**
	 * 重点监管信息查询
	 * 
	 * @author zhuyong
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<CsSuperviseObjDto> queryListPage(PageRequest request) throws Exception;
	
	/**
	 * 重点监管信息查询
	 * 
	 * @author zhuyong
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<CsSuperviseObjDto> queryListNoPage(Map<String,Object> map) throws Exception;
	
	
	/**
	 * 按照批次浏览
	 * 
	 * @author zhuyong
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<CsSuperviseObjDto> queryByBatchNOList(PageRequest request) throws Exception;
	
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
	 * 重点企业监管查看查询
	 * 
	 * @author zhuyong
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<CsSuperviseObjDto> queryForViewList(PageRequest request) throws Exception;
	
	/**
	 * 获取有效企业监管标识
	 * @author zjj
	 */
	public List<CsSuperviseObjDto> selectEffectiveSupMark(Map<String,Object> map) throws Exception;
	
	/**
	 * 获取一家企业重点监管情况
	 * 返回Map作为全景查询索引参数
	 * 
	 * @author zhuyong
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> doGetSuperviewInfoForIndex(String priPID) throws Exception;

	/**
	 * 描述：根据pripid获取重点监管对象
	 * @author baifangfang
	 * @date 2017-4-19
	 * @param priPID
	 * @return
	 */
	public List<CsSuperviseObjDto> qryCsSuperviseObjDtoByPriPID(String priPID);
}