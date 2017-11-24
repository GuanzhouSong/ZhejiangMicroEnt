/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.ext.service;

import java.util.List;

import com.icinfo.cs.ext.dto.MidInvDto;
import com.icinfo.cs.ext.model.MidInv;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_mid_inv 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
public interface IMidInvService extends BaseService {
	
	/**
	 * 
	 * 描述: 根据内部序号查询投资信息
	 * @auther gaojinling
	 * @date 2016年8月29日 
	 * @param PriPID
	 * @return
	 */
	public List<MidInv>  selectInvListByPriPID(String PriPID);

	/**
	 * 描述：根据priPID查询投资信息
	 * @author baifangfang
	 * @date 2016年9月23日
	 * @param request
	 * @return
	 */
	public List<MidInvDto> queryPageResult(PageRequest request);
	
	/**
	 * 描述：根据cerNo查询投资信息
	 * @author chenyu
	 * @date 2016年11月11日
	 * @param request
	 * @return
	 */
	public List<MidInvDto> queryPageResultByCerNO(PageRequest request) throws Exception;
	
	/**
	 * 描述：根据cerNo查询投资信息
	 * 
	 * @author zhuyong
	 * @date 2016年11月11日
	 * @param request
	 * @return
	 */
	public List<MidInvDto> queryPageResultByCerNO(String cerNO);

	/**
	 * 描述：根据id查询股东及出资信息
	 * @author baifangfang
	 * @date 2016年9月30日
	 * @param midInvId
	 * @return
	 */
	public MidInv findMidInvById(int midInvId);

	/**
	 * 
	 * 描述: 根据内部序号查询投资信息
	 * @auther baifangfang
	 * @date 2016年12月8日 
	 * @param PriPID
	 * @return
	 */
	public List<MidInvDto> queryListResult(String priPID);

	/**
	 * 
	 * 描述: 查询投资表中的合伙人信息
	 * @auther baifangfang
	 * @date 2017年3月10日 
	 * @return
	 */
	public List<MidInv> findMidInvByExeAffSign();
    
	/**
	 * 描述：根据cerNo查询投资信息(企业唯一)
	 * @author yujingwei
	 * @date 2017年03月22日
	 * @param request
	 * @return List<MidInv>
	 */
	public List<MidInv> selectMidInvInfoByCerNO(String certNO) throws Exception;

	/**
	 * 描述：根据证件号和姓名查询法人数量（合伙企业）
	 * @author baifangfang
	 * @date 2017年04月10日
	 * @param certNO
	 * @param name
	 * @return
	 */
	public int qryMidInvByCerNOAndName(String certNO, String name);
	
}