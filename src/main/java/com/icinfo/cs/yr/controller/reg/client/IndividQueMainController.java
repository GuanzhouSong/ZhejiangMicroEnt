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

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.yr.model.IndividQueMain;
import com.icinfo.cs.yr.service.IIndividQueMainService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;

/**
 * 描述:    cs_individ_quemain 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月24日
 */
@Controller
@RequestMapping("/reg/client/yr/ent/indiviquemain")
public class IndividQueMainController extends BaseController {
	
	@Autowired
	private IIndividQueMainService individQueMainService;
	
	/**
     * 获取个转企主表信息
     * @author yujingwei
     * @date 2016-9-26
     * @param session
     * @return AjaxResult
     * @throws Exception
     */
    @RequestMapping(value = "search", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult doGetInfo(HttpSession session) throws Exception {
    	MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
    	if(StringUtil.isNotEmpty(midBaseInfoDto.getPriPID())){
    		 Integer year = Calendar.getInstance().get(Calendar.YEAR);
    		 List<IndividQueMain> individQueMainList = individQueMainService.selectIndividQueMainList(midBaseInfoDto.getPriPID(), year);
    		 if(CollectionUtils.isNotEmpty(individQueMainList)){
    			 return AjaxResult.success("IndividQueMain", individQueMainList.get(0));
    		 }
    	}
    	return AjaxResult.success("IndividQueMain",new IndividQueMain());
    }
}