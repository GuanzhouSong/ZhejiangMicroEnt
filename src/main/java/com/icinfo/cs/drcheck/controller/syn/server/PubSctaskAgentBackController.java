/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.controller.syn.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.drcheck.dto.PubSctaskAgentBackDto;
import com.icinfo.cs.drcheck.service.IPubSctaskAgentBackService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:  cs_pub_sctask_agent_back 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
@Controller
@RequestMapping("/syn/pub/server/drcheck/pubsctaskagentback")
public class PubSctaskAgentBackController extends BaseController {

    @Autowired
    private IPubSctaskAgentBackService pubSctaskAgentBackService;
    
    /**
   	 * 描述：添加到备份
   	 * 
   	 * @author chenxin
   	 * @date 2016-10-27
   	 * @return
   	 * @throws Exception
   	 */
   	@RequestMapping(value = "/add", method = RequestMethod.POST)
   	@ResponseBody
   	public AjaxResult doAdd(@RequestBody PubSctaskAgentBackDto pubSctaskAgentBackDto) throws Exception {
   		if(pubSctaskAgentBackService.addSctaskAgentBackList(pubSctaskAgentBackDto.getDeptTaskUid(),pubSctaskAgentBackDto.getUidList())){
   			return AjaxResult.success("导入待选库成功");
   		}
   		return AjaxResult.error("导入待选库失败");
   	}   
   	
   	/**
   	 * 描述：添加到备份
   	 * 
   	 * @author chenxin
   	 * @date 2016-10-27
   	 * @return
   	 * @throws Exception
   	 */
   	@RequestMapping(value = "/delete", method = RequestMethod.POST)
   	@ResponseBody
   	public AjaxResult doDelete(int id) throws Exception {
   		if(pubSctaskAgentBackService.delSctaskAgentBackById(id)){
   			return AjaxResult.success("删除成功");
   		}
   		return AjaxResult.error("删除失败");
   	}   
    
    /**
     * 描述：获取查抽检查待抽检列表
     * @author chenxin
     * @date 2016-10-26
     * @return
     * @throws Exception
     */
	@RequestMapping(value="/list.json",method= RequestMethod.GET)
    @ResponseBody
    public PageResponse<PubSctaskAgentBackDto> listJSON(PageRequest request) throws Exception {
		List<PubSctaskAgentBackDto>	data = pubSctaskAgentBackService.queryPubSctaskAgentBackDtoPage(request);
        return new PageResponse<PubSctaskAgentBackDto>(data);
    }
}