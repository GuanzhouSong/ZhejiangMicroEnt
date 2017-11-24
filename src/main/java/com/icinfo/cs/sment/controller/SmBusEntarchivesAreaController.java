/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.sment.model.SmBusEntarchivesArea;
import com.icinfo.cs.sment.service.ISmBusEntarchivesAreaService;
import com.icinfo.cs.sment.util.UUIDUtils;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;

/**
 * 描述:   小微企业-区域code sm_bus_entarchives_area 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年05月04日
 */
@Controller
@RequestMapping("/sment/areatype")
public class SmBusEntarchivesAreaController extends BaseController {
	
	@Autowired
	ISmBusEntarchivesAreaService smBusEntarchivesAreaService;
	
	/**
	 * 进入区域类型维护
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/areaTypeManage")
	public String areaTypeManage() throws Exception{
		return "sment/system/sment_area_manage_list";
	}
	/**
	 * 获取区域类型数据
	 * @author zjj
	 */
    @RequestMapping({"/list.json", "list.xml"})
    @ResponseBody
    public List<SmBusEntarchivesArea> listJSON() throws Exception {
    	return smBusEntarchivesAreaService.selectAreaList();
    }
    /**
     * 进入增加修改页面
     * @author zjj
     */
    @RequestMapping("/enEdit")
    public ModelAndView enEdit(String id,String sid,String pid,String pName) throws Exception{
    	ModelAndView mv =new ModelAndView("sment/system/sment_area_manage_edit");
    	if(StringUtils.isNotBlank(id)){
    		
    		Map<String, Object> qryMap = new HashMap<String,Object>();
        	qryMap.put("areaCode", sid);
        	List<SmBusEntarchivesArea> list = smBusEntarchivesAreaService.selectListByMap(qryMap);
        	if(list.size()==0) return mv;	
        	mv.addObject("pName",pName);
        	mv.addObject("smBusEntarchivesArea",list.get(0));
    	}else{
    		mv.addObject("pid",pid);
    		mv.addObject("sid",sid);
    	}
    	return mv;
    }
    /**
	 * 增加修改区域类型
	 * @author zjj
	 */
    @RequestMapping("/edit")
    @ResponseBody
    public AjaxResult edit(HttpSession session,SmBusEntarchivesArea smBusEntarchivesArea) throws Exception {
    	if(StringUtils.isBlank(smBusEntarchivesArea.getAreaName().trim()))
    		return AjaxResult.error("区域类型名称不能为空");
    	
    	Map<String, Object> qryMap = new HashMap<String,Object>();
    	qryMap.put("areaName", smBusEntarchivesArea.getAreaName().trim());
    	qryMap.put("areaPcode", smBusEntarchivesArea.getAreaPcode ().trim());
    	List<SmBusEntarchivesArea> list = smBusEntarchivesAreaService.selectListByMap(qryMap);
    	if(list.size()>0) return AjaxResult.error("区域类型名称不能重复");
    	if(StringUtils.isNotBlank(smBusEntarchivesArea.getAreaCode())){
    		smBusEntarchivesAreaService.update(smBusEntarchivesArea);
    		
    	}else{
    	    SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
         // 警示协同的地址 默认警示
         String sysSetDeptCode = sysUser.getDepartMent ().getDeptCode ().substring (0, 6);
         smBusEntarchivesArea.setDeptCode (sysSetDeptCode);
    		//插入二级节点
    		smBusEntarchivesArea.setAreaCode(smBusEntarchivesArea.getAreaPcode()+"_"+UUIDUtils.randomUUID());
    		smBusEntarchivesAreaService.insert(smBusEntarchivesArea);
    	}
    	return AjaxResult.success("操作成功",smBusEntarchivesArea);
    }
    
    /**
     * 查询某一数据
     */
    @RequestMapping("/query")
    @ResponseBody
    public AjaxResult query(String areaCode) throws Exception {
    	if(StringUtils.isNotBlank(areaCode)){
        	Map<String, Object> qryMap = new HashMap<String,Object>();
        	qryMap.put("areaCode", areaCode);
            List<SmBusEntarchivesArea> list = smBusEntarchivesAreaService.selectListByMap(qryMap);
            if(list.size() == 0) return AjaxResult.error("参数错误");
            return AjaxResult.success(null, list.get(0));
    	}
    	return AjaxResult.error("参数错误");
    }
    /**
     * 删除某一节点
     * @author zjj
     */
    @RequestMapping("/delete")
    @ResponseBody
    public AjaxResult delete(String id) throws Exception {
    	if(StringUtils.isNotBlank(id)){
            if(smBusEntarchivesAreaService.delete(id)>0)
            return AjaxResult.success("删除成功");
    	}
    	return AjaxResult.error("操作失败");
    }
    
    
    
    /** 
     * 描述: 根据父类code获取子类列表
     * @author 张文男
     * @date 2017年5月8日 
     * @param areaPcode
     * @return 
     */
    
    @RequestMapping("/queryListByAreaPcode.json")
    @ResponseBody
    public AjaxResult queryListByAreaPcode(HttpSession session,String areaPcode) {
            List<SmBusEntarchivesArea> list = null;
            try {
                SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
                // 警示协同的地址 默认警示
                String sysSetDeptCode = sysUser.getDepartMent ().getDeptCode ().substring (0, 6);
                if (sysSetDeptCode.equals ("330000")) {// 省局
                    sysSetDeptCode = "33";
                } else if (sysSetDeptCode.substring (4, 6).equals ("00")) {// 市局
                    sysSetDeptCode = sysSetDeptCode.substring (0,4);
                } 
                list = smBusEntarchivesAreaService.queryListByAreaPcode (areaPcode,sysSetDeptCode);
                return AjaxResult.success ("操作成功",list);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return AjaxResult.error ("操作失败");
    }

}