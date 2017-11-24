/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.system.dto.PermisionTreeNode;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.yr.model.DepartMent;
import com.icinfo.cs.yr.service.IDepartMentService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.tools.utils.StringUtils;

/**
 * 描述:    cs_department 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月20日
 */
@Controller
@RequestMapping("/reg/server/yr/department")
public class DepartMentController extends BaseController {
	
	@Autowired
	private IDepartMentService departMentService;
	
	/**
	 * 
	 * 描述: 进入部门管理
	 * @auther yujingwei
	 * @date 2016年9月21日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public  ModelAndView list() throws Exception{
		ModelAndView view=new ModelAndView("/reg/server/yr/sysmanage/deptmanage/list");
		return view;
		}
	
	/**
	 * 描述: 查询根据登录人员过滤后的部门列表
	 * @auther gaojinling
	 * @date 2016年9月21日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"list.json","list.xml"})
	@ResponseBody
	public AjaxResult listJSON(HttpSession session)throws Exception{
	 Map<String, Object> map  = new HashMap<String, Object>();
	 map.put("regUnit_permission_limit", getLimitReg());//权限限制字段
	 List<DepartMent> resultData = departMentService.selectDepartmentPermissionList(map);
	 List<PermisionTreeNode> list = new ArrayList<PermisionTreeNode>();
	 for (DepartMent departMent : resultData) {
         PermisionTreeNode treeNode = new PermisionTreeNode();
         treeNode.setId(departMent.getDeptDID());
         treeNode.setpId(departMent.getDeptPID());
         treeNode.setName(departMent.getDeptName());
         treeNode.setCode(departMent.getDeptCode());
         treeNode.setDeptId(departMent.getId().toString());
         list.add(treeNode);
     }
	 return AjaxResult.success("查询成功",list);
	}
	
	/**
	 * 根据部门id查询部门信息
	 * @author yujingwei
	 * @date 2015-9-21
	 * @param deptId
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping({"selectDetail.json","list.xml"})
	@ResponseBody
	public AjaxResult selectDetail(String deptId) throws Exception{
		  if(!deptId.isEmpty()){
			  DepartMent departMent=departMentService.selectOne(deptId);
		      return AjaxResult.success("查询成功",departMent);
		  }else{
			  return AjaxResult.error("查询失败");
		  }
	}
	
	/**
	 * 描述: 显示
	 * @auther gaojinling
	 * @date 2016年9月21日 
	 * @param deptid
	 * @param sid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/show")
	public ModelAndView show(String deptid,String sid)throws Exception{
		ModelAndView view=new ModelAndView("/reg/server/yr/sysmanage/deptmanage/edit");
		DepartMent department=null;
		//修改view
		if(StringUtils.isNotEmpty(deptid)){
			department = departMentService.selectOne(deptid);
		   if(department!=null){
			   view.addObject("department",department);
			   if(StringUtils.isNotEmpty(department.getDeptPID())){
				   DepartMent parent = departMentService.selectOne(department.getDeptPID());
				   if(parent != null){
					   view.addObject("parentName",parent.getDeptName()); 
				   }
			   }
		   }
		}
		//添加view
		if(StringUtils.isNotEmpty(sid)){
			DepartMent _temp=departMentService.selectOne(sid);
		    if(_temp != null){
				  view.addObject("parentIdForSub", _temp.getDeptDID());
                  view.addObject("parentIdForSibling", _temp.getDeptPID());
			} 
		}
		return view; 
	}
	
	/**
	 * 描述: 添加或修改部门信息
	 * @auther yujingwei
	 * @date 2016年9月21日 
	 * @param department
	 * @param parentId
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(DepartMent department,String parentId,HttpSession session)throws Exception{
		SysUser sysUser = (SysUser) session.getAttribute(Constants.SESSION_SYS_USER);
		department.setSetter(sysUser.getRealName());
		department.setSetDate(new Date());
		department.setCreateTime(new Date());
		if(StringUtils.isNotEmpty(department.getDeptDID())){
			if(departMentService.update(department) > 0){
				return AjaxResult.success("更新部门成功");
			}else{
				return AjaxResult.error("更新部门失败");
			}
		}else{
			if(departMentService.selectDepartMentByDeptCode(department.getDeptCode()) != null){
				return AjaxResult.error("该部门编码已经存在，请重新输入！");
			}
			List<DepartMent> list = departMentService.selectByParentId(parentId);
			//通过父节点得到子节点
			String deptid = departMentService.doGetDepdid(list,parentId);
			department.setDeptDID(deptid);
			department.setDeptPID(parentId);
			if(departMentService.save(department) > 0){
				return AjaxResult.success("新增部门成功");
			}else{
				return AjaxResult.error("新增部门失败");
			} 
		} 
	}
	
	/**
	 * 描述：删除部门信息
	 * @author yujingwei
	 * @param deptId
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(String deptId)throws Exception{
		if(StringUtils.isEmpty(deptId)){
		   return AjaxResult.error("删除的部门不存在");
		}
		if(departMentService.deleteByDeptId(deptId) >0){
			return AjaxResult.success("删除部门成功");
		}
		return AjaxResult.error("删除部门失败"); 
		
	}
	
	/**
	 * 获取权限限制
	 * @return
	 */
	public String getLimitReg() {
		SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
		String level = sysUser.getUserVest(sysUser);
		String isAdmin = sysUser.getIsAdmin(); 
//        1：本所 2：本局3：本市 4：本省   0 管理员
		if((StringUtils.isNotBlank(isAdmin) &&"1".equals(isAdmin)) || (StringUtils.equalsIgnoreCase(level, "4")||StringUtils.isBlank(level))){ //管理员权限放开
			return "";
		}
		if (StringUtils.equalsIgnoreCase(level, "1")||StringUtils.isBlank(level)) { //所级
			return StringUtils.substring(sysUser.getDepartMent().getDeptCode(), 0, 8);
		}
		if (StringUtils.equalsIgnoreCase(level, "2")) {
			return StringUtils.substring(sysUser.getDepartMent().getDeptCode(), 0, 6); //局级
		}
		if (StringUtils.equalsIgnoreCase(level, "3")) {
			return StringUtils.substring(sysUser.getDepartMent().getDeptCode(), 0, 4); //市局级
		} 
		return "";
	}
	
	
}