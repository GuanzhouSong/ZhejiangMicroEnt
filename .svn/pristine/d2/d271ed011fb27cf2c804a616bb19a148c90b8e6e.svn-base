/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.yr.dto.IndividQueMainDto;
import com.icinfo.cs.yr.mapper.IndividQueMainMapper;
import com.icinfo.cs.yr.mapper.IndividQuestionnaireMapper;
import com.icinfo.cs.yr.model.IndividQueMain;
import com.icinfo.cs.yr.model.IndividQuestionnaire;
import com.icinfo.cs.yr.service.IIndividQueMainService;
import com.icinfo.cs.yr.service.IIndividQuestionnaireService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 描述:    cs_individ_quemain 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月24日
 */
@Service
public class IndividQueMainServiceImpl extends MyBatisServiceSupport implements IIndividQueMainService {
	
	@Autowired
	private IndividQueMainMapper individQueMainMapper;
	
	@Autowired
	private IndividQuestionnaireMapper individQuestionnaireMapper;
	
	@Autowired
	IIndividQuestionnaireService iIndividQuestionnaireService;
	
	/**
     * 获取当前年度个转企主表数据
     * @author yujingwei
     * @date 2016-9-24
     * @return List<IndividQueMain>
     * @throws Exception
     */
	public List<IndividQueMain> selectIndividQueMainList(String pripid, Integer year) throws Exception{
		Example example = new Example(IndividQueMain.class);
		example.createCriteria().andEqualTo("priPID", pripid).andEqualTo("year", year);
		return individQueMainMapper.selectByExample(example);
	}
	
	/**
     * 提交个转企调查表信息
     * @author yujingwei
     * @date 2016-9-24
     * @param List<IndividQueMain>
     * @param IndividQueMain individQueMain
     * @param midBaseInfoDto
     * @throws Exception
     */
	@Transactional(rollbackFor = Exception.class)
	@Override
	@RepeatSubmit(timeout=1000)
	public boolean doCommitQuestionnaireInfo(List<IndividQuestionnaire> questionnaireList,
			   IndividQueMain individQueMain, MidBaseInfoDto midBaseInfoDto) throws Exception{
			String qmID = "";
			Integer curYear = Calendar.getInstance().get(Calendar.YEAR);
			if(individQueMain != null){
				individQueMain.setCreateTime(new Date());
				if(individQueMain.getAuditState().equals("2")){
					individQueMain.setSetTime(new Date());//填报时间
				}
				if(individQueMain.getQmID().equals("")){
					qmID = StringUtil.getRandomNumberByRegOrg(midBaseInfoDto.getRegOrg());//主表序号
					individQueMain.setQmID(qmID);
					individQueMain.setYear(curYear);
					individQueMainMapper.insert(individQueMain);
				}else{
					Example example = new Example(IndividQueMain.class);
					example.createCriteria().andEqualTo("priPID", individQueMain.getPriPID()).andEqualTo("year", curYear);
					individQueMainMapper.updateByExampleSelective(individQueMain, example);
				}
			}
			if(CollectionUtils.isNotEmpty(questionnaireList)){
				questionnaireList.get(0).setSetDate(new Date());
				questionnaireList.get(0).setYear(curYear);
				questionnaireList.get(1).setSetDate(new Date());
				questionnaireList.get(1).setYear(curYear);
				if(questionnaireList.get(0).getQueID().equals("") || questionnaireList.get(1).getQueID().equals("")){
					String queID_01 = StringUtil.getRandomNumberByRegOrg(midBaseInfoDto.getRegOrg());//生成序号
					String queID_02 = StringUtil.getRandomNumberByRegOrg(midBaseInfoDto.getRegOrg());//生成序号
					questionnaireList.get(0).setQueID(queID_01);
					questionnaireList.get(1).setQueID(queID_02);
					questionnaireList.get(0).setQmID(qmID);//关联主表序号
					questionnaireList.get(1).setQmID(qmID);//关联主表序号
					iIndividQuestionnaireService.wrapDivideQuestionaireList(questionnaireList);
					individQuestionnaireMapper.insert(questionnaireList.get(0));
					individQuestionnaireMapper.insert(questionnaireList.get(1));
				}else{
					iIndividQuestionnaireService.updateQuestionnaireList(
					      iIndividQuestionnaireService.wrapDivideQuestionaireList(questionnaireList));
				}
			}
		   return true;
	}
	
	
	/**
     * 描述：获取个转企调查表列表数据(工商端)
     * @author yujingwei
     * @param request
     * @return
     * @throws Exception
     */
	public List<IndividQueMain> queryPage(PageRequest request) throws Exception{
		 PageHelper.startPage(request.getPageNum(), request.getLength());
	     return individQueMainMapper.selectQueMainInfo(request.getParams());
	}
	
	/**
     * 个转企调查表修正(工商端)
     * @author yujingwei
     * @param IndividQuestionnaireDto
     * @param individQueMainDto
     * @date 2016-9-26
     * @return AjaxResult
     * @throws Exception
     */
	@Override
	public boolean doEditQuestionnaireForServer(List<IndividQuestionnaire> questionnaireList,
			IndividQueMain individQueMain,SysUser sysUser) throws Exception{
			if(individQueMain != null){
				//设置修正人及时间
				individQueMain.setAuditDate(new Date());
				individQueMain.setAuditName(sysUser.getRealName());
				//更新
				Example example = new Example(IndividQueMain.class);
				example.createCriteria().andEqualTo("priPID", individQueMain.getPriPID())
				.andEqualTo("year", individQueMain.getYear());
				individQueMainMapper.updateByExampleSelective(individQueMain, example);
			}
			if(CollectionUtils.isNotEmpty(questionnaireList)){
				iIndividQuestionnaireService.updateQuestionnaireList(
				iIndividQuestionnaireService.wrapDivideQuestionaireList(questionnaireList));
			}
		    return true;
	   }

	@Override
	public IndividQueMainDto qryQueMainCount(Map<String, Object> params) {
		return individQueMainMapper.selectQueMainCount(params);
	}

	@Override
	public List<IndividQueMainDto> selectSurQuantity(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), 10000);
		return individQueMainMapper.selectSurQuantity(request.getParams());
	}
}