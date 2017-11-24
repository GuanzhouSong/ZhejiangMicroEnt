/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.yr.dto.IndividQuestionnaireDto;
import com.icinfo.cs.yr.mapper.IndividQuestionnaireMapper;
import com.icinfo.cs.yr.model.IndividQuestionnaire;
import com.icinfo.cs.yr.service.IIndividQuestionnaireService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述: cs_individ_questionnaire 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月24日
 */
@Service
public class IndividQuestionnaireServiceImpl extends MyBatisServiceSupport implements IIndividQuestionnaireService {

	@Autowired
	private IndividQuestionnaireMapper individQuestionnaireMapper;

	/**
	 * 描述 ： 查询个转企调查表数据
	 * 
	 * @author yujingwei
	 * @param queFlag,pripid,Year
	 * @date 2016-9-24
	 * @return view
	 * @throws Exception
	 */
	@Override
	public List<IndividQuestionnaire> selectQuestionnaireList(String pripid, Integer Year, String queFlag)
			throws Exception {
		Example example = new Example(IndividQuestionnaire.class);
		Criteria criteria = example.createCriteria().andEqualTo("priPID", pripid);
		criteria.andEqualTo("year", Year);
		if (queFlag != null) {
			criteria.andEqualTo("queFlag", queFlag);
		}
		return individQuestionnaireMapper.selectByExample(example);
	}

	/**
	 * 描述 ：更新个转企调查表信息
	 * 
	 * @author yujingwei
	 * @param queFlag
	 * @date 2016-9-24
	 * @return int
	 * @throws Exception
	 */
	public int updateQuestionnaireList(List<IndividQuestionnaire> individQuestionnaireList) throws Exception {
		int count = 0;
		for (IndividQuestionnaire individQuestionnaire : individQuestionnaireList) {
			Example example = new Example(IndividQuestionnaire.class);
			example.createCriteria().andEqualTo("priPID", individQuestionnaire.getPriPID())
					.andEqualTo("year", individQuestionnaire.getYear())
					.andEqualTo("queFlag", individQuestionnaire.getQueFlag());
			individQuestionnaireMapper.updateByExampleSelective(individQuestionnaire, example);
			count++;
		}
		return count;
	}

	/**
	 * 描述 ：金额万元转为元
	 * 
	 * @author yujingwei
	 * @param questionnaireList
	 * @date 2016-9-24
	 * @return List<IndividQuestionnaire>
	 * @throws Exception
	 */
	@Override
	public List<IndividQuestionnaire> wrapQuestionnaireList(List<IndividQuestionnaire> questionnaireList)
			throws Exception {
		if (questionnaireList == null || questionnaireList.isEmpty()) {
			return questionnaireList;
		}
		IndividQuestionnaire beforeQuestionnaire = questionnaireList.get(0);
		// 转企前 年产值或营业额
		beforeQuestionnaire.setVendInc(beforeQuestionnaire.getVendInc() == null ? null
				: beforeQuestionnaire.getVendInc().multiply(new BigDecimal(10000)));
		// 转企前 年利润
		beforeQuestionnaire.setProGro(beforeQuestionnaire.getProGro() == null ? null
				: beforeQuestionnaire.getProGro().multiply(new BigDecimal(10000)));
		// 转企前 纳税总额
		beforeQuestionnaire.setRatGro(beforeQuestionnaire.getRatGro() == null ? null
				: beforeQuestionnaire.getRatGro().multiply(new BigDecimal(10000)));
		// 转企前 社保总费用
		beforeQuestionnaire.setSocIns(beforeQuestionnaire.getSocIns() == null ? null
				: beforeQuestionnaire.getSocIns().multiply(new BigDecimal(10000)));
		// 转企前 企业融资情况
		beforeQuestionnaire.setComLoan(beforeQuestionnaire.getComLoan() == null ? null
				: beforeQuestionnaire.getComLoan().multiply(new BigDecimal(10000)));
		if (questionnaireList.size() > 1) {
			IndividQuestionnaire afterQuestionnaire = questionnaireList.get(1);
			// 转企后 年产值或营业额
			afterQuestionnaire.setVendInc(afterQuestionnaire.getVendInc() == null ? null
					: afterQuestionnaire.getVendInc().multiply(new BigDecimal(10000)));
			// 转企后 年利润
			afterQuestionnaire.setProGro(afterQuestionnaire.getProGro() == null ? null
					: afterQuestionnaire.getProGro().multiply(new BigDecimal(10000)));
			// 转企后 纳税总额
			afterQuestionnaire.setRatGro(afterQuestionnaire.getRatGro() == null ? null
					: afterQuestionnaire.getRatGro().multiply(new BigDecimal(10000)));
			// 转企后 社保总费用
			afterQuestionnaire.setSocIns(afterQuestionnaire.getSocIns() == null ? null
					: afterQuestionnaire.getSocIns().multiply(new BigDecimal(10000)));
			// 转企后 企业融资情况
			afterQuestionnaire.setComLoan(afterQuestionnaire.getComLoan() == null ? null
					: afterQuestionnaire.getComLoan().multiply(new BigDecimal(10000)));
		}
		return questionnaireList;
	}

	/**
	 * 描述：元转化为万元
	 * 
	 * @author yujingwei
	 * @date 2016-9-26
	 * @param qustionaireList
	 * @return List<IndividQuestionnaire>
	 */
	public List<IndividQuestionnaire> wrapDivideQuestionaireList(List<IndividQuestionnaire> questionnaireList)
			throws Exception {
		if (questionnaireList == null || questionnaireList.isEmpty()) {
			return questionnaireList;
		}
		// 转企前 年产值或营业额
		questionnaireList.get(0).setVendInc(questionnaireList.get(0).getVendInc() == null ? null
				: questionnaireList.get(0).getVendInc().divide(new BigDecimal(10000)));
		// 转企前 年利润
		questionnaireList.get(0).setProGro(questionnaireList.get(0).getProGro() == null ? null
				: questionnaireList.get(0).getProGro().divide(new BigDecimal(10000)));
		// 转企前 纳税总额
		questionnaireList.get(0).setRatGro(questionnaireList.get(0).getRatGro() == null ? null
				: questionnaireList.get(0).getRatGro().divide(new BigDecimal(10000)));
		// 转企前 社保总费用
		questionnaireList.get(0).setSocIns(questionnaireList.get(0).getSocIns() == null ? null
				: questionnaireList.get(0).getSocIns().divide(new BigDecimal(10000)));
		// 转企前 企业融资情况
		questionnaireList.get(0).setComLoan(questionnaireList.get(0).getComLoan() == null ? null
				: questionnaireList.get(0).getComLoan().divide(new BigDecimal(10000)));
		// 转企前 年产值或营业额
		questionnaireList.get(1).setVendInc(questionnaireList.get(1).getVendInc() == null ? null
				: questionnaireList.get(1).getVendInc().divide(new BigDecimal(10000)));
		// 转企前 年利润
		questionnaireList.get(1).setProGro(questionnaireList.get(1).getProGro() == null ? null
				: questionnaireList.get(1).getProGro().divide(new BigDecimal(10000)));
		// 转企前 纳税总额
		questionnaireList.get(1).setRatGro(questionnaireList.get(1).getRatGro() == null ? null
				: questionnaireList.get(1).getRatGro().divide(new BigDecimal(10000)));
		// 转企前 社保总费用
		questionnaireList.get(1).setSocIns(questionnaireList.get(1).getSocIns() == null ? null
				: questionnaireList.get(1).getSocIns().divide(new BigDecimal(10000)));
		// 转企前 企业融资情况
		questionnaireList.get(1).setComLoan(questionnaireList.get(1).getComLoan() == null ? null
				: questionnaireList.get(1).getComLoan().divide(new BigDecimal(10000)));
		return questionnaireList;
	}

	@Override
	public IndividQuestionnaireDto qryQuestionnaireCount(Map<String, Object> params) {
		IndividQuestionnaireDto individQuestionnaireDto = individQuestionnaireMapper.selectQuestionnaireCount(params);
		if (individQuestionnaireDto != null) {
			individQuestionnaireDto.setVendIncTotal(individQuestionnaireDto.getVendIncTotal() == null ? null
					: individQuestionnaireDto.getVendIncTotal().multiply(new BigDecimal(10000)));
			individQuestionnaireDto.setProGroTotal(individQuestionnaireDto.getProGroTotal() == null ? null
					: individQuestionnaireDto.getProGroTotal().multiply(new BigDecimal(10000)));
			individQuestionnaireDto.setRatGroTotal(individQuestionnaireDto.getRatGroTotal() == null ? null
					: individQuestionnaireDto.getRatGroTotal().multiply(new BigDecimal(10000)));
			individQuestionnaireDto.setSocInsTotal(individQuestionnaireDto.getSocInsTotal() == null ? null
					: individQuestionnaireDto.getSocInsTotal().multiply(new BigDecimal(10000)));
			individQuestionnaireDto.setComLoanTotal(individQuestionnaireDto.getComLoanTotal() == null ? null
					: individQuestionnaireDto.getComLoanTotal().multiply(new BigDecimal(10000)));
			return individQuestionnaireDto;
		}else{
			return new IndividQuestionnaireDto();
		}
	}
}