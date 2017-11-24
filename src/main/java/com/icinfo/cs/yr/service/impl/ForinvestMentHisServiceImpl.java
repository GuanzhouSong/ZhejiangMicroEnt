/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.yr.mapper.ForinvestMentHisMapper;
import com.icinfo.cs.yr.model.ForinvestMentHis;
import com.icinfo.cs.yr.service.IForinvestMentHisService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_forinvestment_his 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
@Service
public class ForinvestMentHisServiceImpl extends MyBatisServiceSupport implements IForinvestMentHisService {
	private static final Logger logger = LoggerFactory.getLogger(ForGuaranteeInfoHisServiceImpl.class);

	@Autowired
	private ForinvestMentHisMapper forinvestMentHisMapper;
	/**
	 * 
	 * 描述             : 根据年报ID分页查询 公示 对外投资信息 历史信息
	 * @author: 赵祥江
	 * @date  : 2016年9月10日 上午9:18:11 
	 * @param : anCheID:年报ID
	 * @return: List<ForinvestMentHis>
	 * @throws
	 */
	public List<ForinvestMentHis> queryPage(PageRequest request) throws Exception {
		try {
			Map<String, Object> searchMap=  request.getParams();
			PageHelper.startPage(request.getPageNum(), request.getLength());
			Example example=this.getExample(ForinvestMentHis.class);
			//年报ID
			if(searchMap.containsKey(Constants.CS_ANCHEID)){
				example.createCriteria()
				.andEqualTo(Constants.CS_ANCHEID, searchMap.get(Constants.CS_ANCHEID).toString());
				List<ForinvestMentHis>  forinvestMentHisList= forinvestMentHisMapper.selectByExample(example);
				if(forinvestMentHisList.size()>0){
					return forinvestMentHisList;
				} 
			} 
			return new ArrayList<ForinvestMentHis>();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据年报ID分页查询 公示 年报对外投资 历史信息失败!");
            throw new BusinessException("根据年报ID分页查询 公示 年报对外投资 历史信息失败!");
		}
	}
	
	private Example getExample(Class<?> classObj){
		Example example=new Example(classObj); 
		return example;
	}

	/** 
	 * 描述: 保存公示对外投资历史记录
	 * @auther ZhouYan
	 * @date 2016年9月19日 
	 * @param forinvestMentHis
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int insert(ForinvestMentHis forinvestMentHis) throws Exception {
		return forinvestMentHisMapper.insert(forinvestMentHis);
	}

	/**
	 * 
	 * 描述   根据年报ID和年报编码查询历史信息
	 * @author 赵祥江
	 * @date 2016年9月26日 下午7:19:21 
	 * @param 
	 * @return List<ForinvestMentHis>
	 * @throws
	 */
	@Override
	public List<ForinvestMentHis> selectForinvestMentHisByAnCheIDAndReportNo(
			String anCheID, String reportNo) throws Exception {
		ForinvestMentHis forinvestMentHis=new ForinvestMentHis();
		forinvestMentHis.setAnCheID(anCheID);
		forinvestMentHis.setReportNo(reportNo);
		return forinvestMentHisMapper.select(forinvestMentHis);
	}
	
}