/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.service.ICodeEntcatgService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysRole;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.system.model.SysUserRole;
import com.icinfo.cs.system.service.ISysRoleService;
import com.icinfo.cs.system.service.ISysUserRoleService;
import com.icinfo.cs.system.service.ISysUserService;
import com.icinfo.cs.yr.model.DepartMent;
import com.icinfo.cs.yr.service.IDepartMentService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.tools.utils.StringUtils;

/**
 * 描述:  系统用户管理控制器.<br>
 *
 * @author xiajunwei
 * @date 2016年04月20日
 */
@Controller
@RequestMapping("/reg/server/sysuser")
public class SysUserController extends CSBaseController {
    private final static Logger logger = LoggerFactory.getLogger(SysUserController.class);
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ISysUserRoleService sysUserRoleService;
    @Autowired
    private ISysRoleService sysRoleService;
    @Autowired
    private ICodeEntcatgService codeEntcatgService;
    @Autowired
    private IDepartMentService departMentService;

    @RequestMapping("/synerror")
    public ModelAndView doSynError() throws Exception{
        ModelAndView view  = new ModelAndView("/syn/exception/error");
        return view;
    }

    /**
     * 进入系统用户列表页面
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/list")
    public ModelAndView list() throws Exception {
        ModelAndView mav = new ModelAndView( "sysuser/list");
        SysUser sysUser=(SysUser)getSession().getAttribute(Constants.SESSION_SYS_USER);
        mav.addObject("userType", sysUser.getUserType());
        return mav;
    }

    /**
     * 跳转到岗位成员管理页面
     * @author ZhuDefeng
     * @date 2017-01-18
     * @return
     * @throws Exception
     */
    @RequestMapping("/user_role_edit")
    public ModelAndView list_user_role_edit() throws Exception {
        ModelAndView mav = new ModelAndView( "sysuser/user_role_edit");
        SysUserDto setUser=(SysUserDto)getSession().getAttribute(Constants.SESSION_SYS_USER);
        List<SysRole> data = sysRoleService.selectBySysUser(setUser);
        mav.addObject("allRoles", data);
        //层级
        mav.addObject("uservest", setUser.getUserVest(setUser));
        return mav;
    }

    /**
     * 批量为人员设置(添加/删减)岗位
     * @author ZhuDefeng
     * @date 2017-01-18
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/bathSetRole")
    @ResponseBody
    public AjaxResult bathSetRole( String userIds,  String roleIds, String type)throws Exception{
        if (StringUtil.isBlank(userIds)) {
            AjaxResult error = AjaxResult.error("请勾选用户后再操作！");
            return error;
        }
        SysUserDto setUser=(SysUserDto)getSession().getAttribute(Constants.SESSION_SYS_USER);
        sysUserService.doBatchSetUsersRoles(userIds,roleIds,type,setUser);
        return AjaxResult.success("操作成功!");
    }

    /**
     * 跳转到批量为人员设置岗位页面
     * @author ZhuDefeng
     * @date 2017-01-18
     * @return
     * @throws Exception
     */
    @RequestMapping("/toBathSetRole")
    public ModelAndView toBathSetRole(String userIds,String type,String userNames )throws Exception{
        ModelAndView mav = new ModelAndView( "sysuser/role_select");
        SysUser setUser=(SysUser)getSession().getAttribute(Constants.SESSION_SYS_USER);
        List<SysRole> data = sysRoleService.selectBySysUser(setUser);
        mav.addObject("allRoles", data);
        mav.addObject("userIds", userIds);
        mav.addObject("type", type);
        mav.addObject("userNames", userNames);
        return mav;
    }
    /**
     * 系统数据JSON数据列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping({"/list.json", "list.xml"})
    @ResponseBody
    public PageResponse<SysUserDto> listJSON(PageRequest request) throws Exception {
        SysUserDto sysUser=(SysUserDto)getSession().getAttribute(Constants.SESSION_SYS_USER);
        if(request.getParams()==null){
            request.setParams(new HashMap<String,Object>());
        }
        request.getParams().put("userType",sysUser.getUserType());
        if(!"1".equals(sysUser.getIsAdmin())&&!"2".equals(sysUser.getIsAdmin())){
            String deptCodeLike=replaceByUserLevel(sysUser.getDepartMent().getDeptCode(),sysUser.getSearchRangeLevel(),"%");
            request.getParams().put("deptCodeLike",deptCodeLike);
        }
        List<SysUserDto> data = sysUserService.queryPage(request);
        return new PageResponse<SysUserDto>(data);
    }
    
    /**
     * 系统数据JSON数据列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping({"/listdeptuser.json", "list.xml"})
    @ResponseBody
    public PageResponse<SysUserDto> listDeptUser(PageRequest request) throws Exception {
    	SysUser sysUser=(SysUser)getSession().getAttribute(Constants.SESSION_SYS_USER);
    	if(request.getParams()==null){
    		request.setParams(new HashMap<String,Object>());
    	}
    	request.getParams().put("userType",sysUser.getUserType());
		request.getParams().put("deptCode",sysUser.getDeptCode());

    	List<SysUserDto> data = sysUserService.queryPage(request);
    	return new PageResponse<SysUserDto>(data);
    }

    /**
     * 显示编辑对话框
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView show(String id) throws Exception {
        SysUserDto sysUser=null;
        ModelAndView view = new ModelAndView("sysuser/edit");

        //所有角色信息
        SysUser setUser=(SysUser)getSession().getAttribute(Constants.SESSION_SYS_USER);
        List<SysRole> data = sysRoleService.selectBySysUser(setUser);
        view.addObject("allRoles", data);
        view.addObject("userType", setUser.getUserType());
       // view.addObject("codeEntcatgs", codeEntcatgService.selectAll());//所有的企业类型（大类）
        if (StringUtils.isNotEmpty(id)) {
            //获取用户信息

            if("1".equals(setUser.getUserType())){
                sysUser = sysUserService.selectUserByUId(id);
            }
            if("2".equals(setUser.getUserType())){
                sysUser = sysUserService.selectSynUserByUId(id);
            }
            if (sysUser != null) {
                view.addObject("sysUser", sysUser);
                if(StringUtil.isNotBlank(sysUser.getDeptCode())){
//                    DepartMent departMent=departMentService.selectDepartMentByDeptCode(sysUser.getDeptCode());
                    DepartMent departMent=departMentService.selectOne(sysUser.getDeptCode());
                    view.addObject("dept", departMent);
                }
                //获取用户角色信息
                List<SysUserRole> rolesList = sysUserRoleService.selectByUserId(id);

                Map<String, SysUserRole> rolesMap = new HashMap<String, SysUserRole>();
                for (SysUserRole userRole : rolesList) {
                    rolesMap.put(userRole.getRoleId(), userRole);
                }
                if(StringUtils.isNotBlank(sysUser.getSearchRangeEntType())){
                    Map<String, String> searchRangeEntTypeMap = new HashMap<String, String>();
                    for(String entCatg:sysUser.getSearchRangeEntType().split(",")){
                        searchRangeEntTypeMap.put(entCatg,entCatg);
                    }
                    view.addObject("searchRangeEntTypes", searchRangeEntTypeMap);
                }
                view.addObject("userRoles", rolesMap);
            }
        }
        return view;
    }

    /**
     * 用户信息保存
     *
     * @param sysUser
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult save(@Valid @RequestBody SysUserDto sysUser, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            //参数验证错误
            AjaxResult error = AjaxResult.error("参数验证错误");
            error.addErrorInfo(result.getAllErrors());
            return error;
        }
        SysUser setPerson=(SysUser)getSession().getAttribute(Constants.SESSION_SYS_USER);
        sysUser.setUserSetPerson(setPerson.getId());
        sysUser.setUserType(setPerson.getUserType());
        if(StringUtil.isBlank(sysUser.getSearchRangeLevel())){
            sysUser.setSearchRangeLevel("1");
        }
        String[] roleArr=sysUser.getRoles().split(",");
        if (StringUtils.isNotEmpty(sysUser.getId())) {
            if (sysUserService.update(sysUser, roleArr) > 0) {
                return AjaxResult.success("更新用户信息成功");
            }
            return AjaxResult.error("更新用户信息失败!");
        }
        
        try {
        	if (sysUserService.insert(sysUser, roleArr) > 0) {
                return AjaxResult.success("创建新用户成功.");
            }
		} catch (Exception e) {
			e.printStackTrace();
			String msg=e.getMessage();
			if(StringUtil.isBlank(msg)){
				msg="创建新用户失败!";
			}
			return AjaxResult.error(msg);
		}
        return AjaxResult.error("创建新用户失败!");
    }

    /**
     * 禁用用户
     *
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/disable")
    @ResponseBody
    public AjaxResult disable(String id) throws Exception {
        if (StringUtils.isEmpty(id)) {
            return AjaxResult.error("未选择禁用用户!");
        }
        if (sysUserService.disOrEnAbleUser(id,"0") > 0) {
            return AjaxResult.success("禁用用户成功.");
        }
        return AjaxResult.error("禁用用户失败!");
    }

    /**
     * 启用用户
     *
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/enable")
    @ResponseBody
    public AjaxResult enable(String id) throws Exception {
        if (StringUtils.isEmpty(id)) {
            return AjaxResult.error("未选择启用用户!");
        }
        if (sysUserService.disOrEnAbleUser(id,"1") > 0) {
            return AjaxResult.success("启用用户成功.");
        }
        return AjaxResult.error("启用用户失败!");
    }


    /**
     * 描述：根据部门编码查询用户集合
     * @author ZhuDefeng
     * @date 2016-09-23
     * @param deptCode 部门编码
     * @return
     * @throws Exception
     */
    @RequestMapping({"/listByDeptCode.json", "list.xml"})
    @ResponseBody
    public List<SysUser> listJSONBydeptCode(String deptCode) throws Exception {
        List<SysUser> data = sysUserService.selectUserByDeptId(deptCode);
        return data;
    }

    /**
     * 描述：修改密码
     * @author ZhuDefeng
     * @date 2016-11-2
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/editPsw", method = RequestMethod.GET)
    public String editPsw()throws Exception{
        return "sysuser/sysuser_psw_edit";
    }

    /**
     * 描述：检查原密码
     * @author ZhuDefeng
     * @date 2016-11-2
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/doCheckSysUserPsw")
    @ResponseBody
    public AjaxResult doCheckSysUserPsw(@Param("password")String password)throws Exception{
        boolean isTrue=sysUserService.doCheckPsw(password,(SysUserDto)getSession().getAttribute(Constants.SESSION_SYS_USER));
        if(isTrue) return AjaxResult.success("true");
        return AjaxResult.error("false");
    }

    /**
     * 描述：修改密码
     * @author ZhuDefeng
     * @date 2016-11-2
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/doChangePsw")
    @ResponseBody
    public AjaxResult doChangePsw(@Param("password")String password)throws Exception{
        int modResult=sysUserService.doModLoginUserPwd(password,(SysUserDto)getSession().getAttribute(Constants.SESSION_SYS_USER));
        if(modResult>0){
            return AjaxResult.success("修改用户密码成功");
        }
        return AjaxResult.error("修改用户密码失败!");
    }
}
