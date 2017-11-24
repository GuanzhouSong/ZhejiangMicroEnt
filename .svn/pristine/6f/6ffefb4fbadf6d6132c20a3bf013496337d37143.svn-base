/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.client;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.yr.dto.IndividQueMainDto;
import com.icinfo.cs.yr.dto.IndividQuestionnaireDto;
import com.icinfo.cs.yr.model.IndividQueMain;
import com.icinfo.cs.yr.model.IndividQuestionnaire;
import com.icinfo.cs.yr.service.IIndividQueMainService;
import com.icinfo.cs.yr.service.IIndividQuestionnaireService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;

/**
 * 描述:    cs_individ_questionnaire 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月24日
 */
@Controller("ClientQuestionnaire")
@RequestMapping("/reg/client/yr/ent/individquestionnaire")
public class IndividQuestionnaireController extends BaseController {
	
	@Autowired
	private IIndividQuestionnaireService IndividQuestionnaireService;
	
	@Autowired
	private IIndividQueMainService individQueMainService;
	
	
	 /**
     * 进入个转企调查表填报页面
     * @author yujingwei
     * @date 2016-9-24
     * @return view
     * @throws Exception
     */
    @RequestMapping("/view")
    public ModelAndView view(HttpSession session) throws Exception {
        ModelAndView view = new ModelAndView("/reg/client/yr/auxtab/individquestion_edit");
        MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
        String pripid = midBaseInfoDto.getPriPID();
        Integer year = Calendar.getInstance().get(Calendar.YEAR);
        Integer lastYear = year - 1 ;
        //1.获取上一年度个转企前的数据
        String queFlag = "1";
        List<IndividQuestionnaire> lastQuestionnaireList = IndividQuestionnaireService.selectQuestionnaireList(pripid,lastYear,queFlag);
        lastQuestionnaireList = IndividQuestionnaireService.wrapQuestionnaireList(lastQuestionnaireList);
        //2.获取当前年度个转企前后数据
        List<IndividQuestionnaire> questionnaireList = IndividQuestionnaireService.selectQuestionnaireList(pripid,year,null);
        questionnaireList = IndividQuestionnaireService.wrapQuestionnaireList(questionnaireList);
        //3.获取当前年度个转企主表数据
        List<IndividQueMain> individQueMainList = individQueMainService.selectIndividQueMainList(pripid,year);
        //4.上一年度的转企前数据存在并且当前年度未填写数据时，将上年度转企前数据复制到当年度
        if(lastQuestionnaireList.size() != 0 && questionnaireList.size() == 0){
        	questionnaireList.add(lastQuestionnaireList.get(0));
        }
        view.addObject("questionnaireList", questionnaireList);
        view.addObject("individQueMainList", individQueMainList);
        return view;
    }
    
    
    /**
     * 个转企调查表提交
     * @author yujingwei
     * @date 2016-9-26
     * @param IndividQuestionnaireDto
     * @param individQueMainDto,session
     * @return AjaxResult
     * @throws Exception
     */
    @RequestMapping(value = "commit", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult commit(IndividQuestionnaireDto IndividQuestionnaireDto,IndividQueMainDto individQueMainDto,HttpSession session) throws Exception {
    	MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
    	List<IndividQuestionnaire> questionnaireList = IndividQuestionnaireDto.getQuestionnaireList();
    	List<IndividQueMain> individQueMainList = individQueMainDto.getIndividQueMainList();
    	IndividQueMain individQueMain = individQueMainList.get(0);
    	if(CollectionUtils.isNotEmpty(individQueMainList) 
    			   && CollectionUtils.isNotEmpty(questionnaireList)){
    		try {
    			//提交
        		boolean commitFlag = individQueMainService.doCommitQuestionnaireInfo(questionnaireList,individQueMain,midBaseInfoDto);
        		if(commitFlag){
        			return AjaxResult.success("提交成功！");
        		}
			} catch (Exception e) {
				AjaxResult.error("保存失败！请重试");
			}
    	}
    	return AjaxResult.error("保存失败！请重试");
    }

}