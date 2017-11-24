/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.dtinfo.dto.LicDeptDto;
import com.icinfo.cs.system.dto.SysUserAreaManageDto;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.system.model.SysUserAreaManage;
import com.icinfo.cs.system.service.ISysUserAreaManageService;
import com.icinfo.cs.system.service.ISysUserService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:   111111 SYS_USER_AREA_ADMIN 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年05月04日
 */
@Controller
@RequestMapping({ "/syn/sysuserareamanage", "/reg/server/sysuserareamanage" })
public class SysUserAreaManageController extends CSBaseController {
	@Autowired
	private ISysUserAreaManageService sysUserAreaManageService;
	@Autowired
	private ISysUserService sysUserService;
	/**
	 * 
	 * 描述   进入区域管理员页面
	 * @author 赵祥江
	 * @date 2017年5月4日 下午2:40:22 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/sysUserAreaManageListPage")
	public ModelAndView sysUserAreaManageListPage(HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		//警示协同的地址 默认警示
		String sysUrl="/reg/server";
		//协同
		if("2".equals(sysUser.getUserType())){
			sysUrl="/syn";
		}
		ModelAndView view =new ModelAndView("/syn/system/userareamanage/userareamanage_list");
		view.addObject("sysUrl", sysUrl);
		return view;
	}
	
	/**
	 * 
	 * 描述   查看详情
	 * @author 赵祥江
	 * @date 2017年5月5日 下午2:55:03 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/viewDetail")
	public ModelAndView viewDetail(String uid,HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		//警示协同的地址 默认警示
		String sysUrl="/reg/server";
		//协同
		if("2".equals(sysUser.getUserType())){
			sysUrl="/syn";
		}
		SysUserAreaManage sysUserAreaManage=sysUserAreaManageService.selectSysUserAreaManageByUid(uid);
		SysUserDto sysUserDto =sysUserService.selectSynUserByUId(sysUserAreaManage==null?"000000":sysUserAreaManage.getUserIdentity());
		ModelAndView view =new ModelAndView("/syn/system/userareamanage/userareamanage_detail");
		view.addObject("sysUrl", sysUrl);
		view.addObject("sysUserAreaManage", sysUserAreaManage);
		view.addObject("sysUser", sysUserDto);
		return view;
	}
	
	
	/**
	 * 
	 * 描述   分页查询
	 * @author 赵祥江
	 * @date 2017年5月4日 下午4:21:11 
	 * @param 
	 * @return PageResponse<SysUserAreaManageDto>
	 * @throws
	 */
	@RequestMapping({"/selectSysUserAreaManageListPageJSON.json","list.xml"})
	@ResponseBody
	public PageResponse<SysUserAreaManageDto> selectSysUserAreaManageListPageJSON(PageRequest request)throws Exception{
		 Map<String,Object> queryMap= request.getParams();
		 //去掉查询参数的左右空格
		 StringUtil.paramTrim(queryMap); 
		 if(queryMap!=null&&queryMap.containsKey("checkDep")&&StringUtil.isNotBlank(queryMap.get("checkDep").toString())){ 
			 queryMap.put("checkDep", com.icinfo.cs.common.utils.StringUtil.doSplitStringToSqlFormat(queryMap.get("checkDep").toString(),","));
		 }
		 List<SysUserAreaManageDto> sysUserAreaManageDtoList= sysUserAreaManageService.queryPage(request);
	 	 return new PageResponse<SysUserAreaManageDto>(sysUserAreaManageDtoList);
	}
	
	
	/**
	 * 
	 * 描述   禁用、启用区域管理员
	 * @author 赵祥江
	 * @date 2017年5月4日 下午6:47:55 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping("/updateUserAreaManageStatus")
	@ResponseBody
	public AjaxResult updateUserAreaManageStatus(String uid,String status,HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if (StringUtil.isNotEmpty(uid)&&StringUtil.isNotEmpty(status)) {
			SysUserAreaManage sysUserAreaManage=new SysUserAreaManage();
			sysUserAreaManage.setUid(uid);
			sysUserAreaManage.setUserStatus(status);
			sysUserAreaManage.setSetName(sysUser.getRealName());
			sysUserAreaManage.setSetDate(DateUtil.getSysCurrentDate());
			if(sysUserAreaManageService.updateSysUserAreaManageByUid(sysUserAreaManage)>0){
				return AjaxResult.success("操作成功");
			}  
		}
		return  AjaxResult.error("操作失败");
	}
	
	/**
	 * 
	 * 描述   进入添加区域管理员页面
	 * @author 赵祥江
	 * @date 2017年5月4日 下午7:17:44 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping({"/userAreaManagEdit"})
	public ModelAndView userAreaManagEdit(HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		ModelAndView view  = new ModelAndView("/syn/system/userareamanage/userareamanage_edit");
		//警示协同的地址 默认警示
		String sysUrl="/reg/server";
		//协同
		if("2".equals(sysUser.getUserType())){
			sysUrl="/syn";
		}
		view.addObject("sysUrl", sysUrl);
		return view;
	}
	
	/**
	 * 
	 * 描述   根据部门编码获取用户
	 * @author 赵祥江
	 * @date 2017年5月4日 下午8:48:04 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
 	@RequestMapping("/getsliceManByDept")
    @ResponseBody
    public AjaxResult getsliceManByDept(String deptCode) throws Exception {
        List<SysUser> data = sysUserService.getsliceManByDept(deptCode);
        return AjaxResult.success("查询成功", data);
    }
 	
 	/**
 	 * 
 	 * 描述   保存
 	 * @author 赵祥江
 	 * @date 2017年5月4日 下午8:54:41 
 	 * @param 
 	 * @return AjaxResult
 	 * @throws
 	 */
 	@RequestMapping("/saveSysUserAreaManage")
    @ResponseBody
    public AjaxResult saveSysUserAreaManage(String allCheckedVal,String uid,HttpSession session) throws Exception {
        try {
        	StringBuffer bf=new StringBuffer();
     		String[] allCheckedValArr=allCheckedVal.split(",");
            SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
            if(allCheckedValArr.length>0){
            	for(int i=0;i<allCheckedValArr.length;i++){
            		SysUserAreaManage sysUserAreaManage=new SysUserAreaManage();
            		sysUserAreaManage.setCreateTime(DateUtil.getSysDate());
            		sysUserAreaManage.setSetDate(sysUserAreaManage.getCreateTime());
            		sysUserAreaManage.setSetName(sysUser.getRealName());
            		sysUserAreaManage.setUserIdentity(allCheckedValArr[i]);
            		sysUserAreaManage.setUserStatus("1");
            		SysUserAreaManage sysUserAreaManageTem =sysUserAreaManageService.selectSysUserAreaManageByUserIdentity(allCheckedValArr[i],null);
            	    if(sysUserAreaManageTem!=null){
            	    	SysUserDto sysUserDto =sysUserService.selectSynUserByUId(allCheckedValArr[i]);
            	    	if(sysUserDto!=null){
            	    		bf.append(sysUserDto.getRealName()+"、");
            	    	}
            	    }else{
            	    	sysUserAreaManageService.insertSysUserAreaManage(sysUserAreaManage);
            	    }
            	}
            }
            if(bf.length()>0){
            	bf.substring(0, bf.length()-1);
            	bf.append("等已经是区域管理员，不能重复添加");
            }
            return AjaxResult.success("操作成功", bf);
		} catch (Exception e) {
			e.printStackTrace();
		} 
        return AjaxResult.error("操作失败");
    }
 	
 	
 	/**
 	 * 
 	 * 描述   根据uid 删除
 	 * @author 赵祥江
 	 * @date 2017年5月5日 下午2:45:38 
 	 * @param 
 	 * @return AjaxResult
 	 * @throws
 	 */
 	@RequestMapping("/delete")
    @ResponseBody
    public AjaxResult delete(String uid) throws Exception {
        try {
            if(StringUtil.isNotBlank(uid)){
            	if(sysUserAreaManageService.deleteSysUserAreaManageByUid(uid)>0){
            		return AjaxResult.success("操作成功!");
            	}else{
            		return AjaxResult.error("操作失败");
            	}
            }
		} catch (Exception e) {
			e.printStackTrace();
		} 
        return AjaxResult.error("操作失败");
    }
}