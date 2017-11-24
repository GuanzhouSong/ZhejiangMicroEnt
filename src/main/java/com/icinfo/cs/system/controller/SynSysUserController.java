/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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
import com.icinfo.cs.common.constant.DBAuthorConstants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysDepart;
import com.icinfo.cs.system.model.SysRole;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.system.model.SysUserAreaManage;
import com.icinfo.cs.system.model.SysUserRole;
import com.icinfo.cs.system.service.IDeptDutycodeRefService;
import com.icinfo.cs.system.service.ISysDepartService;
import com.icinfo.cs.system.service.ISysRoleService;
import com.icinfo.cs.system.service.ISysUserAreaManageService;
import com.icinfo.cs.system.service.ISysUserRoleService;
import com.icinfo.cs.system.service.ISysUserService;
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
@RequestMapping("/syn/system/sysuser")
public class SynSysUserController extends CSBaseController {
    private final static Logger logger = LoggerFactory.getLogger(SynSysUserController.class);

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISysUserRoleService sysUserRoleService;

    @Autowired
    private ISysRoleService sysRoleService;

    @Autowired
    private ICodeEntcatgService codeEntcatgService;

    @Autowired
    private ISysDepartService sysDepartService;

    @Autowired
    private IDeptDutycodeRefService deptDutycodeRefService;
    
    @Autowired
	private ISysUserAreaManageService sysUserAreaManageService;


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
        SysUser setUser=(SysUser)getSession().getAttribute(Constants.SESSION_SYS_USER);
        List<SysRole> data = sysRoleService.selectBySysUser(setUser);
        mav.addObject("allRoles", data);
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
        Map<String,Object> qryMap=getRequestParam(request);
        qryMap.put("userType", "2");
        request.getParams().put("userType",sysUser.getUserType());
        //区域管理员
        SysUserAreaManage sysUserAreaManage=	sysUserAreaManageService.selectSysUserAreaManageByUserIdentity(sysUser.getId(), "1");
        if(sysUserAreaManage!=null){
        	  //区域管理员标识
              request.getParams().put("isSysUserAreaManage","1"); 
              String deptCodeLike=replaceByUserLevel(sysUser.getSysDepart().getAdcode(),sysUser.getSearchRangeLevel(),"%");
              request.getParams().put("deptCodeLike",deptCodeLike);
        }else{
        	 if(!"1".equals(sysUser.getIsAdmin())&&!"2".equals(sysUser.getIsAdmin())){
                 if(DBAuthorConstants.USER_SEARCH_RANGE_SELF_DEPT.equals(sysUser.getSearchRangeLevel())){
                     request.getParams().put("deptCode",sysUser.getSysDepart().getOrgCoding());
                 }else if(!request.getParams().containsKey("dutyDeptCodes")||StringUtil.isEmpty(request.getParams().get("dutyDeptCodes").toString())){
                     //如果页面没有传入dutyDeptCodes，则以当前用户默认的职能部门为查询条件
                     String deptCodeLike=replaceByUserLevel(sysUser.getSysDepart().getAdcode(),sysUser.getSearchRangeLevel(),"%");
                     if(StringUtil.isNotEmpty(deptCodeLike))request.getParams().put("deptCodeLike",deptCodeLike);
                     String dutyCodes=deptDutycodeRefService.doSelectDutyCodesByDeptCode(sysUser.getDeptCode());
                     if(StringUtil.isNotEmpty(dutyCodes)){
                         request.getParams().put("dutyDeptCodes",dutyCodes);
                     }else{
                         request.getParams().put("dutyDeptCodes","");
                     }
                 }
             }
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
        ModelAndView view = new ModelAndView("sysuser/syn_edit");
        //所有角色信息
        SysUser setUser=(SysUser)getSession().getAttribute(Constants.SESSION_SYS_USER);
        List<SysRole> data = sysRoleService.selectBySysUser(setUser);
        view.addObject("allRoles", data);
        view.addObject("codeEntcatgs", codeEntcatgService.selectAll());//所有的企业类型（大类）
        if (StringUtils.isNotEmpty(id)) {
            //获取用户信息
           SysUser sysUser = sysUserService.selectSynUserByUId(id);
            if (sysUser != null) {
                view.addObject("sysUser", sysUser);
                SysDepart sysDepart=sysDepartService.doGetByCode(sysUser.getDeptCode());
                view.addObject("sysDepart", sysDepart);
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
//        if(StringUtil.isNotBlank(sysUser.getTelPhone())&&!sysUserService.ckTelPhone(sysUser.getTelPhone(), DBAuthorConstants.USER_TYPE_SYN)){
//            return AjaxResult.error("更新用户信息失败,手机号码已被使用!");
//        }
        SysUser setPerson=(SysUser)getSession().getAttribute(Constants.SESSION_SYS_USER);
        sysUser.setUserSetPerson(setPerson.getId());
        sysUser.setUserType(setPerson.getUserType());
        
        if(StringUtil.isBlank(sysUser.getSearchRangeLevel())){
        	if ("2".equals(setPerson.getUserType())) {
        		sysUser.setSearchRangeLevel("2");
			}else{
				sysUser.setSearchRangeLevel("1");
			}
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
     * 将协同用户“是否验证”改成否，让用户可以在协同登录的时候重新验证用户信息
     * @author ZhuDefeng
     * @date 2016-12-29
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/revalid")
    @ResponseBody
    public AjaxResult revalid(String id) throws Exception {
        if (StringUtils.isEmpty(id)) {
            return AjaxResult.error("未选择重新验证的用户!");
        }
        if (sysUserService.revalidUser(id) > 0) {
            return AjaxResult.success("操作成功.");
        }
        return AjaxResult.error("操作失败!");
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
}
