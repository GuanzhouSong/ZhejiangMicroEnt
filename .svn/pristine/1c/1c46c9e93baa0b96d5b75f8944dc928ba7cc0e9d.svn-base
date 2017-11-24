/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.controller;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.controller.CSBaseController;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.service.ICodeSlicenoService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;

/**
 * 描述:    cs_code_sliceno 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月10日
 */
@Controller
@RequestMapping("/commom/server/sliceno/")
public class CodeSlicenoController extends CSBaseController {
	  @Autowired
	  private ICodeSlicenoService codeSlicenoService;

	/**
	 *
	 * 描述: to片区选择页面
	 * @auther ljx
	 * @date 2016年10月19日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/slicenomutiselect")
	public ModelAndView toSlicenoTreeView(String isPermissionCheck )throws Exception{
		ModelAndView view=new ModelAndView("/common/select/slicenomutiselect");
		view.addObject("isPermissionCheck", isPermissionCheck);
		return view;
	}
	/**
	 *
	 * 描述: to只选择片区页面
	 * @auther ljx
	 * @date 2016年11月2日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/slicenomutiselectnocheck")
	public ModelAndView toSlicenTreeNoCheckView(String isPermissionCheck)throws Exception{
		ModelAndView view=new ModelAndView("/common/select/slicenomutiselectnocheck");
		view.addObject("isPermissionCheck", isPermissionCheck);
		return view;
	}


	/**
	 *
	 * 描述: 片区选择json
	 * @auther ljx
	 * @date 2016年10月19日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/treeSlicenoListJSON")
	@ResponseBody
	public AjaxResult treeSlicenoListJSON(String isPermissionCheck,String content)throws Exception{
		Map param = new HashedMap();
		param.put("content", content);
		if("true".equals(isPermissionCheck)){
			String whereValBySysuser=getWhereValBySysUser("");
			param.put("regUnit_permission_limit", whereValBySysuser);//权限限制字段
			List<Map<String,Object>> data=codeSlicenoService.selectToTreeMap(param);
			return AjaxResult.success("查询成功",data);
		}
		List<Map<String,Object>> data=codeSlicenoService.selectToTreeMap(param);
		return AjaxResult.success("查询成功",data);
	}
	/**
	 * 
	 * 描述: 只选择片区
	 * @auther ljx
	 * @date 2016年11月2日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/treeSlicenoListNoCheckJSON")
	@ResponseBody
	public AjaxResult treeSlicenoListNoCheckJSON(String isPermissionCheck,String content)throws Exception{
		Map param = new HashedMap();
		param.put("content", content);
		if("true".equals(isPermissionCheck)){
			String whereValBySysuser=getWhereValBySysUser("");
			param.put("regUnit_permission_limit", whereValBySysuser);//权限限制字段
			List<Map<String,Object>> data=codeSlicenoService.selectToTreeNoCheckMap(param);
			return AjaxResult.success("查询成功",data);
		}
		List<Map<String,Object>> data=codeSlicenoService.selectToTreeNoCheckMap(param);
		return AjaxResult.success("查询成功",data);
	}

}