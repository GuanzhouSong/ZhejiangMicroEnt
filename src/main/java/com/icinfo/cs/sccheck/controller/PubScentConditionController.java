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

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.sccheck.dto.PubScentConditionDto;
import com.icinfo.cs.sccheck.service.IPubScentConditionService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_pub_scent_condition 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年05月17日
 */
@Controller
@RequestMapping({"/reg/pub/server/sccheck/entcondition","/syn/pub/server/sccheck/entcondition"})
public class PubScentConditionController extends CSBaseController {
	@Autowired
	private IPubScentConditionService pubScentConditionService;
	
	/**
     * 描述：确认本次检查对象抽取库
     * @author chenxin
     * @date 2017-05-17
     * @param taskUid
     * @param taskCondition
     * @return
     * @throws Exception
     */
	@RequestMapping(value="/confirm",method= RequestMethod.POST)
    @ResponseBody
    public AjaxResult doConfirmEntBack(HttpSession session,String taskUid) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if(pubScentConditionService.doConfirmEntBack(taskUid,sysUser)){
			return AjaxResult.success("保存成功");
		}
		return AjaxResult.error("保存失败");
    }
	

	/**
     * 描述：确认本次检查对象抽取库
     * @author chenxin
     * @date 2017-05-17
     * @param taskUid
     * @param taskCondition
     * @return
     * @throws Exception
     */
	@RequestMapping(value="/specialrandom",method= RequestMethod.POST)
    @ResponseBody
    public AjaxResult doConfirmBySpecial(HttpSession session,String taskUid) throws Exception {
		Map<String,Object> params = new HashMap<String,Object>();
		creatDefaultDBAuthEnv(params,"b.RegOrg","b.LocalAdm");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if(pubScentConditionService.doConfirmBySpecial(taskUid,sysUser,params)){
			return AjaxResult.success("保存成功");
		}
		return AjaxResult.error("保存失败");
    }
	
	/**
	 * 描述：提交随机抽检条件
	 * 
	 * @author chenxin
	 * @date 2017-05-20
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/commit", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doCommit(@RequestBody PubScentConditionDto pubScentConditionDto,HttpSession session) throws Exception {
		if(pubScentConditionService.doCommitCondition(pubScentConditionDto)){
			return AjaxResult.success("保存成功");
		}
		return AjaxResult.error("保存失败");
	}
	
	/**
     * 描述：获取抽检库统计信息
     * @author chenxin
     * @date 2016-10-26
     * @return
     * @throws Exception
     */
	@RequestMapping(value="/list.json",method= RequestMethod.GET)
    @ResponseBody
    public PageResponse<PubScentConditionDto> listJSON(PageRequest request,HttpSession session) throws Exception {
		List<PubScentConditionDto> data = pubScentConditionService.queryPubScentConditionDtoPage(request);
        return new PageResponse<PubScentConditionDto>(data);
    }
}