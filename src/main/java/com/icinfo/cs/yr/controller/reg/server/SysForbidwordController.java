/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.server;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.KeywordFilter;
import com.icinfo.cs.yr.dto.SysForbidwordDto;
import com.icinfo.cs.yr.model.SysForbidword;
import com.icinfo.cs.yr.service.ISysForbidwordService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.security.shiro.UserProfile;

/**
 * 描述: cs_sys_forbidword 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年08月30日
 */
@Controller
@RequestMapping("/reg/server/yr/sysforbidword/")
public class SysForbidwordController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(SysForbidwordController.class);

	@Autowired
	ISysForbidwordService sysForbidwordService;

	/**
	 * 描述：进入敏感词列表页面
	 * 
	 * @author baifangfang
	 * @date 2016年9月8日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list() throws Exception {
		ModelAndView mav = new ModelAndView("reg/server/yr/sysforbidword/sysforbidword_list");
		return mav;
	}

	/**
	 * 描述：敏感词JSON数据列表
	 *
	 * @author baifangfang
	 * @date 2016年8月30日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "list.json", "list.xml" })
	@ResponseBody
	public PageResponse<SysForbidword> listJSON(PageRequest request) throws Exception {
		List<SysForbidword> sysForbidwords = sysForbidwordService.queryPageResult(request);
		logger.info("sysForbidwords {}", sysForbidwords);
		return new PageResponse<SysForbidword>(sysForbidwords);
	}

	/**
	 * 描述：根据sysForbidwordId查询敏感词(进入添加或修改页面)
	 * 
	 * @author baifangfang
	 * @date 2016年8月30日
	 * @param sysForbidwordId
	 * @return
	 */
	@RequestMapping(value = "show", method = RequestMethod.GET)
	public ModelAndView show(@RequestParam(required = false) Integer sysForbidwordId, HttpSession session) {
		logger.info("sysForbidwordId {}", sysForbidwordId);
		UserProfile userProfile = (UserProfile) session.getAttribute(Constants.SESSION_SYS_USER_KEY);
		ModelAndView mav = new ModelAndView("reg/server/yr/sysforbidword/sysforbidword_edit");

		if (!StringUtils.isEmpty(sysForbidwordId)) {
			SysForbidword sysForbidword = sysForbidwordService.doGetSysForbidWordById(sysForbidwordId);
			logger.info("sysForbidword {}", sysForbidword);
			mav.addObject("sysForbidword", sysForbidword);
		} else {
			SysForbidword sysForbidword = new SysForbidword();
			sysForbidword.setSetName(userProfile.getRealName());
			sysForbidword.setSetTime(new Date());
			mav.addObject("sysForbidword", sysForbidword);
		}
		return mav;
	}

	/**
	 * 描述：禁用启用
	 * 
	 * @author baifangfang
	 * @date 2017年2月7日
	 * @param sysForbidwordId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "doAbled")
	@ResponseBody
	public AjaxResult delete(@RequestParam String isValid, @RequestParam Integer sysForbidwordId) throws Exception {
		logger.info("isValid {}", isValid);
		if (StringUtils.isEmpty(isValid)) {
			return AjaxResult.error("无效的状态!");
		} else {
			SysForbidword sysForbidword = sysForbidwordService.doGetSysForbidWordById(sysForbidwordId);
			if ("1".equals(isValid)) {
				isValid = "0";
			} else {
				isValid = "1";
			}
			sysForbidword.setIsValid(isValid);
			sysForbidwordService.update(sysForbidword);
		}
		return AjaxResult.success("敏感词禁用或者启用成功.");
	}

	/**
	 * 描述：添加或修改敏感词
	 * 
	 * @author baifangfang
	 * @date 2016年8月30日
	 * @param sysForbidword
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult save(@Valid @RequestBody SysForbidwordDto sysForbidword, HttpSession session,
			BindingResult result) {
		UserProfile userProfile = (UserProfile) session.getAttribute(Constants.SESSION_SYS_USER_KEY);
		sysForbidword.setSetId(userProfile.getUserId());
		sysForbidword.setSetName(userProfile.getRealName());
		logger.info("sysForbidword {}", sysForbidword);

		if (result.hasErrors()) {
			// 参数验证错误
			AjaxResult error = AjaxResult.error("参数验证错误");
			error.addErrorInfo(result.getAllErrors());
			return error;
		}
		if (!StringUtils.isEmpty(sysForbidword.getId())) {
			if (sysForbidwordService.update(sysForbidword) > 0) {
				// 2016-10-8 chenyl 修改敏感词匹配集合
				KeywordFilter.changeKeysMap();
				return AjaxResult.success("更新敏感词成功");
			}
			return AjaxResult.error("更新敏感词失败!");
		}
		if (sysForbidwordService.insert(sysForbidword) > 0) {
			// 2016-10-8 chenyl 修改敏感词匹配集合
			KeywordFilter.changeKeysMap();
			return AjaxResult.success("添加敏感词成功.");
		}
		return AjaxResult.error("添加敏感词失败!");
	}

	/**
	 * 描述：根据id删除敏感词
	 * 
	 * @author baifangfang
	 * @date 2016年9月8日
	 * @param sysForbidwordId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public AjaxResult delete(@RequestParam Integer sysForbidwordId) throws Exception {
		if (StringUtils.isEmpty(sysForbidwordId)) {
			return AjaxResult.error("未选择删除敏感词!");
		}
		if (sysForbidwordService.deleteById(sysForbidwordId) > 0) {
			// 2016-10-8 chenyl 修改敏感词匹配集合
			KeywordFilter.changeKeysMap();
			return AjaxResult.success("删除敏感词成功.");
		}
		return AjaxResult.error("删除敏感词失败!");
	}
}