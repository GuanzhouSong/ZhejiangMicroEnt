/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.copysend.service.impl;

import com.icinfo.cs.copysend.mapper.CopySendIllegalMapper;
import com.icinfo.cs.copysend.model.CopySend;
import com.icinfo.cs.copysend.model.CopySendIllegal;
import com.icinfo.cs.copysend.service.ICopySendIllegalService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_copy_send_illegal 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月24日
 */
@Service
public class CopySendIllegalServiceImpl extends MyBatisServiceSupport implements ICopySendIllegalService {
	@Autowired
	CopySendIllegalMapper copySendIllegalMapper;
	
	/**
     * 描述: 涉嫌违法当事人添加数据
     *
     * @return
     * @throws Exception
     * @auther ylr
     * @date 2016年10月24日
     */
	public Integer insert(CopySendIllegal copySendIllegal) throws Exception{
		return copySendIllegalMapper.insert(copySendIllegal);
	}
	
	/**
     * 描述: 根据批次号获取涉嫌违法当事人列表
     *
     * @return
     * @throws Exception
     * @auther ylr
     * @date 2016年10月28日
     */
	public List<CopySendIllegal> selectIllegalListByCopyFormNo(String copyFormNo) throws Exception{
		Example example = new Example(CopySendIllegal.class);
		example.createCriteria().andEqualTo("copyFormNo", copyFormNo);
		return copySendIllegalMapper.selectByExample(example);
	}
	
	/**
     * 描述: 根据批次号删除涉嫌违法当事人列表
     *
     * @return
     * @throws Exception
     * @auther ylr
     * @date 2016年10月28日
     */
	public Integer deleteByCopyFormNo(String copyFormNo) throws Exception{
		Example example = new Example(CopySendIllegal.class);
		example.createCriteria().andEqualTo("copyFormNo", copyFormNo);
		return copySendIllegalMapper.deleteByExample(example);
	}
	
	/**
     * 描述: 根据pripid统计企业被添加抄告抄送次数
     *
     * @return
     * @throws Exception
     * @auther ylr
     * @date 2016年11月28日
     */
	public Integer selectCountByPriPID(String priPID) throws Exception{
		Example example = new Example(CopySendIllegal.class);
		example.createCriteria().andEqualTo("priPID", priPID);
		return copySendIllegalMapper.selectCountByExample(example);
	}
}