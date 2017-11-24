/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.copysend.service;

import java.util.List;

import com.icinfo.cs.copysend.model.CopySendIllegal;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_copy_send_illegal 对应的Service接口.<br>
 *
 * @author ylr
 * @date 2016年10月24日
 */
public interface ICopySendIllegalService extends BaseService {
	
	/**
     * 描述: 涉嫌违法当事人添加数据
     *
     * @return
     * @throws Exception
     * @auther ylr
     * @date 2016年8月29日
     */
	Integer insert(CopySendIllegal copySendIllegal) throws Exception;
	
	/**
     * 描述: 根据批次号获取涉嫌违法当事人列表
     *
     * @return
     * @throws Exception
     * @auther ylr
     * @date 2016年10月28日
     */
	List<CopySendIllegal> selectIllegalListByCopyFormNo(String copyFormNo) throws Exception;
	
	/**
     * 描述: 根据批次号删除涉嫌违法当事人列表
     *
     * @return
     * @throws Exception
     * @auther ylr
     * @date 2016年10月28日
     */
	Integer deleteByCopyFormNo(String copyFormNo) throws Exception;
	
	/**
     * 描述: 根据pripid统计企业被添加抄告抄送次数
     *
     * @return
     * @throws Exception
     * @auther ylr
     * @date 2016年11月28日
     */
	Integer selectCountByPriPID(String priPID) throws Exception;
	
	
}