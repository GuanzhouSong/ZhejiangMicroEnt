/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.yr.dto.IndividQuestionnaireDto;
import com.icinfo.cs.yr.model.IndividQuestionnaire;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_individ_questionnaire 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月24日
 */
public interface IIndividQuestionnaireService extends BaseService {
    
	
	/**
     *描述 ： 查询个转企调查表数据
     * @author yujingwei
	 * @param queFlag,pripid,Year
     * @date 2016-9-24
     * @return view
     * @throws Exception
     */
	public List<IndividQuestionnaire> selectQuestionnaireList(String pripid,
			Integer Year, String queFlag) throws Exception;
	
	/**
	 *描述 ：更新个转企调查表信息
	 * @author yujingwei
	 * @param queFlag 
	 * @date 2016-9-24
	 * @return int
	 * @throws Exception
	 */
	public int updateQuestionnaireList(List<IndividQuestionnaire> individQuestionnaireList) throws Exception;
    
	/**
     * 描述 ：金额万元转为元
     * @author yujingwei
	 * @param laseQuestionnaireList 
     * @date 2016-9-24
     * @return List<IndividQuestionnaire>
     * @throws Exception
     */
	public List<IndividQuestionnaire> wrapQuestionnaireList
	           (List<IndividQuestionnaire> questionnaireList) throws Exception;
	
	/**
	 * 描述：元转化为万元
	 * @author yujingwei
	 * @date 2016-9-26
	 * @param qustionaireList
	 * @return List<IndividQuestionnaire>
	 */
	public List<IndividQuestionnaire> wrapDivideQuestionaireList(List<IndividQuestionnaire> questionnaireList) throws Exception;

	/**
	 * 描述：个转企统计
	 * @author baifangfang
	 * @date 2017年4月24日
	 * @param params
	 * @return
	 */
	public IndividQuestionnaireDto qryQuestionnaireCount(Map<String, Object> params);

}