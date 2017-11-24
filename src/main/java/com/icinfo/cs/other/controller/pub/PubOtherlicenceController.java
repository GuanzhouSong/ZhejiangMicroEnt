/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.controller.pub;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.ext.dto.MidInvDto;
import com.icinfo.cs.other.dto.PubOtherlicenceDto;
import com.icinfo.cs.other.model.PubServerModrecord;
import com.icinfo.cs.other.service.IPubOtherlicenceService;
import com.icinfo.cs.other.service.IPubServerModrecordService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_pub_otherlicence 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月18日
 */
@Controller("ClientPubOtherlicenceController")
@RequestMapping("/pub/pubohterlicence/")
public class PubOtherlicenceController extends BaseController {

	@Autowired
	private IPubOtherlicenceService pubOtherlicenceService;
	
	@Autowired
	private IPubServerModrecordService pubServerModrecordService;

	@RequestMapping({ "/list_data" })
	@ResponseBody
	public PageResponse<PubOtherlicenceDto> list_data(PageRequest request) throws Exception {
		List<PubOtherlicenceDto> data = pubOtherlicenceService.select_queryPage(request);// 执行参数条件查询
		for(PubOtherlicenceDto pubOtherlicenceDto : data) {
			//变更信息
			List<PubServerModrecord> pubOtherlicenceModList = pubServerModrecordService.doGetAlterInfoList(pubOtherlicenceDto.getLicID());
			pubOtherlicenceDto.setPubOtherlicenceModList(pubOtherlicenceModList);
		}
		return new PageResponse<PubOtherlicenceDto>(data);
	}

}