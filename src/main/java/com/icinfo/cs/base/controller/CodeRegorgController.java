/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CodeRegorg;
import com.icinfo.cs.base.service.ICodeRegorgService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.DBAuthorConstants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_code_regorg 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月12日
 */
@Controller
@RequestMapping({ "/commom/server/regorg/", "/syn/regorg/", "reg/server/regorg/" })
public class CodeRegorgController extends CSBaseController {
	@Autowired
	private ICodeRegorgService codeRegorgService;

	/**
	 *
	 * 描述: to登记机关树页面多选
	 *
	 * @auther ljx
	 * @date 2016年10月27日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("regorgmutiselect")
	public ModelAndView toOrgTreeView(String isPermissionCheck, String areaFlag) throws Exception {
		ModelAndView view = new ModelAndView("/common/select/regorgmutiselect");
		if ("1".equals(areaFlag)) {
			view.addObject("areaFlag", areaFlag);
		}
		view.addObject("isPermissionCheck", isPermissionCheck);
		return view;

	}

	@RequestMapping("/regorgmutiselectnocheck")
	public ModelAndView toOrgTreeViewNocheck(String isPermissionCheck) throws Exception {
		ModelAndView view = new ModelAndView("/common/select/regorgmutiselectnocheck");
		view.addObject("isPermissionCheck", isPermissionCheck);
		return view;
	}

	/**
	 *
	 * 描述: 单选
	 * 
	 * @auther ljx
	 * @date 2016年11月23日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/regorgsingleselectnocheck")
	public ModelAndView toOrgTreeSingView(String isPermissionCheck) throws Exception {
		ModelAndView view = new ModelAndView("/common/select/regorgsingleselectnocheck");
		view.addObject("isPermissionCheck", isPermissionCheck);
		return view;

	}

	/**
	 *
	 * 描述: 登记机关树状结构json数据
	 *
	 * @auther ljx
	 * @date 2016年10月18日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/treeListJSON")
	@ResponseBody
	public AjaxResult treeListJSON(String isPermissionCheck, String areaFlag,String content) throws Exception {
		SysUserDto sysUser=(SysUserDto)getSession().getAttribute(Constants.SESSION_SYS_USER);
		String userVest=sysUser.getUserVest(sysUser);
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("content", content);
		if ("1".equals(areaFlag)) {
			List<Map<String, Object>> data = codeRegorgService.selectToTreeMapHZ(param);
			return AjaxResult.success("查询成功", data);
		}
		if ("true".equals(isPermissionCheck)) {
			//查询权限
			String searchRangeLevel=sysUser.getSearchRangeLevel();
			//分局
			if(DBAuthorConstants.USER_LEVEL_COUNTRY.equals(userVest)&&DBAuthorConstants.USER_LEVEL_COUNTRY.equals(searchRangeLevel)&&DBAuthorConstants.USER_LEVEL_UNIT.equals(sysUser.getUserType())){
				param.put("isBranch", "1");// 分局标识 分局且查询权限是本局时登记机关树显示市级登记机关
			} 
			String whereValBySysuser = getWhereValBySysUser("");
			param.put("regUnit_permission_limit", StringUtil.substring(whereValBySysuser, 0, 6));// 权限限制字段
			//查询带权限的登记机关部分数据
			List<Map<String, Object>> data = codeRegorgService.selectToTreeMap(param);
			if (StringUtil.isBlank(whereValBySysuser)) {
				return AjaxResult.success("查询成功", data);
			}
			//查询所有省局部分登记机关数据
			List<Map<String, Object>> dataAll = codeRegorgService.selectProv("false",content);
			if(getCodeByUserType(sysUser).length()>4 && "3300".equals(getCodeByUserType(sysUser).substring(0, 4))){//省局用户且不为省级
				return AjaxResult.success("查询成功",dataAll);
			}else{
				dataAll.addAll(data);
				return AjaxResult.success("查询成功",dataAll);
			}
		}
		List<Map<String, Object>> data = codeRegorgService.selectToTreeMap(param);
		return AjaxResult.success("查询成功", data);
	}

	/**
	 *
	 * 描述: 只选择最后一级
	 * 
	 * @auther ljx
	 * @date 2016年11月2日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/treeListNoCheckJSON")
	@ResponseBody
	public AjaxResult treeListNoCkeckJSON(String isPermissionCheck,String content) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("content", content);
		if ("true".equals(isPermissionCheck)) {
			String whereValBySysuser = getWhereValBySysUser("");
			param.put("regUnit_permission_limit", whereValBySysuser);// 权限限制字段
			List<Map<String, Object>> data = codeRegorgService.selectToTreeNocheckMap(param);
			if (StringUtil.isBlank(whereValBySysuser)) {
				return AjaxResult.success("查询成功", data);
			}
			//查询所有省局部分登记机关数据
			List<Map<String, Object>> dataAll = codeRegorgService.selectProv("false",content);
			SysUserDto sysUser=(SysUserDto)getSession().getAttribute(Constants.SESSION_SYS_USER);
			if(getCodeByUserType(sysUser).length()>4 && "3300".equals(getCodeByUserType(sysUser).substring(0, 4))){//省局用户且不为省级
				return AjaxResult.success("查询成功",dataAll);
			}else{
				dataAll.addAll(data);
				return AjaxResult.success("查询成功",dataAll);
			}
		}
		List<Map<String, Object>> data = codeRegorgService.selectToTreeNocheckMap(param);
		return AjaxResult.success("查询成功", data);
	}

	/**
	 *
	 * 描述: 进入登记机关联络员维护查询页面
	 * 
	 * @auther gaojinling
	 * @date 2016年11月15日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/regorgList")
	public ModelAndView regorglist(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/syn/system/coderegorg/regorg_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());
		return view;
	}

	/**
	 *
	 * 描述: 登记机关联络员维护（分页查询）
	 * 
	 * @auther gaojinling
	 * @date 2016年11月15日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/regorgList.json", "list.xml" })
	@ResponseBody
	public PageResponse<CodeRegorg> regorgListJSON(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request, "t.Code", "t.Code");
		List<CodeRegorg> data = codeRegorgService.selectRegOrgCodeListJSON(request);
		return new PageResponse<CodeRegorg>(data);
	}

	/**
	 *
	 * 描述: 登记机关联络员维护
	 * 
	 * @auther gaojinling
	 * @date 2016年11月15日
	 * @param regOrgCode
	 * @param type
	 *            操作类型 1 修改 2 查看
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/regorgView")
	public ModelAndView regorg(String regOrgCode, String type, HttpSession session) throws Exception {
		ModelAndView view;
		if (type.endsWith("1")) {
			view = new ModelAndView("/syn/system/coderegorg/regorg_edit");
		} else {
			view = new ModelAndView("/syn/system/coderegorg/regorg_view");
		}
		CodeRegorg codeRegorg = codeRegorgService.selectRegOrgByCode(regOrgCode);
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());
		view.addObject("codeRegorg", codeRegorg);
		view.addObject("type", type);
		return view;
	}

	/**
	 *
	 * 描述: 登记机关联络员维护
	 * 
	 * @auther gaojinling
	 * @date 2016年11月15日
	 * @param codeRegorg
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doUpdate", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult updateCodeRegorg(@Valid @RequestBody CodeRegorg codeRegorg) throws Exception {
		if (codeRegorg != null && StringUtil.isNotEmpty(codeRegorg.getCode())) {
			if (codeRegorgService.update(codeRegorg) > 0) {
				return AjaxResult.success("修改成功！");
			}
		}
		return AjaxResult.error("修改失败！");
	}

}