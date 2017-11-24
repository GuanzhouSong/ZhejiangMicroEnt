/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.yr.model.ForGuaranteeInfoHis;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_forguaranteeinfo_his 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
public interface IForGuaranteeInfoHisService extends BaseService {
	/**
	 * 
	 * 描述             : 根据年报ID分页查询 公示 年报对外担保  历史信息
	 * @author: 赵祥江
	 * @date  : 2016年9月10日 上午9:11:55 
	 * @param : anCheID:年报ID
	 * @return: List<ForGuaranteeInfoHis>
	 * @throws
	 */
	public List<ForGuaranteeInfoHis> queryPage(PageRequest request) throws Exception;
	
	/** 
	 * 描述: 保存公示对外担保历史记录
	 * @auther ZhouYan
	 * @date 2016年9月19日 
	 * @param forGuaranteeInfoHis
	 * @return
	 * @throws Exception 
	 */
	public int insert(ForGuaranteeInfoHis forGuaranteeInfoHis)throws Exception;

	/**
	 * 
	 * 描述   根据年报ID和年报编码获取历史信息
	 * @author 赵祥江
	 * @date 2016年9月26日 下午7:15:20 
	 * @param 
	 * @return List<ForGuaranteeInfoHis>
	 * @throws
	 */
    public List<ForGuaranteeInfoHis> selectForGuaranteeInfoHisByAnCheIDAnd(String anCheID,String reportNo)throws Exception;

}