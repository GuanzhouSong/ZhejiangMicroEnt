package com.icinfo.cs.sment.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.system.dto.PermisionTreeNode;
import com.icinfo.cs.system.dto.SysPermisionDto;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysPermision;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.system.service.ISysPermisionService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.security.shiro.ShiroChainReloadService;
import com.icinfo.framework.tools.utils.StringUtils;

/**
 * 描述:系统权限控制器（小微监测）
 *
 * @author zhuyong
 * @date 2017-04-28
 */
@Controller
@RequestMapping(value = "/sment/server/syspermision")
public class SmentSysPermisionController extends BaseController {
	@Autowired
	private ISysPermisionService sysPermisionService;
	@Autowired
	private ShiroChainReloadService shiroChainReloadService;

	/**
	 * 跳转到岗位资源显示页面
	 * 
	 * @author ZhuDefeng
	 * @date 2017-01-24
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/role_permission_show")
	public ModelAndView role_permission_show(String roleId) throws Exception {
		ModelAndView mav = new ModelAndView("sment/system/syspermision/sment_role_permission_show");
		mav.addObject("roleId", roleId);
		return mav;
	}

	/**
	 * 进入系统权限页面
	 *
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list() throws Exception {
		return "sment/system/syspermision/sment_permision_list";
	}

	/**
	 * 返回权限JSON数据
	 *
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/list.json", "list.xml" })
	@ResponseBody
	public AjaxResult listJSON() throws Exception {
		SysUser sysUser = (SysUser) getSession().getAttribute(Constants.SESSION_SYS_USER);
		Map<String, Object> qryMap = new HashMap<>();
		qryMap.put("permisionSysType", sysUser.getUserType());
		// 查询所有权限
		List<SysPermision> permisions = sysPermisionService.selectAll(qryMap);
		// 构造ztree节点数据
		List<PermisionTreeNode> treeNodes = new ArrayList<PermisionTreeNode>();
		for (SysPermision p : permisions) {
			PermisionTreeNode treeNode = new PermisionTreeNode();
			treeNode.setId(p.getId());
			if (StringUtils.isNotEmpty(p.getParentId())) {
				treeNode.setpId(p.getParentId());
			} else {
				treeNode.setpId("0");
			}
			treeNode.setName(p.getName());
			treeNodes.add(treeNode);
		}
		return AjaxResult.success("加载权限数据成功", treeNodes);
	}

	/**
	 * 返回权限JSON数据
	 *
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/list4roleIds.json", "list.xml" })
	@ResponseBody
	public AjaxResult listJSON4roleIds(String roleIds) throws Exception {
		SysUser sysUser = (SysUser) getSession().getAttribute(Constants.SESSION_SYS_USER);
		Map<String, Object> qryMap = new HashMap<>();
		qryMap.put("permisionSysType", sysUser.getUserType());
		// 查询所有权限
		List<SysPermision> permisions = sysPermisionService.selectAll4RoleIds(roleIds);
		// 构造ztree节点数据
		List<PermisionTreeNode> treeNodes = new ArrayList<PermisionTreeNode>();
		for (SysPermision p : permisions) {
			PermisionTreeNode treeNode = new PermisionTreeNode();
			treeNode.setId(p.getId());
			if (StringUtils.isNotEmpty(p.getParentId())) {
				treeNode.setpId(p.getParentId());
			} else {
				treeNode.setpId("0");
			}
			treeNode.setName(p.getName());
			treeNodes.add(treeNode);
		}
		return AjaxResult.success("加载权限数据成功", treeNodes);
	}

	/**
	 * 显示系统权限维护
	 *
	 * @param id
	 *            编辑权限ID
	 * @param sid
	 *            权限树选中权限ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/show")
	public ModelAndView show(String id, String sid) throws Exception {
		ModelAndView view = new ModelAndView("sment/system/syspermision/sment_permision_edit");
		SysPermision sysPermision = null;
		if (StringUtils.isNotEmpty(id)) {
			// 修改是加载原权限信息
			sysPermision = sysPermisionService.selectByPrimaryKey(id);
			if (sysPermision != null) {
				view.addObject("sysPermision", sysPermision);

				if (StringUtils.isNotEmpty(sysPermision.getParentId())) {
					// 如果是修改，需要显示父权限名称
					SysPermision parent = sysPermisionService.selectByPrimaryKey(sysPermision.getParentId());
					view.addObject("parentName", parent.getName());
				}
			}
		}
		if (sysPermision == null) {
			// 新增权限处理
			if (StringUtils.isNotEmpty(sid)) {
				SysPermision _temp = sysPermisionService.selectByPrimaryKey(sid);
				if (_temp != null) {
					view.addObject("parentIdForSub", _temp.getId());
					view.addObject("parentIdForSibling", _temp.getParentId());
				}
			}
		}
		return view;
	}

	/**
	 * 获取系统权限资源
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/query")
	@ResponseBody
	public AjaxResult load(String id) throws Exception {
		if (StringUtils.isEmpty(id)) {
			return AjaxResult.error("系统权限不存在");
		}
		SysPermision sysPermision = sysPermisionService.selectByPrimaryKey(id);
		if (sysPermision != null) {
			return AjaxResult.success("加载成功", sysPermision);
		} else {
			return AjaxResult.error("系统权限不存在");
		}
	}

	/**
	 * 保存系统权限信息
	 *
	 * @param sysPermision
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult save(@Valid SysPermisionDto sysPermision, BindingResult result) throws Exception {
		if (result.hasErrors()) {
			// 参数验证错误
			AjaxResult error = AjaxResult.error("参数验证错误");
			error.addErrorInfo(result.getAllErrors());
			return error;
		}
		SysUser setPerson = (SysUser) getSession().getAttribute(Constants.SESSION_SYS_USER);
		sysPermision.setPermisionSysType(setPerson.getUserType());
		if (StringUtils.isNotEmpty(sysPermision.getId())) {
			if (sysPermisionService.update(sysPermision) > 0) {
				return AjaxResult.success("更新系统权限成功", sysPermision);
			}
			return AjaxResult.error("更新系统权限失败");
		}
		if (sysPermisionService.insert(sysPermision) > 0) {
			return AjaxResult.success("新增系统权限成功", sysPermision);
		}
		return AjaxResult.error("新增系统权限失败");
	}

	/**
	 * 删除系统权限
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(String id) throws Exception {
		if (StringUtils.isEmpty(id)) {
			return AjaxResult.error("删除的权限不存在!");
		}
		if (sysPermisionService.deleteByPrimaryKey(id) > 0) {
			return AjaxResult.success("删除系统权限成功");
		}
		return AjaxResult.error("删除的权限失败!");
	}

	@RequestMapping("/reload")
	@ResponseBody
	public AjaxResult reload() throws Exception {
		shiroChainReloadService.reloadChainDefinitions();
		return AjaxResult.success("系统权限定义刷新成功！");
	}

	/**
	 * 模糊搜索菜单
	 * 
	 * @author ZhuDefeng
	 * @date 2016-12-08
	 * @param keyWord
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/searchMenu")
	@ResponseBody
	public AjaxResult searchMenu(String keyWord) throws Exception {
		SysUserDto sysUserDto = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
		if (StringUtils.isEmpty(keyWord)) {
			return AjaxResult.error("无结果");
		}
		List<SysPermision> sysPermisionList = sysPermisionService.findPermisionByPerName(keyWord, sysUserDto);
		return AjaxResult.success("加载成功", sysPermisionList);
	}
}
