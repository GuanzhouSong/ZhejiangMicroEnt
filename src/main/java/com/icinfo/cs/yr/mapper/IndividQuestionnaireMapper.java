/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年09月24日
 * @version 2.0
 */
package com.icinfo.cs.yr.mapper;

import java.util.Map;

import com.icinfo.cs.yr.dto.IndividQuestionnaireDto;
import com.icinfo.cs.yr.model.IndividQuestionnaire;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_individ_questionnaire 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年09月24日
 */
public interface IndividQuestionnaireMapper extends Mapper<IndividQuestionnaire> {

	/**
	 * 描述：个转企统计
	 * @author Administrator
	 * @date 2017年4月24日
	 * @param params
	 * @return
	 */
	IndividQuestionnaireDto selectQuestionnaireCount(Map<String, Object> params);

}