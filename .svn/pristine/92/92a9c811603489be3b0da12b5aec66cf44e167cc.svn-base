/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.ext.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CodeChgType;
import com.icinfo.cs.base.service.ICodeChgTypeService;
import com.icinfo.cs.ext.dto.MidAltitemDto;
import com.icinfo.cs.ext.service.IMidAltitemService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_mid_altitem 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月20日
 */
@Controller
@RequestMapping("/midaltitem/")
public class MidAltitemController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(MidAltitemController.class);

	@Autowired
	IMidAltitemService midAltitemService;

	@Autowired
	ICodeChgTypeService codeChgTypeService;

	/**
	 * 描述：根据priPID查询变更信息JSON数据列表
	 *
	 * @author baifangfang
	 * @date 2016年10月20日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "list.json", "list.xml" })
	@ResponseBody
	public PageResponse<MidAltitemDto> listJSON(PageRequest request) throws Exception {
		String entTypeCatg = request.getParams().get("entTypeCatg").toString();
		List<MidAltitemDto> midAltitemDtos = midAltitemService.queryPageResult(request);
		for (MidAltitemDto midAltitemDto : midAltitemDtos) {
			String altItem = midAltitemDto.getAltItem();// 变更事项编码
			// 查询编码表
			List<CodeChgType> codeChgTypeList = codeChgTypeService.selectCodeChgTypeListByAltItem(altItem);
			for (CodeChgType codeChgType : codeChgTypeList) {
				String entTypeCatgs = codeChgType.getEntTypeCatgs();
				String[] entTypeCatgArr = entTypeCatgs.split(",");
				for (int i = 0; i < entTypeCatgArr.length; i++) {
					if (entTypeCatgArr[i].equals(entTypeCatg)) {
						midAltitemDto.setAltContent(codeChgType.getContent());
						break;
					}
				}
			}
		}
		logger.info("midAltitemDtos {}", midAltitemDtos);
		return new PageResponse<MidAltitemDto>(midAltitemDtos);
	}

	/**
	 * 进入变更历史页面
	 * 
	 * @author zhuyong
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEnEntAltItemHis/{priPID}")
	@ResponseBody
	public ModelAndView doEnEntAltItemHis(@PathVariable("priPID") String priPID) throws Exception {
		ModelAndView mav = new ModelAndView("/syn/system/search/appsearch/appchangehis");
		mav.addObject("priPID", priPID);
		return mav;
	}
}
