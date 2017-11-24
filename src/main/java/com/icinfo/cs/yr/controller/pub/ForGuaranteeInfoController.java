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
import com.icinfo.cs.yr.dto.ForGuaranteeInfoDto;
import com.icinfo.cs.yr.model.ForGuaranteeInfo;
import com.icinfo.cs.yr.service.IBaseInfoService;
import com.icinfo.cs.yr.service.IForGuaranteeInfoService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_forguaranteeinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
@Controller
@RequestMapping("pub/GuaranteeInfo")
public class ForGuaranteeInfoController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(ForGuaranteeInfoController.class);
	
	@Autowired
	private IForGuaranteeInfoService forGuaranteeInfoService;
	
	@Autowired
	private IBaseInfoService baseInfoService;
	/**
     * 描述：获取列表Json数据
     * @author yujingwei
     * @return
     * @throws Exception
     */
	@RequestMapping("/list.json")
	@ResponseBody
    public PageResponse<ForGuaranteeInfo> listJSON(PageRequest request) throws Exception {
		List<ForGuaranteeInfo> data = forGuaranteeInfoService.queryPage(request);
		logger.info("data {}", data);
        return new PageResponse<ForGuaranteeInfo>(data);
    }
	
	/**
	 * 
	 * 描述: 公示侧获取对外担保信息（过滤敏感词）
	 * @auther chenyl
	 * @date 2016年10月8日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/publist.json")
	@ResponseBody
	public PageResponse<ForGuaranteeInfoDto> listJSONForPub(PageRequest request) throws Exception {
		List<ForGuaranteeInfoDto> data = forGuaranteeInfoService.queryPageForPub(request);
		logger.info("data {}", data);
		Map<String, Object> searchMap=  request.getParams();
		if(searchMap != null && searchMap.containsKey(Constants.CS_ANCHEID)){
			String anCheID = (String) searchMap.get(Constants.CS_ANCHEID);
			String ifFilter = baseInfoService.queryAnduitStateInfoByAncheID(anCheID);

			if ("0".equals(ifFilter)) {
				for (ForGuaranteeInfoDto forGuaranteeInfo : data) {
					if (forGuaranteeInfo != null) {
						forGuaranteeInfo.doFilterForbidword();
					}
				}
			}	
		}
		return new PageResponse<ForGuaranteeInfoDto>(data);
	}
}