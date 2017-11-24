package com.icinfo.cs.concern.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.concern.dto.CsConcernActivityDto;
import com.icinfo.cs.concern.model.CsConcernActivity;
import com.icinfo.cs.concern.service.CsConcernActivityService;
import com.icinfo.cs.risk.service.ICsWarnMarkService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.tools.utils.StringUtils;

/**
 * 关注服务活动记录控制器
 * @author caoxu
 *
 */
@Controller
@RequestMapping("/syn/con/csconcernactivity")
public class CsConcernActivityController extends BaseController {
	
	@Autowired
	private CsConcernActivityService csConcernActivityService;
	
	@Autowired
	private ICsWarnMarkService csWarnMarkService; 
	
	@Autowired
	private  HttpServletRequest request;
	
	/**
	 * 跳转到活动列表页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/list"})
	public String list() throws Exception {
		return "/syn/system/concern/activity/con_activity_list";
	}
	
	/**
     * 惩戒规则JSON数据列表（带分页）
     *
     * @param request
     * @return
     * @throws Exception
     */
	@RequestMapping({ "/list.json", "list.xml" })
	@ResponseBody
	public PageResponse<CsConcernActivity> listJSON(PageRequest request) throws Exception {
		Map<String, Object> parms = request.getParams();
		if (parms == null) {
			parms = new HashMap<String, Object>();
		}
		List<CsConcernActivity> list = this.csConcernActivityService.queryPage(request, parms);
		return new PageResponse<CsConcernActivity>(list);
	}
	
	/**
	 * 跳转添加/编辑页
	 * @param id
	 * @param map
	 * @param deal (0编辑页，1查看页）
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/show" })
	public String show(String id, Integer deal, ModelMap map) throws Exception {
		// 获取当前用户
		SysUserDto currUser = (SysUserDto) request.getSession().getAttribute(Constants.SESSION_SYS_USER);
		map.put("user", currUser);
		if (StringUtils.isNotEmpty(id)) {
			CsConcernActivity csConcernActivity = this.csConcernActivityService.getById(id);
			map.addAttribute("activity", csConcernActivity);
			if (deal == 0) {
				return "/syn/system/concern/activity/con_activity_edit";
			} else if (deal == 1) {
				return "/syn/system/concern/activity/con_activity_view";
			} else if (deal == 2) {
				return "/syn/system/concern/activity/con_activity_print";
			}
		}
		return "/syn/system/concern/activity/con_activity_add";
	}
	
	/**
	 * 选择标识
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectMark")
	public ModelAndView selectMark() throws Exception {
		ModelAndView mav = new ModelAndView("/syn/system/concern/activity/con_activity_selectmark");
		SysUserDto sysUser = (SysUserDto) request.getSession().getAttribute(Constants.SESSION_SYS_USER);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("markSetDeptCode", sysUser.getDeptCode());
		map.put("markFunc", "gz");// 关注标识
		map.put("markState", "1");// 有效标识

		mav.addObject("markList", csWarnMarkService.selectCsWarnMarkList(map));
		return mav;
	}
	
	/**
	 * 保存活动单
	 * @param csConcernActivityDto
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
	public AjaxResult save(@Valid CsConcernActivityDto csConcernActivityDto, BindingResult result) throws Exception {
		if (result.hasErrors() || (csConcernActivityDto.getDateBegin() == null
				&& csConcernActivityDto.getDateEnd() == null && csConcernActivityDto.getIsLong() == null)) {
			// 参数验证错误
			AjaxResult error = AjaxResult.error("请检查 红色* 的内容有无遗漏");
			error.addErrorInfo(result.getAllErrors());
			return error;
		}
		SysUserDto sysUser = (SysUserDto) request.getSession().getAttribute(Constants.SESSION_SYS_USER);
		csConcernActivityDto.setOperName(sysUser.getRealName());
		csConcernActivityDto.setOperDeptName(sysUser.getDept());
		csConcernActivityDto.setOperDeptCode(sysUser.getDeptCode());
		if (this.csConcernActivityService.insert(csConcernActivityDto) > 0) {
			return AjaxResult.success("保存活动单成功");
		} else
			return AjaxResult.error("保存活动单失败！");
	}
	
	/**
	 * 修改活动单
	 * @param csConcernActivityDto
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
	public AjaxResult update(@Valid CsConcernActivityDto csConcernActivityDto, BindingResult result) throws Exception {
		if (result.hasErrors() || (csConcernActivityDto.getDateBegin() == null
				&& csConcernActivityDto.getDateEnd() == null && csConcernActivityDto.getIsLong() == null)) {
			// 参数验证错误
			AjaxResult error = AjaxResult.error("请检查 红色* 的内容有无遗漏");
			error.addErrorInfo(result.getAllErrors());
			return error;
		}
		if (this.csConcernActivityService.update(csConcernActivityDto) > 0) {
			return AjaxResult.success("修改活动单成功");
		} else
			return AjaxResult.error("修改活动单失败！");
	}

}
