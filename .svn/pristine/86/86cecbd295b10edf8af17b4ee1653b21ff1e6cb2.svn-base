/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.yr.dto.ForinvestMentDto;
import com.icinfo.cs.yr.model.ForinvestMent;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_forinvestment 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
public interface IForinvestMentService extends BaseService {

	/**
	 * 
	 * 描述             : 根据年报ID分页查询 公示 对外投资
	 * @author: 赵祥江
	 * @date  : 2016年9月9日 下午3:55:12 
	 * @param : anCheID:年报ID
	 * @return: List<ForinvestMent>
	 * @throws
	 */
	public List<ForinvestMent> queryPage(PageRequest request) throws Exception;
	
	/**
	 * 
	 * 描述             : 根据年报ID获取对外投资不分页
	 * @author: 赵祥江
	 * @date  : 2016年9月19日 下午2:23:27 
	 * @param :
	 * @return: List<ForinvestMent>
	 * @throws
	 */
	public List<ForinvestMent> selectForinvestMentByAnCheID(String anCheID) throws Exception;
	
	/** 
	 * 描述: 根据年报id删除公示信息
	 * @auther ZhouYan
	 * @date 2016年9月19日 
	 * @param anCheID
	 * @return
	 * @throws Exception 
	 */
	public int deleteByAnCheID(String anCheID) throws Exception;
	
	/** 
	 * 描述: 根据年报id保存公示信息
	 * @auther ZhouYan
	 * @date 2016年9月19日 
	 * @param anCheID
	 * @return
	 * @throws Exception 
	 */
	public int insertByAnCheID(String anCheID) throws Exception;

	/**
	 * 
	 * 描述: 公示侧对外投资信息查询（过滤敏感词）
	 * @auther chenyl
	 * @date 2016年10月10日 
	 * @param request
	 * @return
	 */
	public List<ForinvestMentDto> queryPageForPub(PageRequest request);

	/**
	 * 描述：根据年报id查询对外投资列表
	 * @author baifangfang
	 * @date 2016年10月26日
	 * @param anCheID
	 * @return
	 */
	public List<ForinvestMentDto> queryListResult(String anCheID);

	/** 
     * 描述: 保存公示信息
     * @auther ZhouYan
     * @date 2016年11月11日 
     * @param forinvestMent
     * @return
     * @throws Exception 
     */
    public int insert(ForinvestMent forinvestMent)throws Exception;
}