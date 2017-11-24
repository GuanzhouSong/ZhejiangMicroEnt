/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.pub;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.CardUtil;
import com.icinfo.cs.yr.dto.UpdateInfoDto;
import com.icinfo.cs.yr.service.IBaseInfoService;
import com.icinfo.cs.yr.service.IUpdateInfoService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_updateinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月19日
 */
@Controller
@RequestMapping("pub/updateinfo")
public class UpdateInfoController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(UpdateInfoController.class);

	@Autowired
	private IUpdateInfoService updateInfoService;
	
	@Autowired
	private IBaseInfoService baseInfoService;

	/**
	 * 描述：获取列表Json数据
	 * 
	 * @author yujingwei
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list.json")
	@ResponseBody
	public PageResponse<UpdateInfoDto> listJSON(PageRequest request) throws Exception {
		List<UpdateInfoDto> data = updateInfoService.queryPage(request);
		logger.info("data {}", data);
		return new PageResponse<UpdateInfoDto>(data);
	}
	
	/**
	 * 
	 * 描述: 公示侧企业修改信息查询（过滤敏感词）
	 * @auther chenyl
	 * @date 2016年10月10日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/publist.json")
	@ResponseBody
	public PageResponse<UpdateInfoDto> listJSONForPub(PageRequest request) throws Exception {
		List<UpdateInfoDto> data = updateInfoService.queryPageForPub(request);
		for (int i = 0; i < data.size(); i++) {
			String altBe = data.get(i).getAltBe();
			altBe = CardUtil.getHide(altBe);
			data.get(i).setAltBe(altBe);

			String altAf = data.get(i).getAltAf();
			altAf = CardUtil.getHide(altAf);
			data.get(i).setAltAf(altAf);
		}
		logger.info("data {}", data);
		Map<String, Object> searchMap = request.getParams();
		if(searchMap != null && searchMap.containsKey(Constants.CS_ANCHEID)){
			String anCheID = (String) searchMap.get(Constants.CS_ANCHEID);
			String ifFilter = baseInfoService.queryAnduitStateInfoByAncheID(anCheID);

			if ("0".equals(ifFilter)) {
				for (UpdateInfoDto updateInfo : data) {
					if (updateInfo != null) {
						updateInfo.doFilterForbidword();
					}
				}
			}	
		}
		return new PageResponse<UpdateInfoDto>(data);
	}
}