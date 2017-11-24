/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.risk.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.risk.mapper.CsWarnMarkMapper;
import com.icinfo.cs.risk.model.CsWarnMark;
import com.icinfo.cs.risk.service.ICsWarnMarkService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_warn_mark 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月18日
 */
@Service
public class CsWarnMarkServiceImpl extends MyBatisServiceSupport implements ICsWarnMarkService {

	@Autowired
	CsWarnMarkMapper csWarnMarkMapper;
	
   /**
    * 预警标识查询
    * @author zjj
    * 20161018
    */
	@Override
	public List<CsWarnMark> queryPage(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return csWarnMarkMapper.selectWarnMarkList(request.getParams());
	}

		
	@Override
	public int update(CsWarnMark csWarnMark) throws Exception {
		Example example = new Example(CsWarnMark.class);
        example.createCriteria().andEqualTo("uid", csWarnMark.getUid());
		return csWarnMarkMapper.updateByExampleSelective(csWarnMark, example);
	}

	@Override
	public int insert(CsWarnMark csWarnMark) throws Exception {
		return csWarnMarkMapper.insert(csWarnMark);
	}


	@Override
	public int disableUpdate(CsWarnMark csWarnMark) throws Exception {
		Example example = new Example(CsWarnMark.class);
        example.createCriteria().andEqualTo("uid", csWarnMark.getUid());
		return csWarnMarkMapper.updateByExampleSelective(csWarnMark, example);
	}
    /**
     * 获取设置年份
     * @author zjj
     */
	@Override
	public List<CsWarnMark> selectCsWarnMarkSetYear() throws Exception {
		return csWarnMarkMapper.selectCsWarnMarkSetYear();
	}
	

	/**
	 * 获取指定标记
	 * @author zjj
	 * 20161025
	 */
	@Override
	public List<CsWarnMark> selectCsWarnMarkList(Map<String, Object> qryMap) throws Exception {
		return csWarnMarkMapper.selectWarnMarkList(qryMap);
	}

}