/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.server;

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
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.yr.dto.PubExcludeEntDto;
import com.icinfo.cs.yr.model.PubExcludeEnt;
import com.icinfo.cs.yr.service.IPubExcludeEntService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.security.shiro.UserProfile;

/**
 * 描述: cs_pub_excludeent 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年08月30日
 */
@Controller
@RequestMapping("/reg/server/yr/pubexcludeent/")
public class PubExcludeEntController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(PubExcludeEntController.class);

	@Autowired
	IPubExcludeEntService pubExcludeEntService;

	/**
	 * 描述：进入限制公示名单列表页面
	 * 
	 * @author baifangfang
	 * @date 2016年9月8日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list() throws Exception {
		ModelAndView mav = new ModelAndView("reg/server/yr/pubexcludeent/pubexcludeent_list");
		mav.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
		return mav;
	}

	/**
	 * 描述：限制公示名单JSON数据列表
	 *
	 * @author baifangfang
	 * @date 2016年8月30日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "list.json", "list.xml" })
	@ResponseBody
	public PageResponse<PubExcludeEntDto> listJSON(PageRequest request) throws Exception {
		List<PubExcludeEntDto> pubExcludeEntDtos = pubExcludeEntService.queryPageExcludeResult(request);
		logger.info("pubExcludeEntDtos {}", pubExcludeEntDtos);
		return new PageResponse<PubExcludeEntDto>(pubExcludeEntDtos);
	}

	/**
	 * 描述：进入未进入限制公示的企业名单页面
	 * 
	 * @author baifangfang
	 * @date 2016年9月8日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listNotExclude")
	public ModelAndView listNotExclude() throws Exception {
		ModelAndView mav = new ModelAndView("reg/server/yr/pubexcludeent/pubnotexcludeent_list");
		return mav;
	}

	/**
	 * 描述：获取未进入限制公示的企业名单列表
	 *
	 * @author baifangfang
	 * @date 2016年8月30日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "listNotExclude.json", "listNotExclude.xml" })
	@ResponseBody
	public PageResponse<PubExcludeEntDto> listNotExcludeJSON(PageRequest request) throws Exception {
		List<PubExcludeEntDto> pubExcludeEntDtos = pubExcludeEntService.queryPageNotExcludeResult(request);
		logger.info("pubExcludeEntDtos {}", pubExcludeEntDtos);
		return new PageResponse<PubExcludeEntDto>(pubExcludeEntDtos);
	}

	/**
	 * 描述：根据pubExcludeEntId查询限制公示名单(进入添加或修改页面)
	 * 
	 * @author baifangfang
	 * @date 2016年8月30日
	 * @param pubExcludeEntId
	 * @return
	 */
	@RequestMapping(value = "show", method = RequestMethod.GET)
	public ModelAndView show(@RequestParam(required = false) String priPID) {
		logger.info("priPID {}", priPID);
		ModelAndView mav = new ModelAndView("reg/server/yr/pubexcludeent/pubexcludeent_edit");

		if (!StringUtils.isEmpty(priPID)) {
			PubExcludeEnt pubExcludeEnt = pubExcludeEntService.doGetPubExcludeEntByPriPID(priPID);
			logger.info("pubExcludeEnt {}", pubExcludeEnt);
			if (pubExcludeEnt != null) {
				mav.addObject("priPID", pubExcludeEnt.getPriPID());
				mav.addObject("pubExcludeEnt", pubExcludeEnt);
			} else {
				mav.addObject("priPID", priPID);
			}
		}
		return mav;
	}

	/**
	 * 描述：添加或修改限制公示名单
	 * 
	 * @author baifangfang
	 * @date 2016年8月30日
	 * @param pubExcludeEnt
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult save(@Valid @RequestBody PubExcludeEntDto pubExcludeEnt, HttpSession session,
			BindingResult result) {
		UserProfile userProfile = (UserProfile) session.getAttribute(Constants.SESSION_SYS_USER_KEY);
		pubExcludeEnt.setSetId(userProfile.getUserId());
		pubExcludeEnt.setSetName(userProfile.getRealName());
		logger.info("pubExcludeEnt {}", pubExcludeEnt);

		if (result.hasErrors()) {
			// 参数验证错误
			AjaxResult error = AjaxResult.error("参数验证错误");
			error.addErrorInfo(result.getAllErrors());
			return error;
		}
		if (!StringUtils.isEmpty(pubExcludeEnt.getId())) {
			if (pubExcludeEntService.update(pubExcludeEnt) > 0) {
				return AjaxResult.success("更新限制公示名单成功");
			}
			return AjaxResult.error("更新限制公示名单失败!");
		}
		if (pubExcludeEntService.insert(pubExcludeEnt) > 0) {
			return AjaxResult.success("添加限制公示名单成功.");
		}
		return AjaxResult.error("添加限制公示名单失败!");
	}

	/**
	 * 描述：根据id删除限制公示名单
	 * 
	 * @author baifangfang
	 * @date 2016年9月8日
	 * @param pubExcludeEntId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public AjaxResult delete(@RequestParam Integer pubExcludeEntId) throws Exception {
		logger.info("pubExcludeEntId {}", pubExcludeEntId);
		if (StringUtils.isEmpty(pubExcludeEntId)) {
			return AjaxResult.error("未选择删除限制公示名单!");
		}
		if (pubExcludeEntService.deleteById(pubExcludeEntId) > 0) {
			return AjaxResult.success("删除限制公示名单成功.");
		}
		return AjaxResult.error("删除限制公示名单失败!");
	}
}