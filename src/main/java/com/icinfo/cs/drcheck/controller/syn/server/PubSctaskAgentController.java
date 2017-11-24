/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.controller.syn.server;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.drcheck.dto.PubSctaskAgentDto;
import com.icinfo.cs.drcheck.service.IPubSctaskAgentBackService;
import com.icinfo.cs.drcheck.service.IPubSctaskAgentService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:  cs_pub_sctask_agent 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
@Controller
@RequestMapping("/syn/pub/server/drcheck/pubsctaskagent")
public class PubSctaskAgentController extends BaseController {

    @Autowired
    private IPubSctaskAgentService pubSctaskAgentService;
    
    @Autowired
    private IPubSctaskAgentBackService pubSctaskAgentBackService;
     
    /**
     * 描述：随机页面读取抽取执法人员
     * @author chenxin
     * @date 2016-10-26
     * @return
     * @throws Exception
     */
	@RequestMapping(value="/list.json",method= RequestMethod.GET)
    @ResponseBody
    public PageResponse<PubSctaskAgentDto> listJSON(PageRequest request) throws Exception {
		List<PubSctaskAgentDto>	data = pubSctaskAgentService.queryPubSctaskAgentDtoPage(request);
        return new PageResponse<PubSctaskAgentDto>(data);
    }

	/**
     * 描述：清除已抽取抽取执法人员
     * @author chenxin
     * @date 2016-11-07
     * @return
     * @throws Exception
     */
	@RequestMapping(value="/clean",method= RequestMethod.POST)
    @ResponseBody
    public AjaxResult cleanRandomResult(String taskNO) throws Exception {
		if(StringUtils.isNotBlank(taskNO)){
			pubSctaskAgentService.cleanPubSctaskAgentByTaskNO(taskNO);
			return AjaxResult.success("清除成功");
		}
		return AjaxResult.error("清除失败");
    }
	
	/**
	 * 描述：随机抽取执法人员
	 * @author chenxin
	 * @date 2016-11-07
	 * @param deptTaskNO实施部门编号
	 * @param taskNO任务标号
	 * @param number抽取数量
	 * @param scTypeWay抽取方式
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/random",method= RequestMethod.POST)
	@ResponseBody
	public AjaxResult doRandomAgent(String deptTaskNO,String taskNO,int number,String scTypeWay,int groupAgentNumber) throws Exception {
		if(StringUtils.isNotEmpty(deptTaskNO) && StringUtils.isNotEmpty(taskNO)){
			int total = pubSctaskAgentBackService.selectCountByTaskNO(deptTaskNO);
			if(number > total){
				return AjaxResult.error("抽取数量不得大于待抽取数量");
			}
			pubSctaskAgentService.randomPubSctaskAgentByTaskNO(deptTaskNO,taskNO,total,number,scTypeWay,groupAgentNumber);
			return AjaxResult.success("抽取成功");
		}
		return AjaxResult.error("抽取失败");
	}
}