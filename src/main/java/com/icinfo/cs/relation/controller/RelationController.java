package com.icinfo.cs.relation.controller;

import java.util.List;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.relation.dto.RelationLinkDto;
import com.icinfo.cs.relation.dto.RelationNodeDto;
import com.icinfo.cs.relation.service.IRelationService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;


/**
 * 描述: 关系路径  对应的Controller类.<br>
 * 
 * @author hsh
 * @date 2017年11月03日
 */
@Controller
@RequestMapping({ "/syn/relation", "/reg/server/relation" })
public class RelationController extends CSBaseController {
	 private static final Logger logger =LoggerFactory.getLogger(RelationController.class);
	@Autowired
	private IRelationService relationService; 
	
	/**
	 * 初始化页面
	 * 
	 * @return
	 */
	@RequestMapping("/initRelationMorePath")
	public ModelAndView initRelationPath() {
		ModelAndView mv = new ModelAndView("/reg/server/relation/relation");
		return mv;
	}
	

	/**
	 * 
	 * 描述   智能比对
	 * @author 赵祥江
	 * @date 2017年11月9日 下午5:33:32 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping("/getIRelationInfo")
	@ResponseBody
	public AjaxResult getIRelationInfo(String  entNameStrs) throws Exception { 
		try {
			String qStr=relationService.getIRelationInfo(entNameStrs);
			JSONObject jsonObject = null;
			if(StringUtil.isNotBlank(qStr)) {
				jsonObject = JSONObject.fromObject(qStr);
				List<RelationNodeDto> relationNodeDtoList= JSON.parseArray(jsonObject.get("nodes")+"", RelationNodeDto.class);
				List<RelationLinkDto> relationLinkDtoList= JSON.parseArray(jsonObject.get("links")+"", RelationLinkDto.class);
				if(relationNodeDtoList.size()>0&&relationNodeDtoList.size()>0){
					jsonObject.put("nodes", relationNodeDtoList);
					jsonObject.put("links", relationLinkDtoList);
					return AjaxResult.success("获取成功！", jsonObject);
				}
			}
		} catch (Exception e) {
			logger.error("智能比对出现异常", e);
		}  
		return AjaxResult.error("未查询到数据，请检查输入是否有误！");
	}

}
