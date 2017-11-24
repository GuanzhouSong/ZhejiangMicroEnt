/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.yr.dto.IndividQueMainDto;
import com.icinfo.cs.yr.model.IndividQueMain;
import com.icinfo.cs.yr.model.IndividQuestionnaire;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_individ_quemain 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月24日
 */
public interface IIndividQueMainService extends BaseService {
     
	
	 /**
     * 获取当前年度个转企主表数据
     * @author yujingwei
     * @date 2016-9-24
     * @return List<IndividQueMain>
     * @throws Exception
     */
	public List<IndividQueMain> selectIndividQueMainList(String pripid, Integer year) throws Exception;

	
	/**
     * 提交个转企调查表信息
     * @author yujingwei
     * @date 2016-9-24
     * @param List<IndividQueMain>
     * @param IndividQueMain individQueMain
     * @param midBaseInfoDto
     * @throws Exception
     */
	public boolean doCommitQuestionnaireInfo(List<IndividQuestionnaire> questionnaireList,
			   IndividQueMain individQueMain, MidBaseInfoDto midBaseInfoDto) throws Exception;

	
	/**
     * 描述：获取个转企调查表列表数据(工商端)
     * @author yujingwei
     * @param request
     * @return
     * @throws Exception
     */
	public List<IndividQueMain> queryPage(PageRequest request) throws Exception;

	/**
     * 个转企调查表修正(工商端)
     * @author yujingwei
	 * @param sysUser 
     * @param IndividQuestionnaireDto
     * @param individQueMainDto
     * @date 2016-9-26
     * @return AjaxResult
     * @throws Exception
     */
	public boolean doEditQuestionnaireForServer(List<IndividQuestionnaire> questionnaireList,
			IndividQueMain individQueMain, SysUser sysUser) throws Exception;

	/**
	 * 描述：个体户调查表统计
	 * @author baifangfang
	 * @date 2017年4月24日
	 * @param params
	 * @return
	 */
	public IndividQueMainDto qryQueMainCount(Map<String, Object> params);

	/**
	 * 描述：个体户调查表按统计量进行统计
	 * @author Administrator
	 * @date 2017年4月26日
	 * @param request
	 * @return
	 */
	public List<IndividQueMainDto> selectSurQuantity(PageRequest request);
}