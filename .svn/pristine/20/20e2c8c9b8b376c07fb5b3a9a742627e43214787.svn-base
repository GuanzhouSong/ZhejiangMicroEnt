package com.icinfo.cs.sment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.DBAuthorConstants;
import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysDepart;
import com.icinfo.cs.system.model.SysRole;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.system.model.SysUserRole;
import com.icinfo.cs.system.service.ISysDepartService;
import com.icinfo.cs.system.service.ISysRoleService;
import com.icinfo.cs.system.service.ISysUserRoleService;
import com.icinfo.cs.system.service.ISysUserService;
import com.icinfo.cs.yr.model.DepartMent;
import com.icinfo.cs.yr.service.IDepartMentService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.tools.utils.StringUtils;

/**
 * 描述: 系统用户管理控制器.<br>
 *
 * @author xiajunwei
 * @date 2016年04月20日
 */
@Controller
@RequestMapping("/sment/server/sysuser")
public class SmentSysUserController extends CSBaseController {

	@Autowired
	private ISysUserService sysUserService;

	@Autowired
	private ISysUserRoleService sysUserRoleService;

	@Autowired
	private ISysRoleService sysRoleService;

	@Autowired
    private IDepartMentService departMentService;

	@RequestMapping("/synerror")
	public ModelAndView doSynError() throws Exception {
		ModelAndView view = new ModelAndView("/syn/exception/error");
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
		return new ModelAndView("sment/system/sysuser/sment_sysuser_list");
	}


	/**
	 * 系统数据JSON数据列表
	 *
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/list.json", "list.xml" })
	@ResponseBody
	public PageResponse<SysUserDto> listJSON(PageRequest request) throws Exception {
		SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
		if (request.getParams() == null) {
			request.setParams(new HashMap<String, Object>());
		}
		request.getParams().put("userType", sysUser.getUserType());
		if (!"1".equals(sysUser.getIsAdmin()) && !"2".equals(sysUser.getIsAdmin())) {
			String deptCodeLike = replaceByUserLevel(sysUser.getDepartMent().getDeptCode(), 
					sysUser.getSearchRangeLevel(), "%");
			request.getParams().put("deptCodeLike", deptCodeLike);
		}
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
		ModelAndView view = new ModelAndView("/sment/system/sysuser/sment_sysuser_edit");
		// 所有角色信息
		SysUser setUser = (SysUser) getSession().getAttribute(Constants.SESSION_SYS_USER);
		List<SysRole> data = sysRoleService.selectBySysUser(setUser);
		view.addObject("allRoles", data);
		if (StringUtils.isNotEmpty(id)) {
			// 获取用户信息
			SysUser sysUser = sysUserService.selectSynUserByUId(id);
			if (sysUser != null) {
				view.addObject("sysUser", sysUser);
                if(StringUtil.isNotBlank(sysUser.getDeptCode())){
                    DepartMent departMent=departMentService.selectOne(sysUser.getDeptCode());
                    view.addObject("dept", departMent);
                }
				// 获取用户角色信息
				List<SysUserRole> rolesList = sysUserRoleService.selectByUserId(id);

				Map<String, SysUserRole> rolesMap = new HashMap<String, SysUserRole>();
				for (SysUserRole userRole : rolesList) {
					rolesMap.put(userRole.getRoleId(), userRole);
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
			// 参数验证错误
			AjaxResult error = AjaxResult.error("参数验证错误");
			error.addErrorInfo(result.getAllErrors());
			return error;
		}
		SysUser setPerson = (SysUser) getSession().getAttribute(Constants.SESSION_SYS_USER);
		sysUser.setUserSetPerson(setPerson.getId());
		sysUser.setUserType(DBAuthorConstants.USER_TYPE_SMENT);
		if (StringUtil.isBlank(sysUser.getSearchRangeLevel())) {
			sysUser.setSearchRangeLevel("1");
		}
		//密码加密
		if(StringUtil.isNotBlank(sysUser.getPassword())){
			sysUser.setUserPasswordKey(AESEUtil.encodeCorpid(sysUser.getPassword()));
		}
		String[] roleArr = sysUser.getRoles().split(",");
		if (StringUtils.isNotEmpty(sysUser.getId())) {
			if (sysUserService.update(sysUser, roleArr) > 0) {
				return AjaxResult.success("更新用户信息成功");
			}
			return AjaxResult.error("更新用户信息失败!");
		}
		
		try {
			if (sysUserService.insert(sysUser, roleArr) > 0) 
				return AjaxResult.success("创建新用户成功!");
		} catch (BusinessException e) {
			return AjaxResult.error(e.getMessage()+"");
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
		if (sysUserService.disOrEnAbleUser(id, "0") > 0) {
			return AjaxResult.success("禁用用户成功!");
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
		if (sysUserService.disOrEnAbleUser(id, "1") > 0) {
			return AjaxResult.success("启用用户成功!");
		}
		return AjaxResult.error("启用用户失败!");
	}

	/**
     * 描述：修改密码
     * @author zhuyong
     * @date 2017-05-04
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/editPsw", method = RequestMethod.GET)
    public String editPsw()throws Exception{
        return "sment/system/sysuser/sment_sysuser_psw_edit";
    }

    /**
     * 描述：检查原密码
     * 
     * @author zhuyong
     * @date 2017-05-04
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
     * 
     * @author zhuyong
     * @date 2017-05-04
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
