/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.system.model.SysVersion;
import com.icinfo.cs.system.service.ISysVersionService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.security.shiro.UserProfile;

/**
 * 描述:    cs_sys_version 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月23日
 */
@Controller
@RequestMapping("/reg/server/sysversion")
public class SysVersionController extends BaseController {
	@Autowired
	private ISysVersionService sysVersionService;
	
	/**
	 * 
	 * 描述: 进入版本列表页面
	 * @auther chenxin
	 * @date 2016-09-11
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/list",method= RequestMethod.GET)
	public ModelAndView list() throws Exception{
		ModelAndView view = new ModelAndView("/system/sysversion/sysversion_list");
		return view;
	}
	
	/**
     * 描述：获取列表Json数据
     * @author chenxin
     * @date 2016-09-11
     * @return
     * @throws Exception
     */
	@RequestMapping(value="/list.json",method= RequestMethod.GET)
    @ResponseBody
    public PageResponse<SysVersion> listJSON(PageRequest request) throws Exception {
		List<SysVersion> data = sysVersionService.queryPage(request);
        return new PageResponse<SysVersion>(data);
    }
	
	/**
	 * 描述：进入版本审核详细页面
	 * @author chenxin
	 * @date 2016-09-11
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/show",method = RequestMethod.GET)
	public ModelAndView editSysVersionPage(@RequestParam(required = false) Integer sysVersionId) throws Exception {
        ModelAndView view = new ModelAndView("/system/sysversion/sysversion_edit");
        if(sysVersionId != null && sysVersionId > 0){
        	SysVersion sysVersion =  sysVersionService.selectSysVersionById(sysVersionId);
        	view.addObject(sysVersion);
        }
		return view;
	}
	
	/**
	 * 描述：版本信息保存
	 * 
	 * @author chenxin
	 * @date 2016-09-24
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doSaveSysVersion( SysVersion sysVersion,HttpSession session) throws Exception {
		if(StringUtils.isEmpty(sysVersion.getTitle())){
			return AjaxResult.error("请输入标题");
		}
		if(StringUtils.isEmpty(sysVersion.getContents())){
			return AjaxResult.error("请输入更新内容");
		}
		UserProfile userProfile = (UserProfile) session.getAttribute(Constants.SESSION_SYS_USER_KEY);
		sysVersion.setCreateTime(new Date());;
		sysVersion.setSetName(userProfile.getUsername());
		if (sysVersion.getId() != null && sysVersion.getId() > 0) {
			if (sysVersionService.update(sysVersion) > 0) {
				return AjaxResult.success("更新版本信息成功");
			}
			return AjaxResult.error("更新版本信息失败!");
		}
		if (sysVersionService.insert(sysVersion) > 0) {
			return AjaxResult.success("添加版本信息成功.");
		}
        return AjaxResult.error("添加版本信息失败!");
	}
	
	/**
	 * 描述：根据id删除版本信息
	 * @author chenxin
	 * @date 2016年9月24日
	 * @param sysVersionId
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value = "delete")
    @ResponseBody
    public AjaxResult delete(@RequestParam Integer sysVersionId) throws Exception {
        if (sysVersionId == null || sysVersionId <= 0) {
            return AjaxResult.error("未选择删除版本信息!");
        }
        if (sysVersionService.deleteById(sysVersionId) > 0) {
            return AjaxResult.success("删除版本信息成功.");
        }
        return AjaxResult.error("删除版本信息失败!");
    }
}