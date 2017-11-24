/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.opanomaly.controller.pub.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.opanomaly.dto.PubOpanoMalyDto;
import com.icinfo.cs.opanomaly.service.IPubOpanoMalyService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_pub_opanomaly 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月19日
 */
@Controller("ClientPubOpanoMalyController")
@RequestMapping("/pub/client/pubopanomaly")
public class PubOpanoMalyController extends BaseController{
	
	@Autowired
	private IPubOpanoMalyService pubOpanoMalyService;
	
	/** 
	 * 描述: 纳入/移出经营异常名录信息（公示单个企业展示）
	 * @auther ZhouYan
	 * @date 2016年11月3日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/list/list.json",method= RequestMethod.POST)
    @ResponseBody
    public PageResponse<PubOpanoMalyDto> listJSON(PageRequest request) throws Exception {
		List<PubOpanoMalyDto> data = pubOpanoMalyService.queryPubOpanoMalyListForPub(request);
        return new PageResponse<PubOpanoMalyDto>(data);
    }
	
	
	public IPubOpanoMalyService getPubOpanoMalyService() {
		return pubOpanoMalyService;
	}

	public void setPubOpanoMalyService(IPubOpanoMalyService pubOpanoMalyService) {
		this.pubOpanoMalyService = pubOpanoMalyService;
	}
	
}
