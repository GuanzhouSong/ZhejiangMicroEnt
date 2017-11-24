/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.sccheck.dto.PubScentAgentBackDto;
import com.icinfo.cs.sccheck.service.IPubScentAgentBackService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_pub_scent_agent_back 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年05月20日
 */
@Controller
@RequestMapping({"/reg/server/sccheck/pubscentAgentBack","/syn/server/sccheck/pubscentAgentBack"})
public class PubScentAgentBackController extends BaseController {
	
	
	@Autowired
	private IPubScentAgentBackService pubScentAgentBackService;
	
	
	/**
	 * 
	 * 描述: 通过部门任务id分页查询待选检查人员
	 * @auther gaojinling
	 * @date 2017年5月20日 
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/list.json",method= RequestMethod.GET)
    @ResponseBody
    public PageResponse<PubScentAgentBackDto> listJSON(PageRequest request,HttpSession session) throws Exception {
		List<PubScentAgentBackDto> data = null;
		data = pubScentAgentBackService.selectPubScentAgentBackList(request);
        return new PageResponse<PubScentAgentBackDto>(data);
    }
	
	/**
	 * 
	 * 描述:当前部门id下的待检查人员列表渲染完成后 查询其总数，用户抽检人员时判断
	 * @auther gaojinling
	 * @date 2017年5月26日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/DataCountList", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult DataCountList(PageRequest request) throws Exception {
		Map<String, Object> params = request.getParams();
		if (params == null) {
			params = new HashMap<String, Object>();
		}
		// 限制对象数量
		int pubScentAgentCount = pubScentAgentBackService.selectPubScentAgentBackDtoCount(params);
		return AjaxResult.success("pubScentAgentCount", pubScentAgentCount);
	}
	
	
	
	/**
	 * 
	 * 描述: 抽检人员导入待选库
	 * @auther gaojinling
	 * @date 2017年5月21日 
	 * @param pubSctaskAgentBackDto
	 * @return
	 * @throws Exception
	 */
   	@RequestMapping(value = "/add", method = RequestMethod.POST)
   	@ResponseBody
   	public AjaxResult doAdd(@RequestBody PubScentAgentBackDto pubScentAgentBackDto) throws Exception {
   		if(pubScentAgentBackService.addScentAgentBackList(pubScentAgentBackDto.getDeptTaskUid(),pubScentAgentBackDto.getUidList())){
   			return AjaxResult.success("导入待选库成功");
   		}
   		return AjaxResult.error("导入待选库失败");
   	} 
   	
   	

   	/**
   	 * 
   	 * 描述: 批量删除待选库的检查人员
   	 * @auther gaojinling
   	 * @date 2017年5月21日 
   	 * @param deptTaskUid
   	 * @param AgentIds
   	 * @return
   	 * @throws Exception
   	 */
	@RequestMapping(value = "/deleteRtn", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult deleteRtn(String deptTaskUid,String agentIds) throws Exception {
		try {
			pubScentAgentBackService.deleteByDeptTaskUidAndAgentId(deptTaskUid, StringUtil.doSplitStringToSqlFormat(agentIds,","));
			return AjaxResult.success("批量删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error("批量删除失败");
		}
	}
   	
   	
	/**
	 * 
	 * 描述: 清空当前部门待选库的检查人员
	 * @auther gaojinling
	 * @date 2017年5月21日 
	 * @param deptTaskUid
	 * @param AgentIds
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteRtnAll", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult deleteRtnAll(String deptTaskUid) throws Exception {
		try {
			pubScentAgentBackService.deleteByDeptTaskUid(deptTaskUid);
			return AjaxResult.success("批量删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error("批量删除失败");
		}
	}
	
	
   	
   	
    
	
	
	
	
	
	
}