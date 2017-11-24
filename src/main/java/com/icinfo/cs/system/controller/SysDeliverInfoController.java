/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysDeliverInfo;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.system.service.ISysDeliverInfoService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.tools.utils.StringUtils;

/**
 * 描述:    cs_sys_deliverinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年08月30日
 */
@Controller
@RequestMapping("/reg/server/yr/sysdeliverinfo")
public class SysDeliverInfoController extends BaseController {
	
	@Autowired
	private ISysDeliverInfoService sysDeliverInfoService;
	
	/**
	 * 
	 * 描述: 进入送达地址维护页
	 * @auther gaojinling
	 * @date 2016年9月20日 
	 * @return
	 * @throws Exception
	 */
    @RequestMapping("/ent")
	public String entDeliverInfo() throws Exception{
		return "/reg/server/yr/sysdeliverinfo/sysdeliverinfo_list";
	}
    
    
    /**
     * 
     * 描述: 条件分页查询送达地址列表
     * @auther gaojinling
     * @date 2016年9月20日 
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping({"/list.json", "list.xml"})
    @ResponseBody
	public PageResponse<SysDeliverInfo> queryPageDeliverInfo(PageRequest request) throws Exception{
    	 return (new PageResponse<SysDeliverInfo>(sysDeliverInfoService.queryPage(request)));
    }
    
 /**
  * 
  * 描述: 进入修改/保存页面
  * @auther gaojinling
  * @date 2016年9月20日 
  * @param UID
  * @return
  * @throws Exception
  */
    @RequestMapping("/view")
    public ModelAndView viewDeliverInfo(String uid,String deptId ,String deliName ,String deliCode,String deliType,HttpSession session) throws Exception {
        ModelAndView view = new ModelAndView("/reg/server/yr/sysdeliverinfo/sysdeliverinfo_edit");
        if (StringUtils.isNotEmpty(uid)) {
            SysDeliverInfo sysDeliverInfo = sysDeliverInfoService.selectDeliverInfoByPrimaryKey(uid);
        	if (sysDeliverInfo != null) {
                view.addObject("sysDeliverInfo", sysDeliverInfo);
            }
        }
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
        view.addObject("sysUser", sysUser);
		view.addObject("deptId",deptId);
        view.addObject("deliName",deliName);
        view.addObject("deliCode",deliCode);
        view.addObject("deliType",deliType);
        return view;
    }
    
    /***
     * 
     * 描述: 保存（修改）
     * @auther gaojinling
     * @date 2016年9月20日 
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult editDeliverInfo(@Valid SysDeliverInfo sysDeliverInfo) throws Exception {
    	if(sysDeliverInfo != null){
    		if(StringUtil.isNotEmpty(sysDeliverInfo.getUid())){
    			if(sysDeliverInfoService.update(sysDeliverInfo)>0){
    				return AjaxResult.success("0");
    			}else{
    				return AjaxResult.error("更新失败");
    			}
    		}else{
    			if(sysDeliverInfoService.inset(sysDeliverInfo)>0){
    				return AjaxResult.success("1");
    			}else{
    				return AjaxResult.error("更新失败");
    			}
    		}
    	}
    	return AjaxResult.error("操作失败");
    }
    
    /**
     * 
     * 描述: 修改
     * @auther gaojinling
     * @date 2016年9月29日 
     * @param uid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public AjaxResult delete(String uid) throws Exception {
        if (StringUtils.isEmpty(uid)) {
            return AjaxResult.error("未选择删除用户!");
        }
        if (sysDeliverInfoService.deletebyPrimaryKey(uid) > 0) {
            return AjaxResult.success("删除用户成功.");
        }
        return AjaxResult.error("删除用户失败!");
    }
    
    
    
    
    
    
    
}