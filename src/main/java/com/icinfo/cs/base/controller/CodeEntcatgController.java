/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CodeEntcatg;
import com.icinfo.cs.base.service.ICodeEntcatgService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;

/**
 * 描述: cs_code_entcatg 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月10日
 */
@Controller
@RequestMapping("/commom/server/entcatg/")
public class CodeEntcatgController extends BaseController {
	@Autowired
	private ICodeEntcatgService codeEntcatgService;

	private static final String comType[] = { "50", "16", "17" };
	private static final String perType = "50";
	private static final String farmType[] = { "16", "17" };

	/**
	 * 
	 * 描述: to企业类型选择页面
	 * 
	 * @auther ljx
	 * @date 2016年10月19日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/entcatgmutiselect")
	public ModelAndView toEntcatgTreeView() throws Exception {
		ModelAndView view = new ModelAndView("/common/select/entcatgmutiselect");
		return view;
	}

	@RequestMapping("/entcatgmutiselectnocheck")
	public ModelAndView toEntcatgTreeNocheckView() throws Exception {
		ModelAndView view = new ModelAndView("/common/select/entcatgmutiselectnockeck");
		return view;

	}

	/**
	 * 描述：企业综合查询企业类型json多选
	 * 
	 * @auther baifangfang
	 * @date 2017年1月4日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/treeEntcatgListJSONCom")
	@ResponseBody
	public AjaxResult treeEntcatgListJSONCom(@RequestParam(required = false) String type,
			@RequestParam(required = false) String indType,HttpSession session,@RequestParam(required = false) String content) throws Exception {
		if(StringUtils.isNotBlank(indType))
			return AjaxResult.success("查询成功",codeEntcatgService.selectToTreeMapByIndType(indType));
		
		if (StringUtil.isNotBlank(type)) 
			return AjaxResult.success("查询成功",codeEntcatgService.selectToTreeMapByType(type,content));

		Map<String,Object> qryMap = new HashMap<String,Object>();
		SysUser sysUser = (SysUser)session.getAttribute(Constants.SESSION_SYS_USER);
		qryMap.put("content",content);
		if(sysUser != null && StringUtils.isNotBlank(sysUser.getUserType())){
			qryMap.put("userType", sysUser.getUserType());
		}
		return AjaxResult.success("查询成功", codeEntcatgService.selectToTreeMapLimit(qryMap));
	}

	/**
	 * 
	 * 描述: 企业综合查询企业类型选择页面
	 * 
	 * @auther baifangfang
	 * @date 2017年1月4日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/entcatgmutiselectCom")
	public ModelAndView toEntcatgTreeViewCom(@RequestParam(required = false) String type,
			@RequestParam(required = false) String indType) throws Exception {
		ModelAndView view = new ModelAndView("/common/select/entcatgmutiselectCom");
		view.addObject("type", type);
		view.addObject("indType", indType);
		return view;
	}

	/**
	 * 企业类型json多选 描述: TODO
	 * 
	 * @auther ljx
	 * @date 2016年10月19日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/treeEntcatgListJSON")
	@ResponseBody
	public AjaxResult treeEntcatgListJSON(String content) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("content", content);
		List<Map<String, Object>> data = codeEntcatgService.selectToTreeMap(map);
		return AjaxResult.success("查询成功", data);
	}

	/**
	 * 
	 * 描述: 抽查对象根据企业类型查企业大类
	 * 
	 * @auther ljx
	 * @date 2016年11月8日
	 * @param codes
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/selectEntcatgByCation")
	@ResponseBody
	public AjaxResult selectEntcatgByCation(@RequestBody String[] type) throws Exception {
		List<CodeEntcatg> list = new ArrayList<CodeEntcatg>();
		List<CodeEntcatg> perlist = new ArrayList<CodeEntcatg>();
		List<CodeEntcatg> farmlist = new ArrayList<CodeEntcatg>();
		List<CodeEntcatg> comlist = new ArrayList<CodeEntcatg>();
		for (String str : type) {
			List<String> caList = new ArrayList<String>();
			if (str.equals("perType")) {
				caList.add(perType);
				perlist = codeEntcatgService.selectByCation(caList);
				list.addAll(perlist);
			}
			if (str.equals("farmType")) {
				caList.addAll(Arrays.asList(farmType));
				farmlist = codeEntcatgService.selectByCation(caList);
				list.addAll(farmlist);
			}
			if (str.equals("comType")) {
				List<String> not = new ArrayList<String>(Arrays.asList(comType));
				comlist = codeEntcatgService.selectByCationNotIn(not);
				list.addAll(comlist);
			}
		}
		return AjaxResult.success("查询成功", list);

	}

	/**
	 * 
	 * 描述: 多选只选择小类
	 * 
	 * @auther ljx
	 * @date 2016年11月2日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/treeEntcatgNocheckListJSON")
	@ResponseBody
	public AjaxResult treeEntcatgNocheckListJSON(String content) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("content", content);
		List<Map<String, Object>> data = codeEntcatgService.selectToTreeMapNoCheck(map);
		return AjaxResult.success("查询成功", data);

	}

}